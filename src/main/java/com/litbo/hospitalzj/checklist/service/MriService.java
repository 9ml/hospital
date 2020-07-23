package com.litbo.hospitalzj.checklist.service;

import com.litbo.hospitalzj.checklist.domain.Mri;
import com.litbo.hospitalzj.checklist.domain.MriTemplate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MriService {

    //查询模板值
    public MriTemplate findTemplate();
    //修改模板值
    public void updateMriTemplate(MriTemplate mriTemplate);
    //插入模板值
    public void insert(MriTemplate mriTemplate);
   //保存高频电刀数据
    void save(Mri mri);
    //修改数据
    void updateMri(Mri mri);
    //根据设备id查询检测表高频电刀
    public Mri findMri(String eqId);
    //查询一条
    Mri find();
    //根据设备Id,检测仪器Id以及状态查询电切表查询最后一条记录
    Mri findByEqIdandJcyqIdLast1(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //根据设备Id,检测仪器Id以及状态查询电切表
    List<Mri> findByEqIdandJcyqId(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //查询所有
    List<Mri> findAll();

    //根据检测仪器Id查询
    Mri findByMriId(@Param("mriId") Integer mriId);

    //修改审核人意见
    void updateShrJcjy(@Param("mriId") Integer mriId, @Param("shrJcjl") String shrJcjl, @Param("auditor") String auditor);
}
