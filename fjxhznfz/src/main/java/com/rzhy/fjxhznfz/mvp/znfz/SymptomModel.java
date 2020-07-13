package com.rzhy.fjxhznfz.mvp.znfz;

import com.rzhy.fjxhznfz.retrofit.BaseResult;

import java.util.List;

/**
 * Created by SenGe on 2020-06-23.
 */

public class SymptomModel extends BaseResult {
    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * symptomContent : 腮腺肿大是涎腺病变中最常见的表现，也是全身疾病的局部体征，肿大可为单侧或双侧性，肿大明显时可见耳垂附近区域向外隆起，高度肿大时，头部正面观耳垂可被掩盖。
         * symptomName : 腮腺肿大
         */

        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            private int id;
            private String symptomContent;
            private String symptomName;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getSymptomContent() {
                return symptomContent;
            }

            public void setSymptomContent(String symptomContent) {
                this.symptomContent = symptomContent;
            }

            public String getSymptomName() {
                return symptomName;
            }

            public void setSymptomName(String symptomName) {
                this.symptomName = symptomName;
            }
        }
    }
}
