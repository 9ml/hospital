package com.litbo.hospitalzj.zk.service.impl;

import com.litbo.hospitalzj.zk.domian.Yq;
import com.litbo.hospitalzj.zk.domian.YqEq;
import com.litbo.hospitalzj.zk.mapper.YqEqMapper;
import com.litbo.hospitalzj.zk.service.YqEqService;
import com.litbo.hospitalzj.zk.vo.YqEqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YqEqServiceImpl implements YqEqService{

	@Autowired
	YqEqMapper yqEqMapper;

	@Override
	public List<Yq> selectOtherAndJcshcg(String eqId) {
		return yqEqMapper.selectOtherAndJcshcg(eqId);
	}

	@Override
	public List<Yq> selectDqjcAndJcshcg(String eqId) {
		return yqEqMapper.selectDqjcAndJcshcg(eqId);
	}

	@Override
	public List<Yq> selectOtherAndJcBtg(String eqId) {
		return yqEqMapper.selectOtherAndJcBtg(eqId);
	}

	@Override
	public List<Yq> selectDqjcAndJcBtg(String eqId) {
		return yqEqMapper.selectDqjcAndJcBtg(eqId);
	}

	@Override
	public List<Yq> selectOtherAndDsc(String eqId) {
		return yqEqMapper.selectOtherAndDsc(eqId);
	}

	@Override
	public List<Yq> selectDqjcAndDsc(String eqId) {
		return yqEqMapper.selectDqjcAndDsc(eqId);
	}

	@Override
	public int insertBatch(String eqId, String jcyqId) {
		YqEq yqEq=new YqEq();
		yqEq.setJcyqId(jcyqId);
		yqEq.setEqId(eqId);
		yqEq.setState(0);
		yqEqMapper.delete(jcyqId, eqId);
		yqEqMapper.insert(yqEq);
		return yqEq.getId();
	}
	@Override
	public void deleteBatch(String jcyqId, String eqId) {
			yqEqMapper.delete(jcyqId,eqId);
	}

	@Override
	public YqEq selectEqId(String jcyqId) {
		return yqEqMapper.selectEqId(jcyqId);
	}

	@Override
	public void updateState(Integer yqEqId,Integer state) {
		yqEqMapper.updateState(yqEqId,state);
	}

	@Override
	public void updateType(Integer yqEqId, String state) {
		yqEqMapper.updateType(yqEqId, state);
	}

	@Override
	public void updateAllType(String eqId, String type) {
		yqEqMapper.updateAllType(eqId, type);
	}

	@Override
	public List<YqEqVo> selectYqEq(String userId, Integer state) {
		return yqEqMapper.selectYqEq(userId, state);
	}

	@Override
	public Integer findId(Integer jcyqId, Integer eqId) {
		return yqEqMapper.findId(jcyqId,eqId);
	}

	@Override
	public Integer findTotalNum(String eqId) {
		return yqEqMapper.findTotalNum(eqId);
	}

	@Override
	public YqEq findById(Integer yqEqId) {
		return yqEqMapper.findById(yqEqId);
	}

	@Override
	public List<YqEq> findByType(String eqId, String type) {
		return yqEqMapper.findByType(eqId, type);
	}

	/*@Override
	public YqEq selectYqEq(Integer yqEqId) {
		return yqEqMapper.selectYqEq(yqEqId);
	}*/


}