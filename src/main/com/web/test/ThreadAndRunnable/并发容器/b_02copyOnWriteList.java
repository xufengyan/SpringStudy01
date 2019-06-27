package com.web.test.ThreadAndRunnable.并发容器;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Administrator on 2019/4/18 0018.
 */
public class b_02copyOnWriteList {



    public static void main(String [] args){
            List list =new
//            Vector();//读写都加锁

            ArrayList();//会出现并发问题

//            CopyOnWriteArrayList();//写的时候会再复制一遍，写的效率很低，但读的时候不用加锁，效率高

            Random random=new Random();

            //初始化100个线程
            Thread [] ths=new Thread[100];


            for(int i=0;i<ths.length;i++){

                Runnable runnable =new Runnable() {
                    @Override
                    public void run() {
                        for(int j=0;j<10000;j++){
                            list.add("a"+random.nextInt(10000));
                        }
                    }
                };

            ths[i] =new Thread(runnable);

            }

    }












}
