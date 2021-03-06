package com.litbo.hospitalzj.supplier.mapper;

import com.litbo.hospitalzj.supplier.entity.EqJfly;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 设备经费持久层接口
 * @author 刘洋
 *
 */
@Mapper
public interface EqJfMapper {
	@Select("SELECT eqjf_id eqjfId, eqjf_name eqjfName FROM eq_jfly WHERE eqjf_id=#{eqjfId}")
	EqJfly findById(@Param("eqjfId") Integer eqjfId);
	@Select("SELECT eqjf_id eqjfId, eqjf_name eqjfName FROM eq_jfly WHERE eqjf_name=#{eqjfName} and is_delete=0")
	EqJfly findByName(@Param("eqjfName") String eqjfName);
	@Select("SELECT eqjf_id eqjfId, eqjf_name eqjfName FROM eq_jfly where is_delete = 0")
	List<EqJfly> findAll();
	//删除，修改状态
	/*@Delete("delete from eq_jfly where eqjf_id = #{eqjfId}")*/
	@Update("update eq_jfly set is_delete = #{isDelete} where eqjf_id = #{eqjfId}")
	int delete(@Param("eqjfId") Integer eqjfId, @Param("isDelete") Integer isDelete);

	@Insert(" insert into eq_jfly (eqjf_id, eqjf_name) values (#{eqjfId}, #{eqjfName})")
	int insert(EqJfly eqJfly);
	@Update(("update eq_jfly set eqjf_name = #{eqjfName,jdbcType=VARCHAR} where eqjf_id = #{eqjfId,jdbcType=INTEGER}"))
	Integer update(EqJfly eqJfly);
	//模糊查询
	@Select("SELECT * FROM eq_jfly WHERE eqjf_name LIKE '%${eqjfName}%' where is_delete=0")
	List<EqJfly> findEqJflyLike(@Param("eqjfName") String eqjfName);
}
