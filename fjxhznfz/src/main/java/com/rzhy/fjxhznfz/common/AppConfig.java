package com.rzhy.fjxhznfz.common;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by 38272 on 2018/2/6.
 */

public class AppConfig {
    private static AppConfig mInstance;
    /* 配置文件名称 */
    public static final String CONFIG_NAME = "fjxhznfz.cfg";
    private static SharedPreferences mSharePreferences;
    // 微信支付签名
    // APP_ID 替换为你的应用从官方网站申请到的合法appId
    public static final String APP_ID = "wx1ff291ddcacdb9f9";

    private AppConfig(Context paramContext) {
        mSharePreferences = paramContext.getSharedPreferences(CONFIG_NAME, Context.MODE_PRIVATE);
    }

    public static AppConfig getInstatce(Context paramContext){
       if(mInstance == null){
           mInstance = new AppConfig(paramContext);
       }
       return mInstance;
    }

    /**
     * 删除配置项
     *
     * @param key
     * @return
     */
    public boolean removeConfigItem(String key) {
        return mSharePreferences.edit().remove(key).commit();
    }


    /**
     * 取长整型
     *
     * @param key
     * @param defValue
     * @return
     */
    public long getLong(String key, long defValue) {
        return mSharePreferences.getLong(key, defValue);
    }

    /**
     * 赋值长整型的值
     *
     * @param key
     * @param value
     */
    public void setValue(String key, long value) {
        mSharePreferences.edit().putLong(key, value).commit();
    }

    /**
     * 取整型的值
     *
     * @param key
     * @param defValue
     * @return
     */
    public int getInt(String key, int defValue) {
        return mSharePreferences.getInt(key, defValue);
    }

    /**
     * 取字符型的值
     *
     * @param key
     * @param defValue
     * @return
     */
    public String getString(String key, String defValue) {
        return mSharePreferences.getString(key, defValue);
    }

    /**
     * 赋值整型的值
     *
     * @param key
     * @param value
     */
    public void setValue(String key, int value) {
        mSharePreferences.edit().putInt(key, value).commit();
    }

    /**
     * 赋值字符型的值
     *
     * @param key
     * @param value
     */
    public void setValue(String key, String value) {
        mSharePreferences.edit().putString(key, value).commit();
    }

    /**
     * 获取BOOLEAN型
     *
     * @Title: getBoolean
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param key
     * @param @param defValue
     * @param @return 设定文件
     * @return boolean 返回类型
     * @throws
     */
    public boolean getBoolean(String key, Boolean defValue) {
        return mSharePreferences.getBoolean(key, defValue);
    }

    /**
     * 设置BOOLEAN
     *
     * @Title: setValue
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param key
     * @param @param value 设定文件
     * @return void 返回类型
     * @throws
     */
    public void setValue(String key, Boolean value) {
        mSharePreferences.edit().putBoolean(key, value).commit();


    }

    /**
     * 是否包括KEY
     *
     * @Title: contains
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param key
     * @param @return 设定文件
     * @return boolean 返回类型
     * @throws
     */
    public boolean contains(String key) {
        return mSharePreferences.contains(key);
    }
}
