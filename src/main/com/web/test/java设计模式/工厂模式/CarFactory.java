package com.web.test.java设计模式.工厂模式;

/**
 * Created by Administrator on 2019/4/29 0029.
 */
public class CarFactory extends VihecleFactory {

    //生产汽车的工厂类
    @Override
    Car factoryCreate() {
        return Car.getcar();
    }




}
