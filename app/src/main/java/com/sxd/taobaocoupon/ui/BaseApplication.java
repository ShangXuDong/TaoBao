package com.sxd.taobaocoupon.ui;

import android.app.Application;
import android.content.Context;


public class BaseApplication extends Application {

    public static Context APP_CONTEXT = null;

    @Override
    public void onCreate() {
        super.onCreate();
        APP_CONTEXT = getBaseContext();
//        RxTool.init(this);
    }


}
