package com.litbo.hospitalzj.supplier.controller;


import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.supplier.entity.EqInfo;
import com.litbo.hospitalzj.supplier.service.EqInfoService;
import com.litbo.hospitalzj.supplier.vo.SelHtEqVo;
import com.litbo.hospitalzj.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/eqInfo")
public class EqInfoController extends BaseController{
	@Autowired
	private EqInfoService eqinfoService;



	@RequestMapping("/insertBat")
	public ResponseResult<Integer> insertBatEqInfo(EqInfo eqInfo, HttpSession session){
		String[] ccbhs = eqInfo.getEqScbh().split(",");
		String[] ccshs = eqInfo.getEqCcdate().split(",");
		int num = Integer.parseInt(eqInfo.getEqNum());
		if(ccbhs.length != num || ccshs.length != num){
			return new ResponseResult<Integer>(603);
		}
		for (int i=0; i<ccbhs.length; i++){
			eqInfo.setEqScbh(ccbhs[i]);
			eqInfo.setEqCcdate(ccshs[i]);
			eqInfo.setEqState(2);
			eqInfo.setEqNum("1");
			eqinfoService.InsertBatEqInfo(eqInfo);
		}
		return new ResponseResult<Integer>(SUCCESS,eqInfo.getEqId());
		//session.setAttribute("eqId", eqInfo.getEqId());
		//System.out.println(eqInfo.getEqId());
	}


	@RequestMapping("/deleteBat")
	public ResponseResult<Void> deleteBat(Integer eqId) {
		EqInfo eqInfo = eqinfoService.selectByEqId(eqId);
		eqinfoService.deleteBat(eqInfo);
		return new ResponseResult<Void>(SUCCESS);
	}



	@RequestMapping("/insert")
	public ResponseResult<Integer> insertEqInfo(EqInfo eqInfo, HttpSession session){
		eqinfoService.InsertEqInfo(eqInfo);
		session.setAttribute("eqId", eqInfo.getEqId());
		System.out.println(eqInfo.getEqId());
		eqInfo.setEqState(1);
		return new ResponseResult<Integer>(SUCCESS,eqInfo.getEqId());
	}




	@RequestMapping("/updateInfo")
	public ResponseResult<Void> updateInfo(EqInfo eqInfo){
		eqinfoService.updateInfo(eqInfo);
		return new ResponseResult<Void>(SUCCESS);
	}
	@RequestMapping("/selectEqHt")
	public ResponseResult<List<EqInfo>> selectEqInfo(Integer htIds, HttpSession session){
		List<EqInfo> eqInfo=eqinfoService.selectEqInfo(htIds);
		return new ResponseResult<List<EqInfo>>(SUCCESS,eqInfo);
	}
	@RequestMapping("/selectEqInfo")
	public ResponseResult<List<SelHtEqVo>> selectEqHt(Integer htIds, HttpSession session){
		List<SelHtEqVo> eqInfo=eqinfoService.selectEqHtVo(htIds);
		System.out.println(eqInfo);
		return new ResponseResult<List<SelHtEqVo>>(SUCCESS,eqInfo);
	}

	@RequestMapping("/selectGroupEqInfo2")
	public ResponseResult<List<SelHtEqVo>> selectGroupEqInfo2(Integer htIds, HttpSession session){
		List<SelHtEqVo> eqInfo=eqinfoService.selectGroupEqHtVo2(htIds);
		return new ResponseResult<List<SelHtEqVo>>(SUCCESS,eqInfo);
	}


	@RequestMapping("/selectGroupEqInfo")
	public ResponseResult<List<SelHtEqVo>> selectGroupEqInfo(Integer htIds, HttpSession session){
		List<SelHtEqVo> eqInfo=eqinfoService.selectGroupEqHtVo(htIds);
		System.out.println(eqInfo);
		return new ResponseResult<List<SelHtEqVo>>(SUCCESS,eqInfo);
	}


	@RequestMapping("/selectEqId")
	public ResponseResult<Integer> findByEqId(Integer eqId){
		Integer data=eqinfoService.findHtId(eqId);
		return new ResponseResult<Integer>(SUCCESS,data);
	}
	@RequestMapping("/selectByState")
	public ResponseResult<List<EqInfo>> findByState(){
		List<EqInfo> data=eqinfoService.selectByState();
		return new ResponseResult<List<EqInfo>>(SUCCESS,data);
	}
	@RequestMapping("/delete")
	public ResponseResult<Void> delete(Integer eqId) {
		eqinfoService.delete(eqId);
		return new ResponseResult<Void>(SUCCESS);
	}
	@RequestMapping("/select")
	public ResponseResult<EqInfo> selectByEqId(Integer eqId) {
		EqInfo data=eqinfoService.selectByEqId(eqId);
		return new ResponseResult<EqInfo>(SUCCESS,data);
	}

