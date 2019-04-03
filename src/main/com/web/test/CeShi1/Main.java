package com.web.test.CeShi1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2019/3/9 0009.
 */
public class Main {

    public static void main(String [] args){


        //在bean容器创建的时候就初始化好了bean容器中所有的bean
        ClassPathXmlApplicationContext bean=new ClassPathXmlApplicationContext("resources/applicationContext2.xml");

        Car car= (Car) bean.getBean("car");
        System.out.println(car);
//        销毁bean
        bean.close();

    }

}
