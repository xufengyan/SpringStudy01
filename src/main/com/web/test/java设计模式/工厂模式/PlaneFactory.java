package com.web.test.java设计模式.工厂模式;

/**
 * Created by Administrator on 2019/4/29 0029.
 */
public class PlaneFactory extends VihecleFactory{
    @Override
    Plane factoryCreate() {
        return new Plane();
    }
}
