package com.rzhy.fjxhznfz.mvp.patient;

import com.rzhy.fjxhznfz.retrofit.BaseResult;

import java.util.List;

/**
 * Created by SenGe on 2020-06-12.
 */

public class PatientListModel extends BaseResult {

    private DataBean data;
    /**
     * data : {"list":[{"bindNum":"K54057390","bindType":1,"id":40055,"name":"陈松","phone":"13123169770 ","status":1,"userId":39008},{"bindNum":"A31402128","bindType":1,"id":40056,"name":"林杰","phone":"18695770105","status":1,"userId":39008}]}
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
         * bindNum : K54057390
         * bindType : 1
         * id : 40055
         * name : 陈松
         * phone : 13123169770
         * status : 1
         * userId : 39008
         */

        private List<BindUserEntity> list;

        public List<BindUserEntity> getList() {
            return list;
        }

        public DataBean(List<BindUserEntity> list) {
            this.list = list;
        }
    }

    public static class BindUserEntity{
        private long id;
        private String bindNum;
        private int bindType;
        private String name;
        private String phone;
        private int status;
        private long userId;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getBindNum() {
            return bindNum;
        }

        public void setBindNum(String bindNum) {
            this.bindNum = bindNum;
        }

        public int getBindType() {
            return bindType;
        }

        public void setBindType(int bindType) {
            this.bindType = bindType;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }
    }

}
