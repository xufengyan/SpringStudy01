package web.test.java设计模式.责任链模式;

/**
 * Created by Administrator on 2019/4/24 0024.
 */
public class disposeHTML implements Filter{

    @Override
    public String doFilter(String str) {

        str=str.replaceAll("<","[")
            .replaceAll(">","]");

        return str;
    }

    @Override
    public void doNewFilter(Request request, Response response,FilterChain chain) {
         request.RequestStr=request.RequestStr.replaceAll("<","[")
                 .replaceAll(">","]")+"Html()";
//         当处理完request请求后，调用doNewFilter，继续调用下一个方法对请求消息进行处理
         chain.doNewFilter(request,response,chain);
         //当doNewFilter调用return返回的时候执行返回消息处理
        response.Response=response.Response.replaceAll("<","[")
                .replaceAll(">","]")+"Html()";
    }
}
