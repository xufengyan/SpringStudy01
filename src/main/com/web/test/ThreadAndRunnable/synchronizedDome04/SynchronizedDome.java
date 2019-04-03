package com.web.test.ThreadAndRunnable.synchronizedDome04;

/**
 * Created by Administrator on 2019/3/15 0015.
 */
public class SynchronizedDome {

    private  int count=10;

    private Object o=new Object();//锁

    private static int count2=10;

    public void m(){
        synchronized (o){//每个线程进来执行这个方法的时候都必须拿到 O这个锁
            count--;
            System.out.println("线程："+Thread.currentThread().getName()+"count:------------"+count);
        }
    }


    public void T(){
        synchronized (this){//每个线程进来执行这个方法的时候都必须拿到 this这个锁
            count++;
            System.out.println("线程："+Thread.currentThread().getName()+"count:------------"+count);
        }

    }


//    将synchronized放到今天方法中等同于
    public synchronized static void S(){

        count2--;
        System.out.println("线程："+Thread.currentThread().getName()+"count2:------------"+count2);

    }


}
