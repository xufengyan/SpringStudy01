package com.web.test.ThreadAndRunnable.volatileDome03;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/3/19 0019.
 */
public class volatileDome2 {

    /**
     * volatile只保证了可见性，没有保证原子性
     * 所以数据没有和预想的一样，到达10000，
     */
    volatile int count=1;
    public void m(){
        for(int i=0;i<1000;i++){
        count++;
        }
    }


    public static void main(String [] args){

        final volatileDome2 v=new volatileDome2();
        List<Thread> list=new ArrayList<>();

        for(int i=0;i<10;i++){
        list.add(new Thread(v::m,"v"+i));
        }

        for (Thread t:list){
            t.start();
        }
        try {
            for (Thread t:list){
                t.join();
            }
        }catch (Exception e){

        }

        System.out.println(v.count);

    }


}
