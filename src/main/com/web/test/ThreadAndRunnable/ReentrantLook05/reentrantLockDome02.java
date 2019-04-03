package com.web.test.ThreadAndRunnable.ReentrantLook05;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2019/3/28 0028.
 */
public class reentrantLockDome02 {



    Lock lock=new ReentrantLock();

    public void r1(){
        /**
         * 使用ReentrantLook必须手动释放锁
         * synchronized在遇到异常的时候会将锁释放，当ReentrantLook不会，他必须手动释放
         * 所以在做异常处理的时候必须在finally里面释放锁
         */
        try {
            //锁定方法
            lock.lock();
            for (int i=0;i<10;i++){
                System.out.println("r1--------"+i);
                TimeUnit.SECONDS.sleep(1);
            }
        }catch (Exception e){
            System.out.println(e);
        }finally {
            //释放锁
            lock.unlock();
        }


    }



    public void r2(){

        //尝试请求锁，不管请求失败或者成功都会执行
        boolean locked=lock.tryLock();
        System.out.println("r2---------启动");

        //判断锁是否请求成功成功后要释放锁，不成功则不执行
        if(locked){
            lock.unlock();
        }

    }


    public static void main(String [] args){

        reentrantLockDome02 r=new reentrantLockDome02();

        new Thread(r::r1,"r1").start();

        new Thread(r::r2,"r2").start();

    }


}
