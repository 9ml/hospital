package com.litbo.hospitalzj.checklist.service.Impl;

import com.litbo.hospitalzj.checklist.dao.HxjMapper;
import com.litbo.hospitalzj.checklist.domain.Hxj;
import com.litbo.hospitalzj.checklist.domain.HxjTemplate;
import com.litbo.hospitalzj.checklist.service.HxjService;
import io.swagger.models.auth.In;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HxjServiceImpl implements HxjService {
    @Autowired
    private HxjMapper hxjMapper;

    //查询模板值
    @Override
    public HxjTemplate findTemplate(Integer type){
        return hxjMapper.findTemplate(type);
    }
    //修改模板值
    @Override
    public void updateHxjTemplate(HxjTemplate hxjTemplate) {
        hxjMapper.updateHxjTemplate(hxjTemplate);
    }
    //插入模板值
    @Override
    public void insertHxjTemplate(HxjTemplate hxjTemplate) {
        hxjMapper.insertHxjTemplate(hxjTemplate);;
    }

    //查询所有呼吸机检测数据
    public List<Hxj> findAll(Integer type){
        return hxjMapper.findAll( type);
    }

    @Override
    public Hxj findByHxjId(Integer hxjid) {
        return hxjMapper.findByHxjId(hxjid);
    }

    @Override
    public void updateShrJcjy(Integer hxjid, String shrJcjl, String auditor) {
        hxjMapper.updateShrJcjy(hxjid, shrJcjl, auditor, new Date());
    }

    //保存呼吸机检测数据
    public void save(Hxj hxj){
        BeanUtils.copyProperties(hxjMapper.findTemplate(hxj.getType()), hxj);
        hxjMapper.save(hxj);
    }

    @Override
    public void updateHxj(Hxj hxj) {
        BeanUtils.copyProperties(hxjMapper.findTemplate(hxj.getType()), hxj);
        hxjMapper.updateHxj(hxj);
    }

    @Override
    public Hxj findHxj(String eqId) {
        return hxjMapper.findHxj(eqId);
    }

    @Override
    public Hxj findByEqIdandJcyqIdLast1(String eqId, String jcyqId) {
        return hxjMapper.findByEqIdandJcyqIdLast1(eqId, jcyqId);
    }

    @Override
    public List<Hxj> findByEqIdandJcyqId(String eqId, String jcyqId) {
        return hxjMapper.findByEqIdandJcyqId(eqId, jcyqId);
    }
}
