package com.web.test.NIO实现聊天功能;

import java.nio.channels.SocketChannel;

/**
 * Created by Administrator on 2019/6/26 0026.
 */
public class User {

    //客户端名称
    private String chileName;
    //客户端的socket
    private SocketChannel socketChannel;

    public String getChileName() {
        return chileName;
    }

    public void setChileName(String chileName) {
        this.chileName = chileName;
    }

    public SocketChannel getSocketChannel() {
        return socketChannel;
    }

    public void setSocketChannel(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    public  User(String c,SocketChannel s){
        this.chileName=c;
        this.socketChannel=s;
    }
}
