package com.web.test.java设计模式.迭代器模式;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.sun.tools.internal.ws.wsdl.document.soap.SOAPUse;

/**
 * Created by Administrator on 2019/4/25 0025.
 */
public class Test {

    public static void main(String [] args){

    Collection c=new LinkedList();


    for(int i=0;i<15;i++){
        c.add("I:"+i);
    }

        System.out.println(c.size());

        Iterator iterator=c.getIterator();

        while (iterator.hashNext()){
            System.out.println(iterator.Next());
        }

    }


}
