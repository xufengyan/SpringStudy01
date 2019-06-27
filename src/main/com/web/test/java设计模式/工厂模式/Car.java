package com.web.test.java设计模式.工厂模式;

import org.apache.tools.ant.taskdefs.Move;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2019/4/29 0029.
 */
public class Car implements Moveable{

    //创建一次
    private  static Car car=new Car();

    //将构造方法私有化，不能直接New出来
    private Car(){}


    public void run(){
        System.out.println("老张只有一辆车去东北了");
    }


    //提供一个方法让别的对象只能获取一个对象

    //这里使用了工厂模式和单利模式，用户不管怎么样始终只能获取一个对象

    //控制了对象产生的相关逻辑，都称之为工厂相关的方法
    public static Car getcar(){

        return car;

    }

}
