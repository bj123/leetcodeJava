package com.example.juc;
import javax.jws.Oneway;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁， 一般使用缓存
 */
public class ReentrantReadWriteLockTest {
    static Map<String, Object> map = new HashMap<String, Object>();
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    static Lock r = rwl.readLock();
    static Lock w = rwl.writeLock();

    private    volatile  boolean isCheck;
    // 获取一个key对应的value
    public static final Object get(String key) {
        r.lock();
        try {
            return map.get(key);
        } finally {
            r.unlock();
        }
    }
    // 设置key对应的value，并返回旧的value
    public static final Object put(String key, Object value) {
        w.lock();
        try {
            return map.put(key, value);
        } finally {
            w.unlock();
        }
    }

    /**
     * 锁降级：遵循获取写锁，获取读锁在释放写锁的次序，写锁可以降级为读锁
     */
    public    void  readWriteLock(){
            // 先加读锁
            r.lock();
            if(isCheck){
                //为true 时进行写入操作,读写锁是互斥的，读读才是共享的，所以要先释放读锁
                r.unlock();
                w.lock(); //毒读锁释放后，多个线程才能竞争写锁
                map.put("test","aaaaa");
                //当血锁释放完毕时，其它所有的线程会继续竞争写锁。所以要保证不让其它线程进来，要进行锁降级
                //加了读锁  其它写锁，就要等待下面的写锁释放后才可以进行修改。
                // 然后其它线程发现读锁还未释放，所以写入不，保证了下面读取的线程安全性
                r.lock();
                w.unlock();  //
            }
            Object test=map.get("test");
            System.out.println(test);
            r.unlock();

    }
}
