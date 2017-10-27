package com.example.admin.utilsapp.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/**
 * 应用信息
 */

public class AppInfoUtil {

    public static String getPackageName(Context context){
        return context.getPackageName();
    }

    public static String getVersionName(Context context){
        String versionName = null;
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            versionName = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName;
    }

    public static int getVersionCode(Context context){
        int versionCode = 0;
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            versionCode = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }

    public static String getApplicationMetaData(Context context, String name){
        if(context == null || TextUtils.isEmpty(name)){
            return null;
        }
        String metaData = null;
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            if(packageManager != null){
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, PackageManager.GET_META_DATA);
                if(applicationInfo != null && applicationInfo.metaData != null){
                    metaData = applicationInfo.metaData.getString(name);
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return metaData;
    }

}
