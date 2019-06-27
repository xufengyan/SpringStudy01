package com.web.test.java设计模式.责任链模式;

/**
 * Created by Administrator on 2019/4/24 0024.
 */
public class MasProcessor {


    //将所有继承了Filter类方法的类放一个数组里面
    Filter [] filters={new disposeHTML(),new sensitiveFilter()};



    /**
     * 对消息进行处理，再返回
     * @param str
     * @return
     */
    public String process(String str){
        //遍历这个集合里面的类对消息进行处理
        //这个就使用了责任链模式，将所有的有关联的方法放在一起处理
        for (Filter filter:filters){
           str= filter.doFilter(str);
        }

        return str;
    }
}
