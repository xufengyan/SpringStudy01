package web.test.Netty学习;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.AttributeKey;

/**
 * Created by Administrator on 2019/7/10 0010.
 */
public class NettyServer {


        public static void main(String [] args) throws InterruptedException {

            ServerBootstrap server = new ServerBootstrap();

//            NioEventLoop
            EventLoopGroup parentGroup = new NioEventLoopGroup();
            EventLoopGroup childGroup = new NioEventLoopGroup();

            //第1步定义两个线程组，用来处理客户端通道的accept和读写事件
            //parentGroup用来处理accept连接事件，childgroup用来处理通道的读写事件
            //parentGroup获取客户端连接，连接接收到之后再将连接转发给childgroup去处理
            server.group(parentGroup, childGroup)
                    .channel(NioServerSocketChannel.class)//绑定服务端通道，
                    // 在该配置中通过this.config = new NioServerSocketChannel.NioServerSocketChannelConfig(this, this.javaChannel().socket());
                    //创建Tcp参数类
                    //super() 通过父类的构造方法设置为非阻塞模式
                    .childOption(ChannelOption.TCP_NODELAY,true)//方法可以给每条连接设置一些TCP底层相关的属性
                    //给childOption和childAttr设置自定义的一些属性，其实就是给服务端一个维护的map，
                    .childAttr(AttributeKey.newInstance("childAttr"),
                            "NettyServer")//可以通过childAttr 给每一条连接设置自定义属性
                    .handler(new ChannelInitializer<NioServerSocketChannel>() {
                        @Override
                        protected void initChannel(NioServerSocketChannel nioServerSocketChannel) throws Exception {
                            System.out.println("服务器启动中");
                        }
                    })//用于指定服务端在启动过程中的一些逻辑
                    .childHandler(new ChannelInitializer<NioSocketChannel>() {

                        @Override
                        protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {

                        }
                    });//就是定义每条连接的数据读写、业务处理逻辑

                    //初始化端口
                    server.bind(8090).sync();


        }





}
