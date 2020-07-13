package com.rzhy.fjxhznfz.mvp;

public interface Presenter<V> {

    void attachView(V view);

    void detachView();

}
