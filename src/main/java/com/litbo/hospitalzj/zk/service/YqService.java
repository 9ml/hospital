package com.litbo.hospitalzj.zk.service;

import com.litbo.hospitalzj.zk.domian.EqInfo;
import com.litbo.hospitalzj.zk.domian.Yq;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface YqService {
	List<Yq> jz();
	Integer jzNum();
	void JzTime(@Param("jcyqId") Integer jcyqId, @Param("jcyqJzTime") Date jcyqJzTime);
	Yq findById(Integer jcyqId);
	List<Yq> findYqByYqNameLike(String jcyqName);

	List<Yq> findByUserId(String userId);
	
	List<Yq> findNotByUserId(String userId);

	void insert(Yq yq);

	void delete(Integer jcyqId);

	List<Yq> findAll();

	void update(Yq yq);

	List<Yq> select(Integer eqId);
	//根据档案号查询出设备
	EqInfo selectEqInfo(String eqDah);

	/*List<Yq> selectEqYq(String eqDah);*/

	//电器的数据
	List<Yq> selectEqYqByEqId(@Param("eqId") Integer eqId, @Param("jcyqName") String jcyqName);
    //除电器意外的数据
	List<Yq> selectEqYqNotDqByEqId(@Param("eqId") Integer eqId, @Param("jcyqName") String jcyqName);
	//根据设备Id查询出设备以及仪器
	EqInfo selectEqInfoByEqid(Integer eqId);

	List<Yq> selectEqYqByEqid(Integer eqId);

	//根据设备id查询设备所关联的仪器
	List<Yq> selectYqByEqId(@Param("eqId") Integer eqId);

	//管理员查看通过设备ID查询设备检测仪器
	//查看非电气仪器表
	List<Yq> selectYqNotDqByEqId(@Param("eqId") Integer eqId, @Param("jcyqName") String jcyqName);
	//查看电气仪器表
	List<Yq> selectYqDqByEqId(@Param("eqId") Integer eqId, @Param("jcyqName") String jcyqName);

	List<Yq> selectTime();

	List<String> selectEqInfoEqMc(String eqDah);
}
