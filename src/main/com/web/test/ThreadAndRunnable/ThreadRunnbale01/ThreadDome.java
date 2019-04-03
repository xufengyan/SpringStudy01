package com.web.test.ThreadAndRunnable.ThreadRunnbale01;


/**
 * Created by Administrator on 2019/3/12 0012.
 */
public class ThreadDome extends Thread{

    public ThreadDome (){


    }
    public ThreadDome (String name){
        super(name);
    }

    @Override
    public void run() {

        for(int i=0;i<10;i++){

            System.out.println(Thread.currentThread().getName()+"第"+i+"次执行");

        }

    }
}
