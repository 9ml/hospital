package com.litbo.hospitalzj.checklist.service.Impl;

import com.litbo.hospitalzj.checklist.dao.SybMapper;
import com.litbo.hospitalzj.checklist.domain.Syb;
import com.litbo.hospitalzj.checklist.domain.SybTemplate;
import com.litbo.hospitalzj.checklist.service.SybService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SybServiceImpl implements SybService {
    @Autowired
    private SybMapper sybMapper;

    //查询模板值
    public SybTemplate findTemplate(){
        return sybMapper.findTemplate();
    }
    //修改模板值
    public void updateSybTemplate(SybTemplate sybTemplate){
        sybMapper.updateSybTemplate(sybTemplate);
    }
    //插入模板值
    public void insert(SybTemplate sybTemplate){
        sybMapper.insert(sybTemplate);
    }

    //保存
    public void save(Syb syb){
        BeanUtils.copyProperties(sybMapper.findTemplate(), syb);
        sybMapper.save(syb);
    }
    @Override
    public void updateSyb(Syb syb) {
        BeanUtils.copyProperties(sybMapper.findTemplate(), syb);
        sybMapper.updateSyb(syb);
    }

    @Override
    public Syb findSyb(String eqId) {
        return sybMapper.findSyb(eqId);
    }
    //查询一条
    public Syb find(){
        return sybMapper.find();
    }

    //根据设备Id,检测仪器Id以及状态最后一条记录
    public Syb findByEqIdandJcyqIdLast1(String eqId, String jcyqId){
        return sybMapper.findByEqIdandJcyqIdLast1(eqId, jcyqId);
    }
    //根据设备Id,检测仪器Id以及状态查询
    public List<Syb> findByEqIdandJcyqId(String eqId, String jcyqId){
        return sybMapper.findByEqIdandJcyqId(eqId, jcyqId);
    }
    //查询所有
    public List<Syb> findAll(){
        return sybMapper.findAll();
    }
    public Syb findBySybId(@Param("sybId")Integer sybId){
        return sybMapper.findBySybId(sybId);
    }
    @Override
    public void updateShrJcjy(Integer sybId, String shrJcjl, String auditor) {
        sybMapper.updateShrJcjy(sybId,shrJcjl,auditor,new Date());
    }
}
