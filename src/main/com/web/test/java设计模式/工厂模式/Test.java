package com.web.test.java设计模式.工厂模式;

/**
 * Created by Administrator on 2019/4/29 0029.
 */
public class Test {

    public static void main(String  []  args){



         Car car=Car.getcar();
         Car car1=Car.getcar();
         //不管调用多少次getCar 始终都只有一个对象，这个就是单利模式
         if(car == car1){
             System.out.println("都是同名一个对象");
         }
         car.run();



        //将使用的放都定义到接口中
         Moveable m=Car.getcar();
         m.run();



         //将创建对象的工作都交给刚给工厂，我们只需要指定是哪个工厂
        VihecleFactory factory=new PlaneFactory();

        Moveable Planem = factory.factoryCreate();

        Planem.run();
    }

}
