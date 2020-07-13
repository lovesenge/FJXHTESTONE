package com.rzhy.fjxhznfz.mvp.znfz;

import com.rzhy.fjxhznfz.retrofit.BaseResult;

import java.util.List;

/**
 * Created by SenGe on 2020-06-23.
 */

public class YyghModel extends BaseResult {
    private DataBean data;
    /**
     * data : {"list":[{"baseDp":{"id":2,"image":"","indexs":1,"name":"内科","zfpb":0,"zfpbValue":"正常"},"baseDpName":"内科","description":"","html":"","image":"","isShow":0,"ksdm":"39","ksmc":"内分泌科","zfpb":0,"zfpbValue":"正常"},{"baseDp":{"id":2,"image":"","indexs":1,"name":"内科","zfpb":0,"zfpbValue":"正常"},"baseDpName":"内科","description":"","html":"","image":"","isShow":0,"ksdm":"40","ksmc":"肾内科","zfpb":0,"zfpbValue":"正常"},{"baseDp":{"id":2,"image":"","indexs":1,"name":"内科","zfpb":0,"zfpbValue":"正常"},"baseDpName":"内科","description":"","html":"","image":"","isShow":0,"ksdm":"47","ksmc":"血液科","zfpb":0,"zfpbValue":"正常"},{"baseDp":{"id":2,"image":"","indexs":1,"name":"内科","zfpb":0,"zfpbValue":"正常"},"baseDpName":"内科","description":"","html":"","image":"","isShow":0,"ksdm":"50","ksmc":"心内科","zfpb":0,"zfpbValue":"正常"},{"baseDp":{"id":2,"image":"","indexs":1,"name":"内科","zfpb":0,"zfpbValue":"正常"},"baseDpName":"内科","description":"","html":"","image":"","isShow":0,"ksdm":"52","ksmc":"神经内科","zfpb":0,"zfpbValue":"正常"},{"baseDp":{"id":2,"image":"","indexs":1,"name":"内科","zfpb":0,"zfpbValue":"正常"},"baseDpName":"内科","description":"","html":"","image":"","isShow":0,"ksdm":"54","ksmc":"综合内科","zfpb":0,"zfpbValue":"正常"},{"baseDp":{"id":2,"image":"","indexs":1,"name":"内科","zfpb":0,"zfpbValue":"正常"},"baseDpName":"内科","description":"","html":"","image":"","isShow":0,"ksdm":"7","ksmc":"风湿科","zfpb":0,"zfpbValue":"正常"},{"baseDp":{"id":2,"image":"","indexs":1,"name":"内科","zfpb":0,"zfpbValue":"正常"},"baseDpName":"内科","description":"","html":"","image":"","isShow":0,"ksdm":"76","ksmc":"普内科","zfpb":0,"zfpbValue":"正常"},{"baseDp":{"id":2,"image":"","indexs":1,"name":"内科","zfpb":0,"zfpbValue":"正常"},"baseDpName":"内科","description":"","html":"","image":"","isShow":0,"ksdm":"77","ksmc":"消化内科","zfpb":0,"zfpbValue":"正常"},{"baseDp":{"id":3,"image":"","indexs":2,"name":"外科","zfpb":0,"zfpbValue":"正常"},"baseDpName":"外科","description":"","html":"","image":"","isShow":0,"ksdm":"10","ksmc":"骨科","zfpb":0,"zfpbValue":"正常"},{"baseDp":{"id":3,"image":"","indexs":2,"name":"外科","zfpb":0,"zfpbValue":"正常"},"baseDpName":"外科","description":"","html":"","image":"","isShow":0,"ksdm":"44","ksmc":"肛肠科","zfpb":0,"zfpbValue":"正常"},{"baseDp":{"id":3,"image":"","indexs":2,"name":"外科","zfpb":0,"zfpbValue":"正常"},"baseDpName":"外科","description":"","html":"","image":"","isShow":0,"ksdm":"51","ksmc":"血管及甲状腺科","zfpb":0,"zfpbValue":"正常"},{"baseDp":{"id":3,"image":"","indexs":2,"name":"外科","zfpb":0,"zfpbValue":"正常"},"baseDpName":"外科","description":"","html":"","image":"","isShow":0,"ksdm":"55","ksmc":"乳腺外科","zfpb":0,"zfpbValue":"正常"},{"baseDp":{"id":3,"image":"","indexs":2,"name":"外科","zfpb":0,"zfpbValue":"正常"},"baseDpName":"外科","description":"","html":"","image":"","isShow":0,"ksdm":"62","ksmc":"心外科","zfpb":0,"zfpbValue":"正常"},{"baseDp":{"id":3,"image":"","indexs":2,"name":"外科","zfpb":0,"zfpbValue":"正常"},"baseDpName":"外科","description":"","html":"","image":"","isShow":0,"ksdm":"64","ksmc":"神经外科","zfpb":0,"zfpbValue":"正常"},{"baseDp":{"id":3,"image":"","indexs":2,"name":"外科","zfpb":0,"zfpbValue":"正常"},"baseDpName":"外科","description":"","html":"","image":"","isShow":0,"ksdm":"69","ksmc":"胸外科","zfpb":0,"zfpbValue":"正常"},{"baseDp":{"id":3,"image":"","indexs":2,"name":"外科","zfpb":0,"zfpbValue":"正常"},"baseDpName":"外科","description":"","html":"","image":"","isShow":0,"ksdm":"70","ksmc":"普通外科","zfpb":0,"zfpbValue":"正常"},{"baseDp":{"id":3,"image":"","indexs":2,"name":"外科","zfpb":0,"zfpbValue":"正常"},"baseDpName":"外科","description":"","html":"","image":"","isShow":0,"ksdm":"72","ksmc":"基本外科","zfpb":0,"zfpbValue":"正常"},{"baseDp":{"id":3,"image":"","indexs":2,"name":"外科","zfpb":0,"zfpbValue":"正常"},"baseDpName":"外科","description":"","html":"","image":"","isShow":0,"ksdm":"74","ksmc":"泌尿外科","zfpb":0,"zfpbValue":"正常"},{"baseDp":{"id":3,"image":"","indexs":2,"name":"外科","zfpb":0,"zfpbValue":"正常"},"baseDpName":"外科","description":"","html":"","image":"","isShow":0,"ksdm":"75","ksmc":"结直肠科","zfpb":0,"zfpbValue":"正常"},{"baseDp":{"id":3,"image":"","indexs":2,"name":"外科","zfpb":0,"zfpbValue":"正常"},"baseDpName":"外科","description":"","html":"","image":"","isShow":0,"ksdm":"78","ksmc":"胃外科","zfpb":0,"zfpbValue":"正常"},{"baseDp":{"id":3,"image":"","indexs":2,"name":"外科","zfpb":0,"zfpbValue":"正常"},"baseDpName":"外科","description":"","html":"","image":"","isShow":0,"ksdm":"81","ksmc":"烧伤科","zfpb":0,"zfpbValue":"正常"},{"baseDp":{"id":3,"image":"","indexs":2,"name":"外科","zfpb":0,"zfpbValue":"正常"},"baseDpName":"外科","description":"","html":"","image":"","isShow":0,"ksdm":"82","ksmc":"疼痛门诊","zfpb":0,"zfpbValue":"正常"},{"baseDp":{"id":3,"image":"","indexs":2,"name":"外科","zfpb":0,"zfpbValue":"正常"},"baseDpName":"外科","description":"","html":"","image":"","isShow":0,"ksdm":"9","ksmc":"肝胆外科","zfpb":0,"zfpbValue":"正常"},{"baseDp":{"id":4,"image":"","indexs":3,"name":"妇产科","zfpb":0,"zfpbValue":"正常"},"baseDpName":"妇产科","description":"","html":"","image":"","isShow":0,"ksdm":"61","ksmc":"妇科","zfpb":0,"zfpbValue":"正常"},{"baseDp":{"id":4,"image":"","indexs":3,"name":"妇产科","zfpb":0,"zfpbValue":"正常"},"baseDpName":"妇产科","description":"","html":"","image":"","isShow":0,"ksdm":"73","ksmc":"产科","zfpb":0,"zfpbValue":"正常"},{"baseDp":{"id":5,"image":"","indexs":4,"name":"儿科","zfpb":0,"zfpbValue":"正常"},"baseDpName":"儿科","description":"","html":"","image":"","isShow":0,"ksdm":"4","ksmc":"儿外科","zfpb":0,"zfpbValue":"正常"},{"baseDp":{"id":5,"image":"","indexs":4,"name":"儿科","zfpb":0,"zfpbValue":"正常"},"baseDpName":"儿科","description":"","html":"","image":"","isShow":0,"ksdm":"59","ksmc":"儿科","zfpb":0,"zfpbValue":"正常"},{"baseDp":{"id":6,"image":"","indexs":5,"name":"五官科","zfpb":0,"zfpbValue":"正常"},"baseDpName":"五官科","description":"","html":"","image":"","isShow":0,"ksdm":"5","ksmc":"耳鼻喉科","zfpb":0,"zfpbValue":"正常"},{"baseDp":{"id":6,"image":"","indexs":5,"name":"五官科","zfpb":0,"zfpbValue":"正常"},"baseDpName":"五官科","description":"","html":"","image":"","isShow":0,"ksdm":"79","ksmc":"眼科","zfpb":0,"zfpbValue":"正常"},{"baseDp":{"id":7,"image":"","indexs":6,"name":"中医科","zfpb":0,"zfpbValue":"正常"},"baseDpName":"中医科","description":"","html":"","image":"","isShow":0,"ksdm":"45","ksmc":"中医科","zfpb":0,"zfpbValue":"正常"},{"baseDp":{"id":8,"image":"","indexs":7,"name":"皮肤性病科","zfpb":0,"zfpbValue":"正常"},"baseDpName":"皮肤性病科","description":"","html":"","image":"","isShow":0,"ksdm":"46","ksmc":"皮肤性病科","zfpb":0,"zfpbValue":"正常"},{"baseDp":{"id":9,"image":"","indexs":8,"name":"康复科","zfpb":0,"zfpbValue":"正常"},"baseDpName":"康复科","description":"","html":"","image":"","isShow":0,"ksdm":"48","ksmc":"康复科","zfpb":0,"zfpbValue":"正常"},{"baseDp":{"id":10,"image":"","indexs":9,"name":"肿瘤科","zfpb":0,"zfpbValue":"正常"},"baseDpName":"肿瘤科","description":"","html":"","image":"","isShow":0,"ksdm":"57","ksmc":"肿瘤内科","zfpb":0,"zfpbValue":"正常"},{"baseDp":{"id":10,"image":"","indexs":9,"name":"肿瘤科","zfpb":0,"zfpbValue":"正常"},"baseDpName":"肿瘤科","description":"","html":"","image":"","isShow":0,"ksdm":"6","ksmc":"放疗科","zfpb":0,"zfpbValue":"正常"},{"baseDp":{"id":11,"image":"","indexs":10,"name":"整形科","zfpb":0,"zfpbValue":"正常"},"baseDpName":"整形科","description":"","html":"","image":"","isShow":0,"ksdm":"60","ksmc":"整形科","zfpb":0,"zfpbValue":"正常"},{"baseDp":{"id":11,"image":"","indexs":10,"name":"整形科","zfpb":0,"zfpbValue":"正常"},"baseDpName":"整形科","description":"","html":"","image":"","isShow":0,"ksdm":"80","ksmc":"门激光美容室","zfpb":0,"zfpbValue":"正常"},{"baseDp":{"id":1,"indexs":999,"name":"其他","zfpb":0,"zfpbValue":"正常"},"baseDpName":"其他","description":"","html":"","image":"","isShow":0,"ksdm":"58","ksmc":"超声科（彩超检查预约）","zfpb":0,"zfpbValue":"正常"}]}
     * msg : 成功
     * ret : 1
     */
    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * baseDp : {"id":2,"image":"","indexs":1,"name":"内科","zfpb":0,"zfpbValue":"正常"}
         * baseDpName : 内科
         * description :
         * html :
         * image :
         * isShow : 0
         * ksdm : 39
         * ksmc : 内分泌科
         * zfpb : 0
         * zfpbValue : 正常
         */

        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 2
             * image :
             * indexs : 1
             * name : 内科
             * zfpb : 0
             * zfpbValue : 正常
             */

