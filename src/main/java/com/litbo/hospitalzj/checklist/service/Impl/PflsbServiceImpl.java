package com.litbo.hospitalzj.checklist.service.Impl;

import com.litbo.hospitalzj.checklist.dao.PflsbMapper;
import com.litbo.hospitalzj.checklist.domain.Pflsb;
import com.litbo.hospitalzj.checklist.domain.PflsbTemplate;
import com.litbo.hospitalzj.checklist.service.PflsbService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PflsbServiceImpl implements PflsbService {
    @Autowired
    private PflsbMapper pflsbMapper;

    //查询模板值
    public PflsbTemplate findTemplate(){
        return pflsbMapper.findTemplate();
    }
    //修改模板值
    public void updatePflsbTemplate(PflsbTemplate pflsbTemplate){
        pflsbMapper.updatePflsbTemplate(pflsbTemplate);
    }
    //插入模板值
    public void insert(PflsbTemplate pflsbTemplate){
        pflsbMapper.insert(pflsbTemplate);
    }

    //保存
    public void save(Pflsb pflsb){
        BeanUtils.copyProperties(pflsbMapper.findTemplate(), pflsb);
        pflsbMapper.save(pflsb);
    }
    @Override
    public void updatePflsb(Pflsb pflsb) {
        BeanUtils.copyProperties(pflsbMapper.findTemplate(), pflsb);
        pflsbMapper.updatePflsb(pflsb);
    }

    @Override
    public Pflsb findPflsb(String eqId) {
        return pflsbMapper.findPflsb(eqId);
    }
    //查询一条
    public Pflsb find(){
        return pflsbMapper.find();
    }

    //根据设备Id,检测仪器Id以及状态最后一条记录
    public Pflsb findByEqIdandJcyqIdLast1(String eqId, String jcyqId){
        return pflsbMapper.findByEqIdandJcyqIdLast1(eqId, jcyqId);
    }
    //根据设备Id,检测仪器Id以及状态查询
    public List<Pflsb> findByEqIdandJcyqId(String eqId, String jcyqId){
        return pflsbMapper.findByEqIdandJcyqId(eqId, jcyqId);
    }
    //查询所有
    public List<Pflsb> findAll(){
        return pflsbMapper.findAll();
    }
    public Pflsb findByPflsbId(@Param("pflsbId")Integer pflsbId){
        return pflsbMapper.findByPflsbId(pflsbId);
    }
    @Override
    public void updateShrJcjy(Integer pflsbId, String shrJcjl, String auditor) {
        pflsbMapper.updateShrJcjy(pflsbId,shrJcjl,auditor,new Date());
    }
}
