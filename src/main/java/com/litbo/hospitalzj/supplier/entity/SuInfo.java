package com.litbo.hospitalzj.supplier.entity;

public class SuInfo {
    private Integer suId;

    private String suMc;

    private String password;

    private String suSf;

    private String suCs;

    private String suXq;

    private String suFr;

    private String suDjr;

    private String suFzr;

    private String suKhyh;

    private String suKhyhzh;

    private String suGsdz;

    private String suLxrxm;

    private String suLxrdh;

    private String suLxrbm;

    private String suDh;

    private String suYb;

    private String suEmail;

    private String suCz;

    private String suWz;

    private String bz;

    private Integer isDelete;
    
    private Integer state;

    private String nowTime;

    public String getNowTime() {
        return nowTime;
    }

    public void setNowTime(String nowTime) {
        this.nowTime = nowTime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getSuMc() {
        return suMc;
    }

    public void setSuMc(String suMc) {
        this.suMc = suMc;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getSuId() {
        return suId;
    }

    public void setSuId(Integer suId) {
        this.suId = suId;
    }

    public String getSuSf() {
        return suSf;
    }

    public void setSuSf(String suSf) {
        this.suSf = suSf == null ? null : suSf.trim();
    }

    public String getSuCs() {
        return suCs;
    }

    public void setSuCs(String suCs) {
        this.suCs = suCs == null ? null : suCs.trim();
    }

    public String getSuXq() {
        return suXq;
    }

    public void setSuXq(String suXq) {
        this.suXq = suXq == null ? null : suXq.trim();
    }

    public String getSuFr() {
        return suFr;
    }

    public void setSuFr(String suFr) {
        this.suFr = suFr == null ? null : suFr.trim();
    }

    public String getSuDjr() {
        return suDjr;
    }

    public void setSuDjr(String suDjr) {
        this.suDjr = suDjr == null ? null : suDjr.trim();
    }

    public String getSuFzr() {
        return suFzr;
    }

    public void setSuFzr(String suFzr) {
        this.suFzr = suFzr == null ? null : suFzr.trim();
    }

    public String getSuKhyh() {
        return suKhyh;
    }

    public void setSuKhyh(String suKhyh) {
        this.suKhyh = suKhyh == null ? null : suKhyh.trim();
    }

    public String getSuKhyhzh() {
        return suKhyhzh;
    }

    public void setSuKhyhzh(String suKhyhzh) {
        this.suKhyhzh = suKhyhzh == null ? null : suKhyhzh.trim();
    }

    public String getSuGsdz() {
        return suGsdz;
    }

    public void setSuGsdz(String suGsdz) {
        this.suGsdz = suGsdz == null ? null : suGsdz.trim();
    }

    public String getSuLxrxm() {
        return suLxrxm;
    }

    public void setSuLxrxm(String suLxrxm) {
        this.suLxrxm = suLxrxm == null ? null : suLxrxm.trim();
    }

    public String getSuLxrdh() {
        return suLxrdh;
    }

    public void setSuLxrdh(String suLxrdh) {
        this.suLxrdh = suLxrdh == null ? null : suLxrdh.trim();
    }

    public String getSuLxrbm() {
        return suLxrbm;
    }

    public void setSuLxrbm(String suLxrbm) {
        this.suLxrbm = suLxrbm == null ? null : suLxrbm.trim();
    }

    public String getSuDh() {
        return suDh;
    }

    public void setSuDh(String suDh) {
        this.suDh = suDh == null ? null : suDh.trim();
    }

    public String getSuYb() {
        return suYb;
    }

    public void setSuYb(String suYb) {
        this.suYb = suYb == null ? null : suYb.trim();
    }

    public String getSuEmail() {
        return suEmail;
    }

    public void setSuEmail(String suEmail) {
        this.suEmail = suEmail == null ? null : suEmail.trim();
    }

    public String getSuCz() {
        return suCz;
    }

    public void setSuCz(String suCz) {
        this.suCz = suCz == null ? null : suCz.trim();
    }

    public String getSuWz() {
        return suWz;
    }

    public void setSuWz(String suWz) {
        this.suWz = suWz == null ? null : suWz.trim();
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }

    @Override
    public String toString() {
        return "SuInfo{" +
                "suId=" + suId +
                ", suMc='" + suMc + '\'' +
                ", password='" + password + '\'' +
                ", suSf='" + suSf + '\'' +
                ", suCs='" + suCs + '\'' +
                ", suXq='" + suXq + '\'' +
                ", suFr='" + suFr + '\'' +
                ", suDjr='" + suDjr + '\'' +
                ", suFzr='" + suFzr + '\'' +
                ", suKhyh='" + suKhyh + '\'' +
                ", suKhyhzh='" + suKhyhzh + '\'' +
                ", suGsdz='" + suGsdz + '\'' +
                ", suLxrxm='" + suLxrxm + '\'' +
                ", suLxrdh='" + suLxrdh + '\'' +
                ", suLxrbm='" + suLxrbm + '\'' +
                ", suDh='" + suDh + '\'' +
                ", suYb='" + suYb + '\'' +
                ", suEmail='" + suEmail + '\'' +
                ", suCz='" + suCz + '\'' +
                ", suWz='" + suWz + '\'' +
                ", bz='" + bz + '\'' +
                ", isDelete=" + isDelete +
                ", state=" + state +
                '}';
    }
}