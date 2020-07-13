package com.rzhy.fjxhznfz.ui.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.rzhy.fjxhznfz.R;

/**
 * Created by SenGe on 2020-06-23.
 */

public class BaseFragment extends Fragment {
    public Activity mActivity;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mActivity = getActivity();
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
    }



    public void showProgress(String text) {
        if (((BaseActivity) mActivity).mProgressDialog == null) {
            ((BaseActivity) mActivity).mProgressDialog = new ProgressDialog(mActivity);
            ((BaseActivity) mActivity).mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        }
        ((BaseActivity) mActivity).mProgressDialog.setMessage(text);
        ((BaseActivity) mActivity).mProgressDialog.show();
    }

    public void hideProgress() {
        if (((BaseActivity) mActivity).mProgressDialog != null) {
            ((BaseActivity) mActivity).mProgressDialog.dismiss();
        }
    }
}
