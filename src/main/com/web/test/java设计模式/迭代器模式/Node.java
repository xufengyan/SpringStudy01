package com.web.test.java设计模式.迭代器模式;

/**
 * Created by Administrator on 2019/4/25 0025.
 */
public class Node {
    //用来保存数据的
    private  Object data;

    //用来指向下一个元素位置的
    private Node next;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }
}
