package com.example.administrator.android_doannhapmondidong.Utils;

import com.example.administrator.android_doannhapmondidong.Services.APIService;

import retrofit2.Retrofit;

public class APIUtils {
    private static final String BASE_URL = "http://doannhapmongame.000webhostapp.com/server/";

    public static APIService getAPIService(){
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
