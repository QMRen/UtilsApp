package com.example.admin.utilsapp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.utilsapp.R;
import com.example.admin.utilsapp.base.BaseFragment;

/**
 * Created by admin on 2017/10/27.
 */

public class HomeFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,null);
        return view;
    }
//    WebView mWebView;
//    String mURL = "http://uatlfs.lcshidai.com/download/2017/10/23/1508735968689.jpg";
//    //    String mURL = "http://img10.3lian.com/sc6/show02/43/51/18.jpg";
////        String mURL = "https://www.hao123.com/";
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        mWebView = (WebView) findViewById(R.id.web);
//        WebSettings settings = mWebView.getSettings();
//        settings.setBlockNetworkImage(false);//解决图片加载不出来的问题
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            //允许混合内容，5.0之后的api
//            settings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
//        }
//        settings.setDomStorageEnabled(true);
//        settings.setAllowFileAccess(true);
//        settings.setJavaScriptEnabled(true);
////设置自适应屏幕，两者合用
//        settings.setUseWideViewPort(true); //将图片调整到适合webview的大小
//        settings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
////缩放操作
//        settings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
//        settings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
//        settings.setDisplayZoomControls(false); //隐藏原生的缩放控件
////其他细节操作
//        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); //关闭webview中缓存
//        settings.setAllowFileAccess(true); //设置可以访问文件
//        settings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
//        settings.setLoadsImagesAutomatically(true); //支持自动加载图片
//        settings.setDefaultTextEncodingName("utf-8");//设置编码格式
//        mWebView.setWebViewClient(new WebViewClient() {
//
//            @Override
//            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
//                handler.proceed();
//            }
//
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                mWebView.loadUrl(url);
//                return true;
//            }
//        });
//        mWebView.setWebChromeClient(new WebChromeClient(){
//            @Override
//            public void onProgressChanged(WebView view, int newProgress) {
//                super.onProgressChanged(view, newProgress);
//            }
//        });
//        mWebView.loadData(
//                "<img src =\""+mURL+"\"/>",
//                "text/html",
//                "utf-8"
//        );
}
