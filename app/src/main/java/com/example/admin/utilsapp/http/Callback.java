package com.example.admin.utilsapp.http;

/**
 * Created by admin on 2017/11/15.
 */

public abstract class Callback<T> {

    public abstract void requestError(Throwable msg);

    public abstract void requestSuccess(T data);

    public abstract void requestComplete();

}
