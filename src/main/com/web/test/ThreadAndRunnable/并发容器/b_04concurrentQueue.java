package com.web.test.ThreadAndRunnable.并发容器;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by Administrator on 2019/4/18 0018.
 */
public class b_04concurrentQueue {



    public static void main(String [] args){


    Queue<String> queue=new ConcurrentLinkedDeque<>();//·内部加锁的队列

    for(int i=0;i<10;i++){

     queue.offer("qu"+i);//offer和add一样是往数组里面加数据，但是用offer添加数据会返回bool类型的参数，判断数据是否添加成功

    }

        System.out.println(queue);
        System.out.println(queue.size());

        System.out.println(queue.poll());//取出第一个数值,并将这个值从队列里面删除
        System.out.println(queue.size());

        System.out.println(queue.peek());//取出这个值，不会对这个值进行删除
        System.out.println(queue.size());
    }





}
