package com.litbo.hospitalzj.checklist.service.Impl;

import com.litbo.hospitalzj.checklist.dao.YpjMapper;
import com.litbo.hospitalzj.checklist.domain.Ypj;
import com.litbo.hospitalzj.checklist.domain.YpjTemplate;
import com.litbo.hospitalzj.checklist.service.YpjService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class YpjServiceImpl implements YpjService {
    @Autowired
    private YpjMapper ypjMapper;

    //查询模板值
    public YpjTemplate findTemplate(){
        return ypjMapper.findTemplate();
    }
    //修改模板值
    public void updateYpjTemplate(YpjTemplate ypjTemplate){
        ypjMapper.updateYpjTemplate(ypjTemplate);
    }
    //插入模板值
    public void insert(YpjTemplate ypjTemplate){
        ypjMapper.insert(ypjTemplate);
    }

    //保存
    public void save(Ypj ypj){
        BeanUtils.copyProperties(ypjMapper.findTemplate(), ypj);
        ypjMapper.save(ypj);
    }
    @Override
    public void updateYpj(Ypj ypj) {
        BeanUtils.copyProperties(ypjMapper.findTemplate(), ypj);
        ypjMapper.updateYpj(ypj);
    }

    @Override
    public Ypj findYpj(String eqId) {
        return ypjMapper.findYpj(eqId);
    }
    //查询一条
    public Ypj find(){
        return ypjMapper.find();
    }

    //根据设备Id,检测仪器Id以及状态最后一条记录
    public Ypj findByEqIdandJcyqIdLast1(String eqId, String jcyqId){
        return ypjMapper.findByEqIdandJcyqIdLast1(eqId, jcyqId);
    }
    //根据设备Id,检测仪器Id以及状态查询
    public List<Ypj> findByEqIdandJcyqId(String eqId, String jcyqId){
        return ypjMapper.findByEqIdandJcyqId(eqId, jcyqId);
    }
    //查询所有
    public List<Ypj> findAll(){
        return ypjMapper.findAll();
    }
    public Ypj findByYpjId(@Param("ypjId")Integer ypjId){
        return ypjMapper.findByYpjId(ypjId);
    }
    @Override
    public void updateShrJcjy(Integer ypjId, String shrJcjl, String auditor) {
        ypjMapper.updateShrJcjy(ypjId,shrJcjl,auditor,new Date());
    }
}
