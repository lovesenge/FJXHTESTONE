package com.rzhy.fjxhznfz.ui.znfz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.rzhy.fjxhznfz.R;
import com.rzhy.fjxhznfz.mvp.MvpFragment;
import com.rzhy.fjxhznfz.mvp.znfz.ListFrgPresenter;
import com.rzhy.fjxhznfz.mvp.znfz.ListFrgView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by SenGe on 2020-06-23.
 */

public class ListFragment extends MvpFragment<ListFrgPresenter> implements ListFrgView {

    ListView listview;

    // 1是男性 2是女性
    private int gender = 1;

    private SimpleAdapter adapter;
    private List<Map<String ,Object>> data = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_znfz_page02, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listview = view.findViewById(R.id.listview);
        init();
        initEvent();
    }

    private void initEvent() {
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BodyPositionActivity.goTo(mActivity,data.get(position).get("id").toString(),data.get(position).get("bodyName").toString(),gender+"");
            }
        });
    }

    private void init() {
        adapter = new SimpleAdapter(
                mActivity,
                data,
                R.layout.base_item_title_arrow,
                new String []{
                        "bodyName"
                },
                new int[]{
                        R.id.title
                }
        );
        listview.setAdapter(adapter);

        initData();
    }

    private void initData() {
        mvpPresenter.getBodyList();
    }


    @Override
    public void showLoading(String msg) {
        showProgress(msg);
    }

    @Override
    public void hideLoading() {
        hideProgress();
    }

    @Override
    public void onSuccess(Object o) {

    }

    @Override
    public void onFailure(int code, String msg) {

    }

    @Override
    public void getDpSuccess(List<Map<String, Object>> testModel) {
        data.clear();
        data.addAll(testModel);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected ListFrgPresenter createPresenter() {
        return new ListFrgPresenter(this);
    }

    public void upUI() {
        init();
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
