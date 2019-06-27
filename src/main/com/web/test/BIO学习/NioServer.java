package com.web.test.BIO学习;

/**
 * Created by Administrator on 2019/6/4 0004.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * nio 同步非阻塞Io，只需开启一个线程处理多个事件
 *
 * 解决方法，采用多路复用器，监听多个客户端发过来的Io消息
 */
public class NioServer {

    //创建一个通道处理器
    private Selector selector;


    /**
     * 获得serverSocket，并初始化
     * @param port
     * @throws IOException
     */
    public void initServer(int port) throws IOException{

        //获取一个serverSocket通道
        ServerSocketChannel serverChannel=ServerSocketChannel.open();

        //设置serverSocket为非阻塞
        serverChannel.configureBlocking(false);

        //将该通道对应的serverSocket绑定到port的端口
        serverChannel.socket().bind(new InetSocketAddress(port));

        //获得一个通道处理器
        this.selector=Selector.open();

        //将通道处理器和该通道绑定，并注册SelectionKey.OP_ACCEPT事件
        //当事件到达时selector.select()会继续执行，没有的话将会一直注阻塞 在这里
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);

    }


    /**
     * 循环监听selector是否有需要处理的事件，如果有就处理
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
    public void listen() throws IOException{

        System.out.println("服务器启动中。。。。。。");

        //循环访问selector，
        while (true){
            //监听注册事件，没有的话将会一直阻塞在这里
            selector.select();

            //获取selector中选中的项的迭代器，选中的项为注册事件
            Iterator ite=this.selector.selectedKeys().iterator();

            while (ite.hasNext()){

                SelectionKey key =(SelectionKey) ite.next();

                //删除已选的key，防止重复处理
                ite.remove();

                //判断客户端的连接请求
                if(key.isAcceptable()){

                    //获取到客户端连接
                    ServerSocketChannel server=(ServerSocketChannel) key.channel();

                    System.out.println("??:"+server.socket());

                    //获得和客户端的连接通道
                    SocketChannel socketChannel=server.accept();
                    //设置为非阻塞式的
                    socketChannel.configureBlocking(false);

                    socketChannel.write(ByteBuffer.wrap(new String("向客户端发送一个消息").getBytes()));

                    //在和客户端连接成功后，为了接受客户端的消息，给通道设置读的权限
                    socketChannel.register(this.selector,SelectionKey.OP_READ);

                    //获取客户端的只读事件
                }else if(key.isReadable()){

                    read(key);

                }

            }

        }

    }


    /**
     * 处理读取客户端发来的消息
     * @param key
     * @throws IOException
     */
    public void read(SelectionKey key)throws IOException{

        SocketChannel channel=(SocketChannel) key.channel();

        System.out.println("客户端："+channel.getRemoteAddress());
        //创建读取的缓冲区

        ByteBuffer buff=ByteBuffer.allocate(1024);

        channel.read(buff);

        byte [] data=buff.array();

        String msg=new String(data).trim();

        System.out.println("客户端获取的消息："+msg.toString());

        InputStreamReader sysin =new InputStreamReader(System.in);

        BufferedReader socketBuff=new BufferedReader(sysin);

        ByteBuffer outBuff=ByteBuffer.wrap(socketBuff.readLine().getBytes());

        channel.write(outBuff);//将发送数据返回客户端
    }


    /**
     * 测试
     * @param args
     * @throws IOException
     */
    public static void main(String [] args) throws IOException{

        NioServer nio=new NioServer();

        nio.initServer(8000);

        nio.listen();

    }




}
