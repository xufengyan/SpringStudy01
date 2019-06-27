package com.web.test.懒汉饿汉模式多线程优化;

/**
 * Created by Administrator on 2019/6/14 0014.
 */
public class Singleton {

    private Singleton(){}

    private static Singleton instance=null;

    /**
     * 懒汉模式
     * @return
     */
    public Singleton getInstance() {

        if(instance==null){
            synchronized(this) {
                instance= new Singleton();
            }
        }
        return instance;
    }

}


/**
 * 饿汉模式
 */
class Singleton2 {

    private Singleton2(){}

    private static Singleton2 instance=new Singleton2();

    public Singleton2 getInstance(){
        return instance;
    }

}
