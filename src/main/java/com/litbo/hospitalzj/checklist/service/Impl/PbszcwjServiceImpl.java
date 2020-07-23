package com.litbo.hospitalzj.checklist.service.Impl;

import com.litbo.hospitalzj.checklist.dao.PbszcwjMapper;
import com.litbo.hospitalzj.checklist.domain.Pbszcwj;
import com.litbo.hospitalzj.checklist.domain.PbszcwjTemplate;
import com.litbo.hospitalzj.checklist.service.PbszcwjService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PbszcwjServiceImpl implements PbszcwjService {
    @Autowired
    private PbszcwjMapper pbszcwjMapper;

    //查询模板值
    public PbszcwjTemplate findTemplate(){
        return pbszcwjMapper.findTemplate();
    }
    //修改模板值
    public void updatePbszcwjTemplate(PbszcwjTemplate pbszcwjTemplate){
        pbszcwjMapper.updatePbszcwjTemplate(pbszcwjTemplate);
    }
    //插入模板值
    public void insert(PbszcwjTemplate pbszcwjTemplate){
        pbszcwjMapper.insert(pbszcwjTemplate);
    }

    //保存
    public void save(Pbszcwj pbszcwj){
        BeanUtils.copyProperties(pbszcwjMapper.findTemplate(), pbszcwj);
        pbszcwjMapper.save(pbszcwj);
    }
    @Override
    public void updatePbszcwj(Pbszcwj pbszcwj) {
        BeanUtils.copyProperties(pbszcwjMapper.findTemplate(), pbszcwj);
        pbszcwjMapper.updatePbszcwj(pbszcwj);
    }

    @Override
    public Pbszcwj findPbszcwj(String eqId) {
        return pbszcwjMapper.findPbszcwj(eqId);
    }
    //查询一条
    public Pbszcwj find(){
        return pbszcwjMapper.find();
    }

    //根据设备Id,检测仪器Id以及状态最后一条记录
    public Pbszcwj findByEqIdandJcyqIdLast1(String eqId, String jcyqId){
        return pbszcwjMapper.findByEqIdandJcyqIdLast1(eqId, jcyqId);
    }
    //根据设备Id,检测仪器Id以及状态查询
    public List<Pbszcwj> findByEqIdandJcyqId(String eqId, String jcyqId){
        return pbszcwjMapper.findByEqIdandJcyqId(eqId, jcyqId);
    }
    //查询所有
    public List<Pbszcwj> findAll(){
        return pbszcwjMapper.findAll();
    }
    public Pbszcwj findByPbszcwjId(@Param("pbszcwjId")Integer pbszcwjId){
        return pbszcwjMapper.findByPbszcwjId(pbszcwjId);
    }
    @Override
    public void updateShrJcjy(Integer pbszcwjId, String shrJcjl, String auditor) {
        pbszcwjMapper.updateShrJcjy(pbszcwjId,shrJcjl,auditor,new Date());
    }
}
