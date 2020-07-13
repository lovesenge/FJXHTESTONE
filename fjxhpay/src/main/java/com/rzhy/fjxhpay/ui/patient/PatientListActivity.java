package com.rzhy.fjxhpay.ui.patient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.rzhy.fjxhpay.R;
import com.rzhy.fjxhpay.common.AppConfig;
import com.rzhy.fjxhpay.mvp.MvpActivity;
import com.rzhy.fjxhpay.mvp.patient.PatientListModel;
import com.rzhy.fjxhpay.mvp.patient.PatientListPresenter;
import com.rzhy.fjxhpay.mvp.patient.PatientListView;
import com.rzhy.fjxhpay.mvp.patient.PatientModel;
import com.rzhy.fjxhpay.ui.pay.PayActivity;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by SenGe on 2020-06-12.
 */

public class PatientListActivity extends MvpActivity<PatientListPresenter> implements PatientListView,View.OnClickListener{

    ListView listviewBinduser;
    Button btnChoose;

    private PatientListAdapter adapter;
    private PatientModel patient;

    private Integer type;
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_list);
        listviewBinduser = findViewById(R.id.listview_binduser);
        btnChoose = findViewById(R.id.btn_choose);
        init();
        initEvent();
    }

    private void init() {
        initTitle(getResources().getString(R.string.common_choose_patient_title));
        adapter = new PatientListAdapter(mActivity);
        listviewBinduser.setAdapter(adapter);
    }

    private void initData() {
        userId = getIntent().getStringExtra("userId");
        type = getIntent().getIntExtra("type", 0);
        mvpPresenter.getBindUserListFromServer();
    }

    @Override
    protected void onResume() {
        initData();
        super.onResume();
    }

    private void initEvent(){
        listviewBinduser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.setChecked(position);
                adapter.notifyDataSetChanged();
                if (adapter.getChecked() > -1) {
                    btnChoose.setEnabled(true);
                    patient = new PatientModel();
                    patient.setId(adapter.getData().get(adapter.getChecked()).getId());
                    patient.setBindNum(adapter.getData().get(adapter.getChecked()).getBindNum());
                    patient.setBindType(adapter.getData().get(adapter.getChecked()).getBindType());
                    patient.setName(adapter.getData().get(adapter.getChecked()).getName());
                    patient.setPhone(adapter.getData().get(adapter.getChecked()).getPhone());
                    patient.setStatus(adapter.getData().get(adapter.getChecked()).getStatus());
                    patient.setUserId(adapter.getData().get(adapter.getChecked()).getUserId());
                }
            }
        });
        btnChoose.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.btn_choose) {
            Class<?> clazz = ((Class) getIntent().getExtras().get("class"));
            Bundle bundle = getIntent().getExtras();
            bundle.putSerializable("patient", patient);
            Intent intent = new Intent(this, PayActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
//                Toast.makeText(this,"111",Toast.LENGTH_SHORT).show();

        }
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
    public void getPatientListSuccess(PatientListModel model) {
        List<PatientListModel.BindUserEntity> list = new ArrayList<>();
        for (int i=0;i<model.getData().getList().size();i++){
            if (model.getData().getList().get(i).getBindType() == type){
                list.add(model.getData().getList().get(i));
            }
        }
        adapter.addData(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected PatientListPresenter createPresenter() {
        return new PatientListPresenter(this);
    }

    /**
     * 选择就诊人
     * @param context
     * @param type 1 门诊 2 住院
     */
    public static void goTo(final Activity context,String userId, final Integer type,String APP_ID) {
//        if (StringUtils.isBlank(AppCfg.getInstatce(context).getString("token", ""))) {
//            SigninActivity.goTo4Ret(context, 1);
//            return;
//        }
//        final Intent intent = new Intent();
//        if (bundle == null) bundle = new Bundle();
//        if (DBManager.getInstance(context).getBindUserNobyType(type) == 0) {
//            final MSGDialog dialog = new MSGDialog(context);
//            dialog.show();
//            dialog.setTitle("提示");
//            dialog.setMessage("您未绑定就诊人，是否前去绑定？");
//            final Bundle finalBundle = bundle;
//            dialog.setYesOnclickListener(new MSGDialog.onYesOnclickListener() {
//                @Override
//                public void onYesClick() {
//                    finalBundle.putInt("state", BindUserAddActivity.STATE_EMPTY_NO_BACK);
//                    finalBundle.putSerializable("class", clazz);
//                    /**；
//                     * 参数type 1->门诊x; 3->住院; null 或者其-> 全部
//                     * 如果传进来的是门诊则跳到绑定就诊人就只能绑定门诊
//                     * 如果传进来的是住院则跳到绑定就诊人就只能绑定住院
//                     */
//                    if (type == null){
//                        finalBundle.putSerializable("type",BindUserAddActivity.Type.ALL);
//                    }else{
//                        if (type == 1){
//                            finalBundle.putSerializable("type",BindUserAddActivity.Type.MZ);
//                        }else if (type == 2){
//                            finalBundle.putSerializable("type",BindUserAddActivity.Type.ZY);
//                        }else{
//                            finalBundle.putSerializable("type",BindUserAddActivity.Type.ALL);
//                        }
//                    }
//                    intent.setClass(context, BindUserAddActivity.class);
//                    intent.putExtras(finalBundle);
//                    context.startActivity(intent);
//                    dialog.dismiss();
//                }
//            });
//            dialog.setNoOnclickListener(new MSGDialog.onNoOnclickListener() {
//                @Override
//                public void onNoClick() {
//                    dialog.dismiss();
//                }
//            });
//        } else if (DBManager.getInstance(context).getBindUserNobyType(type) == 1) {
//            PatientModel patient = new PatientModel();
//            BindUserEntity bindUserEntity = DBManager.getInstance(context).getBindUserByType(type);
//            patient.setId(bindUserEntity.getId());
//            patient.setBindNum(bindUserEntity.getBindNum());
//            patient.setBindType(bindUserEntity.getBindType());
//            patient.setName(bindUserEntity.getName());
//            patient.setPhone(bindUserEntity.getPhone());
//            patient.setStatus(bindUserEntity.getStatus());
//            patient.setUserId(bindUserEntity.getUserId());
//            bundle.putSerializable(PATIENT, patient);
//            intent.setClass(context, clazz);
//            intent.putExtras(bundle);
//            context.startActivity(intent);
//        } else {
//            intent.setClass(context, ChoosePatientActivity.class);
//            bundle.putSerializable("class", clazz);
//            bundle.putInt("type", type == null ? 0 : type);
//            intent.putExtras(bundle);
//            context.startActivity(intent);
//        }
        if (!userId.equals("")){
            AppConfig.getInstatce(context).setValue("userId",userId);
        }
        if (!APP_ID.equals("")){
            AppConfig.getInstatce(context).setValue("APP_ID",APP_ID);
        }
        Bundle bundle = new Bundle();
        Intent intent = new Intent(context,PatientListActivity.class);
        bundle.putString("userId", userId);
        bundle.putInt("type", type == null ? 0 : type);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }


}
