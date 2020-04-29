package com.litbo.hospitalzj.supplier.mapper;

import com.litbo.hospitalzj.supplier.entity.EqInfo;
import com.litbo.hospitalzj.supplier.entity.HtInfo;
import com.litbo.hospitalzj.supplier.vo.SelHtEqVo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Mapper
public interface EqInfoMapper {
	/*@Insert({
		 "<script>",
		 "insert into eq_Info (eq_id,ht_ids,eq_pm,eq_gg,"
		 + "eq_xh,eq_jldw_id,eq_price,eq_zczbh,eq_scbh,eq_num,eq_totalprice,"
		 + "eq_ccdate,eq_cscs,eq_gb,eq_bgbh,eq_sh_fws,eq_sh_qddh,eq_sh_shjl,"
		 + "eq_sh_jldh,eq_sh_fwr,eq_sh_lxr,eq_sh_lxrdh,eq_state,eq_yzm,"
		 + "eq_sh_jlsb,eq_sh_fssb) values ",
		 "<foreach collection='eqInfos' item='item' index='index' separator=','>",
		 "(#{item.eqId},#{item.htIds},#{item.eqPm},#{item.eqGg},#{item.eqXh},#{item.eqJldwId},#{item.eqPrice},#{item.eqZczbh},"
		 + "#{item.eqScbh},#{item.eqNum},#{item.eqTotalprice},#{item.eqCcdate},"
		 + "#{item.eqCscs},#{item.eqGb},#{item.eqBgbh},#{item.eqShFws},#{item.eqShQddh},"
		 + "#{item.eqShShjl},#{item.eqShJldh},#{item.eqShFwr},"
		 + "#{item.eqShLxr},#{item.eqShLxrdh},#{item.eqState},#{item.eqYzm},#{item.eqShFssb},"
		 + "#{item.eqShFssb})",
		 "</foreach>",
		 "</script>"
		})
		int insertEqInfoList(@Param(value="eqInfos") List<EqInfo>  eqInfo);*/
	
	@Insert("insert into eq_info (eq_id, eq_mc, eq_dah, \n" +
			"      eq_pm_id, eq_xh, eq_jldw_id, \n" +
			"      eq_azdd, eq_bxq, eq_yt, \n" +
			"      eq_price, eq_zczbh, eq_scbh, \n" +
			"      eq_num, eq_totalprice, eq_ccdate, \n" +
			"      eq_cscs, eq_gb, eq_bgbh, \n" +
			"      eq_sh_fws, eq_sh_qddh, eq_sh_shjl, \n" +
			"      eq_sh_jldh, eq_sh_lxr, eq_sh_lxrdh, \n" +
			"      eq_state, eq_yzm, ht_ids, \n" +
			"      eq_sh_lb, eq_syks, eq_jx, \n" +
			"      eq_qyrq, eq_cfdd, eq_bfjd,eq_qk\n" +
			"      )\n" +
			"    values (#{eqId,jdbcType=INTEGER}, #{eqMc,jdbcType=VARCHAR}, #{eqDah,jdbcType=VARCHAR}, \n" +
			"      #{eqPmId,jdbcType=VARCHAR}, #{eqXh,jdbcType=VARCHAR}, #{eqJldwId,jdbcType=VARCHAR}, \n" +
			"      #{eqAzdd,jdbcType=VARCHAR}, #{eqBxq,jdbcType=VARCHAR}, #{eqYt,jdbcType=VARCHAR}, \n" +
			"      #{eqPrice,jdbcType=DECIMAL}, #{eqZczbh,jdbcType=VARCHAR}, #{eqScbh,jdbcType=VARCHAR}, \n" +
			"      #{eqNum,jdbcType=VARCHAR}, #{eqTotalprice,jdbcType=VARCHAR}, #{eqCcdate,jdbcType=VARCHAR}, \n" +
			"      #{eqCscs,jdbcType=VARCHAR}, #{eqGb,jdbcType=VARCHAR}, #{eqBgbh,jdbcType=VARCHAR}, \n" +
			"      #{eqShFws,jdbcType=VARCHAR}, #{eqShQddh,jdbcType=VARCHAR}, #{eqShShjl,jdbcType=VARCHAR}, \n" +
			"      #{eqShJldh,jdbcType=VARCHAR}, #{eqShLxr,jdbcType=VARCHAR}, #{eqShLxrdh,jdbcType=VARCHAR}, \n" +
			"      #{eqState,jdbcType=INTEGER}, #{eqYzm,jdbcType=VARCHAR}, #{htIds,jdbcType=INTEGER}, \n" +
			"      #{eqShLb,jdbcType=VARCHAR}, #{eqSyks,jdbcType=VARCHAR}, #{eqJx,jdbcType=VARCHAR}, \n" +
			"      #{eqQyrq,jdbcType=VARCHAR}, #{eqCfdd,jdbcType=VARCHAR}, #{eqBfjd,jdbcType=VARCHAR},\n" +
			"      #{eqQk})")
	@Options(useGeneratedKeys = true, keyProperty = "eqId", keyColumn = "eq_id")
	Integer insertEqInfo(EqInfo eqInfo);
	
