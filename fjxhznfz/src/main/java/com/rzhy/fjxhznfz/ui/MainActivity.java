package com.rzhy.fjxhznfz.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.rzhy.fjxhznfz.R;
import com.rzhy.fjxhznfz.mvp.BasePresenter;
import com.rzhy.fjxhznfz.mvp.MvpActivity;
import com.rzhy.fjxhznfz.ui.patient.PatientListActivity;
import com.rzhy.fjxhznfz.ui.znfz.ZnfzActivity;


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

                ZnfzActivity.goTo(MainActivity.this);
            }
        });
    }
}
