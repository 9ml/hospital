package com.litbo.hospitalzj.supplier.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ZzInfo {
    private Integer zzId;

    private Integer suId;

    private String zzYyzch;

    private String zzYyzzbh;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date zzYyclrq;

    private String zzYyfdr;

    private String zzYyzczj;

    private String zzQylx;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date zzYysxrq;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date zzYyjzrq;

    private String zzYyyx;

    private String zzZlglr;

    private String zzZlglrdz;

    private String zzYyscdz;

    private String zzCkdz;

    private String zzYyjyfw;

    private String zzYybz;

    private String zzJyzh;

    private String zzJyqyfzr;

    private String zzJyfddbr;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date zzJysxrq;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date zzJyjzrq;

    private String zzJyyx;

    private String zzJyzcdz;

    private String zzJybz;

    private String zzZzdm;

    private String zzZzlx;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date zzZzsxrq;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date zzZzjzrq;

    private String zzZzdz;

    private String zzZzyx;

    private String zzZzbz;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date nowTime;

    public Date getNowTime() {
        return nowTime;
    }

    public void setNowTime(Date nowTime) {
        this.nowTime = nowTime;
    }

    public String getZzZzyx() {
        return zzZzyx;
    }

    public void setZzZzyx(String zzZzyx) {
        this.zzZzyx = zzZzyx;
    }

    public String getZzYyjyfw() {
        return zzYyjyfw;
    }

    public void setZzYyjyfw(String zzYyjyfw) {
        this.zzYyjyfw = zzYyjyfw;
    }

    public Integer getZzId() {
        return zzId;
    }

    public void setZzId(Integer zzId) {
        this.zzId = zzId;
    }

    public Integer getSuId() {
        return suId;
    }

    public void setSuId(Integer suId) {
        this.suId = suId;
    }

    public String getZzYyzch() {
        return zzYyzch;
    }

    public void setZzYyzch(String zzYyzch) {
        this.zzYyzch = zzYyzch == null ? null : zzYyzch.trim();
    }

    public String getZzYyzzbh() {
        return zzYyzzbh;
    }

    public void setZzYyzzbh(String zzYyzzbh) {
        this.zzYyzzbh = zzYyzzbh == null ? null : zzYyzzbh.trim();
    }

    public Date getZzYyclrq() {
        return zzYyclrq;
    }

    public void setZzYyclrq(Date zzYyclrq) {
        this.zzYyclrq = zzYyclrq;
    }

    public String getZzYyfdr() {
        return zzYyfdr;
    }

    public void setZzYyfdr(String zzYyfdr) {
        this.zzYyfdr = zzYyfdr == null ? null : zzYyfdr.trim();
    }

    public String getZzYyzczj() {
        return zzYyzczj;
    }

    public void setZzYyzczj(String zzYyzczj) {
        this.zzYyzczj = zzYyzczj == null ? null : zzYyzczj.trim();
    }

    public String getZzQylx() {
        return zzQylx;
    }

    public void setZzQylx(String zzQylx) {
        this.zzQylx = zzQylx == null ? null : zzQylx.trim();
    }

    public Date getZzYysxrq() {
        return zzYysxrq;
    }

    public void setZzYysxrq(Date zzYysxrq) {
        this.zzYysxrq = zzYysxrq;
    }

    public Date getZzYyjzrq() {
        return zzYyjzrq;
    }

    public void setZzYyjzrq(Date zzYyjzrq) {
        this.zzYyjzrq = zzYyjzrq;
    }

    public String getZzYyyx() {
        return zzYyyx;
    }

    public void setZzYyyx(String zzYyyx) {
        this.zzYyyx = zzYyyx == null ? null : zzYyyx.trim();
    }

    public String getZzZlglr() {
        return zzZlglr;
    }

    public void setZzZlglr(String zzZlglr) {
        this.zzZlglr = zzZlglr == null ? null : zzZlglr.trim();
    }

    public String getZzZlglrdz() {
        return zzZlglrdz;
    }

    public void setZzZlglrdz(String zzZlglrdz) {
        this.zzZlglrdz = zzZlglrdz == null ? null : zzZlglrdz.trim();
    }

    public String getZzYyscdz() {
        return zzYyscdz;
    }

    public void setZzYyscdz(String zzYyscdz) {
        this.zzYyscdz = zzYyscdz == null ? null : zzYyscdz.trim();
    }

    public String getZzCkdz() {
        return zzCkdz;
    }

    public void setZzCkdz(String zzCkdz) {
        this.zzCkdz = zzCkdz == null ? null : zzCkdz.trim();
    }

    public String getZzYybz() {
        return zzYybz;
    }

    public void setZzYybz(String zzYybz) {
        this.zzYybz = zzYybz == null ? null : zzYybz.trim();
    }

    public String getZzJyzh() {
        return zzJyzh;
    }

    public void setZzJyzh(String zzJyzh) {
        this.zzJyzh = zzJyzh == null ? null : zzJyzh.trim();
    }

    public String getZzJyqyfzr() {
        return zzJyqyfzr;
    }

    public void setZzJyqyfzr(String zzJyqyfzr) {
        this.zzJyqyfzr = zzJyqyfzr == null ? null : zzJyqyfzr.trim();
    }

    public String getZzJyfddbr() {
        return zzJyfddbr;
    }

    public void setZzJyfddbr(String zzJyfddbr) {
        this.zzJyfddbr = zzJyfddbr == null ? null : zzJyfddbr.trim();
    }

    public Date getZzJysxrq() {
        return zzJysxrq;
    }

    public void setZzJysxrq(Date zzJysxrq) {
        this.zzJysxrq = zzJysxrq;
    }

    public Date getZzJyjzrq() {
        return zzJyjzrq;
    }

    public void setZzJyjzrq(Date zzJyjzrq) {
        this.zzJyjzrq = zzJyjzrq;
    }

    public String getZzJyyx() {
        return zzJyyx;
    }

    public void setZzJyyx(String zzJyyx) {
        this.zzJyyx = zzJyyx == null ? null : zzJyyx.trim();
    }

    public String getZzJyzcdz() {
        return zzJyzcdz;
    }

    public void setZzJyzcdz(String zzJyzcdz) {
        this.zzJyzcdz = zzJyzcdz == null ? null : zzJyzcdz.trim();
    }

    public String getZzJybz() {
        return zzJybz;
    }

    public void setZzJybz(String zzJybz) {
        this.zzJybz = zzJybz == null ? null : zzJybz.trim();
    }

    public String getZzZzdm() {
        return zzZzdm;
    }

    public void setZzZzdm(String zzZzdm) {
        this.zzZzdm = zzZzdm == null ? null : zzZzdm.trim();
    }

    public String getZzZzlx() {
        return zzZzlx;
    }

    public void setZzZzlx(String zzZzlx) {
        this.zzZzlx = zzZzlx == null ? null : zzZzlx.trim();
    }

    public Date getZzZzsxrq() {
        return zzZzsxrq;
    }

    public void setZzZzsxrq(Date zzZzsxrq) {
        this.zzZzsxrq = zzZzsxrq;
    }

    public Date getZzZzjzrq() {
        return zzZzjzrq;
    }

    public void setZzZzjzrq(Date zzZzjzrq) {
        this.zzZzjzrq = zzZzjzrq;
    }

    public String getZzZzdz() {
        return zzZzdz;
    }

    public void setZzZzdz(String zzZzdz) {
        this.zzZzdz = zzZzdz == null ? null : zzZzdz.trim();
    }

    public String getZzZzbz() {
        return zzZzbz;
    }

    public void setZzZzbz(String zzZzbz) {
        this.zzZzbz = zzZzbz == null ? null : zzZzbz.trim();
    }
}