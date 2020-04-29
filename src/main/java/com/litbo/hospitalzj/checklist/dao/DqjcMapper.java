package com.litbo.hospitalzj.checklist.dao;

import com.litbo.hospitalzj.checklist.domain.Dqjc;
import com.litbo.hospitalzj.checklist.domain.DqjcTemplate;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * 电器检测dao层
 * @author bigStone
 *
 */
@Mapper
public interface DqjcMapper {
	
   	//查询电气检测模板表
	@Select("select dqjc_templateid, dydy1, dydy2,jdzk, jyzk, ddldl_zc, ddldl_dy, wkldl_zc, wkldl_dy, hzldl_zc_bf, hzldl_zc_cf, hzldl_dy_bf, hzldl_dy_cf,"
			+ " hzfzldl_zc_bf, hzfzldl_zc_cf, hzfzldl_dy_bf, hzfzldl_dy_cf from dqjc_template order by dqjc_templateid desc limit 1")
	public DqjcTemplate findTemplate();
	//修改模板表数据
	@Update(" update dqjc_template\n" +
			"    set dydy1 = #{dydy1},\n" +
			"      dydy2=#{dydy2},"+
			"      jdzk = #{jdzk},\n" +
			"      jyzk = #{jyzk,jdbcType=VARCHAR},\n" +
			"      ddldl_zc = #{ddldlZc,jdbcType=DOUBLE},\n" +
			"      ddldl_dy = #{ddldlDy,jdbcType=DOUBLE},\n" +
			"      wkldl_zc = #{wkldlZc,jdbcType=DOUBLE},\n" +
			"      wkldl_dy = #{wkldlDy,jdbcType=DOUBLE},\n" +
			"      hzldl_zc_bf = #{hzldlZcBf,jdbcType=DOUBLE},\n" +
			"      hzldl_zc_cf = #{hzldlZcCf,jdbcType=DOUBLE},\n" +
			"      hzldl_dy_bf = #{hzldlDyBf,jdbcType=DOUBLE},\n" +
			"      hzldl_dy_cf = #{hzldlDyCf,jdbcType=DOUBLE},\n" +
			"      hzfzldl_zc_bf = #{hzfzldlZcBf,jdbcType=DOUBLE},\n" +
			"      hzfzldl_zc_cf = #{hzfzldlZcCf,jdbcType=DOUBLE},\n" +
			"      hzfzldl_dy_bf = #{hzfzldlDyBf,jdbcType=DOUBLE},\n" +
			"      hzfzldl_dy_cf = #{hzfzldlDyCf,jdbcType=DOUBLE}\n" +
			"    where dqjc_templateid = #{dqjcTemplateid,jdbcType=INTEGER}")
	public void updateTemplate(DqjcTemplate dqjcTemplate);
	//插入模板表数据
	@Insert(" insert into dqjc_template (dqjc_templateid, dydy1,dydy2 jdzk, \n" +
			"      jyzk, ddldl_zc, ddldl_dy, \n" +
			"      wkldl_zc, wkldl_dy, hzldl_zc_bf, \n" +
			"      hzldl_zc_cf, hzldl_dy_bf, hzldl_dy_cf, \n" +
			"      hzfzldl_zc_bf, hzfzldl_zc_cf, hzfzldl_dy_bf, \n" +
			"      hzfzldl_dy_cf)\n" +
			"    values (#{dqjcTemplateid,jdbcType=INTEGER}, #{dydy,jdbcType=DOUBLE}, #{jdzk,jdbcType=DOUBLE}, \n" +
			"      #{jyzk,jdbcType=VARCHAR}, #{ddldlZc,jdbcType=DOUBLE}, #{ddldlDy,jdbcType=DOUBLE}, \n" +
			"      #{wkldlZc,jdbcType=DOUBLE}, #{wkldlDy,jdbcType=DOUBLE}, #{hzldlZcBf,jdbcType=DOUBLE}, \n" +
			"      #{hzldlZcCf,jdbcType=DOUBLE}, #{hzldlDyBf,jdbcType=DOUBLE}, #{hzldlDyCf,jdbcType=DOUBLE}, \n" +
			"      #{hzfzldlZcBf,jdbcType=DOUBLE}, #{hzfzldlZcCf,jdbcType=DOUBLE}, #{hzfzldlDyBf,jdbcType=DOUBLE}, \n" +
			"      #{hzfzldlDyCf,jdbcType=DOUBLE})")
	void insertTemplate(DqjcTemplate dqjcTemplate);

