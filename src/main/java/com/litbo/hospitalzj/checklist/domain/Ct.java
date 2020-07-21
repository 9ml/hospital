package com.litbo.hospitalzj.checklist.domain;

import lombok.Data;

import java.util.Date;
@Data
public class Ct {
    private Integer ctId;

    private Integer jcyqId;

    private Integer eqId;

    private String tester;

    private Date testTime;

    private String auditor;

    private String shrJcjl;

    private Date shsjTime;

    private String jcjl;

    private String jcsm;

    private String cjchpcChTest1;

    private String cjchpcChTest2;

    private String cjchpcChTest3;

    private Double cjchpcChValue1;

    private Double cjchpcChValue2;

    private Double cjchpcChValue3;

    private Integer cjchpcChRes1;

    private Integer cjchpcChRes2;

    private Integer cjchpcChRes3;

    private String cjchpcJctj;

    private String cjchpcZbyq;

    private Double ctdiwValue;

    private Integer ctdiwRes;

    private String ctdiwJctj;

    private String ctdiwZbyq;

    private Integer ctzRes;

    private Double ctzValue;

    private String ctzZbyq;

    private String ctzJctj;

    private String jyxJctj;

    private Integer jyxRes;

    private Double jyxValue;

    private String jyxZbyq;

    private String zsJctj;

    private String zsZbyq;

    private Integer zsRes;

    private Double zsValue;

    private String gdbfblSf1;

    private String gdbfblSf2;

    private String gdbfblJctj1;

    private String gdbfblJctj2;

    private String gdbfblZbyq1;

    private String gdbfblZbyq2;

    private Double gdbfblValue2;

    private Double gdbfblValue1;

    private Integer gdbfblRes1;

    private Integer gdbfblRes2;

    private String ddbktcfblJctj;

    private String ddbktcfblZbyq;

    private Integer ddbktcfblRes;

    private Double ddbktcfblValue;

    private String ctzxxJctj;

    private String ctzxxZbyq;

    private Double ctzxxValue;

    private Integer ctzxxRes;

    private Integer type;

    public Integer getCtId() {
        return ctId;
    }

    public void setCtId(Integer ctId) {
        this.ctId = ctId;
    }

    public Integer getJcyqId() {
        return jcyqId;
    }

    public void setJcyqId(Integer jcyqId) {
        this.jcyqId = jcyqId;
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

    public Date getTestTime() {
        return testTime;
    }

    public void setTestTime(Date testTime) {
        this.testTime = testTime;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor == null ? null : auditor.trim();
    }

    public String getShrJcjl() {
        return shrJcjl;
    }

    public void setShrJcjl(String shrJcjl) {
        this.shrJcjl = shrJcjl == null ? null : shrJcjl.trim();
    }

    public Date getShsjTime() {
        return shsjTime;
    }

    public void setShsjTime(Date shsjTime) {
        this.shsjTime = shsjTime;
    }

    public String getJcjl() {
        return jcjl;
    }

    public void setJcjl(String jcjl) {
        this.jcjl = jcjl == null ? null : jcjl.trim();
    }

    public String getJcsm() {
        return jcsm;
    }

    public void setJcsm(String jcsm) {
        this.jcsm = jcsm == null ? null : jcsm.trim();
    }


}