package com.minitoring.pojo;

public class User { ////定义User 类用来接收数据库的字段
    private String uid;
    private String long_pred;
    private String lait_pred;

    public void setuid(String uid) {
        this.uid = uid;
    }
    public String getuid() {
        return uid;
    }

    public void setlong_pred(String long_pred) {
        this.long_pred = long_pred== null ? null : long_pred.trim();
    }

    public String getlong_pred() {
        return long_pred;
    }
    public void setlait_pred(String lait_pred) {
        this.lait_pred = lait_pred== null ? null : lait_pred.trim();
    }
    public String getlait_pred() {
        return lait_pred;
    }

}