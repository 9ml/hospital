package com.litbo.hospitalzj.checklist.service;

import com.litbo.hospitalzj.checklist.domain.Zsb;
import com.litbo.hospitalzj.checklist.domain.ZsbTemplate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ZsbService {

    //查询模板值
    public ZsbTemplate findTemplate();
    //修改模板值
    public void updateZsbTemplate(ZsbTemplate zsbTemplate);
    //插入模板值
    public void insert(ZsbTemplate zsbTemplate);
   //保存高频电刀数据
    void save(Zsb zsb);
    //修改数据
    void updateZsb(Zsb zsb);
    //根据设备id查询检测表高频电刀
    public Zsb findZsb(String eqId);
    //查询一条
    Zsb find();
    //根据设备Id,检测仪器Id以及状态查询电切表查询最后一条记录
    Zsb findByEqIdandJcyqIdLast1(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //根据设备Id,检测仪器Id以及状态查询电切表
    List<Zsb> findByEqIdandJcyqId(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //查询所有
    List<Zsb> findAll();

    //根据检测仪器Id查询
    Zsb findByZsbId(@Param("zsbId") Integer zsbId);

    //修改审核人意见
    void updateShrJcjy(@Param("zsbId") Integer zsbId, @Param("shrJcjl") String shrJcjl, @Param("auditor") String auditor);
}
