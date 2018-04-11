package cn.zhsit.helpers;

import org.springframework.stereotype.Component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class ListOpsHelper {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 压栈
     *
     * @param key
     * @param value
     * @return
     */
    public Long leftPush(String key, String value) {
        return stringRedisTemplate.opsForList().leftPush(key, value);
    }

    public Long leftPushAll(String key, String... vals) {
        return stringRedisTemplate.opsForList().leftPushAll(key, vals);
    }

    public Long leftPushAll(String key, List<String> vals) {
        return stringRedisTemplate.opsForList().leftPushAll(key, vals);
    }


    /**
     * 出栈
     *
     * @param key
     * @return
     */
    public String leftPop(String key) {
        return stringRedisTemplate.opsForList().leftPop(key);
    }


    /**
     * 入队
     *
     * @param key
     * @param value
     * @return
     */
    public Long rightPush(String key, String value) {
        return stringRedisTemplate.opsForList().rightPush(key, value);
    }


    public Long rightPushAll(String key, String... vals) {
        return stringRedisTemplate.opsForList().rightPushAll(key, vals);
    }

    public Long rightPushAll(String key, List<String> vals) {
        return stringRedisTemplate.opsForList().rightPushAll(key, vals);
    }


    /**
     * 栈/队列长
     *
     * @param key
     * @return
     */
    public Long length(String key) {
        return stringRedisTemplate.opsForList().size(key);
    }

    /**
     * 范围检索
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public List<String> range(String key, int start, int end) {
        return stringRedisTemplate.opsForList().range(key, start, end);
    }

    /**
     * 移除
     *
     * @param key
     * @param i
     * @param value
     */
    public void remove(String key, long i, String value) {
        stringRedisTemplate.opsForList().remove(key, i, value);
    }

    /**
     * 检索
     *
     * @param key
     * @param index
     * @return
     */
    public String index(String key, long index) {
        return stringRedisTemplate.opsForList().index(key, index);
    }

    /**
     * 置值
     *
     * @param key
     * @param index
     * @param value
     */
    public void set(String key, long index, String value) {
        stringRedisTemplate.opsForList().set(key, index, value);
    }

    /**
     * 裁剪
     *
     * @param key
     * @param start
     * @param end
     */
    public void trim(String key, long start, int end) {
        stringRedisTemplate.opsForList().trim(key, start, end);
    }
}
