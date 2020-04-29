package com.litbo.hospitalzj.supplier.mapper;

import com.litbo.hospitalzj.supplier.entity.SgdjHw;
import org.apache.ibatis.annotations.*;

@Mapper
public interface SgdjHwMapper {
	@Insert("insert into sg_djhw (djhw_id, ht_ids, djhw_wbz, \n" +
			"      djhw_ysbs, djhw_sbwg, djhw_sxwj, \n" +
			"      djhw_bzxx, djhw_txxx, djhw_zxxx, \n" +
			"      djhw_mxxx, djhw_hgzxx, djhw_gpxx, \n" +
			"      djhw_czsmxx, djhw_wxscxx, djhw_sbylxx, \n" +
			"      djhw_bz, djhw_bz11, djhw_bz12, \n" +
			"      djhw_bz13, djhw_bz14, djhw_bz15, \n" +
			"      djhw_bz16, djhw_url)\n" +
			"    values (#{djhwId,jdbcType=INTEGER}, #{htIds,jdbcType=INTEGER}, #{djhwWbz,jdbcType=VARCHAR}, \n" +
			"      #{djhwYsbs,jdbcType=VARCHAR}, #{djhwSbwg,jdbcType=VARCHAR}, #{djhwSxwj,jdbcType=VARCHAR}, \n" +
			"      #{djhwBzxx,jdbcType=VARCHAR}, #{djhwTxxx,jdbcType=VARCHAR}, #{djhwZxxx,jdbcType=VARCHAR}, \n" +
			"      #{djhwMxxx,jdbcType=VARCHAR}, #{djhwHgzxx,jdbcType=VARCHAR}, #{djhwGpxx,jdbcType=VARCHAR}, \n" +
			"      #{djhwCzsmxx,jdbcType=VARCHAR}, #{djhwWxscxx,jdbcType=VARCHAR}, #{djhwSbylxx,jdbcType=VARCHAR}, \n" +
			"      #{djhwBz,jdbcType=VARCHAR}, #{djhwBz11,jdbcType=VARCHAR}, #{djhwBz12,jdbcType=VARCHAR}, \n" +
			"      #{djhwBz13,jdbcType=VARCHAR}, #{djhwBz14,jdbcType=VARCHAR}, #{djhwBz15,jdbcType=VARCHAR}, \n" +
			"      #{djhwBz16,jdbcType=VARCHAR}, #{djhwUrl,jdbcType=VARCHAR})")
	Integer insertSgdjHw(SgdjHw sgdjhw);
	
	@Select("select * from "
			+ "sg_djhw where ht_ids=#{htIds}")
	SgdjHw selectSgdjHw(Integer htIds);
	
	@Update(" update sg_djhw\n" +
			"    set ht_ids = #{htIds,jdbcType=INTEGER},\n" +
			"      djhw_wbz = #{djhwWbz,jdbcType=VARCHAR},\n" +
			"      djhw_ysbs = #{djhwYsbs,jdbcType=VARCHAR},\n" +
			"      djhw_sbwg = #{djhwSbwg,jdbcType=VARCHAR},\n" +
			"      djhw_sxwj = #{djhwSxwj,jdbcType=VARCHAR},\n" +
			"      djhw_bzxx = #{djhwBzxx,jdbcType=VARCHAR},\n" +
			"      djhw_txxx = #{djhwTxxx,jdbcType=VARCHAR},\n" +
			"      djhw_zxxx = #{djhwZxxx,jdbcType=VARCHAR},\n" +
			"      djhw_mxxx = #{djhwMxxx,jdbcType=VARCHAR},\n" +
			"      djhw_hgzxx = #{djhwHgzxx,jdbcType=VARCHAR},\n" +
			"      djhw_gpxx = #{djhwGpxx,jdbcType=VARCHAR},\n" +
			"      djhw_czsmxx = #{djhwCzsmxx,jdbcType=VARCHAR},\n" +
			"      djhw_wxscxx = #{djhwWxscxx,jdbcType=VARCHAR},\n" +
			"      djhw_sbylxx = #{djhwSbylxx,jdbcType=VARCHAR},\n" +
			"      djhw_bz = #{djhwBz,jdbcType=VARCHAR},\n" +
			"      djhw_bz11 = #{djhwBz11,jdbcType=VARCHAR},\n" +
			"      djhw_bz12 = #{djhwBz12,jdbcType=VARCHAR},\n" +
			"      djhw_bz13 = #{djhwBz13,jdbcType=VARCHAR},\n" +
			"      djhw_bz14 = #{djhwBz14,jdbcType=VARCHAR},\n" +
			"      djhw_bz15 = #{djhwBz15,jdbcType=VARCHAR},\n" +
			"      djhw_bz16 = #{djhwBz16,jdbcType=VARCHAR},\n" +
			"      djhw_url = #{djhwUrl,jdbcType=VARCHAR} where ht_ids=#{htIds}")
	Integer updateInfo(SgdjHw sgdjhw); 
	
	@Update("UPDATE sg_djhw SET djhw_bz1=#{djhwBz1},djhw_bz2=#{djhwBz2},djhw_bz3=#{djhwBz3},djhw_bz4=#{djhwBz4} where djhw_id=#{djhwId}")
	Integer updateOne(@Param("djhwId") Integer djhwId, @Param("htFile") String htFile);
	@Update("update sg_djhw set djhw_url = CONCAT(djhw_url,#{path}) where ht_ids = #{htIds}")
    int updateURL(@Param("htIds") Integer htIds, @Param("path") String path);

	@Update("update sg_djhw set djhw_bz1 = CONCAT(djhw_bz1,#{path}) where ht_ids = #{htIds}")
	int updateWjURL(@Param("htIds") Integer htIds, @Param("path") String path);

	@Select("select * from "
			+ "sg_djhw where ht_ids=#{htIds}")
	SgdjHw selectSgdjHwByHtIds(Integer htIds);
	@Select("select djhw_url from sg_djhw where ht_ids = #{htIds}")
	String showImages(Integer htIds);
	@Select("SELECT count(*) FROM sg_djhw s left join ht_info h on s.ht_ids=h.ht_id where h.ht_state=#{htState}")
	int count(String htState);
}
