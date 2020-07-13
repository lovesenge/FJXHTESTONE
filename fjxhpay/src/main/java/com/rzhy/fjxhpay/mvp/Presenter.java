package com.rzhy.fjxhpay.mvp;

public interface Presenter<V> {

    void attachView(V view);

    void detachView();

}
