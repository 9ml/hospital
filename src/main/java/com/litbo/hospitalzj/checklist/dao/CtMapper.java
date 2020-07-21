package com.litbo.hospitalzj.checklist.dao;

import com.litbo.hospitalzj.checklist.domain.Ct;
import com.litbo.hospitalzj.checklist.domain.CtTemplate;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface CtMapper {
    //查询模板值
    @Select("select * from ct_template order by ct_template_id desc limit 1")
    CtTemplate findTemplate();
    //插入模板表数据
    @Insert(" insert into ct_template ( djdq_test1, djdq_test2, \n" +
            "      djdq_test3, djdq_test4, djdq_wc, \n" +
            "      djdn_test1, djdn_test2, djdn_test3, \n" +
            "      djdn_test4, djdn_wc, sjdq_test1, \n" +
            "      sjdq_test2, sjdq_test3, sjdq_test4, \n" +
            "      sjdq_wc, sjdn_test1, sjdn_test2, \n" +
            "      sjdn_test3, sjdn_test4, sjdn_wc, \n" +
            "      djgpld_wc, sjgpld_wc, spare1, \n" +
            "      spare2)\n" +
            "    values ( #{djdqTest1,jdbcType=DOUBLE}, #{djdqTest2,jdbcType=DOUBLE}, \n" +
            "      #{djdqTest3,jdbcType=DOUBLE}, #{djdqTest4,jdbcType=DOUBLE}, #{djdqWc,jdbcType=INTEGER}, \n" +
            "      #{djdnTest1,jdbcType=DOUBLE}, #{djdnTest2,jdbcType=DOUBLE}, #{djdnTest3,jdbcType=DOUBLE}, \n" +
            "      #{djdnTest4,jdbcType=DOUBLE}, #{djdnWc,jdbcType=INTEGER}, #{sjdqTest1,jdbcType=DOUBLE}, \n" +
            "      #{sjdqTest2,jdbcType=DOUBLE}, #{sjdqTest3,jdbcType=DOUBLE}, #{sjdqTest4,jdbcType=DOUBLE}, \n" +
            "      #{sjdqWc,jdbcType=INTEGER}, #{sjdnTest1,jdbcType=DOUBLE}, #{sjdnTest2,jdbcType=DOUBLE}, \n" +
            "      #{sjdnTest3,jdbcType=DOUBLE}, #{sjdnTest4,jdbcType=DOUBLE}, #{sjdnWc,jdbcType=INTEGER}, \n" +
            "      #{djgpldWc,jdbcType=INTEGER}, #{sjgpldWc,jdbcType=INTEGER}, #{spare1,jdbcType=VARCHAR}, \n" +
            "      #{spare2,jdbcType=VARCHAR})")

    void insert(CtTemplate ctTemplate);
    //修改模板表数据
    @Update(" update ct_template\n" +
            "    set cjchpc_ch_test1 = #{cjchpcChTest1,jdbcType=INTEGER},\n" +
            "      cjchpc_ch_test2 = #{cjchpcChTest2,jdbcType=INTEGER},\n" +
            "      cjchpc_ch_test3 = #{cjchpcChTest3,jdbcType=INTEGER},\n" +
            "      cjchpc_jctj = #{cjchpcJctj,jdbcType=VARCHAR},\n" +
            "      cjchpc_zbyq = #{cjchpcZbyq,jdbcType=VARCHAR},\n" +
            "      ctdiw_jctj = #{ctdiwJctj,jdbcType=VARCHAR},\n" +
            "      ctdiw_zbyq = #{ctdiwZbyq,jdbcType=VARCHAR},\n" +
            "      ctz_zbyq = #{ctzZbyq,jdbcType=VARCHAR},\n" +
            "      ctz_jctj = #{ctzJctj,jdbcType=VARCHAR},\n" +
            "      jyx_jctj = #{jyxJctj,jdbcType=VARCHAR},\n" +
            "      jyx_zbyq = #{jyxZbyq,jdbcType=VARCHAR},\n" +
            "      zs_jctj = #{zsJctj,jdbcType=VARCHAR},\n" +
            "      zs_zbyq = #{zsZbyq,jdbcType=VARCHAR},\n" +
            "      gdbfbl_sf1 = #{gdbfblSf1,jdbcType=VARCHAR},\n" +
            "      gdbfbl_sf2 = #{gdbfblSf2,jdbcType=VARCHAR},\n" +
            "      gdbfbl_jctj1 = #{gdbfblJctj1,jdbcType=VARCHAR},\n" +
            "      gdbfbl_jctj2 = #{gdbfblJctj2,jdbcType=VARCHAR},\n" +
            "      gdbfbl_zbyq1 = #{gdbfblZbyq1,jdbcType=VARCHAR},\n" +
            "      gdbfbl_zbyq2 = #{gdbfblZbyq2,jdbcType=VARCHAR},\n" +
            "      ddbktcfbl_jctj = #{ddbktcfblJctj,jdbcType=VARCHAR},\n" +
            "      ddbktcfbl_zbyq = #{ddbktcfblZbyq,jdbcType=VARCHAR},\n" +
            "      ctzxx_jctj = #{ctzxxJctj,jdbcType=VARCHAR},\n" +
            "      ctzxx_zbyq = #{ctzxxZbyq,jdbcType=VARCHAR},\n" +
            "      type = #{type,jdbcType=INTEGER}" +
            "    where ct_template_id = #{ctTemplateId,jdbcType=INTEGER}")
    void updateCtTemplate(CtTemplate ctTemplate);
    //保存
    @Insert("insert into ct ( jcyq_id, eq_id, \n" +
            "      tester, test_time, auditor, \n" +
            "      shr_jcjl, shsj_time, jcjl, \n" +
            "      jcsm, cjchpc_ch_test1, cjchpc_ch_test2, \n" +
            "      cjchpc_ch_test3, cjchpc_ch_value1, cjchpc_ch_value2, \n" +
            "      cjchpc_ch_value3, cjchpc_ch_res1, cjchpc_ch_res2, \n" +
            "      cjchpc_ch_res3, cjchpc_jctj, cjchpc_zbyq, \n" +
            "      ctdiw_value, ctdiw_res, ctdiw_jctj, \n" +
            "      ctdiw_zbyq, ctz_res, ctz_value, \n" +
            "      ctz_zbyq, ctz_jctj, jyx_jctj, \n" +
            "      jyx_res, jyx_value, jyx_zbyq, \n" +
            "      zs_jctj, zs_zbyq, zs_res, \n" +
            "      zs_value, gdbfbl_sf1, gdbfbl_sf2, \n" +
            "      gdbfbl_jctj1, gdbfbl_jctj2, gdbfbl_zbyq1, \n" +
            "      gdbfbl_zbyq2, gdbfbl_value2, gdbfbl_value1, \n" +
            "      gdbfbl_res1, gdbfbl_res2, ddbktcfbl_jctj, \n" +
            "      ddbktcfbl_zbyq, ddbktcfbl_res, ddbktcfbl_value, \n" +
            "      ctzxx_jctj, ctzxx_zbyq, ctzxx_value, \n" +
            "      ctzxx_res, type) " +
            "values ( #{jcyqId,jdbcType=INTEGER}, #{eqId,jdbcType=INTEGER}, \n" +
            "      #{tester,jdbcType=VARCHAR}, #{testTime,jdbcType=TIMESTAMP}, #{auditor,jdbcType=VARCHAR}, \n" +
            "      #{shrJcjl,jdbcType=VARCHAR}, #{shsjTime,jdbcType=TIMESTAMP}, #{jcjl,jdbcType=VARCHAR}, \n" +
            "      #{jcsm,jdbcType=VARCHAR}, #{cjchpcChTest1,jdbcType=VARCHAR}, #{cjchpcChTest2,jdbcType=VARCHAR}, \n" +
            "      #{cjchpcChTest3,jdbcType=VARCHAR}, #{cjchpcChValue1,jdbcType=DOUBLE}, #{cjchpcChValue2,jdbcType=DOUBLE}, \n" +
            "      #{cjchpcChValue3,jdbcType=DOUBLE}, #{cjchpcChRes1,jdbcType=INTEGER}, #{cjchpcChRes2,jdbcType=INTEGER}, \n" +
            "      #{cjchpcChRes3,jdbcType=INTEGER}, #{cjchpcJctj,jdbcType=VARCHAR}, #{cjchpcZbyq,jdbcType=VARCHAR}, \n" +
            "      #{ctdiwValue,jdbcType=DOUBLE}, #{ctdiwRes,jdbcType=INTEGER}, #{ctdiwJctj,jdbcType=VARCHAR}, \n" +
            "      #{ctdiwZbyq,jdbcType=VARCHAR}, #{ctzRes,jdbcType=INTEGER}, #{ctzValue,jdbcType=DOUBLE}, \n" +
            "      #{ctzZbyq,jdbcType=VARCHAR}, #{ctzJctj,jdbcType=VARCHAR}, #{jyxJctj,jdbcType=VARCHAR}, \n" +
            "      #{jyxRes,jdbcType=INTEGER}, #{jyxValue,jdbcType=DOUBLE}, #{jyxZbyq,jdbcType=VARCHAR}, \n" +
            "      #{zsJctj,jdbcType=VARCHAR}, #{zsZbyq,jdbcType=VARCHAR}, #{zsRes,jdbcType=INTEGER}, \n" +
            "      #{zsValue,jdbcType=DOUBLE}, #{gdbfblSf1,jdbcType=VARCHAR}, #{gdbfblSf2,jdbcType=VARCHAR}, \n" +
            "      #{gdbfblJctj1,jdbcType=VARCHAR}, #{gdbfblJctj2,jdbcType=VARCHAR}, #{gdbfblZbyq1,jdbcType=VARCHAR}, \n" +
            "      #{gdbfblZbyq2,jdbcType=VARCHAR}, #{gdbfblValue2,jdbcType=DOUBLE}, #{gdbfblValue1,jdbcType=DOUBLE}, \n" +
            "      #{gdbfblRes1,jdbcType=INTEGER}, #{gdbfblRes2,jdbcType=INTEGER}, #{ddbktcfblJctj,jdbcType=VARCHAR}, \n" +
            "      #{ddbktcfblZbyq,jdbcType=VARCHAR}, #{ddbktcfblRes,jdbcType=INTEGER}, #{ddbktcfblValue,jdbcType=DOUBLE}, \n" +
            "      #{ctzxxJctj,jdbcType=VARCHAR}, #{ctzxxZbyq,jdbcType=VARCHAR}, #{ctzxxValue,jdbcType=DOUBLE}, \n" +
            "      #{ctzxxRes,jdbcType=INTEGER}, #{type,jdbcType=INTEGER})")
    @Options(useGeneratedKeys = true, keyProperty = "ctId", keyColumn = "ct_id")
    void save(Ct ct);
    //修改数据
    @Update(" update ct\n" +
            "    set  jcyq_id = #{jcyqId,jdbcType=INTEGER},\n" +
            "      eq_id = #{eqId,jdbcType=INTEGER},\n" +
            "      tester = #{tester,jdbcType=VARCHAR},\n" +
            "      test_time = #{testTime,jdbcType=TIMESTAMP},\n" +
            "      auditor = #{auditor,jdbcType=VARCHAR},\n" +
            "      shr_jcjl = #{shrJcjl,jdbcType=VARCHAR},\n" +
            "      shsj_time = #{shsjTime,jdbcType=TIMESTAMP},\n" +
            "      jcjl = #{jcjl,jdbcType=VARCHAR},\n" +
            "      jcsm = #{jcsm,jdbcType=VARCHAR},\n" +
            "      cjchpc_ch_test1 = #{cjchpcChTest1,jdbcType=VARCHAR},\n" +
            "      cjchpc_ch_test2 = #{cjchpcChTest2,jdbcType=VARCHAR},\n" +
            "      cjchpc_ch_test3 = #{cjchpcChTest3,jdbcType=VARCHAR},\n" +
            "      cjchpc_ch_value1 = #{cjchpcChValue1,jdbcType=DOUBLE},\n" +
            "      cjchpc_ch_value2 = #{cjchpcChValue2,jdbcType=DOUBLE},\n" +
            "      cjchpc_ch_value3 = #{cjchpcChValue3,jdbcType=DOUBLE},\n" +
            "      cjchpc_ch_res1 = #{cjchpcChRes1,jdbcType=INTEGER},\n" +
            "      cjchpc_ch_res2 = #{cjchpcChRes2,jdbcType=INTEGER},\n" +
            "      cjchpc_ch_res3 = #{cjchpcChRes3,jdbcType=INTEGER},\n" +
            "      cjchpc_jctj = #{cjchpcJctj,jdbcType=VARCHAR},\n" +
            "      cjchpc_zbyq = #{cjchpcZbyq,jdbcType=VARCHAR},\n" +
            "      ctdiw_value = #{ctdiwValue,jdbcType=DOUBLE},\n" +
            "      ctdiw_res = #{ctdiwRes,jdbcType=INTEGER},\n" +
            "      ctdiw_jctj = #{ctdiwJctj,jdbcType=VARCHAR},\n" +
            "      ctdiw_zbyq = #{ctdiwZbyq,jdbcType=VARCHAR},\n" +
            "      ctz_res = #{ctzRes,jdbcType=INTEGER},\n" +
            "      ctz_value = #{ctzValue,jdbcType=DOUBLE},\n" +
            "      ctz_zbyq = #{ctzZbyq,jdbcType=VARCHAR},\n" +
            "      ctz_jctj = #{ctzJctj,jdbcType=VARCHAR},\n" +
            "      jyx_jctj = #{jyxJctj,jdbcType=VARCHAR},\n" +
            "      jyx_res = #{jyxRes,jdbcType=INTEGER},\n" +
            "      jyx_value = #{jyxValue,jdbcType=DOUBLE},\n" +
            "      jyx_zbyq = #{jyxZbyq,jdbcType=VARCHAR},\n" +
            "      zs_jctj = #{zsJctj,jdbcType=VARCHAR},\n" +
            "      zs_zbyq = #{zsZbyq,jdbcType=VARCHAR},\n" +
            "      zs_res = #{zsRes,jdbcType=INTEGER},\n" +
            "      zs_value = #{zsValue,jdbcType=DOUBLE},\n" +
            "      gdbfbl_sf1 = #{gdbfblSf1,jdbcType=VARCHAR},\n" +
            "      gdbfbl_sf2 = #{gdbfblSf2,jdbcType=VARCHAR},\n" +
            "      gdbfbl_jctj1 = #{gdbfblJctj1,jdbcType=VARCHAR},\n" +
            "      gdbfbl_jctj2 = #{gdbfblJctj2,jdbcType=VARCHAR},\n" +
            "      gdbfbl_zbyq1 = #{gdbfblZbyq1,jdbcType=VARCHAR},\n" +
            "      gdbfbl_zbyq2 = #{gdbfblZbyq2,jdbcType=VARCHAR},\n" +
            "      gdbfbl_value2 = #{gdbfblValue2,jdbcType=DOUBLE},\n" +
            "      gdbfbl_value1 = #{gdbfblValue1,jdbcType=DOUBLE},\n" +
            "      gdbfbl_res1 = #{gdbfblRes1,jdbcType=INTEGER},\n" +
            "      gdbfbl_res2 = #{gdbfblRes2,jdbcType=INTEGER},\n" +
            "      ddbktcfbl_jctj = #{ddbktcfblJctj,jdbcType=VARCHAR},\n" +
            "      ddbktcfbl_zbyq = #{ddbktcfblZbyq,jdbcType=VARCHAR},\n" +
            "      ddbktcfbl_res = #{ddbktcfblRes,jdbcType=INTEGER},\n" +
            "      ddbktcfbl_value = #{ddbktcfblValue,jdbcType=DOUBLE},\n" +
            "      ctzxx_jctj = #{ctzxxJctj,jdbcType=VARCHAR},\n" +
            "      ctzxx_zbyq = #{ctzxxZbyq,jdbcType=VARCHAR},\n" +
            "      ctzxx_value = #{ctzxxValue,jdbcType=DOUBLE},\n" +
            "      ctzxx_res = #{ctzxxRes,jdbcType=INTEGER},\n" +
            "      type = #{type,jdbcType=INTEGER}" +
            "    where ct_id = #{ctId,jdbcType=INTEGER}")
    void updateCt(Ct ct);

    @Select("select * from ct where eq_id =#{eqId} order by ct_id desc limit 1")
    Ct findCt(String eqId);
    //查询一条
    @Select("select * from ct order by ct_id desc limit 1")
    Ct find();
    //根据设备Id,检测仪器Id以及状态查询电切表查询最后一条记录
    @Select("select ct.* from ct where ct.eq_id=#{eqId} and ct.jcyq_id=#{jcyqId} order by test_time desc, ct_id desc limit 1" )
    Ct findByEqIdandJcyqIdLast1(@Param("eqId") String eqId,@Param("jcyqId") String jcyqId);
    //根据设备Id,检测仪器Id以及状态查询电切表
    @Select("select ct.* from ct where ct.eq_id=#{eqId} and ct.jcyq_id=#{jcyqId}" )
    List<Ct> findByEqIdandJcyqId(@Param("eqId") String eqId,@Param("jcyqId") String jcyqId);
    //查询所有
    @Select("select * from ct")
    List<Ct> findAll();
    @Select("select ct.* from ct where ct_id=#{ctId}" )
    Ct findByCtid(Integer ctId);
    //修改审核人意见
    @Update("update ct set shr_jcjl=#{shrJcjl},auditor=#{auditor},shsj_time=#{shsjTime} where ct_id=#{ctId}")
    void updateShrJcjy(@Param("ctId") Integer ctId, @Param("shrJcjl") String shrJcjl,@Param("auditor") String auditor, @Param("date") Date date);
}
