package com.web.test.ThreadAndRunnable.ReentrantLook05;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2019/3/29 0029.
 */
public class reentrantLockDome05<T> {

    /**
     * 面试题，在一个固定的容量的同步容器中，里面有get（），put（），count（）方法，、
     * 实现两个生产和10个消费者的阻塞问题
     */

    /**
     * 方法二：使用ReentrantLock中的condition可以精确指定要唤醒的方法和要等待的方法
     */
    final private LinkedList<T> lists=new LinkedList();

    final private int MAX=10;

    private int count = 0;

    private ReentrantLock lock = new ReentrantLock();

    private Condition production = lock.newCondition();

    private Condition consumption = lock.newCondition();


    public void put(T t){//生产者

        try {

            lock.lock();

            while (lists.size()==MAX){//判断容器中的容量是否到最大值

                production.await();//如果到最大值，就让消费者线下进入等待

            }

            lists.add(t);

            ++count;
            System.out.println("put---"+count);
            consumption.signalAll();//唤醒所有消费者线程
        }catch (Exception e){

            System.out.println(e);

        }finally {

            lock.unlock();

        }

    }


    public T get(){//消费者线程

        T t=null;
        try {
            lock.lock();
            while (lists.size()==0){//判断当前容器是否为0

                consumption.await();

            }
            t= lists.removeFirst();
            --count;
            System.out.println("get---"+count);
            production.signalAll();//唤醒所有生产者线程
        }catch (Exception e){

            System.out.println(e);

        }finally {
            lock.unlock();
        }
        return t;
    }


    public static void main(String [] args){

        reentrantLockDome05<String> r=new reentrantLockDome05();

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
