package com.web.test.ThreadAndRunnable.并发容器;

import sun.rmi.runtime.Log;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;

/**
 * Created by Administrator on 2019/4/18 0018.
 */
public class b_01concurrentMap {





public static void main(String [] args){

//    Map map=new ConcurrentHashMap(); //并发的hsahMap 分段锁技术：将map容器分成很多块，对每个块进行加锁，

    Map map=new ConcurrentSkipListMap();//高并发并且排序

//    Map map =new Hashtable();//所有的方法都加了锁，效率比较低--------在put的时候是对整合map容器进行加锁

//    Map map =new HashMap<>();


    Random random=new Random();

    //初始化100个线程
    Thread [] ths=new Thread[100];

//    创建一个门闩 门闩的初始值为线程的长度
    CountDownLatch latch=new CountDownLatch(ths.length);

    long stareTime=System.currentTimeMillis();
//    启动所有线程,
    for(int i=0;i<ths.length;i++){
        //每个线程启动的时候都往map里面添加10000个数据
        ths[i]=new Thread(()->{
            for(int j=0;j<10000;j++){
                map.put(""+random.nextInt(10000),random.nextInt(10000));
            }
            //每次线程执行完毕后都将门闩减一
            latch.countDown();
        });
    }

    //启动所有线程
    Arrays.asList(ths).forEach((t)->t.start());

    try {
        latch.await();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    long end=System.currentTimeMillis();

    System.out.println(end-stareTime);

}



}
