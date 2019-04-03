package com.web.test.HolleWorld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Author: XuFeng
 * @CreationTime: 2019/3/7 0007 09:16
 */
public class Main {

    public static void main(String [] args) throws SQLException {

        /**
        HolleWorld holleWorld=new HolleWorld();
        //可以将创建对象的事交给spring去管理也就是Spring的IOC控制反转
        holleWorld.setName("xufeng");
        holleWorld.holleWorld();
         **/


        //1. 创建Spring的Ioc容器对象
        //ApplicationContext实际上就是一个IOC容器
        //ClassPathXmlApplicationContext 是applicationContex接口的实现类，通过类路径下进行加载文件
        ApplicationContext applicationContext=
                new ClassPathXmlApplicationContext("resources/applicationContext.xml");

        //2.从Ioc中取出bean实例
        //利用类型 （id 唯一标识）返回Ioc容器中的bean，Ioc容器中只能有一个该类型的bean
        HolleWorld holleWorld= (HolleWorld) applicationContext.getBean("holleWorld");

        holleWorld.holleWorld();

        Car car=(Car) applicationContext.getBean("car");

        System.out.println(car);

        Car car1=(Car) applicationContext.getBean("carTwo");

        System.out.println(car1);


        /**
         * 测试连接数据库
         */
        DataSource dataSource= (DataSource) applicationContext.getBean("dataSource");
        System.out.println(dataSource.getConnection());


    }

}
