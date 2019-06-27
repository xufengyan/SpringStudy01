package com.web.test.ThreadAndRunnable.线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2019/4/24 0024.
 */
public class T_07SingleThreadExecutor {

    public static void main(String [] args){

        //newSingleThreadExecutor()------单线程池，只有一个线程执行，且会按顺序执行线程，


        ExecutorService service=Executors.newSingleThreadExecutor();


        for(int i=0;i<10;i++){

            service.execute(()->{

                System.out.println(Thread.currentThread().getName());

            });

        }




    }



}
