package com.example.administrator.android_doannhapmondidong.Services;

import com.example.administrator.android_doannhapmondidong.Models.Loaisp;
import com.example.administrator.android_doannhapmondidong.Models.Sanpham;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIService {
    @GET("getloaisp.php")
    Call<ArrayList<Loaisp>> getLoaisp();

    @GET("getspmoinhat.php")
    Call<ArrayList<Sanpham>> getSanphammoinhat();

    @GET("getsp.php")
    Call<ArrayList<Sanpham>> getSanpham(@Query("page") int page, @Query("idsp") int idsp);

    @POST("thongtinkhachhang.php")
    @FormUrlEncoded
    Call<Integer> postDonHang(@Field("tenkhachhang") String tenkhachhang,
                              @Field("diachi") String diachi,
                              @Field("sodienthoai") Integer sodienthoai,
                              @Field("tongtien") Integer tongtien);

    @POST("chitietdonhang.php")
    @FormUrlEncoded
    Call<Integer> postChitietDonhang(@Field("json") JSONArray json);
}
