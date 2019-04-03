package com.web.test.hashMap;

import java.util.HashMap;

/**
 * Created by Administrator on 2019/3/11 0011.
 */
public class hashMapDome {

    public static void main(String [] args){

        HashMap<Integer,String> map=new HashMap();
        map.put(1,"jack");
        map.put(2,"tangm");
        map.put(3,"suon");
        map.put(4,"jack");
        System.out.println("hsshMap:"+"suon".hashCode()%16);
        System.out.println(map.get(4)+map.get(1));

    }


}
