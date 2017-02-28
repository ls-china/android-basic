package com.ls.sample.data;

import com.ls.sample.data.resp.BdResponse;
import com.ls.sample.data.resp.ImageSoResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by hx on 2017/2/28.
 * <a href="https://github.com/China-ls">GitHub</a>
 */

public interface Api {
    public static final String BASE_URL = "http://example.com";

    @GET
    Observable<ImageSoResponse> queryImageSoPicture(@Url String url);

    @GET
    Observable<BdResponse> queryBdPicture(@Url String url);

}
