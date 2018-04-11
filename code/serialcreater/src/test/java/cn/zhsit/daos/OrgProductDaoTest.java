package cn.zhsit.daos;

import cn.zhsit.Application;
import cn.zhsit.constants.ZhsConstants;
import cn.zhsit.enums.CurrentLock;
import cn.zhsit.enums.OrgEnum;
import cn.zhsit.enums.ProductEnum;
import cn.zhsit.enums.TableId;
import cn.zhsit.helpers.KeyHelper;
import cn.zhsit.helpers.RedisHelper;
import cn.zhsit.models.po.OrgProduct;
import cn.zhsit.models.po.OrgProductExample;
import cn.zhsit.models.po.ZyZytybhb;
import cn.zhsit.models.vo.OrgProductVo;
import cn.zhsit.utils.ZhsNumberUtil;
import cn.zhsit.utils.ZhsThreadUtil;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisConnectionUtils;
import org.springframework.data.redis.core.RedisKeyValueTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.locks.Lock;

/**
 * 资源统一编号表
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
//@SpringBootTest()
@Component
public class OrgProductDaoTest extends BaseDao {
    @Rule
    public ContiPerfRule i = new ContiPerfRule();
    @Autowired
    private OrgProductDao orgProductDao;


    @Test
    public void testMaxId() throws Exception {
        Long maxId = orgProductDao.getMaxId();
        System.out.println("maxId:" + maxId);
    }

    @Test
    public void testSelectById() {
        OrgProduct op = orgProductDao.selectById((long) 329);
        System.out.println(op);
    }

    @Test
    @PerfTest(invocations = 100, threads = 20)
    public void testLockRecord() throws Exception {
        String threadId = ZhsThreadUtil.currentThreadId();
        Integer seconds = 60;
//        Integer num = orgProductDao.lockRecord(2L, threadId, seconds);
        OrgProductVo orgProduct = new OrgProductVo();
        orgProduct.setId(2L);
        orgProduct.setRecordOwner(threadId);
        orgProduct.setRecordOwnerExpireSeconds(seconds);
        Integer num = orgProductDao.lockRecord(orgProduct);
        System.out.println("锁行数目:" + num);
        if (num == 1) {
            Thread.sleep(1000 * seconds);
        }
    }

    @Test
    public void testSelectMinOrgProduct() {
        OrgProduct op = new OrgProduct();
        op.setOrgCode(OrgEnum.CaiTuan.getZzlb());
        op.setProductCode(ProductEnum.JiaoYi.getCplb());
        OrgProduct minOrgProduct = orgProductDao.selectMinOrgProduct(op);
        System.out.println(minOrgProduct);

    }

    @Test
    public void addAll() {

    }
}
