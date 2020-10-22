package com.sanctuary.eduinfosvc.domain;

import org.springframework.stereotype.Component;

@Component
public class User {

    private int id;
    private String userName;
    private String sex;
    private String phone;
    private String password;
    private boolean status = true;
    private String note;

    private int role;
    private int organizeId;
    private String organizeName;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }

    public int getRole() {
        return role;
    }
    public void setRole(int role) {
        this.role = role;
    }

    public int getOrganizeId() {
        return organizeId;
    }
    public void setOrganizeId(int organizeId) {
        this.organizeId = organizeId;
    }

    public String getOrganizeName() {
        return organizeName;
    }
    public void setOrganizeName(String organizeName) {
        this.organizeName = organizeName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", note='" + note + '\'' +
                ", role=" + role +
                ", organizeId=" + organizeId +
                ", organizeName='" + organizeName + '\'' +
                '}';
    }
}