	//保存电气检测数据
	@Insert("insert into dqjc (dqjcid, jcyq_id, eq_id, \n" +
			"      tester, auditor,shsj_time, test_time, \n" +
			"      shr_jcjl,jcjl, jcsm, dydy1, dydy2,dydy_value, \n" +
			"      dydy_result, jdzk, jdzk_value, \n" +
			"      jdzk_result, jyzk, jyzk_value, \n" +
			"      jyzk_result, ddldl_zc, ddldl_zc_zx_value, \n" +
			"      ddldl_zc_fx_value, ddldl_zc_result, ddldl_dy, \n" +
			"      ddldl_dy_zxdl_value, ddldl_dy_fxdl_value, ddldl_dy_result, \n" +
			"      wkldl_zc, wkldl_zc_zx_value, wkldl_zc_fx_value, \n" +
			"      wkldl_zc_result, wkldl_dy, wkldl_dy_zxdl_value, \n" +
			"      wkldl_dy_zxdd_value, wkldl_dy_fxdl_value, wkldl_dy_fxdd_value, \n" +
			"      wkldl_dy_result, hzldl_zc_zxbf_value, hzldl_zc_fxbf_value, \n" +
			"      hzldl_zc_zxcf_value, hzldl_zc_fxcf_value, hzldl_zc_result, \n" +
			"      hzldl_dy_zxdlbf_value, hzldl_dy_zxddbf_value, hzldl_dy_fxdlbf_value, \n" +
			"      hzldl_dy_fxddbf_value, hzldl_dy_zxdlcf_value, hzldl_dy_zxddcf_value, \n" +
			"      hzldl_dy_fxdlcf_value, hzldl_dy_fxddcf_value, hzldl_dy_result, \n" +
			"      hzfzldl_zc_zxbf_value, hzfzldl_zc_fxbf_value, hzfzldl_zc_zxcf_value, \n" +
			"      hzfzldl_zc_fxcf_value, hzfzldl_zc_result, hzfzldl_dy_zxdlbf_value, \n" +
			"      hzfzldl_dy_zxddbf_value, hzfzldl_dy_fxdlbf_value, \n" +
			"      hzfzldl_dy_fxddbf_value, hzfzldl_dy_zxdlcf_value, \n" +
			"      hzfzldl_dy_zxddcf_value, hzfzldl_dy_fxdlcf_value, \n" +
			"      hzfzldl_dy_fxddcf_value, hzfzldl_dy_result, state, \n" +
			"      spare2, spare3, spare4, \n" +
			"      spare5)\n" +
			"    values (#{dqjcid,jdbcType=INTEGER}, #{jcyqId,jdbcType=INTEGER}, #{eqId,jdbcType=INTEGER}, \n" +
			"      #{tester,jdbcType=VARCHAR}, #{auditor,jdbcType=VARCHAR},#{shsjTime}, #{testTime,jdbcType=TIMESTAMP}, \n" +
			"      #{shrJcjl,jdbcType=VARCHAR},#{jcjl,jdbcType=VARCHAR}, #{jcsm,jdbcType=VARCHAR}, #{dydy1},#{dydy2}, #{dydyValue,jdbcType=DOUBLE}, \n" +
			"      #{dydyResult,jdbcType=TINYINT}, #{jdzk,jdbcType=DOUBLE}, #{jdzkValue,jdbcType=DOUBLE}, \n" +
			"      #{jdzkResult,jdbcType=TINYINT}, #{jyzk,jdbcType=DOUBLE}, #{jyzkValue,jdbcType=DOUBLE}, \n" +
			"      #{jyzkResult,jdbcType=TINYINT}, #{ddldlZc,jdbcType=DOUBLE}, #{ddldlZcZxValue,jdbcType=DOUBLE}, \n" +
			"      #{ddldlZcFxValue,jdbcType=DOUBLE}, #{ddldlZcResult,jdbcType=TINYINT}, #{ddldlDy,jdbcType=DOUBLE}, \n" +
			"      #{ddldlDyZxdlValue,jdbcType=DOUBLE}, #{ddldlDyFxdlValue,jdbcType=DOUBLE}, #{ddldlDyResult,jdbcType=TINYINT}, \n" +
			"      #{wkldlZc,jdbcType=DOUBLE}, #{wkldlZcZxValue,jdbcType=DOUBLE}, #{wkldlZcFxValue,jdbcType=DOUBLE}, \n" +
			"      #{wkldlZcResult,jdbcType=TINYINT}, #{wkldlDy,jdbcType=DOUBLE}, #{wkldlDyZxdlValue,jdbcType=DOUBLE}, \n" +
			"      #{wkldlDyZxddValue,jdbcType=DOUBLE}, #{wkldlDyFxdlValue,jdbcType=DOUBLE}, #{wkldlDyFxddValue,jdbcType=DOUBLE}, \n" +
			"      #{wkldlDyResult,jdbcType=TINYINT}, #{hzldlZcZxbfValue,jdbcType=DOUBLE}, #{hzldlZcFxbfValue,jdbcType=DOUBLE}, \n" +
			"      #{hzldlZcZxcfValue,jdbcType=DOUBLE}, #{hzldlZcFxcfValue,jdbcType=DOUBLE}, #{hzldlZcResult,jdbcType=TINYINT}, \n" +
			"      #{hzldlDyZxdlbfValue,jdbcType=DOUBLE}, #{hzldlDyZxddbfValue,jdbcType=DOUBLE}, #{hzldlDyFxdlbfValue,jdbcType=DOUBLE}, \n" +
			"      #{hzldlDyFxddbfValue,jdbcType=DOUBLE}, #{hzldlDyZxdlcfValue,jdbcType=DOUBLE}, #{hzldlDyZxddcfValue,jdbcType=DOUBLE}, \n" +
			"      #{hzldlDyFxdlcfValue,jdbcType=DOUBLE}, #{hzldlDyFxddcfValue,jdbcType=DOUBLE}, #{hzldlDyResult,jdbcType=TINYINT}, \n" +
			"      #{hzfzldlZcZxbfValue,jdbcType=DOUBLE}, #{hzfzldlZcFxbfValue,jdbcType=DOUBLE}, #{hzfzldlZcZxcfValue,jdbcType=DOUBLE}, \n" +
			"      #{hzfzldlZcFxcfValue,jdbcType=DOUBLE}, #{hzfzldlZcResult,jdbcType=TINYINT}, #{hzfzldlDyZxdlbfValue,jdbcType=DOUBLE}, \n" +
			"      #{hzfzldlDyZxddbfValue,jdbcType=DOUBLE}, #{hzfzldlDyFxdlbfValue,jdbcType=DOUBLE}, \n" +
			"      #{hzfzldlDyFxddbfValue,jdbcType=DOUBLE}, #{hzfzldlDyZxdlcfValue,jdbcType=DOUBLE}, \n" +
			"      #{hzfzldlDyZxddcfValue,jdbcType=DOUBLE}, #{hzfzldlDyFxdlcfValue,jdbcType=DOUBLE}, \n" +
			"      #{hzfzldlDyFxddcfValue,jdbcType=DOUBLE}, #{hzfzldlDyResult,jdbcType=TINYINT}, #{state,jdbcType=TINYINT}, \n" +
			"      #{spare2,jdbcType=TINYINT}, #{spare3,jdbcType=TINYINT}, #{spare4,jdbcType=TINYINT}, \n" +
			"      #{spare5,jdbcType=TINYINT})")
	@Options(useGeneratedKeys = true, keyProperty = "dqjcid", keyColumn = "dqjcid")
	public void save(Dqjc dqjc);

