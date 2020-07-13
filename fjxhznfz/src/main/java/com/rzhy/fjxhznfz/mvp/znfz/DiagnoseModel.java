package com.rzhy.fjxhznfz.mvp.znfz;

import com.rzhy.fjxhznfz.retrofit.BaseResult;

/**
 * Created by SenGe on 2020-06-23.
 */

public class DiagnoseModel extends BaseResult {
    /**
     * guideDiagnose : {"diagnoseContent":"是否伴有发热，皮肤潮红、局部水肿，有压痛，按压腺体有脓液流入口腔，肿大可伴有暂时性面瘫？","diseaseList":"","dpList":"","id":1,"isEnd":0}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * diagnoseContent : 是否伴有发热，皮肤潮红、局部水肿，有压痛，按压腺体有脓液流入口腔，肿大可伴有暂时性面瘫？
         * diseaseList :
         * dpList :
         * id : 1
         * isEnd : 0
         */

        private GuideDiagnoseBean guideDiagnose;

        public GuideDiagnoseBean getGuideDiagnose() {
            return guideDiagnose;
        }

        public void setGuideDiagnose(GuideDiagnoseBean guideDiagnose) {
            this.guideDiagnose = guideDiagnose;
        }

        public static class GuideDiagnoseBean {
            private String diagnoseContent;
            private String diseaseList;
            private String dpList;
            private int id;
            private int isEnd;

            public String getDiagnoseContent() {
                return diagnoseContent;
            }

            public void setDiagnoseContent(String diagnoseContent) {
                this.diagnoseContent = diagnoseContent;
            }

            public String getDiseaseList() {
                return diseaseList;
            }

            public void setDiseaseList(String diseaseList) {
                this.diseaseList = diseaseList;
            }

            public String getDpList() {
                return dpList;
            }

            public void setDpList(String dpList) {
                this.dpList = dpList;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getIsEnd() {
                return isEnd;
            }

            public void setIsEnd(int isEnd) {
                this.isEnd = isEnd;
            }
        }
    }
}
