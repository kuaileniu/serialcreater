package cn.zhsit.services.impl;

import cn.zhsit.constants.ZhsConstants;
import cn.zhsit.daos.OrgProductDao;
import cn.zhsit.daos.OrgProductMapper;
import cn.zhsit.enums.OrgEnum;
import cn.zhsit.enums.ProductEnum;
import cn.zhsit.enums.SourceEnum;
import cn.zhsit.helpers.KeyHelper;
import cn.zhsit.helpers.RedisHelper;
import cn.zhsit.helpers.SerialHelper;
import cn.zhsit.models.dto.CommonDTO;
import cn.zhsit.models.po.OrgProduct;
import cn.zhsit.models.vo.OrgProductVo;
import cn.zhsit.models.vo.SerialReq;
import cn.zhsit.models.vo.SerialResp;
import cn.zhsit.services.AbstractSerialService;
import cn.zhsit.services.SerialService;
import cn.zhsit.utils.ZhsBeanUtil;
import cn.zhsit.utils.ZhsNumberUtil;
import cn.zhsit.utils.ZhsThreadUtil;
import cn.zhsit.utils.io.ZhsIOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author Darren
 *         61947666@qq.com
 * @description:
 */
@Service
public class SerialServiceImpl extends AbstractSerialService implements SerialService {
    protected Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    protected OrgProductMapper orgProductMapper;
    @Autowired
    protected RedisHelper redisHelper;
    @Autowired
    protected SerialHelper serialHelper;
    @Autowired
    protected KeyHelper keyHelper;
    @Autowired
    protected OrgProductDao orgProductDao;


//    public void handle4(HttpServletRequest request, HttpServletResponse resp, SerialReq serial) {
//        OrgEnum org = OrgEnum.of(serial.getOrgCode());
//        ProductEnum product = ProductEnum.of(serial.getProductCode());
//        Map<String, String> orgProduct = null;
//        boolean next = false;
//        int loopNum = 0;
//        while (!next && loopNum < 10) {
//            loopNum++;
//            orgProduct = redisHelper.hMGet(keyHelper.getOrgProductRecordKey(org, product), "orgId", "productId");
//            if (orgProduct == null) {
//                boolean lockSuccess = resetRedisOrgProduct(org, product);
//                if (!lockSuccess) {
//                    ZhsThreadUtil.sleep(2);
//                }
//            } else {
//                // 获取lastSourceId
//                Long lastSourceId = redisHelper.hIncrBy(keyHelper.getOrgProductRecordKey(org, product), "lastSourceId");
//                boolean goOn = check(lastSourceId);
//                if (!goOn) {
//                    redisHelper.del(keyHelper.getOrgProductRecordKey(org, product));
//                }
//                orgProduct.put("lastSourceId", lastSourceId.toString());
//                next = true;
//            }
//        }
//        if (!next) {
//            writeOutError(resp);
//            return;
//        }
//        writeOut(orgProduct, resp);
//
//    }



//
//        writeOut(orgProduct, resp);
//    }
//
//    /**
//     * @param org
//     * @param product
//     * @return true设置成功；
//     */
//    private boolean resetRedisOrgProduct(OrgEnum org, ProductEnum product) {
//        OrgProduct op = new OrgProduct();
//        op.setOrgCode(org.getZzlb());
//        op.setProductCode(product.getCplb());
//        //1.查询最小的有效的OrgProduct
//        OrgProduct minOrgProduct = orgProductDao.selectMinOrgProduct(op);
//        //2.锁查询出来的最小的OrgProduct
//        OrgProductVo opv = new OrgProductVo();
//        opv.setRecordOwnerExpireSeconds(ZhsConstants.OrgProductRecordLockTime);
//        opv.setId(minOrgProduct.getId());
//        opv.setRecordOwner(ZhsThreadUtil.currentThreadId());
//        int lockNum = orgProductDao.lockRecord(opv);
//        if (lockNum != 1) {
//            return false;
//        }
//
//        //3.若能锁成功，根据id重新查询此id的OrgProduct;若锁不成功，线程等待2秒后，从redis中再次获取
//        minOrgProduct = orgProductMapper.selectByPrimaryKey(minOrgProduct.getId());
////        Integer lastSourceId = minOrgProduct.getLastSourceId();
//        //4.将最小的OrgProduct设置到redis hashset中
////        redisHelper.set(keyHelper.getOrgProductRecordKey(org, product), ZhsJsonUtil.toJson(minOrgProduct));
//        redisHelper.hPutAll(keyHelper.getOrgProductRecordKey(org, product), ZhsBeanUtil.bean2StingMap(minOrgProduct));
//        //5.orgProduct 为redis中的值,引用指向新值
//        //6,设置sourceId
////        redisHelper.set(keyHelper.getSourceKey(org, product), lastSourceId.toString());
//
//        //7,解锁OrgProduct表
//        orgProductDao.releaseLockRecord(opv);
//        return true;
//    }


    /**
     * @param orgProduct
     * @return true, 通过；
     */
    private boolean check(final OrgProduct orgProduct) {
        return ZhsNumberUtil.noMoreThanBitNum(SourceEnum.Length, orgProduct.getLastSourceId());
    }

    public void writeOutError(HttpServletResponse resp,CommonDTO dto) {
        SerialResp sr = new SerialResp();
        sr.setCode(SerialResp.CODE_ERROR);
        sr.setMsg("有异常，后面需要重写");
        ZhsIOUtils.writeJsonAndClose(resp, sr);
    }

    private void writeOut(final OrgProduct orgProduct, HttpServletResponse resp) {
        SerialResp serialResp = new SerialResp();
        serialResp.setCode(SerialResp.CODE_OK);
        serialResp.setMsg(serialHelper.serial(orgProduct));
        ZhsIOUtils.writeJsonAndClose(resp, serialResp);
    }

//    @Override
//    public void writeOut(final Map<String, String> orgProduct, HttpServletResponse resp) {
//        SerialResp serialResp = new SerialResp();
//        serialResp.setCode(SerialResp.CODE_OK);
//        serialResp.setMsg(serialHelper.serial(orgProduct));
//        ZhsIOUtils.writeJsonAndClose(resp, serialResp);
//    }


}
