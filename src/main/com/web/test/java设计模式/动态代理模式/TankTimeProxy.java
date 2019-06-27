package com.web.test.java设计模式.动态代理模式;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

/**
 * Created by Administrator on 2019/4/30 0030.
 */
public class TankTimeProxy implements Moveable{

    TankTimeProxy(Moveable t){
        this.t=t;
    }

    Moveable t;


    @Override
    public void move() {
        long start = System.currentTimeMillis();
        System.out.println("开始时间"+start);
        t.move();
        long end = System.currentTimeMillis();
        System.out.println("方法运行时间："+(end-start));
    }
}
