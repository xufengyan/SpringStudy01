package com.web.test.CeShi1;

/**
 * Created by Administrator on 2019/3/9 0009.
 */
public class Car {
    private  String carName;

    private  double price;

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Car{" +
                "carName='" + carName + '\'' +
                ", price=" + price +
                '}';
    }

    public void init(){
        System.out.println("初始化bean");
    }


    public void destory(){


        System.out.println("销毁bean");
    }
}
