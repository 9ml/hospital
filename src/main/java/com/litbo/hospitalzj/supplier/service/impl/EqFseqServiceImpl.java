package com.litbo.hospitalzj.supplier.service.impl;

import com.litbo.hospitalzj.supplier.controller.ex.EqFjIsNullException;
import com.litbo.hospitalzj.supplier.entity.EqFj;
import com.litbo.hospitalzj.supplier.entity.EqFseq;
import com.litbo.hospitalzj.supplier.mapper.EqFseqMapper;
import com.litbo.hospitalzj.supplier.service.EqFseqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EqFseqServiceImpl implements EqFseqService {
	@Autowired
	private EqFseqMapper eqFseqMapper;


	@Override
	public void insertEqFseq(EqFseq eqFseq) {
		eqFseqMapper.insertEqFseq(eqFseq);
	}

	@Override
	public List<EqFseq> selectEqFseq(Integer eqIds) {
		return eqFseqMapper.selectEqFseq(eqIds);
	}

	@Override
	public void updateInfo(EqFseq eqFseq) {
		eqFseqMapper.updateInfo(eqFseq);
	}

	@Override
	public void delete(Integer eqFsid) {
		eqFseqMapper.delete(eqFsid);
	}

	@Override
	public EqFseq selectById(Integer eqFsid) {
		return eqFseqMapper.selectById(eqFsid);
	}

	public List<EqFseq> selectEqFseqGroup(Integer eqIds) {
		List<EqFseq> data=eqFseqMapper.selectEqFjGroup(eqIds);
		for (EqFseq eqFj : data) {
			List<EqFseq> eqFjs = eqFseqMapper.selectEqFjByRq(eqFj.getEqMc(), eqFj.getEqXh(), String.valueOf(eqIds));
			StringBuffer bh = new StringBuffer();
			StringBuffer rq = new StringBuffer();
			int i = 1;
			for (EqFseq fj : eqFjs) {
				if(i < eqFjs.size()){
					bh.append(fj.getEqScbh()).append(",");
					rq.append(fj.getEqCcdate()).append(",");
				}else{
					bh.append(fj.getEqScbh());
					rq.append(fj.getEqCcdate());
				}
				i++;
			}
			eqFj.setEqScbh(bh.toString());
			eqFj.setEqCcdate(rq.toString());
			eqFj.setEqNum(String.valueOf(eqFjs.size()));
		}
		if (data==null) {
			throw new EqFjIsNullException("设备附件信息不存在，需要请添加");
		}
		return data;
	}

	public void deleteBat(EqFseq eqFseq) {
		eqFseqMapper.deleteBat(eqFseq.getEqIds(), eqFseq.getEqMc(), eqFseq.getEqXh());
	}

	public EqFseq selectById2(Integer eqFsid) {
		EqFseq eqFj = eqFseqMapper.selectById(eqFsid);
		List<EqFseq> eqFjs = eqFseqMapper.selectEqFjByRq(eqFj.getEqMc(), eqFj.getEqXh(), eqFj.getEqIds());
		StringBuffer bh = new StringBuffer();
		StringBuffer rq = new StringBuffer();
		int i = 1;
		for (EqFseq fj : eqFjs) {
			if(i < eqFjs.size()){
				bh.append(fj.getEqScbh()).append(",");
				rq.append(fj.getEqCcdate()).append(",");
			}else{
				bh.append(fj.getEqScbh());
				rq.append(fj.getEqCcdate());
			}
			i++;
		}
		eqFj.setEqScbh(bh.toString());
		eqFj.setEqCcdate(rq.toString());
		eqFj.setEqNum(String.valueOf(eqFjs.size()));

		return eqFj;
	}

	@Override
	public void update(EqFseq eqFseq) {
		eqFseqMapper.update(eqFseq);
	}

	@Override
	public List<EqFseq> selectByMcAndXh(Integer eqIds, String eqMc, String eqXh) {
		return eqFseqMapper.selectByMcAndXh(eqIds, eqMc, eqXh);
	}
}
