package com.web.test.java设计模式.策略模式;

/**
 * Created by Administrator on 2019/4/28 0028.
 */
public class Test {

    public static void main(String [] args){

        Cat [] cats={new Cat(3,3),new Cat(1,1),new Cat(2,2)};

        DataStore d=new DataStore();

        d.sort(cats);

        System.out.println(cats);
    }


}
