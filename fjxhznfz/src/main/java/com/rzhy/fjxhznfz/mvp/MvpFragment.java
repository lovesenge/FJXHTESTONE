package com.rzhy.fjxhznfz.mvp;

import android.os.Bundle;
import android.view.View;

import com.rzhy.fjxhznfz.ui.base.BaseFragment;


/**
 * Created by SenGe on 2020-06-23.
 */

public abstract class MvpFragment<P extends BasePresenter> extends BaseFragment {
    protected P mvpPresenter;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mvpPresenter = createPresenter();
    }

    protected abstract P createPresenter();


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mvpPresenter != null) {
            mvpPresenter.detachView();
        }
    }
}