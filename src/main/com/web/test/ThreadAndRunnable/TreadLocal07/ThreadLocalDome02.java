package com.web.test.ThreadAndRunnable.TreadLocal07;

/**
 * Created by Administrator on 2019/4/3 0003.
 */


import com.sun.org.apache.regexp.internal.RE;

/**
 * 线程安全的单利模式
 */
public class ThreadLocalDome02 {

    private static ThreadLocalDome02 t;

    private ThreadLocalDome02(){

    }

    /**
     * 使用同步锁保证线程安全
     * 调用这个方法，判断这个方法的对象是不是为空
     * 不是的创建
     * @return
     */
    public static synchronized ThreadLocalDome02 getThread(){

        if(t==null){
           t=new ThreadLocalDome02();
        }
        return t;
    }


    /**
     * 使用双层同步锁保证线程安全
     *
     */

    public static ThreadLocalDome02 getThread02(){

        if(t==null){
            //使用synchronized锁定局部代码，
//            当一个线程进去后，再判断一次是否为空，再进行创建
        synchronized (ThreadLocalDome02.class){
            if(t==null){
                t=new ThreadLocalDome02();
            }
        }
        }
        return t;
    }


    /**
     * 不使用锁 实现线程安全的单例模式
     */
    /**
     * 创建一个内部类
     */
    private static class getThread{

        private static ThreadLocalDome02 t2=new ThreadLocalDome02();
    }
    //当调用get方法的时候调用创建的方法
    public static ThreadLocalDome02 getThread03(){

        return getThread.t2;
    }






}
