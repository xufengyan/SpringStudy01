package com.web.test.ThreadAndRunnable.并发容器;

import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2019/4/18 0018.
 */
public class b_05linkedblockQueue {

    static BlockingDeque strs=new LinkedBlockingDeque();//是一个阻塞式的线程安全的队列,无界限：可以无限储存数据

    static Random random = new Random();

    public static void main(String [] args){


        //启动一个生产者线程
        new Thread(()->{
            for(int i=0;i<100;i++){

                try {
                    strs.put("s"+i);
                    TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        },"生产者").start();



        for(int i=0;i<5;i++){

            new Thread(()-> {

                for (; ; ) {

                    try {
                        System.out.println(Thread.currentThread().getName() + "消费：" + strs.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }


            },"消费者"+i).start();



        }




    }

}
