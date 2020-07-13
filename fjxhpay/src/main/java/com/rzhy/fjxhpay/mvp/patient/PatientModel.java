package com.rzhy.fjxhpay.mvp.patient;

import java.io.Serializable;

/**
 */

public class PatientModel implements Serializable {

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

    public String getBindNum() {
        return bindNum;
    }

    public int getBindType() {
        return bindType;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public int getStatus() {
        return status;
    }

    public long getUserId() {
        return userId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setBindNum(String bindNum) {
        this.bindNum = bindNum;
    }

    public void setBindType(int bindType) {
        this.bindType = bindType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
