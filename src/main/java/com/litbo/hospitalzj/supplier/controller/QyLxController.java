package com.litbo.hospitalzj.supplier.controller;

import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.supplier.entity.QyLx;
import com.litbo.hospitalzj.supplier.entity.TBank;
import com.litbo.hospitalzj.supplier.service.QyLxService;
import com.litbo.hospitalzj.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/qylx")
public class QyLxController extends BaseController{
	@Autowired
	public QyLxService qyLxService;


	@RequestMapping("/bank")
	public ResponseResult<List<TBank>> getBank() {
		List<TBank> data=qyLxService.findBank();
		return new ResponseResult<List<TBank>>(SUCCESS,data);
	}

	@RequestMapping("/insert")
	public ResponseResult<Void> getByCode(QyLx qyLx) {
		qyLxService.insert(qyLx);
		return new ResponseResult<Void>(SUCCESS);
	}
	@RequestMapping("/all")
	public ResponseResult<List<QyLx>> getAll() {
		List<QyLx> data=qyLxService.findAll();
		return new ResponseResult<List<QyLx>>(SUCCESS,data);
	}
	@RequestMapping("/allQyLx")
	public ResponseResult<List<QyLx>> All() {
		List<QyLx> data=qyLxService.findAll();
		return new ResponseResult<List<QyLx>>(SUCCESS,data);
	}
	@RequestMapping("/delete")
	public ResponseResult<Void> delete(Integer qyLxid) {
		qyLxService.delete(qyLxid);
		return new ResponseResult<Void>(SUCCESS);
	}
	@RequestMapping("/update")
	public ResponseResult<Void> update(QyLx qyLx) {
		qyLxService.update(qyLx);
		return new ResponseResult<Void>(SUCCESS);
	}
	@RequestMapping("/findByQyLxNameLike")
	public ResponseResult<List<QyLx>> findByQyLxNameLike(String qyLxcm) {
		List<QyLx> data=qyLxService.findByQyLxNameLike(qyLxcm);
		return new ResponseResult<List<QyLx>>(SUCCESS,data);
	}
}
