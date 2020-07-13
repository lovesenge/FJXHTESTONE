package com.rzhy.fjxhznfz.mvp.znfz;

import com.rzhy.fjxhznfz.mvp.BasePresenter;
import com.rzhy.fjxhznfz.rxjava.BaseMyApiCallBack;
import com.rzhy.fjxhznfz.rxjava.ObserverCallBack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SenGe on 2020-06-23.
 */

public class SymptomPresenter extends BasePresenter<SymptomView> {
    private List<Map<String, Object>> data = new ArrayList<>();

    public SymptomPresenter(SymptomView view) {
        this.mvpView = view;
    }

    public void getSymptom(String id,String sex) {
        mvpView.showLoading("加载中...");
        addSubscription(httpService.getGuideSymptom(id,sex), new ObserverCallBack<>(new BaseMyApiCallBack<SymptomModel>() {

            @Override
            public void onSuccess(SymptomModel model) {
                for (int i = 0; i < model.getData().getList().size(); i++) {
                    Map<String, Object> map = new HashMap<>();
                    map.put("symptomName", model.getData().getList().get(i).getSymptomName());
                    map.put("id", model.getData().getList().get(i).getId());
                    data.add(map);
                }
                mvpView.getDpSuccess(data);
            }

            @Override
            public void onFinish() {
                mvpView.hideLoading();
            }

        }));
    }
}
