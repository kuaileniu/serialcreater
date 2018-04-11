package cn.zhsit.helpers;

import cn.zhsit.Application;
import cn.zhsit.constants.ZhsConstants;
import cn.zhsit.models.vo.OrgProductVo;
import cn.zhsit.utils.ZhsBeanUtil;
import cn.zhsit.utils.ZhsJsonUtil;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.test.context.junit4.SpringRunner;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class RedisHelperTest {
    @Rule
    public ContiPerfRule i = new ContiPerfRule();
    @Autowired
    private RedisHelper redisHelper;
    @Autowired
    protected KeyHelper keyHelper;
    static Map map = new HashMap<>(1000);
    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void testIncrOnce() {
        for (int i = 0; i < 1000; i++) {
            List<Long> codes = redisHelper.incr("n", 10);
//            System.out.println(codes);
            map.put(i, codes);
        }
    }


    int step = 100;
    static volatile int num = 0;

    //http://databene.org/contiperf
    @Test
    //用20个线程共执行1000次
    @PerfTest(invocations = 10000, threads = 20)
    //总执行时间在totalTime毫秒之内，平均不能超过average毫秒，单次最大不能超过max毫秒
    @Required(max = 2000, average = 250, totalTime = 1000 * 20)
    public void testIncr() throws Exception {
        List<Long> codes = redisHelper.incr("n", step);
//        map.put(ZhsID.id32(), codes);
//        map.put(++num+"_"+ZhsID.id32(), codes);
    }

    @PerfTest(invocations = 100, threads = 20)
    @Required(max = 1000, average = 250, totalTime = 1000 * 20)
    @Test
    public void testSet() {
        String key = "888999";
        String value = "darren";
        redisHelper.set(key, value, 1, TimeUnit.MINUTES);
    }


    @Test
    public void testSetMultiIfAbsent() {
        Map<String, String> multi = new HashMap<>();
        multi.put("a", "a1");
        multi.put("b", "b5");
        multi.put("c", "c1");
        multi.put("d", "d1");
        redisHelper.setMultiIfAbsent(multi, Expiration.from(3, TimeUnit.MINUTES));
    }

    @Test
    public void testSetMultiUpsert() {
        Map<String, String> multi = new HashMap<>();
        multi.put("a", "ba1");
        multi.put("b", "bb1");
        multi.put("c", "bc1");
        multi.put("d", "bd1");
        redisHelper.setMultiUpsert(multi, Expiration.from(3, TimeUnit.MINUTES));
    }


    @Test
    public void testCheckExits() {
        String key = "888999";
        Boolean exists = redisHelper.checkExists(key);
        System.out.println("exists:" + exists);
        Assert.assertFalse(key + "不应该存在", exists);

    }

    //    @After
    public void printCurrent() {
        System.out.println(map.size());
    }

    @AfterClass
    public static void printTotal() {
        Iterator its = map.keySet().iterator();
        while (its.hasNext()) {
            Object key = its.next();
//            System.out.println(key + "    " + map.get(key));
//            System.out.println(key );
        }
//        System.out.println("size:"+map.size());
    }


    @Test
    public void testGetRedisTime() {
        Long time = redisHelper.getRedisTime();
        System.out.println("time:" + time);
        Assert.assertNotNull("获取的redis时间为空", time);
    }

    @Test
    public void testLock() {
        long l = 1000 * 30;
        Boolean lockSuccess = redisHelper.lock("fjt", l);
        System.out.println("lockSuccess：" + lockSuccess);
    }


    @Test
    public void testRemove() {
        String key = this.getClass().getName();
        redisHelper.set(key, "testRemove");
        redisHelper.remove(key);
    }

    @Test
    public void testPutHSet() {
        String key = "bjzhs";
        Map<String, String> map = new HashMap<>();
        map.put("orgId", "100");
        map.put("productId", "1");
        redisHelper.hPutAll(key, map);
    }

    @Test
    @PerfTest(invocations = 1000, threads = 20)
    public void testHIncrBy() {
        String key = "bjzhs";
        Map<String, String> map = new HashMap<>();
        map.put("orgId", "100");
        map.put("productId", "1");
        Long productId = redisHelper.hIncrBy(key, "productId");
        System.out.println("productId:" + productId);
    }

    //  hgetall fng123
    //  hincrby fng123 recordOwnerExpireSeconds 1
    @Test
    public void testHGetAll() {
        String key = "fng123";
        OrgProductVo oo = new OrgProductVo();
        oo.setRecordOwnerExpireSeconds(10);
        oo.setRecordOwner("bj北京智慧山");
        Map map = ZhsBeanUtil.bean2StingMap(oo);
        redisHelper.hPutAll(key, map);

        Map mm = redisHelper.hGetAll(key);
        System.out.println("mm:" + mm);
    }

    @Test
    @PerfTest(invocations = 100, threads = 20)
    public void testRightPushN(){
        long count=redisHelper.rightPushAll(keyHelper.getOrgProductHistoryListKey(),"beijing","智","慧","山");
        System.out.println("插入成功后的索引值:"+count);
    }
    @Test
    public void testRightPush(){
        long count=redisHelper.rightPush(keyHelper.getOrgProductHistoryListKey(),"3feng");
        System.out.println("插入成功后的索引值:"+count);
    }

    @Test
    @PerfTest(invocations = 10, threads = 20)
    public void testLeftPop() {
        String v = redisHelper.leftPop(keyHelper.getOrgProductHistoryListKey());
        System.out.println("v:"+v);
    }

    @Test
    @PerfTest(invocations = 10, threads = 20)
    public void testLeftPopN() throws Exception{
        List<String> list = redisHelper.leftPop(keyHelper.getOrgProductHistoryListKey(), 10);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
