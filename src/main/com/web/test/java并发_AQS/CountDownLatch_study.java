package com.web.test.java并发_AQS;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2019/6/18 0018.
 */
public class CountDownLatch_study {

    private static final int threaCount=200;

    public static void main(String [] args) throws InterruptedException{
        //创建一个线程池
        ExecutorService executor= Executors.newCachedThreadPool();

        //门闩
        CountDownLatch countDownLatch=new CountDownLatch(threaCount);

        for(int i=0;i<threaCount;i++){
            final int num=i;

            executor.execute(()->{
                try {
                    System.out.println("进入："+num);
                    TimeUnit.SECONDS.sleep(5);

                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    System.out.println("减一");
                    countDownLatch.countDown();
                }
            });

        }

        countDownLatch.await();
//        countDownLatch.await(10, TimeUnit.MILLISECONDS);//根据时间阻塞


        System.out.println("成功");

        executor.shutdown();

    }











}