	//根据电气检测设备id查询设备检测表
	@Select("select dqjcid, jcyq_id, eq_id, tester, auditor,shsj_time,test_time, jcjl, jcsm, dydy1, dydy2,dydy_value, "
			+"dydy_result, jdzk, jdzk_value, jdzk_result, jyzk, jyzk_value, jyzk_result, ddldl_zc,            "
			+"ddldl_zc_zx_value, ddldl_zc_fx_value, ddldl_zc_result, ddldl_dy, ddldl_dy_zxdl_value,           "
			+"ddldl_dy_fxdl_value, ddldl_dy_result, wkldl_zc, wkldl_zc_zx_value, wkldl_zc_fx_value,           "
			+"wkldl_zc_result, wkldl_dy, wkldl_dy_zxdl_value, wkldl_dy_zxdd_value, wkldl_dy_fxdl_value,       "
			+"wkldl_dy_fxdd_value, wkldl_dy_result, hzldl_zc_bf, hzldl_zc_cf, hzldl_zc_zx_value,              "
			+"hzldl_zc_fx_value, hzldl_zc_result, hzldl_dy_bf, hzldl_dy_cf, hzldl_dy_zxdl_value,              "
			+"hzldl_dy_zxdd_value, hzldl_dy_fxdl_value, hzldl_dy_fxdd_value, hzldl_dy_result, hzfzldl_zc_bf,  "
			+"hzfzldl_zc_cf, hzfzldl_zc_zx_value, hzfzldl_zc_fx_value, hzfzldl_zc_result, hzfzldl_dy_bf,      "
			+"hzfzldl_dy_cf, hzfzldl_dy_zxdl_value, hzfzldl_dy_zxdd_value, hzfzldl_dy_fxdl_value,             "
			+"hzfzldl_dy_fxdd_value, hzfzldl_dy_result, spare1, spare2, spare3, spare4, spare5 from dqjc order by dqjcid desc limit 1 where eq_id = '#{eqId}'")
	public Dqjc findDqjc(String eqId);

