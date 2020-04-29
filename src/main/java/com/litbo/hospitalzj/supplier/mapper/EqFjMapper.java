package com.litbo.hospitalzj.supplier.mapper;

import com.litbo.hospitalzj.supplier.entity.EqFj;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EqFjMapper {
	/*@Insert(
		 "insert into eq_fj(eq_fjid,eq_ids,eq_fjmc,eq_fjxh,eq_fjsl,eq_fjdw,eq_fjsccs,eq_fjccbh,bz) values "
		 + "<foreach collection='eqFjs' item='item' open='(' close=')' index='index' separator=','> "
		 + "(#{item.eqFjId},#{item.eqIds},#{item.eqFjmc},#{item.eqFjxh},#{item.eqFjsl},"
		 + "#{item.eqFjdw},#{item.eqFjsccs},#{item.eqFjccbh},#{item.bz})"
		 + "</foreach>")
		int insertCollectList(@Param(value = "eqFjs") List<EqFj> eqFjs);*/
	@Insert("insert into eq_fj(eq_fjid,eq_ids,eq_fjmc,eq_fjxh,eq_fjsl,eq_fjdw,eq_fjsccs,eq_fjccbh,bz, eq_fjccrq) values "
			+ "(#{eqFjId},#{eqIds},#{eqFjmc},#{eqFjxh},#{eqFjsl},#{eqFjdw},#{eqFjsccs},#{eqFjccbh},#{bz}, #{eqFjccrq})")
	Integer insertEqFj(EqFj eqfj);
	
	@Select("select eq_fjid as eqFjId,eq_ids as eqIds,eq_fjmc eqFjmc,eq_fjxh eqFjxh,eq_fjsl eqFjsl,eq_fjdw eqFjdw,eq_fjsccs eqFjsccs,eq_fjccbh eqFjccbh, eq_fjccrq eqFjccrq,bz from eq_fj where eq_ids=#{eqIds}")
	List<EqFj> selectEqFj(Integer eqIds);

	@Select("select eq_fjid as eqFjId,eq_ids as eqIds,eq_fjmc eqFjmc,eq_fjxh eqFjxh,eq_fjsl eqFjsl,eq_fjdw eqFjdw,eq_fjsccs eqFjsccs,eq_fjccbh eqFjccbh, eq_fjccrq eqFjccrq,bz from eq_fj where eq_ids=#{eqIds} " +
			" group by eq_fjmc, eq_fjxh")
	List<EqFj> selectEqFjGroup(Integer eqIds);

	@Select("select * from eq_fj where eq_fjid=#{eqFjId}")
	EqFj selectById(Integer eqFjId);
	@Update("update eq_fj set eq_fjmc=#{eqFjmc}, eq_fjxh=#{eqFjxh},eq_fjsl=#{eqFjsl},eq_fjdw=#{eqFjdw},"
			+ "eq_fjsccs=#{eqFjsccs},eq_fjccbh=#{eqFjccbh},bz=#{bz} where eq_fjmc=#{eqFjmc}")
	Integer updataInfo(EqFj eqfj);


	@Update("update eq_fj set eq_fjmc=#{eqFjmc}, eq_fjxh=#{eqFjxh},eq_fjsl=#{eqFjsl},eq_fjdw=#{eqFjdw},"
			+ "eq_fjsccs=#{eqFjsccs},eq_fjccbh=#{eqFjccbh},bz=#{bz}, eq_fjccrq=#{eqFjccrqe} where eq_fjid=#{eqFjId}")
	Integer updata(EqFj eqfj);

	@Delete("delete from eq_fj where eq_fjid=#{eqFjid}")
	Integer delete(Integer eqFjid);

	@Select("select * from eq_fj where eq_fjmc = #{eqFjmc} and eq_fjxh=#{eqFjxh} and eq_ids=#{eqIds}")
	List<EqFj> selectEqFjByRq(@Param("eqFjmc") String eqFjmc, @Param("eqFjxh") String eqFjxh, @Param("eqIds") Integer eqIds);

	@Delete("delete from eq_fj where eq_ids = #{eqIds} and eq_fjmc = #{eqFjmc} and eq_fjxh = #{eqFjxh}")
	void deleteBat(@Param("eqIds") Integer eqIds, @Param("eqFjmc")String eqFjmc, @Param("eqFjxh")String eqFjxh);

	@Delete("delete from eq_fj where eq_ids = #{eqId}")
	void deleteByEqId(Integer eqId);

	@Select("select * from eq_fj where eq_ids=#{eqIds} and eq_fjmc=#{eqFjmc} and eq_fjxh=#{eqFjxh}")
	List<EqFj> selectBxyMcAndXh(@Param("eqIds") Integer eqIds, @Param("eqFjmc") String eqFjmc, @Param("eqFjxh") String eqFjxh);
}
