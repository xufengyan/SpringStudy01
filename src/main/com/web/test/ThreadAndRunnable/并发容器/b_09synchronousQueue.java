package com.web.test.ThreadAndRunnable.并发容器;

import sun.java2d.loops.TransformHelper;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by Administrator on 2019/4/22 0022.
 */
public class b_09synchronousQueue {
    //容量为0，必须先有线程过来等着使用，不然会发生线程阻塞

    public static void main(String [] args) throws InterruptedException {

        BlockingQueue syncQueue=new SynchronousQueue();//也是一个阻塞队列

        new Thread(()->{

            try {
                syncQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"消费").start();


        syncQueue.put("aaa");//当前面没有消费线程等待消费的时候会发生线程阻塞


        System.out.println(syncQueue.size());



    }





}
