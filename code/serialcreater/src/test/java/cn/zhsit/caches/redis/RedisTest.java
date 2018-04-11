package cn.zhsit.caches.redis;

import cn.zhsit.Application;
import cn.zhsit.daos.ZyZytybhbMapperTest;
import cn.zhsit.daos.ZyZzidzdbhbMapperTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisConnectionUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(SpringRunner.class)
//@SpringApplicationConfiguration
@SpringBootTest(classes = {Application.class})
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() throws Exception {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
        System.out.println(stringRedisTemplate.opsForValue().get("foo"));
    }

    //Spring-data-redis: 事务与pipeline
    //http://www.tuicool.com/articles/nQ32ii
    @Test
    public void testIncr() {
        String key = "nnn";
        try {
            RedisConnectionFactory factory = redisTemplate.getConnectionFactory();
            RedisConnection redisConnection = factory.getConnection();
            List<Object> results;
            try {
                redisConnection.openPipeline();
                redisConnection.incr(key.getBytes("UTF-8")); //results .add一次
                redisConnection.incr(key.getBytes("UTF-8")); //results .add一次
                results = redisConnection.closePipeline();
            } finally {
                RedisConnectionUtils.releaseConnection(redisConnection, factory);
            }
            if (results == null) {
                return;
            }
            for (Object item : results) {
                System.out.println(item.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testObj() throws Exception {
//        User user=new User("aa@126.com", "aa", "aa123456", "aa","123");
//        ValueOperations<String, User> operations=redisTemplate.opsForValue();
//        operations.set("com.neox", user);
//        operations.set("com.neo.f", user,1,TimeUnit.SECONDS);
//        Thread.sleep(1000);
//        //redisTemplate.delete("com.neo.f");
//        boolean exists=redisTemplate.hasKey("com.neo.f");
//        if(exists){
//            System.out.println("exists is true");
//        }else{
//            System.out.println("exists is false");
//        }
//         Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
    }
}
