package com.web.test.java设计模式.策略模式;


/**
 * Created by Administrator on 2019/4/28 0028.
 */
public class DataStore {


    public void sort(Object [] o){

        for(int i=0;i<o.length-1;i++){
            for(int j=0;j<o.length-1-i;j++){
                compareble o1=(compareble) o[j];
                compareble o2=(compareble) o[j+1];
                if(o1.compareTo(o2)==1){
                    exchange(o,j,j+1);
                }
            }
        }
    }




    public void exchange(Object [] o,int x,int y){
        Object o1=o[x];
        o[x]=o[y];
        o[y]=o1;
    }

}
