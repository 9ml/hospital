package com.litbo.hospitalzj.checklist.service;

import com.litbo.hospitalzj.checklist.domain.Pflsb;
import com.litbo.hospitalzj.checklist.domain.PflsbTemplate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PflsbService {

    //查询模板值
    public PflsbTemplate findTemplate();
    //修改模板值
    public void updatePflsbTemplate(PflsbTemplate pflsbTemplate);
    //插入模板值
    public void insert(PflsbTemplate pflsbTemplate);
   //保存高频电刀数据
    void save(Pflsb pflsb);
    //修改数据
    void updatePflsb(Pflsb pflsb);
    //根据设备id查询检测表高频电刀
    public Pflsb findPflsb(String eqId);
    //查询一条
    Pflsb find();
    //根据设备Id,检测仪器Id以及状态查询电切表查询最后一条记录
    Pflsb findByEqIdandJcyqIdLast1(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //根据设备Id,检测仪器Id以及状态查询电切表
    List<Pflsb> findByEqIdandJcyqId(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //查询所有
    List<Pflsb> findAll();

    //根据检测仪器Id查询
    Pflsb findByPflsbId(@Param("pflsbId") Integer pflsbId);

    //修改审核人意见
    void updateShrJcjy(@Param("pflsbId") Integer pflsbId, @Param("shrJcjl") String shrJcjl, @Param("auditor") String auditor);
}
