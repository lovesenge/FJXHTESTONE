package com.rzhy.fjxhpay.mvp;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rzhy.fjxhpay.R;
import com.rzhy.fjxhpay.ui.base.BaseActivity;


public abstract class MvpActivity<P extends BasePresenter> extends BaseActivity {
    protected P mvpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mvpPresenter = createPresenter();
        super.onCreate(savedInstanceState);
    }

    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mvpPresenter != null) {
            mvpPresenter.detachView();
        }
    }

    public void initTitle(String title) {
        TextView tvTitle = (TextView) findViewById(R.id.titlebar_title);
        ImageView ivLeft = (ImageView) findViewById(R.id.titlebar_left_img);
//        ImageView ivRight = (ImageView) findViewById(R.id.titlebar_right_img);
        tvTitle.setText(title);
        ivLeft.setImageResource(R.drawable.ic_chevron_left);
        ivLeft.setBackgroundResource(R.drawable.base_selector);
        ivLeft.setVisibility(View.VISIBLE);
        ivLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
