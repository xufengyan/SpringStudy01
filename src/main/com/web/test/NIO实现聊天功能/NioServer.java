package com.web.test.NIO实现聊天功能;

import net.sf.json.JSONObject;
import netscape.javascript.JSObject;
import org.apache.commons.lang.StringUtils;

import javax.json.JsonObject;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2019/6/26 0026.
 */
public class NioServer {

    //用来存放连接的客户端
    private Map<String,User> userMap=new HashMap<>();

    //创建一个通道处理器
    private Selector selector;//也叫多路复用

    private ByteBuffer readBuffer = ByteBuffer.allocate(1024);

    private String  userNaem= "徐峰的超级聊天工具";

    /**
     * 初始化通道
     */
    public void initServer(int port) throws IOException {

//        获取到一个server通道
        ServerSocketChannel socketChannel=ServerSocketChannel.open();

        //设置serverSocket为非阻塞的
        socketChannel.configureBlocking(false);

        //该通道绑定端口
        socketChannel.socket().bind(new InetSocketAddress(port));

        //获取到通道处理器
        this.selector=Selector.open();

        //将通道处理器和该通道绑定，并注册SelectionKey.OP_ACCEPT事件
        //当事件到达时selector.select()会继续执行，没有的话将会一直注阻塞 在这里
        socketChannel.register(selector, SelectionKey.OP_ACCEPT);

    }

    /**
     * 循环监听selector是否有需要处理的事件，有的话就处理
     */
    public void linten() throws IOException {

        System.out.println("服务器已启动。。。。。。。。。。各部门注意");

        while (true){

            //监听是否有事件需要处理，没有的话就会一直阻塞在这里
            this.selector.select();
            //获取selector中的选中项，选中项为注册事件
            Iterator iterator=this.selector.selectedKeys().iterator();

            while (iterator.hasNext()) {

                SelectionKey selectionKey = (SelectionKey) iterator.next();

                //删除已选的key防止重复处理
                iterator.remove();

                //判断客户端是否连接
                if (selectionKey.isAcceptable()) {

                    //获取到客户端的socket；
                    ServerSocketChannel userSocket = (ServerSocketChannel) selectionKey.channel();



                    //获取与客户端的连接通道
                    SocketChannel socketChannel = userSocket.accept();

                    this.readBuffer.clear();
                    int len = 0;
                    try {
                        len = socketChannel.read(this.readBuffer);
                    } catch (IOException e) {
                        // 远程强制关闭通道，取消选择键并关闭通道
                        System.err.println(e);
                        return;
                    }

                    String msg = new String(this.readBuffer.array(), 0, len, Charset.forName("UTF-8"));

                    //将json字符串转换为对象
                    Message message = (Message) JSONObject.toBean(JSONObject.fromObject(msg), Message.class);

                    User user = new User(message.getFormUserName(), socketChannel);

                    //将当前连接的用户保存进去
                    userMap.put(message.getFormUserName(), user);

                    Message masg=new Message();

                    masg.setFormUserName(userNaem);

                    masg.setToUserName(message.getFormUserName());

                    masg.setContent("欢迎进入聊天室");

                    toUseeMessage(socketChannel,masg);

//                    socketChannel.write(ByteBuffer.wrap(new String(message.getFormUserName() + ":您已成功连接").getBytes()));

                    //设置通道为非阻塞式的
                    socketChannel.configureBlocking(false);


                    //在和客户端连接成功后，为了接受客户端的消息，给通道设置读的权限
                    socketChannel.register(this.selector, SelectionKey.OP_READ);
                }else if(selectionKey.isReadable()){

                    SocketChannel socket = (SocketChannel) selectionKey.channel();


                    read(selectionKey);

                }

            }

        }

    }

    /**
     * 读取客户端的消息并根据要求指定回复人回复
     * @param key
     * @throws IOException
     */
    public void read(SelectionKey key)throws IOException{

        //获取到连接
        SocketChannel socketChannel=(SocketChannel) key.channel();

        this.readBuffer.clear();

        int len = 0;
        try {
            len = socketChannel.read(this.readBuffer);
        } catch (IOException e) {
            // 远程强制关闭通道，取消选择键并关闭通道
            System.err.println(e);
            return;
        }

        String msg = new String(this.readBuffer.array(), 0, len, Charset.forName("UTF-8"));

        //将json字符串转换为对象
        Message message = (Message) JSONObject.toBean(JSONObject.fromObject(msg), Message.class);

        //给所有人发消息
        if("allUser".equals(message.getToUserName())){

            System.out.println("<"+message.getFormUserName()+">对所有人说："+message.getContent());

            //群发
            userAllMessage(message);

        }else{

            System.out.println("<"+message.getFormUserName()+">对<"+message.getToUserName()+">说："+message.getContent());
            //独发
            toUseeMessage(userMap.get(message.getToUserName()).getSocketChannel(),message);

        }

    }


    /**
     * 给所有人发消息
     * @param message
     * @throws IOException
     */
    public void userAllMessage(Message message) throws IOException {

        Set<Map.Entry<String, User>> entrySet = userMap.entrySet();

        for (Map.Entry<String, User> e : entrySet) {
            if (StringUtils.isNotEmpty(message.getFormUserName())
                    && e.getKey().equals(message.getFormUserName())) {
                continue;
            }
            JSONObject m = JSONObject.fromObject(message);
            byte[] val = m.toString().getBytes();
            e.getValue().getSocketChannel().write(ByteBuffer.wrap(val));
        }

    }

    //单独发送消息
    public void toUseeMessage(SocketChannel socketChannel,Message returnMessage) throws IOException {
        JSONObject msg = JSONObject.fromObject(returnMessage);
        if (socketChannel != null && msg != null) {
            byte[] val = msg.toString().getBytes();
            socketChannel.write(ByteBuffer.wrap(val));
        }

    }


    public static void main(String [] args) throws IOException {
        NioServer nioServer=new NioServer();
        nioServer.initServer(8000);
        nioServer.linten();
    }

}
