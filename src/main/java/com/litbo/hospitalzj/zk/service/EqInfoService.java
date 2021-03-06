package com.litbo.hospitalzj.zk.service;

import com.litbo.hospitalzj.sf.entity.User;
import com.litbo.hospitalzj.zk.domian.EqInfo;
import com.litbo.hospitalzj.zk.domian.Yq;
import com.litbo.hospitalzj.zk.vo.EqAndUname;
import com.litbo.hospitalzj.zk.vo.EqToYqs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EqInfoService {
	List<EqInfo> findAll(@Param("offset") Integer offset,
                         @Param("count") Integer count);
	void updateInfo1(EqInfo eqinfo);

	void updateEqPm(@Param("eqPmId") Integer eqPmId, @Param("eqId") Integer eqId);

	public void insert(EqInfo dt);

	public void delete(String id);

	public List<EqInfo> findByJcyqId(String jcyqId);

	public List<EqInfo> findNotByJcyqId(String jcyqId);

	public List<EqInfo> findJcEqByUserId(String userId);

	public List<EqInfo> findShEqByUserId(String userId);

	public List<EqInfo> findJcEqNotByUserId(String string);

	public List<EqInfo> findShEqNotByUserId(String string);

	public EqToYqs findEqYqs(String dah);

	public EqInfo findEqById(String eqId);

	public List<Yq> findYqsById(Integer eqId);

	public List<EqInfo> findEqsByState(String state);

	public List<EqInfo> findEqsByUserIdAndState(String userId, String state);

	List<EqInfo> findEqInfo(String userId);

	List<EqInfo> findNewEqInfo();
    //查询用户已分配的新设备信息
	List<EqInfo> findNewJcEqByUserId(String userId);

	
	public List<EqAndUname> findJcEqsByUserIdAndState(String userId, String state);

	public List<EqInfo> findShEqsByUserIdAndState(String userId, String state);
	//通过设备Id查询分配用户
	List<User> findUserIdByEqId(String userId);
	EqInfo findByDah(String dah);

	//根据设备id查询设备品名
    int findEqPm(String eqId);
}
