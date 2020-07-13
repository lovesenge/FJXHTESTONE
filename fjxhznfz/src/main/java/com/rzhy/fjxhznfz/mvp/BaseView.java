package com.rzhy.fjxhznfz.mvp;


public interface BaseView<T> {
    void showLoading(String msg);
    void hideLoading();
    void onSuccess(T t);
    void onFailure(int code, String msg);
}
