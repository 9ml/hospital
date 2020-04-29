package com.litbo.hospitalzj.supplier.controller;

import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.supplier.entity.EqLy;
import com.litbo.hospitalzj.supplier.service.EqLyService;
import com.litbo.hospitalzj.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 设备来源控制层
 * @author 刘洋
 *
 */
@RestController
@RequestMapping("/eqly")
public class EqLyController extends BaseController{
	@Autowired
	public EqLyService eqLyService;
	

	@RequestMapping("/{eqlyId}")
	public ResponseResult<EqLy> getByCode(@PathVariable("eqlyId") Integer eqlyId) {
		EqLy data=eqLyService.getById(eqlyId);
		return new ResponseResult<EqLy>(SUCCESS,data);
	}
	@RequestMapping("/all")
	public ResponseResult<List<EqLy>> getAll() {
		List<EqLy> data=eqLyService.getAll();
		return new ResponseResult<List<EqLy>>(SUCCESS,data);
	}
	@RequestMapping("/allEqly")
	public ResponseResult<List<EqLy>> All() {
		List<EqLy> data=eqLyService.getAll();
		return new ResponseResult<List<EqLy>>(SUCCESS,data);
	}
	@RequestMapping("/insert")
	public ResponseResult<Void> insert(EqLy eqLy) {
		eqLyService.insert(eqLy);
		return new ResponseResult<Void>(SUCCESS);
	}
	@RequestMapping("/delete")
	public ResponseResult<Void> delete(Integer eqlyId) {
		eqLyService.delete(eqlyId,1);
		return new ResponseResult<Void>(SUCCESS);
	}
	@RequestMapping("/update")
	public ResponseResult<EqLy> update(EqLy eqLy) {
		EqLy data=eqLyService.update(eqLy);
		return new ResponseResult<EqLy>(SUCCESS,data);
	}
	@RequestMapping("/findEqLyLike")
	public ResponseResult<List<EqLy>> findEqLyLike(String eqlyName) {
		List<EqLy> data=eqLyService.findEqLyLike(eqlyName);
		return new ResponseResult<List<EqLy>>(SUCCESS,data);
	}

}
