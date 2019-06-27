package com.web.test.NIO实现聊天功能;

import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

/**
 * Created by Administrator on 2019/6/26 0026.
 */
public class NioChile {


    private Selector selector;

    private SocketChannel socketChannel;

    private ByteBuffer readBuffer = ByteBuffer.allocate(1024);
    private String  userNaem= "李四";
    /**
     * 初始化通道
     * @param ip
     * @param port
     */
    public void initChile(String ip,int port) throws IOException {

        //获取socket通道
        socketChannel = SocketChannel.open();

        //设置通道为非阻塞的
        socketChannel.configureBlocking(false);

        //获取一个通道处理器
        this.selector=Selector.open();

        //客户端连接服务器
        socketChannel.connect(new InetSocketAddress(ip,port));

        //将通道管理器和该通道绑定，并注册事件
        socketChannel.register(this.selector, SelectionKey.OP_CONNECT);

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

                    System.out.println("???:"+channel);
                    //将通道设置为非阻塞
                    channel.configureBlocking(false);

                    Message returnMsg=new Message();

                    returnMsg.setContent("");
                    returnMsg.setFormUserName(userNaem);
                    returnMsg.setToUserName("allUser");
                    sendMessage(returnMsg);

//                    channel.write(ByteBuffer.wrap(new String("我给服务器端发送消息了").getBytes()));

                    channel.register(this.selector, SelectionKey.OP_READ);


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

        this.readBuffer.clear();
        //创建读取的缓冲区
        int len = 0;
        try {
            len = channel.read(this.readBuffer);
        } catch (IOException e) {
            // 远程强制关闭通道，取消选择键并关闭通道
            System.err.println(e);
            return;
        }

        String msg = new String(this.readBuffer.array(), 0, len, Charset.forName("UTF-8"));

        //将json字符串转换为对象
        Message message = (Message) JSONObject.toBean(JSONObject.fromObject(msg), Message.class);

        System.out.println(message.getFormUserName()+"说："+message.getContent());

        InputStreamReader sysin =new InputStreamReader(System.in);

        BufferedReader socketBuff=new BufferedReader(sysin);

        Message returnMsg=new Message();

        String resConten=new String(socketBuff.readLine()).trim();

        returnMsg.setContent(resConten);
        returnMsg.setFormUserName(userNaem);
        returnMsg.setToUserName("allUser");
        sendMessage(returnMsg);
    }


    public void sendMessage(Message message) throws IOException {

        JSONObject msg=JSONObject.fromObject(message);
        if(socketChannel!=null&&message!=null){
            byte[] val = msg.toString().getBytes();
            socketChannel.write(ByteBuffer.wrap(val));
        }

    }

    public static void main(String [] args)throws IOException{

        NioChile nioChile =new NioChile();
        nioChile.initChile("localhost",8000);
        nioChile.listen();

    }

}
