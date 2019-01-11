package com.example.administrator.android_doannhapmondidong.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Sanpham implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("tenqt")
    @Expose
    private String tenqt;
    @SerializedName("giaqt")
    @Expose
    private String giaqt;
    @SerializedName("hinhanhqt")
    @Expose
    private String hinhanhqt;
    @SerializedName("mota")
    @Expose
    private String mota;
    @SerializedName("idqt")
    @Expose
    private String idqt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenqt() {
        return tenqt;
    }

    public void setTenqt(String tenqt) {
        this.tenqt = tenqt;
    }

    public String getGiaqt() {
        return giaqt;
    }

    public void setGiaqt(String giaqt) {
        this.giaqt = giaqt;
    }

    public String getHinhanhqt() {
        return hinhanhqt;
    }

    public void setHinhanhqt(String hinhanhqt) {
        this.hinhanhqt = hinhanhqt;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getIdqt() {
        return idqt;
    }

    public void setIdqt(String idqt) {
        this.idqt = idqt;
    }

}
