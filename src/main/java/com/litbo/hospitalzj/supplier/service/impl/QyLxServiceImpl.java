package com.litbo.hospitalzj.supplier.service.impl;


import com.litbo.hospitalzj.supplier.entity.QyLx;
import com.litbo.hospitalzj.supplier.entity.TBank;
import com.litbo.hospitalzj.supplier.mapper.QyLxMapper;
import com.litbo.hospitalzj.supplier.service.QyLxService;
import com.litbo.hospitalzj.supplier.service.exception.InsertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QyLxServiceImpl implements QyLxService {
	@Autowired
	private QyLxMapper  qyLxMapper;

	@Override
	public List<QyLx> findAll() {
		return qyLxMapper.findAll();
	}

	@Override
	public void insert(QyLx qyLx) {
		QyLx data=qyLxMapper.findByName(qyLx.getQyLxcm());
		if(data!=null){
			throw new InsertException("此项数据已存在");
		}
		qyLxMapper.insert(qyLx);
	}

	@Override
	public void update(QyLx qyLx) {
		qyLxMapper.update(qyLx);
	}

	@Override
	public List<QyLx> findByQyLxNameLike(String qyLx) {
		return qyLxMapper.findByQyLxNameLike(qyLx);
	}

	@Override
	public void delete(Integer qyLxid) {
		qyLxMapper.delete(qyLxid);
	}

	@Override
	public List<TBank> findBank() {
		return qyLxMapper.findBank();

	}
}
