package com.web.test.ThreadAndRunnable.synchronizedDome04;

/**
 * Created by Administrator on 2019/3/15 0015.
 */


import com.web.test.ThreadAndRunnable.ThreadRunnbale01.RunnbaleDome;

/**
 * 死锁
 */
public class synchronizedDome3 {

    private Object o1=new Object();

    private Object o2=new Object();
    public void A1(){
        System.out.println("11111");
        synchronized (o1){
            System.out.println("----------锁1");
            synchronized (o2){
                try {
                    Thread.sleep(5000);
                }catch (Exception e){

                }
                System.out.println("----------锁2");

            }

        }


    }



    public void  A2(){
        System.out.println("22222");

        synchronized (o2){
            System.out.println("-------锁3");
            synchronized (o1){
                try {
                    Thread.sleep(2000);
                }catch (Exception e){
                }
                System.out.println("----------锁4");

            }

        }
    }


    /**
     * 死锁代码测试
     * @param args
     */
    public static void main(String [] args){

        final synchronizedDome3 s=new synchronizedDome3();

        final synchronizedDome3 s1=new synchronizedDome3();

        Runnable r=new RunnbaleDome(){
            @Override
            public void run() {
                s.A1();
            }
        };

        Runnable r2=new RunnbaleDome(){
            @Override
            public void run() {
                s.A2();
            }
        };
        new Thread(r,"s").start();
        new Thread(r2,"s1").start();

    }

}
