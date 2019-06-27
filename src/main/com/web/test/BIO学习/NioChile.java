package com.web.test.BIO学习;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by Administrator on 2019/6/4 0004.
 */
public class NioChile {

    private Selector selector;

    /**
     * 初始化通道
     * @param ip
     * @param port
     */
    public void initChile(String ip,int port) throws IOException{

        //获取socket通道
        SocketChannel channel = SocketChannel.open();

        //设置通道为非阻塞的
        channel.configureBlocking(false);

        //获取一个通道处理器
        this.selector=Selector.open();

        //客户端连接服务器
        channel.connect(new InetSocketAddress(ip,port));

        //将通道管理器和该通道绑定，并注册事件
        channel.register(this.selector, SelectionKey.OP_CONNECT);

    }




    @SuppressWarnings("unchecked")
    public void listen() throws IOException{

            while(true){

                selector.select();

                //获取selector选中项的迭代器
                Iterator ite = this.selector.selectedKeys().iterator();

                while (ite.hasNext()){

                    SelectionKey key=(SelectionKey) ite.next();

                    ite.remove();

                    //判断连接事件有没有发生
                    if(key.isConnectable()){

                        SocketChannel channel=(SocketChannel) key.channel();


                        //判断是不是在连接中，是的话就连接
                        if(channel.isConnectionPending()){

                            channel.finishConnect();

                        }

                        //将通道设置为非阻塞
                        channel.configureBlocking(false);

//                        channel.write(ByteBuffer.wrap(new String("我给服务器端发送消息了").getBytes()));

                        channel.register(this.selector,SelectionKey.OP_READ);


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

        //创建读取的缓冲区

        ByteBuffer buff=ByteBuffer.allocate(1024);

        channel.read(buff);

        byte [] data=buff.array();

        String msg=new String(data).trim();

        System.out.println("获取服务器端的消息："+msg.toString());

        InputStreamReader sysin =new InputStreamReader(System.in);

        BufferedReader socketBuff=new BufferedReader(sysin);

        ByteBuffer outBuff=ByteBuffer.wrap(socketBuff.readLine().getBytes());

        channel.write(outBuff);//将客户端的数据发送回客户端
    }




    public static void main(String [] args)throws IOException{

        NioChile client = new NioChile();
        client.initChile("localhost",8000);
        client.listen();

    }



}
