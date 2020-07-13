package com.rzhy.fjxhpay.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.rzhy.fjxhpay.R;
import com.rzhy.fjxhpay.mvp.BasePresenter;
import com.rzhy.fjxhpay.mvp.MvpActivity;
import com.rzhy.fjxhpay.ui.patient.PatientListActivity;


public class MainActivity extends MvpActivity {

    TextView tvPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvPay = findViewById(R.id.tv_pay);
        init();
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    private void init(){
        tvPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(mActivity, PatientListActivity.class);
//                intent.putExtra("userId","");
//                startActivity(intent);

                PatientListActivity.goTo(MainActivity.this, "15528" ,1,"wx1ff291ddcacdb9f9");
            }
        });
    }
}
