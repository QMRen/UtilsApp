package com.example.admin.utilsapp.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 2017/11/14.
 */

public class ServiceFactory {
    private volatile static OkHttpClient okHttpClient;
    private volatile static Retrofit retrofit;

    private static final int DEFAULT_CACHE_SIZE = 1024 * 1024 * 20;//默认缓存大小20M
    private static final int DEFAULT_MAX_AGE = 60 * 60;// 默认缓存时间单位
    private static final int DEFAULT_MAX_STALE_ONLINE = DEFAULT_MAX_AGE * 24;// 默认在线缓存时间
    private static final int DEFAULT_MAX_STALE_OFFLINE = DEFAULT_MAX_AGE * 24 * 7;// 默认离线缓存时间

    /**
     * 保存cookies拦截器
     */
//    private static Interceptor SAVE_COOKIES_INTERCEPTOR = new Interceptor() {
//        @Override
//        public Response intercept(Chain chain) throws IOException {
//            SharedPreferences sharedPreferences = MainApplication.getApplication()
//                    .getSharedPreferences("cookie_sp", Context.MODE_PRIVATE);
//            Response originalResponse = chain.proceed(chain.request());
//            if (!CommonUtils.isNullOrEmpty(originalResponse.header("Set-Cookie"))) {
//                updateCookies(originalResponse, sharedPreferences);
//            }
//
//            return originalResponse;
//        }
//    };
//
//    private static void updateCookies(Response originalResponse, SharedPreferences sharedPreferences) {
//        final StringBuffer cookieBuffer = new StringBuffer();
//        Observable.from(originalResponse.headers("Set-Cookie"))
//                .map(new Func1<String, String>() {
//                    @Override
//                    public String call(String s) {
//                        String[] cookieArray = s.split(";");
//                        return cookieArray[0];
//                    }
//                })
//                .subscribe(new Action1<String>() {
//                    @Override
//                    public void call(String s) {
//                        cookieBuffer.append(s).append(";");
//                    }
//                });
//        KLog.e("save_cookie", cookieBuffer.toString());
//        CookieManager.getInstance().setCookie(cookieBuffer.deleteCharAt(cookieBuffer.length() - 1).toString());
//    }
//
//    /**
//     * 添加cookies拦截器
//     */
//    private static Interceptor ADD_COOKIES_INTERCEPTOR = new Interceptor() {
//        @Override
//        public Response intercept(Chain chain) throws IOException {
//            final Request.Builder builder = chain.request().newBuilder();
////            SharedPreferences sharedPreferences = MainApplication.getApplication()
////                    .getSharedPreferences("cookie_sp", Context.MODE_PRIVATE);
//            Observable.just(CookieManager.getInstance().getCookie())
//                    .subscribe(new Action1<String>() {
//                        @Override
//                        public void call(String s) {
//                            builder.addHeader("Cookie", s);
//                        }
//                    });
////            KLog.e("add_cookie", sharedPreferences.getString("cookie", ""));
//            return chain.proceed(builder.build());
//        }
//    };
//
//    /**
//     * request 拦截器定义
//     */
//    private static final Interceptor REQUEST_INTERCEPTOR = new Interceptor() {
//        @Override
//        public Response intercept(Chain chain) throws IOException {
//            Request request = chain.request();
//            int maxStale = DEFAULT_MAX_STALE_ONLINE;
//            //向服务期请求数据缓存1个小时
//            CacheControl tempCacheControl = new CacheControl.Builder()
////                .onlyIfCached()
//                    .maxStale(5, TimeUnit.SECONDS)
//                    .build();
//            request = request.newBuilder()
//                    .cacheControl(tempCacheControl)
//                    .build();
//            return chain.proceed(request);
//        }
//    };
//
//    /**
//     * response 拦截器定义
//     */
//    private static final Interceptor RESPONSE_INTERCEPTOR = new Interceptor() {
//        @Override
//        public Response intercept(Chain chain) throws IOException {
//            //针对那些服务器不支持缓存策略的情况下，使用强制修改响应头，达到缓存的效果
//            //响应拦截只不过是出于规范，向服务器发出请求，至于服务器搭不搭理我们我们不管他，我们在响应里面做手脚，有网没有情况下的缓存策略
//            Request request = chain.request();
//            Response originalResponse = chain.proceed(request);
//            int maxAge;
//            // 缓存的数据
//            if (!NetworkUtils.isConnected(MainApplication.getApplication())) {// 没有网络
//                maxAge = DEFAULT_MAX_STALE_OFFLINE;
//            } else {
//                maxAge = 0;
//            }
//            return originalResponse.newBuilder()
//                    .removeHeader("Pragma")// 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
//                    .removeHeader("Cache-Control")
//                    .header("Cache-Control", "public, max-age=" + maxAge)
//                    .build();
//        }
//    };
//    /**
//     * 打印返回的json数据拦截器
//     */
//    private static final Interceptor LOGGING_INTERCEPTOR = new Interceptor() {
//        @Override
//        public Response intercept(Chain chain) throws IOException {
//
//            final Request request = chain.request();
//            final Response response = chain.proceed(request);
//
//            final ResponseBody responseBody = response.body();
//            final long contentLength = responseBody.contentLength();
//
//            BufferedSource source = responseBody.source();
//            source.request(Long.MAX_VALUE); // Buffer the entire body.
//            Buffer buffer = source.buffer();
//
//            Charset charset = Charset.forName("UTF-8");
//            MediaType contentType = responseBody.contentType();
//            if (contentType != null) {
//                try {
//                    charset = contentType.charset(charset);
//                } catch (UnsupportedCharsetException e) {
//                    KLog.e("");
//                    KLog.e("Couldn't decode the response body; charset is likely malformed.");
//                    e.printStackTrace();
//                    return response;
//                }
//            }
//            StringBuilder sb = new StringBuilder();
//            if ("POST".equals(request.method())) {
//                if (request.body() instanceof FormBody) {
//                    FormBody body = (FormBody) request.body();
//                    for (int i = 0; i < body.size(); i++) {
//                        sb.append(body.encodedName(i) + "=" + body.encodedValue(i) + "&");
//                    }
//                    sb.delete(sb.length() - 1, sb.length());
//                }
//            }
//            if (contentLength != 0) {
//                long t1 = System.nanoTime();
//                if (sb.toString().length() > 0) {
//                    KLog.i("OkHttp:", String.format("Sending %s request %s on %s%n%s", request.method(), request.url() + "?" + sb.toString(), chain.connection(), request.headers()));
//                } else {
//                    KLog.i("OkHttp:", String.format("Sending %s request %s on %s%n%s", request.method(), request.url(), chain.connection(), request.headers()));
//                }
//                long t2 = System.nanoTime();
//                if (sb.toString().length() > 0) {
//                    KLog.i("OkHttp:", String.format("Received response for %s in %.1fms%n%s", response.request().url() + "?" + sb.toString(), (t2 - t1) / 1e6d, response.headers()));
//                } else {
//                    KLog.i("OkHttp:", String.format("Received response for %s in %.1fms%n%s", response.request().url(), (t2 - t1) / 1e6d, response.headers()));
//                }
//                KLog.i("--------------------------------------------开始打印返回数据----------------------------------------------------");
//                KLog.json(buffer.clone().readString(charset));
//                KLog.i("--------------------------------------------结束打印返回数据----------------------------------------------------");
//            }
//
//            return response;
//        }
//    };
//
//    /**
//     * 登录跳转拦截器
//     */
//    private static final Interceptor INVOKER_LOGIN_INTERCEPTOR = new Interceptor() {
//        @Override
//        public Response intercept(Chain chain) throws IOException {
//            final Request request = chain.request();
//            final Response response = chain.proceed(request);
//
//            final ResponseBody responseBody = response.body();
//
//            BufferedSource source = responseBody.source();
//            source.request(Long.MAX_VALUE); // Buffer the entire body.
//            Buffer buffer = source.buffer();
//            Charset charset = Charset.forName("UTF-8");
//            try {
//                JSONObject jsonObject = new JSONObject(buffer.clone().readString(charset));
//                if (jsonObject.has("success") && !jsonObject.getBoolean("success")) {
//                    if (jsonObject.has("code") && jsonObject.getInt("code") == 403) {
//                        SharedPreferencesUtil sharedPreferencesUtil = new SharedPreferencesUtil(MainApplication.getApplication(), Table.ConfigSetting.TableName);
//                        boolean isGestureLockOpen = sharedPreferencesUtil.getBoolean(Table.ConfigSetting.IsGestureLockOpen, false);
//                        if (isGestureLockOpen) {
//                            Intent intent = new Intent();
//                            intent.putExtra(ExtraKey.InvokeLogin, true);
//                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                            intent.setClass(MainApplication.getApplication(), GestureLoginActivity.class);
//                            MainApplication.getApplication().startActivity(intent);
//                        } else {
//                            Intent intent = new Intent();
//                            intent.putExtra(ExtraKey.InvokeLogin, true);
//                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                            intent.setClass(MainApplication.getApplication(), LoginActivity.class);
//                            MainApplication.getApplication().startActivity(intent);
//                        }
//                    }
//                }
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//            return response;
//        }
//    };
//
//    /**
//     * 获取OkHttpClient实例
//     *
//     * @return OkHttpClient实例
//     */
//    private static OkHttpClient getOkHttpClient() {
//        if (okHttpClient == null) {
//            synchronized (OkHttpClient.class) {// 同步访问
//                if (okHttpClient == null) {
//                    // 网络请求相关缓存
//                    File cacheFile = new File(MainApplication.getApplication().getCacheDir(), "responses");
//                    Cache cache = new Cache(cacheFile, DEFAULT_CACHE_SIZE);
//                    okHttpClient = new OkHttpClient.Builder()
//                            .cache(cache)
//                            .writeTimeout(60, TimeUnit.SECONDS)
//                            .readTimeout(100, TimeUnit.SECONDS)
//                            .connectTimeout(60, TimeUnit.SECONDS)
//                            // 添加相关拦截器
//                            .addInterceptor(SAVE_COOKIES_INTERCEPTOR)
//                            .addInterceptor(ADD_COOKIES_INTERCEPTOR)
//                            .addNetworkInterceptor(RESPONSE_INTERCEPTOR)
//                            .addInterceptor(REQUEST_INTERCEPTOR)
//                            .addInterceptor(LOGGING_INTERCEPTOR)
//                            .addInterceptor(INVOKER_LOGIN_INTERCEPTOR)
//                            .build();
//                }
//            }
//        }
//        return okHttpClient;
//    }

    /**
     * 处理Json不规范带来的问题
     */
    private static Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    /**
     * 创建Service
     *
     * @param baseUrl      base url
     * @param serviceClazz 定义的服务类（通常是接口）
     * @param <T>          泛形，对应与定义的服务类
     * @return 定义的服务类
     */
    public static <T> T createService(String baseUrl, Class<T> serviceClazz) {
        Retrofit retrofit = new Retrofit.Builder()
//                .client(getOkHttpClient())
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(serviceClazz);
    }
}
