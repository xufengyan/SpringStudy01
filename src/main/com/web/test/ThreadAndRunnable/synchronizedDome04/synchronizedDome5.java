package com.web.test.ThreadAndRunnable.synchronizedDome04;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2019/3/27 0027.
 */
public class synchronizedDome5 {

    Object o=new Object();


    /**
     * 当一个锁对象改变了，锁定的也会改变-------------所以synchronized中锁定的是堆内存中的对象上面
     * 不要用字符串常量作为锁定的对象
     */


    public void m1(){
        synchronized (o){
            for(int i=1;i>0;i++){

                try {
                    TimeUnit.SECONDS.sleep(2);
                }catch (Exception e){

                }
                System.out.println(Thread.currentThread().getName());

            }
        }
    }

    public void m2(){
        synchronized (o){
            for(int i=1;i>0;i++){
                try {
                    TimeUnit.SECONDS.sleep(2);
                }catch (Exception e){

                }
                System.out.println(Thread.currentThread().getName());

            }
        }
    }



    public static void main(String [] args){

        synchronizedDome5 s=new synchronizedDome5();

        new Thread(s::m1,"m1").start();
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){

        }

        s.o=new Object(); //将锁的对象改变

        //锁的对象改变了，线程2就可以进去了，否则锁的对象没有改变的话，线程2永远启动不了

        new Thread(s::m2,"m2").start();

    }




}