            private BaseDpBean baseDp;
            private String baseDpName;
            private String description;
            private String html;
            private String image;
            private String deptRule;
            private int isShow;
            private String ksdm;
            private String ksmc;
            private int zfpb;
            private String zfpbValue;

            public BaseDpBean getBaseDp() {
                return baseDp;
            }

            public void setBaseDp(BaseDpBean baseDp) {
                this.baseDp = baseDp;
            }

            public String getBaseDpName() {
                return baseDpName;
            }

            public void setBaseDpName(String baseDpName) {
                this.baseDpName = baseDpName;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getHtml() {
                return html;
            }

            public void setHtml(String html) {
                this.html = html;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getDeptRule() {
                return deptRule;
            }

            public void setDeptRule(String deptRule) {
                this.deptRule = deptRule;
            }

            public int getIsShow() {
                return isShow;
            }

            public void setIsShow(int isShow) {
                this.isShow = isShow;
            }

            public String getKsdm() {
                return ksdm;
            }

            public void setKsdm(String ksdm) {
                this.ksdm = ksdm;
            }

            public String getKsmc() {
                return ksmc;
            }

            public void setKsmc(String ksmc) {
                this.ksmc = ksmc;
            }

            public int getZfpb() {
                return zfpb;
            }

            public void setZfpb(int zfpb) {
                this.zfpb = zfpb;
            }

            public String getZfpbValue() {
                return zfpbValue;
            }

            public void setZfpbValue(String zfpbValue) {
                this.zfpbValue = zfpbValue;
            }

            public static class BaseDpBean {
                private int id;
                private String image;
                private int indexs;
                private String name;
                private int zfpb;
                private String zfpbValue;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public int getIndexs() {
                    return indexs;
                }

                public void setIndexs(int indexs) {
                    this.indexs = indexs;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getZfpb() {
                    return zfpb;
                }

                public void setZfpb(int zfpb) {
                    this.zfpb = zfpb;
                }

                public String getZfpbValue() {
                    return zfpbValue;
                }

                public void setZfpbValue(String zfpbValue) {
                    this.zfpbValue = zfpbValue;
                }
            }
        }
    }
}
