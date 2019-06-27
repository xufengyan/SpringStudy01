package com.web.test.Tcp_Socket学习;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.UnknownHostException;

/**
 * @Author: LiXiang
 * @Description :
 * @Date: Created in 2019-05-29 9:17
 */
public class TCPSocketDemo {



}

class TcpServer {

    public static void main(String[] args) throws IOException {
        System.out.println("socket tcp服务器端启动....");

        // 1.给socket绑定一个端口，使用bind函数 赋予 ip和端口
        // 2.监听此端口(list函数)，当客户端发来一个网络包请求时，内核需要通过此端口找到你的应用程序；这里没有写监听ip，即监听所有网卡
        // 3.此时内核会创建两个队列，一个队列存储已经完成 3次握手的（est状态），一个队列存储未完全连接的（syn状态）
        ServerSocket serverSocket = new ServerSocket(8080);//监听socket

        // 4.服务端调用accept函数，取出一个已经完成连接的连接，如果未完成连接则等待（阻塞）
        // 6.所以你要知道，上一个socket是监听socket，这个socket才是传输数据的socket
        Socket accept = serverSocket.accept();//已连接socket

        // 7.文件流读写数据

        InputStream inputStream = accept.getInputStream();
        // 转换成string类型
        byte[] buf = new byte[1024];
        int len = inputStream.read(buf);
        String str = new String(buf, 0, len);
        System.out.println("服务器接受客户端内容:" + str);
        serverSocket.close();
    }
}

class TcpClient {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("socket tcp 客户端启动....");

        // 5.客户端在服务端调用 accept函数后，调用 connect函数发起连接
        //      ①在函数中指定 IP和端口，然后发起三次握手
        //      ②服务端内核给客户端分配一个临时的端口，一旦握手成功服务端的accept函数就会返回一个Socket
        Socket socket = new Socket("127.0.0.1", 8080);


        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("简单".getBytes());
        socket.close();
    }
}