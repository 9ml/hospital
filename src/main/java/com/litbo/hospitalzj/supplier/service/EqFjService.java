package com.litbo.hospitalzj.supplier.service;

import com.litbo.hospitalzj.supplier.entity.EqFj;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EqFjService {
	EqFj insertEqFj(EqFj eqfj);
	
	void updateInfo(EqFj eqfj);
	
	List<EqFj> selectInfo(@Param("eqIds") Integer eqIds);

	List<EqFj> selectEqFjGroup(@Param("eqIds") Integer eqIds);

	Integer delete(Integer eqFjid);

	EqFj selectById(Integer eqFjId);


	void deleteBat(EqFj eqFj);

    EqFj selectInfoOneGroup(EqFj eqFj);

	List<EqFj> selectByMcAndXh(Integer eqIds, String eqFjmc, String eqFjxh);

	void update(EqFj eqFj);
}
