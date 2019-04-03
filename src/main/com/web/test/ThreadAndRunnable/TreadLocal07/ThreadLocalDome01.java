package com.web.test.ThreadAndRunnable.TreadLocal07;

import com.web.test.zhujie.Person;

/**
 * Created by Administrator on 2019/3/30 0030.
 */
public class ThreadLocalDome01 {


    /**
     * 线程本地的变量，线程之间ThreadLocal的改变相互不影响
     */
    static ThreadLocal<Person> tl=new ThreadLocal<>();



    public static void main(String [] args){

        ThreadLocalDome01 t=new ThreadLocalDome01();



        new Thread(()->{

            System.out.println("t1："+t.tl.get());

        },"t1").start();



        new Thread(()->{

         t.tl.set(new Person());
            System.out.println("dssd");
            System.out.println("t2 :"+t.tl.get());
        },"t2").start();


    }




}
