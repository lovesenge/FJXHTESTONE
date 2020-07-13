package com.rzhy.fjxhznfz.ui.znfz;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rzhy.fjxhznfz.R;
import com.shizhefei.view.indicator.IndicatorViewPager;

import java.util.List;

/**
 * Created by SenGe on 2020-06-23.
 */

public class ZnfzAdapter extends IndicatorViewPager.IndicatorFragmentPagerAdapter  {
    private LayoutInflater inflater;
    private List<Fragment> fragmentList;
    private FragmentManager fragmentManager;

    public ZnfzAdapter(FragmentManager fragmentManager, LayoutInflater inflater,List<Fragment> fragmentList) {
        super(fragmentManager);
        this.fragmentManager = fragmentManager;
        this.inflater = inflater;
        this.fragmentList = fragmentList;
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public View getViewForTab(int position, View convertView, ViewGroup container) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_tab_guide, container, false);
        }
        return convertView;
    }

    @Override
    public Fragment getFragmentForPage(int position) {
        return fragmentList.get(position);
    }
}