	@RequestMapping("/updateBat")
	public ResponseResult udateBat(EqInfo eqInfo){
		String[] ccbhs = eqInfo.getEqScbh().split(",");
		String[] ccshs = eqInfo.getEqCcdate().split(",");
		int num = Integer.parseInt(eqInfo.getEqNum());
		if(ccbhs.length != num || ccshs.length != num){
			return new ResponseResult<Integer>(603);
		}
		//根据设备id查出该设备的信息，
		EqInfo byEqId = eqinfoService.selectByEqId(eqInfo.getEqId());
		//用该设备的类型， 名称， 合同号查出合同关联的设备列表
		List<EqInfo> eqInfos = eqinfoService.selectEqInfo(eqInfo.getHtIds());
		for (EqInfo info : eqInfos) {
			if(!info.getEqMc().equals(byEqId.getEqMc()) || !info.getEqXh().equals(byEqId.getEqXh())){
				eqInfos.remove(info);
			}
		}
		if(eqInfos.size() != Integer.parseInt(eqInfo.getEqNum())){
			return new ResponseResult(603);
		}

		if(eqInfos.size() == Integer.parseInt(eqInfo.getEqNum())){
			for(int i=0; i<eqInfos.size(); i++){
				eqInfo.setEqId(eqInfos.get(i).getEqId());
				eqInfo.setEqScbh(ccbhs[i]);
				eqInfo.setEqCcdate(ccshs[i]);
				eqInfo.setEqState(2);
				eqInfo.setEqNum("1");
				eqinfoService.updateInfo(eqInfo);
			}
		}else if(eqInfos.size() > Integer.parseInt(eqInfo.getEqNum())){
			//数量减少
			for (int i=0; i<eqInfos.size(); i++) {
				//如果数据库中
				if(contain(eqInfos.get(i).getEqScbh(), ccbhs)){
					eqInfo.setEqId(eqInfos.get(i).getEqId());
					eqInfo.setEqScbh(ccbhs[i]);
					eqInfo.setEqCcdate(ccshs[i]);
					eqInfo.setEqState(2);
					eqInfo.setEqNum("1");
					eqinfoService.updateInfo(eqInfo);
				}else{
					eqinfoService.delete(eqInfos.get(i).getEqId());
				}
			}
		}else if(eqInfos.size() < Integer.parseInt(eqInfo.getEqNum())){
			//数量增加
			//如果数据库中查询到的bh
			int sun = Integer.parseInt(eqInfo.getEqNum());
			for (int i=0; i<sun; i++) {
				//如果数据库中
					if(contain(eqInfos.get(i).getEqScbh(), ccbhs)){
					eqInfo.setEqId(eqInfos.get(i).getEqId());
					eqInfo.setEqScbh(ccbhs[i]);
					eqInfo.setEqCcdate(ccshs[i]);
					eqInfo.setEqState(2);
					eqInfo.setEqNum("1");
					eqinfoService.updateInfo(eqInfo);
				}else{
					eqInfo.setEqScbh(ccbhs[i]);
					eqInfo.setEqCcdate(ccshs[i]);
					eqInfo.setEqState(2);
					eqInfo.setEqNum("1");
					eqinfoService.InsertEqInfo(eqInfo);
				}
			}
		}
		
		return new ResponseResult(200);
	}

	private boolean contain(String eqScbh, String[] ccbhs) {
		boolean res = false;
		for(int i=0; i<ccbhs.length; i++){
			if(eqScbh.equals(ccbhs[i])){
				res = true;
				continue;
			}
		}
		return res;
	}


	@RequestMapping("/selectGroup")
	public ResponseResult<EqInfo> selectGroup(Integer eqId) {
		EqInfo data=eqinfoService.selectGroup(eqId);
		return new ResponseResult<EqInfo>(SUCCESS,data);
	}


