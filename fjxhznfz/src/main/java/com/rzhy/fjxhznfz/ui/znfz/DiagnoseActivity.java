package com.rzhy.fjxhznfz.ui.znfz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rzhy.fjxhznfz.R;
import com.rzhy.fjxhznfz.mvp.MvpActivity;
import com.rzhy.fjxhznfz.mvp.znfz.DiagnoseModel;
import com.rzhy.fjxhznfz.mvp.znfz.DiagnosePresenter;
import com.rzhy.fjxhznfz.mvp.znfz.DiagnoseView;

/**
 * Created by SenGe on 2020-06-23.
 */

public class DiagnoseActivity extends MvpActivity<DiagnosePresenter> implements DiagnoseView {

    public static void goTo(Context context, String id, String symptomName) {
        Intent intent = new Intent(context, DiagnoseActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("symptomName", symptomName);
        context.startActivity(intent);
    }

    TextView alertMessage;

    Button btnYes;

    Button btnNo;
    private String id;
    private String symptomName;

    private String isEnd;
    private DiagnoseModel diagnoseModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_znfz_diagnose);
        alertMessage = findViewById(R.id.alert_message);
        btnYes = findViewById(R.id.btn_yes);
        btnNo = findViewById(R.id.btn_no);
        init();
    }

    private void init() {


        id = getIntent().getStringExtra("id");
        symptomName = getIntent().getStringExtra("symptomName");
        initTitle(symptomName);

        initData();
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mvpPresenter.getGuideDiagnose2(id, "1", diagnoseModel.getData().getGuideDiagnose().getId() + "");
            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mvpPresenter.getGuideDiagnose2(id, "0", diagnoseModel.getData().getGuideDiagnose().getId() + "");
            }
        });
    }

    private void initData() {
        mvpPresenter.getGuideDiagnose1(id);
    }

    @Override
    protected DiagnosePresenter createPresenter() {
        return new DiagnosePresenter(this);
    }

    @Override
    public void isEnd(DiagnoseModel model) {
        diagnoseModel = model;
        DiagnoseInfoActivity.goTo(
                mActivity,
                diagnoseModel.getData().getGuideDiagnose().getDiagnoseContent(),
                diagnoseModel.getData().getGuideDiagnose().getDpList() + "",
                symptomName);
        finish();
    }

    @Override
    public void isNotEnd(DiagnoseModel model) {
        diagnoseModel = model;
        alertMessage.setText(diagnoseModel.getData().getGuideDiagnose().getDiagnoseContent());
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




}
