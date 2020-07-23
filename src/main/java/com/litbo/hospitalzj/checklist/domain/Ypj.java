package com.litbo.hospitalzj.checklist.domain;

import lombok.Data;

import java.util.Date;
@Data
public class Ypj {
    private Integer ypjId;

    private Integer jcyqId;

    private Integer eqId;

    private String shrJcjl;

    private String tester;

    private String auditor;

    private Date testTime;

    private Date shsjTime;

    private String jcjl;

    private String jcsm;

    private String gdyzsJctj1;

    private String gdyzsJctj2;

    private Integer gdyzsResult1;

    private Integer gdyzsResult2;

    private String gdyzsZbyq;

    private String gdyzsValue1;

    private String gdyzsValue2;

    private String fssclJctj;

    private String fssclValue;

    private String fssclZbyq;

    private Integer fssclResult;

    private String yyxsbzcJctj1;

    private String yyxsbzcJctj2;

    private String yyxsbzcZbyq;

    private String yyxsbzcValue1;

    private String yyxsbzcValue2;

    private String zlgJctj;

    private String zlgValue;

    private String zlgZbyq;

    private Byte zlgResult;


}