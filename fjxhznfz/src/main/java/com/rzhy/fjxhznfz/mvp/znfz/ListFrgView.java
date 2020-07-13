package com.rzhy.fjxhznfz.mvp.znfz;

import com.rzhy.fjxhznfz.mvp.BaseView;

import java.util.List;
import java.util.Map;

/**
 * Created by SenGe on 2020-06-23.
 */

public interface ListFrgView extends BaseView {
    void getDpSuccess(List<Map<String, Object>> testModel);
}
