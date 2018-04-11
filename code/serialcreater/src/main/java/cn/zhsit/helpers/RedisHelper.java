package cn.zhsit.helpers;

import cn.zhsit.constants.ZhsConstants;
import cn.zhsit.utils.ZhsBeanUtil;
import org.apache.ibatis.ognl.IntHashMap;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

// http://www.cnblogs.com/skyessay/p/6485187.html
@Component
public class RedisHelper {
    private static final String lockSeparator = "__";
    @Resource
    private RedisTemplate<String, String> redisTemplate;

    public void set(String key, String val) {
        redisTemplate.opsForValue().set(key, val);
    }

    public void set(String key, String val, long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, val, timeout, unit);
    }

    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public boolean del(String key) {
        redisTemplate.delete(key);
        return true;
    }

    public boolean remove(String key) {
        try {
            byte[] k = key.getBytes(ZhsConstants.ChaSet_UTF_8);
            RedisConnectionFactory factory = redisTemplate.getConnectionFactory();
            RedisConnection redisConnection = factory.getConnection();
            Long result;
            try {
                result = redisConnection.del(k);
            } finally {
                RedisConnectionUtils.releaseConnection(redisConnection, factory);
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Long increment(String key) {
        return redisTemplate.opsForValue().increment(key, 1);
    }

    /**
     * 当不存在时，添加
     *
     * @param multi
     * @param expiration
     * @throws RuntimeException
     */
    public void setMultiIfAbsent(Map<String, String> multi, Expiration expiration) throws RuntimeException {
        if (null == multi || multi.size() < 1) return;
        try {
            RedisConnectionFactory factory = redisTemplate.getConnectionFactory();
            RedisConnection redisConnection = factory.getConnection();
            try {
                redisConnection.openPipeline();
                for (Map.Entry<String, String> entry : multi.entrySet()) {
                    String key = entry.getKey();
                    String val = entry.getValue();
                    redisConnection.set(key.getBytes(ZhsConstants.ChaSet_UTF_8), val.getBytes(ZhsConstants.ChaSet_UTF_8), expiration, RedisStringCommands.SetOption.ifAbsent());
                }
                redisConnection.closePipeline();
            } finally {
                RedisConnectionUtils.releaseConnection(redisConnection, factory);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 当不存在时，添加
     *
     * @param multi
     * @throws RuntimeException
     */
    public void setMultiIfAbsent(Map<String, String> multi) throws RuntimeException {
        if (null == multi || multi.size() < 1) return;
        try {
            Expiration expiration = Expiration.from(Integer.MAX_VALUE, TimeUnit.DAYS);
            RedisConnectionFactory factory = redisTemplate.getConnectionFactory();
            RedisConnection redisConnection = factory.getConnection();
            try {
                redisConnection.openPipeline();
                for (Map.Entry<String, String> entry : multi.entrySet()) {
                    String key = entry.getKey();
                    String val = entry.getValue();
                    redisConnection.set(key.getBytes(ZhsConstants.ChaSet_UTF_8), val.getBytes(ZhsConstants.ChaSet_UTF_8), expiration, RedisStringCommands.SetOption.SET_IF_ABSENT);
                }
                redisConnection.closePipeline();
            } finally {
                RedisConnectionUtils.releaseConnection(redisConnection, factory);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 重新设置；相当于如果有则删除，再添加；
     *
     * @param multi
     * @param expiration
     * @throws RuntimeException
     */
    public void setMultiUpsert(Map<String, String> multi, Expiration expiration) throws RuntimeException {
        if (null == multi || multi.size() < 1) return;
        try {
            RedisConnectionFactory factory = redisTemplate.getConnectionFactory();
            RedisConnection redisConnection = factory.getConnection();
            try {
                redisConnection.openPipeline();
                for (Map.Entry<String, String> entry : multi.entrySet()) {
                    String key = entry.getKey();
                    String val = entry.getValue();
                    redisConnection.set(key.getBytes(ZhsConstants.ChaSet_UTF_8), val.getBytes(ZhsConstants.ChaSet_UTF_8), expiration, RedisStringCommands.SetOption.UPSERT);
                }
                redisConnection.closePipeline();
            } finally {
                RedisConnectionUtils.releaseConnection(redisConnection, factory);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Long incr(String key) throws RuntimeException {
        try {
            byte[] k = key.getBytes(ZhsConstants.ChaSet_UTF_8);
            RedisConnectionFactory factory = redisTemplate.getConnectionFactory();
            RedisConnection redisConnection = factory.getConnection();
            Long result;
            try {
                redisConnection.openPipeline();
                result = redisConnection.incr(k); //results .add一次
                List<Object> results = redisConnection.closePipeline();
                result = (Long) results.get(0);
            } finally {
                RedisConnectionUtils.releaseConnection(redisConnection, factory);
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Long> incr(String key, int count) throws RuntimeException {
        try {
            byte[] k = key.getBytes(ZhsConstants.ChaSet_UTF_8);
            RedisConnectionFactory factory = redisTemplate.getConnectionFactory();
            RedisConnection redisConnection = factory.getConnection();
            List results;
            try {
                redisConnection.openPipeline();
                for (int i = 0; i < count; i++) {
                    redisConnection.incr(k); //results .add一次
                }
                results = redisConnection.closePipeline();
            } finally {
                RedisConnectionUtils.releaseConnection(redisConnection, factory);
            }
            return results;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /***
     * 根据key判断是否存在
     *
     * @param key
     * @return true 存在；
     * @throws RuntimeException
     */
    public Boolean checkExists(String key) throws RuntimeException {
        try {
            byte[] k = key.getBytes(ZhsConstants.ChaSet_UTF_8);
            RedisConnectionFactory factory = redisTemplate.getConnectionFactory();
            RedisConnection redisConnection = factory.getConnection();
            try {
                return redisConnection.exists(k);
            } finally {
                RedisConnectionUtils.releaseConnection(redisConnection, factory);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //获取redis的时间
    public Long getRedisTime() {
        return redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.time();
            }
        });
    }

    /**
     * @param key
     * @return
     */
    public Boolean lock(String key, Long timeOutMillis) {
        try {
            long redisTime = getRedisTime();
            timeOutMillis = redisTime + timeOutMillis + 1;
            byte[] k = key.getBytes(ZhsConstants.ChaSet_UTF_8);
            byte[] v = (timeOutMillis.toString() + lockSeparator + ZhsConstants.SystemId + lockSeparator + Thread.currentThread().getName()).getBytes(ZhsConstants.ChaSet_UTF_8);
            RedisConnectionFactory factory = redisTemplate.getConnectionFactory();
            RedisConnection redisConnection = factory.getConnection();
            try {
                Boolean setNXSuccess = redisConnection.setNX(k, v);
                if (setNXSuccess) {
                    Boolean expireSuccess = redisConnection.pExpireAt(k, timeOutMillis);
                } else {
                    String redisVal = get(key);
                    if (null == redisVal) {
                        setNXSuccess = redisConnection.setNX(k, v);
                    } else {
                        String[] vals = redisVal.split(lockSeparator);
                        Long expireTime = Long.valueOf(vals[0]);
                        if (expireTime.longValue() < getRedisTime()) {
                            redisConnection.del(k);
                            setNXSuccess = redisConnection.setNX(k, v);
                            if (setNXSuccess) {
                                Boolean expireSuccess = redisConnection.pExpireAt(k, timeOutMillis);
                            }
                        }
                    }
                }
                return setNXSuccess;
            } finally {
                RedisConnectionUtils.releaseConnection(redisConnection, factory);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 释放本系统本线程主动上的锁
     *
     * @param key
     * @return
     */
    public Boolean releaseLock(String key) {
        try {
            RedisConnectionFactory factory = redisTemplate.getConnectionFactory();
            RedisConnection redisConnection = factory.getConnection();
            try {
                String redisVal = get(key);
                if (null == redisVal) {
                    return true;
                }
                String[] vals = redisVal.split(lockSeparator);
                byte[] k = key.getBytes(ZhsConstants.ChaSet_UTF_8);
                if (ZhsConstants.SystemId.equals(vals[1]) && Thread.currentThread().getName().equals(vals[2])) {
                    //是本系统本线程上的锁，则可以主动删除
                    redisConnection.del(k);
                    return true;
                } else {
                    //不是自己上的锁，要判断是否过期，如果过期，则删除
                    Long expireTime = Long.valueOf(vals[0]);
                    if (expireTime.longValue() < getRedisTime()) {
                        redisConnection.del(k);
                        return true;
                    } else {
                        return false;
                    }
                }
            } finally {
                RedisConnectionUtils.releaseConnection(redisConnection, factory);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param key
     * @param map map中的val不可以为空
     */
    public void hPutAll(String key, Map<String, String> map) {
        redisTemplate.opsForHash().putAll(key, map);
    }

    public Map<Object, Object> hGetAll(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    public Map<String, String> hMGet(String key, String... hkey) {
        Map<String, String> map = null;
        List hkeys = Arrays.asList(hkey);
        List hvals = redisTemplate.opsForHash().multiGet(key, hkeys);
        if (null == hvals) {
            return null;
        }
        for (int i = 0; i < hvals.size(); i++) {
            Object val = hvals.get(i);
            if (null == val) {
                continue;
            }
            if (map == null) {
                map = new HashMap<>();
            }
            map.put((String) hkeys.get(i), (String) hvals.get(i));
        }
        return map;
    }

    public Long hIncrBy(String key, String field) {
        return redisTemplate.opsForHash().increment(key, field, 1);
    }

    /**
     *
     * @param key
     * @param val
     * @return 插入成功后的索引值
     */
    public Long rightPushAll(String key, String... val) {
        if (val.length < 1) {
            return 0L;
        }
        return redisTemplate.opsForList().rightPushAll(key, val);
    }

    /**
     *
     * @param key
     * @param val
     * @return 插入成功后的索引值
     */
    public Long rightPush(String key, String val) {
        return redisTemplate.opsForList().rightPush(key, val);
    }

    public String leftPop(String key) {
        return redisTemplate.opsForList().leftPop(key);
    }

    public List<String> leftPop(String key, int n) {
        try {
            RedisConnectionFactory factory = redisTemplate.getConnectionFactory();
            RedisConnection redisConnection = factory.getConnection();
            List<Object> results=null;
            try {
                redisConnection.openPipeline();
                byte[] k = key.getBytes(ZhsConstants.ChaSet_UTF_8);
                for (int i = 0; i < n; i++) {
                    redisConnection.lPop(k);
                }
                results = redisConnection.closePipeline();
            } finally {
                RedisConnectionUtils.releaseConnection(redisConnection, factory);
            }
            List<String> back = new ArrayList<>();
            for(Object o:results){
                if (null != o) {
                    back.add(new String((byte[]) o, ZhsConstants.ChaSet_UTF_8));
                }
            }
            return back;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> rightPop(String key, int n) {
        try {
            RedisConnectionFactory factory = redisTemplate.getConnectionFactory();
            RedisConnection redisConnection = factory.getConnection();
            List<Object> results=null;
            try {
                redisConnection.openPipeline();
                byte[] k = key.getBytes(ZhsConstants.ChaSet_UTF_8);
                for (int i = 0; i < n; i++) {
                    redisConnection.rPop(k);
                }
                results = redisConnection.closePipeline();
            } finally {
                RedisConnectionUtils.releaseConnection(redisConnection, factory);
            }
            List<String> back = new ArrayList<>();
            for(Object o:results){
                if (null != o) {
                    back.add(new String((byte[]) o, ZhsConstants.ChaSet_UTF_8));
                }
            }
            return back;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
