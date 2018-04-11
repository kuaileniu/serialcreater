package cn.zhsit.services.impl;

import cn.zhsit.annotations.Disable;
import cn.zhsit.daos.OrgProductDao;
import cn.zhsit.daos.OrgProductMapper;
import cn.zhsit.daos.ZhsLockDao;
import cn.zhsit.enums.OrgEnum;
import cn.zhsit.enums.ProductEnum;
import cn.zhsit.enums.RecordStatusEnum;
import cn.zhsit.enums.ZhsLockEnum;
import cn.zhsit.helpers.KeyHelper;
import cn.zhsit.helpers.OrgProductEnumHelper;
import cn.zhsit.helpers.RedisHelper;
import cn.zhsit.models.po.OrgProduct;
import cn.zhsit.models.po.OrgProductExample;
import cn.zhsit.models.po.ZhsLockPO;
import cn.zhsit.services.OrgProductService;
import cn.zhsit.utils.ZhsDateUtil;
import cn.zhsit.utils.ZhsJsonUtil;
import cn.zhsit.utils.ZhsThreadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class OrgProductServiceImpl implements OrgProductService {
    private final Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    private OrgProductDao orgProductDao;
    @Autowired
    private OrgProductMapper orgProductMapper;
    @Autowired
    private RedisHelper redisHelper;
    @Autowired
    private ZhsLockDao zhsLockDao;
    @Autowired
    protected KeyHelper keyHelper;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


    @Override
    public int transOrgProduct2RDB() {
        ZhsLockPO record = new ZhsLockPO();
        record.setSeconds(60);
        record.setId(ZhsLockEnum.OrgProductUpdateSourceIdLock.tableId());
        record.setRecordOwner(ZhsThreadUtil.currentThreadId());
        int lockNum = zhsLockDao.lock(record);
        if (lockNum != 1) {
            System.out.println("未获得OrgProductUpdateSourceIdLock");
            return 0;
        }
//        List<String> list = redisHelper.rightPop(keyHelper.getOrgProductHistoryListKey(), 500);  //经测试，右进右出有bug
        List<String> list = redisHelper.leftPop(keyHelper.getOrgProductHistoryListKey(), 500);
        if (list.size() < 1) {
            return 0;
        }
        List<OrgProduct> opList = null;
        boolean arrayListExists = false;
        for (String orgProductJson : list) {
            if (!arrayListExists) {
                arrayListExists = true;
                opList = new ArrayList<>();
            }
            OrgProduct orgProduct = ZhsJsonUtil.fromJson(orgProductJson, OrgProduct.class);
            opList.add(orgProduct);
        }
        List<OrgProduct> toDBList = getMaxSourceIdWithSameOrgProduct(opList);
        if (toDBList != null) {
            for (OrgProduct toDB : toDBList) {
                orgProductDao.updateLastSourceId(toDB);
            }
        }
        return list.size();
    }

    public List<OrgProduct> getMaxSourceIdWithSameOrgProduct(List<OrgProduct> redisList) {
        List<OrgProduct> toDBList = new ArrayList<>(1);
        for (int i = redisList.size() - 1; i >= 0; i--) {
            OrgProduct redisOP = redisList.get(i);
            boolean existSameOPId = false;
            for (int m = 0; m < toDBList.size(); m++) {
                OrgProduct toDB = toDBList.get(m);
                if (redisOP.getProductId().intValue() == toDB.getProductId().intValue() && redisOP.getOrgId().intValue() == toDB.getOrgId().intValue()) {
                    existSameOPId = true;
                    if (redisOP.getLastSourceId().intValue() > redisOP.getLastSourceId().intValue()) {
                        toDBList.set(m, redisOP);
                    }
                    break;
                }
            }
            if (!existSameOPId) {
                toDBList.add(redisOP);
            }
        }
        return toDBList;
    }

    @Override
    public int addOrgProductRDBIfLessN(final int n) {
        ZhsLockPO zhsLockPO = new ZhsLockPO();
        zhsLockPO.setSeconds(60);
        zhsLockPO.setRecordOwner(ZhsThreadUtil.currentThreadId());
        zhsLockPO.setId(ZhsLockEnum.OrgProductInsertLock.tableId());
        int lockNum = zhsLockDao.lock(zhsLockPO);
        if (lockNum == 0) {
            System.out.println("------------------未获得锁" + dateFormat.format(Calendar.getInstance().getTime()));
            return 0;
        }
        int count = 0;
       List<OrgEnum> orgs = OrgProductEnumHelper.allEnableOrgEnum(Disable.class);
        for (OrgEnum org : orgs) {
            List<ProductEnum> products= OrgProductEnumHelper.allProductEnumByOrg(org,Disable.class);
            for (ProductEnum product : products) {
                OrgProduct op = new OrgProduct();
                op.setOrgCode(org.getZzlb());
                op.setProductCode(product.getCplb());
                List<OrgProduct> list = orgProductDao.selectMinOrgProductN(op, n);

                boolean addRecord = checkAddRecord(org, product, list, n);
                if (addRecord) {
                    List<OrgProduct> addOrgProductList = createAddRecord(org, product, list, n);
                    count += save(addOrgProductList);
                }
            }
        }
        return count;
    }

    private int save(List<OrgProduct> addOrgProductList) {
        int count = 0;
        for (OrgProduct op : addOrgProductList) {
            orgProductMapper.insert(op);
            count++;
        }
        return count;
    }

    private List<OrgProduct> createAddRecord(OrgEnum org, ProductEnum product, List<OrgProduct> list, final int n) {
        if (list.size() == 0) {
            return fromZero(org, product, n);
        }
        return fromBase(org, product, list, n);
    }

    private List<OrgProduct> fromBase(OrgEnum org, ProductEnum product, List<OrgProduct> dbList, final int n) {
        OrgProduct maxOrgProduct = dbList.get(dbList.size() - 1);
        List<OrgProduct> list = new ArrayList<OrgProduct>();
        int shouldAddNum = n - dbList.size();
        int count = 0;
        boolean continueProductWithSameOrgId=true;//是否沿同一个orgid下的productId
        orgLoop:
        for (int orgId = maxOrgProduct.getOrgId(); orgId <= org.getJzh(); orgId++) {
            if(continueProductWithSameOrgId) {
                for (int productId = maxOrgProduct.getProductId() + 1; productId <= product.getCpflzh(); productId++) {
                    count++;
                    list.add(createOrgProduct(org, product, orgId, productId));
                    if (count >= shouldAddNum) {
                        break orgLoop;
                    }
                }
                continueProductWithSameOrgId=false;
            }
            for (int productId = product.getCpflqh(); productId <= product.getCpflzh(); productId++) {
                count++;
                list.add(createOrgProduct(org, product, orgId, productId));
                if (count >= shouldAddNum) {
                    break orgLoop;
                }
            }
        }
        System.out.println(org.getZzlb()+"   "+product.getCplb()+"   应该添加条数:"+shouldAddNum +"  ,实际添加条数:"+count);
        return list;
    }

    private OrgProduct createOrgProduct(OrgEnum org, ProductEnum product, int orgId, int productId) {
        OrgProduct op = new OrgProduct();
        op.setOrgCode(org.getZzlb());
        op.setOrgId(orgId);
        op.setProductCode(product.getCplb());
        op.setProductId(productId);
        op.setRecordStatus(RecordStatusEnum.Default.code());
        op.setLastSourceId(-1);
        op.setCreateTime(new Date());
        return op;
    }

    private List<OrgProduct> fromZero(OrgEnum org, ProductEnum product, final int n) {
        List<OrgProduct> list = new ArrayList<OrgProduct>();
        int count = 0;
        orgLoop:
        for (int orgId = org.getQsh(); orgId <= org.getJzh(); orgId++) {
            for (int productId = product.getCpflqh(); productId <= product.getCpflzh(); productId++) {
                count++;
                list.add(createOrgProduct(org, product, orgId, productId));
                if (count >= n) {
                    break orgLoop;
                }
            }
        }
//        System.out.println("从零添加条数:"+count);
        return list;
    }

    /**
     * @param org
     * @param product
     * @param list
     * @param n
     * @return true, 需要增加记录；
     */
    private boolean checkAddRecord(OrgEnum org, ProductEnum product, List<OrgProduct> list, int n) {
        if (list.size() == 0) {
            return true;
        }
        if (list.size() == n) {
            return false;
        }
        OrgProduct lastOrgProduct = list.get(list.size() - 1);
        Integer lastOrgId = lastOrgProduct.getOrgId();
        Integer lastProductId = lastOrgProduct.getProductId();
        long jieZhiOrgId = org.getJzh();
        long jieZhiProductId = product.getCpflzh();
        long total = ((jieZhiOrgId - lastOrgId.intValue()) + 1) * ((jieZhiProductId - lastProductId.intValue()) + 1);
        if (total <= 1) {
//            System.out.println("total:" + total + "            " + org.getZzlb() + " " + lastOrgId + "   ," + product.getCplb() + "  ," + lastProductId);
//            System.out.println("((" + jieZhiOrgId + "-" + lastOrgId.intValue() + ")+1)*((" + jieZhiProductId + "-" + lastProductId.intValue() + ")+1)");
            return false;
        }
        return true;
    }

    @Override
    public int moveOrgProduct2His() {
        //迁移3天之前完成的数据
        Date jieZhiDate=ZhsDateUtil.addDays(new Date(), -3);
        OrgProductExample query=new OrgProductExample();
        query.createCriteria().andRecordStatusEqualTo(RecordStatusEnum.Full.code()).andStopTimeLessThan(jieZhiDate);
//        List<OrgProduct> orgProductList=orgProductMapper.selectByExample(query);
        System.out.println();
        return 0;
    }
}
