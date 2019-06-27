package com.web.test.java设计模式.策略模式;

/**
 * Created by Administrator on 2019/4/28 0028.
 */
public class sortHeight implements  compareor{


    @Override
    public int compar(Object o,Object o1) {
        Cat c1=(Cat) o;
        Cat c2=(Cat) o1;

        if(c1.getHeight()>c2.getHeight()){
            return 1;
        }else if(c1.getHeight()<c2.getHeight()){
            return -1;
        }

        return 0;
    }
}
