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

public class PicFrgPresenter extends BasePresenter<PicFrgView> {
    private List<Map<String, Object>> data = new ArrayList<>();

    public PicFrgPresenter(PicFrgView view) {
        this.mvpView = view ;
    }

    public void getBodyList(){
        mvpView.showLoading("加载中...");

        addSubscription(httpService.getGuideBody(), new ObserverCallBack<>(new BaseMyApiCallBack<ListBodyModel>(){

            @Override
            public void onSuccess(ListBodyModel model) {
                for (int i = 0; i < model.getData().getList().size(); i++) {
                    if (model.getData().getList().get(i).getStatus() == 1) {
                        Map<String ,Object> map = new HashMap<>();
                        map.put("bodyName",model.getData().getList().get(i).getBodyName());
                        map.put("id",model.getData().getList().get(i).getId());
                        data.add(map);
                    }
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
