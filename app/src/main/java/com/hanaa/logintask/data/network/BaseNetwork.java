package com.hanaa.logintask.data.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.hanaa.logintask.data.adapter.LoginResponseDeserializer;
import com.hanaa.logintask.data.model.LoginResponseCloud;

import java.lang.reflect.Type;

import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseNetwork {

    private BaseNetwork() {
    }
    public static class RetrofitInstance {
        static Retrofit retrofit;

        static {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(createGsonConverter(new TypeToken<LoginResponseCloud>() {
                    }.getType(), new LoginResponseDeserializer()))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
    }

    private static Converter.Factory createGsonConverter(Type type, Object typeAdapter) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(type, typeAdapter);
        Gson gson = gsonBuilder.create();

        return GsonConverterFactory.create(gson);
    }


    private static final String BASE_URL = "https://cpanels.shop/testTask/api/";

    public static Retrofit getInstance() {

        return RetrofitInstance.retrofit;
    }
}
