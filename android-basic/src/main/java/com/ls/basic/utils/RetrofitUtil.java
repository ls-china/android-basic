package com.ls.basic.utils;

import retrofit2.Retrofit;

/**
 * Created by hx on 2016/12/27.
 * core - com.ls.basic.utils
 */
public abstract class RetrofitUtil {

    public static synchronized <T> T createDefault(Class<T> service, String baseurl) {
        return new Retrofit.Builder().baseUrl(baseurl).build().create(service);
    }

}
