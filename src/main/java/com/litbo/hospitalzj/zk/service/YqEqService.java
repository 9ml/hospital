package com.litbo.hospitalzj.zk.service;

import com.litbo.hospitalzj.zk.domian.Yq;
import com.litbo.hospitalzj.zk.domian.YqEq;
import com.litbo.hospitalzj.zk.vo.YqEqVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface YqEqService {


	//查询和对应设备关联的仪器信息（待上传）
	List<Yq> selectOtherAndJcshcg(String eqId);

	//查询和对应设备关联的电器检测仪器信息（待上传）
	List<Yq>  selectDqjcAndJcshcg(String eqId);

	//查询和对应设备关联的仪器信息（待上传）
	List<Yq> selectOtherAndJcBtg(String eqId);

	//查询和对应设备关联的电器检测仪器信息（待上传）
	List<Yq>  selectDqjcAndJcBtg(String eqId);

	//查询和对应设备关联的仪器信息（待上传）
	List<Yq> selectOtherAndDsc(String eqId);

	//查询和对应设备关联的电器检测仪器信息（待上传）
	List<Yq>  selectDqjcAndDsc(String eqId);


	int insertBatch(String eqId, String jcyqId);
	
	void deleteBatch(String jcyqId, String eqId);
	
	YqEq selectEqId(String jcyqId);

	void updateState(Integer yqEqId, Integer state);

	void updateType(Integer yqEqId, String state);

	void updateAllType(@Param("eqId") String eqId, @Param("type") String type);
	List<YqEqVo> selectYqEq(@Param("userId") String userId, @Param("state") Integer state);
	Integer findId(@Param("jcyqId") Integer jcyqId, @Param("eqId") Integer eqId);


	Integer findTotalNum(String eqId);

	YqEq findById(Integer yqEqId);

	List<YqEq> findByType(String eqId, String 待上传);

	//
   /* YqEq selectYqEq(Integer yqEqId);*/
}
