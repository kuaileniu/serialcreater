//package cn.zhsit.helpers;
//
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//
///**
// * Created by Administrator on 2017/5/9.
// */
////@Service
//@Component
//public class RedisCacheHelper {
//    @Resource
//    private RedisTemplate<String,String> redisTemplate;
//
//    public void g(){
//        ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
//        valueOperations.set("mykey4", "random1="+Math.random());
//        System.out.println(valueOperations.get("mykey4"));
//        System.out.println(valueOperations.get("foo"));
//    }
//}
