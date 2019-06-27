package com.web.test.java设计模式.动态代理模式;

/**
 * Created by Administrator on 2019/4/30 0030.
 */
public class Test {


    public static void  main(String [] args){


        Tank t=new Tank();

//        使用动态代理模式

//        将要执行的对象交由其他方法区代理运行，可以在这个方法运行的时候做类似与Spring AOP原理的一些方法

        TankTimeProxy ttp=new TankTimeProxy(t);

        TankLogProxy tlp=new TankLogProxy(ttp);

        Moveable m=tlp;

        m.move();


    }


}
