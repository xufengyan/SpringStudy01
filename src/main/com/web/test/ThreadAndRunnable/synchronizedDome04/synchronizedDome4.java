package com.web.test.ThreadAndRunnable.synchronizedDome04;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/3/19 0019.
 */
public class synchronizedDome4 {

    /**
     * synchronized既保证了可见性，也保证原子性
     *
     */
    int count=0;
    public synchronized void m(){
        for(int i=0;i<1000;i++){
            count++;
        }
    }


    public static void main(String [] args) throws InterruptedException {

        final synchronizedDome4 s=new synchronizedDome4();
        List<Thread> list=new ArrayList<>();

        for(int i=0;i<10;i++){
            list.add(new Thread(s::m,"s"+i));
        }

        for (Thread t:list){
            t.start();
        }
        for (Thread t:list){
            t.join();
        }
        System.out.println(s.count);

    }



}
