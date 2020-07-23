package com.litbo.hospitalzj.checklist.service.Impl;

import com.litbo.hospitalzj.checklist.dao.ZsbMapper;
import com.litbo.hospitalzj.checklist.domain.Zsb;
import com.litbo.hospitalzj.checklist.domain.ZsbTemplate;
import com.litbo.hospitalzj.checklist.service.ZsbService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ZsbServiceImpl implements ZsbService {
    @Autowired
    private ZsbMapper zsbMapper;

    //查询模板值
    public ZsbTemplate findTemplate(){
        return zsbMapper.findTemplate();
    }
    //修改模板值
    public void updateZsbTemplate(ZsbTemplate zsbTemplate){
        zsbMapper.updateZsbTemplate(zsbTemplate);
    }
    //插入模板值
    public void insert(ZsbTemplate zsbTemplate){
        zsbMapper.insert(zsbTemplate);
    }

    //保存
    public void save(Zsb zsb){
        BeanUtils.copyProperties(zsbMapper.findTemplate(), zsb);
        zsbMapper.save(zsb);
    }
    @Override
    public void updateZsb(Zsb zsb) {
        BeanUtils.copyProperties(zsbMapper.findTemplate(), zsb);
        zsbMapper.updateZsb(zsb);
    }

    @Override
    public Zsb findZsb(String eqId) {
        return zsbMapper.findZsb(eqId);
    }
    //查询一条
    public Zsb find(){
        return zsbMapper.find();
    }

    //根据设备Id,检测仪器Id以及状态最后一条记录
    public Zsb findByEqIdandJcyqIdLast1(String eqId, String jcyqId){
        return zsbMapper.findByEqIdandJcyqIdLast1(eqId, jcyqId);
    }
    //根据设备Id,检测仪器Id以及状态查询
    public List<Zsb> findByEqIdandJcyqId(String eqId, String jcyqId){
        return zsbMapper.findByEqIdandJcyqId(eqId, jcyqId);
    }
    //查询所有
    public List<Zsb> findAll(){
        return zsbMapper.findAll();
    }
    public Zsb findByZsbId(@Param("zsbId")Integer zsbId){
        return zsbMapper.findByZsbId(zsbId);
    }
    @Override
    public void updateShrJcjy(Integer zsbId, String shrJcjl, String auditor) {
        zsbMapper.updateShrJcjy(zsbId,shrJcjl,auditor,new Date());
    }
}
