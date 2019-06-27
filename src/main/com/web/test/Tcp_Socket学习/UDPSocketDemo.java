package com.web.test.Tcp_Socket学习;

import javax.servlet.Servlet;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Author: LiXiang
 * @Description :
 * @Date: Created in 2019-05-29 9:17
 */
public class UDPSocketDemo {
}
//UDP 服务端
class UdpSocketServer {

    public static void main(String[] args) throws IOException {
        System.out.println("udp服务器端启动连接....");

        // 1.UDP没有连接，所以不需要握手，所以就不需要调用listen和connect函数，所以也就不需要专门的socket维护连接
        // 2.第一步bind函数绑定端口
        DatagramSocket ds = new DatagramSocket(8080);

        // 3.sendto 和 recvfrom 通讯

        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
        // 阻塞,等待接受客户端发送请求
        ds.receive(dp);
        System.out.println("来源:"+dp.getAddress()+",端口号:"+dp.getPort());
        // 获取客户端请求内容
        String str=new String(dp.getData(),0,dp.getLength());
        System.out.println("str:"+str);
        ds.close();

    }

}
//UDP客户端
class UdpClient {

    public static void main(String[] args) throws IOException {
        System.out.println("udp客户端启动连接....");
        DatagramSocket ds = new DatagramSocket();
        String str="呵呵哒";
        byte[] bytes= str.getBytes();
        DatagramPacket dp= new DatagramPacket(bytes, bytes.length, InetAddress.getByName("127.0.0.1"),8080);
        ds.send(dp);
        ds.close();
    }

}