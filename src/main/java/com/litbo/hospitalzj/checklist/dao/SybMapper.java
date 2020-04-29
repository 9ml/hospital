package com.litbo.hospitalzj.checklist.dao;

import com.litbo.hospitalzj.checklist.domain.SybC;
import com.litbo.hospitalzj.checklist.domain.SybCTemplate;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * 输液泵， 注射泵mapper
 */
@Mapper
public interface SybMapper {
    //查询模板数据
    @Select("select * from ${tableName} order by temp_id desc limit 1")
    SybCTemplate findTemplate(@Param("tableName") String tableName);
    //修改模板表数据
    //幼儿
    @Update("update syb_c_template\n" +
            "    set llcsd1 = #{llcsd1,jdbcType=INTEGER},\n" +
            "      llcsd2 = #{llcsd2,jdbcType=INTEGER},\n" +
            "      wc = #{wc,jdbcType=INTEGER},\n" +
            "      zsbjllz = #{zsbjllz,jdbcType=INTEGER},\n" +
            "      zsbj_wc1 = #{zsbjWc1,jdbcType=INTEGER},\n" +
            "      zsbj_wc2 = #{zsbjWc2,jdbcType=INTEGER}\n" +
            "    where temp_id = #{tempId,jdbcType=BIGINT}")
    int updateC(SybCTemplate sybCTemplate);
    //成人
    @Update(" update syb_m_template\n" +
            "    set llcsd1 = #{llcsd1,jdbcType=INTEGER},\n" +
            "      llcsd2 = #{llcsd2,jdbcType=INTEGER},\n" +
            "      wc = #{wc,jdbcType=INTEGER},\n" +
            "      zsbjllz = #{zsbjllz,jdbcType=INTEGER},\n" +
            "      zsbj_wc1 = #{zsbjWc1,jdbcType=INTEGER},\n" +
            "      zsbj_wc2 = #{zsbjWc2,jdbcType=INTEGER}\n" +
            "    where temp_id = #{tempId,jdbcType=BIGINT}")
    int updateM(SybCTemplate sybCTemplate);
    //插入模板表数据
    //幼儿
    @Insert("insert into syb_c_template (temp_id, llcsd1, llcsd2, \n" +
            "      wc, zsbjllz, zsbj_wc1, \n" +
            "      zsbj_wc2)\n" +
            "    values (#{tempId,jdbcType=BIGINT}, #{llcsd1,jdbcType=INTEGER}, #{llcsd2,jdbcType=INTEGER}, \n" +
            "      #{wc,jdbcType=INTEGER}, #{zsbjllz,jdbcType=INTEGER}, #{zsbjWc1,jdbcType=INTEGER}, \n" +
            "      #{zsbjWc2,jdbcType=INTEGER})")
    void insertChildTemplate(SybCTemplate template);
    //成人
    @Insert("insert into syb_m_template (temp_id, llcsd1, llcsd2, \n" +
            "      wc, zsbjllz, zsbj_wc1, \n" +
            "      zsbj_wc2)\n" +
            "    values (#{tempId,jdbcType=BIGINT}, #{llcsd1,jdbcType=INTEGER}, #{llcsd2,jdbcType=INTEGER}, \n" +
            "      #{wc,jdbcType=INTEGER}, #{zsbjllz,jdbcType=INTEGER}, #{zsbjWc1,jdbcType=INTEGER}, \n" +
            "      #{zsbjWc2,jdbcType=INTEGER})")
    void insertManTemplate(SybCTemplate template);
    //保存信息
    //输液泵检测信息录入（幼儿）
    @Insert("insert into syb_c (id, jcyq_id, eq_id,  tester, auditor, test_time, shsj_time,   jcjl, jcsm, llcsd1,   pjll_1, llcsd2, pjll_2, \n" +
            "      wc, llcs_result, zsbjcsll,   bjsz_h, bjsz_m, bjsz_l,   bjsj_h, bjsj_m, bjsj_l,     bjyl_h, bjyl_m, bjyl_l, \n" +
            "      zsbj_wc1, zsbj_wc2, zsbj_result,    zs, sygbt, dyxtk, jjkp,   qpbj, kmbj)\n" +
            "    values (#{id,jdbcType=BIGINT}, #{jcyqId,jdbcType=INTEGER}, #{eqId,jdbcType=INTEGER}, \n" +
            "      #{tester,jdbcType=VARCHAR}, #{auditor,jdbcType=VARCHAR}, #{testTime,jdbcType=TIMESTAMP},#{shsjTime}, \n" +
            "      #{jcjl,jdbcType=VARCHAR}, #{jcsm,jdbcType=VARCHAR}, #{llcsd1,jdbcType=INTEGER}, \n" +
            "      #{pjll1,jdbcType=INTEGER}, #{llcsd2,jdbcType=INTEGER}, #{pjll2,jdbcType=INTEGER}, \n" +
            "      #{wc,jdbcType=INTEGER}, #{llcsResult,jdbcType=INTEGER}, #{zsbjcsll,jdbcType=INTEGER}, \n" +
            "      #{bjszH,jdbcType=INTEGER}, #{bjszM,jdbcType=INTEGER}, #{bjszL,jdbcType=INTEGER}, \n" +
            "      #{bjsjH,jdbcType=VARCHAR}, #{bjsjM,jdbcType=VARCHAR}, #{bjsjL,jdbcType=VARCHAR}, \n" +
            "      #{bjylH,jdbcType=INTEGER}, #{bjylM,jdbcType=INTEGER}, #{bjylL,jdbcType=INTEGER}, \n" +
            "      #{zsbjWc1,jdbcType=INTEGER}, #{zsbjWc2,jdbcType=INTEGER}, #{zsbjResult,jdbcType=TINYINT}, \n" +
            "      #{zs,jdbcType=TINYINT}, #{sygbt,jdbcType=TINYINT}, #{dyxtk,jdbcType=TINYINT}, #{jjkp,jdbcType=TINYINT}, \n" +
            "      #{qpbj,jdbcType=TINYINT}, #{kmbj,jdbcType=TINYINT})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void saveChild(SybC sybC);
    @Update("update syb_c\n" +
            "    set jcyq_id = #{jcyqId,jdbcType=INTEGER},\n" +
            "      eq_id = #{eqId,jdbcType=INTEGER},\n" +
            "      tester = #{tester,jdbcType=VARCHAR},\n" +
            "      auditor = #{auditor,jdbcType=VARCHAR},\n" +
            "      test_time = #{testTime,jdbcType=TIMESTAMP},\n" +
            "      jcjl = #{jcjl,jdbcType=VARCHAR},\n" +
            "      jcsm = #{jcsm,jdbcType=VARCHAR},\n" +
            "      llcsd1 = #{llcsd1,jdbcType=INTEGER},\n" +
            "      pjll_1 = #{pjll1,jdbcType=INTEGER},\n" +
            "      llcsd2 = #{llcsd2,jdbcType=INTEGER},\n" +
            "      pjll_2 = #{pjll2,jdbcType=INTEGER},\n" +
            "      wc = #{wc,jdbcType=INTEGER},\n" +
            "      llcs_result = #{llcsResult,jdbcType=INTEGER},\n" +
            "      zsbjcsll = #{zsbjcsll,jdbcType=INTEGER},\n" +
            "      bjsz_h = #{bjszH,jdbcType=INTEGER},\n" +
            "      bjsz_m = #{bjszM,jdbcType=INTEGER},\n" +
            "      bjsz_l = #{bjszL,jdbcType=INTEGER},\n" +
            "      bjsj_h = #{bjsjH,jdbcType=VARCHAR},\n" +
            "      bjsj_m = #{bjsjM,jdbcType=VARCHAR},\n" +
            "      bjsj_l = #{bjsjL,jdbcType=VARCHAR},\n" +
            "      bjyl_h = #{bjylH,jdbcType=INTEGER},\n" +
            "      bjyl_m = #{bjylM,jdbcType=INTEGER},\n" +
            "      bjyl_l = #{bjylL,jdbcType=INTEGER},\n" +
            "      zsbj_wc1 = #{zsbjWc1,jdbcType=INTEGER},\n" +
            "      zsbj_wc2 = #{zsbjWc2,jdbcType=INTEGER},\n" +
            "      zsbj_result = #{zsbjResult,jdbcType=TINYINT},\n" +
            "      zs = #{zs,jdbcType=TINYINT},\n" +
            "      sygbt = #{sygbt,jdbcType=TINYINT},\n" +
            "      dyxtk = #{dyxtk,jdbcType=TINYINT},\n" +
            "      jjkp = #{jjkp,jdbcType=TINYINT},\n" +
            "      qpbj = #{qpbj,jdbcType=TINYINT},\n" +
            "      kmbj = #{kmbj,jdbcType=TINYINT}\n" +
            "    where id = #{id,jdbcType=BIGINT}")
    void updateChild(SybC sybC);
    //输液泵检测信息录入（成人）
    @Insert("insert into syb_m (id, jcyq_id, eq_id,  tester, auditor, test_time, shsj_time,   jcjl, jcsm, llcsd1,   pjll_1, llcsd2, pjll_2, \n" +
            "      wc, llcs_result, zsbjcsll,   bjsz_h, bjsz_m, bjsz_l,   bjsj_h, bjsj_m, bjsj_l,     bjyl_h, bjyl_m, bjyl_l, \n" +
            "      zsbj_wc1, zsbj_wc2, zsbj_result,    zs, sygbt, dyxtk, jjkp,   qpbj, kmbj)\n" +
            "    values (#{id,jdbcType=BIGINT}, #{jcyqId,jdbcType=INTEGER}, #{eqId,jdbcType=INTEGER}, \n" +
            "      #{tester,jdbcType=VARCHAR}, #{auditor,jdbcType=VARCHAR}, #{testTime,jdbcType=TIMESTAMP},#{shsjTime}, \n" +
            "      #{jcjl,jdbcType=VARCHAR}, #{jcsm,jdbcType=VARCHAR}, #{llcsd1,jdbcType=INTEGER}, \n" +
            "      #{pjll1,jdbcType=INTEGER}, #{llcsd2,jdbcType=INTEGER}, #{pjll2,jdbcType=INTEGER}, \n" +
            "      #{wc,jdbcType=INTEGER}, #{llcsResult,jdbcType=INTEGER}, #{zsbjcsll,jdbcType=INTEGER}, \n" +
            "      #{bjszH,jdbcType=INTEGER}, #{bjszM,jdbcType=INTEGER}, #{bjszL,jdbcType=INTEGER}, \n" +
            "      #{bjsjH,jdbcType=VARCHAR}, #{bjsjM,jdbcType=VARCHAR}, #{bjsjL,jdbcType=VARCHAR}, \n" +
            "      #{bjylH,jdbcType=INTEGER}, #{bjylM,jdbcType=INTEGER}, #{bjylL,jdbcType=INTEGER}, \n" +
            "      #{zsbjWc1,jdbcType=INTEGER}, #{zsbjWc2,jdbcType=INTEGER}, #{zsbjResult,jdbcType=TINYINT}, \n" +
            "      #{zs,jdbcType=TINYINT}, #{sygbt,jdbcType=TINYINT}, #{dyxtk,jdbcType=TINYINT}, #{jjkp,jdbcType=TINYINT}, \n" +
            "      #{qpbj,jdbcType=TINYINT}, #{kmbj,jdbcType=TINYINT})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void saveMan(SybC sybC);


    @Update("update syb_m\n" +
            "    set jcyq_id = #{jcyqId,jdbcType=INTEGER},\n" +
            "      eq_id = #{eqId,jdbcType=INTEGER},\n" +
            "      tester = #{tester,jdbcType=VARCHAR},\n" +
            "      auditor = #{auditor,jdbcType=VARCHAR},\n" +
            "      test_time = #{testTime,jdbcType=TIMESTAMP},\n" +
            "      jcjl = #{jcjl,jdbcType=VARCHAR},\n" +
            "      jcsm = #{jcsm,jdbcType=VARCHAR},\n" +
            "      llcsd1 = #{llcsd1,jdbcType=INTEGER},\n" +
            "      pjll_1 = #{pjll1,jdbcType=INTEGER},\n" +
            "      llcsd2 = #{llcsd2,jdbcType=INTEGER},\n" +
            "      pjll_2 = #{pjll2,jdbcType=INTEGER},\n" +
            "      wc = #{wc,jdbcType=INTEGER},\n" +
            "      llcs_result = #{llcsResult,jdbcType=INTEGER},\n" +
            "      zsbjcsll = #{zsbjcsll,jdbcType=INTEGER},\n" +
            "      bjsz_h = #{bjszH,jdbcType=INTEGER},\n" +
            "      bjsz_m = #{bjszM,jdbcType=INTEGER},\n" +
            "      bjsz_l = #{bjszL,jdbcType=INTEGER},\n" +
            "      bjsj_h = #{bjsjH,jdbcType=VARCHAR},\n" +
            "      bjsj_m = #{bjsjM,jdbcType=VARCHAR},\n" +
            "      bjsj_l = #{bjsjL,jdbcType=VARCHAR},\n" +
            "      bjyl_h = #{bjylH,jdbcType=INTEGER},\n" +
            "      bjyl_m = #{bjylM,jdbcType=INTEGER},\n" +
            "      bjyl_l = #{bjylL,jdbcType=INTEGER},\n" +
            "      zsbj_wc1 = #{zsbjWc1,jdbcType=INTEGER},\n" +
            "      zsbj_wc2 = #{zsbjWc2,jdbcType=INTEGER},\n" +
            "      zsbj_result = #{zsbjResult,jdbcType=TINYINT},\n" +
            "      zs = #{zs,jdbcType=TINYINT},\n" +
            "      sygbt = #{sygbt,jdbcType=TINYINT},\n" +
            "      dyxtk = #{dyxtk,jdbcType=TINYINT},\n" +
            "      jjkp = #{jjkp,jdbcType=TINYINT},\n" +
            "      qpbj = #{qpbj,jdbcType=TINYINT},\n" +
            "      kmbj = #{kmbj,jdbcType=TINYINT}\n" +
            "    where id = #{id,jdbcType=BIGINT}")
    void updateMan(SybC sybC);

    //根据设备Id,检测仪器Id以及状态查询最后一条记录
    @Select("select * from ${tableName} where eq_id=#{eqId} and jcyq_id=#{jcyqId} order by test_time desc, id desc limit 1" )
    SybC findByEqIdandJcyqIdLast(@Param("tableName") String tableName, @Param("eqId") String eqId, @Param("jcyqId") String jcyqId);
    //根据设备Id,检测仪器Id以及状态查询
    @Select("select * from ${tableName} where eq_id=#{eqId} and jcyq_id=#{jcyqId}" )
    List<SybC> findByEqIdandJcyqId(@Param("tableName") String tableName, @Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    @Select("select * from syb_c where syb_c.eq_id=#{eqId} and syb_c.jcyq_id=#{jcyqId} order by id desc limit 1" )
    SybC findByEqIdandJcyqIdLast1C(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //根据设备Id,检测仪器Id以及状态查询电器表
    @Select("select * from syb_c where syb_c.eq_id=#{eqId} and syb_c.jcyq_id=#{jcyqId}" )
    List<SybC> findByEqIdandJcyqIdC(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //根据设备Id,检测仪器Id以及状态查询电器表查询最后一条记录
    @Select("select * from syb_m where syb_m.eq_id=#{eqId} and syb_m.jcyq_id=#{jcyqId} order by id desc limit 1" )
    SybC findByEqIdandJcyqIdLast1M(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //根据设备Id,检测仪器Id以及状态查询电器表
    @Select("select * from syb_m where syb_m.eq_id=#{eqId} and syb_m.jcyq_id=#{jcyqId}" )
    List<SybC> findByEqIdandJcyqIdM(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    /**
     * 根据iD状态查询
     */
    @Select("select * from ${tableName} where id=#{id}")
    SybC findByid(@Param("id") Integer id, @Param("tableName") String tableName);
    //查询所有检测表数据信息
    //查询所有录入信息
    @Select("select * from ${tableName}")
    List<SybC> findAll(String tableName);
    //修改审核人意见
    @Update("update syb_c set shr_jcjl=#{shrJcjl},auditor=#{auditor},shsj_time=#{shsjTime} where id=#{id}")
    void updateShrJcjyC(@Param("id") Integer id, @Param("shrJcjl") String shrJcjl, @Param("auditor") String auditor, @Param("shsjTime") Date shsjTime);
    @Update("update syb_m set shr_jcjl=#{shrJcjl},auditor=#{auditor},shsj_time=#{shsjTime} where id=#{id}")
    void updateShrJcjyM(@Param("id") Integer id, @Param("shrJcjl") String shrJcjl, @Param("auditor") String auditor, @Param("shsjTime") Date shsjTime);










    //查询最后录入的一条检测信息
    @Select("select * from ${value} order by id limit 1")
    SybC find(String tableName);


}
