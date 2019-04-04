package com.web.test.ThreadAndRunnable.TreadLocal07;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2019/4/4 0004.
 */
public class queueDome1 {


    /**
     * 使用队列
     */
    static Queue<String> queueList=new ConcurrentLinkedDeque();


    static {
        for(int i=1;i<101;i++){
            //使用queue添加数据
        queueList.add("车票"+i);

        }
    }

    public static void main(String [] args){

        for(int i=0;i<10;i++){

            new Thread(()->{
                while (true){
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    String s=queueList.poll();

                    if(s==null) break;

                    System.out.println("销售了："+s);
                }

            },"queue").start();

        }

    }








}
