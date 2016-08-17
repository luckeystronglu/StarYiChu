package com.qf.luckey.staryichu;

import android.app.Application;

import com.qf.luckey.util.HttpURL;
import com.qf.luckey.util.HttpUtils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/8/11.
 */
public class MyApplication extends Application {
    public static HttpUtils utils;

    @Override
    public void onCreate() {
        super.onCreate();
        utils = initRetrofit();
    }

    public HttpUtils initRetrofit(){
        //得到retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HttpURL.HTTP_ROOT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //得到方法对象
        return retrofit.create(HttpUtils.class);
    }
}
