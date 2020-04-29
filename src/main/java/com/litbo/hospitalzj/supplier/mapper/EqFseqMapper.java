package com.litbo.hospitalzj.supplier.mapper;

import com.litbo.hospitalzj.supplier.entity.EqFseq;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EqFseqMapper {
	/*@Insert(
		 "insert into eq_fj(eq_fjid,eq_ids,eq_fjmc,eq_fjxh,eq_fjsl,eq_fjdw,eq_fjsccs,eq_fjccbh,bz) values "
		 + "<foreach collection='eqFjs' item='item' open='(' close=')' index='index' separator=','> "
		 + "(#{item.eqFjId},#{item.eqIds},#{item.eqFjmc},#{item.eqFjxh},#{item.eqFjsl},"
		 + "#{item.eqFjdw},#{item.eqFjsccs},#{item.eqFjccbh},#{item.bz})"
		 + "</foreach>")
		int insertCollectList(@Param(value = "eqFjs") List<EqFj> eqFjs);*/
	@Insert("insert into eq_fseq (eq_fsid, eq_ids, eq_mc, \n" +
			"      eq_dah, eq_pm_id, \n" +
			"      eq_xh, eq_jldw_id, eq_azdd, \n" +
			"      eq_bxq, eq_yt, eq_price, \n" +
			"      eq_zczbh, eq_scbh, eq_num, \n" +
			"      eq_totalprice, eq_ccdate, eq_cscs, \n" +
			"      eq_gb, eq_bgbh, eq_sh_fws, \n" +
			"      eq_sh_qddh, eq_sh_shjl, eq_sh_jldh, \n" +
			"      eq_sh_lxr, eq_sh_lxrdh, eq_state, \n" +
			"      eq_yzm, eq_sh_lb, ht_ids, \n" +
			"      eq_syks, eq_jx, eq_qyrq, \n" +
			"      eq_cfdd, eq_bfjd)\n" +
			"    values (#{eqFsid,jdbcType=INTEGER}, #{eqIds,jdbcType=VARCHAR}, #{eqMc,jdbcType=VARCHAR}, \n" +
			"      #{eqDah,jdbcType=VARCHAR}, #{eqPmId,jdbcType=VARCHAR},\n" +
			"      #{eqXh,jdbcType=VARCHAR}, #{eqJldwId,jdbcType=VARCHAR}, #{eqAzdd,jdbcType=VARCHAR}, \n" +
			"      #{eqBxq,jdbcType=VARCHAR}, #{eqYt,jdbcType=VARCHAR}, #{eqPrice,jdbcType=DECIMAL}, \n" +
			"      #{eqZczbh,jdbcType=VARCHAR}, #{eqScbh,jdbcType=VARCHAR}, #{eqNum,jdbcType=VARCHAR}, \n" +
			"      #{eqTotalprice,jdbcType=VARCHAR}, #{eqCcdate,jdbcType=VARCHAR}, #{eqCscs,jdbcType=VARCHAR}, \n" +
			"      #{eqGb,jdbcType=VARCHAR}, #{eqBgbh,jdbcType=VARCHAR}, #{eqShFws,jdbcType=VARCHAR}, \n" +
			"      #{eqShQddh,jdbcType=VARCHAR}, #{eqShShjl,jdbcType=VARCHAR}, #{eqShJldh,jdbcType=VARCHAR}, \n" +
			"      #{eqShLxr,jdbcType=VARCHAR}, #{eqShLxrdh,jdbcType=VARCHAR}, #{eqState,jdbcType=INTEGER}, \n" +
			"      #{eqYzm,jdbcType=VARCHAR}, #{eqShLb,jdbcType=VARCHAR}, #{htIds,jdbcType=INTEGER}, \n" +
			"      #{eqSyks,jdbcType=VARCHAR}, #{eqJx,jdbcType=VARCHAR}, #{eqQyrq,jdbcType=VARCHAR}, \n" +
			"      #{eqCfdd,jdbcType=VARCHAR}, #{eqBfjd,jdbcType=VARCHAR})")
	Integer insertEqFseq(EqFseq eqFseq);
	
	@Select("select * from eq_fseq where eq_ids=#{eqIds}")
	List<EqFseq> selectEqFseq(Integer eqIds);

	@Update(" update eq_fseq\n" +
			"    set eq_ids = #{eqIds,jdbcType=VARCHAR},\n" +
			"      eq_mc = #{eqMc,jdbcType=VARCHAR},\n" +
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
			"      eq_sh_lb = #{eqShLb,jdbcType=VARCHAR},\n" +
			"      ht_ids = #{htIds,jdbcType=INTEGER},\n" +
			"      eq_syks = #{eqSyks,jdbcType=VARCHAR},\n" +
			"      eq_jx = #{eqJx,jdbcType=VARCHAR},\n" +
			"      eq_qyrq = #{eqQyrq,jdbcType=VARCHAR},\n" +
			"      eq_cfdd = #{eqCfdd,jdbcType=VARCHAR},\n" +
			"      eq_bfjd = #{eqBfjd,jdbcType=VARCHAR}\n" +
			"    where eq_id = #{eqId,jdbcType=INTEGER}")
	Integer updateInfo(EqFseq eqFseq);
	@Select("select * from eq_fseq where eq_fsid=#{eqFsid}")
	EqFseq selectById(Integer eqFsid);
	@Delete("delete from eq_fseq where eq_fsid=#{eqFsid}")
	Integer delete(Integer eqFsid);

	@Select("select * from eq_fseq where eq_ids = #{eqIds} group by eq_mc, eq_xh")
    List<EqFseq> selectEqFjGroup(Integer eqIds);

    @Select("select eq_ccdate, eq_scbh from eq_fseq where eq_mc=#{eqMc} and eq_xh=#{eqXh} and eq_ids =#{eqIds}")
	List<EqFseq> selectEqFjByRq(@Param("eqMc") String eqMc,@Param("eqXh") String eqXh, @Param("eqIds") String eqIds);

    @Delete("delete from eq_fseq where eq_ids = #{eqIds} and eq_mc = #{eqMc} and eq_xh = #{eqXh}")
	void deleteBat(@Param("eqIds") String eqIds, @Param("eqMc") String eqMc,@Param("eqXh") String eqXh);

    @Delete("delete from eq_fseq where eq_ids = #{eqId}")
	void deleteByEqId(Integer eqId);




	@Update(" update eq_fseq\n" +
			"    set eq_ids = #{eqIds,jdbcType=VARCHAR},\n" +
			"      eq_mc = #{eqMc,jdbcType=VARCHAR},\n" +
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
			"      eq_sh_lb = #{eqShLb,jdbcType=VARCHAR},\n" +
			"      ht_ids = #{htIds,jdbcType=INTEGER},\n" +
			"      eq_syks = #{eqSyks,jdbcType=VARCHAR},\n" +
			"      eq_jx = #{eqJx,jdbcType=VARCHAR},\n" +
			"      eq_qyrq = #{eqQyrq,jdbcType=VARCHAR},\n" +
			"      eq_cfdd = #{eqCfdd,jdbcType=VARCHAR},\n" +
			"      eq_bfjd = #{eqBfjd,jdbcType=VARCHAR}\n" +
			"    where eq_fsid = #{eqFsid,jdbcType=INTEGER}")
	Integer update(EqFseq eqFseq);




	@Select("select * from eq_fseq where eq_ids=#{eqIds} and eq_mc=#{eqMc} and eq_xh = #{eqXh}")
	List<EqFseq> selectByMcAndXh(@Param("eqIds") Integer eqIds, @Param("eqMc")String eqMc, @Param("eqXh")String eqXh);
}
