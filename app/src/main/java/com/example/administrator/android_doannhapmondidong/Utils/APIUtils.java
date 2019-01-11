package com.example.administrator.android_doannhapmondidong.Utils;

import com.example.administrator.android_doannhapmondidong.Services.APIService;

import retrofit2.Retrofit;

public class APIUtils {
    private static final String BASE_URL = "http://192.168.31.9/server/";

    public static APIService getAPIService(){
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
