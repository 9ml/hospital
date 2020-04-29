package com.litbo.hospitalzj.supplier.service;

import com.litbo.hospitalzj.supplier.entity.QyLx;
import com.litbo.hospitalzj.supplier.entity.TBank;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QyLxService {
	List<QyLx> findAll();
	void insert(QyLx qyLx);
	void update(QyLx qyLx);
	List<QyLx> findByQyLxNameLike(@Param("qyLx") String qyLx);
	void delete(Integer qyLxid);

	//查询银行列表
    List<TBank> findBank();
}
