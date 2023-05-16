package com.example.cms;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApi {
    private static RetrofitApi instance = null;
    private  api myApi;

    private RetrofitApi() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okclient = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .build();

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okclient)
                .build();

 myApi = retrofit.create(api.class);
    }
    public static synchronized RetrofitApi getInstance() {
        if (instance == null) {
            instance = new RetrofitApi();
        }
        return instance;
    }
    public api getMyApi() {
        return myApi;
    }

}