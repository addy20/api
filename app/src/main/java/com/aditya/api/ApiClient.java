package com.aditya.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiClient {

    public static Retrofit getAPIClient(){
        Retrofit client=null;

        OkHttpClient httpClient=new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30,TimeUnit.SECONDS)
                .writeTimeout(30,TimeUnit.SECONDS)
                .build();

        client=new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .client(httpClient)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        return client;
    }
}
