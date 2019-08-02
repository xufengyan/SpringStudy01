package com.web.test.nio;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2019/7/2 0002.
 */
public class server {



    public static void serverTest2(){
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        ServerSocketChannel serverSocketChannel = null;
        try
        {
            serverSocketChannel = ServerSocketChannel.open();

            //将socket设置为阻塞状态
            serverSocketChannel.configureBlocking(false);
            //设置端口
            serverSocketChannel.socket().bind(new InetSocketAddress(8888));

            System.out.println(serverSocketChannel.getLocalAddress());

            System.out.println("服务器已启动。。。。。。");
            //当没有注册事件进来的时候将会一直阻塞在这里（没有使用selector的时候）,
            SocketChannel channel=null;

            while (true){
                     //不断监听有没有注册事件进来
                     channel=serverSocketChannel.accept();

                     if(channel!=null) {

                         //判断是否建立连接
                         while (channel.finishConnect()){

                             buffer.clear();

                             channel.read(buffer);

                             byte[] data = buffer.array();

                             String msg = new String(data).trim();

                             System.out.println("客户端数据" + msg);
                         }


                     }


                }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocketChannel != null) {
                    serverSocketChannel.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String [] args){

        serverTest2();
    }

}
