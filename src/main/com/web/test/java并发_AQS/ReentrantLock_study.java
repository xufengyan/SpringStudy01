package com.web.test.java并发_AQS;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2019/6/19 0019.
 */
public class ReentrantLock_study {

    private static int clientTotel=2000;

    private static int threaTotal=200;

    private static int count=0;

    //
    private static Lock lock=new ReentrantLock();

    public static void main(String [] args) throws InterruptedException {

        ExecutorService execut= Executors.newCachedThreadPool();

        final Semaphore semaphore=new Semaphore(threaTotal);

        final CountDownLatch countDownLatch=new CountDownLatch(clientTotel);

        for(int i=0;i<clientTotel;i++){

            execut.execute(()->{
                try {
                    semaphore.acquire();
                    held();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        execut.shutdown();
        System.out.println("count:"+count);

    }


    private  static void held(){
        lock.lock();
        try {
            count++;
        }finally {
            lock.unlock();
        }
    }













}
