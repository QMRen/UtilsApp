package com.example.admin.utilsapp.service;

import android.content.Context;

import com.example.admin.utilsapp.api.GirlsApi;
import com.example.admin.utilsapp.api.Server;
import com.example.admin.utilsapp.bean.BannerBean;
import com.example.admin.utilsapp.bean.Girls;
import com.example.admin.utilsapp.http.BaseEntity;
import com.example.admin.utilsapp.http.BaseResponse;
import com.example.admin.utilsapp.http.BaseSchedulerTransformer;
import com.example.admin.utilsapp.http.BaseService;
import com.example.admin.utilsapp.http.BaseSubscriber;
import com.example.admin.utilsapp.http.Callback;
import com.example.admin.utilsapp.http.ServiceFactory;

import java.util.List;

import retrofit2.Response;

/**
 * Created by admin on 2017/11/15.
 */

public class GirlService extends BaseService {

    public GirlService(Context context) {
        super(context);
    }

    public void getVideoUrl(Callback<Response<BaseEntity<List<Girls>>>> callback) {

        ServiceFactory.createService(Server.ApiUrl, GirlsApi.class)
                .getVideoUrl()
                .compose(new BaseSchedulerTransformer<Response<BaseEntity<List<Girls>>>>())
                .subscribe(new BaseSubscriber<>(callback));
    }

    public void getBanner(Callback<Response<BaseResponse<List<BannerBean>>>> callback) {
        ServiceFactory.createService(Server.TrjUrl, GirlsApi.class).getBanner()
                .compose(new BaseSchedulerTransformer<Response<BaseResponse<List<BannerBean>>>>())
                .subscribe(new BaseSubscriber<>(callback));
    }
}
