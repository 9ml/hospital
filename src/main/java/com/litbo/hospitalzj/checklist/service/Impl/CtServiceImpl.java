package com.litbo.hospitalzj.checklist.service.Impl;

import com.litbo.hospitalzj.checklist.domain.Ct;
import com.litbo.hospitalzj.checklist.domain.CtTemplate;
import com.litbo.hospitalzj.checklist.domain.Ct;
import com.litbo.hospitalzj.checklist.service.CtService;
import com.litbo.hospitalzj.checklist.dao.CtMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CtServiceImpl implements CtService {
    @Autowired
    private CtMapper ctMapper;

    //查询模板值
    public CtTemplate findTemplate(){
        return ctMapper.findTemplate();
    }
    //修改模板值
    public void updateCtTemplate(CtTemplate ctTemplate){
        ctMapper.updateCtTemplate(ctTemplate);
    }
    //插入模板值
    public void insert(CtTemplate ctTemplate){
        ctMapper.insert(ctTemplate);
    }

    //保存
    public void save(Ct ct){
        BeanUtils.copyProperties(ctMapper.findTemplate(), ct);
        ctMapper.save(ct);
    }
    @Override
    public void updateCt(Ct ct) {
        BeanUtils.copyProperties(ctMapper.findTemplate(), ct);
        ctMapper.updateCt(ct);
    }

    @Override
    public Ct findCt(String eqId) {
        return ctMapper.findCt(eqId);
    }
    //查询一条
    public Ct find(){
        return ctMapper.find();
    }

    //根据设备Id,检测仪器Id以及状态最后一条记录
    public Ct findByEqIdandJcyqIdLast1(String eqId, String jcyqId){
        return ctMapper.findByEqIdandJcyqIdLast1(eqId, jcyqId);
    }
    //根据设备Id,检测仪器Id以及状态查询
    public List<Ct> findByEqIdandJcyqId(String eqId, String jcyqId){
        return ctMapper.findByEqIdandJcyqId(eqId, jcyqId);
    }
    //查询所有
    public List<Ct> findAll(){
        return ctMapper.findAll();
    }
    public Ct findByCtid(@Param("ctId")Integer ctId){
        return ctMapper.findByCtid(ctId);
    }
    @Override
    public void updateShrJcjy(Integer ctId, String shrJcjl, String auditor) {
        ctMapper.updateShrJcjy(ctId,shrJcjl,auditor,new Date());
    }
}
