package com.litbo.hospitalzj.supplier.service;

import com.litbo.hospitalzj.supplier.entity.EqFseq;

import java.util.List;

public interface EqFseqService {
	void insertEqFseq(EqFseq eqFseq);

	List<EqFseq> selectEqFseq(Integer eqIds);

	void updateInfo(EqFseq eqFseq);

	void delete(Integer eqFsid);

	EqFseq selectById(Integer eqFsid);

    List<EqFseq> selectEqFseqGroup(Integer eqIds);

	void deleteBat(EqFseq eqFseq);

    EqFseq selectById2(Integer eqFsid);

	void update(EqFseq eqFseq);

	List<EqFseq> selectByMcAndXh(Integer eqFsid, String eqMc, String eqXh);
}
