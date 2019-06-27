package com.web.test.ThreadAndRunnable.并发容器;

import java.util.concurrent.LinkedTransferQueue;

/**
 * Created by Administrator on 2019/4/22 0022.
 */
public class b_08linkedTransferQueue {


    public static void main(String [] args) throws InterruptedException {


    LinkedTransferQueue transfer=new LinkedTransferQueue();//消费者先等待取数，等生产者生产了就直接去消费者，不需要存在队列里
    //一般用于实时消息处理


        /**
         * 消费者先进行消费，
         */
        new Thread(()->{
            try {
                transfer.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
        //生产者进行生产

        transfer.transfer("1111");//使用Transfer的transfer当在生产者之前没有消费者，会出现线程阻塞

//            transfer.add("add");
//        new Thread(()->{
//            try {
//                System.out.println( transfer.take());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        }).start();

    }




}
