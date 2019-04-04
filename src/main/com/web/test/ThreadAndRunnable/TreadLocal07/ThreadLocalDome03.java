package com.web.test.ThreadAndRunnable.TreadLocal07;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2019/4/3 0003.
 */
public class ThreadLocalDome03 {

    /**
     * 实现一个买票的小程序-----------
     * 实时监控票的剩余量
     */





//    使用list集合去保存车票，没有任何的线程安全
//    static List<String> list=new ArrayList<>();

     /*
    static {
//        初始一万张票
        for (int i = 1; i < 10001; i++) {
            list.add("车票：" + i);
        }

    }
    */



     /*

//    使用vector来存放车票------vector保证了数据的原子性和可见性
    static Vector vector=new Vector();


    static {
//        初始一万张票
        for (int i = 1; i <101; i++) {
            vector.add("车票：" + i);
        }

    }
    */



     //使用synchronized同步锁来实现线程安全


        static List<String> list=new ArrayList<>();


    static {
//        初始一万张票
        for (int i = 1; i < 51; i++) {
            list.add("车票：" + i);
        }

    }







    public static void main(String [] args){

        /*
        // list  启动十个线程去买票
        //不使用线程安全的时候，当票卖完了，当前一个线程进来的买完最后一张票，后一个线程进来买票，发现没有了，就会出现异常
        for(int i=0;i<10;i++){
            new Thread(()->{
                while (list.size()>0){
                    System.out.println(list.remove(0));
                }

            },"t1").start();

        }
        */






        /*

        //vector 启动十个线程去买票

        //使用vector数组存储数据，保证了数据的线程安全

        for(int i=0;i<10;i++){
            new Thread(()->{
                //当使用了vector数组的时候，程序能够正常运行，
                while (vector.size()>0){
                    // 但是当线程在买票的中途出现了停顿，还是会出现票买完了，还有线程继续执行的买票

//                    也就是虽然vector的方法具有原子性，但是判断和中途出现的一些问题是不具有原子性的
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("买了->"+vector.remove(0));
                }

            },"t1").start();

        }

        */




        // list  启动十个线程去买票
        //使用synchronized锁住方法块，可以实现线程安全，并保证票的正常
        //但是这样效率明显不高
        for(int i=0;i<10;i++){
            new Thread(()->{
                while (true){
                    synchronized (list){
                        if(list.size()<=0) break;
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("买了——>"+list.remove(0));
                    }
                }
            },"t1").start();
        }



    }
















}
