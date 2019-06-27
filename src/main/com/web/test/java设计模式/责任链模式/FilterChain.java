package com.web.test.java设计模式.责任链模式;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/4/24 0024.
 */
public class FilterChain implements Filter{

    //定义一个集合，用来存放定义的校验规则
     List<Filter> list=new ArrayList<Filter>();

    int index=0;
    /**
     * 将校验规则放进list集合中
     * @param filter
     * @return 返回当前的类
     */
    public FilterChain addFilter(Filter filter){
         list.add(filter);
         return this;
     }


    /**
     * 将存放的校验规则对消息进行校验
     * @param str
     * @return
     */
    @Override
    public String doFilter(String str) {

        for (Filter filter:list){

           str =  filter.doFilter(str);

        }

        return str;
    }

    /**
     * 处理前段发送的消息，和处理返回的消息
     * @param request 前端接收的消息
     * @param response 返回处理的消息
     */
    @Override
    public void doNewFilter(Request request, Response response,FilterChain chain) {
        if(index==list.size()){
        return;
        }
        Filter f=list.get(index);
        index++;
        f.doNewFilter(request,response,chain);


    }
}
