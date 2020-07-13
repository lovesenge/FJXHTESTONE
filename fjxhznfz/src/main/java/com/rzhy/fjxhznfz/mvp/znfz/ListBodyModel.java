package com.rzhy.fjxhznfz.mvp.znfz;

import com.rzhy.fjxhznfz.retrofit.BaseResult;

import java.util.List;

/**
 * Created by SenGe on 2020-06-23.
 */

public class ListBodyModel extends BaseResult {
    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * bodyName : 头部
         * id : 1
         * remark :
         * status : 1
         */

        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            private String bodyName;
            private int id;
            private String remark;
            private int status;

            public String getBodyName() {
                return bodyName;
            }

            public void setBodyName(String bodyName) {
                this.bodyName = bodyName;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        }
    }
}
