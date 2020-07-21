package com.litbo.hospitalzj.checklist.service.Impl;

import com.litbo.hospitalzj.checklist.dao.YdscxbMapper;
import com.litbo.hospitalzj.checklist.domain.Ydscxb;
import com.litbo.hospitalzj.checklist.domain.YdscxbTemplate;
import com.litbo.hospitalzj.checklist.service.YdscxbService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class YdscxbServiceImpl implements YdscxbService {
    @Autowired
    private YdscxbMapper ydscxbMapper;

    //查询模板值
    public YdscxbTemplate findTemplate(){
        return ydscxbMapper.findTemplate();
    }
    //修改模板值
    public void updateYdscxbTemplate(YdscxbTemplate ydscxbTemplate){
        ydscxbMapper.updateYdscxbTemplate(ydscxbTemplate);
    }
    //插入模板值
    public void insert(YdscxbTemplate ydscxbTemplate){
        ydscxbMapper.insert(ydscxbTemplate);
    }

    //保存
    public void save(Ydscxb ydscxb){
        BeanUtils.copyProperties(ydscxbMapper.findTemplate(), ydscxb);
        ydscxbMapper.save(ydscxb);
    }
    @Override
    public void updateYdscxb(Ydscxb ydscxb) {
        BeanUtils.copyProperties(ydscxbMapper.findTemplate(), ydscxb);
        ydscxbMapper.updateYdscxb(ydscxb);
    }

    @Override
    public Ydscxb findYdscxb(String eqId) {
        return ydscxbMapper.findYdscxb(eqId);
    }
    //查询一条
    public Ydscxb find(){
        return ydscxbMapper.find();
    }

    //根据设备Id,检测仪器Id以及状态最后一条记录
    public Ydscxb findByEqIdandJcyqIdLast1(String eqId, String jcyqId){
        return ydscxbMapper.findByEqIdandJcyqIdLast1(eqId, jcyqId);
    }
    //根据设备Id,检测仪器Id以及状态查询
    public List<Ydscxb> findByEqIdandJcyqId(String eqId, String jcyqId){
        return ydscxbMapper.findByEqIdandJcyqId(eqId, jcyqId);
    }
    //查询所有
    public List<Ydscxb> findAll(){
        return ydscxbMapper.findAll();
    }

    @Override
    public Ydscxb findByYdId(Integer ydId) {
        return ydscxbMapper.findByydId(ydId);
    }

    @Override
    public void updateShrJcjy(Integer ydId, String shrJcjl, String auditor) {
        ydscxbMapper.updateShrJcjy(ydId,shrJcjl,auditor,new Date());
    }
}
