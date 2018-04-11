package cn.zhsit;

import cn.zhsit.constants.ZhsConstants;
import cn.zhsit.daos.*;
import cn.zhsit.helpers.RedisHelper;
import cn.zhsit.services.OrgProductServiceTest;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisConnectionUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes =
        {
                Application.class,
                ZyZytybhbMapperTest.class,
                ZyZzidzdbhbMapperTest.class,
                OrgProductDaoTest.class,
                ZhsLockMapperTest.class,
                OrgProductMapperTest.class,
                OrgProductServiceTest.class,
                DaoForTest.class
        })
@Component
public class CreateAll extends BaseDao{

    @Autowired
    private ZyZytybhbMapperTest zyZytybhbMapperTest;
    @Autowired
    private ZyZzidzdbhbMapperTest zzidzdbhbMapperTest;
    @Autowired
    private OrgProductDaoTest orgProductDaoTest;
    @Autowired
    private OrgProductMapperTest orgProductMapperTest;
    @Autowired
    private ZhsLockMapperTest zhsLockMapperTest;
    @Autowired
    private  RedisTemplate<String, String> redisTemplate;
    @Autowired
    private OrgProductServiceTest orgProductServiceTest;
//    public void setRedisTemplate(RedisTemplate<String, String> redisTemplate){
//        CreateAll.redisTemplate=redisTemplate;
//    }




    @Test
    public void testCreateAll() throws Exception {
//        zzidzdbhbMapperTest.addAll();
//        zyZytybhbMapperTest.addAll();


    }

    private void cleanRedis()throws Exception{
        try {
            redisTemplate.getConnectionFactory().getConnection().flushDb();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    @Test
    public void addAll() throws Exception {
        cleanRedis();
        zhsLockMapperTest.addAll();
        orgProductServiceTest.addAll();

    }
}
