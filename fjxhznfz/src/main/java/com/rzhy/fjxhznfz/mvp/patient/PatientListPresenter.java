package com.rzhy.fjxhznfz.mvp.patient;

import com.rzhy.fjxhznfz.mvp.BasePresenter;
import com.rzhy.fjxhznfz.rxjava.BaseMyApiCallBack;
import com.rzhy.fjxhznfz.rxjava.ObserverCallBack;

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
