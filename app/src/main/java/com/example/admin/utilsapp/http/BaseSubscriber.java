package com.example.admin.utilsapp.http;


import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;


/**
 * Created by admin on 2017/11/15.
 */

public class BaseSubscriber<T> implements Subscriber<T> {

    private Callback<T> mCallback;

    public BaseSubscriber(Callback<T> callback) {
        mCallback = callback;
    }

    @Override
    public void onSubscribe(Subscription s) {

    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable t) {

    }

    @Override
    public void onComplete() {

    }
}