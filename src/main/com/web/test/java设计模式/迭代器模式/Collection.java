package com.web.test.java设计模式.迭代器模式;

/**
 * Created by Administrator on 2019/4/25 0025.
 */
public interface Collection {

    public void add(Object o);

    public int size();

    public com.web.test.java设计模式.迭代器模式.Iterator getIterator();
}
