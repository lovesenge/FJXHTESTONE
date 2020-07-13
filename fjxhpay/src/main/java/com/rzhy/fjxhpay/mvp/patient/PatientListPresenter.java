package com.rzhy.fjxhpay.mvp.patient;

import com.rzhy.fjxhpay.mvp.BasePresenter;
import com.rzhy.fjxhpay.rxjava.BaseMyApiCallBack;
import com.rzhy.fjxhpay.rxjava.ObserverCallBack;

/**
 * Created by SenGe on 2020-06-12.
 */

public class PatientListPresenter extends BasePresenter<PatientListView> {

    public PatientListPresenter(PatientListView view) {
        this.mvpView = view;
    }

    public void getBindUserListFromServer() {
        mvpView.showLoading("");
        addSubscription(httpService.getPatientList(), new ObserverCallBack<>(new BaseMyApiCallBack<PatientListModel>() {
            @Override
            public void onSuccess(PatientListModel model) {
                mvpView.getPatientListSuccess(model);
            }

            @Override
            public void onFinish() {
                mvpView.hideLoading();
            }

        }));
    }
}
