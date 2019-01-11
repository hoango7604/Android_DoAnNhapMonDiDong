package com.example.administrator.android_doannhapmondidong.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Loaisp {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("tenloaiqt")
    @Expose
    private String tenloaiqt;

    @SerializedName("hinhanhloaiqt")
    @Expose
    private String hinhanhloaiqt;

    public Loaisp(String id, String tenloaiqt, String hinhanhloaiqt) {
        this.id = id;
        this.tenloaiqt = tenloaiqt;
        this.hinhanhloaiqt = hinhanhloaiqt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenloaiqt() {
        return tenloaiqt;
    }

    public void setTenloaiqt(String tenloaiqt) {
        this.tenloaiqt = tenloaiqt;
    }

    public String getHinhanhloaiqt() {
        return hinhanhloaiqt;
    }

    public void setHinhanhloaiqt(String hinhanhloaiqt) {
        this.hinhanhloaiqt = hinhanhloaiqt;
    }

}
