package com.web.test.java设计模式.动态代理模式;

import com.sun.tools.internal.ws.wsdl.document.soap.SOAPUse;

/**
 * Created by Administrator on 2019/4/30 0030.
 */
public class TankLogProxy implements Moveable{

//    在创建这个对象的时候传入要代理的对象，
//    被代理的对象都实现了Moveable接口

    TankLogProxy(Moveable m){
        this.m=m;
    }

    Moveable m ;

    @Override
    public void move() {

        System.out.println("坦克开始启动了");
        //执行代理的方法，可以在这个方法执行的前后添加一些操作
        m.move();

        System.out.println("坦克运行时间结束了");

    }
}
