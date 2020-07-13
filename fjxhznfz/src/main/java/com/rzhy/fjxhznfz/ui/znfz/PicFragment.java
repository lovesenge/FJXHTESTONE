package com.rzhy.fjxhznfz.ui.znfz;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.rzhy.fjxhznfz.R;
import com.rzhy.fjxhznfz.mvp.MvpFragment;
import com.rzhy.fjxhznfz.mvp.znfz.PicFrgPresenter;
import com.rzhy.fjxhznfz.mvp.znfz.PicFrgView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by SenGe on 2020-06-23.
 */

public class PicFragment  extends MvpFragment<PicFrgPresenter> implements PicFrgView {

    ImageView image;
    ImageButton btImage;

    // 1是男性 2是女性
    private int gender = 1;

    private boolean isSide = false;

    private PhotoViewAttacher mAttacher;

    private List<Map<String, Object>> data = new ArrayList<>();
    private Map<String, float[]> map;
    private Map<String, float[]> map2;
    private Drawable bitmapMan;
    private Drawable bitmapWomen;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_znfz_page01, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        image = view.findViewById(R.id.image);
        btImage = view.findViewById(R.id.bt_image);

        btImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable bitmapManback = ContextCompat.getDrawable(mActivity, R.drawable.services_icon_znfz_manback);
                Drawable bitmapWomenback = ContextCompat.getDrawable(mActivity, R.drawable.services_icon_znfz_womenback);

                if (isSide) {
                    if (gender == 1) {
                        image.setImageDrawable(bitmapMan);
                    } else {
                        image.setImageDrawable(bitmapWomen);
                    }
                    setSide(false);
                }else {
                    if (gender == 1) {
                        image.setImageDrawable(bitmapManback);
                    } else {
                        image.setImageDrawable(bitmapWomenback);
                    }
                    setSide(true);
                }
            }
        });

        init();

    }

    public boolean isSide() {
        return isSide;
    }

    public void setSide(boolean side) {
        isSide = side;
    }

    private void init() {

        // 获取部位列表
        mvpPresenter.getBodyList();

        // 正面
        map = new HashMap<>();
        float[] toubu = {0.360F, 0.622F, 0.015F, 0.070F};
        map.put("头部", toubu);

        float[] jinbu = {0.360F, 0.622F, 0.150F, 0.206F};
        map.put("颈部", jinbu);

        float[] xiongbu = {0.360F, 0.652F, 0.206F, 0.316F};
        map.put("胸部", xiongbu);

        float[] fubu = {0.360F, 0.622F, 0.316F, 0.416F};
        map.put("腹部", fubu);

        float[] shengzhi = {0.360F, 0.622F, 0.416F, 0.546F};
        map.put("生殖器", shengzhi);

//        float[] paixiebu = {0.360F, 0.622F, 0.416F, 0.546F};
//        map.put("排泄部", paixiebu);

//        float[] beibu = {0.360F, 0.622F, 0.205F, 0.516F};
//        map.put("背部", beibu);

        float[] eryan = {0.360F, 0.622F, 0.070F, 0.156F};
        map.put("耳眼口鼻", eryan);

        float[] shagnzhi1 = {0.060F, 0.272F, 0.315F, 0.596F};
        map.put("上肢1", shagnzhi1);

        float[] shagnzhi2 = {0.622F, 0.872F, 0.315F, 0.596F};
        map.put("上肢2", shagnzhi2);

        float[] xiazhi = {0.320F, 0.642F, 0.605F, 0.906F};
        map.put("下肢", xiazhi);

        // 反面
        map2 = new HashMap<>();
        float[] toubu2 = {0.360F, 0.622F, 0.015F, 0.070F};
        map2.put("头部", toubu2);

        float[] jinbu2 = {0.360F, 0.622F, 0.150F, 0.206F};
        map2.put("颈部", jinbu2);

        float[] paixiebu2 = {0.360F, 0.622F, 0.416F, 0.546F};
        map2.put("排泄部", paixiebu2);

        float[] beibu2 = {0.360F, 0.622F, 0.205F, 0.416F};
        map2.put("背部", beibu2);

        float[] shagnzhi12 = {0.060F, 0.272F, 0.315F, 0.596F};
        map2.put("上肢1", shagnzhi12);

        float[] shagnzhi22 = {0.622F, 0.872F, 0.315F, 0.596F};
        map2.put("上肢2", shagnzhi22);

        float[] xiazhi2 = {0.320F, 0.642F, 0.605F, 0.906F};
        map2.put("下肢", xiazhi);

        bitmapMan = ContextCompat.getDrawable(mActivity, R.drawable.services_icon_znfz_man);
        bitmapWomen = ContextCompat.getDrawable(mActivity, R.drawable.services_icon_znfz_women);

        if (gender == 1) {
            image.setImageDrawable(bitmapMan);
        } else {
            image.setImageDrawable(bitmapWomen);
        }

        // The MAGIC happens here!
        mAttacher = new PhotoViewAttacher(image);

        // 暂时用这种办法修复初始化话时图片过小
        mAttacher.setZoomable(false);//设置不能缩放
        mAttacher.setZoomable(true);//设置不能缩放


        // 单击监听
        mAttacher.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener() {
            @Override
            public void onPhotoTap(View view, float x, float y) {
//                Toast.makeText(mActivity, "velocityX:" + x + "velocityY:" + y, Toast.LENGTH_SHORT).show();
//                Logger.d("velocityX:" + x + "velocityY:" + y);
                if (isSide) {
                    for (Map.Entry<String, float[]> entry : map2.entrySet()) {
                        float[] v = entry.getValue();
                        if (v[0] < x && x < v[1] && y > v[2] && y < v[3]) {
                            for (int i1 = 0; i1 < data.size(); i1++) {

                                if (entry.getKey().startsWith(data.get(i1).get("bodyName").toString())) {
                                    BodyPositionActivity.goTo(mActivity, data.get(i1).get("id").toString(), data.get(i1).get("bodyName").toString(), gender + "");
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }else {
                    for (Map.Entry<String, float[]> entry : map.entrySet()) {
                        float[] v = entry.getValue();
                        if (v[0] < x && x < v[1] && y > v[2] && y < v[3]) {
                            for (int i1 = 0; i1 < data.size(); i1++) {

                                if (entry.getKey().startsWith(data.get(i1).get("bodyName").toString())) {
                                    BodyPositionActivity.goTo(mActivity, data.get(i1).get("id").toString(), data.get(i1).get("bodyName").toString(), gender + "");
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
            }

            @Override
            public void onOutsidePhotoTap() {
            }
        });
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
    }

    @Override
    protected PicFrgPresenter createPresenter() {
        return new PicFrgPresenter(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mAttacher.cleanup();
    }

    public void upUI() {
        init();
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
