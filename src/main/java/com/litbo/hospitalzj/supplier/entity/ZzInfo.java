package com.litbo.hospitalzj.supplier.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
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

 }