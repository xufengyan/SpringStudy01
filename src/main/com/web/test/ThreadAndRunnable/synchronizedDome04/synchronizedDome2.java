package com.web.test.ThreadAndRunnable.synchronizedDome04;

/**
 * Created by Administrator on 2019/3/15 0015.
 */
public class synchronizedDome2 implements Runnable{

    private  int count=10;




    @Override
    public /*synchronized*/ void run() {
        //当在方法前面加上synchronized的时候，这个方法就必须在一个线程执行完成之后下一个线程才能执行
        count++;
        System.out.println("线程："+Thread.currentThread().getName()+"，count：-----"+count);

    }


    public static void main(String [] args){

        synchronizedDome2 s=new synchronizedDome2();

        for(int i=0;i<5;i++){
            new Thread(s,"Thread"+i).start();
        }
    }



}
