package com.web.test.Tcp_Socket学习;

/**
 * Created by Administrator on 2019/5/28 0028.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 客户端
 */
public class TcpClient0 {

    public static void main(String [] args)throws Exception{

        try {
            //创建socket
            Socket socket =new Socket("localhost",45500);

//            建立连接

            //客户端向服务器发送请求
            //写
            InputStreamReader sysin =new InputStreamReader(System.in);
            //放入到缓冲区
            BufferedReader sysBuff =new BufferedReader(sysin);


            //读取socket中的内容

            InputStreamReader socketIn=new InputStreamReader(socket.getInputStream());
            BufferedReader socketBuff=new BufferedReader(socketIn);

            //向socket中写入
            PrintWriter socketOut=new PrintWriter(socket.getOutputStream());

            //读取到输入的值
            String redline=sysBuff.readLine();

            //进行通信
            while (!"red".equals(redline)){
                //客户端发送的
                socketOut.println(redline);//将输入的值写入socket；
                socketOut.flush();//刷新缓冲区
                System.out.println("客户端数据："+redline);

                //接收服务器端的
                System.out.println("服务器数据："+socketBuff.readLine());//接收不到数据的话会一直在这里等待
                //为了循环通讯才赋值的
                redline = socketBuff.readLine();
            }
                //关闭
            sysin.close();
            socketOut.close();
            socket.close();
        }catch (Exception e){
            System.out.println(e);
        }

    }



}
