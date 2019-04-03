package com.web.test.ThreadAndRunnable.atomicIntager06;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2019/3/19 0019.
 */
public class AtomicIntage {

    //原子类
    AtomicInteger atomicInteger =new AtomicInteger();

    public void getAtomic(){
        for (int i=0;i<1000;i++){
            //if(atomicInteger.get()==1000)//AtomicInteger写入if判断当中去的时候，原子性就将不存在
            atomicInteger.incrementAndGet();//自加
        }

    }


    public static void main(String [] args){

        AtomicIntage a=new AtomicIntage();
        List<Thread> list = new ArrayList<>();

        for(int i=0;i<10;i++){

        list.add(new Thread(a::getAtomic,"atomicinteger"+i));

        }

        for(Thread t:list){
            //启动线程
            t.start();
        }
        try {
            for (Thread t:list){
                t.join();
            }
        }catch (Exception e){

        }

        System.out.println(a.atomicInteger);

    }


}
