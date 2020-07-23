package com.litbo.hospitalzj.checklist.service;

import com.litbo.hospitalzj.checklist.domain.Syb;
import com.litbo.hospitalzj.checklist.domain.SybTemplate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SybService {

    //查询模板值
    public SybTemplate findTemplate();
    //修改模板值
    public void updateSybTemplate(SybTemplate sybTemplate);
    //插入模板值
    public void insert(SybTemplate sybTemplate);
   //保存高频电刀数据
    void save(Syb syb);
    //修改数据
    void updateSyb(Syb syb);
    //根据设备id查询检测表高频电刀
    public Syb findSyb(String eqId);
    //查询一条
    Syb find();
    //根据设备Id,检测仪器Id以及状态查询电切表查询最后一条记录
    Syb findByEqIdandJcyqIdLast1(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //根据设备Id,检测仪器Id以及状态查询电切表
    List<Syb> findByEqIdandJcyqId(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //查询所有
    List<Syb> findAll();

    //根据检测仪器Id查询
    Syb findBySybId(@Param("sybId") Integer sybId);

    //修改审核人意见
    void updateShrJcjy(@Param("sybId") Integer sybId, @Param("shrJcjl") String shrJcjl, @Param("auditor") String auditor);
}
