package com.rzhy.fjxhznfz.retrofit;


import com.rzhy.fjxhznfz.mvp.patient.PatientListModel;
import com.rzhy.fjxhznfz.mvp.znfz.DiagnoseModel;
import com.rzhy.fjxhznfz.mvp.znfz.ListBodyModel;
import com.rzhy.fjxhznfz.mvp.znfz.SymptomModel;
import com.rzhy.fjxhznfz.mvp.znfz.YyghModel;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by SenGe on 2020-06-12.
 */

public interface HttpService {



    /**
     * 获取绑定就诊人列表
     *
     * @return
     */
    @POST("user/getBrdaList")
    Observable<PatientListModel> getPatientList();

    /**
     * 智能分诊列表
     *
     * @return
     */
    @POST("getGuideBody")
    Observable<ListBodyModel> getGuideBody();

    /**
     * 智能分诊部位列表
     *
     * @return
     */
    @FormUrlEncoded
    @POST("getGuideSymptom")
    Observable<SymptomModel> getGuideSymptom(
            @Field("bodyId") String id,
            @Field("sex") String sex
    );

    /**
     * 智能分诊获取题目
     *
     * @return
     */
    @FormUrlEncoded
    @POST("getGuideDiagnose")
    Observable<DiagnoseModel> getGuideDiagnose1(
            @Field("symptomId") String id
    );

    /**
     * 智能分诊答题提交
     *
     * @return
     */
    @FormUrlEncoded
    @POST("getGuideDiagnose")
    Observable<DiagnoseModel> getGuideDiagnose2(
            @Field("symptomId") String id,
            @Field("isSelected") String isSelected,
            @Field("diagnoseId") String diagnoseId

    );

    /**
     * 获取预约科室列表
     *
     * @return
     */
    @POST("getOrderDp")
    Observable<YyghModel> getDepartments();

}
