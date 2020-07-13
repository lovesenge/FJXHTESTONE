package com.rzhy.fjxhznfz.mvp.znfz;

import com.rzhy.fjxhznfz.mvp.BasePresenter;
import com.rzhy.fjxhznfz.rxjava.BaseMyApiCallBack;
import com.rzhy.fjxhznfz.rxjava.ObserverCallBack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SenGe on 2020-06-23.
 */

public class DiagnoseInfoPresenter extends BasePresenter<DiagnoseInfoView> {

    public DiagnoseInfoPresenter(DiagnoseInfoView view) {
        this.mvpView = view;
    }

    public void getDepartments(final String ksmc) {
        mvpView.showLoading("加载中...");
        addSubscription(httpService.getDepartments(), new ObserverCallBack<>(new BaseMyApiCallBack<YyghModel>() {
            @Override
            public void onSuccess(YyghModel model) {
                if ("1".equals(model.getRet())) {
                    Map<String, Object> data = new HashMap<>();
                    for (int i = 0; i < model.getData().getList().size(); i++) {
                        if (ksmc.equals(model.getData().getList().get(i).getKsmc())) {
                            data.put("ksmc", model.getData().getList().get(i).getKsmc());
                            data.put("ksdm", model.getData().getList().get(i).getKsdm());
                            break;
                        }
                    }
                    mvpView.getDpSuccess(data);
                } else {
                }
            }

            @Override
            public void onFinish() {
                mvpView.hideLoading();
            }
        }));
    }
}
