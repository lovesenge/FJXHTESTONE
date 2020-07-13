package com.rzhy.fjxh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.rzhy.fjxhpay.ui.patient.PatientListActivity;
import com.rzhy.fjxhznfz.ui.znfz.ZnfzActivity;


public class MainActivity extends AppCompatActivity {

    TextView tvPay;
    TextView tvZNFZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvPay = findViewById(R.id.tv_go_to_pay);
        tvZNFZ = findViewById(R.id.tv_go_to_znfz);

        tvPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PatientListActivity.goTo(MainActivity.this, "15528" ,1,"wx1ff291ddcacdb9f9");
            }
        });

        tvZNFZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZnfzActivity.goTo(MainActivity.this);
            }
        });

    }
}
