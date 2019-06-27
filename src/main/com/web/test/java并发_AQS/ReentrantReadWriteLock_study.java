package com.web.test.java并发_AQS;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Administrator on 2019/6/19 0019.
 */
public class ReentrantReadWriteLock_study {

    private static Map<String,String> map=new HashMap<>();

    /**
     * 共享资源读锁支持多线访问，写锁只支持独占
     */
    private static ReentrantReadWriteLock readWriteLock=new ReentrantReadWriteLock();

    private static Lock readLock=readWriteLock.readLock();

    private static Lock writeLock=readWriteLock.writeLock();


    /**
     * 读取
     * @param key
     * @return
     */
    public String getKey(String key){
        readLock.lock();
        try {
            return map.get(key);
        }finally {
            readLock.unlock();
        }
    }


    /**
     * 设置值
     * @param key
     * @param value
     * @return
     */
    public String setMap(String key,String value){
        writeLock.lock();
        try {
            return map.put(key,value);
        }finally {
            writeLock.unlock();
        }
    }



    public static void main(String [] args){

        ReentrantReadWriteLock_study r=new ReentrantReadWriteLock_study();

        for(int i=0;i<10;i++){
            final int t=i;
           new Thread(()->{
               System.out.println(r.setMap("r"+t,"t"+t));
           }).start();
        }

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(int i=0;i<10;i++){
            final int t=i;
            new Thread(()->{
                System.out.println("值"+r.getKey("r"+t));
            }).start();
        }


    }

}
