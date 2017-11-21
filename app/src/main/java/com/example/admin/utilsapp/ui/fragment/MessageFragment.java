package com.example.admin.utilsapp.ui.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.example.admin.utilsapp.R;
import com.example.admin.utilsapp.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2017/10/30.
 */

public class MessageFragment extends BaseFragment {

    @BindView(R.id.message_img)
    ImageView mImageView;
    @BindView(R.id.message_web)
    WebView mWebView;
//    String mUrl = "http://g.hiphotos.baidu.com/image/pic/item/71cf3bc79f3df8dc57ab895bc411728b46102861.jpg";
    String mUrl = "http://uatlfs.lcshidai.com/download/2017/10/23/1508735968689.jpg";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message,null);
        ButterKnife.bind(MessageFragment.this,view);
//        Glide.with(getActivity()).load(mUrl).into(new SimpleTarget<Drawable>() {
//            @Override
//            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
//                mImageView.setImageDrawable(resource);
//            }
//        });
//        mWebView.loadUrl(mUrl);
        mWebView.loadData(
                "<img src =\""+mUrl+"\"/>",
                "text/html",
                "utf-8"
        );
        if (Build.VERSION.SDK_INT >= 21) {
            //允许混合内容，5.0之后的api
            mWebView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.setWebChromeClient(new WebChromeClient());
        return view;
    }
}
