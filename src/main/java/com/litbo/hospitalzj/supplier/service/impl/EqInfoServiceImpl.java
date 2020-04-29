package com.litbo.hospitalzj.supplier.service.impl;

import com.litbo.hospitalzj.quality.entity.EqPm;
import com.litbo.hospitalzj.quality.mapper.EqPmMapper;
import com.litbo.hospitalzj.quality.mapper.EqXeqMapper;
import com.litbo.hospitalzj.supplier.controller.ex.EqInfoIsNullException;
import com.litbo.hospitalzj.supplier.entity.EqInfo;
import com.litbo.hospitalzj.supplier.mapper.EqFjMapper;
import com.litbo.hospitalzj.supplier.mapper.EqFseqMapper;
import com.litbo.hospitalzj.supplier.mapper.EqInfoMapper;
import com.litbo.hospitalzj.supplier.service.EqFjService;
import com.litbo.hospitalzj.supplier.service.EqFseqService;
import com.litbo.hospitalzj.supplier.service.EqInfoService;
import com.litbo.hospitalzj.supplier.service.exception.InsertException;
import com.litbo.hospitalzj.supplier.vo.SelHtEqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EqInfoServiceImpl implements EqInfoService {
	@Autowired
	public EqInfoMapper eqInfoMapper;
	@Autowired
	public EqXeqMapper eqXeqMapper;
	@Autowired
	public EqPmMapper eqPmMapper;
	@Autowired
	public EqFjMapper eqFjMapper;
	@Autowired
	public EqFseqMapper eqFseqMapper;

	@Override
	public Integer InsertEqInfo(EqInfo eqInfo) {
		/*EqInfo data=eqInfoMapper.selectByName(eqInfo.getEqMc());
		if(data!=null){
			throw new InsertException("设备信息已存在");
		}*/
		eqInfoMapper.insertEqInfo(eqInfo);
		return eqInfo.getEqId();
	}

	public void InsertBatEqInfo(EqInfo eqInfo) {
		eqInfoMapper.InsertBatEqInfo(eqInfo);
	}

	public List<SelHtEqVo> selectGroupEqHtVo(Integer htIds) {
		List<SelHtEqVo> data=eqInfoMapper.selectGroupEqHtVo(htIds);
		if(data==null) {
			throw new EqInfoIsNullException("设备信息为空，需要请添加");
		}
		return data;
	}

	public List<SelHtEqVo> selectGroupEqHtVo2(Integer htIds) {
		List<SelHtEqVo> data=eqInfoMapper.selectGroupEqHtVo(htIds);
		//e.eq_mc, e.eq_xh
		for (SelHtEqVo suinfo : data) {
			List<SelHtEqVo> suinfos = eqInfoMapper.selectRq(suinfo.getEqMc(), suinfo.getEqXh(), htIds);
			StringBuffer bh = new StringBuffer();
			StringBuffer rq = new StringBuffer();
			int i = 1;
			for (SelHtEqVo selHtEqVo : suinfos) {
				if(i < suinfos.size()){
					bh.append(selHtEqVo.getEqScbh()).append(",");
					rq.append(selHtEqVo.getEqCcdate()).append(",");
				}else{
					bh.append(selHtEqVo.getEqScbh());
					rq.append(selHtEqVo.getEqCcdate());

				}
				i++;
			}
			suinfo.setEqScbh(bh.toString());
			suinfo.setEqCcdate(rq.toString());
			suinfo.setEqNum(String.valueOf(suinfos.size()));
		}
		return data;
	}

	@Override
	public void deleteBat(EqInfo eqInfo) {
		eqInfoMapper.deleteBat(eqInfo.getEqMc(), eqInfo.getEqXh(), eqInfo.getHtIds());
		eqFjMapper.deleteByEqId(eqInfo.getEqId());
		eqFseqMapper.deleteByEqId(eqInfo.getEqId());
	}

	public EqInfo selectGroup(Integer eqId) {
		EqInfo eqInfo = eqInfoMapper.selectByEqId(eqId);
		List<SelHtEqVo> suinfos = eqInfoMapper.selectRq(eqInfo.getEqMc(), eqInfo.getEqXh(), eqInfo.getHtIds());
		StringBuffer bh = new StringBuffer();
		StringBuffer rq = new StringBuffer();
		int i = 1;
		for (SelHtEqVo selHtEqVo : suinfos) {
			if(i < suinfos.size()){
				bh.append(selHtEqVo.getEqScbh()).append(",");
				rq.append(selHtEqVo.getEqCcdate()).append(",");
			}else{
				bh.append(selHtEqVo.getEqScbh());
				rq.append(selHtEqVo.getEqCcdate());
			}
			i++;
		}
		eqInfo.setEqScbh(bh.toString());
		eqInfo.setEqCcdate(rq.toString());
		eqInfo.setEqNum(String.valueOf(suinfos.size()));
		return eqInfo;
	}


	public void updateInfo(EqInfo eqInfo) {

		eqInfoMapper.updateInfo(eqInfo);
	}

	public List<EqInfo> selectEqInfo(Integer htIds) {
		List<EqInfo> data=eqInfoMapper.selectEqinfo(htIds);
		if(data==null) {
			throw new EqInfoIsNullException("设备信息为空，需要请添加");
		}
		return data;
	}
	@Override
	public List<SelHtEqVo> selectEqHtVo(Integer htIds) {
		List<SelHtEqVo> data=eqInfoMapper.selectEqHtVo(htIds);
		if(data==null) {
			throw new EqInfoIsNullException("设备信息为空，需要请添加");
		}
		return data;
	}

	@Override
	public List<EqInfo> selectByState() {
		return eqInfoMapper.selectByState();
	}

	@Override
	public void delete(Integer eqId) {
		 eqInfoMapper.delete(eqId);
	}

	@Override
	public EqInfo selectByEqId(Integer eqId) {
		return eqInfoMapper.selectByEqId(eqId);
	}

	@Override
	public List<EqInfo> newEqinfo() {
		List<EqInfo> data=eqInfoMapper.newEqInfo();
		List<EqInfo> newE=new ArrayList();
		for(EqInfo eqInfo:data){
			int isNull=eqXeqMapper.findByEqName(eqInfo.getEqPmId());
			if(isNull==1){
				newE.add(eqInfo);
			}
		}
		return newE;
	}

	@Override
	public List<EqInfo> eqInfoYfp(Integer eqState) {
		return eqInfoMapper.eqInfoYfp(eqState);
	}

	@Override
	public List<EqInfo> eqInfoWfp(Integer eqState) {
		List<EqInfo> data=eqInfoMapper.eqInfoWfp(eqState);
		List<EqInfo> newE=new ArrayList();
		for(EqInfo eqInfo:data){
			EqPm eqPm=eqPmMapper.findById(Integer.valueOf(eqInfo.getEqPmId()));
			int isNull=eqXeqMapper.findByEqName(eqPm.getEqPmName());
			if(isNull==1){
				newE.add(eqInfo);
			}
		}
		return newE;
	}

	@Override
	public Integer countWfp(Integer eqState) {
		return eqInfoMapper.countWfp(eqState);
	}

	@Override
	public List<EqInfo> findByUserIdEqInfo(Integer eqState, String userId) {
		return eqInfoMapper.findByUserIdEqInfo(eqState,userId);
	}

	@Override
	public Integer findByUserIdEqInfoCount(Integer eqState, String userId) {
		return eqInfoMapper.findByUserIdEqInfoCount(eqState, userId);
	}

	@Override
	public void updateEqQk(Integer eqId, String eqQk) {
		eqInfoMapper.updateEqQk(eqId,eqQk);
	}

	@Override
	public List<EqInfo> findByEqQk(String eqQk) {
		return eqInfoMapper.findByEqQk(eqQk);
	}

	@Override
	public Integer lastId() {
		return eqInfoMapper.lastId();
	}




	@Override
	public Integer findHtId(Integer eqId) {
		Integer data=eqInfoMapper.selectHtId(eqId);
		if(data==null) {
			throw new EqInfoIsNullException("设备信息为空，需要请添加");
		}
		return data;
	}
	@Override
	public List<EqInfo> findWXEqInfo() {
		return eqInfoMapper.findWXEqInfo();
	}

}
