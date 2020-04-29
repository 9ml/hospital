package com.litbo.hospitalzj.supplier.controller;

import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.supplier.entity.SgdjHw;
import com.litbo.hospitalzj.supplier.service.HtInfoService;
import com.litbo.hospitalzj.supplier.service.SgdjHwService;
import com.litbo.hospitalzj.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sgdjhw")
public class SgdjHwController extends BaseController{
	@Autowired
	private SgdjHwService sgdjHwService;
	@Autowired
	private HtInfoService htinfoService;
	@RequestMapping("/select")
	public ResponseResult<SgdjHw> select(Integer htIds) {
		SgdjHw all= sgdjHwService.selectSgdjHw(htIds);
		return new ResponseResult<SgdjHw>(SUCCESS,all);
	}
	@RequestMapping(value = "/insert",method = RequestMethod.POST)
	public ResponseResult<Integer> insert(SgdjHw sgdjHw, @RequestParam("htIds") Integer htids) {
		sgdjHw.setHtIds(htids);
		Integer integer = sgdjHwService.InsertSgdjHw(sgdjHw);
		return new ResponseResult<Integer>(SUCCESS, integer);
	}
	@RequestMapping("/updateInfo")
	public ResponseResult<Void> updateInfo(SgdjHw sgdjHw) {
		System.out.println(sgdjHw.getDjhwSbwg());
		System.out.println(sgdjHw.getDjhwSxwj());
		sgdjHwService.updateInfo(sgdjHw);

	/*	htinfoService.updateHtInfoState(sgdjHw.getHtIds(), EnumProcess.PERFECT_INFORMATION.getMessage());*/
		return new ResponseResult<Void>(SUCCESS);
	}
/*	//同意验收数量
	@RequestMapping("/countByTyys")
	public ResponseResult<Integer> countByTyys() {
		Integer all= sgdjHwService.count(EnumProcess.TONG_YI_YANSHOU.getMessage());
		return new ResponseResult<Integer>(SUCCESS,all);
	}*/
	/*//等待审核验收数量
	@RequestMapping("/countByDdshys")
	public ResponseResult<Integer> countByDdshys() {
		Integer all= sgdjHwService.count(EnumProcess.WAIT_ACCEPT_YS.getMessage());
		return new ResponseResult<Integer>(SUCCESS,all);
	}*/
}
