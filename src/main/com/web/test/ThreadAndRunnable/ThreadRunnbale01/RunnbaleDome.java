package com.web.test.ThreadAndRunnable.ThreadRunnbale01;

/**
 * Created by Administrator on 2019/3/12 0012.
 */

/**
 *
 * 通过继承Runable接口实现run（）方法创建一个线程
 */
public class RunnbaleDome implements Runnable{
    @Override
    public void run() {

        for (int i=0;i<10;i++){
            //currentThread()获取当前执行的线程
            System.out.println(Thread.currentThread().getName()+"线程第"+i+"调用");

        }

    }




}
