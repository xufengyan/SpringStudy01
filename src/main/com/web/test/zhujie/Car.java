package com.web.test.zhujie;

/**
 * Created by Administrator on 2019/3/9 0009.
 */
public class Car {

   private String carName;
   private Double price;

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carName='" + carName + '\'' +
                ", price=" + price +"1111"+
                '}';
    }
}
