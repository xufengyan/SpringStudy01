package com.web.test.HolleWorld;

/**
 * @Author: XuFeng
 * @CreationTime: 2019/3/7 0007 11:04
 */
public class Car {
    private String name;
    private String model;
    private Integer price;

    public Car(String name, String model) {
        this.name = name;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
