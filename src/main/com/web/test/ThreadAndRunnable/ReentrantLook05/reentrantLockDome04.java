package com.web.test.ThreadAndRunnable.ReentrantLook05;

import java.util.LinkedList;

/**
 * Created by Administrator on 2019/3/28 0028.
 */
public class reentrantLockDome04<T> {
    /**
     * 面试题，在一个固定的容量的同步容器中，里面有get（），put（），count（）方法，、
     * 实现两个生产和10个消费者的阻塞问题
     */

    final private LinkedList<T> list=new LinkedList<>();

    final private int MAX=10;

    private int count=0;


    public synchronized void put(T t){

        while (list.size()==MAX){//判断当前数组的容量有没有到最大值，如果到最大值就让这线程进行等待
            //为什么这里用while而不用if
//            if只会判断一次，while会重复再判断一次，防止其他线程进来添加了数据，而当前线程又添加
//            所以wait()一般和while()一起使用
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        list.add(t);
        ++count;
        System.out.println("put"+count);
        this.notifyAll();//用notifyAll的原因是唤醒所有等待的线程
//        而使用notify可能唤醒的不是消费线程，二唤醒生产线程，而导致线程执行不下去
    }



    public  synchronized T get(){

        T t=null;
        while (list.size()==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        t = list.removeFirst();

        --count;
        System.out.println("get"+count);
        this.notifyAll();
        return t;
    }


    public static void main(String [] args){

        reentrantLockDome04<String> r=new reentrantLockDome04();

        //启动消费者线程
        for(int i=0;i<10;i++){
        new Thread(()->{
            for(int j=0;j<5;j++){
                System.out.println(""+r.get());
            }
        },"get---"+i).start();
        }

        //启动生产者线程
        for(int i=0;i<2;i++){
            new Thread(()->{
                for(int j=0;j<25;j++){
                r.put(Thread.currentThread().getName()+"-"+j);
                }
            },"put---"+i).start();

        }



    }


}
