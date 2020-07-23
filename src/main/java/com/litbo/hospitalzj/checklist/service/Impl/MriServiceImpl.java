package com.litbo.hospitalzj.checklist.service.Impl;

import com.litbo.hospitalzj.checklist.dao.GpddMapper;
import com.litbo.hospitalzj.checklist.domain.Gpdd;
import com.litbo.hospitalzj.checklist.service.GpddService;
import com.litbo.hospitalzj.zk.domian.GpddTemplate;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MriServiceImpl implements GpddService {
    @Autowired
    private GpddMapper gpddMapper;

    //查询模板值
    public GpddTemplate findTemplate(){
        return gpddMapper.findTemplate();
    }
    //修改模板值
    public void updateGpddTemplate(GpddTemplate gpddTemplate){
        gpddMapper.updateGpddTemplate(gpddTemplate);
    }
    //插入模板值
    public void insert(GpddTemplate gpddTemplate){
        gpddMapper.insert(gpddTemplate);
    }

    //保存
    public void save(Gpdd gpdd){
        BeanUtils.copyProperties(gpddMapper.findTemplate(), gpdd);
        gpddMapper.save(gpdd);
    }
    @Override
    public void updateGpdd(Gpdd gpdd) {
        BeanUtils.copyProperties(gpddMapper.findTemplate(), gpdd);
        gpddMapper.updateGpdd(gpdd);
    }

    @Override
    public Gpdd findGpdd(String eqId) {
        return gpddMapper.findGpdd(eqId);
    }
    //查询一条
    public Gpdd find(){
        return gpddMapper.find();
    }

    //根据设备Id,检测仪器Id以及状态最后一条记录
    public Gpdd findByEqIdandJcyqIdLast1(String eqId, String jcyqId){
        return gpddMapper.findByEqIdandJcyqIdLast1(eqId, jcyqId);
    }
    //根据设备Id,检测仪器Id以及状态查询
    public List<Gpdd> findByEqIdandJcyqId(String eqId, String jcyqId){
        return gpddMapper.findByEqIdandJcyqId(eqId, jcyqId);
    }
    //查询所有
    public List<Gpdd> findAll(){
        return gpddMapper.findAll();
    }
    public Gpdd findByGpddid(@Param("gpddid")Integer gpddid){
        return gpddMapper.findByGpddid(gpddid);
    }
    @Override
    public void updateShrJcjy(Integer gpddid, String shrJcjl, String auditor) {
        gpddMapper.updateShrJcjy(gpddid,shrJcjl,auditor,new Date());
    }
}
