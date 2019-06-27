package com.web.test.ThreadAndRunnable.并发容器;

import com.sun.org.apache.xerces.internal.xs.LSInputList;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2019/4/18 0018.
 */
public class b_03synchronizedList {


    //一个普通的list集合
    List list=new ArrayList();

    //将一个普通list集合传入到synchronizedList里面会返回加了锁的lsit
    List syncList= Collections.synchronizedList(list);








}
