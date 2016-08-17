package com.qf.luckey.util;


import com.qf.luckey.entity.FitEntity;
import com.qf.luckey.entity.Project2Entity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 联网数据请求
 * Created by Administrator on 2016/8/11.
 */
public interface HttpUtils {
    /**
     * 搭配模块下--搭配--最新模块数据
     * @Query你想在url增加参数，就通过这个 注解，注解会把传递过来的参数拼凑起来
     */
    @GET(HttpURL.HTTP_FIT_NEWEST)
    Call<FitEntity> getNewData(@Query("flag") String flag);

//    @GET(HttpURL.HTTP_FIT_NEWEST)
//    Call<FitEntity> getNewData();


    //专题数据模块
    @GET(HttpURL.HTTP_SUBJECT)
    Call<Project2Entity> getProjectData();

}
