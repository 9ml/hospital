package com.litbo.hospitalzj.checklist.domain;

import lombok.Data;

import java.util.Date;
@Data
public class Mri {
    private Integer mriId;

    private Integer jcyqId;

    private Integer eqId;

    private String shrJcjl;

    private String tester;

    private String auditor;

    private Date testTime;

    private Date shsjTime;

    private String jcjl;

    private String jcsm;

    private String xqSmtj;

    private String smjzSmtj;

    private String mcxlSmtj;

    private String cjjzSmtj;

    private String cfsjSmtj;

    private String sySmtj;

    private String hbsjSmtj;

    private String chSmtj;

    private String pjcsSmtj;

    private String cjjSmtj;

    private String xzbBzyq;

    private String xzbValue;

    private Byte xzbResult;

    private String jhqblBzyq;

    private String jhqblValue;

    private Byte jhqblResult;

    private String kjfblBzyq;

    private String kjfblValue;

    private Byte kjfblResult;

    private String txjyxBzyq;

    private String txjyxValue;

    private Byte txjyxResult;

    private String chwcBzyq;

    private String chwcValue;

    private Byte chwcResult;

    private String chfjyxBzyq;

    private String chfjyxValue;

    private Byte chfjyxResult;

    private String zhbBzyq;

    private String zhbValue;

    private Byte zhbResult;

    private String ddbdfblBzyq1;

    private String ddbdfblBzyq2;

    private String ddbdfblValue;

    private Byte ddbdfblResult;

    private Byte type;

}