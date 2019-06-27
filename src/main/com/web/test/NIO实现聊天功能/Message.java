package com.web.test.NIO实现聊天功能;

/**
 * Created by Administrator on 2019/6/26 0026.
 */
public class Message {

    private String content;//内容

    private String formUserName;//用户名

    private String toUserName;//指定发送用户


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFormUserName() {
        return formUserName;
    }

    public void setFormUserName(String formUserName) {
        this.formUserName = formUserName;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }
}
