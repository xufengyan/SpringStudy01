package com.web.test.懒汉饿汉模式多线程优化;

/**
 * Created by Administrator on 2019/6/14 0014.
 */
public class recursive {


    public int get(int a){
        if(a==0){
            return a;
        }
        return a+get(a-1);
    }

    public  static void main(String [] args){

        recursive recursive=new recursive();

        System.out.println(recursive.get(100));


    }


}
