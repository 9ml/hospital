package com.litbo.hospitalzj.checklist.dao;

import com.litbo.hospitalzj.checklist.domain.Pbszcwj;
import com.litbo.hospitalzj.checklist.domain.PbszcwjTemplate;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface PbszcwjMapper {

    //查询模板值
    @Select("select * from pbszcwj_template order by pbszcwj_template_id desc limit 1")
    PbszcwjTemplate findTemplate();
    //修改模板表数据
    @Update(" update pbszcwj_template\n" +
            "    set gdyzsdpl_jctj = #{gdyzsdplJctj,jdbcType=VARCHAR},\n" +
            "      gdyzsdpl_jctj1 = #{gdyzsdplJctj1,jdbcType=VARCHAR},\n" +
            "      gdyzsdpl_jctj2 = #{gdyzsdplJctj2,jdbcType=VARCHAR},\n" +
            "      gdyzsdpl_jctj3 = #{gdyzsdplJctj3,jdbcType=VARCHAR},\n" +
            "      gdyzsdpl_jctj4 = #{gdyzsdplJctj4,jdbcType=VARCHAR},\n" +
            "      gdyzsdpl_zbyq = #{gdyzsdplZbyq,jdbcType=VARCHAR},\n" +
            "      sclcfx_jctj = #{sclcfxJctj,jdbcType=VARCHAR},\n" +
            "      sclcfx_zbyq = #{sclcfxZbyq,jdbcType=VARCHAR},\n" +
            "      yyxsbzc_jctj = #{yyxsbzcJctj,jdbcType=VARCHAR},\n" +
            "      yyxsbzc_zbyq = #{yyxsbzcZbyq,jdbcType=VARCHAR},\n" +
            "      zdbgkzcfx_zbyq = #{zdbgkzcfxZbyq,jdbcType=VARCHAR},\n" +
            "      yyxsczdpl_jctj = #{yyxsczdplJctj,jdbcType=VARCHAR},\n" +
            "      yyxsczdpl_zbyq = #{yyxsczdplZbyq,jdbcType=VARCHAR},\n" +
            "      gyyzsysbdpl_jctj = #{gyyzsysbdplJctj,jdbcType=VARCHAR},\n" +
            "      gyyzsysbdpl_zbyq = #{gyyzsysbdplZbyq,jdbcType=VARCHAR},\n" +
            "      tssjzrstbkqbsdnldxz_jctj = #{tssjzrstbkqbsdnldxzJctj,jdbcType=VARCHAR},\n" +
            "      tssjzrstbkqbsdnldxz_zbyq = #{tssjzrstbkqbsdnldxzZbyq,jdbcType=VARCHAR},\n" +
            "      kjfbl_jctj = #{kjfblJctj,jdbcType=VARCHAR},\n" +
            "      ddbfbl_jctj1 = #{ddbfblJctj1,jdbcType=VARCHAR},\n" +
            "      ddbfbl_jctj2 = #{ddbfblJctj2,jdbcType=VARCHAR},\n" +
            "      ddbfbl_zbyq = #{ddbfblZbyq,jdbcType=VARCHAR}" +
            "    where pbszcwj_template_id = #{pbszcwjTemplateId,jdbcType=INTEGER}")
    int updatePbszcwjTemplate(PbszcwjTemplate pbszcwjTemplate);
    //插入模板表数据
    @Insert(" insert into pbszcwj_template (gdyzsdpl_jctj, \n" +
            "      gdyzsdpl_jctj1, gdyzsdpl_jctj2, gdyzsdpl_jctj3, \n" +
            "      gdyzsdpl_jctj4, gdyzsdpl_zbyq, sclcfx_jctj, \n" +
            "      sclcfx_zbyq, yyxsbzc_jctj, yyxsbzc_zbyq, \n" +
            "      zdbgkzcfx_zbyq, yyxsczdpl_jctj, yyxsczdpl_zbyq, \n" +
            "      gyyzsysbdpl_jctj, gyyzsysbdpl_zbyq, tssjzrstbkqbsdnldxz_jctj, \n" +
            "      tssjzrstbkqbsdnldxz_zbyq, kjfbl_jctj, ddbfbl_jctj1, \n" +
            "      ddbfbl_jctj2, ddbfbl_zbyq)\n" +
            "    values (#{gdyzsdplJctj,jdbcType=VARCHAR}, \n" +
            "      #{gdyzsdplJctj1,jdbcType=VARCHAR}, #{gdyzsdplJctj2,jdbcType=VARCHAR}, #{gdyzsdplJctj3,jdbcType=VARCHAR}, \n" +
            "      #{gdyzsdplJctj4,jdbcType=VARCHAR}, #{gdyzsdplZbyq,jdbcType=VARCHAR}, #{sclcfxJctj,jdbcType=VARCHAR}, \n" +
            "      #{sclcfxZbyq,jdbcType=VARCHAR}, #{yyxsbzcJctj,jdbcType=VARCHAR}, #{yyxsbzcZbyq,jdbcType=VARCHAR}, \n" +
            "      #{zdbgkzcfxZbyq,jdbcType=VARCHAR}, #{yyxsczdplJctj,jdbcType=VARCHAR}, #{yyxsczdplZbyq,jdbcType=VARCHAR}, \n" +
            "      #{gyyzsysbdplJctj,jdbcType=VARCHAR}, #{gyyzsysbdplZbyq,jdbcType=VARCHAR}, #{tssjzrstbkqbsdnldxzJctj,jdbcType=VARCHAR}, \n" +
            "      #{tssjzrstbkqbsdnldxzZbyq,jdbcType=VARCHAR}, #{kjfblJctj,jdbcType=VARCHAR}, #{ddbfblJctj1,jdbcType=VARCHAR}, \n" +
            "      #{ddbfblJctj2,jdbcType=VARCHAR}, #{ddbfblZbyq,jdbcType=VARCHAR})")
    int insert(PbszcwjTemplate pbszcwjTemplate);

    //保存
    @Insert("insert into pbszcwj (jcyq_id, eq_id, \n" +
            "      tester, shr_jcjl, auditor, \n" +
            "      test_time, shsj_time, jcjl, \n" +
            "      jcsm, gdyzsdpl_jctj, gdyzsdpl_jctj1, \n" +
            "      gdyzsdpl_jctj2, gdyzsdpl_jctj3, gdyzsdpl_jctj4, \n" +
            "      gdyzsdpl_value1, gdyzsdpl_value2, gdyzsdpl_value3, \n" +
            "      gdyzsdpl_value4, gdyzsdpl_value5, gdyzsdpl_value6, \n" +
            "      gdyzsdpl_value7, gdyzsdpl_value8, gdyzsdpl_zbyq, \n" +
            "      gdyzsdpl_result1, gdyzsdpl_result2, gdyzsdpl_result3, \n" +
            "      gdyzsdpl_result4, sclcfx_jctj, sclcfx_value, \n" +
            "      sclcfx_zbyq, sclcfx_result, yyxsbzc_jctj, \n" +
            "      yyxsbzc_value, yyxsbzc_zbyq, yyxsbzc_result, \n" +
            "      zdbgkzcfx_value, zdbgkzcfx_zbyq, yyxsczdpl_jctj, \n" +
            "      yyxsczdpl_value, yyxsczdpl_zbyq, yyxsczdpl_result, \n" +
            "      gyyzsysbdpl_jctj, gyyzsysbdpl_value1, gyyzsysbdpl_value2, \n" +
            "      gyyzsysbdpl_value3, gyyzsysbdpl_value4, gyyzsysbdpl_value5, \n" +
            "      gyyzsysbdpl_value6, gyyzsysbdpl_value7, gyyzsysbdpl_value8, \n" +
            "      gyyzsysbdpl_zbyq, gyyzsysbdpl_result, tssjzrstbkqbsdnldxz_jctj, \n" +
            "      tssjzrstbkqbsdnldxz_value, tssjzrstbkqbsdnldxz_zbyq, \n" +
            "      tssjzrstbkqbsdnldxz_result, kjfbl_jctj, kjfbl_value, \n" +
            "      ddbfbl_jctj1, ddbfbl_jctj2, ddbfbl_value1, \n" +
            "      ddbfbl_value2, ddbfbl_zbyq, ddbfbl_result) " +
            "values ( #{jcyqId,jdbcType=INTEGER}, #{eqId,jdbcType=INTEGER}, \n" +
            "      #{tester,jdbcType=VARCHAR}, #{shrJcjl,jdbcType=VARCHAR}, #{auditor,jdbcType=VARCHAR}, \n" +
            "      #{testTime,jdbcType=TIMESTAMP}, #{shsjTime,jdbcType=TIMESTAMP}, #{jcjl,jdbcType=VARCHAR}, \n" +
            "      #{jcsm,jdbcType=VARCHAR}, #{gdyzsdplJctj,jdbcType=VARCHAR}, #{gdyzsdplJctj1,jdbcType=VARCHAR}, \n" +
            "      #{gdyzsdplJctj2,jdbcType=VARCHAR}, #{gdyzsdplJctj3,jdbcType=VARCHAR}, #{gdyzsdplJctj4,jdbcType=VARCHAR}, \n" +
            "      #{gdyzsdplValue1,jdbcType=VARCHAR}, #{gdyzsdplValue2,jdbcType=VARCHAR}, #{gdyzsdplValue3,jdbcType=VARCHAR}, \n" +
            "      #{gdyzsdplValue4,jdbcType=VARCHAR}, #{gdyzsdplValue5,jdbcType=VARCHAR}, #{gdyzsdplValue6,jdbcType=VARCHAR}, \n" +
            "      #{gdyzsdplValue7,jdbcType=VARCHAR}, #{gdyzsdplValue8,jdbcType=VARCHAR}, #{gdyzsdplZbyq,jdbcType=VARCHAR}, \n" +
            "      #{gdyzsdplResult1,jdbcType=TINYINT}, #{gdyzsdplResult2,jdbcType=TINYINT}, #{gdyzsdplResult3,jdbcType=TINYINT}, \n" +
            "      #{gdyzsdplResult4,jdbcType=TINYINT}, #{sclcfxJctj,jdbcType=VARCHAR}, #{sclcfxValue,jdbcType=VARCHAR}, \n" +
            "      #{sclcfxZbyq,jdbcType=VARCHAR}, #{sclcfxResult,jdbcType=TINYINT}, #{yyxsbzcJctj,jdbcType=VARCHAR}, \n" +
            "      #{yyxsbzcValue,jdbcType=VARCHAR}, #{yyxsbzcZbyq,jdbcType=VARCHAR}, #{yyxsbzcResult,jdbcType=TINYINT}, \n" +
            "      #{zdbgkzcfxValue,jdbcType=VARCHAR}, #{zdbgkzcfxZbyq,jdbcType=VARCHAR}, #{yyxsczdplJctj,jdbcType=VARCHAR}, \n" +
            "      #{yyxsczdplValue,jdbcType=VARCHAR}, #{yyxsczdplZbyq,jdbcType=VARCHAR}, #{yyxsczdplResult,jdbcType=TINYINT}, \n" +
            "      #{gyyzsysbdplJctj,jdbcType=VARCHAR}, #{gyyzsysbdplValue1,jdbcType=VARCHAR}, #{gyyzsysbdplValue2,jdbcType=VARCHAR}, \n" +
            "      #{gyyzsysbdplValue3,jdbcType=VARCHAR}, #{gyyzsysbdplValue4,jdbcType=VARCHAR}, #{gyyzsysbdplValue5,jdbcType=VARCHAR}, \n" +
            "      #{gyyzsysbdplValue6,jdbcType=VARCHAR}, #{gyyzsysbdplValue7,jdbcType=VARCHAR}, #{gyyzsysbdplValue8,jdbcType=VARCHAR}, \n" +
            "      #{gyyzsysbdplZbyq,jdbcType=VARCHAR}, #{gyyzsysbdplResult,jdbcType=TINYINT}, #{tssjzrstbkqbsdnldxzJctj,jdbcType=VARCHAR}, \n" +
            "      #{tssjzrstbkqbsdnldxzValue,jdbcType=VARCHAR}, #{tssjzrstbkqbsdnldxzZbyq,jdbcType=VARCHAR}, \n" +
            "      #{tssjzrstbkqbsdnldxzResult,jdbcType=TINYINT}, #{kjfblJctj,jdbcType=VARCHAR}, #{kjfblValue,jdbcType=VARCHAR}, \n" +
            "      #{ddbfblJctj1,jdbcType=VARCHAR}, #{ddbfblJctj2,jdbcType=VARCHAR}, #{ddbfblValue1,jdbcType=VARCHAR}, \n" +
            "      #{ddbfblValue2,jdbcType=VARCHAR}, #{ddbfblZbyq,jdbcType=VARCHAR}, #{ddbfblResult,jdbcType=TINYINT})")
    @Options(useGeneratedKeys = true, keyProperty = "pbszcwjId", keyColumn = "pbszcwj_id")
    void save(Pbszcwj pbszcwj);
    //修改数据
    @Update(" update pbszcwj\n" +
            "    set jcyq_id = #{jcyqId,jdbcType=INTEGER},\n" +
            "      eq_id = #{eqId,jdbcType=INTEGER},\n" +
            "      tester = #{tester,jdbcType=VARCHAR},\n" +
            "      shr_jcjl = #{shrJcjl,jdbcType=VARCHAR},\n" +
            "      auditor = #{auditor,jdbcType=VARCHAR},\n" +
            "      test_time = #{testTime,jdbcType=TIMESTAMP},\n" +
            "      shsj_time = #{shsjTime,jdbcType=TIMESTAMP},\n" +
            "      jcjl = #{jcjl,jdbcType=VARCHAR},\n" +
            "      jcsm = #{jcsm,jdbcType=VARCHAR},\n" +
            "      gdyzsdpl_jctj = #{gdyzsdplJctj,jdbcType=VARCHAR},\n" +
            "      gdyzsdpl_jctj1 = #{gdyzsdplJctj1,jdbcType=VARCHAR},\n" +
            "      gdyzsdpl_jctj2 = #{gdyzsdplJctj2,jdbcType=VARCHAR},\n" +
            "      gdyzsdpl_jctj3 = #{gdyzsdplJctj3,jdbcType=VARCHAR},\n" +
            "      gdyzsdpl_jctj4 = #{gdyzsdplJctj4,jdbcType=VARCHAR},\n" +
            "      gdyzsdpl_value1 = #{gdyzsdplValue1,jdbcType=VARCHAR},\n" +
            "      gdyzsdpl_value2 = #{gdyzsdplValue2,jdbcType=VARCHAR},\n" +
            "      gdyzsdpl_value3 = #{gdyzsdplValue3,jdbcType=VARCHAR},\n" +
            "      gdyzsdpl_value4 = #{gdyzsdplValue4,jdbcType=VARCHAR},\n" +
            "      gdyzsdpl_value5 = #{gdyzsdplValue5,jdbcType=VARCHAR},\n" +
            "      gdyzsdpl_value6 = #{gdyzsdplValue6,jdbcType=VARCHAR},\n" +
            "      gdyzsdpl_value7 = #{gdyzsdplValue7,jdbcType=VARCHAR},\n" +
            "      gdyzsdpl_value8 = #{gdyzsdplValue8,jdbcType=VARCHAR},\n" +
            "      gdyzsdpl_zbyq = #{gdyzsdplZbyq,jdbcType=VARCHAR},\n" +
            "      gdyzsdpl_result1 = #{gdyzsdplResult1,jdbcType=TINYINT},\n" +
            "      gdyzsdpl_result2 = #{gdyzsdplResult2,jdbcType=TINYINT},\n" +
            "      gdyzsdpl_result3 = #{gdyzsdplResult3,jdbcType=TINYINT},\n" +
            "      gdyzsdpl_result4 = #{gdyzsdplResult4,jdbcType=TINYINT},\n" +
            "      sclcfx_jctj = #{sclcfxJctj,jdbcType=VARCHAR},\n" +
            "      sclcfx_value = #{sclcfxValue,jdbcType=VARCHAR},\n" +
            "      sclcfx_zbyq = #{sclcfxZbyq,jdbcType=VARCHAR},\n" +
            "      sclcfx_result = #{sclcfxResult,jdbcType=TINYINT},\n" +
            "      yyxsbzc_jctj = #{yyxsbzcJctj,jdbcType=VARCHAR},\n" +
            "      yyxsbzc_value = #{yyxsbzcValue,jdbcType=VARCHAR},\n" +
            "      yyxsbzc_zbyq = #{yyxsbzcZbyq,jdbcType=VARCHAR},\n" +
            "      yyxsbzc_result = #{yyxsbzcResult,jdbcType=TINYINT},\n" +
            "      zdbgkzcfx_value = #{zdbgkzcfxValue,jdbcType=VARCHAR},\n" +
            "      zdbgkzcfx_zbyq = #{zdbgkzcfxZbyq,jdbcType=VARCHAR},\n" +
            "      yyxsczdpl_jctj = #{yyxsczdplJctj,jdbcType=VARCHAR},\n" +
            "      yyxsczdpl_value = #{yyxsczdplValue,jdbcType=VARCHAR},\n" +
            "      yyxsczdpl_zbyq = #{yyxsczdplZbyq,jdbcType=VARCHAR},\n" +
            "      yyxsczdpl_result = #{yyxsczdplResult,jdbcType=TINYINT},\n" +
            "      gyyzsysbdpl_jctj = #{gyyzsysbdplJctj,jdbcType=VARCHAR},\n" +
            "      gyyzsysbdpl_value1 = #{gyyzsysbdplValue1,jdbcType=VARCHAR},\n" +
            "      gyyzsysbdpl_value2 = #{gyyzsysbdplValue2,jdbcType=VARCHAR},\n" +
            "      gyyzsysbdpl_value3 = #{gyyzsysbdplValue3,jdbcType=VARCHAR},\n" +
            "      gyyzsysbdpl_value4 = #{gyyzsysbdplValue4,jdbcType=VARCHAR},\n" +
            "      gyyzsysbdpl_value5 = #{gyyzsysbdplValue5,jdbcType=VARCHAR},\n" +
            "      gyyzsysbdpl_value6 = #{gyyzsysbdplValue6,jdbcType=VARCHAR},\n" +
            "      gyyzsysbdpl_value7 = #{gyyzsysbdplValue7,jdbcType=VARCHAR},\n" +
            "      gyyzsysbdpl_value8 = #{gyyzsysbdplValue8,jdbcType=VARCHAR},\n" +
            "      gyyzsysbdpl_zbyq = #{gyyzsysbdplZbyq,jdbcType=VARCHAR},\n" +
            "      gyyzsysbdpl_result = #{gyyzsysbdplResult,jdbcType=TINYINT},\n" +
            "      tssjzrstbkqbsdnldxz_jctj = #{tssjzrstbkqbsdnldxzJctj,jdbcType=VARCHAR},\n" +
            "      tssjzrstbkqbsdnldxz_value = #{tssjzrstbkqbsdnldxzValue,jdbcType=VARCHAR},\n" +
            "      tssjzrstbkqbsdnldxz_zbyq = #{tssjzrstbkqbsdnldxzZbyq,jdbcType=VARCHAR},\n" +
            "      tssjzrstbkqbsdnldxz_result = #{tssjzrstbkqbsdnldxzResult,jdbcType=TINYINT},\n" +
            "      kjfbl_jctj = #{kjfblJctj,jdbcType=VARCHAR},\n" +
            "      kjfbl_value = #{kjfblValue,jdbcType=VARCHAR},\n" +
            "      ddbfbl_jctj1 = #{ddbfblJctj1,jdbcType=VARCHAR},\n" +
            "      ddbfbl_jctj2 = #{ddbfblJctj2,jdbcType=VARCHAR},\n" +
            "      ddbfbl_value1 = #{ddbfblValue1,jdbcType=VARCHAR},\n" +
            "      ddbfbl_value2 = #{ddbfblValue2,jdbcType=VARCHAR},\n" +
            "      ddbfbl_zbyq = #{ddbfblZbyq,jdbcType=VARCHAR},\n" +
            "      ddbfbl_result = #{ddbfblResult,jdbcType=TINYINT}" +
            "    where pbszcwj_id = #{pbszcwjId,jdbcType=INTEGER}")
    void updatePbszcwj(Pbszcwj pbszcwj);
    //根据设备id查询检测表婴儿培养箱
    @Select("select * from pbszcwj where eq_id =#{eqId} order by pbszcwj_id desc limit 1")
    public Pbszcwj findPbszcwj(String eqId);
    //查询一条
    @Select("select * from pbszcwj order by pbszcwj_id desc limit 1")
    Pbszcwj find();
    //根据设备Id,检测仪器Id以及状态查询电切表查询最后一条记录
    @Select("select pbszcwj.* from pbszcwj where pbszcwj.eq_id=#{eqId} and pbszcwj.jcyq_id=#{jcyqId} order by test_time desc, pbszcwj_id desc limit 1" )
    Pbszcwj findByEqIdandJcyqIdLast1(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //根据设备Id,检测仪器Id以及状态查询电切表
    @Select("select pbszcwj.* from pbszcwj where pbszcwj.eq_id=#{eqId} and pbszcwj.jcyq_id=#{jcyqId}" )
    List<Pbszcwj> findByEqIdandJcyqId(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //查询所有
    @Select("select * from pbszcwj")
    List<Pbszcwj> findAll();

    //根据检测仪器Id查询
    @Select("select pbszcwj.* from pbszcwj where pbszcwj_id=#{pbszcwjId}" )
    Pbszcwj findByPbszcwjId(@Param("pbszcwjId") Integer pbszcwjId);

    //修改审核人意见
    @Update("update pbszcwj set shr_jcjl=#{shrJcjl},auditor=#{auditor},shsj_time=#{shsjTime} where pbszcwj_id=#{pbszcwjId}")
    void updateShrJcjy(@Param("pbszcwjId") Integer pbszcwjId, @Param("shrJcjl") String shrJcjl, @Param("auditor") String auditor, @Param("shsjTime") Date shsjTime);
}

