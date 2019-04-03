package com.web.test.ThreadAndRunnable;

import com.web.test.ThreadAndRunnable.ThreadRunnbale01.RunnbaleDome;
import com.web.test.ThreadAndRunnable.ThreadRunnbale01.ThreadDome;

/**
 * Created by Administrator on 2019/3/12 0012.
 */
public class Main {

    public static void main(String [] args){

//        实现Runnable接口来实现
        RunnbaleDome runnbale=new RunnbaleDome();
        Thread thread1=new Thread(runnbale,"第一个线程");
        Thread thread2=new Thread(runnbale,"第二个线程");
        thread1.start();
        thread2.start();


        //继承Thread类来实现
        ThreadDome threadDome1=new ThreadDome("Thread1线程");
        ThreadDome threadDome2=new ThreadDome("Thread2线程");

        threadDome1.start();
        threadDome2.start();

        ThreadLocal threadLocal=new ThreadLocal();



    }

}
