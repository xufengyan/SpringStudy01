package com.web.test.Tcp_Socket学习;

/**
 * Created by Administrator on 2019/5/28 0028.
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器端
 */
public class TcpServer0 {

    public static void main(String [] arge) throws Exception{
        try {
            //创建客户端的socket
            ServerSocket serverSocket=new ServerSocket(45500);

            Socket socket =serverSocket.accept();//监听

            System.out.println(socket);
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


            //获取服务器输入的值
            String redline =sysBuff.readLine();

            //循环通信
            while (!"red".equals(redline)){
                //客户端发送的
                socketOut.println(redline);//将输入的值写入socket；
                socketOut.flush();//刷新缓冲区
                System.out.println("服务器数据："+redline);
                //接收客户端的
                String rl=socketBuff.readLine();

                if(!"ok".equals(rl)){
                    System.out.println("客户端数据："+rl);

                }else {
                    break;
                }

                redline=sysBuff.readLine();
            }
            //关闭
            socketIn.close();
            socketOut.close();
            serverSocket.close();
        }catch (Exception e){
            System.out.println(e);
        }



        }


    }



