package com.example.admin.utilsapp.api;

/**
 * Created by admin on 2017/11/15.
 */

public class Server {

    public static String ApiUrl = null;
    public static String TrjUrl = null;
    public static String ApiWap = null;

    //测试环境
    private static final String ApiUrl_Test = "http://uatlweb.lcshidai.com/";
    private static final String ApiWap_Test = "http://uatlwap.lcshidai.com/";
    private static final String TrjUrl_Test = "http://uatweb.lcshidai.com/";
    //运维环境
    private static final String ApiUrl_Maintain = "http://uatjkweb.tourongjia.com/";
    private static final String ApiWap_Maintain = "http://uatjkwap.tourongjia.com/";
    private static final String TrjUrl_Maintain = "http://uatweb.lcshidai.com/";
    //生产环境
    private static final String ApiUrl_Produce = "http://gank.io/";
    private static final String ApiWap_Produce = "http://web.changxiangstyle.com/";
    private static final String TrjUrl_Produce = "https://www.lcshidai.com/";

    private enum ServerType{
        TEST,       //测试
        MAINTAIN,   //运维
        PRODUCE     //生产
    }

    private static ServerType serverType = ServerType.PRODUCE;

    static {
        switch (serverType){
            case TEST:
                ApiUrl = ApiUrl_Test;
                TrjUrl = TrjUrl_Test;
                ApiWap = ApiWap_Test;
                break;
            case MAINTAIN:
                ApiUrl = ApiUrl_Maintain;
                TrjUrl = TrjUrl_Maintain;
                ApiWap = ApiWap_Maintain;
                break;
            case PRODUCE:
                ApiUrl = ApiUrl_Produce;
                TrjUrl = TrjUrl_Produce;
                ApiWap = ApiWap_Produce;
                break;
        }
    }
}
