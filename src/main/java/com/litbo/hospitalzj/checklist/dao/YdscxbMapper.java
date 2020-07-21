package com.litbo.hospitalzj.checklist.dao;

import com.litbo.hospitalzj.checklist.domain.Ydscxb;
import com.litbo.hospitalzj.checklist.domain.YdscxbTemplate;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface YdscxbMapper {
    //查询模板值
    @Select("select * from ydscxb_template order by  ydscxb_template_id desc limit 1")
    YdscxbTemplate findTemplate();
    //修改模板表数据
    @Update(" update ydscxb_template\n" +
            "    set  gdyzspl_jctj1 = #{gdyzsplJctj1,jdbcType=VARCHAR},\n" +
            "      gdyzspl_jctj2 = #{gdyzsplJctj2,jdbcType=VARCHAR},\n" +
            "      gdyzspl_jctj3 = #{gdyzsplJctj3,jdbcType=VARCHAR},\n" +
            "      gdyzspl_jctj4 = #{gdyzsplJctj4,jdbcType=VARCHAR},\n" +
            "      gdyzspl_jctj5 = #{gdyzsplJctj5,jdbcType=VARCHAR},\n" +
            "      gdyzspl_jctj6 = #{gdyzsplJctj6,jdbcType=VARCHAR},\n" +
            "      gdyzspl_jctj7 = #{gdyzsplJctj7,jdbcType=VARCHAR},\n" +
            "      gdyzspl_jctj8 = #{gdyzsplJctj8,jdbcType=VARCHAR},\n" +
            "      gdyzspl_zbyq = #{gdyzsplZbyq,jdbcType=VARCHAR},\n" +
            "      yyxsbzc_jctj = #{yyxsbzcJctj,jdbcType=VARCHAR},\n" +
            "      yyxsbzc_zbyq = #{yyxsbzcZbyq,jdbcType=VARCHAR},\n" +
            "      tssjzrstb_jctj = #{tssjzrstbJctj,jdbcType=VARCHAR},\n" +
            "      tssjzrstb_zbyq = #{tssjzrstbZbyq,jdbcType=VARCHAR},\n" +
            "      kjfbl_jctj = #{kjfblJctj,jdbcType=INTEGER},\n" +
            "      kjfbl_zbyq = #{kjfblZbyq,jdbcType=VARCHAR},\n" +
            "      ddbfbl_jctj1 = #{ddbfblJctj1,jdbcType=VARCHAR},\n" +
            "      ddbfbl_jctj2 = #{ddbfblJctj2,jdbcType=VARCHAR},\n" +
            "      ddbfbl_zbyq = #{ddbfblZbyq,jdbcType=VARCHAR},\n" +
            "      yxjsq_jctj = #{yxjsqJctj,jdbcType=VARCHAR},\n" +
            "      yxjsq_zbyq = #{yxjsqZbyq,jdbcType=VARCHAR},\n" +
            "      zdldkz_zbyq = #{zdldkzZbyq,jdbcType=VARCHAR},\n" +
            "      state = #{state,jdbcType=VARCHAR}" +
            "    where ydscxb_template_id = #{ydscxbTemplateId,jdbcType=INTEGER}")
    void updateYdscxbTemplate(YdscxbTemplate ydscxbTemplate);
    //插入模板表数据
    @Insert(" insert into ydscxb_template ( gdyzspl_jctj1, gdyzspl_jctj2, \n" +
            "      gdyzspl_jctj3, gdyzspl_jctj4, gdyzspl_jctj5, \n" +
            "      gdyzspl_jctj6, gdyzspl_jctj7, gdyzspl_jctj8, \n" +
            "      gdyzspl_zbyq, yyxsbzc_jctj, yyxsbzc_zbyq, \n" +
            "      tssjzrstb_jctj, tssjzrstb_zbyq, kjfbl_jctj, \n" +
            "      kjfbl_zbyq, ddbfbl_jctj1, ddbfbl_jctj2, \n" +
            "      ddbfbl_zbyq, yxjsq_jctj, yxjsq_zbyq, \n" +
            "      zdldkz_zbyq, state)\n" +
            "    values ( #{gdyzsplJctj1,jdbcType=VARCHAR}, #{gdyzsplJctj2,jdbcType=VARCHAR}, \n" +
            "      #{gdyzsplJctj3,jdbcType=VARCHAR}, #{gdyzsplJctj4,jdbcType=VARCHAR}, #{gdyzsplJctj5,jdbcType=VARCHAR}, \n" +
            "      #{gdyzsplJctj6,jdbcType=VARCHAR}, #{gdyzsplJctj7,jdbcType=VARCHAR}, #{gdyzsplJctj8,jdbcType=VARCHAR}, \n" +
            "      #{gdyzsplZbyq,jdbcType=VARCHAR}, #{yyxsbzcJctj,jdbcType=VARCHAR}, #{yyxsbzcZbyq,jdbcType=VARCHAR}, \n" +
            "      #{tssjzrstbJctj,jdbcType=VARCHAR}, #{tssjzrstbZbyq,jdbcType=VARCHAR}, #{kjfblJctj,jdbcType=INTEGER}, \n" +
            "      #{kjfblZbyq,jdbcType=VARCHAR}, #{ddbfblJctj1,jdbcType=VARCHAR}, #{ddbfblJctj2,jdbcType=VARCHAR}, \n" +
            "      #{ddbfblZbyq,jdbcType=VARCHAR}, #{yxjsqJctj,jdbcType=VARCHAR}, #{yxjsqZbyq,jdbcType=VARCHAR}, \n" +
            "      #{zdldkzZbyq,jdbcType=VARCHAR}, #{state,jdbcType=VARCHAR})")
    void insert(YdscxbTemplate ydscxbTemplate);
    //修改数据
    @Update(" update ydscxb\n" +
            "    set jcyq_id = #{jcyqId,jdbcType=INTEGER},\n" +
            "      eq_id = #{eqId,jdbcType=INTEGER},\n" +
            "      tester = #{tester,jdbcType=VARCHAR},\n" +
            "      test_time = #{testTime,jdbcType=TIMESTAMP},\n" +
            "      auditor = #{auditor,jdbcType=VARCHAR},\n" +
            "      shr_jcjl = #{shrJcjl,jdbcType=VARCHAR},\n" +
            "      shsj_time = #{shsjTime,jdbcType=TIMESTAMP},\n" +
            "      jcjl = #{jcjl,jdbcType=VARCHAR},\n" +
            "      jcsm = #{jcsm,jdbcType=VARCHAR},\n" +
            "      gdyzspl_jctj1 = #{gdyzsplJctj1,jdbcType=VARCHAR},\n" +
            "      gdyzspl_jctj2 = #{gdyzsplJctj2,jdbcType=VARCHAR},\n" +
            "      gdyzspl_jctj3 = #{gdyzsplJctj3,jdbcType=VARCHAR},\n" +
            "      gdyzspl_jctj4 = #{gdyzsplJctj4,jdbcType=VARCHAR},\n" +
            "      gdyzspl_jctj5 = #{gdyzsplJctj5,jdbcType=VARCHAR},\n" +
            "      gdyzspl_jctj6 = #{gdyzsplJctj6,jdbcType=VARCHAR},\n" +
            "      gdyzspl_jctj7 = #{gdyzsplJctj7,jdbcType=VARCHAR},\n" +
            "      gdyzspl_jctj8 = #{gdyzsplJctj8,jdbcType=VARCHAR},\n" +
            "      gdyzspl_value1 = #{gdyzsplValue1,jdbcType=VARCHAR},\n" +
            "      gdyzspl_value2 = #{gdyzsplValue2,jdbcType=VARCHAR},\n" +
            "      gdyzspl_value3 = #{gdyzsplValue3,jdbcType=VARCHAR},\n" +
            "      gdyzspl_value4 = #{gdyzsplValue4,jdbcType=VARCHAR},\n" +
            "      gdyzspl_value5 = #{gdyzsplValue5,jdbcType=VARCHAR},\n" +
            "      gdyzspl_value6 = #{gdyzsplValue6,jdbcType=VARCHAR},\n" +
            "      gdyzspl_value7 = #{gdyzsplValue7,jdbcType=VARCHAR},\n" +
            "      gdyzspl_value8 = #{gdyzsplValue8,jdbcType=VARCHAR},\n" +
            "      gdyzspl_res1 = #{gdyzsplRes1,jdbcType=VARCHAR},\n" +
            "      gdyzspl_res2 = #{gdyzsplRes2,jdbcType=VARCHAR},\n" +
            "      gdyzspl_res3 = #{gdyzsplRes3,jdbcType=VARCHAR},\n" +
            "      gdyzspl_res4 = #{gdyzsplRes4,jdbcType=VARCHAR},\n" +
            "      gdyzspl_zbyq = #{gdyzsplZbyq,jdbcType=VARCHAR},\n" +
            "      yyxsbzc_jctj = #{yyxsbzcJctj,jdbcType=VARCHAR},\n" +
            "      yyxsbzc_zbyq = #{yyxsbzcZbyq,jdbcType=VARCHAR},\n" +
            "      yyxsbzc_res = #{yyxsbzcRes,jdbcType=TINYINT},\n" +
            "      yyxsbzc_value = #{yyxsbzcValue,jdbcType=VARCHAR},\n" +
            "      tssjzrstb_jctj = #{tssjzrstbJctj,jdbcType=VARCHAR},\n" +
            "      tssjzrstb_value = #{tssjzrstbValue,jdbcType=VARCHAR},\n" +
            "      tssjzrstb_zbyq = #{tssjzrstbZbyq,jdbcType=VARCHAR},\n" +
            "      tssjzrstb_res = #{tssjzrstbRes,jdbcType=TINYINT},\n" +
            "      kjfbl_jctj = #{kjfblJctj,jdbcType=INTEGER},\n" +
            "      kjfbl_zbyq = #{kjfblZbyq,jdbcType=VARCHAR},\n" +
            "      kjfbl_res = #{kjfblRes,jdbcType=TINYINT},\n" +
            "      kjfbl_value = #{kjfblValue,jdbcType=VARCHAR},\n" +
            "      ddbfbl_jctj1 = #{ddbfblJctj1,jdbcType=VARCHAR},\n" +
            "      ddbfbl_jctj2 = #{ddbfblJctj2,jdbcType=VARCHAR},\n" +
            "      ddbfbl_value1 = #{ddbfblValue1,jdbcType=VARCHAR},\n" +
            "      ddbfbl_value2 = #{ddbfblValue2,jdbcType=VARCHAR},\n" +
            "      ddbfbl_zbyq = #{ddbfblZbyq,jdbcType=VARCHAR},\n" +
            "      ddbfbl_res1 = #{ddbfblRes1,jdbcType=TINYINT},\n" +
            "      ddbfbl_res2 = #{ddbfblRes2,jdbcType=TINYINT},\n" +
            "      yxjsq_jctj = #{yxjsqJctj,jdbcType=VARCHAR},\n" +
            "      yxjsq_value = #{yxjsqValue,jdbcType=VARCHAR},\n" +
            "      yxjsq_zbyq = #{yxjsqZbyq,jdbcType=VARCHAR},\n" +
            "      yxjsq_res = #{yxjsqRes,jdbcType=INTEGER},\n" +
            "      zdldkz_value = #{zdldkzValue,jdbcType=VARCHAR},\n" +
            "      zdldkz_zbyq = #{zdldkzZbyq,jdbcType=VARCHAR},\n" +
            "      state = #{state,jdbcType=VARCHAR}" +
            "    where yd_id = #{ydId,jdbcType=INTEGER}")
    void updateYdscxb(Ydscxb ydscxb);

    @Select("select * from ydscxb where eq_id =#{eqId} order by yd_id desc limit 1")
    Ydscxb findYdscxb(String eqId);

    @Select("select * from ydscxb order by yd_id desc limit 1")
    Ydscxb find();

    //根据设备Id,检测仪器Id以及状态查询电切表查询最后一条记录
    @Select("select ydscxb.* from ydscxb where ydscxb.eq_id=#{eqId} and ydscxb.jcyq_id=#{jcyqId} order by test_time desc, yd_id desc limit 1" )
    Ydscxb findByEqIdandJcyqIdLast1(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //根据设备Id,检测仪器Id以及状态查询电切表
    @Select("select ydscxb.* from ydscxb where ydscxb.eq_id=#{eqId} and ydscxb.jcyq_id=#{jcyqId}" )
    List<Ydscxb> findByEqIdandJcyqId(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //查询所有
    @Select("select * from ydscxb")
    List<Ydscxb> findAll();

    //保存
    @Insert("insert into ydscxb ( jcyq_id, eq_id, \n" +
            "      tester, test_time, auditor, \n" +
            "      shr_jcjl, shsj_time, jcjl, \n" +
            "      jcsm, gdyzspl_jctj1, gdyzspl_jctj2, \n" +
            "      gdyzspl_jctj3, gdyzspl_jctj4, gdyzspl_jctj5, \n" +
            "      gdyzspl_jctj6, gdyzspl_jctj7, gdyzspl_jctj8, \n" +
            "      gdyzspl_value1, gdyzspl_value2, gdyzspl_value3, \n" +
            "      gdyzspl_value4, gdyzspl_value5, gdyzspl_value6, \n" +
            "      gdyzspl_value7, gdyzspl_value8, gdyzspl_res1, \n" +
            "      gdyzspl_res2, gdyzspl_res3, gdyzspl_res4, \n" +
            "      gdyzspl_zbyq, yyxsbzc_jctj, yyxsbzc_zbyq, \n" +
            "      yyxsbzc_res, yyxsbzc_value, tssjzrstb_jctj, \n" +
            "      tssjzrstb_value, tssjzrstb_zbyq, tssjzrstb_res, \n" +
            "      kjfbl_jctj, kjfbl_zbyq, kjfbl_res, \n" +
            "      kjfbl_value, ddbfbl_jctj1, ddbfbl_jctj2, \n" +
            "      ddbfbl_value1, ddbfbl_value2, ddbfbl_zbyq, \n" +
            "      ddbfbl_res1, ddbfbl_res2, yxjsq_jctj, \n" +
            "      yxjsq_value, yxjsq_zbyq, yxjsq_res, \n" +
            "      zdldkz_value, zdldkz_zbyq, state) " +
            "values ( #{jcyqId,jdbcType=INTEGER}, #{eqId,jdbcType=INTEGER}, \n" +
            "      #{tester,jdbcType=VARCHAR}, #{testTime,jdbcType=TIMESTAMP}, #{auditor,jdbcType=VARCHAR}, \n" +
            "      #{shrJcjl,jdbcType=VARCHAR}, #{shsjTime,jdbcType=TIMESTAMP}, #{jcjl,jdbcType=VARCHAR}, \n" +
            "      #{jcsm,jdbcType=VARCHAR}, #{gdyzsplJctj1,jdbcType=VARCHAR}, #{gdyzsplJctj2,jdbcType=VARCHAR}, \n" +
            "      #{gdyzsplJctj3,jdbcType=VARCHAR}, #{gdyzsplJctj4,jdbcType=VARCHAR}, #{gdyzsplJctj5,jdbcType=VARCHAR}, \n" +
            "      #{gdyzsplJctj6,jdbcType=VARCHAR}, #{gdyzsplJctj7,jdbcType=VARCHAR}, #{gdyzsplJctj8,jdbcType=VARCHAR}, \n" +
            "      #{gdyzsplValue1,jdbcType=VARCHAR}, #{gdyzsplValue2,jdbcType=VARCHAR}, #{gdyzsplValue3,jdbcType=VARCHAR}, \n" +
            "      #{gdyzsplValue4,jdbcType=VARCHAR}, #{gdyzsplValue5,jdbcType=VARCHAR}, #{gdyzsplValue6,jdbcType=VARCHAR}, \n" +
            "      #{gdyzsplValue7,jdbcType=VARCHAR}, #{gdyzsplValue8,jdbcType=VARCHAR}, #{gdyzsplRes1,jdbcType=VARCHAR}, \n" +
            "      #{gdyzsplRes2,jdbcType=VARCHAR}, #{gdyzsplRes3,jdbcType=VARCHAR}, #{gdyzsplRes4,jdbcType=VARCHAR}, \n" +
            "      #{gdyzsplZbyq,jdbcType=VARCHAR}, #{yyxsbzcJctj,jdbcType=VARCHAR}, #{yyxsbzcZbyq,jdbcType=VARCHAR}, \n" +
            "      #{yyxsbzcRes,jdbcType=TINYINT}, #{yyxsbzcValue,jdbcType=VARCHAR}, #{tssjzrstbJctj,jdbcType=VARCHAR}, \n" +
            "      #{tssjzrstbValue,jdbcType=VARCHAR}, #{tssjzrstbZbyq,jdbcType=VARCHAR}, #{tssjzrstbRes,jdbcType=TINYINT}, \n" +
            "      #{kjfblJctj,jdbcType=INTEGER}, #{kjfblZbyq,jdbcType=VARCHAR}, #{kjfblRes,jdbcType=TINYINT}, \n" +
            "      #{kjfblValue,jdbcType=VARCHAR}, #{ddbfblJctj1,jdbcType=VARCHAR}, #{ddbfblJctj2,jdbcType=VARCHAR}, \n" +
            "      #{ddbfblValue1,jdbcType=VARCHAR}, #{ddbfblValue2,jdbcType=VARCHAR}, #{ddbfblZbyq,jdbcType=VARCHAR}, \n" +
            "      #{ddbfblRes1,jdbcType=TINYINT}, #{ddbfblRes2,jdbcType=TINYINT}, #{yxjsqJctj,jdbcType=VARCHAR}, \n" +
            "      #{yxjsqValue,jdbcType=VARCHAR}, #{yxjsqZbyq,jdbcType=VARCHAR}, #{yxjsqRes,jdbcType=INTEGER}, \n" +
            "      #{zdldkzValue,jdbcType=VARCHAR}, #{zdldkzZbyq,jdbcType=VARCHAR}, #{state,jdbcType=VARCHAR})")
    @Options(useGeneratedKeys = true, keyColumn = "ydscxb_template_id", keyProperty = "ydscxbTemplateId")
    void save(Ydscxb ydscxb);

    //修改审核人意见
    @Update("update ydscxb set shr_jcjl=#{shrJcjl},auditor=#{auditor},shsj_time=#{shsjTime} where yd_id=#{ydId}")
    void updateShrJcjy(@Param("ydId") Integer ydId, @Param("shrJcjl") String shrJcjl, @Param("auditor") String auditor, @Param("date") Date date);
    //根据检测仪器Id查询
    @Select("select ydscxb.* from ydscxb where yd_id=#{ydId}" )
    Ydscxb findByydId(Integer ydId);
}
