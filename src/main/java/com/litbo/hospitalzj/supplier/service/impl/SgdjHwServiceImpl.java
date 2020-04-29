package com.litbo.hospitalzj.supplier.service.impl;

import com.litbo.hospitalzj.supplier.entity.HtInfo;
import com.litbo.hospitalzj.supplier.entity.SgdjHw;
import com.litbo.hospitalzj.supplier.mapper.HtInfoMapper;
import com.litbo.hospitalzj.supplier.mapper.SgdjHwMapper;
import com.litbo.hospitalzj.supplier.service.SgdjHwService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SgdjHwServiceImpl implements SgdjHwService {
    @Autowired
    private SgdjHwMapper SgdjHwMapper;
    @Autowired
    private HtInfoMapper htInfoMapper;

    @Override
    public SgdjHw selectSgdjHw(Integer htIds) {
        SgdjHw data = SgdjHwMapper.selectSgdjHw(htIds);
        return data;
    }

    @Override
    @Transactional
    public Integer InsertSgdjHw(SgdjHw sgdjhw) {
        SgdjHw sgdjHw = SgdjHwMapper.selectSgdjHw(sgdjhw.getHtIds());
        if(sgdjHw == null){
            SgdjHwMapper.insertSgdjHw(sgdjhw);
        }else{
            SgdjHwMapper.updateInfo(sgdjhw);
        }
        HtInfo htInfo = htInfoMapper.findByHtId(sgdjhw.getHtIds());
        if("无".equals(htInfo.getHtGzspd())){
            return 2;
        }
        return 1;
    }

    @Override
    public Integer updateInfo(SgdjHw sgdjhw) {
        System.out.println(sgdjhw);
        return SgdjHwMapper.updateInfo(sgdjhw);
    }

    @Transactional
    @Override
    public int updateURL(Integer htIds, String path) {
        if (SgdjHwMapper.selectSgdjHwByHtIds(htIds) == null) {
            SgdjHw sgdjHw = new SgdjHw();
            sgdjHw.setHtIds(htIds);
            SgdjHwMapper.insertSgdjHw(sgdjHw);
        }
        return SgdjHwMapper.updateURL(htIds, path + " ");
    }

    @Override
    public String[] showImages(Integer htIds) {
        String djhwUrl = SgdjHwMapper.showImages(htIds);
        if (djhwUrl != null)
            return djhwUrl.split(" ");
        else
            return null;
    }

    @Override
    public int count(String htState) {
        return SgdjHwMapper.count(htState);
    }
}
