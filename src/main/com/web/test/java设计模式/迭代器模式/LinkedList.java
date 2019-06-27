package com.web.test.java设计模式.迭代器模式;

import java.util.List;

/**
 * Created by Administrator on 2019/4/25 0025.
 */
public class LinkedList implements Collection {

    /**
     * 模仿LinkedList写一个链表形式的容器
     */

    //数据存放的位置
    Node head = null;

    //下一个元素的索引
    Node tail = null;


    int size=0;

    @Override
    public void add(Object o) {

        Node n=new Node(o,null);
        //判断head是否为null，为null的话说明是第一个添加的元素
        //第一次就不用指定下一个元素的索引
        if(head==null){
            head=n;
            tail=n;
        }

        tail.setNext(n);
        tail=n;
        size++;


    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator getIterator() {
        return new LinkedListIterator();
    }



    private class LinkedListIterator implements Iterator{

        private int countIndex=0;

        @Override
        public Boolean hashNext() {
            if(countIndex>=size) return false;
            else return true;
        }

        @Override
        public Object Next() {

            tail=head.getNext();

            Object o=tail.getData();

            countIndex++;

            return o;

        }
    }

}
