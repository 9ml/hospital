package com.litbo.hospitalzj.user.bean;

import java.util.Date;

/**
 * 质检设备流水
 */
public class EqZjls {
    private Integer dzId;

    private Date testTime;

    private Integer eqId;

    private String eqMc;

    private String tester;

    private String auditor;

    private String eqDah;


    public String getEqMc() {
        return eqMc;
    }

    public void setEqMc(String eqMc) {
        this.eqMc = eqMc;
    }
    public Integer getDzId() {
        return dzId;
    }

    public void setDzId(Integer dzId) {
        this.dzId = dzId;
    }

    public Date getTestTime() {
        return testTime;
    }

    public void setTestTime(Date testTime) {
        this.testTime = testTime;
    }

    public Integer getEqId() {
        return eqId;
    }

    public void setEqId(Integer eqId) {
        this.eqId = eqId;
    }

    public String getTester() {
        return tester;
    }

    public void setTester(String tester) {
        this.tester = tester == null ? null : tester.trim();
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor == null ? null : auditor.trim();
    }

    public String getEqDah() {
        return eqDah;
    }

    public void setEqDah(String eqDah) {
        this.eqDah = eqDah;
    }
}