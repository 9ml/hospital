package com.litbo.hospitalzj.zk.service.impl;

import com.litbo.hospitalzj.sf.entity.User;
import com.litbo.hospitalzj.sf.mapper.UserMapper;
import com.litbo.hospitalzj.sf.vo.UserRoleVo;
import com.litbo.hospitalzj.supplier.entity.EqInfo;
import com.litbo.hospitalzj.supplier.mapper.EqInfoMapper;
import com.litbo.hospitalzj.supplier.service.exception.InsertException;
import com.litbo.hospitalzj.supplier.service.exception.ServiceException;
import com.litbo.hospitalzj.user.bean.EqZjls;
import com.litbo.hospitalzj.user.dao.EqZjlsDao;
import com.litbo.hospitalzj.zk.Enum.EnumProcess2;
import com.litbo.hospitalzj.zk.domian.UserEq;
import com.litbo.hospitalzj.zk.mapper.UserEqMapper;
import com.litbo.hospitalzj.zk.mapper.YqEqMapper;
import com.litbo.hospitalzj.zk.service.UserEqService;
import com.litbo.hospitalzj.zk.vo.UserEqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserEqServiceImpl implements UserEqService{

	@Autowired
	UserEqMapper userEqMapper;
	@Autowired
	YqEqMapper yqEqMapper;
	@Autowired
	private EqZjlsDao eqZjlsDao;
	@Autowired
	public EqInfoMapper eqInfoMapper;
	@Autowired
	private UserMapper userMapper;

	@Override
	public void insertBatchByShEqid(String userId, String[] shEqid) {
		UserEq userEq=new UserEq();
		userEq.setUserId(userId);
		for(int i=0;i<shEqid.length;i++){
			User data=userEqMapper.findUserRole(userId);
			if("管理员&检测员"!=data.getRoleId()){
				throw new InsertException("请给管理员&检测员添加审核设备");
			}
			userEq.setShEqid(shEqid[i]);
			userEqMapper.insertBatchByShEqid(userEq);
		}
	}

	@Override
	public Integer insertBatchByJcEqid(String userId, String jcEqid ,String shrId,String ndjhId) {
		UserEq userEq=new UserEq();
		userEq.setUserId(userId);
		userEq.setJcEqid(jcEqid);
		userEq.setShrId(shrId);
		userEq.setNdjhId(ndjhId);
		userEq.setDate(new Date());
		Integer id = userEqMapper.findUserEqByUserIdAndJceqid(userId, jcEqid);
		if(id == null){
			userEqMapper.insertBatchByJcEqid(userEq);
			return userEq.getId();
		}

		return id;
	}

	@Override
	public void deleteBatchByShEqid(String userId, String[] shEqId) {
		for(int i=0;i<shEqId.length;i++){
			userEqMapper.deleteBatchByShEqid(userId,shEqId[i]);
		}
	}

	@Override
	public void deleteBatchByJcEqid(String userId, String jcEqId) {
			userEqMapper.deleteBatchByJcEqid(userId,jcEqId);
	}

	@Override
	public void setEqState(Integer Id, String state) {
		userEqMapper.setEqState(Id,state);
	}

	@Override
	public void setJcEqState2(String userId, String eqId) {
		userEqMapper.setJcEqState2(userId,eqId);
	}

	@Override
	public void setEqState2(String userId, String eqId) {
		//检测人员不仅要把自己的检测设备设置状态还要设置将要
		//审核该设备的人员的设备状态
		userEqMapper.setJcEqState2(userId,eqId);
		userEqMapper.setShEqState2(eqId);
	}

	@Override
	public void setEqState34(String State,String userId, String eqId) {
		if(State.equals("1")){
			userEqMapper.setEqState4(userId,eqId);
		}else{
			userEqMapper.setEqState3(userId,eqId);
		}
	}
	@Override
	public void setEqState5(String userId, String eqId) {
		userEqMapper.setEqState5(userId, eqId);
	}

	@Override
	public void setEqState6(String userId, String eqId) {
		userEqMapper.setEqState6(userId, eqId);
	}

	@Override
	public void updateState(Integer ndjhId, String userEqState, String state) {
		userEqMapper.updateState(ndjhId,userEqState,state);
		
	}

	@Override
	public List<UserEqVo> findUserEqVo(String userId,String state) {
		return userEqMapper.findUserEqVo(userId,state);
	}

	@Override
	public List<UserEqVo> findUserEq(String userId, String state, String shState) {
		return userEqMapper.findUserEq(userId,state,shState);
	}
	@Override
	public void setEqStateNotIs(String jceqId,String userId,String shrId) {
		System.out.println("++++++++++++++++++++"+jceqId);
		EqInfo eqInfo= eqInfoMapper.selectByEqId(Integer.valueOf(jceqId));
		UserRoleVo user=userMapper.select(userId);
		UserRoleVo shr=userMapper.select(shrId);
		Integer userEqId=userEqMapper.findUserEqByUserIdAndJceqid(userId, jceqId);
		System.out.println(userEqId);
		if(yqEqMapper.selectStateNot(jceqId,0)>0){
			throw new ServiceException("此设备，您还有数据没有验收！！！");
		}
		if(yqEqMapper.selectStateNot(jceqId,2)>0){
			userEqMapper.setEqStateNotIs(userEqId,EnumProcess2.DETECTION_OF_AUDIT_NOT.getMessage());
		}else{
			userEqMapper.setEqStateNotIs(userEqId,EnumProcess2.DETECTION_OF_AUDIT_IS.getMessage());
			yqEqMapper.updateAllType(jceqId, "初始值");
			EqZjls data =new EqZjls();
			data.setEqId(Integer.valueOf(jceqId));
			data.setTestTime(new Date());
			data.setEqMc(eqInfo.getEqMc());
			data.setTester(user.getUserName());
			data.setAuditor(shr.getUserName());
			eqZjlsDao.insert(data);
		}
	}



	//
	///
	///
	///
	@Override
	public void setEqTypeNotIs(String jceqId, String userId) {
		Integer userEqId=null;
		userEqMapper.setEqStateNotIs(userEqId,EnumProcess2.UNDER_REVIEW.getMessage());
	}
	//查询审核不成功个数
	@Override
	public Integer findByUserIdState(String userId, String state) {
		return userEqMapper.findByUserIdState(userId,state);
	}

	@Override
	public Integer findUserEqByUserIdAndJceqid(String userId, String jceqId) {
		return userEqMapper.findUserEqByUserIdAndJceqid(userId,jceqId);
	}
}