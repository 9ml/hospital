package com.litbo.hospitalzj.checklist.service.Impl;

import com.litbo.hospitalzj.checklist.dao.MriMapper;
import com.litbo.hospitalzj.checklist.domain.Mri;
import com.litbo.hospitalzj.checklist.domain.MriTemplate;
import com.litbo.hospitalzj.checklist.service.MriService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MriServiceImpl implements MriService {
    @Autowired
    private MriMapper mriMapper;

    //查询模板值
    public MriTemplate findTemplate(){
        return mriMapper.findTemplate();
    }
    //修改模板值
    public void updateMriTemplate(MriTemplate mriTemplate){
        mriMapper.updateMriTemplate(mriTemplate);
    }
    //插入模板值
    public void insert(MriTemplate mriTemplate){
        mriMapper.insert(mriTemplate);
    }

    //保存
    public void save(Mri mri){
        BeanUtils.copyProperties(mriMapper.findTemplate(), mri);
        mriMapper.save(mri);
    }
    @Override
    public void updateMri(Mri mri) {
        BeanUtils.copyProperties(mriMapper.findTemplate(), mri);
        mriMapper.updateMri(mri);
    }

    @Override
    public Mri findMri(String eqId) {
        return mriMapper.findMri(eqId);
    }
    //查询一条
    public Mri find(){
        return mriMapper.find();
    }

    //根据设备Id,检测仪器Id以及状态最后一条记录
    public Mri findByEqIdandJcyqIdLast1(String eqId, String jcyqId){
        return mriMapper.findByEqIdandJcyqIdLast1(eqId, jcyqId);
    }
    //根据设备Id,检测仪器Id以及状态查询
    public List<Mri> findByEqIdandJcyqId(String eqId, String jcyqId){
        return mriMapper.findByEqIdandJcyqId(eqId, jcyqId);
    }
    //查询所有
    public List<Mri> findAll(){
        return mriMapper.findAll();
    }
    public Mri findByMriId(@Param("mriId")Integer mriId){
        return mriMapper.findByMriId(mriId);
    }
    @Override
    public void updateShrJcjy(Integer mriId, String shrJcjl, String auditor) {
        mriMapper.updateShrJcjy(mriId,shrJcjl,auditor,new Date());
    }
}
