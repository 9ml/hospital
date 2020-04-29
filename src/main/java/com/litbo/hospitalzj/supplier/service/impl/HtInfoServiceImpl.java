package com.litbo.hospitalzj.supplier.service.impl;

import com.litbo.hospitalzj.hospital.enums.EnumProcess;
import com.litbo.hospitalzj.supplier.controller.ex.HtInfoIsNullException;
import com.litbo.hospitalzj.supplier.entity.District;
import com.litbo.hospitalzj.supplier.entity.EqInfo;
import com.litbo.hospitalzj.supplier.entity.HtInfo;
import com.litbo.hospitalzj.supplier.mapper.EqHtFjVoMapper;
import com.litbo.hospitalzj.supplier.mapper.EqInfoMapper;
import com.litbo.hospitalzj.supplier.mapper.HtInfoMapper;
import com.litbo.hospitalzj.supplier.service.HtInfoService;
import com.litbo.hospitalzj.supplier.service.exception.YzmNonentityException;
import com.litbo.hospitalzj.supplier.vo.EqHtVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class HtInfoServiceImpl implements HtInfoService {
	@Autowired
	public HtInfoMapper htInfoMapper;
    @Autowired
    public EqHtFjVoMapper eqhtfjMapper;
	@Autowired
	public EqInfoMapper eqInfoMapper;
	@Override
	public Integer InsertHtInfo(HtInfo htInfo) {
		htInfoMapper.insertHt(htInfo);
		Integer a=htInfo.getHtId();
		System.out.println(a);
		return htInfo.getHtId();
	}
	@Override
	public List<EqHtVo> selectEqHtVo(String htYzm) {
		List<EqHtVo> date=htInfoMapper.EqHtVo(htYzm);
		if(date==null) {
			throw new YzmNonentityException("验证码不存在");
		}
		return date;
	}

	@Override
	public List<HtInfo> selectAllHtInfo() {
		List<HtInfo> data=htInfoMapper.findAll(EnumProcess.WAIT_ACCEPT.getMessage());
		if (data== null) {
			throw new HtInfoIsNullException("合同不存在，请根据需要添加合同");
		}
		return data;
	}

	@Override
	public void updateInfo(HtInfo htinfo) {
		htInfoMapper.updateInfo(htinfo);
	}
	@Override
	public List<HtInfo> selectHtinfo(Integer sbcsId) {
		List<HtInfo> data=htInfoMapper.findBySbcsId(sbcsId);
		if (data== null) {
			throw new HtInfoIsNullException("合同不存在，请根据需要添加合同");
		}
		return data;
	}
	@Override
	public void updateYzm(Integer htId, String htYzm, String htState) {

		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = fmt.format(new Date());

		htInfoMapper.updateYzm(htId,htYzm,htState, format);
	}
	@Override
	public HtInfo select(Integer htId) {
		HtInfo data=htInfoMapper.findByHtId(htId);
		return data;
	}
	@Override
	public HtInfo selectHtInfo(String htYzm) {
		HtInfo data=htInfoMapper.findByHtYzm(htYzm);
		if (data== null) {
			throw new HtInfoIsNullException("验证码不存在，请根据添加合同");
		}
		return data;
	}


	@Override
	public int agreeHtInfoById(Integer htId, String yy, String date,String htYsyDh) {
		System.out.println(123);
		return htInfoMapper.updateState(htId,yy,date,EnumProcess.APPOINMENT_ACCEPTANCE.getMessage(),htYsyDh);
	}

	@Override
	public int refuseHtInfoById(Integer htId, String yy, String date,String htYsyDh) {
		return htInfoMapper.updateState(htId,yy,date,EnumProcess.IMPERFECT_CONTRACT_INFORMATION.getMessage(),htYsyDh);
	}

	@Override
	public List<HtInfo> selectAllHtWaitRegister() {
		List<HtInfo> data=htInfoMapper.findAll(EnumProcess.APPOINMENT_ACCEPTANCE.getMessage());
		return data;
	}

	@Override
	public int updateHtInfoState(Integer htId, String htState) {
		return htInfoMapper.updateStateById(htId, htState);
	}

	@Override
	public List<HtInfo> selectAllHtWaitAccept() {
		List<HtInfo> data=htInfoMapper.findAll(EnumProcess.WAIT_ACCEPT_YS.getMessage());
		return data;
	}

	@Override
	public List<HtInfo> selectAllHtAccept() {
		List<HtInfo> data=htInfoMapper.findAll(EnumProcess.ACCEPT_OVER.getMessage());
		return data;
	}
	@Override
	public List<HtInfo> selectAllHtByhtState(String htState) {
		List<HtInfo> data=htInfoMapper.findAll(htState);
		return data;
	}

	@Override
	public void HtJC(Integer htId) {
		List<EqInfo> data=eqInfoMapper.selectEqinfo(htId);
		for(EqInfo eqInfo:data){
			String eqScbh=eqInfo.getEqScbh();
			String[] eqScbhOne=eqScbh.split(",");
			if(eqScbhOne.length!=Integer.valueOf(eqInfo.getEqNum())){
				throw new RuntimeException("请核对设备数量与生产编号数量，不对应");
			}
			for(int j=0;j<eqScbhOne.length;j++){
				int lastId=eqInfoMapper.lastId();
				eqInfo.setEqId(lastId+1);
				eqInfo.setEqDah(" ");
				eqInfo.setEqNum("1");
				eqInfo.setEqState(2);
				eqInfo.setEqScbh(eqScbhOne[j]);
				System.out.println(eqInfo);
				eqInfoMapper.insertEqInfo(eqInfo);
			}
		}
	}

	@Override
	public int count(String htState) {
		return htInfoMapper.count(htState);
	}

	@Override
	public List<District> findProvinceByParentId(String parent) {
		return htInfoMapper.findProvinceByParentId(parent);
	}

	@Override
	public void saveqm(String htId, String img, Integer num) {
		if(num == 1){
			//保存签名并改状态
			htInfoMapper.saveqm1(htId, img);
		}else if(num ==2){
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String format = fmt.format(new Date());
			htInfoMapper.saveqm2(htId, img, format);
		}else{
			htInfoMapper.saveqm3(htId, img);
		}


	}

	@Override
	public void updateHtInfoStateAndTime(Integer htId, String format, String message) {
		htInfoMapper.updateHtInfoStateAndTime(htId, format, message);
	}

	@Override
	public void updateHtInfoStateAndwsTime(Integer htId, String format, String message) {
		htInfoMapper.updateHtInfoStateAndwsTime(htId, format, message);
	}

	public List<HtInfo> findBySuMc(String suMc) {
		return htInfoMapper.findBySuMc(suMc);
	}

	@Override
	public void deleteById(String htId) {
		htInfoMapper.deleteById(htId);
	}


}