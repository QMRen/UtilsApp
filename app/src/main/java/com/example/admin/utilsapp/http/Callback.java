package com.example.admin.utilsapp.http;

/**
 * Created by admin on 2017/11/15.
 */

public interface Callback<T> {

    void requestError(String msg);

    void requestSuccess(T data);
}
