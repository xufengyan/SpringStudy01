package com.web.test.ThreadAndRunnable.notifywait02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2019/3/27 0027.
 */
public class CountDownLatchDome {

    /**
     * 实现一个线程在list集合中循环添加10个对象当添加到第五个的时候 启动另一个线程获取list.size()=5
     *
     * 使用CountDownLatch（门栓）来解决
     */

    List list=new ArrayList();

    public void add(Object o){
        list.add(o);
    }

    public int size(){

        return list.size();
    }


    public static void main(String [] args){

        CountDownLatchDome c=new CountDownLatchDome();

        CountDownLatch latch=new CountDownLatch(1);

        new Thread(() -> {
            System.out.println("c1启动");
            if(c.size()!=5){
                try {
                    //当size不等于5的时候给线程加上门栓
                    System.out.println("c1线程等待");
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("c1线程结束");

        },"c1").start();



        new Thread(() -> {
            System.out.println("c2启动");
           for(int i=0;i<10;i++){
               c.add(new Object());
               try {
                   TimeUnit.SECONDS.sleep(2);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println("c2线程"+i);
               if(c.size()==5){
                   System.out.println("122");
                   latch.countDown();
               }
           }

        },"c2").start();

    }


}