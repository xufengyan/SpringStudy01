package com.web.test.ThreadAndRunnable.线程池;

import java.util.concurrent.Executor;

/**
 * Created by Administrator on 2019/4/22 0022.
 */
//实现Executor接口
public class T_01Executor implements Executor{

    public static void main(String [] args){


       new T_01Executor().execute(()->{
           System.out.println("出来吧，神奇宝贝");
       });



    }


//    实现execute方法 这个方法类似一个启动方法
    @Override
    public void execute(Runnable command) {


         command.run();
    }
    //执行器




}
