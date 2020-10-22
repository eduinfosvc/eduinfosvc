package com.sanctuary.eduinfosvc.util;

public class ErrorInfo implements Info{
    private int status;
    private String msg;

    public ErrorInfo(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }
    public ErrorInfo() { }

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
}
