package com.litbo.hospitalzj.checklist.dao;

import com.litbo.hospitalzj.checklist.domain.Pflsb;
import com.litbo.hospitalzj.checklist.domain.PflsbTemplate;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface PflsbMapper {

    //查询模板值
    @Select("select * from pflsb_template order by pflsb_template_id desc limit 1")
    PflsbTemplate findTemplate();
    //修改模板表数据
    @Update(" update pflsb_template\n" +
            "    set  gdyzspl_maxs1 = #{gdyzsplMaxs1,jdbcType=VARCHAR},\n" +
            "      gdyzspl_maxs2 = #{gdyzsplMaxs2,jdbcType=VARCHAR},\n" +
            "      gdyzspl_kv1 = #{gdyzsplKv1,jdbcType=VARCHAR},\n" +
            "      gdyzspl_kv2 = #{gdyzsplKv2,jdbcType=VARCHAR},\n" +
            "      gdyzspl_kv3 = #{gdyzsplKv3,jdbcType=VARCHAR},\n" +
            "      gdyzspl_kv4 = #{gdyzsplKv4,jdbcType=VARCHAR},\n" +
            "      gdyzspl_kv5 = #{gdyzsplKv5,jdbcType=VARCHAR},\n" +
            "      gdyzspl_kv6 = #{gdyzsplKv6,jdbcType=VARCHAR},\n" +
            "      gdyzspl_kv7 = #{gdyzsplKv7,jdbcType=VARCHAR},\n" +
            "      gdyzspl_kv8 = #{gdyzsplKv8,jdbcType=VARCHAR},\n" +
            "      gdyzspl_zbyq = #{gdyzsplZbyq,jdbcType=VARCHAR},\n" +
            "      sclcfx_maxs = #{sclcfxMaxs,jdbcType=VARCHAR},\n" +
            "      sclcfx_sid = #{sclcfxSid,jdbcType=VARCHAR},\n" +
            "      sclcfx_yq = #{sclcfxYq,jdbcType=VARCHAR},\n" +
            "      yyxbzc_kv = #{yyxbzcKv,jdbcType=VARCHAR},\n" +
            "      yyxbzc_maxs = #{yyxbzcMaxs,jdbcType=VARCHAR},\n" +
            "      yyxbzc_zbyq = #{yyxbzcZbyq,jdbcType=VARCHAR},\n" +
            "      yyxsczdpl_czd1 = #{yyxsczdplCzd1,jdbcType=VARCHAR},\n" +
            "      yyxsczdpl_czd2 = #{yyxsczdplCzd2,jdbcType=VARCHAR},\n" +
            "      yyxsczdpl_czd3 = #{yyxsczdplCzd3,jdbcType=VARCHAR},\n" +
            "      yyxsczdpl_zbyq = #{yyxsczdplZbyq,jdbcType=VARCHAR},\n" +
            "      azs_kv = #{azsKv,jdbcType=VARCHAR},\n" +
            "      azs_maxs = #{azsMaxs,jdbcType=VARCHAR},\n" +
            "      azs_sid = #{azsSid,jdbcType=VARCHAR},\n" +
            "      azs_zbyq = #{azsZbyq,jdbcType=VARCHAR},\n" +
            "      tcqjlzs_kv = #{tcqjlzsKv,jdbcType=VARCHAR},\n" +
            "      tcqjlzs_maxs = #{tcqjlzsMaxs,jdbcType=VARCHAR},\n" +
            "      tcqjlzs_sid = #{tcqjlzsSid,jdbcType=VARCHAR},\n" +
            "      tcqjlzs_rskqbsdn1 = #{tcqjlzsRskqbsdn1,jdbcType=VARCHAR},\n" +
            "      tcqjlzs_rskqbsdn2 = #{tcqjlzsRskqbsdn2,jdbcType=VARCHAR},\n" +
            "      tcqjlzs_rskqbsdn3 = #{tcqjlzsRskqbsdn3,jdbcType=VARCHAR},\n" +
            "      tcqjlzs_zbyq = #{tcqjlzsZbyq,jdbcType=VARCHAR},\n" +
            "      jxkjfbl_sid = #{jxkjfblSid,jdbcType=VARCHAR},\n" +
            "      jxkjfbl_kv = #{jxkjfblKv,jdbcType=VARCHAR},\n" +
            "      jxkjfbl_maxs = #{jxkjfblMaxs,jdbcType=VARCHAR},\n" +
            "      jxkjfbl_zbyq = #{jxkjfblZbyq,jdbcType=VARCHAR},\n" +
            "      ddbdxj_kv1 = #{ddbdxjKv1,jdbcType=VARCHAR},\n" +
            "      ddbdxj_kv2 = #{ddbdxjKv2,jdbcType=VARCHAR},\n" +
            "      ddbdxj_kv3 = #{ddbdxjKv3,jdbcType=VARCHAR},\n" +
            "      ddbdxj_maxs1 = #{ddbdxjMaxs1,jdbcType=VARCHAR},\n" +
            "      ddbdxj_maxs2 = #{ddbdxjMaxs2,jdbcType=VARCHAR},\n" +
            "      ddbdxj_maxs3 = #{ddbdxjMaxs3,jdbcType=VARCHAR},\n" +
            "      ddbdxj_rskqbsdn1 = #{ddbdxjRskqbsdn1,jdbcType=VARCHAR},\n" +
            "      ddbdxj_rskqbsdn2 = #{ddbdxjRskqbsdn2,jdbcType=VARCHAR},\n" +
            "      ddbdxj_rskqbsdn3 = #{ddbdxjRskqbsdn3,jdbcType=VARCHAR},\n" +
            "      ddbdxj_sid1 = #{ddbdxjSid1,jdbcType=VARCHAR},\n" +
            "      ddbdxj_sid2 = #{ddbdxjSid2,jdbcType=VARCHAR},\n" +
            "      ddbdxj_sid3 = #{ddbdxjSid3,jdbcType=VARCHAR},\n" +
            "      ddbdxj_ddbdxj_value1 = #{ddbdxjDdbdxjValue1,jdbcType=VARCHAR},\n" +
            "      ddbdxj_ddbdxj_value2 = #{ddbdxjDdbdxjValue2,jdbcType=VARCHAR},\n" +
            "      ddbdxj_ddbdxj_value3 = #{ddbdxjDdbdxjValue3,jdbcType=VARCHAR},\n" +
            "      ddbdxj_zbyq = #{ddbdxjZbyq,jdbcType=VARCHAR},\n" +
            "      type = #{type,jdbcType=TINYINT}"+
            "    where pflsb_template_id = #{pflsbTemplateId,jdbcType=INTEGER}")
    int updatePflsbTemplate(PflsbTemplate pflsbTemplate);
    //插入模板表数据
    @Insert(" insert into pflsb_template ( gdyzspl_maxs1, gdyzspl_maxs2, \n" +
            "      gdyzspl_kv1, gdyzspl_kv2, gdyzspl_kv3, \n" +
            "      gdyzspl_kv4, gdyzspl_kv5, gdyzspl_kv6, \n" +
            "      gdyzspl_kv7, gdyzspl_kv8, gdyzspl_zbyq, \n" +
            "      sclcfx_maxs, sclcfx_sid, sclcfx_yq, \n" +
            "      yyxbzc_kv, yyxbzc_maxs, yyxbzc_zbyq, \n" +
            "      yyxsczdpl_czd1, yyxsczdpl_czd2, yyxsczdpl_czd3, \n" +
            "      yyxsczdpl_zbyq, azs_kv, azs_maxs, \n" +
            "      azs_sid, azs_zbyq, tcqjlzs_kv, \n" +
            "      tcqjlzs_maxs, tcqjlzs_sid, tcqjlzs_rskqbsdn1, \n" +
            "      tcqjlzs_rskqbsdn2, tcqjlzs_rskqbsdn3, tcqjlzs_zbyq, \n" +
            "      jxkjfbl_sid, jxkjfbl_kv, jxkjfbl_maxs, \n" +
            "      jxkjfbl_zbyq, ddbdxj_kv1, ddbdxj_kv2, \n" +
            "      ddbdxj_kv3, ddbdxj_maxs1, ddbdxj_maxs2, \n" +
            "      ddbdxj_maxs3, ddbdxj_rskqbsdn1, ddbdxj_rskqbsdn2, \n" +
            "      ddbdxj_rskqbsdn3, ddbdxj_sid1, ddbdxj_sid2, \n" +
            "      ddbdxj_sid3, ddbdxj_ddbdxj_value1, ddbdxj_ddbdxj_value2, \n" +
            "      ddbdxj_ddbdxj_value3, ddbdxj_zbyq, type)\n" +
            "    values ( #{gdyzsplMaxs1,jdbcType=VARCHAR}, #{gdyzsplMaxs2,jdbcType=VARCHAR}, \n" +
            "      #{gdyzsplKv1,jdbcType=VARCHAR}, #{gdyzsplKv2,jdbcType=VARCHAR}, #{gdyzsplKv3,jdbcType=VARCHAR}, \n" +
            "      #{gdyzsplKv4,jdbcType=VARCHAR}, #{gdyzsplKv5,jdbcType=VARCHAR}, #{gdyzsplKv6,jdbcType=VARCHAR}, \n" +
            "      #{gdyzsplKv7,jdbcType=VARCHAR}, #{gdyzsplKv8,jdbcType=VARCHAR}, #{gdyzsplZbyq,jdbcType=VARCHAR}, \n" +
            "      #{sclcfxMaxs,jdbcType=VARCHAR}, #{sclcfxSid,jdbcType=VARCHAR}, #{sclcfxYq,jdbcType=VARCHAR}, \n" +
            "      #{yyxbzcKv,jdbcType=VARCHAR}, #{yyxbzcMaxs,jdbcType=VARCHAR}, #{yyxbzcZbyq,jdbcType=VARCHAR}, \n" +
            "      #{yyxsczdplCzd1,jdbcType=VARCHAR}, #{yyxsczdplCzd2,jdbcType=VARCHAR}, #{yyxsczdplCzd3,jdbcType=VARCHAR}, \n" +
            "      #{yyxsczdplZbyq,jdbcType=VARCHAR}, #{azsKv,jdbcType=VARCHAR}, #{azsMaxs,jdbcType=VARCHAR}, \n" +
            "      #{azsSid,jdbcType=VARCHAR}, #{azsZbyq,jdbcType=VARCHAR}, #{tcqjlzsKv,jdbcType=VARCHAR}, \n" +
            "      #{tcqjlzsMaxs,jdbcType=VARCHAR}, #{tcqjlzsSid,jdbcType=VARCHAR}, #{tcqjlzsRskqbsdn1,jdbcType=VARCHAR}, \n" +
            "      #{tcqjlzsRskqbsdn2,jdbcType=VARCHAR}, #{tcqjlzsRskqbsdn3,jdbcType=VARCHAR}, #{tcqjlzsZbyq,jdbcType=VARCHAR}, \n" +
            "      #{jxkjfblSid,jdbcType=VARCHAR}, #{jxkjfblKv,jdbcType=VARCHAR}, #{jxkjfblMaxs,jdbcType=VARCHAR}, \n" +
            "      #{jxkjfblZbyq,jdbcType=VARCHAR}, #{ddbdxjKv1,jdbcType=VARCHAR}, #{ddbdxjKv2,jdbcType=VARCHAR}, \n" +
            "      #{ddbdxjKv3,jdbcType=VARCHAR}, #{ddbdxjMaxs1,jdbcType=VARCHAR}, #{ddbdxjMaxs2,jdbcType=VARCHAR}, \n" +
            "      #{ddbdxjMaxs3,jdbcType=VARCHAR}, #{ddbdxjRskqbsdn1,jdbcType=VARCHAR}, #{ddbdxjRskqbsdn2,jdbcType=VARCHAR}, \n" +
            "      #{ddbdxjRskqbsdn3,jdbcType=VARCHAR}, #{ddbdxjSid1,jdbcType=VARCHAR}, #{ddbdxjSid2,jdbcType=VARCHAR}, \n" +
            "      #{ddbdxjSid3,jdbcType=VARCHAR}, #{ddbdxjDdbdxjValue1,jdbcType=VARCHAR}, #{ddbdxjDdbdxjValue2,jdbcType=VARCHAR}, \n" +
            "      #{ddbdxjDdbdxjValue3,jdbcType=VARCHAR}, #{ddbdxjZbyq,jdbcType=VARCHAR}, #{type,jdbcType=TINYINT})")
    int insert(PflsbTemplate pflsbTemplate);

    //保存
    @Insert("insert into pflsb (jcyq_id, eq_id, \n" +
            "      shr_jcjl, tester, auditor, \n" +
            "      test_time, shsj_time, jcjl, \n" +
            "      jcsm, gdyzspl_maxs1, gdyzspl_maxs2, \n" +
            "      gdyzspl_kv1, gdyzspl_kv2, gdyzspl_kv3, \n" +
            "      gdyzspl_kv4, gdyzspl_kv5, gdyzspl_kv6, \n" +
            "      gdyzspl_kv7, gdyzspl_kv8, gdyzspl_value1, \n" +
            "      gdyzspl_value2, gdyzspl_value3, gdyzspl_value4, \n" +
            "      gdyzspl_value5, gdyzspl_value6, gdyzspl_value7, \n" +
            "      gdyzspl_value8, gdyzspl_zbyq, gdyzspl_bz1, \n" +
            "      gdyzspl_bz2, gdyzspl_bz3, gdyzspl_bz4, \n" +
            "      gdyzspl_bz5, gdyzspl_bz6, gdyzspl_bz7, \n" +
            "      gdyzspl_bz8, sclcfx_maxs, sclcfx_sid, \n" +
            "      sclcfx_value1, sclcfx_value2, sclcfx_value3, \n" +
            "      sclcfx_value4, sclcfx_value5, sclcfx_yq, \n" +
            "      sclcfx_bz, yyxbzc_kv, yyxbzc_maxs, \n" +
            "      yyxbzc_value, yyxbzc_zbyq, yyxbzc_bz, \n" +
            "      yyxsczdpl_czd1, yyxsczdpl_czd2, yyxsczdpl_czd3, \n" +
            "      yyxsczdpl_value1, yyxsczdpl_value2, yyxsczdpl_value3, \n" +
            "      yyxsczdpl_zbyq, yyxsczdpl_bz1, yyxsczdpl_bz2, \n" +
            "      yyxsczdpl_bz3, azs_kv, azs_maxs, \n" +
            "      azs_sid, azs_value, azs_zbyq, \n" +
            "      azs_bz, tcqjlzs_kv, tcqjlzs_maxs, \n" +
            "      tcqjlzs_sid, tcqjlzs_rskqbsdn1, tcqjlzs_rskqbsdn2, \n" +
            "      tcqjlzs_rskqbsdn3, tcqjlzs_value1, tcqjlzs_value2, \n" +
            "      tcqjlzs_value3, tcqjlzs_zbyq, tcqjlzs_bz, \n" +
            "      jxkjfbl_sid, jxkjfbl_kv, jxkjfbl_maxs, \n" +
            "      jxkjfbl_sp_value, jxkjfbl_cz_value, jxkjfbl_zbyq, \n" +
            "      jxkjfbl_bz, ddbdxj_kv1, ddbdxj_kv2, \n" +
            "      ddbdxj_kv3, ddbdxj_maxs1, ddbdxj_maxs2, \n" +
            "      ddbdxj_maxs3, ddbdxj_rskqbsdn1, ddbdxj_rskqbsdn2, \n" +
            "      ddbdxj_rskqbsdn3, ddbdxj_sid1, ddbdxj_sid2, \n" +
            "      ddbdxj_sid3, ddbdxj_ddbdxj_value1, ddbdxj_ddbdxj_value2, \n" +
            "      ddbdxj_ddbdxj_value3, ddbdxj_jxz_value1, ddbdxj_jxz_value2, \n" +
            "      ddbdxj_jxz_value3, ddbdxj_zbyq, ddbdxj_bz, \n" +
            "      type) " +
            "values ( #{jcyqId,jdbcType=INTEGER}, #{eqId,jdbcType=INTEGER}, \n" +
            "      #{shrJcjl,jdbcType=VARCHAR}, #{tester,jdbcType=VARCHAR}, #{auditor,jdbcType=VARCHAR}, \n" +
            "      #{testTime,jdbcType=TIMESTAMP}, #{shsjTime,jdbcType=TIMESTAMP}, #{jcjl,jdbcType=VARCHAR}, \n" +
            "      #{jcsm,jdbcType=VARCHAR}, #{gdyzsplMaxs1,jdbcType=VARCHAR}, #{gdyzsplMaxs2,jdbcType=VARCHAR}, \n" +
            "      #{gdyzsplKv1,jdbcType=VARCHAR}, #{gdyzsplKv2,jdbcType=VARCHAR}, #{gdyzsplKv3,jdbcType=VARCHAR}, \n" +
            "      #{gdyzsplKv4,jdbcType=VARCHAR}, #{gdyzsplKv5,jdbcType=VARCHAR}, #{gdyzsplKv6,jdbcType=VARCHAR}, \n" +
            "      #{gdyzsplKv7,jdbcType=VARCHAR}, #{gdyzsplKv8,jdbcType=VARCHAR}, #{gdyzsplValue1,jdbcType=VARCHAR}, \n" +
            "      #{gdyzsplValue2,jdbcType=VARCHAR}, #{gdyzsplValue3,jdbcType=VARCHAR}, #{gdyzsplValue4,jdbcType=VARCHAR}, \n" +
            "      #{gdyzsplValue5,jdbcType=VARCHAR}, #{gdyzsplValue6,jdbcType=VARCHAR}, #{gdyzsplValue7,jdbcType=VARCHAR}, \n" +
            "      #{gdyzsplValue8,jdbcType=VARCHAR}, #{gdyzsplZbyq,jdbcType=VARCHAR}, #{gdyzsplBz1,jdbcType=VARCHAR}, \n" +
            "      #{gdyzsplBz2,jdbcType=VARCHAR}, #{gdyzsplBz3,jdbcType=VARCHAR}, #{gdyzsplBz4,jdbcType=VARCHAR}, \n" +
            "      #{gdyzsplBz5,jdbcType=VARCHAR}, #{gdyzsplBz6,jdbcType=VARCHAR}, #{gdyzsplBz7,jdbcType=VARCHAR}, \n" +
            "      #{gdyzsplBz8,jdbcType=VARCHAR}, #{sclcfxMaxs,jdbcType=VARCHAR}, #{sclcfxSid,jdbcType=VARCHAR}, \n" +
            "      #{sclcfxValue1,jdbcType=VARCHAR}, #{sclcfxValue2,jdbcType=VARCHAR}, #{sclcfxValue3,jdbcType=VARCHAR}, \n" +
            "      #{sclcfxValue4,jdbcType=VARCHAR}, #{sclcfxValue5,jdbcType=VARCHAR}, #{sclcfxYq,jdbcType=VARCHAR}, \n" +
            "      #{sclcfxBz,jdbcType=VARCHAR}, #{yyxbzcKv,jdbcType=VARCHAR}, #{yyxbzcMaxs,jdbcType=VARCHAR}, \n" +
            "      #{yyxbzcValue,jdbcType=VARCHAR}, #{yyxbzcZbyq,jdbcType=VARCHAR}, #{yyxbzcBz,jdbcType=VARCHAR}, \n" +
            "      #{yyxsczdplCzd1,jdbcType=VARCHAR}, #{yyxsczdplCzd2,jdbcType=VARCHAR}, #{yyxsczdplCzd3,jdbcType=VARCHAR}, \n" +
            "      #{yyxsczdplValue1,jdbcType=VARCHAR}, #{yyxsczdplValue2,jdbcType=VARCHAR}, #{yyxsczdplValue3,jdbcType=VARCHAR}, \n" +
            "      #{yyxsczdplZbyq,jdbcType=VARCHAR}, #{yyxsczdplBz1,jdbcType=VARCHAR}, #{yyxsczdplBz2,jdbcType=VARCHAR}, \n" +
            "      #{yyxsczdplBz3,jdbcType=VARCHAR}, #{azsKv,jdbcType=VARCHAR}, #{azsMaxs,jdbcType=VARCHAR}, \n" +
            "      #{azsSid,jdbcType=VARCHAR}, #{azsValue,jdbcType=VARCHAR}, #{azsZbyq,jdbcType=VARCHAR}, \n" +
            "      #{azsBz,jdbcType=VARCHAR}, #{tcqjlzsKv,jdbcType=VARCHAR}, #{tcqjlzsMaxs,jdbcType=VARCHAR}, \n" +
            "      #{tcqjlzsSid,jdbcType=VARCHAR}, #{tcqjlzsRskqbsdn1,jdbcType=VARCHAR}, #{tcqjlzsRskqbsdn2,jdbcType=VARCHAR}, \n" +
            "      #{tcqjlzsRskqbsdn3,jdbcType=VARCHAR}, #{tcqjlzsValue1,jdbcType=VARCHAR}, #{tcqjlzsValue2,jdbcType=VARCHAR}, \n" +
            "      #{tcqjlzsValue3,jdbcType=VARCHAR}, #{tcqjlzsZbyq,jdbcType=VARCHAR}, #{tcqjlzsBz,jdbcType=VARCHAR}, \n" +
            "      #{jxkjfblSid,jdbcType=VARCHAR}, #{jxkjfblKv,jdbcType=VARCHAR}, #{jxkjfblMaxs,jdbcType=VARCHAR}, \n" +
            "      #{jxkjfblSpValue,jdbcType=VARCHAR}, #{jxkjfblCzValue,jdbcType=VARCHAR}, #{jxkjfblZbyq,jdbcType=VARCHAR}, \n" +
            "      #{jxkjfblBz,jdbcType=VARCHAR}, #{ddbdxjKv1,jdbcType=VARCHAR}, #{ddbdxjKv2,jdbcType=VARCHAR}, \n" +
            "      #{ddbdxjKv3,jdbcType=VARCHAR}, #{ddbdxjMaxs1,jdbcType=VARCHAR}, #{ddbdxjMaxs2,jdbcType=VARCHAR}, \n" +
            "      #{ddbdxjMaxs3,jdbcType=VARCHAR}, #{ddbdxjRskqbsdn1,jdbcType=VARCHAR}, #{ddbdxjRskqbsdn2,jdbcType=VARCHAR}, \n" +
            "      #{ddbdxjRskqbsdn3,jdbcType=VARCHAR}, #{ddbdxjSid1,jdbcType=VARCHAR}, #{ddbdxjSid2,jdbcType=VARCHAR}, \n" +
            "      #{ddbdxjSid3,jdbcType=VARCHAR}, #{ddbdxjDdbdxjValue1,jdbcType=VARCHAR}, #{ddbdxjDdbdxjValue2,jdbcType=VARCHAR}, \n" +
            "      #{ddbdxjDdbdxjValue3,jdbcType=VARCHAR}, #{ddbdxjJxzValue1,jdbcType=VARCHAR}, #{ddbdxjJxzValue2,jdbcType=VARCHAR}, \n" +
            "      #{ddbdxjJxzValue3,jdbcType=VARCHAR}, #{ddbdxjZbyq,jdbcType=VARCHAR}, #{ddbdxjBz,jdbcType=VARCHAR}, \n" +
            "      #{type,jdbcType=TINYINT})")
    @Options(useGeneratedKeys = true, keyProperty = "pflsbId", keyColumn = "pflsb_id")
    void save(Pflsb pflsb);
    //修改数据
    @Update(" update pflsb\n" +
            "    set jcyq_id = #{jcyqId,jdbcType=INTEGER},\n" +
            "      eq_id = #{eqId,jdbcType=INTEGER},\n" +
            "      shr_jcjl = #{shrJcjl,jdbcType=VARCHAR},\n" +
            "      tester = #{tester,jdbcType=VARCHAR},\n" +
            "      auditor = #{auditor,jdbcType=VARCHAR},\n" +
            "      test_time = #{testTime,jdbcType=TIMESTAMP},\n" +
            "      shsj_time = #{shsjTime,jdbcType=TIMESTAMP},\n" +
            "      jcjl = #{jcjl,jdbcType=VARCHAR},\n" +
            "      jcsm = #{jcsm,jdbcType=VARCHAR},\n" +
            "      gdyzspl_maxs1 = #{gdyzsplMaxs1,jdbcType=VARCHAR},\n" +
            "      gdyzspl_maxs2 = #{gdyzsplMaxs2,jdbcType=VARCHAR},\n" +
            "      gdyzspl_kv1 = #{gdyzsplKv1,jdbcType=VARCHAR},\n" +
            "      gdyzspl_kv2 = #{gdyzsplKv2,jdbcType=VARCHAR},\n" +
            "      gdyzspl_kv3 = #{gdyzsplKv3,jdbcType=VARCHAR},\n" +
            "      gdyzspl_kv4 = #{gdyzsplKv4,jdbcType=VARCHAR},\n" +
            "      gdyzspl_kv5 = #{gdyzsplKv5,jdbcType=VARCHAR},\n" +
            "      gdyzspl_kv6 = #{gdyzsplKv6,jdbcType=VARCHAR},\n" +
            "      gdyzspl_kv7 = #{gdyzsplKv7,jdbcType=VARCHAR},\n" +
            "      gdyzspl_kv8 = #{gdyzsplKv8,jdbcType=VARCHAR},\n" +
            "      gdyzspl_value1 = #{gdyzsplValue1,jdbcType=VARCHAR},\n" +
            "      gdyzspl_value2 = #{gdyzsplValue2,jdbcType=VARCHAR},\n" +
            "      gdyzspl_value3 = #{gdyzsplValue3,jdbcType=VARCHAR},\n" +
            "      gdyzspl_value4 = #{gdyzsplValue4,jdbcType=VARCHAR},\n" +
            "      gdyzspl_value5 = #{gdyzsplValue5,jdbcType=VARCHAR},\n" +
            "      gdyzspl_value6 = #{gdyzsplValue6,jdbcType=VARCHAR},\n" +
            "      gdyzspl_value7 = #{gdyzsplValue7,jdbcType=VARCHAR},\n" +
            "      gdyzspl_value8 = #{gdyzsplValue8,jdbcType=VARCHAR},\n" +
            "      gdyzspl_zbyq = #{gdyzsplZbyq,jdbcType=VARCHAR},\n" +
            "      gdyzspl_bz1 = #{gdyzsplBz1,jdbcType=VARCHAR},\n" +
            "      gdyzspl_bz2 = #{gdyzsplBz2,jdbcType=VARCHAR},\n" +
            "      gdyzspl_bz3 = #{gdyzsplBz3,jdbcType=VARCHAR},\n" +
            "      gdyzspl_bz4 = #{gdyzsplBz4,jdbcType=VARCHAR},\n" +
            "      gdyzspl_bz5 = #{gdyzsplBz5,jdbcType=VARCHAR},\n" +
            "      gdyzspl_bz6 = #{gdyzsplBz6,jdbcType=VARCHAR},\n" +
            "      gdyzspl_bz7 = #{gdyzsplBz7,jdbcType=VARCHAR},\n" +
            "      gdyzspl_bz8 = #{gdyzsplBz8,jdbcType=VARCHAR},\n" +
            "      sclcfx_maxs = #{sclcfxMaxs,jdbcType=VARCHAR},\n" +
            "      sclcfx_sid = #{sclcfxSid,jdbcType=VARCHAR},\n" +
            "      sclcfx_value1 = #{sclcfxValue1,jdbcType=VARCHAR},\n" +
            "      sclcfx_value2 = #{sclcfxValue2,jdbcType=VARCHAR},\n" +
            "      sclcfx_value3 = #{sclcfxValue3,jdbcType=VARCHAR},\n" +
            "      sclcfx_value4 = #{sclcfxValue4,jdbcType=VARCHAR},\n" +
            "      sclcfx_value5 = #{sclcfxValue5,jdbcType=VARCHAR},\n" +
            "      sclcfx_yq = #{sclcfxYq,jdbcType=VARCHAR},\n" +
            "      sclcfx_bz = #{sclcfxBz,jdbcType=VARCHAR},\n" +
            "      yyxbzc_kv = #{yyxbzcKv,jdbcType=VARCHAR},\n" +
            "      yyxbzc_maxs = #{yyxbzcMaxs,jdbcType=VARCHAR},\n" +
            "      yyxbzc_value = #{yyxbzcValue,jdbcType=VARCHAR},\n" +
            "      yyxbzc_zbyq = #{yyxbzcZbyq,jdbcType=VARCHAR},\n" +
            "      yyxbzc_bz = #{yyxbzcBz,jdbcType=VARCHAR},\n" +
            "      yyxsczdpl_czd1 = #{yyxsczdplCzd1,jdbcType=VARCHAR},\n" +
            "      yyxsczdpl_czd2 = #{yyxsczdplCzd2,jdbcType=VARCHAR},\n" +
            "      yyxsczdpl_czd3 = #{yyxsczdplCzd3,jdbcType=VARCHAR},\n" +
            "      yyxsczdpl_value1 = #{yyxsczdplValue1,jdbcType=VARCHAR},\n" +
            "      yyxsczdpl_value2 = #{yyxsczdplValue2,jdbcType=VARCHAR},\n" +
            "      yyxsczdpl_value3 = #{yyxsczdplValue3,jdbcType=VARCHAR},\n" +
            "      yyxsczdpl_zbyq = #{yyxsczdplZbyq,jdbcType=VARCHAR},\n" +
            "      yyxsczdpl_bz1 = #{yyxsczdplBz1,jdbcType=VARCHAR},\n" +
            "      yyxsczdpl_bz2 = #{yyxsczdplBz2,jdbcType=VARCHAR},\n" +
            "      yyxsczdpl_bz3 = #{yyxsczdplBz3,jdbcType=VARCHAR},\n" +
            "      azs_kv = #{azsKv,jdbcType=VARCHAR},\n" +
            "      azs_maxs = #{azsMaxs,jdbcType=VARCHAR},\n" +
            "      azs_sid = #{azsSid,jdbcType=VARCHAR},\n" +
            "      azs_value = #{azsValue,jdbcType=VARCHAR},\n" +
            "      azs_zbyq = #{azsZbyq,jdbcType=VARCHAR},\n" +
            "      azs_bz = #{azsBz,jdbcType=VARCHAR},\n" +
            "      tcqjlzs_kv = #{tcqjlzsKv,jdbcType=VARCHAR},\n" +
            "      tcqjlzs_maxs = #{tcqjlzsMaxs,jdbcType=VARCHAR},\n" +
            "      tcqjlzs_sid = #{tcqjlzsSid,jdbcType=VARCHAR},\n" +
            "      tcqjlzs_rskqbsdn1 = #{tcqjlzsRskqbsdn1,jdbcType=VARCHAR},\n" +
            "      tcqjlzs_rskqbsdn2 = #{tcqjlzsRskqbsdn2,jdbcType=VARCHAR},\n" +
            "      tcqjlzs_rskqbsdn3 = #{tcqjlzsRskqbsdn3,jdbcType=VARCHAR},\n" +
            "      tcqjlzs_value1 = #{tcqjlzsValue1,jdbcType=VARCHAR},\n" +
            "      tcqjlzs_value2 = #{tcqjlzsValue2,jdbcType=VARCHAR},\n" +
            "      tcqjlzs_value3 = #{tcqjlzsValue3,jdbcType=VARCHAR},\n" +
            "      tcqjlzs_zbyq = #{tcqjlzsZbyq,jdbcType=VARCHAR},\n" +
            "      tcqjlzs_bz = #{tcqjlzsBz,jdbcType=VARCHAR},\n" +
            "      jxkjfbl_sid = #{jxkjfblSid,jdbcType=VARCHAR},\n" +
            "      jxkjfbl_kv = #{jxkjfblKv,jdbcType=VARCHAR},\n" +
            "      jxkjfbl_maxs = #{jxkjfblMaxs,jdbcType=VARCHAR},\n" +
            "      jxkjfbl_sp_value = #{jxkjfblSpValue,jdbcType=VARCHAR},\n" +
            "      jxkjfbl_cz_value = #{jxkjfblCzValue,jdbcType=VARCHAR},\n" +
            "      jxkjfbl_zbyq = #{jxkjfblZbyq,jdbcType=VARCHAR},\n" +
            "      jxkjfbl_bz = #{jxkjfblBz,jdbcType=VARCHAR},\n" +
            "      ddbdxj_kv1 = #{ddbdxjKv1,jdbcType=VARCHAR},\n" +
            "      ddbdxj_kv2 = #{ddbdxjKv2,jdbcType=VARCHAR},\n" +
            "      ddbdxj_kv3 = #{ddbdxjKv3,jdbcType=VARCHAR},\n" +
            "      ddbdxj_maxs1 = #{ddbdxjMaxs1,jdbcType=VARCHAR},\n" +
            "      ddbdxj_maxs2 = #{ddbdxjMaxs2,jdbcType=VARCHAR},\n" +
            "      ddbdxj_maxs3 = #{ddbdxjMaxs3,jdbcType=VARCHAR},\n" +
            "      ddbdxj_rskqbsdn1 = #{ddbdxjRskqbsdn1,jdbcType=VARCHAR},\n" +
            "      ddbdxj_rskqbsdn2 = #{ddbdxjRskqbsdn2,jdbcType=VARCHAR},\n" +
            "      ddbdxj_rskqbsdn3 = #{ddbdxjRskqbsdn3,jdbcType=VARCHAR},\n" +
            "      ddbdxj_sid1 = #{ddbdxjSid1,jdbcType=VARCHAR},\n" +
            "      ddbdxj_sid2 = #{ddbdxjSid2,jdbcType=VARCHAR},\n" +
            "      ddbdxj_sid3 = #{ddbdxjSid3,jdbcType=VARCHAR},\n" +
            "      ddbdxj_ddbdxj_value1 = #{ddbdxjDdbdxjValue1,jdbcType=VARCHAR},\n" +
            "      ddbdxj_ddbdxj_value2 = #{ddbdxjDdbdxjValue2,jdbcType=VARCHAR},\n" +
            "      ddbdxj_ddbdxj_value3 = #{ddbdxjDdbdxjValue3,jdbcType=VARCHAR},\n" +
            "      ddbdxj_jxz_value1 = #{ddbdxjJxzValue1,jdbcType=VARCHAR},\n" +
            "      ddbdxj_jxz_value2 = #{ddbdxjJxzValue2,jdbcType=VARCHAR},\n" +
            "      ddbdxj_jxz_value3 = #{ddbdxjJxzValue3,jdbcType=VARCHAR},\n" +
            "      ddbdxj_zbyq = #{ddbdxjZbyq,jdbcType=VARCHAR},\n" +
            "      ddbdxj_bz = #{ddbdxjBz,jdbcType=VARCHAR},\n" +
            "      type = #{type,jdbcType=TINYINT}" +
            "    where pflsb_id = #{pflsbId,jdbcType=INTEGER}")
    void updatePflsb(Pflsb pflsb);
    //根据设备id查询检测表婴儿培养箱
    @Select("select * from pflsb where eq_id =#{eqId} order by pflsb_id desc limit 1")
    public Pflsb findPflsb(String eqId);
    //查询一条
    @Select("select * from pflsb order by pflsb_id desc limit 1")
    Pflsb find();
    //根据设备Id,检测仪器Id以及状态查询电切表查询最后一条记录
    @Select("select pflsb.* from pflsb where pflsb.eq_id=#{eqId} and pflsb.jcyq_id=#{jcyqId} order by test_time desc, pflsb_id desc limit 1" )
    Pflsb findByEqIdandJcyqIdLast1(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //根据设备Id,检测仪器Id以及状态查询电切表
    @Select("select pflsb.* from pflsb where pflsb.eq_id=#{eqId} and pflsb.jcyq_id=#{jcyqId}" )
    List<Pflsb> findByEqIdandJcyqId(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //查询所有
    @Select("select * from pflsb")
    List<Pflsb> findAll();

    //根据检测仪器Id查询
    @Select("select pflsb.* from pflsb where pflsb_id=#{pflsbId}" )
    Pflsb findByPflsbId(@Param("pflsbId") Integer pflsbId);

    //修改审核人意见
    @Update("update pflsb set shr_jcjl=#{shrJcjl},auditor=#{auditor},shsj_time=#{shsjTime} where pflsb_id=#{pflsbId}")
    void updateShrJcjy(@Param("pflsbId") Integer pflsbId, @Param("shrJcjl") String shrJcjl, @Param("auditor") String auditor, @Param("shsjTime") Date shsjTime);
}

