package com.example.admin.utilsapp.api;


import com.example.admin.utilsapp.bean.Girls;
import com.example.admin.utilsapp.http.BaseEntity;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.Response;
import retrofit2.http.GET;

/**
 * Created by admin on 2017/11/14.
 */

public interface GirlsApi {

    @GET("api/data/福利/10/1")
    Flowable<Response<BaseEntity<List<Girls>>>> getVideoUrl();
}
