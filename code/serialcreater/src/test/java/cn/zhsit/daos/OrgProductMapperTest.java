package cn.zhsit.daos;


import cn.zhsit.Application;
import cn.zhsit.daos.beans.Table;
import cn.zhsit.enums.*;
import cn.zhsit.helpers.KeyHelper;
import cn.zhsit.helpers.RedisHelper;
import cn.zhsit.models.po.OrgProduct;
import cn.zhsit.models.po.OrgProductExample;
import cn.zhsit.models.po.ZhsLockPO;
import cn.zhsit.utils.ZhsThreadUtil;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jca.cci.core.InteractionCallback;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class,DaoForTest.class})
@Component
public class OrgProductMapperTest extends BaseDao {
    @Rule
    public ContiPerfRule i = new ContiPerfRule();
    @Autowired
    private OrgProductDao orgProductDao;
    @Autowired
    public OrgProductMapper orgProductMapper;
    @Autowired
    private RedisHelper redisHelper;
    @Autowired
    private KeyHelper keyHelper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private ZhsLockDao zhsLockDao;
    @Autowired
    private DaoForTest daoForTest;

    //    （1）单位代码统一分配
//        00,000,000富得益总部；
//        00,000,001-09,999,996保留；      ---------------------保留
//        09,999,997系统管理员(super);
//        09,999,998系统安全员(secsuper);
//        09,999,999系统审计员(auditsuper),
//        10，000，000-19，999，999物流中心、直销店、销售企业
//        20，000,000-29，999,999生产企业；
//        30,000,000-79,999,999用户；
//        80,000,000-99,999,999菜团


    /**
     * （2）产品规格分类
     * “0000-0009”人员；
     * “0010-0029”订单；
     * “0030-0039”运单；
     * “0040-0049”出入库单；
     * “0050-0069”预留；
     * “0070”管理批次
     * “0071”视频头
     * “0072”库房
     * “0073”库位
     * “0074”车辆；
     * “0075”软硬件模块；
     * “0076”结算单；
     * “0077”支付单；
     * “0078”论坛编号；
     * “0079”帖子编号；
     * “0080”相册编号
     * “0081-0099”保留；
     * “1000-1999”消息编号；
     *  “2000-2999”照片编号；
     * “3000-3999”评论编号。
     * “4000-4999”微博编号
     * 其它按单位类型不同，产品规格编号分类不同。
     * 生产企业： “5000-5999”零售规格包装号；“6000-6999”批发规格包装号；“7000-7999”生产批次号；“8000-8999”生产记录号；“9000-9999”其它记录。
     * 物流公司：“9000-9999”其它记录。
     * 直销店：“5000-5999”批发零售交易单；“6000-6999”退货交易单；“7000-7999”送货单；“9000-9999”其它记录。
     * 菜团：“5000-5999”活动；“9000-9999”其它记录。
     * 富德益： 专有业务 “5000-5999”
     */

    //00,000,000富得益总部；

    //Perf在高并发时处理@Before有bug
//    @Before
    public void sUp() throws Exception {
        ZhsLockPO lockPO = new ZhsLockPO();
        lockPO.setSeconds(30);
        lockPO.setRecordOwner(ZhsThreadUtil.currentThreadId());
        lockPO.setId(ZhsLockEnum.OrgProductInsertLock.tableId());
        int count = zhsLockDao.lock(lockPO);
        try {
            if (count == 0) {
//                System.out.println("未获得setTableOrgProductIdFromRDB锁");
                Thread.currentThread().sleep(1000 * 2);
                return;
            }
            if (count == 1) {
                OrgProductExample example = new OrgProductExample();
                orgProductMapper.deleteByExample(example);
//                redisHelper.set(TableId.TableOrgProduct.id(), "0");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    //@Test
    public void muThread() throws Exception {
        int invocations = 100;
        int threadNum = 20;
        int loop = invocations / threadNum;
        for (int i = 0; i < threadNum; i++) {
            new Thread() {{
                sUp();
                for (int k = 0; k < loop; k++) {
                    insertAllOrgProduct();
                }
            }}.start();

        }
    }

    @Test
//    @PerfTest(invocations = 100, threads = 20)
//    @Required(max = 1000, average = 250, totalTime = 1000*20 )
    public void insertAllOrgProduct() throws Exception {
//        OrgProductExample example = new OrgProductExample();
//        orgProductMapper.deleteByExample(example);
//        redisHelper.set(TableId.TableOrgProduct.id(), "0");
        int count = 0;
        OrgEnum[] zzs = OrgEnum.values();
        for (OrgEnum zz : zzs) {
//            if (zz == OrgEnum.Undefine) {
//                continue;
//            }
            int zzTimes = 1;
            final int zzTimeLimit = 3;
            for (int orgId = zz.getQsh(); orgId <= zz.getJzh(); orgId++) {
                if (zzTimes > zzTimeLimit) {
                    break;
                } else {
                    zzTimes++;
                }
                ProductEnum[] cps = ProductEnum.values();
                for (ProductEnum cp : cps) {
                    int productTimes = 1;
                    final int productTimeLimits = 3;
                    for (int productId = cp.getCpflqh(); productId <= cp.getCpflzh(); productId++) {
                        if (productTimes > productTimeLimits) {
                            break;
                        } else {
                            productTimes++;
                        }
                        addOrgProduct(zz, cp, orgId, productId);
                        count++;
                    }
                }
            }
        }
        System.out.println("添加条数:"+count);
    }

    private void addOrgProduct(OrgEnum zz, ProductEnum cp, Integer orgId, Integer productId) {
        OrgProduct op = new OrgProduct();
//        op.setId(keyHelper.tableIdCreate(TableId.TableOrgProduct));
        op.setOrgCode(zz.getZzlb());
        op.setProductCode(cp.getCplb());
        op.setCreateTime(current);
        op.setOrgId(orgId);
        op.setProductId(productId);
        op.setRecordStatus(RecordStatusEnum.Default.code());
        op.setLastSourceId(-1);
        orgProductMapper.insert(op);
    }

    @Test
    public void addAll() throws Exception {
        daoForTest.truncateTableOrgProduct();
        insertAllOrgProduct();
    }

}
