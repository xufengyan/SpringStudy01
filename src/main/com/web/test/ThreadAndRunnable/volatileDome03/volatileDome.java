package com.web.test.ThreadAndRunnable.volatileDome03;

/**
 * Created by Administrator on 2019/3/19 0019.
 */
public class volatileDome {

    //当这个变量没有加volatile关键字的时候，即使在别的线程中更改了值，还是不会停止死循环
//    boolean running=true;

    volatile boolean running=true;

    public void m(){
        System.out.println("strot-----");
        while (running){

        }
        System.out.println("end--------");
    }


    public static void main(String [] args){
        final volatileDome v=new volatileDome();

        Runnable r=new Runnable() {
            @Override
            public void run() {
                v.m();
            }
        };
        new Thread(r,"volatile").start();

        try {
            Thread.sleep(1000);
        }catch (Exception e){
        }
        //变更属性的值
        v.running=false;

    }
}
