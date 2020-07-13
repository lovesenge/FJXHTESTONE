package com.rzhy.fjxhznfz.common;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

/**
 * Created by SenGe on 2020-06-12.
 */

public class AppApplication extends MultiDexApplication {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getmContext() {
        return mContext;
    }
}
