package com.web.test.ThreadAndRunnable.线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2019/4/22 0022.
 */
public class T_03ThreadPool {

//    线程池-----------将一堆线程放在一个容器中的，等着用

    //newFixedThreadPool----------指定容量的线程池，可控制线程最大容量的并发数，超过容量的线程就等待

//    使用线程池的好处就是节省资源，提高效率
    public static void main(String [] args){
        //创建一个容量为5的线程池
        ExecutorService service= Executors.newFixedThreadPool(5);

        //创建6个任务，放到这个容量为5的线程池中
        //当6个任务放到容量为5的线程池中的时候五个线程都会启动区处理五个任务，其中多出的任务就必须要等待
        for(int i=0;i<6;i++){
            service.execute(()->{
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName());

            });
        }

        System.out.println(service);

        service.shutdown();//等待所有的任务都执行完了，就关闭线程池

        System.out.println(service.isTerminated());//判断线程池里面的任务是否执行完了

        System.out.println(service.isShutdown()); //判断线程池是否关闭

        System.out.println(service);

    }



}
