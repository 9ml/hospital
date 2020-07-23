package com.litbo.hospitalzj.checklist.service;

import com.litbo.hospitalzj.checklist.domain.Gpdd;
import com.litbo.hospitalzj.zk.domian.GpddTemplate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MriService {

    //查询模板值
    public GpddTemplate findTemplate();
    //修改模板值
    public void updateGpddTemplate(GpddTemplate gpddTemplate);
    //插入模板值
    public void insert(GpddTemplate gpddTemplate);
   //保存高频电刀数据
    void save(Gpdd gpdd);
    //修改数据
    void updateGpdd(Gpdd gpdd);
    //根据设备id查询检测表高频电刀
    public Gpdd findGpdd(String eqId);
    //查询一条
    Gpdd find();
    //根据设备Id,检测仪器Id以及状态查询电切表查询最后一条记录
    Gpdd findByEqIdandJcyqIdLast1(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //根据设备Id,检测仪器Id以及状态查询电切表
    List<Gpdd> findByEqIdandJcyqId(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //查询所有
    List<Gpdd> findAll();

    //根据检测仪器Id查询
    Gpdd findByGpddid(@Param("gpddid") Integer gpddid);

    //修改审核人意见
    void updateShrJcjy(@Param("gpddid") Integer gpddid, @Param("shrJcjl") String shrJcjl, @Param("auditor") String auditor);
}
