package com.mypractice.sinks;

public class SlackMessage {
    public static final String format = "[%s -> %s] : %s";
    private String sender;
    private String reciver;
    private String msg;

    public static String getFormat() {
        return format;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReciver() {
        return reciver;
    }

    public void setReciver(String reciver) {
        this.reciver = reciver;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return String.format(format, this.sender, this.reciver, this.msg);
    }
}
