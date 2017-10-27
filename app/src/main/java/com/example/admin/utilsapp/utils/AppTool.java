package com.example.admin.utilsapp.utils;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhengyu on 2017/5/11.
 * 获取手机上安装的app清单
 */

public class AppTool {

    private static Map<String, String> contact;

    public static String getAppList(PackageManager packageManager){
        List<PackageInfo> packages = packageManager.getInstalledPackages(0);
        List<Map<String, String>> appList = new ArrayList<>();
        for (int i = 0; i < packages.size(); i++){
            PackageInfo info = packages.get(i);
            //过滤掉系统app
            if ((ApplicationInfo.FLAG_SYSTEM & info.applicationInfo.flags) != 0) {
                continue;
            }
            contact = new HashMap<>();
            contact.put("name", info.applicationInfo.loadLabel(packageManager).toString());
            appList.add(contact);
        }
        String s = JsonUtil.toJson(appList);
        return s;
    }
}
