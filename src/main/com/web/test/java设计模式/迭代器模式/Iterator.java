package com.web.test.java设计模式.迭代器模式;

/**
 * Created by Administrator on 2019/4/25 0025.
 */
public interface Iterator {
    //iterator 迭代器

    //判断数据是否存在
    Boolean hashNext();

    //获取下一个元素
    Object Next();

}
