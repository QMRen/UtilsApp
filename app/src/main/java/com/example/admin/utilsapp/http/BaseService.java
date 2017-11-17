package com.example.admin.utilsapp.http;

import android.content.Context;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by admin on 2017/11/15.
 */

public class BaseService {

    protected Context mContext;

    protected BaseService(Context context){
        Reference<Context> contextRef = new WeakReference<>(context);
        mContext = contextRef.get();
    }
}
