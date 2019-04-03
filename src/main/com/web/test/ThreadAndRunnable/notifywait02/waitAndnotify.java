package com.web.test.ThreadAndRunnable.notifywait02;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/3/27 0027.
 */
public class waitAndnotify {

    /**
     * 使用notify（线程唤醒）和 wait（线程等待）
     * 实现一个线程在list集合中添加对象一个线程获取list.size()=5时
     */
    List list=new ArrayList();

    public void add(Object o){
            list.add(o);
    }

    public int size(){
        return list.size();
    }


    public static void main(String [] args){
        waitAndnotify w=new waitAndnotify();

        Object o=new Object();



        new Thread(() -> {
            System.out.println("w2启动");
            synchronized (o){
//                当size不等于5的时候将当前线程进入等待
                if(w.size()!=5){
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("w2结束--size="+w.size());
                //当前线程结束的时候唤醒当前对象锁的等待线程
                o.notify();
            }
        },"w2").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("w1启动");
                synchronized (o){
                    for(int i=0;i<10;i++){
                        w.add(new Object());
                        System.out.println("w1线程"+i);
                        //当size等于5的时候，将等待的线程唤醒
                        if(w.size()==5){
                            o.notify();
                            //当等待的线程唤醒的时候，将当前的线程进入等待
                            try {
                                o.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }
            }
        },"w1").start();





    }


}
