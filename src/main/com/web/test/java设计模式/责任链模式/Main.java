package web.test.java设计模式.责任链模式;

import io.netty.channel.nio.NioEventLoop;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/4/24 0024.
 */
public class Main {

    public static void main(String [] args){
        //java设计模式之      责任链模式-------

        //案例---------假如一个类似论坛的网站，可以发表文章，评论，后台可能要对一些敏感字眼做处理

        String str="学习设计模式<script>（.*,使我快乐,敏感";
//
//        MasProcessor mas=new MasProcessor();
//
//        System.out.println(mas.process(str));
//

//        FilterChain filterChain=new FilterChain();
//
//        filterChain.addFilter(new disposeHTML());
//
//        //当需要增加新的时候 创建一个新的对象
//        FilterChain fc=new FilterChain();
////        将新的规则加入到对象中
//        fc.addFilter(new sensitiveFilter());
////        将新的校验对象放入到最开始的校验对象中
//        filterChain.addFilter(fc);
//
//
//        System.out.println(filterChain.doFilter(str));


//        NioEventLoop

        System.out.println("-----------------------------------------------------------------------------");


        Request request=new Request();
        Response response=new Response();
        //假设这里是前台接收的参数
        request.setRequestStr(str);
        //后端返回的参数
        response.setResponse(str);

        FilterChain fc2=new FilterChain();

        fc2.addFilter(new disposeHTML())
                .addFilter(new sensitiveFilter());

        fc2.doNewFilter(request,response,fc2);

        System.out.println(request.getRequestStr());

        System.out.println(response.getResponse());


    }

}
