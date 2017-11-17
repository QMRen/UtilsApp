package com.example.admin.utilsapp.http;

import org.reactivestreams.Publisher;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by admin on 2017/11/15.
 */

public class BaseSchedulerTransformer<T> implements FlowableTransformer<T, T> {

    @Override
    public Publisher<T> apply(@NonNull Flowable<T> upstream) {
        return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).unsubscribeOn(Schedulers.io());
}
}