	@Select("select * from eq_info where ht_ids=#{htIds}")
	List<EqInfo> selectEqinfo(Integer htIds);

	@Select("select eq_id from eq_info order by eq_id desc limit 1")
	Integer lastId();
	@Select("select ht_ids htIds from eq_info where eq_id=#{eqId}")
	Integer selectHtId(Integer eqId);
	@Select("select ht_ids htIds from eq_info where eq_mc=#{eqMc}")
	EqInfo selectByName(String eqMc);
	@Select("select IFNULL(ht_hthao,'无') htHthao,IFNULL(ht_gzspd,'无') htGzspd," +
			"eq_id, eq_mc, eq_dah, \n"+
			"      eq_pm_id, eq_xh, eq_jldw_id, \n" +
			"      eq_azdd, eq_bxq, eq_yt, \n" +
			"      eq_price, eq_zczbh, eq_scbh, \n" +
			"      eq_num, eq_totalprice, eq_ccdate, \n" +
			"      eq_cscs, eq_gb, eq_bgbh, \n" +
			"      eq_sh_fws, eq_sh_qddh, eq_sh_shjl, \n" +
			"      eq_sh_jldh, eq_sh_lxr, eq_sh_lxrdh, \n" +
			"      eq_state, eq_yzm, ht_ids, \n" +
			"      eq_sh_lb, eq_syks, eq_jx, \n" +
			"      eq_qyrq, eq_cfdd, eq_bfjd"+
			" from eq_info e left join ht_info h on e.ht_ids=h.ht_id where ht_ids=#{htIds}"
			)
	List<SelHtEqVo> selectEqHtVo(Integer htIds);
	@Update(" update eq_info\n" +
			"    set eq_mc = #{eqMc,jdbcType=VARCHAR},\n" +
			"      eq_dah = #{eqDah,jdbcType=VARCHAR},\n" +
			"      eq_pm_id = #{eqPmId,jdbcType=VARCHAR},\n" +
			"      eq_xh = #{eqXh,jdbcType=VARCHAR},\n" +
			"      eq_jldw_id = #{eqJldwId,jdbcType=VARCHAR},\n" +
			"      eq_azdd = #{eqAzdd,jdbcType=VARCHAR},\n" +
			"      eq_bxq = #{eqBxq,jdbcType=VARCHAR},\n" +
			"      eq_yt = #{eqYt,jdbcType=VARCHAR},\n" +
			"      eq_price = #{eqPrice,jdbcType=DECIMAL},\n" +
			"      eq_zczbh = #{eqZczbh,jdbcType=VARCHAR},\n" +
			"      eq_scbh = #{eqScbh,jdbcType=VARCHAR},\n" +
			"      eq_num = #{eqNum,jdbcType=VARCHAR},\n" +
			"      eq_totalprice = #{eqTotalprice,jdbcType=VARCHAR},\n" +
			"      eq_ccdate = #{eqCcdate,jdbcType=VARCHAR},\n" +
			"      eq_cscs = #{eqCscs,jdbcType=VARCHAR},\n" +
			"      eq_gb = #{eqGb,jdbcType=VARCHAR},\n" +
			"      eq_bgbh = #{eqBgbh,jdbcType=VARCHAR},\n" +
			"      eq_sh_fws = #{eqShFws,jdbcType=VARCHAR},\n" +
			"      eq_sh_qddh = #{eqShQddh,jdbcType=VARCHAR},\n" +
			"      eq_sh_shjl = #{eqShShjl,jdbcType=VARCHAR},\n" +
			"      eq_sh_jldh = #{eqShJldh,jdbcType=VARCHAR},\n" +
			"      eq_sh_lxr = #{eqShLxr,jdbcType=VARCHAR},\n" +
			"      eq_sh_lxrdh = #{eqShLxrdh,jdbcType=VARCHAR},\n" +
			"      eq_state = #{eqState,jdbcType=INTEGER},\n" +
			"      eq_yzm = #{eqYzm,jdbcType=VARCHAR},\n" +
			"      ht_ids = #{htIds,jdbcType=INTEGER},\n" +
			"      eq_sh_lb = #{eqShLb,jdbcType=VARCHAR},\n" +
			"      eq_syks = #{eqSyks,jdbcType=VARCHAR},\n" +
			"      eq_jx = #{eqJx,jdbcType=VARCHAR},\n" +
			"      eq_qyrq = #{eqQyrq,jdbcType=VARCHAR},\n" +
			"      eq_cfdd = #{eqCfdd,jdbcType=VARCHAR},\n" +
			"      eq_bfjd = #{eqBfjd,jdbcType=VARCHAR},\n" +
			"	   eq_qk = #{eqQk,jdbcType=VARCHAR}" +
			" where eq_id = #{eqId,jdbcType=INTEGER}")
	Integer updateInfo(EqInfo eqinfo);

