package com.web.test.ThreadAndRunnable.ReentrantLook05;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2019/3/28 0028.
 */
public class reentrantLockDome03 implements Runnable{

    private static ReentrantLock lock=new ReentrantLock(true);

    public void run() {
        for(int i=0;i<10;i++){
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName()+"--获取到锁");
            }catch (Exception e){

            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String [] args){

        reentrantLockDome03 r=new reentrantLockDome03();

        Thread t1=new Thread(r,"t1");
        Thread t2=new Thread(r,"t2");
        Thread t3=new Thread(r,"t3");
        t1.start();
        t2.start();
        t3.start();

    }



}
