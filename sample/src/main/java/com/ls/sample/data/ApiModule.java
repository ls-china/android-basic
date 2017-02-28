package com.ls.sample.data;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hx on 2017/1/10.
 * <a href="https://github.com/China-ls">GitHub</a>
 */

@Module
public class ApiModule {

    @Singleton
    @Provides
    public Api provideApi() {
        return new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .client(new OkHttpClient.Builder().addNetworkInterceptor(new HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BASIC))
                        .build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Api.class);
    }

}
