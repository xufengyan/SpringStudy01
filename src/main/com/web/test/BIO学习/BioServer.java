package com.web.test.BIO学习;

/**
 * Created by Administrator on 2019/5/30 0030.
 */


import com.alibaba.druid.support.spring.stat.SpringStatUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模仿BIO阻塞式案例
 *
 * BIO是一个请求一个答应的通信模式，
 *
 * 服务器端有处理客户端的请求，每个客户端的请求都会创建一个线程去处理--------非常消耗资源
 */

public class BioServer {


    public static void main(String [] args){

        ServerSocket serverSocket=null;

        try {
             serverSocket=new ServerSocket(10001);

            while(true){
                //监听连接状态
                Socket socket = serverSocket.accept();
                System.out.println(socket);
                //监听到客户端发来的请求就创建一个服务线程去处理
                new Thread(new BioHandler(socket)).start();
            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {
            if(null!=serverSocket){
                System.out.println("服务器即将关闭");
                try {
                    //关闭socket
                    serverSocket.close();

                }catch (Exception e){

                    e.printStackTrace();

                }
                serverSocket=null;

            }



        }


    }



    //处理客户端发来的请求
    public static class BioHandler implements Runnable {

        private Socket socket;

        public BioHandler(Socket socket){
            this.socket=socket;
        }

        @Override
        public void run() {
            BufferedReader Buffin=null;//接收客户端发来的消息
            PrintWriter out=null;//对客户端的消息进行回复

            try {
                //获取客户端的消息
                Buffin =new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                out =new PrintWriter(this.socket.getOutputStream());

                while (true){

                    String line = Buffin.readLine();

                    if(null==line){
                        break;
                    }
                    System.out.println("客户端说："+line);

                    out.println("我接收到请求了，你自己去玩吧");
                    out.flush();

                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {

                //关闭
                try {
                if(null!=Buffin){
                    Buffin.close();
                }
                if(null!=out){
                    out.close();
                }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }
    }
}



