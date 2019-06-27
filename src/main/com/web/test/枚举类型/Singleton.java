package com.web.test.枚举类型;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * Created by Administrator on 2019/6/15 0015.
 */
public class Singleton {

    private enum singletonEnum{
        RED(1,"红色"),yellow(2,"黄色");

        private int value;
        private String label;


        singletonEnum(int value, String label) {
            this.value=value;
            this.label=label;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }
    }


    public static void main(String [] args){

        singletonEnum []s = singletonEnum.values();

        for(int i=0;i<s.length;i++){

            System.out.println("value:"+s[i].getValue()+"-------label:"+s[i].getLabel());

        }

        System.out.println("value:"+singletonEnum.RED.getValue()+"-----label："+singletonEnum.RED.getLabel());


    }
}
