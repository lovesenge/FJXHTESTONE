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
import com.rzhy.fjxhznfz.mvp.znfz.SymptomPresenter;
import com.rzhy.fjxhznfz.mvp.znfz.SymptomView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by SenGe on 2020-06-23.
 */

public class BodyPositionActivity extends MvpActivity<SymptomPresenter> implements SymptomView {

    public static void goTo(Context context, String id, String name, String sex) {
        Intent intent = new Intent(context, BodyPositionActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("bodyName", name);
        intent.putExtra("sex", sex);
        context.startActivity(intent);
    }

    ListView symptomList;

    TextView tvMzks;

    private SimpleAdapter adapter;
    private List<Map<String, Object>> data = new ArrayList<>();

    private String id;
    private String bodyName;
    private String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_znfz_symptom);

        symptomList = findViewById(R.id.symptom_list);
        tvMzks = findViewById(R.id.tv_mzks);

        init();
        initEvent();
    }

    private void initEvent() {
        symptomList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DiagnoseActivity.goTo(mActivity,data.get(position).get("id").toString(),data.get(position).get("symptomName").toString());
            }
        });

    }

    private void init() {
        id = getIntent().getStringExtra("id");
        bodyName = getIntent().getStringExtra("bodyName");
        gender = getIntent().getStringExtra("sex");
        tvMzks.setText(bodyName);

        initTitle("智能分诊");
        adapter = new SimpleAdapter(
                mActivity,
                data,
                R.layout.base_item_title_arrow,
                new String[]{
                        "symptomName"
                },
                new int[]{
                        R.id.title
                }
        );
        symptomList.setAdapter(adapter);

        initData();
    }

    private void initData() {
        mvpPresenter.getSymptom(id, gender);
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
    protected SymptomPresenter createPresenter() {
        return new SymptomPresenter(this);
    }
}