	/*
	 * 维修设备模块
	 */
	//查询维修设备信息
	@RequestMapping("/findWxEqInfo")
	public ResponseResult<List<EqInfo>> findWxEqInfo(){
		List<EqInfo> data=eqinfoService.findWXEqInfo();
		return new ResponseResult<List<EqInfo>>(SUCCESS,data);
	}
	//已分配维修设备
	@RequestMapping("/eqInfoWxYfp")
	public ResponseResult<List<EqInfo>> eqInfoWxYfp() {
		List<EqInfo> data=eqinfoService.eqInfoYfp(3);
		return new ResponseResult<List<EqInfo>>(SUCCESS,data);
	}
	//未分配维修设备
	@RequestMapping("/eqInfoWxWfp")
	public ResponseResult<List<EqInfo>> eqInfoWxWfp() {
		List<EqInfo> data=eqinfoService.eqInfoWfp(3);
		return new ResponseResult<List<EqInfo>>(SUCCESS,data);
	}
	//未分配设备数量
	@RequestMapping("/countWxWfp")
	public ResponseResult<Integer> countWxWfp() {
		Integer data=eqinfoService.countWfp(3);
		return new ResponseResult<Integer>(SUCCESS,data);
	}
	//查询已分配到人的设备
	@RequestMapping("/findByUserIdWxEqInfo")
	public ResponseResult<List<EqInfo>> findByUserIdWxEqInfo(HttpSession session) {
		String userId=getUserIdFromSession(session);
		List<EqInfo> data=eqinfoService.findByUserIdEqInfo(3,userId);
		return new ResponseResult<List<EqInfo>>(SUCCESS,data);
	}
	//查询已分配到人的设备数量
	@RequestMapping("/findByUserIdWxEqInfoCount")
	public ResponseResult<Integer> findByUserIdWxEqInfoCount(HttpSession session) {
		String userId=getUserIdFromSession(session);
		Integer data=eqinfoService.findByUserIdEqInfoCount(3,userId);  
		return new ResponseResult<Integer>(SUCCESS,data);
	}
	/*
	 *新设备模块
	 */
	//全部新设备信息
	@RequestMapping("/newEqInfo")
	public ResponseResult<List<EqInfo>> newEqinfo() {
		List<EqInfo> data=eqinfoService.newEqinfo();
		return new ResponseResult<List<EqInfo>>(SUCCESS,data);
	}
	//已分配新设备
	@RequestMapping("/eqInfoYfp")
	public ResponseResult<List<EqInfo>> eqInfoYfp() {
		List<EqInfo> data=eqinfoService.eqInfoYfp(1);
		return new ResponseResult<List<EqInfo>>(SUCCESS,data);
	}
	//未分配新设备
	@RequestMapping("/eqInfoWfp")
	public ResponseResult<List<EqInfo>> eqInfoWfp() {
		List<EqInfo> data=eqinfoService.eqInfoWfp(1);
		return new ResponseResult<List<EqInfo>>(SUCCESS,data);
	}
	//未分配设备数量
	@RequestMapping("/countWfp")
	public ResponseResult<Integer> countWfp() {
		Integer data=eqinfoService.countWfp(1);
		return new ResponseResult<Integer>(SUCCESS,data);
	}
	//查询已分配到人的设备
	@RequestMapping("/findByUserIdEqInfo")
	public ResponseResult<List<EqInfo>> findByUserIdEqInfo(HttpSession session) {
		String userId=getUserIdFromSession(session);
		List<EqInfo> data=eqinfoService.findByUserIdEqInfo(1,userId);
		return new ResponseResult<List<EqInfo>>(SUCCESS,data);
	}
	//查询已分配到人的设备数量
	@RequestMapping("/findByUserIdEqInfoCount")
	public ResponseResult<Integer> findByUserIdEqInfoCount(HttpSession session) {
		String userId=getUserIdFromSession(session);
		Integer data=eqinfoService.findByUserIdEqInfoCount(1,userId);
		return new ResponseResult<Integer>(SUCCESS,data);
	}
	@RequestMapping("/updateEqQk")
	public ResponseResult<Void> updateEqQk(@RequestParam("eqId")Integer eqId, @RequestParam("eqQk")String eqQk) {
		eqinfoService.updateEqQk(eqId,eqQk);
		return new ResponseResult<Void>(SUCCESS);
	}

	@RequestMapping("/findByEqQk")
	public ResponseResult<List<EqInfo>> findByEqQk(@RequestParam("eqQk")String eqQk) {
		List<EqInfo> data=eqinfoService.findByEqQk(eqQk);
		return new ResponseResult<List<EqInfo>>(SUCCESS,data);
	}
}
