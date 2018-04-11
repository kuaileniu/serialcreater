package cn.zhsit.caches.redis;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisConnectionUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import springfox.documentation.service.ApiListing;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2017/5/15.
 * http://blog.csdn.net/xiaoyu411502/article/details/51596518
 * Redis操作命令总结 http://www.jb51.net/article/61793.htm
 * lbush  iven a
 *
 * llen key：计算链表的元素个数
 */
//@Component
public class RedisQueue<T> implements InitializingBean,DisposableBean {
    @Resource
    private RedisTemplate redisTemplate;
    private String key="iven";
    private int cap = Short.MAX_VALUE;//最大阻塞的容量，超过容量将会导致清空旧数据
    private byte[] rawKey;
    private RedisConnectionFactory factory;
    private RedisConnection connection;//for blocking
    private BoundListOperations<String, T> listOperations;//noblocking
    private Lock lock = new ReentrantLock();//基于底层IO阻塞考虑
    @Resource
    private RedisQueueListener listener;//异步回调
    private Thread listenerThread;
    private boolean isClosed;


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(" 开始加载 redis消息队列-----");
        factory = redisTemplate.getConnectionFactory();
        connection = RedisConnectionUtils.getConnection(factory);
        rawKey = redisTemplate.getKeySerializer().serialize(key);
        listOperations = redisTemplate.boundListOps(key);
        if(listener != null){
            listenerThread = new ListenerThread();
            listenerThread.setDaemon(true);
            listenerThread.start();
        }
    }


    /**
     * blocking
     * remove and get last item from queue:BRPOP
     * @return
     */
    public T takeFromTail(int timeout) throws InterruptedException{
        lock.lockInterruptibly();
        try{
            List<byte[]> results = connection.bRPop(timeout, rawKey);
            if(CollectionUtils.isEmpty(results)){
                return null;
            }
            return (T)redisTemplate.getValueSerializer().deserialize(results.get(1));
        }finally{
            lock.unlock();
        }
    }

    public String takeFromTail() throws InterruptedException{
        return takeFromHead(0);
    }

    /**
     * 从队列的头，插入
     */
    public void pushFromHead(T value){
        listOperations.leftPush(value);
    }

    public void pushFromTail(T value){
        listOperations.rightPush(value);
    }

    /**
     * noblocking
     * @return null if no item in queue
     */
    public T removeFromHead(){
        return listOperations.leftPop();
    }

    public T removeFromTail(){
        return listOperations.rightPop();
    }

    /**
     * blocking
     * remove and get first item from queue:BLPOP
     * @return
     */
    public String takeFromHead(int timeout) throws InterruptedException{
        lock.lockInterruptibly();
        try{
            List<byte[]> results = connection.bLPop(timeout, rawKey);
            if(CollectionUtils.isEmpty(results)){
                return null;
            }
            for(byte[] bb:results){
                System.out.println(new String(bb));
            }
            return  new String(results.get(1));
//            return (String)redisTemplate.getValueSerializer().deserialize(results.get(1));
        }finally{
            lock.unlock();
        }
    }

    public String takeFromHead() throws InterruptedException{
        return takeFromHead(0);
    }

    @Override
    public void destroy() throws Exception {
        if(isClosed){
            return;
        }
        shutdown();
        RedisConnectionUtils.releaseConnection(connection, factory);
    }

    private void shutdown(){
        try{
            listenerThread.interrupt();
        }catch(Exception e){
            //
        }
    }
    class ListenerThread extends Thread {

        @Override
        public void run(){
            try{
                while(true){
                    String value = takeFromHead();//cast exceptionyou should check.
                    //逐个执行
                    if(value != null){
                        try{
                            listener.onMessage(value);
                        }catch(Exception e){
                            //
                        }
                    }
                }
            }catch(InterruptedException e){
                //
            }
        }
    }

//    public static void main(String[] args) throws Exception{
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-redis-beans.xml");
//        RedisQueue<String> redisQueue = (RedisQueue)context.getBean("jedisQueue");
//        redisQueue.pushFromHead("test:app");
//        Thread.sleep(15000);
//        redisQueue.pushFromHead("test:app");
//        Thread.sleep(15000);
//        redisQueue.destroy();
//    }
}
