package com.litbo.hospitalzj.checklist.service;

import com.litbo.hospitalzj.checklist.domain.Ypj;
import com.litbo.hospitalzj.checklist.domain.YpjTemplate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface YpjService {

    //查询模板值
    public YpjTemplate findTemplate();
    //修改模板值
    public void updateYpjTemplate(YpjTemplate ypjTemplate);
    //插入模板值
    public void insert(YpjTemplate ypjTemplate);
   //保存高频电刀数据
    void save(Ypj ypj);
    //修改数据
    void updateYpj(Ypj ypj);
    //根据设备id查询检测表高频电刀
    public Ypj findYpj(String eqId);
    //查询一条
    Ypj find();
    //根据设备Id,检测仪器Id以及状态查询电切表查询最后一条记录
    Ypj findByEqIdandJcyqIdLast1(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //根据设备Id,检测仪器Id以及状态查询电切表
    List<Ypj> findByEqIdandJcyqId(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //查询所有
    List<Ypj> findAll();

    //根据检测仪器Id查询
    Ypj findByYpjId(@Param("ypjId") Integer ypjId);

    //修改审核人意见
    void updateShrJcjy(@Param("ypjId") Integer ypjId, @Param("shrJcjl") String shrJcjl, @Param("auditor") String auditor);
}
