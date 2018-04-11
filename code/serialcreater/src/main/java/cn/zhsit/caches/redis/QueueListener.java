package cn.zhsit.caches.redis;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/5/15.
 */
@Component
public class QueueListener<T> implements RedisQueueListener<String> {
    @Override
    public void onMessage(String value) {
        System.out.println("redis消息队列输出结果"+value);
    }
}
