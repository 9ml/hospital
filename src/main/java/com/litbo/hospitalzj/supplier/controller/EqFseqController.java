package com.litbo.hospitalzj.supplier.controller;

import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.supplier.entity.EqFseq;
import com.litbo.hospitalzj.supplier.service.EqFseqService;
import com.litbo.hospitalzj.util.ResponseResult;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/eqfseq")
public class EqFseqController extends BaseController{
	@Autowired
	private EqFseqService eqFseqService;


	@RequestMapping("/insert")
	public ResponseResult<Void> insertEqFj(EqFseq eqFseq){
		eqFseqService.insertEqFseq(eqFseq);
		return new ResponseResult<Void>(SUCCESS);
	}


	@RequestMapping("/insertBat")
	public ResponseResult<Void> insertEqFjBat(EqFseq eqFseq){
		String[] ccbhs = eqFseq.getEqScbh().split(",");
		String[] ccrqs = eqFseq.getEqCcdate().split(",");
		int num = Integer.parseInt(eqFseq.getEqNum());
		if(ccbhs.length != num || ccrqs.length != num){
			return new ResponseResult<>(603);
		}
		for (int i=0; i<ccbhs.length; i++){
			eqFseq.setEqScbh(ccbhs[i]);
			eqFseq.setEqCcdate(ccrqs[i]);
			eqFseq.setEqNum("1");
			eqFseqService.insertEqFseq(eqFseq);
		}
		return new ResponseResult<Void>(SUCCESS);
	}


	@RequestMapping("/updataBat")
	public ResponseResult updataBat(EqFseq eqFseq){
		String[] ccbhs = eqFseq.getEqScbh().split(",");
		String[] ccrqs = eqFseq.getEqCcdate().split(",");
		int num = Integer.parseInt(eqFseq.getEqNum());
		if(ccbhs.length != num || ccrqs.length != num){
			return new ResponseResult<>(603);
		}
		EqFseq fseq = eqFseqService.selectById(eqFseq.getEqFsid());
		List<EqFseq> eqFseqs = eqFseqService.selectByMcAndXh(Integer.parseInt(fseq.getEqIds()), fseq.getEqMc(), fseq.getEqXh());



		for(int i=0; i<eqFseqs.size(); i++){
			eqFseq.setEqFsid(eqFseqs.get(i).getEqFsid());
			eqFseq.setEqScbh(ccbhs[i]);
			eqFseq.setEqCcdate(ccrqs[i]);
			eqFseq.setEqNum("1"	);
			eqFseq.setEqIds(fseq.getEqIds());
			eqFseqService.update(eqFseq);
		}

		return new ResponseResult(200);

	}


	@RequestMapping("/updateInfo")
	public ResponseResult<Void> updateInfo(EqFseq eqFseq){
		eqFseqService.updateInfo(eqFseq);
		return new ResponseResult<Void>(SUCCESS);
	}
	@RequestMapping("/selectInfo")
	public ResponseResult<List<EqFseq>> selectInfo(Integer eqIds){
		List<EqFseq> eqFj=eqFseqService.selectEqFseq(eqIds);
		return new ResponseResult<List<EqFseq>>(SUCCESS,eqFj);
	}

	@RequestMapping("/selectInfoGroup")
	public ResponseResult<List<EqFseq>> selectInfoGroup(Integer eqIds){
		List<EqFseq> eqFj=eqFseqService.selectEqFseqGroup(eqIds);
		return new ResponseResult<List<EqFseq>>(SUCCESS,eqFj);
	}






	@RequestMapping("/selectById")
	public ResponseResult<EqFseq> selectById(Integer eqFsid){
		EqFseq eqFseq=eqFseqService.selectById(eqFsid);
		return new ResponseResult<EqFseq>(SUCCESS,eqFseq);
	}

	@RequestMapping("/selectById2")
	public ResponseResult<EqFseq> selectById2(Integer eqFsid){
		EqFseq eqFseq=eqFseqService.selectById2(eqFsid);
		return new ResponseResult<EqFseq>(SUCCESS,eqFseq);
	}


	@RequestMapping("/delete")
	public ResponseResult<Void> delete(Integer eqFsid){
		eqFseqService.delete(eqFsid);
		return new ResponseResult<Void>(SUCCESS);
	}

	@RequestMapping("/deleteBat")
	public ResponseResult<Void> deleteBat(Integer eqFsid){
		EqFseq eqFseq = eqFseqService.selectById(eqFsid);
		eqFseqService.deleteBat(eqFseq);
		return new ResponseResult<Void>(SUCCESS);
	}
	
}
