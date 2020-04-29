package com.litbo.hospitalzj.supplier.service.impl;

import com.litbo.hospitalzj.supplier.controller.ex.EqFjIsNullException;
import com.litbo.hospitalzj.supplier.entity.EqFj;
import com.litbo.hospitalzj.supplier.mapper.EqFjMapper;
import com.litbo.hospitalzj.supplier.service.EqFjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EqFjServiceImpl implements EqFjService{
	@Autowired
	private EqFjMapper eqFjMapper;

	public EqFj insertEqFj(EqFj eqfj) {
		eqFjMapper.insertEqFj(eqfj);
		return eqfj;
	}

	public void updateInfo(EqFj eqfj) {
		eqFjMapper.updataInfo(eqfj);
	}

	public List<EqFj> selectInfo(Integer eqIds) {
		List<EqFj> data=eqFjMapper.selectEqFj(eqIds);
		if (data==null) {
			throw new EqFjIsNullException("设备附件信息不存在，需要请添加");
		}
		return data;
	}

	public List<EqFj> selectEqFjGroup(Integer eqIds) {
		List<EqFj> data=eqFjMapper.selectEqFjGroup(eqIds);
		for (EqFj eqFj : data) {
			List<EqFj> eqFjs = eqFjMapper.selectEqFjByRq(eqFj.getEqFjmc(), eqFj.getEqFjxh(), eqIds);
			StringBuffer bh = new StringBuffer();
			StringBuffer rq = new StringBuffer();
			int i = 1;
			for (EqFj fj : eqFjs) {
				if(i < eqFjs.size()){
					bh.append(fj.getEqFjccbh()).append(",");
					rq.append(fj.getEqFjccrq()).append(",");
				}else{
					bh.append(fj.getEqFjccbh());
					rq.append(fj.getEqFjccrq());
				}
				i++;
			}
			eqFj.setEqFjccbh(bh.toString());
			eqFj.setEqFjccrq(rq.toString());
			eqFj.setEqFjsl(String.valueOf(eqFjs.size()));
		}
		if (data==null) {
			throw new EqFjIsNullException("设备附件信息不存在，需要请添加");
		}
		return data;
	}

	@Override
	public Integer delete(Integer eqFjid) {
		return eqFjMapper.delete(eqFjid);
	}

	public EqFj selectById(Integer eqFjId) {
		return eqFjMapper.selectById(eqFjId);
	}

	@Override
	public void deleteBat(EqFj eqFj) {
		eqFjMapper.deleteBat(eqFj.getEqIds(), eqFj.getEqFjmc(), eqFj.getEqFjxh());
	}

	@Override
	public EqFj selectInfoOneGroup(EqFj eqFj) {
		List<EqFj> eqFjs = eqFjMapper.selectEqFjByRq(eqFj.getEqFjmc(), eqFj.getEqFjxh(), eqFj.getEqIds());
		StringBuffer bh = new StringBuffer();
		StringBuffer rq = new StringBuffer();
		int i = 1;
		for (EqFj fj : eqFjs) {
			if(i < eqFjs.size()){
				bh.append(fj.getEqFjccbh()).append(",");
				rq.append(fj.getEqFjccrq()).append(",");
			}else{
				bh.append(fj.getEqFjccbh());
				rq.append(fj.getEqFjccrq());
			}
			i++;
		}
		eqFj.setEqFjccbh(bh.toString());
		eqFj.setEqFjccrq(rq.toString());
		eqFj.setEqFjsl(String.valueOf(eqFjs.size()));
		return eqFj;
	}

	@Override
	public List<EqFj> selectByMcAndXh(Integer eqIds, String eqFjmc, String eqFjxh) {
		return eqFjMapper.selectBxyMcAndXh(eqIds, eqFjmc, eqFjxh);
	}

	@Override
	public void update(EqFj eqFj) {
		eqFjMapper.updata(eqFj);
	}


}
