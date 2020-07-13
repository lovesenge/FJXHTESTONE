package com.rzhy.fjxhznfz.mvp.znfz;

import com.rzhy.fjxhznfz.mvp.BasePresenter;
import com.rzhy.fjxhznfz.rxjava.BaseMyApiCallBack;
import com.rzhy.fjxhznfz.rxjava.ObserverCallBack;

/**
 * Created by SenGe on 2020-06-23.
 */

public class DiagnosePresenter extends BasePresenter<DiagnoseView> {

    public DiagnosePresenter(DiagnoseView view) {
        this.mvpView = view;
    }

    public void getGuideDiagnose1(String id){
        mvpView.showLoading("加载中...");
        addSubscription(httpService.getGuideDiagnose1(id), new ObserverCallBack<>(new BaseMyApiCallBack<DiagnoseModel>() {


            @Override
            public void onSuccess(DiagnoseModel model) {
                if (model.getData().getGuideDiagnose().getIsEnd()==0) {
                    mvpView.isNotEnd(model);
                }else{
                    mvpView.isEnd(model);
                }
//                mvpView.getDpSuccess(model);
            }

            @Override
            public void onFinish() {
                mvpView.hideLoading();
            }
        }));
    }

    public void getGuideDiagnose2(String id,String isSelected,String diagnoseId){
        mvpView.showLoading("加载中...");
        addSubscription(httpService.getGuideDiagnose2(id,isSelected,diagnoseId), new ObserverCallBack<>(new BaseMyApiCallBack<DiagnoseModel>() {


            @Override
            public void onSuccess(DiagnoseModel model) {
                if (model.getData().getGuideDiagnose().getIsEnd()==0) {
                    mvpView.isNotEnd(model);
                }else{
                    mvpView.isEnd(model);
                }
//                mvpView.getDpSuccess(model);
            }

            @Override
            public void onFinish() {
                mvpView.hideLoading();
            }
        }));
    }

}

