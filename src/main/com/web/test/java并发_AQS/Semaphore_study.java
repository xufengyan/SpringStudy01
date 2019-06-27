package com.web.test.java并发_AQS;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Administrator on 2019/6/18 0018.
 */
public class Semaphore_study {
    private static int threadCount=200;

    public static void main(String []args){

        ExecutorService execut= Executors.newCachedThreadPool();

        //信号量 ，当里面的值为0 的时候就会阻塞
        Semaphore semaphore=new Semaphore(20);


        for(int i=0;i<threadCount;i++){

            final int num=i;

            execut.execute(()->{
                try {
                    semaphore.acquire();//获取许可证
                    System.out.println("进入:"+num);
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });




        }




    }
    private static void hehe(int threadNum) throws InterruptedException {


    }

}
