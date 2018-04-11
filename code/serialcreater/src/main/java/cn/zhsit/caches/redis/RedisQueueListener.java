package cn.zhsit.caches.redis;

/**
 * Created by Administrator on 2017/5/15.
 */
public interface RedisQueueListener<T> {
    public void onMessage(T value);
}
