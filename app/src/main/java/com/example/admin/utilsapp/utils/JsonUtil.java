package com.example.admin.utilsapp.utils;

import com.google.gson.Gson;

/**
 * Created by Woodslake on 2017/3/2.
 */

public class JsonUtil {
    private JsonUtil(){}

    /**
     * 对象转换成json字符串
     * @param obj
     * @return
     */
    public static String toJson(Object obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

    /**
     * json字符串转成对象
     * @param str
     * @param type
     * @return
     */
    public static <T> T fromJson(String str, Class<T> type) {
        Gson gson = new Gson();
        return gson.fromJson(str, type);
    }

    /**
     * 数组转字符串
     *
     * */
    public static String toString(String[] string) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < string.length; i++) {
            sb.append(string[i]);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
