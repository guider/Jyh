package com.yanyuanquan.android.jyh.api;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by apple on 16/3/14.
 */

@Module
public class ApiServiceModel {
    public static final String baseUrl = "http://guangdiu.com/";

    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        OkHttpClient client = new OkHttpClient();
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
        return retrofit;
    }

    @Provides
    @Singleton
    ApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

    private ApiService service;

    public ApiService getService() {
        return provideApiService(provideRetrofit());
    }

    private static ApiServiceModel apiServiceModel;

    private ApiServiceModel() {
    }

    public static ApiServiceModel getInstance() {
        if (apiServiceModel == null) {
            apiServiceModel = new ApiServiceModel();
        }
        return apiServiceModel;
    }

}
