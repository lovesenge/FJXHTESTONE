package com.rzhy.fjxhznfz.ui.znfz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.rzhy.fjxhznfz.R;
import com.rzhy.fjxhznfz.mvp.BasePresenter;
import com.rzhy.fjxhznfz.mvp.BaseView;
import com.rzhy.fjxhznfz.mvp.MvpActivity;
import com.shizhefei.view.indicator.FixedIndicatorView;
import com.shizhefei.view.indicator.IndicatorViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SenGe on 2020-06-23.
 */

public class ZnfzActivity extends MvpActivity implements BaseView {

    public static void goTo(Context context){
        Intent intent = new Intent(context,ZnfzActivity.class);
        context.startActivity(intent);
    }

    ViewPager guideViewPager;

    FixedIndicatorView guideIndicator;

    RadioButton radioLeft;

    RadioButton radioRight;

    RadioGroup radioGroup;

    RadioButton radioMan;

    RadioButton radioWomen;

    RadioGroup radioGroup2;

    private IndicatorViewPager indicatorViewPager;
    private LayoutInflater inflate;

    private List<Fragment> fragments = new ArrayList<Fragment>();
    private ZnfzAdapter znfzAdapter;

    private PicFragment picFragment = new PicFragment();
    private ListFragment listFragment = new ListFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_znfz);
        initView();
        init();
    }

    private void initView(){
        guideViewPager = findViewById(R.id.guide_viewPager);
        guideIndicator = findViewById(R.id.guide_indicator);
        radioLeft = findViewById(R.id.radio_left);
        radioRight = findViewById(R.id.radio_right);
        radioGroup = findViewById(R.id.radio_group);
        radioMan = findViewById(R.id.radio_man);
        radioWomen = findViewById(R.id.radio_women);
        radioGroup2 = findViewById(R.id.radio_group2);
    }

    private void init() {
        initTitle("智能分诊");

        indicatorViewPager = new IndicatorViewPager(guideIndicator, guideViewPager);
        inflate = LayoutInflater.from(getApplicationContext());
        znfzAdapter = new ZnfzAdapter(getSupportFragmentManager(), inflate, fragments);
        indicatorViewPager.setAdapter(znfzAdapter);

        initData();
        initEvent();
    }
    private void initEvent() {
        radioLeft.setChecked(true);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radio_left) {
                    indicatorViewPager.setCurrentItem(0, false);
                    radioGroup2.setVisibility(View.VISIBLE);

                } else if (checkedId == R.id.radio_right) {
                    indicatorViewPager.setCurrentItem(1, false);
                    radioGroup2.setVisibility(View.GONE);

                }
            }
        });

        indicatorViewPager.setOnIndicatorPageChangeListener(new IndicatorViewPager.OnIndicatorPageChangeListener() {
            @Override
            public void onIndicatorPageChange(int preItem, int currentItem) {
                if (currentItem == 0) {
                    radioLeft.setChecked(true);
                } else {
                    radioRight.setChecked(true);
                }
            }
        });
        radioMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                picFragment.setGender(1);
                listFragment.setGender(1);
                // 刷新正面标识
                picFragment.setSide(false);
                picFragment.upUI();
            }
        });
        radioWomen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                picFragment.setGender(2);
                listFragment.setGender(2);
                // 刷新正面标识
                picFragment.setSide(false);
                picFragment.upUI();
            }
        });
    }

    private void initData() {
        fragments.clear();
        fragments.add(picFragment);
        fragments.add(listFragment);
        znfzAdapter.notifyDataSetChanged();
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
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
