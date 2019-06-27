package com.web.test.java设计模式.迭代器模式;


/**
 * Created by Administrator on 2019/4/25 0025.
 */
public class ArrayList implements Collection {
    /**
     *
     * 模仿JDK的ArrayList 写一个集合容器
     * 拥有添加元素，查看元素个数的方法
     */

    Object [] objects=new Object[10];

    int size=0;

    @Override
    public void add(Object o) {

        //判断容器容量是否到达最大值 对这个容器进行扩容
        if(size==objects.length){

            Object [] newObjject=new Object[objects.length*2];

            System.arraycopy(objects,0,newObjject,0,objects.length);

            objects=newObjject;
        }
        objects[size]=o;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator getIterator() {

        return  new ArrayListIterator();
    }




    private class ArrayListIterator implements Iterator{

       private int countIndex=0;

       @Override
       public Boolean hashNext() {
           if(countIndex>=size) return false;
           else return true;
       }

       @Override
       public Object Next() {
           Object o=objects[countIndex];
           countIndex++;
           return o;
       }
   }

}
