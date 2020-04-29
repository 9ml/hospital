package com.litbo.hospitalzj.supplier.controller;

import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.supplier.entity.EqFj;
import com.litbo.hospitalzj.supplier.service.EqFjService;
import com.litbo.hospitalzj.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/eqfj")
public class EqFjController extends BaseController{
	@Autowired
	private EqFjService eqFjService;


	@RequestMapping("/insertBat")
	public ResponseResult<Void> insertEqFjBat(EqFj eqFj){
		String[] ccbhs = eqFj.getEqFjccbh().split(",");
		String[] ccrqs = eqFj.getEqFjccrq().split(",");
		int num = Integer.parseInt(eqFj.getEqFjsl());
		if(ccbhs.length != num || ccrqs.length != num){
			return new ResponseResult<>(603);
		}
		for (int i=0; i<ccbhs.length; i++){
			eqFj.setEqFjccbh(ccbhs[i]);
			eqFj.setEqFjccrq(ccrqs[i]);
			eqFj.setEqFjsl("1");
			eqFjService.insertEqFj(eqFj);
		}
		return new ResponseResult<Void>(SUCCESS);
	}
	@RequestMapping("/insert")
	public ResponseResult<Void> insertEqFj(EqFj eqFj){
		eqFjService.insertEqFj(eqFj);
		return new ResponseResult<Void>(SUCCESS);
	}
	@RequestMapping("/updateInfo")
	public ResponseResult<Void> updateInfo(EqFj eqFj, HttpSession session){
		eqFjService.updateInfo(eqFj);
		return new ResponseResult<Void>(SUCCESS);
	}


	@RequestMapping("/updateBat")
	public ResponseResult updateBat(EqFj eqFj){
		String[] ccbhs = eqFj.getEqFjccbh().split(",");
		String[] ccrqs = eqFj.getEqFjccrq().split(",");
		int num = Integer.parseInt(eqFj.getEqFjsl());
		if(ccbhs.length != num || ccrqs.length != num){
			return new ResponseResult<>(603);
		}
		EqFj _eqFj = eqFjService.selectById(eqFj.getEqFjId());
		List<EqFj> eqFjs = eqFjService.selectByMcAndXh(_eqFj.getEqIds(), _eqFj.getEqFjmc(), _eqFj.getEqFjxh());
		for (int i=0; i<ccbhs.length; i++){
			eqFj.setEqFjId(eqFjs.get(i).getEqFjId());
			eqFj.setEqIds(_eqFj.getEqIds());
			eqFj.setEqFjccbh(ccbhs[i]);
			eqFj.setEqFjccrq(ccrqs[i]);
			eqFj.setEqFjsl("1");
			eqFjService.update(eqFj);
		}
		return new ResponseResult(200);
	}



	@RequestMapping("/selectInfo")
	public ResponseResult<List<EqFj>> selectInfo(Integer eqIds){
		List<EqFj> eqFj=eqFjService.selectInfo(eqIds);
		return new ResponseResult<List<EqFj>>(SUCCESS,eqFj);
	}

	@RequestMapping("/selectInfoGroup")
	public ResponseResult<List<EqFj>> selectInfoGroup(Integer eqIds){
		List<EqFj> eqFj=eqFjService.selectEqFjGroup(eqIds);
		return new ResponseResult<List<EqFj>>(SUCCESS,eqFj);
	}


	@RequestMapping("/selectInfoOneGroup")
	public ResponseResult<EqFj> selectInfoOneGroup(Integer eqFjId){
		EqFj eqFj=eqFjService.selectById(eqFjId);
		eqFj=eqFjService.selectInfoOneGroup(eqFj);
		return new ResponseResult<EqFj>(SUCCESS,eqFj);
	}


	@RequestMapping("/selectById")
	public ResponseResult<EqFj> selectById(Integer eqFjId){
		EqFj eqFj=eqFjService.selectById(eqFjId);
		return new ResponseResult<EqFj>(SUCCESS,eqFj);
	}
	@RequestMapping("/delete")
	public ResponseResult<Void> delete(Integer eqFjId){
		eqFjService.delete(eqFjId);
		return new ResponseResult<Void>(SUCCESS);
	}

	@RequestMapping("/deleteBat")
	public ResponseResult<Void> deleteBat(Integer eqFjId){
		try {
			EqFj eqFj = eqFjService.selectById(eqFjId);
			eqFjService.deleteBat(eqFj);
			return new ResponseResult<>(200);
		}catch (Exception e){
			return new ResponseResult<>(500, "删除异常！");
		}
	}
}
