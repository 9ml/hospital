package com.litbo.hospitalzj.checklist.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Dcsjhy {
    private Integer dcid;

    private Integer jcyqId;

    private Integer eqId;

    private String tester;

    private String auditor;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date shsjTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date testTime;

    private String shrJcjl;

    public String getShrJcjl() {
        return shrJcjl;
    }

    public void setShrJcjl(String shrJcjl) {
        this.shrJcjl = shrJcjl;
    }

    private String jcjl;

    private String jcsm;

    private float xlTest1;

    private float xlTest2;

    private float xlTest3;

    private float xlTest4;

    private float xlTest5;

    private float xlValue1;

    private float xlValue2;

    private float xlValue3;

    private float xlValue4;

    private float xlValue5;

    private float xlWc;

    private Byte xlResult;

    private float hxlTest1;

    private float hxlTest2;

    private float hxlTest3;

    private float hxlTest4;

    private float hxlTest5;

    private float hxlValue1;

    private float hxlValue2;

    private float hxlValue3;

    private float hxlValue4;

    private float hxlValue5;

    private float hxlWc;

    private Byte hxlResult;

    private float xybhdTest1;

    private float xybhdTest2;

    private float xybhdTest3;

    private float xybhdTest4;

    private float xybhdTest5;

    private float xybhdValue1;

    private float xybhdValue2;

    private float xybhdValue3;

    private float xybhdValue4;

    private float xybhdValue5;

    private float xybhdWc;

    private Byte xybhdResult;

    private float wcxyHTest1;

    private float wcxyMTest1;

    private float wcxyLTest1;

    private float wcxyHTest2;

    private float wcxyMTest2;

    private float wcxyLTest2;

    private float wcxyHTest3;

    private float wcxyMTest3;

    private float wcxyLTest3;

    private float wcxyHTest4;

    private float wcxyMTest4;

    private float wcxyLTest4;

    private float wcxyHTest5;

    private float wcxyMTest5;

    private float wcxyLTest5;

    private float wcxyHValue11;

    private float wcxyMValue11;

    private float wcxyLValue11;

    private float wcxyHValue12;

    private float wcxyMValue12;

    private float wcxyLValue12;

    private float wcxyHValue13;

    private float wcxyMValue13;

    private float wcxyLValue13;

    private float wcxyHValue14;

    private float wcxyMValue14;

    private float wcxyLValue14;

    private float wcxyHValue15;

    private float wcxyMValue15;

    private float wcxyLValue15;

    private float wcxyHValue21;

    private float wcxyMValue21;

    private float wcxyLValue21;

    private float wcxyHValue22;

    private float wcxyMValue22;

    private float wcxyLValue22;

    private float wcxyHValue23;

    private float wcxyMValue23;

    private float wcxyLValue23;

    private float wcxyHValue24;

    private float wcxyMValue24;

    private float wcxyLValue24;

    private float wcxyHValue25;

    private float wcxyMValue25;

    private float wcxyLValue25;

    private float wcxyHValue31;

    private float wcxyMValue31;

    private float wcxyLValue31;

    private float wcxyHValue32;

    private float wcxyMValue32;

    private float wcxyLValue32;

    private float wcxyHValue33;

    private float wcxyMValue33;

    private float wcxyLValue33;

    private float wcxyHValue34;

    private float wcxyMValue34;

    private float wcxyLValue34;

    private float wcxyHValue35;

    private float wcxyMValue35;

    private float wcxyLValue35;
//误差百分比
    private float wcxyWc;

    private Byte wcxyResult;

    private float wcxyjtSd;

    private float wcxyjtMnq;

    private float wcxyjtJhy;

    private float wcxyjtWc;

    private Byte wcxyjtResult;

    private float wcxyqmSd;

    private float wcxyqmXll;

    private float wcxyqmWc;

    private Byte wcxyqmResult;

    private Byte sgbjResult;

    private Byte bjxjcResult;

    private Byte jyjcResult;

    public Date getShsjTime() {
        return shsjTime;
    }

    public void setShsjTime(Date shsjTime) {
        this.shsjTime = shsjTime;
    }

    public float getState() {
        return state;
    }

    public void setState(float state) {
        this.state = state;
    }

    private float state;

    private String spare2;

    private String spare3;

    public Integer getDcid() {
        return dcid;
    }

    public void setDcid(Integer dcid) {
        this.dcid = dcid;
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

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor == null ? null : auditor.trim();
    }

    public Date getTestTime() {
        return testTime;
    }

    public void setTestTime(Date testTime) {
        this.testTime = testTime;
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

    public float getXlTest1() {
        return xlTest1;
    }

    public void setXlTest1(float xlTest1) {
        this.xlTest1 = xlTest1;
    }

    public float getXlTest2() {
        return xlTest2;
    }

    public void setXlTest2(float xlTest2) {
        this.xlTest2 = xlTest2;
    }

    public float getXlTest3() {
        return xlTest3;
    }

    public void setXlTest3(float xlTest3) {
        this.xlTest3 = xlTest3;
    }

    public float getXlTest4() {
        return xlTest4;
    }

    public void setXlTest4(float xlTest4) {
        this.xlTest4 = xlTest4;
    }

    public float getXlTest5() {
        return xlTest5;
    }

    public void setXlTest5(float xlTest5) {
        this.xlTest5 = xlTest5;
    }

    public float getXlValue1() {
        return xlValue1;
    }

    public void setXlValue1(float xlValue1) {
        this.xlValue1 = xlValue1;
    }

    public float getXlValue2() {
        return xlValue2;
    }

    public void setXlValue2(float xlValue2) {
        this.xlValue2 = xlValue2;
    }

    public float getXlValue3() {
        return xlValue3;
    }

    public void setXlValue3(float xlValue3) {
        this.xlValue3 = xlValue3;
    }

    public float getXlValue4() {
        return xlValue4;
    }

    public void setXlValue4(float xlValue4) {
        this.xlValue4 = xlValue4;
    }

    public float getXlValue5() {
        return xlValue5;
    }

    public void setXlValue5(float xlValue5) {
        this.xlValue5 = xlValue5;
    }

    public float getXlWc() {
        return xlWc;
    }

    public void setXlWc(float xlWc) {
        this.xlWc = xlWc;
    }

    public Byte getXlResult() {
        return xlResult;
    }

    public void setXlResult(Byte xlResult) {
        this.xlResult = xlResult;
    }

    public float getHxlTest1() {
        return hxlTest1;
    }

    public void setHxlTest1(float hxlTest1) {
        this.hxlTest1 = hxlTest1;
    }

    public float getHxlTest2() {
        return hxlTest2;
    }

    public void setHxlTest2(float hxlTest2) {
        this.hxlTest2 = hxlTest2;
    }

    public float getHxlTest3() {
        return hxlTest3;
    }

    public void setHxlTest3(float hxlTest3) {
        this.hxlTest3 = hxlTest3;
    }

    public float getHxlTest4() {
        return hxlTest4;
    }

    public void setHxlTest4(float hxlTest4) {
        this.hxlTest4 = hxlTest4;
    }

    public float getHxlTest5() {
        return hxlTest5;
    }

    public void setHxlTest5(float hxlTest5) {
        this.hxlTest5 = hxlTest5;
    }

    public float getHxlValue1() {
        return hxlValue1;
    }

    public void setHxlValue1(float hxlValue1) {
        this.hxlValue1 = hxlValue1;
    }

    public float getHxlValue2() {
        return hxlValue2;
    }

    public void setHxlValue2(float hxlValue2) {
        this.hxlValue2 = hxlValue2;
    }

    public float getHxlValue3() {
        return hxlValue3;
    }

    public void setHxlValue3(float hxlValue3) {
        this.hxlValue3 = hxlValue3;
    }

    public float getHxlValue4() {
        return hxlValue4;
    }

    public void setHxlValue4(float hxlValue4) {
        this.hxlValue4 = hxlValue4;
    }

    public float getHxlValue5() {
        return hxlValue5;
    }

    public void setHxlValue5(float hxlValue5) {
        this.hxlValue5 = hxlValue5;
    }

    public float getHxlWc() {
        return hxlWc;
    }

    public void setHxlWc(float hxlWc) {
        this.hxlWc = hxlWc;
    }

    public Byte getHxlResult() {
        return hxlResult;
    }

    public void setHxlResult(Byte hxlResult) {
        this.hxlResult = hxlResult;
    }

    public float getXybhdTest1() {
        return xybhdTest1;
    }

    public void setXybhdTest1(float xybhdTest1) {
        this.xybhdTest1 = xybhdTest1;
    }

    public float getXybhdTest2() {
        return xybhdTest2;
    }

    public void setXybhdTest2(float xybhdTest2) {
        this.xybhdTest2 = xybhdTest2;
    }

    public float getXybhdTest3() {
        return xybhdTest3;
    }

    public void setXybhdTest3(float xybhdTest3) {
        this.xybhdTest3 = xybhdTest3;
    }

    public float getXybhdTest4() {
        return xybhdTest4;
    }

    public void setXybhdTest4(float xybhdTest4) {
        this.xybhdTest4 = xybhdTest4;
    }

    public float getXybhdTest5() {
        return xybhdTest5;
    }

    public void setXybhdTest5(float xybhdTest5) {
        this.xybhdTest5 = xybhdTest5;
    }

    public float getXybhdValue1() {
        return xybhdValue1;
    }

    public void setXybhdValue1(float xybhdValue1) {
        this.xybhdValue1 = xybhdValue1;
    }

    public float getXybhdValue2() {
        return xybhdValue2;
    }

    public void setXybhdValue2(float xybhdValue2) {
        this.xybhdValue2 = xybhdValue2;
    }

    public float getXybhdValue3() {
        return xybhdValue3;
    }

    public void setXybhdValue3(float xybhdValue3) {
        this.xybhdValue3 = xybhdValue3;
    }

    public float getXybhdValue4() {
        return xybhdValue4;
    }

    public void setXybhdValue4(float xybhdValue4) {
        this.xybhdValue4 = xybhdValue4;
    }

    public float getXybhdValue5() {
        return xybhdValue5;
    }

    public void setXybhdValue5(float xybhdValue5) {
        this.xybhdValue5 = xybhdValue5;
    }

    public float getXybhdWc() {
        return xybhdWc;
    }

    public void setXybhdWc(float xybhdWc) {
        this.xybhdWc = xybhdWc;
    }

    public Byte getXybhdResult() {
        return xybhdResult;
    }

    public void setXybhdResult(Byte xybhdResult) {
        this.xybhdResult = xybhdResult;
    }

    public float getWcxyHTest1() {
        return wcxyHTest1;
    }

    public void setWcxyHTest1(float wcxyHTest1) {
        this.wcxyHTest1 = wcxyHTest1;
    }

    public float getWcxyMTest1() {
        return wcxyMTest1;
    }

    public void setWcxyMTest1(float wcxyMTest1) {
        this.wcxyMTest1 = wcxyMTest1;
    }

    public float getWcxyLTest1() {
        return wcxyLTest1;
    }

    public void setWcxyLTest1(float wcxyLTest1) {
        this.wcxyLTest1 = wcxyLTest1;
    }

    public float getWcxyHTest2() {
        return wcxyHTest2;
    }

    public void setWcxyHTest2(float wcxyHTest2) {
        this.wcxyHTest2 = wcxyHTest2;
    }

    public float getWcxyMTest2() {
        return wcxyMTest2;
    }

    public void setWcxyMTest2(float wcxyMTest2) {
        this.wcxyMTest2 = wcxyMTest2;
    }

    public float getWcxyLTest2() {
        return wcxyLTest2;
    }

    public void setWcxyLTest2(float wcxyLTest2) {
        this.wcxyLTest2 = wcxyLTest2;
    }

    public float getWcxyHTest3() {
        return wcxyHTest3;
    }

    public void setWcxyHTest3(float wcxyHTest3) {
        this.wcxyHTest3 = wcxyHTest3;
    }

    public float getWcxyMTest3() {
        return wcxyMTest3;
    }

    public void setWcxyMTest3(float wcxyMTest3) {
        this.wcxyMTest3 = wcxyMTest3;
    }

    public float getWcxyLTest3() {
        return wcxyLTest3;
    }

    public void setWcxyLTest3(float wcxyLTest3) {
        this.wcxyLTest3 = wcxyLTest3;
    }

    public float getWcxyHTest4() {
        return wcxyHTest4;
    }

    public void setWcxyHTest4(float wcxyHTest4) {
        this.wcxyHTest4 = wcxyHTest4;
    }

    public float getWcxyMTest4() {
        return wcxyMTest4;
    }

    public void setWcxyMTest4(float wcxyMTest4) {
        this.wcxyMTest4 = wcxyMTest4;
    }

    public float getWcxyLTest4() {
        return wcxyLTest4;
    }

    public void setWcxyLTest4(float wcxyLTest4) {
        this.wcxyLTest4 = wcxyLTest4;
    }

    public float getWcxyHTest5() {
        return wcxyHTest5;
    }

    public void setWcxyHTest5(float wcxyHTest5) {
        this.wcxyHTest5 = wcxyHTest5;
    }

    public float getWcxyMTest5() {
        return wcxyMTest5;
    }

    public void setWcxyMTest5(float wcxyMTest5) {
        this.wcxyMTest5 = wcxyMTest5;
    }

    public float getWcxyLTest5() {
        return wcxyLTest5;
    }

    public void setWcxyLTest5(float wcxyLTest5) {
        this.wcxyLTest5 = wcxyLTest5;
    }

    public float getWcxyHValue11() {
        return wcxyHValue11;
    }

    public void setWcxyHValue11(float wcxyHValue11) {
        this.wcxyHValue11 = wcxyHValue11;
    }

    public float getWcxyMValue11() {
        return wcxyMValue11;
    }

    public void setWcxyMValue11(float wcxyMValue11) {
        this.wcxyMValue11 = wcxyMValue11;
    }

    public float getWcxyLValue11() {
        return wcxyLValue11;
    }

    public void setWcxyLValue11(float wcxyLValue11) {
        this.wcxyLValue11 = wcxyLValue11;
    }

    public float getWcxyHValue12() {
        return wcxyHValue12;
    }

    public void setWcxyHValue12(float wcxyHValue12) {
        this.wcxyHValue12 = wcxyHValue12;
    }

    public float getWcxyMValue12() {
        return wcxyMValue12;
    }

    public void setWcxyMValue12(float wcxyMValue12) {
        this.wcxyMValue12 = wcxyMValue12;
    }

    public float getWcxyLValue12() {
        return wcxyLValue12;
    }

    public void setWcxyLValue12(float wcxyLValue12) {
        this.wcxyLValue12 = wcxyLValue12;
    }

    public float getWcxyHValue13() {
        return wcxyHValue13;
    }

    public void setWcxyHValue13(float wcxyHValue13) {
        this.wcxyHValue13 = wcxyHValue13;
    }

    public float getWcxyMValue13() {
        return wcxyMValue13;
    }

    public void setWcxyMValue13(float wcxyMValue13) {
        this.wcxyMValue13 = wcxyMValue13;
    }

    public float getWcxyLValue13() {
        return wcxyLValue13;
    }

    public void setWcxyLValue13(float wcxyLValue13) {
        this.wcxyLValue13 = wcxyLValue13;
    }

    public float getWcxyHValue14() {
        return wcxyHValue14;
    }

    public void setWcxyHValue14(float wcxyHValue14) {
        this.wcxyHValue14 = wcxyHValue14;
    }

    public float getWcxyMValue14() {
        return wcxyMValue14;
    }

    public void setWcxyMValue14(float wcxyMValue14) {
        this.wcxyMValue14 = wcxyMValue14;
    }

    public float getWcxyLValue14() {
        return wcxyLValue14;
    }

    public void setWcxyLValue14(float wcxyLValue14) {
        this.wcxyLValue14 = wcxyLValue14;
    }

    public float getWcxyHValue15() {
        return wcxyHValue15;
    }

    public void setWcxyHValue15(float wcxyHValue15) {
        this.wcxyHValue15 = wcxyHValue15;
    }

    public float getWcxyMValue15() {
        return wcxyMValue15;
    }

    public void setWcxyMValue15(float wcxyMValue15) {
        this.wcxyMValue15 = wcxyMValue15;
    }

    public float getWcxyLValue15() {
        return wcxyLValue15;
    }

    public void setWcxyLValue15(float wcxyLValue15) {
        this.wcxyLValue15 = wcxyLValue15;
    }

    public float getWcxyHValue21() {
        return wcxyHValue21;
    }

    public void setWcxyHValue21(float wcxyHValue21) {
        this.wcxyHValue21 = wcxyHValue21;
    }

    public float getWcxyMValue21() {
        return wcxyMValue21;
    }

    public void setWcxyMValue21(float wcxyMValue21) {
        this.wcxyMValue21 = wcxyMValue21;
    }

    public float getWcxyLValue21() {
        return wcxyLValue21;
    }

    public void setWcxyLValue21(float wcxyLValue21) {
        this.wcxyLValue21 = wcxyLValue21;
    }

    public float getWcxyHValue22() {
        return wcxyHValue22;
    }

    public void setWcxyHValue22(float wcxyHValue22) {
        this.wcxyHValue22 = wcxyHValue22;
    }

    public float getWcxyMValue22() {
        return wcxyMValue22;
    }

    public void setWcxyMValue22(float wcxyMValue22) {
        this.wcxyMValue22 = wcxyMValue22;
    }

    public float getWcxyLValue22() {
        return wcxyLValue22;
    }

    public void setWcxyLValue22(float wcxyLValue22) {
        this.wcxyLValue22 = wcxyLValue22;
    }

    public float getWcxyHValue23() {
        return wcxyHValue23;
    }

    public void setWcxyHValue23(float wcxyHValue23) {
        this.wcxyHValue23 = wcxyHValue23;
    }

    public float getWcxyMValue23() {
        return wcxyMValue23;
    }

    public void setWcxyMValue23(float wcxyMValue23) {
        this.wcxyMValue23 = wcxyMValue23;
    }

    public float getWcxyLValue23() {
        return wcxyLValue23;
    }

    public void setWcxyLValue23(float wcxyLValue23) {
        this.wcxyLValue23 = wcxyLValue23;
    }

    public float getWcxyHValue24() {
        return wcxyHValue24;
    }

    public void setWcxyHValue24(float wcxyHValue24) {
        this.wcxyHValue24 = wcxyHValue24;
    }

    public float getWcxyMValue24() {
        return wcxyMValue24;
    }

    public void setWcxyMValue24(float wcxyMValue24) {
        this.wcxyMValue24 = wcxyMValue24;
    }

    public float getWcxyLValue24() {
        return wcxyLValue24;
    }

    public void setWcxyLValue24(float wcxyLValue24) {
        this.wcxyLValue24 = wcxyLValue24;
    }

    public float getWcxyHValue25() {
        return wcxyHValue25;
    }

    public void setWcxyHValue25(float wcxyHValue25) {
        this.wcxyHValue25 = wcxyHValue25;
    }

    public float getWcxyMValue25() {
        return wcxyMValue25;
    }

    public void setWcxyMValue25(float wcxyMValue25) {
        this.wcxyMValue25 = wcxyMValue25;
    }

    public float getWcxyLValue25() {
        return wcxyLValue25;
    }

    public void setWcxyLValue25(float wcxyLValue25) {
        this.wcxyLValue25 = wcxyLValue25;
    }

    public float getWcxyHValue31() {
        return wcxyHValue31;
    }

    public void setWcxyHValue31(float wcxyHValue31) {
        this.wcxyHValue31 = wcxyHValue31;
    }

    public float getWcxyMValue31() {
        return wcxyMValue31;
    }

    public void setWcxyMValue31(float wcxyMValue31) {
        this.wcxyMValue31 = wcxyMValue31;
    }

    public float getWcxyLValue31() {
        return wcxyLValue31;
    }

    public void setWcxyLValue31(float wcxyLValue31) {
        this.wcxyLValue31 = wcxyLValue31;
    }

    public float getWcxyHValue32() {
        return wcxyHValue32;
    }

    public void setWcxyHValue32(float wcxyHValue32) {
        this.wcxyHValue32 = wcxyHValue32;
    }

    public float getWcxyMValue32() {
        return wcxyMValue32;
    }

    public void setWcxyMValue32(float wcxyMValue32) {
        this.wcxyMValue32 = wcxyMValue32;
    }

    public float getWcxyLValue32() {
        return wcxyLValue32;
    }

    public void setWcxyLValue32(float wcxyLValue32) {
        this.wcxyLValue32 = wcxyLValue32;
    }

    public float getWcxyHValue33() {
        return wcxyHValue33;
    }

    public void setWcxyHValue33(float wcxyHValue33) {
        this.wcxyHValue33 = wcxyHValue33;
    }

    public float getWcxyMValue33() {
        return wcxyMValue33;
    }

    public void setWcxyMValue33(float wcxyMValue33) {
        this.wcxyMValue33 = wcxyMValue33;
    }

    public float getWcxyLValue33() {
        return wcxyLValue33;
    }

    public void setWcxyLValue33(float wcxyLValue33) {
        this.wcxyLValue33 = wcxyLValue33;
    }

    public float getWcxyHValue34() {
        return wcxyHValue34;
    }

    public void setWcxyHValue34(float wcxyHValue34) {
        this.wcxyHValue34 = wcxyHValue34;
    }

    public float getWcxyMValue34() {
        return wcxyMValue34;
    }

    public void setWcxyMValue34(float wcxyMValue34) {
        this.wcxyMValue34 = wcxyMValue34;
    }

    public float getWcxyLValue34() {
        return wcxyLValue34;
    }

    public void setWcxyLValue34(float wcxyLValue34) {
        this.wcxyLValue34 = wcxyLValue34;
    }

    public float getWcxyHValue35() {
        return wcxyHValue35;
    }

    public void setWcxyHValue35(float wcxyHValue35) {
        this.wcxyHValue35 = wcxyHValue35;
    }

    public float getWcxyMValue35() {
        return wcxyMValue35;
    }

    public void setWcxyMValue35(float wcxyMValue35) {
        this.wcxyMValue35 = wcxyMValue35;
    }

    public float getWcxyLValue35() {
        return wcxyLValue35;
    }

    public void setWcxyLValue35(float wcxyLValue35) {
        this.wcxyLValue35 = wcxyLValue35;
    }

    public float getWcxyWc() {
        return wcxyWc;
    }

    public void setWcxyWc(float wcxyWc) {
        this.wcxyWc = wcxyWc;
    }

    public Byte getWcxyResult() {
        return wcxyResult;
    }

    public void setWcxyResult(Byte wcxyResult) {
        this.wcxyResult = wcxyResult;
    }

    public float getWcxyjtSd() {
        return wcxyjtSd;
    }

    public void setWcxyjtSd(float wcxyjtSd) {
        this.wcxyjtSd = wcxyjtSd;
    }

    public float getWcxyjtMnq() {
        return wcxyjtMnq;
    }

    public void setWcxyjtMnq(float wcxyjtMnq) {
        this.wcxyjtMnq = wcxyjtMnq;
    }

    public float getWcxyjtJhy() {
        return wcxyjtJhy;
    }

    public void setWcxyjtJhy(float wcxyjtJhy) {
        this.wcxyjtJhy = wcxyjtJhy;
    }

    public float getWcxyjtWc() {
        return wcxyjtWc;
    }

    public void setWcxyjtWc(float wcxyjtWc) {
        this.wcxyjtWc = wcxyjtWc;
    }

    public Byte getWcxyjtResult() {
        return wcxyjtResult;
    }

    public void setWcxyjtResult(Byte wcxyjtResult) {
        this.wcxyjtResult = wcxyjtResult;
    }

    public float getWcxyqmSd() {
        return wcxyqmSd;
    }

    public void setWcxyqmSd(float wcxyqmSd) {
        this.wcxyqmSd = wcxyqmSd;
    }

    public float getWcxyqmXll() {
        return wcxyqmXll;
    }

    public void setWcxyqmXll(float wcxyqmXll) {
        this.wcxyqmXll = wcxyqmXll;
    }

    public float getWcxyqmWc() {
        return wcxyqmWc;
    }

    public void setWcxyqmWc(float wcxyqmWc) {
        this.wcxyqmWc = wcxyqmWc;
    }

    public Byte getWcxyqmResult() {
        return wcxyqmResult;
    }

    public void setWcxyqmResult(Byte wcxyqmResult) {
        this.wcxyqmResult = wcxyqmResult;
    }

    public Byte getSgbjResult() {
        return sgbjResult;
    }

    public void setSgbjResult(Byte sgbjResult) {
        this.sgbjResult = sgbjResult;
    }

    public Byte getBjxjcResult() {
        return bjxjcResult;
    }

    public void setBjxjcResult(Byte bjxjcResult) {
        this.bjxjcResult = bjxjcResult;
    }

    public Byte getJyjcResult() {
        return jyjcResult;
    }

    public void setJyjcResult(Byte jyjcResult) {
        this.jyjcResult = jyjcResult;
    }

    public String getSpare2() {
        return spare2;
    }

    public void setSpare2(String spare2) {
        this.spare2 = spare2 == null ? null : spare2.trim();
    }

    public String getSpare3() {
        return spare3;
    }

    public void setSpare3(String spare3) {
        this.spare3 = spare3 == null ? null : spare3.trim();
    }
    
}