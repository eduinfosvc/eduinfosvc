package com.sanctuary.eduinfosvc.domain;

public class Column {
    private int id;
    private String name;
    private boolean uploadPower;
    private boolean checkPower;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean isUploadPower() {
        return uploadPower;
    }
    public void setUploadPower(boolean uploadPower) {
        this.uploadPower = uploadPower;
    }

    public boolean isCheckPower() {
        return checkPower;
    }
    public void setCheckPower(boolean checkPower) {
        this.checkPower = checkPower;
    }

    @Override
    public String toString() {
        return "Column{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", uploadPower=" + uploadPower +
                ", checkPower=" + checkPower +
                '}';
    }
}
