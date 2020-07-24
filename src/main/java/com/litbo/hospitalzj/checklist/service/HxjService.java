package com.litbo.hospitalzj.checklist.service;

import com.litbo.hospitalzj.checklist.domain.Hxj;
import com.litbo.hospitalzj.checklist.domain.HxjTemplate;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service("hxjService")
@RequestMapping("/hxj")
public interface HxjService {
    //查询模板值
    HxjTemplate findTemplate(Integer type);

    //修改模板值
    void updateHxjTemplate(HxjTemplate hxjTemplate);

    //插入模板值
    void insertHxjTemplate(HxjTemplate hxjTemplate);

    //保存
    void save(Hxj hxj);

    //修改
    void updateHxj(Hxj hxj);

    //根据电气检测设备id查询设备检测表
    public Hxj findHxj(String eqId);

    //根据设备Id,检测仪器Id以及状态查询电器表查询最后一条记录
    Hxj findByEqIdandJcyqIdLast1(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //根据设备Id,检测仪器Id以及状态查询电器表
    List<Hxj> findByEqIdandJcyqId(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //查询所有
    List<Hxj> findAll(Integer type);

    /**
     * 根据iD状态查询
     */
    Hxj findByHxjId(@Param("hxjId") Integer hxjId);

    //修改审核人意见
    void updateShrJcjy(@Param("hxjId") Integer hxjId, @Param("shrJcjl") String shrJcjl, @Param("auditor") String auditor);

}
