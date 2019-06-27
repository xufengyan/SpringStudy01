package com.web.test.ThreadAndRunnable.线程池;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2019/4/24 0024.
 */
public class T_08ScheduledPool {


    //newScheduledThreadPool--------定时执行任务

    public  static void main(String [] args){

        ScheduledExecutorService service= Executors.newScheduledThreadPool(4);


        service.scheduleAtFixedRate(()->{

            System.out.println(Thread.currentThread().getName());


        },0,2000, TimeUnit.MILLISECONDS);
        //scheduled的scheduleAtFixedRate一共有四个参数
        //第一个要执行的方法，第二个开始任务多少时间开始，每次多少时间次执行，时间的格式


    }


}