	@Update("update eq_info set eq_state = 1 where ht_ids=#{htIds,jdbcType=INTEGER}")
	Integer update(Integer htIds);

	@Select("select * from eq_info where eq_state=1")
	List<EqInfo> selectByState();
	@Select("select * from eq_info where eq_id=#{eqId}")
	EqInfo selectByEqId(Integer eqId);
	@Delete("delete from eq_info where eq_id=#{eqId}")
	Integer delete(Integer eqId);
	/**
	 * 维修设备模块
	 * @return
	 */
	//查询维修设备
	@Select("select * from eq_info where eq_state=3")
	List<EqInfo> findWXEqInfo();
	
	/**
	 * 新设备模块
	 * @return
	 */
	//全部新设备信息
	@Select("select * from eq_info where eq_dah='' and eq_state=0")
	List<EqInfo> newEqInfo();
	//已分配的设备
	@Select("SELECT * FROM eq_info WHERE eq_state=#{eqState} and eq_id IN(SELECT jc_eqid FROM user_eq)")
	List<EqInfo> eqInfoYfp(Integer eqState);
	//未分配的设备
	@Select("SELECT * FROM eq_info WHERE eq_state=#{eqState} and eq_id not IN(SELECT jc_eqid FROM user_eq)")
	List<EqInfo> eqInfoWfp(Integer eqState);
	//未分配的设备数量
	@Select("SELECT count(*) FROM eq_info WHERE eq_state=#{eqState} and eq_id not IN(SELECT jc_eqid FROM user_eq)")
	Integer countWfp(Integer eqState);
	//查询已分配到人的设备
	@Select("SELECT * FROM eq_info e left join user_eq u on e.eq_id =u.jc_eqid WHERE eq_state=#{eqState} and u.user_id=#{userId}")
	List<EqInfo> findByUserIdEqInfo(@Param("eqState") Integer eqState, @Param("userId") String userId);
	//查询已分配到人的新设备数量
	@Select("SELECT count(*) FROM eq_info e left join user_eq u on e.eq_id =u.jc_eqid WHERE eq_state=#{eqState} and u.user_id=#{userId}")
	Integer findByUserIdEqInfoCount(@Param("eqState") Integer eqState, @Param("userId") String userId);
	//修改设备情况
	@Update("update eq_info set eq_qk = #{eqQk} where eq_id=#{eqId}")
	Integer updateEqQk(@Param("eqId") Integer eqId, @Param("eqQk") String eqQk);
	@Select("select * from eq_info where eq_qk=#{eqQk}")
	List<EqInfo> findByEqQk(String eqQk);


