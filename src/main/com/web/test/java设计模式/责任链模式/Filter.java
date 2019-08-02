package web.test.java设计模式.责任链模式;

/**
 * Created by Administrator on 2019/4/24 0024.
 */
public interface Filter {

    /**
     * 定义一个处理消息的类，要处理的消息的方法都继承这个接口
     * @return
     */
    public String doFilter(String str);

    public void doNewFilter(Request reques,Response response,FilterChain chain);

}