	//以id排序，查询最后一条记录
	@Select("select * from dqjc order by dqjcid desc limit 1")
	Dqjc find();

	//根据设备Id,检测仪器Id以及状态查询电器表查询最后一条记录
	@Select("select dqjc.* from dqjc where dqjc.eq_id=#{eqId} and dqjc.jcyq_id=#{jcyqId} order by test_time desc, dqjcid desc limit 1" )
	Dqjc findByEqIdandJcyqIdLast1(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

	//根据设备Id,检测仪器Id以及状态查询电器表
	@Select("select dqjc.* from dqjc where dqjc.eq_id=#{eqId} and dqjc.jcyq_id=#{jcyqId}" )
	List<Dqjc> findByEqIdandJcyqId(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

	//查询所有检测表数据信息
	@Select("select * from dqjc")
	List<Dqjc> findAll();

	/**
	 * 删除电器数据
	 */
	@Delete("delete from dqjc where eq_id=#{eqId} and jcyq_id=#{jcyqId}")
	void delete(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

	/**
	 * 根据iD状态查询
	 */
	@Select("select * from dqjc where dqjcid=#{dqjcid} and state=#{state}")
	Dqjc findByDqjcid(@Param("dqjcid") Integer dqjcid, @Param("state") Integer state);
	/*
	修改状态
	 */
	@Update("update dqjc set state=#{state} where dqjcid=#{dqjcid}")
	void updateState(@Param("dqjcid") Integer dqjcid, @Param("state") Integer state);
	//修改审核人意见
	@Update("update dqjc set shr_jcjl=#{shrJcjl},auditor=#{auditor},shsj_time=#{shsjTime} where dqjcid=#{dqjcid}")
	void updateShrJcjy(@Param("dqjcid") Integer dqjcid, @Param("shrJcjl") String shrJcjl, @Param("auditor") String auditor, @Param("shsjTime") Date shsjTime);

	//TODO 电器更新
	@Update("update dqjc set jcyq_id = #{jcyqId,jdbcType=INTEGER},\n" +
			"      eq_id = #{eqId,jdbcType=INTEGER},\n" +
			"      tester = #{tester,jdbcType=VARCHAR},\n" +
			"      test_time = #{testTime,jdbcType=TIMESTAMP},\n" +
			"      auditor = #{auditor,jdbcType=VARCHAR},\n" +
			"      shsj_time = #{shsjTime,jdbcType=TIMESTAMP},\n" +
			"      shr_jcjl = #{shrJcjl,jdbcType=VARCHAR},\n" +
			"      jcjl = #{jcjl,jdbcType=VARCHAR},\n" +
			"      jcsm = #{jcsm,jdbcType=VARCHAR},\n" +
			"      dydy1 = #{dydy1,jdbcType=INTEGER},\n" +
			"      dydy2 = #{dydy2,jdbcType=INTEGER},\n" +
			"      dydy_value = #{dydyValue,jdbcType=VARCHAR},\n" +
			"      dydy_result = #{dydyResult,jdbcType=TINYINT},\n" +
			"      jdzk = #{jdzk,jdbcType=DOUBLE},\n" +
			"      jdzk_value = #{jdzkValue,jdbcType=DOUBLE},\n" +
			"      jdzk_result = #{jdzkResult,jdbcType=TINYINT},\n" +
			"      jyzk = #{jyzk,jdbcType=DOUBLE},\n" +
			"      jyzk_value = #{jyzkValue,jdbcType=DOUBLE},\n" +
			"      jyzk_result = #{jyzkResult,jdbcType=TINYINT},\n" +
			"      ddldl_zc = #{ddldlZc,jdbcType=DOUBLE},\n" +
			"      ddldl_zc_zx_value = #{ddldlZcZxValue,jdbcType=DOUBLE},\n" +
			"      ddldl_zc_fx_value = #{ddldlZcFxValue,jdbcType=DOUBLE},\n" +
			"      ddldl_zc_result = #{ddldlZcResult,jdbcType=TINYINT},\n" +
			"      ddldl_dy = #{ddldlDy,jdbcType=DOUBLE},\n" +
			"      ddldl_dy_zxdl_value = #{ddldlDyZxdlValue,jdbcType=DOUBLE},\n" +
			"      ddldl_dy_fxdl_value = #{ddldlDyFxdlValue,jdbcType=DOUBLE},\n" +
			"      ddldl_dy_result = #{ddldlDyResult,jdbcType=TINYINT},\n" +
			"      wkldl_zc = #{wkldlZc,jdbcType=DOUBLE},\n" +
			"      wkldl_zc_zx_value = #{wkldlZcZxValue,jdbcType=DOUBLE},\n" +
			"      wkldl_zc_fx_value = #{wkldlZcFxValue,jdbcType=DOUBLE},\n" +
			"      wkldl_zc_result = #{wkldlZcResult,jdbcType=TINYINT},\n" +
			"      wkldl_dy = #{wkldlDy,jdbcType=DOUBLE},\n" +
			"      wkldl_dy_zxdl_value = #{wkldlDyZxdlValue,jdbcType=DOUBLE},\n" +
			"      wkldl_dy_zxdd_value = #{wkldlDyZxddValue,jdbcType=DOUBLE},\n" +
			"      wkldl_dy_fxdl_value = #{wkldlDyFxdlValue,jdbcType=DOUBLE},\n" +
			"      wkldl_dy_fxdd_value = #{wkldlDyFxddValue,jdbcType=DOUBLE},\n" +
			"      wkldl_dy_result = #{wkldlDyResult,jdbcType=TINYINT},\n" +
			"      hzldl_zc_zxbf_value = #{hzldlZcZxbfValue,jdbcType=DOUBLE},\n" +
			"      hzldl_zc_fxbf_value = #{hzldlZcFxbfValue,jdbcType=DOUBLE},\n" +
			"      hzldl_zc_zxcf_value = #{hzldlZcZxcfValue,jdbcType=DOUBLE},\n" +
			"      hzldl_zc_fxcf_value = #{hzldlZcFxcfValue,jdbcType=DOUBLE},\n" +
			"      hzldl_zc_result = #{hzldlZcResult,jdbcType=TINYINT},\n" +
			"      hzldl_dy_zxdlbf_value = #{hzldlDyZxdlbfValue,jdbcType=DOUBLE},\n" +
			"      hzldl_dy_zxddbf_value = #{hzldlDyZxddbfValue,jdbcType=DOUBLE},\n" +
			"      hzldl_dy_fxdlbf_value = #{hzldlDyFxdlbfValue,jdbcType=DOUBLE},\n" +
			"      hzldl_dy_fxddbf_value = #{hzldlDyFxddbfValue,jdbcType=DOUBLE},\n" +
			"      hzldl_dy_zxdlcf_value = #{hzldlDyZxdlcfValue,jdbcType=DOUBLE},\n" +
			"      hzldl_dy_zxddcf_value = #{hzldlDyZxddcfValue,jdbcType=DOUBLE},\n" +
			"      hzldl_dy_fxdlcf_value = #{hzldlDyFxdlcfValue,jdbcType=DOUBLE},\n" +
			"      hzldl_dy_fxddcf_value = #{hzldlDyFxddcfValue,jdbcType=DOUBLE},\n" +
			"      hzldl_dy_result = #{hzldlDyResult,jdbcType=TINYINT},\n" +
			"      hzfzldl_zc_zxbf_value = #{hzfzldlZcZxbfValue,jdbcType=DOUBLE},\n" +
			"      hzfzldl_zc_fxbf_value = #{hzfzldlZcFxbfValue,jdbcType=DOUBLE},\n" +
			"      hzfzldl_zc_zxcf_value = #{hzfzldlZcZxcfValue,jdbcType=DOUBLE},\n" +
			"      hzfzldl_zc_fxcf_value = #{hzfzldlZcFxcfValue,jdbcType=DOUBLE},\n" +
			"      hzfzldl_zc_result = #{hzfzldlZcResult,jdbcType=TINYINT},\n" +
			"      hzfzldl_dy_zxdlbf_value = #{hzfzldlDyZxdlbfValue,jdbcType=DOUBLE},\n" +
			"      hzfzldl_dy_zxddbf_value = #{hzfzldlDyZxddbfValue,jdbcType=DOUBLE},\n" +
			"      hzfzldl_dy_fxdlbf_value = #{hzfzldlDyFxdlbfValue,jdbcType=DOUBLE},\n" +
			"      hzfzldl_dy_fxddbf_value = #{hzfzldlDyFxddbfValue,jdbcType=DOUBLE},\n" +
			"      hzfzldl_dy_zxdlcf_value = #{hzfzldlDyZxdlcfValue,jdbcType=DOUBLE},\n" +
			"      hzfzldl_dy_zxddcf_value = #{hzfzldlDyZxddcfValue,jdbcType=DOUBLE},\n" +
			"      hzfzldl_dy_fxdlcf_value = #{hzfzldlDyFxdlcfValue,jdbcType=DOUBLE},\n" +
			"      hzfzldl_dy_fxddcf_value = #{hzfzldlDyFxddcfValue,jdbcType=DOUBLE},\n" +
			"      hzfzldl_dy_result = #{hzfzldlDyResult,jdbcType=TINYINT},\n" +
			"      state = #{state,jdbcType=INTEGER},\n" +
			"      shsj = #{shsj,jdbcType=DATE},\n" +
			"      spare3 = #{spare3,jdbcType=TINYINT},\n" +
			"      spare4 = #{spare4,jdbcType=TINYINT},\n" +
			"      spare5 = #{spare5,jdbcType=TINYINT},\n" +
			"      spare2 = #{spare2,jdbcType=TINYINT} where dqjcid = #{dqjcid,jdbcType=INTEGER}")
    void updataDqjc(Dqjc dqjc);
}