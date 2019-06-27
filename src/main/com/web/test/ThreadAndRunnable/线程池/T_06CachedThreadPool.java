package com.web.test.ThreadAndRunnable.线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2019/4/24 0024.
 */
public class T_06CachedThreadPool {

//    newCochedThreadPool--------可缓存的线程池，可灵活回收空闲线程，若无空闲，则创建新的线程


    public static void main(String [] args){

        ExecutorService service= Executors.newCachedThreadPool();

        System.out.println("当前线程池情况："+service);


        //在线程池中放十个线程
        for(int i=0;i<10;i++){
            service.execute(()->{

                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName());

            });
        }


        System.out.println("十个线程执行完线程池的启动信息"+service);

        //当60秒后若newCachedThreadPool线程池中没有线程执行，线程池会自动关闭空闲线程

        try {
            TimeUnit.SECONDS.sleep(70);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当70秒后线程池的信息"+service);

    }




}
