package com.rzhy.fjxhznfz.ui.znfz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.rzhy.fjxhznfz.R;
import com.rzhy.fjxhznfz.mvp.MvpActivity;
import com.rzhy.fjxhznfz.mvp.znfz.DiagnoseInfoPresenter;
import com.rzhy.fjxhznfz.mvp.znfz.DiagnoseInfoView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SenGe on 2020-06-23.
 */

public class DiagnoseInfoActivity extends MvpActivity<DiagnoseInfoPresenter> implements DiagnoseInfoView {

    public static void goTo(Context context, String id, String isSelected, String title) {
        Intent intent = new Intent(context, DiagnoseInfoActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("isSelected", isSelected);
        intent.putExtra("symptomName", title);
//        intent.putExtra("diagnoseId", diagnoseId);
        context.startActivity(intent);
    }


    TextView resultMessage;

    ListView listview;
    private String symptomName;
    private String id;
    private String isSelected;
    private SimpleAdapter adapter;
    private List<Map<String, Object>> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_znfz_result);
        resultMessage = findViewById(R.id.result_message);
        listview = findViewById(R.id.listview);
        init();
    }

    private void init() {
        id = getIntent().getStringExtra("id");
        isSelected = getIntent().getStringExtra("isSelected");
        symptomName = getIntent().getStringExtra("symptomName");

        initTitle(symptomName);
        initData();
        initEvent();
    }

    private void initData() {

//        // 请求数据
////        mvpPresenter.getGuideDiagnose2(id, isSelected, id);
//
//        adapter = new SimpleAdapter(
//                mActivity,
//                data,
//                R.layout.base_item_title_arrow,
//                new String[]{
//                        "dpList"
//                },
//                new int[]{
//                        R.id.title
//                }
//        );
//        listview.setAdapter(adapter);
//
//        // 设置列表数据
//        String dpLists[] =isSelected.split(",");
//        for (int i = 0; i < dpLists.length; i++) {
//            Map<String, Object> map = new HashMap<>();
//            map.put("dpList", dpLists[i]);
//            data.add(map);
//        }
//        adapter.notifyDataSetChanged();
        // 内容设置
        resultMessage.setText(id);

    }

    /*监听*/
    private void initEvent() {
//        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                mvpPresenter.getDepartments(data.get(position).get("dpList").toString());
//            }
//        });
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
    public void getDpSuccess(Map<String, Object> data) {

    }

    @Override
    protected DiagnoseInfoPresenter createPresenter() {
        return new DiagnoseInfoPresenter(this);
    }
}
