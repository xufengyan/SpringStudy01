package com.web.test.ThreadAndRunnable.并发容器;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Administrator on 2019/4/22 0022.
 */
public class b_06ArrayBlockingQueue {

    static BlockingQueue arrQueue=new ArrayBlockingQueue(10);//有界队列-----设置队列的大小，超过这个队列的大小数据就放不进去了

    public static void main(String [] args) throws InterruptedException {


        //将这个有界队列放满
        for(int i=0;i<10;i++){
                arrQueue.put("q"+i);
        }

//        arrQueue.add("11111");//当应add向已满的队列中添加元素的时候，会抛出异常

//        arrQueue.put("11111");//队列满了再添加会阻塞

//        arrQueue.offer("fff");//放向已满的队列中添加元素的时候不会抛异常，但会返回一个bool类型的值，用来判断是否添加成功


        System.out.println(arrQueue);




    }






}
