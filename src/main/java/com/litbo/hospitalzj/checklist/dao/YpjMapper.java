package com.litbo.hospitalzj.checklist.dao;

import com.litbo.hospitalzj.checklist.domain.Ypj;
import com.litbo.hospitalzj.checklist.domain.YpjTemplate;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface YpjMapper {

    //查询模板值
    @Select("select * from ypj_template order by ypj_template_id desc limit 1")
    YpjTemplate findTemplate();
    //修改模板表数据
    @Update(" update ypj_template\n" +
            "    set gdyzs_jctj1 = #{gdyzsJctj1,jdbcType=VARCHAR},\n" +
            "      gdyzs_jctj2 = #{gdyzsJctj2,jdbcType=VARCHAR},\n" +
            "      gdyzs_zbyq = #{gdyzsZbyq,jdbcType=VARCHAR},\n" +
            "      fsscl_jctj = #{fssclJctj,jdbcType=VARCHAR},\n" +
            "      fsscl_zbyq = #{fssclZbyq,jdbcType=VARCHAR},\n" +
            "      yyxsbzc_jctj1 = #{yyxsbzcJctj1,jdbcType=VARCHAR},\n" +
            "      yyxsbzc_jctj2 = #{yyxsbzcJctj2,jdbcType=VARCHAR},\n" +
            "      zlg_jctj = #{zlgJctj,jdbcType=VARCHAR},\n" +
            "      zlg_zbyq = #{zlgZbyq,jdbcType=VARCHAR}" +
            "    where ypj_template_id = #{ypjTemplateId,jdbcType=INTEGER}")
    int updateYpjTemplate(YpjTemplate ypjTemplate);
    //插入模板表数据
    @Insert(" insert into ypj_template ( gdyzs_jctj1, gdyzs_jctj2, \n" +
            "      gdyzs_zbyq, fsscl_jctj, fsscl_zbyq, \n" +
            "      yyxsbzc_jctj1, yyxsbzc_jctj2, zlg_jctj, \n" +
            "      zlg_zbyq)\n" +
            "    values ( #{gdyzsJctj1,jdbcType=VARCHAR}, #{gdyzsJctj2,jdbcType=VARCHAR}, \n" +
            "      #{gdyzsZbyq,jdbcType=VARCHAR}, #{fssclJctj,jdbcType=VARCHAR}, #{fssclZbyq,jdbcType=VARCHAR}, \n" +
            "      #{yyxsbzcJctj1,jdbcType=VARCHAR}, #{yyxsbzcJctj2,jdbcType=VARCHAR}, #{zlgJctj,jdbcType=VARCHAR}, \n" +
            "      #{zlgZbyq,jdbcType=VARCHAR})")
    int insert(YpjTemplate ypjTemplate);

    //保存
    @Insert("insert into ypj (jcyq_id, eq_id, \n" +
            "      shr_jcjl, tester, auditor, \n" +
            "      test_time, shsj_time, jcjl, \n" +
            "      jcsm, gdyzs_jctj1, gdyzs_jctj2, \n" +
            "      gdyzs_result1, gdyzs_result2, gdyzs_zbyq, \n" +
            "      gdyzs_value1, gdyzs_value2, fsscl_jctj, \n" +
            "      fsscl_value, fsscl_zbyq, fsscl_result, \n" +
            "      yyxsbzc_jctj1, yyxsbzc_jctj2, yyxsbzc_value1, \n" +
            "      yyxsbzc_value2, zlg_jctj, zlg_value, \n" +
            "      zlg_zbyq, zlg_result) " +
            "values (#{jcyqId,jdbcType=INTEGER}, #{eqId,jdbcType=INTEGER}, \n" +
            "      #{shrJcjl,jdbcType=VARCHAR}, #{tester,jdbcType=VARCHAR}, #{auditor,jdbcType=VARCHAR}, \n" +
            "      #{testTime,jdbcType=TIMESTAMP}, #{shsjTime,jdbcType=TIMESTAMP}, #{jcjl,jdbcType=VARCHAR}, \n" +
            "      #{jcsm,jdbcType=VARCHAR}, #{gdyzsJctj1,jdbcType=VARCHAR}, #{gdyzsJctj2,jdbcType=VARCHAR}, \n" +
            "      #{gdyzsResult1,jdbcType=INTEGER}, #{gdyzsResult2,jdbcType=INTEGER}, #{gdyzsZbyq,jdbcType=VARCHAR}, \n" +
            "      #{gdyzsValue1,jdbcType=VARCHAR}, #{gdyzsValue2,jdbcType=VARCHAR}, #{fssclJctj,jdbcType=VARCHAR}, \n" +
            "      #{fssclValue,jdbcType=VARCHAR}, #{fssclZbyq,jdbcType=VARCHAR}, #{fssclResult,jdbcType=INTEGER}, \n" +
            "      #{yyxsbzcJctj1,jdbcType=VARCHAR}, #{yyxsbzcJctj2,jdbcType=VARCHAR}, #{yyxsbzcValue1,jdbcType=VARCHAR}, \n" +
            "      #{yyxsbzcValue2,jdbcType=VARCHAR}, #{zlgJctj,jdbcType=VARCHAR}, #{zlgValue,jdbcType=VARCHAR}, \n" +
            "      #{zlgZbyq,jdbcType=VARCHAR}, #{zlgResult,jdbcType=TINYINT})")
    @Options(useGeneratedKeys = true, keyProperty = "ypjId", keyColumn = "ypj_id")
    void save(Ypj ypj);
    //修改数据
    @Update(" update ypj\n" +
            "    set jcyq_id = #{jcyqId,jdbcType=INTEGER},\n" +
            "      eq_id = #{eqId,jdbcType=INTEGER},\n" +
            "      shr_jcjl = #{shrJcjl,jdbcType=VARCHAR},\n" +
            "      tester = #{tester,jdbcType=VARCHAR},\n" +
            "      auditor = #{auditor,jdbcType=VARCHAR},\n" +
            "      test_time = #{testTime,jdbcType=TIMESTAMP},\n" +
            "      shsj_time = #{shsjTime,jdbcType=TIMESTAMP},\n" +
            "      jcjl = #{jcjl,jdbcType=VARCHAR},\n" +
            "      jcsm = #{jcsm,jdbcType=VARCHAR},\n" +
            "      gdyzs_jctj1 = #{gdyzsJctj1,jdbcType=VARCHAR},\n" +
            "      gdyzs_jctj2 = #{gdyzsJctj2,jdbcType=VARCHAR},\n" +
            "      gdyzs_result1 = #{gdyzsResult1,jdbcType=INTEGER},\n" +
            "      gdyzs_result2 = #{gdyzsResult2,jdbcType=INTEGER},\n" +
            "      gdyzs_zbyq = #{gdyzsZbyq,jdbcType=VARCHAR},\n" +
            "      gdyzs_value1 = #{gdyzsValue1,jdbcType=VARCHAR},\n" +
            "      gdyzs_value2 = #{gdyzsValue2,jdbcType=VARCHAR},\n" +
            "      fsscl_jctj = #{fssclJctj,jdbcType=VARCHAR},\n" +
            "      fsscl_value = #{fssclValue,jdbcType=VARCHAR},\n" +
            "      fsscl_zbyq = #{fssclZbyq,jdbcType=VARCHAR},\n" +
            "      fsscl_result = #{fssclResult,jdbcType=INTEGER},\n" +
            "      yyxsbzc_jctj1 = #{yyxsbzcJctj1,jdbcType=VARCHAR},\n" +
            "      yyxsbzc_jctj2 = #{yyxsbzcJctj2,jdbcType=VARCHAR},\n" +
            "      yyxsbzc_value1 = #{yyxsbzcValue1,jdbcType=VARCHAR},\n" +
            "      yyxsbzc_value2 = #{yyxsbzcValue2,jdbcType=VARCHAR},\n" +
            "      zlg_jctj = #{zlgJctj,jdbcType=VARCHAR},\n" +
            "      zlg_value = #{zlgValue,jdbcType=VARCHAR},\n" +
            "      zlg_zbyq = #{zlgZbyq,jdbcType=VARCHAR},\n" +
            "      zlg_result = #{zlgResult,jdbcType=TINYINT}" +
            "    where ypj_id = #{ypjId,jdbcType=INTEGER}")
    void updateYpj(Ypj ypj);
    //根据设备id查询检测表婴儿培养箱
    @Select("select * from ypj where eq_id =#{eqId} order by ypj_id desc limit 1")
    public Ypj findYpj(String eqId);
    //查询一条
    @Select("select * from ypj order by ypj_id desc limit 1")
    Ypj find();
    //根据设备Id,检测仪器Id以及状态查询电切表查询最后一条记录
    @Select("select ypj.* from ypj where ypj.eq_id=#{eqId} and ypj.jcyq_id=#{jcyqId} order by test_time desc, ypj_id desc limit 1" )
    Ypj findByEqIdandJcyqIdLast1(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //根据设备Id,检测仪器Id以及状态查询电切表
    @Select("select ypj.* from ypj where ypj.eq_id=#{eqId} and ypj.jcyq_id=#{jcyqId}" )
    List<Ypj> findByEqIdandJcyqId(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //查询所有
    @Select("select * from ypj")
    List<Ypj> findAll();

    //根据检测仪器Id查询
    @Select("select ypj.* from ypj where ypj_id=#{ypjId}" )
    Ypj findByYpjId(@Param("ypjId") Integer ypjId);

    //修改审核人意见
    @Update("update ypj set shr_jcjl=#{shrJcjl},auditor=#{auditor},shsj_time=#{shsjTime} where ypj_id=#{ypjId}")
    void updateShrJcjy(@Param("ypjId") Integer ypjId, @Param("shrJcjl") String shrJcjl, @Param("auditor") String auditor, @Param("shsjTime") Date shsjTime);
}

