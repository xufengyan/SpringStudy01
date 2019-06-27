package com.web.test.BIO学习;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Administrator on 2019/5/30 0030.
 */
public class BioChile {



    public static void main(String [] arge) {

        Socket socket =null;
        BufferedReader buffin=null;
        PrintWriter out = null;

        try {

            socket=new Socket("127.0.0.1",10001);

            buffin=new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out =new PrintWriter(socket.getOutputStream());

            out.println("服务器我来了");
            out.flush();
            String line =buffin.readLine();

            System.out.println("服务器说："+line);


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
            if(null!=socket){
                    socket.close();
            }

            if(null!=buffin){
                buffin.close();
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
