package com.litbo.hospitalzj.checklist.service;

import com.litbo.hospitalzj.checklist.domain.Pbszcwj;
import com.litbo.hospitalzj.checklist.domain.PbszcwjTemplate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PbszcwjService {

    //查询模板值
    public PbszcwjTemplate findTemplate();
    //修改模板值
    public void updatePbszcwjTemplate(PbszcwjTemplate pbszcwjTemplate);
    //插入模板值
    public void insert(PbszcwjTemplate pbszcwjTemplate);
   //保存高频电刀数据
    void save(Pbszcwj pbszcwj);
    //修改数据
    void updatePbszcwj(Pbszcwj pbszcwj);
    //根据设备id查询检测表高频电刀
    public Pbszcwj findPbszcwj(String eqId);
    //查询一条
    Pbszcwj find();
    //根据设备Id,检测仪器Id以及状态查询电切表查询最后一条记录
    Pbszcwj findByEqIdandJcyqIdLast1(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //根据设备Id,检测仪器Id以及状态查询电切表
    List<Pbszcwj> findByEqIdandJcyqId(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //查询所有
    List<Pbszcwj> findAll();

    //根据检测仪器Id查询
    Pbszcwj findByPbszcwjId(@Param("pbszcwjId") Integer pbszcwjId);

    //修改审核人意见
    void updateShrJcjy(@Param("pbszcwjId") Integer pbszcwjId, @Param("shrJcjl") String shrJcjl, @Param("auditor") String auditor);
}
