package com.sanctuary.eduinfosvc.util;

public class SuccessInfo implements Info{
    private int status = 200;
    private String msg = "成功";
    private Object[] data;
    private String token = "sadojao";

    public SuccessInfo(Object[] data) {
        this.data = data;
    }
    public SuccessInfo() { }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object[] getData() {
        return data;
    }
    public void setData(Object[] data) {
        this.data = data;
    }

    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
}
