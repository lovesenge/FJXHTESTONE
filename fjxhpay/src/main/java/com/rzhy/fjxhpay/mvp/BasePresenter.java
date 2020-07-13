package com.rzhy.fjxhpay.mvp;


import com.rzhy.fjxhpay.retrofit.HttpService;
import com.rzhy.fjxhpay.retrofit.RetrofitManager;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class BasePresenter<V> implements Presenter<V> {
    public V mvpView;
    public HttpService httpService = RetrofitManager.retrofit().create(HttpService.class);
    protected CompositeDisposable mCompositeDisposable;

    @Override
    public void attachView(V mvpView) {
        this.mvpView = mvpView;
    }


    @Override
    public void detachView() {
        this.mvpView = null;
        onUnsubscribe();
    }


    //RXjava取消注册，以避免内存泄露
    public void onUnsubscribe() {
        if (mCompositeDisposable != null && mCompositeDisposable.isDisposed()) {
            mCompositeDisposable.dispose();
        }
    }


    public void addSubscription(Observable<?> observable, DisposableObserver observer) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(observer));
    }
}
