package com.litbo.hospitalzj.supplier.mapper;

import com.litbo.hospitalzj.supplier.entity.EqCgfs;
import com.litbo.hospitalzj.supplier.entity.QyLx;
import com.litbo.hospitalzj.supplier.entity.TBank;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 采购持久层接口
 * @author 刘洋
 *
 */
@Mapper
public interface QyLxMapper {
	@Select("SELECT eqcg_id eqcgId, eqcg_name eqcgName FROM eq_cgfs WHERE eqcg_id=#{eqcgId}")
	EqCgfs findById(@Param("eqcgId") Integer eqcgId);

	@Select("SELECT * FROM qy_lx WHERE qy_lxcm=#{qyLxcm}")
	QyLx findByName(@Param("qyLxcm") String qyLxcm);

	@Select("SELECT * FROM qy_lx")
	List<QyLx> findAll();

	@Insert(" insert into qy_lx (qy_lxid, qy_lxcm, qy_lx_code\n" +
			"      )\n" +
			"    values (#{qyLxid,jdbcType=INTEGER}, #{qyLxcm,jdbcType=VARCHAR}, #{qyLxCode,jdbcType=VARCHAR}\n" +
			"      )")
	int insert(QyLx qyLx);
	//提供修改
	@Update("update qy_lx\n" +
			"    set qy_lxcm = #{qyLxcm,jdbcType=VARCHAR},\n" +
			"      qy_lx_code = #{qyLxCode,jdbcType=VARCHAR}\n" +
			"    where qy_lxid = #{qyLxid,jdbcType=INTEGER}")
	Integer update(QyLx qyLx);
	//模糊查询
	@Select("SELECT * FROM qy_lx WHERE qy_lxcm LIKE '%${qyLx}%'")
	List<QyLx> findByQyLxNameLike(@Param("qyLx") String qyLx);
	@Delete("delete from qy_lx where qy_lxid = #{qyLxid}")
	int delete(Integer qyLxid);

	@Select("select * from t_bank")
	List<TBank> findBank();
}