	@Insert("insert into eq_info (eq_id, eq_mc, eq_dah, \n" +
			"      eq_pm_id, eq_xh, eq_jldw_id, \n" +
			"      eq_azdd, eq_bxq, eq_yt, \n" +
			"      eq_price, eq_zczbh, eq_scbh, \n" +
			"      eq_num, eq_totalprice, eq_ccdate, \n" +
			"      eq_cscs, eq_gb, eq_bgbh, \n" +
			"      eq_sh_fws, eq_sh_qddh, eq_sh_shjl, \n" +
			"      eq_sh_jldh, eq_sh_lxr, eq_sh_lxrdh, \n" +
			"      eq_state, eq_yzm, ht_ids, \n" +
			"      eq_sh_lb, eq_syks, eq_jx, \n" +
			"      eq_qyrq, eq_cfdd, eq_bfjd,eq_qk\n" +
			"      )\n" +
			"    values (#{eqId,jdbcType=INTEGER}, #{eqMc,jdbcType=VARCHAR}, #{eqDah,jdbcType=VARCHAR}, \n" +
			"      #{eqPmId,jdbcType=VARCHAR}, #{eqXh,jdbcType=VARCHAR}, #{eqJldwId,jdbcType=VARCHAR}, \n" +
			"      #{eqAzdd,jdbcType=VARCHAR}, #{eqBxq,jdbcType=VARCHAR}, #{eqYt,jdbcType=VARCHAR}, \n" +
			"      #{eqPrice,jdbcType=DECIMAL}, #{eqZczbh,jdbcType=VARCHAR}, #{eqScbh,jdbcType=VARCHAR}, \n" +
			"      #{eqNum,jdbcType=VARCHAR}, #{eqTotalprice,jdbcType=VARCHAR}, #{eqCcdate,jdbcType=VARCHAR}, \n" +
			"      #{eqCscs,jdbcType=VARCHAR}, #{eqGb,jdbcType=VARCHAR}, #{eqBgbh,jdbcType=VARCHAR}, \n" +
			"      #{eqShFws,jdbcType=VARCHAR}, #{eqShQddh,jdbcType=VARCHAR}, #{eqShShjl,jdbcType=VARCHAR}, \n" +
			"      #{eqShJldh,jdbcType=VARCHAR}, #{eqShLxr,jdbcType=VARCHAR}, #{eqShLxrdh,jdbcType=VARCHAR}, \n" +
			"      #{eqState,jdbcType=INTEGER}, #{eqYzm,jdbcType=VARCHAR}, #{htIds,jdbcType=INTEGER}, \n" +
			"      #{eqShLb,jdbcType=VARCHAR}, #{eqSyks,jdbcType=VARCHAR}, #{eqJx,jdbcType=VARCHAR}, \n" +
			"      #{eqQyrq,jdbcType=VARCHAR}, #{eqCfdd,jdbcType=VARCHAR}, #{eqBfjd,jdbcType=VARCHAR},\n" +
			"      #{eqQk})")
	void InsertBatEqInfo(EqInfo eqInfo);


	@Select("select eq_id, eq_mc, eq_dah," +
            "      eq_pm_id, eq_xh, eq_jldw_id, " +
            "      eq_azdd, eq_bxq, eq_yt," +
            "      eq_price, eq_zczbh, eq_scbh," +
            "      count(*) as eq_num, eq_totalprice, eq_ccdate," +
            "      eq_cscs, eq_gb, eq_bgbh, " +
            "      eq_sh_fws, eq_sh_qddh, eq_sh_shjl, " +
            "      eq_sh_jldh, eq_sh_lxr, eq_sh_lxrdh, " +
            "      eq_state, eq_yzm, ht_ids," +
            "      eq_sh_lb, eq_syks, eq_jx," +
            "      eq_qyrq, eq_cfdd, eq_bfjd " +
            " FROM eq_info e LEFT JOIN ht_info h ON e.ht_ids=h.ht_id WHERE e.ht_ids= #{htIds} GROUP BY e.eq_mc, e.eq_xh")
	List<SelHtEqVo> selectGroupEqHtVo(Integer htIds);

	@Select("select eq_ccdate, eq_scbh from eq_info where eq_mc=#{eqMc} and eq_xh=#{eqXh} and ht_ids = #{htIds}")
	List<SelHtEqVo> selectRq(@Param("eqMc") String eqMc, @Param("eqXh") String eqXh, @Param("htIds") Integer htIds);

	@Delete("delete from eq_info where eq_mc=#{eqMc} and eq_xh=#{eqXh} and ht_ids =#{htIds} ")
	void deleteBat(@Param("eqMc") String eqMc,@Param("eqXh") String eqXh,@Param("htIds") Integer htIds);
}
