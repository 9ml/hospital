package com.litbo.hospitalzj.checklist.dao;

import com.litbo.hospitalzj.checklist.domain.*;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * 注射泵mapper
 */
@Mapper
public interface ZsbMapper {

    //查询模板数据（成人，幼儿）
    @Select("select * from ${tableName} order by temp_id desc limit 1")
    SybCTemplate findTemplate(@Param("tableName") String tableName);

    //查询双通道模板数据，最后一条记录
    @Select("select * from stzs_m_template order by temp_id desc limit 1")
    StzsMTemplate findStZsTemplate();

    //修改模板表数据
    //幼儿
    @Update(" update zsb_c_template\n" +
            "    set llcsd1 = #{llcsd1,jdbcType=INTEGER},\n" +
            "      llcsd2 = #{llcsd2,jdbcType=INTEGER},\n" +
            "      wc = #{wc,jdbcType=INTEGER},\n" +
            "      zsbjllz = #{zsbjllz,jdbcType=INTEGER},\n" +
            "      zsbj_wc1 = #{zsbjWc1,jdbcType=INTEGER},\n" +
            "      zsbj_wc2 = #{zsbjWc2,jdbcType=INTEGER}\n" +
            "    where temp_id = #{tempId,jdbcType=BIGINT}")
    int updateC(SybCTemplate sybCTemplate);

    //成人
    @Update("update zsb_m_template\n" +
            "    set llcsd1 = #{llcsd1,jdbcType=INTEGER},\n" +
            "      llcsd2 = #{llcsd2,jdbcType=INTEGER},\n" +
            "      wc = #{wc,jdbcType=INTEGER},\n" +
            "      zsbjllz = #{zsbjllz,jdbcType=INTEGER},\n" +
            "      zsbj_wc1 = #{zsbjWc1,jdbcType=INTEGER},\n" +
            "      zsbj_wc2 = #{zsbjWc2,jdbcType=INTEGER}\n" +
            "    where temp_id = #{tempId,jdbcType=BIGINT}")
    int updateM(SybCTemplate sybCTemplate);

    //双通道
    @Update("update stzs_m_template\n" +
            "    set llcsd11 = #{llcsd11,jdbcType=INTEGER},\n" +
            "      llcsd21 = #{llcsd21,jdbcType=INTEGER},\n" +
            "      wc1 = #{wc1,jdbcType=INTEGER},\n" +
            "      zsbjcsz1 = #{zsbjcsz1,jdbcType=INTEGER},\n" +
            "      zsbj_wc11 = #{zsbjWc11,jdbcType=INTEGER},\n" +
            "      zsbj_wc21 = #{zsbjWc21,jdbcType=INTEGER},\n" +
            "      llcsd12 = #{llcsd12,jdbcType=INTEGER},\n" +
            "      llcsd22 = #{llcsd22,jdbcType=INTEGER},\n" +
            "      wc2 = #{wc2,jdbcType=INTEGER},\n" +
            "      zsbjcsz2 = #{zsbjcsz2,jdbcType=INTEGER},\n" +
            "      zsbj_wc12 = #{zsbjWc12,jdbcType=INTEGER},\n" +
            "      zsbj_wc22 = #{zsbjWc22,jdbcType=INTEGER}\n" +
            "    where temp_id = #{tempId,jdbcType=BIGINT}")
    int updateS(StzsMTemplate stzsMTemplate);

    //插入模板表数据
    //幼儿
    @Insert("insert into zsb_c_template (temp_id, llcsd1, llcsd2, \n" +
            "      wc, zsbjllz, zsbj_wc1, \n" +
            "      zsbj_wc2)\n" +
            "    values (#{tempId,jdbcType=BIGINT}, #{llcsd1,jdbcType=INTEGER}, #{llcsd2,jdbcType=INTEGER}, \n" +
            "      #{wc,jdbcType=INTEGER}, #{zsbjllz,jdbcType=INTEGER}, #{zsbjWc1,jdbcType=INTEGER}, \n" +
            "      #{zsbjWc2,jdbcType=INTEGER})")
    int insertChildTemplate(SybCTemplate template);

    //成人
    @Insert("insert into zsb_m_template (temp_id, llcsd1, llcsd2, \n" +
            "      wc, zsbjllz, zsbj_wc1, \n" +
            "      zsbj_wc2)\n" +
            "    values (#{tempId,jdbcType=BIGINT}, #{llcsd1,jdbcType=INTEGER}, #{llcsd2,jdbcType=INTEGER}, \n" +
            "      #{wc,jdbcType=INTEGER}, #{zsbjllz,jdbcType=INTEGER}, #{zsbjWc1,jdbcType=INTEGER}, \n" +
            "      #{zsbjWc2,jdbcType=INTEGER})")
    int insertManTemplate(SybCTemplate template);

    //双通道
    @Insert("insert into stzs_m_template (temp_id, llcsd11, llcsd21, \n" +
            "      wc1, zsbjcsz1, zsbj_wc11, \n" +
            "      zsbj_wc21, llcsd12, llcsd22, \n" +
            "      wc2, zsbjcsz2, zsbj_wc12, \n" +
            "      zsbj_wc22)\n" +
            "    values (#{tempId,jdbcType=BIGINT}, #{llcsd11,jdbcType=INTEGER}, #{llcsd21,jdbcType=INTEGER}, \n" +
            "      #{wc1,jdbcType=INTEGER}, #{zsbjcsz1,jdbcType=INTEGER}, #{zsbjWc11,jdbcType=INTEGER}, \n" +
            "      #{zsbjWc21,jdbcType=INTEGER}, #{llcsd12,jdbcType=INTEGER}, #{llcsd22,jdbcType=INTEGER}, \n" +
            "      #{wc2,jdbcType=INTEGER}, #{zsbjcsz2,jdbcType=INTEGER}, #{zsbjWc12,jdbcType=INTEGER}, \n" +
            "      #{zsbjWc22,jdbcType=INTEGER})")
    int insertStzsTemplate(StzsMTemplate template);

    //保存信息
    //输液泵检测信息录入（幼儿）
    @Insert("insert into zsb_c (id, jcyq_id, eq_id,  tester, auditor, test_time, shsj_time,   jcjl, jcsm, llcsd1,   pjll_1, llcsd2, pjll_2, \n" +
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

    @Update("update zsb_c\n" +
            "    set jcyq_id = #{jcyqId,jdbcType=INTEGER},\n" +
            "      eq_id = #{eqId,jdbcType=INTEGER},\n" +
            "      tester = #{tester,jdbcType=VARCHAR},\n" +
            "      auditor = #{auditor,jdbcType=VARCHAR},\n" +
            "      test_time = #{testTime,jdbcType=TIMESTAMP},\n" +
            "      shsj_time = #{shsjTime,jdbcType=TIMESTAMP},\n" +
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
    @Insert("insert into zsb_m (id, jcyq_id, eq_id,  tester, auditor, test_time, shsj_time,   jcjl, jcsm, llcsd1,   pjll_1, llcsd2, pjll_2, \n" +
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

    @Update("update zsb_m\n" +
            "    set jcyq_id = #{jcyqId,jdbcType=INTEGER},\n" +
            "      eq_id = #{eqId,jdbcType=INTEGER},\n" +
            "      tester = #{tester,jdbcType=VARCHAR},\n" +
            "      auditor = #{auditor,jdbcType=VARCHAR},\n" +
            "      test_time = #{testTime,jdbcType=TIMESTAMP},\n" +
            "      shsj_time = #{shsjTime,jdbcType=TIMESTAMP},\n" +
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

    //插入双通道注射泵检测数据
    @Insert("insert into stzs_m (id, jcyq_id, eq_id,   tester, auditor, test_time,   jcjl, jcsm, llcsd11,  pjll_11, llcsd21, pjll_21, \n" +
            "      wc1, llcs_result1, zsbj_llz1,   bjsz_h1, bjsz_m1, bjsz_l1,    bjsj_h1, bjsj_m1, bjsj_l1,     bjyl_h1, bjyl_m1, bjyl_l1, \n" +
            "      zsbj_wc11, zsbj_wc21, zsbj_result1,   zs1, sygbt1, dyxtk1,   jjkp1, qpbj1, kmbj1,     llcsd12, pjll_12, llcsd22, \n" +
            "      pjll_22, wc2, llcs_result2,    zsbjcsll2, bjsz_h2, bjsz_m2,     bjsz_l2, bjsj_h2, bjsj_m2, \n" +
            "      bjsj_l2, bjyl_h2, bjyl_m2,    bjyl_l2, zsbj_wc12, zsbj_wc22,    zsbj_result2, zs2, sygbt2,     dyxtk2, jjkp2, qpbj2, \n" +
            "      kmbj2)   values (#{id,jdbcType=BIGINT}, #{jcyqId,jdbcType=INTEGER}, #{eqId,jdbcType=INTEGER}, \n" +
            "      #{tester,jdbcType=VARCHAR}, #{auditor,jdbcType=VARCHAR}, #{testTime,jdbcType=TIMESTAMP}, \n" +
            "      #{jcjl,jdbcType=VARCHAR}, #{jcsm,jdbcType=VARCHAR}, #{llcsd11,jdbcType=INTEGER}, \n" +
            "      #{pjll11,jdbcType=INTEGER}, #{llcsd21,jdbcType=INTEGER}, #{pjll21,jdbcType=INTEGER}, \n" +
            "      #{wc1,jdbcType=INTEGER}, #{llcsResult1,jdbcType=INTEGER}, #{zsbjLlz1,jdbcType=INTEGER}, \n" +
            "      #{bjszH1,jdbcType=INTEGER}, #{bjszM1,jdbcType=INTEGER}, #{bjszL1,jdbcType=INTEGER}, \n" +
            "      #{bjsjH1,jdbcType=INTEGER}, #{bjsjM1,jdbcType=INTEGER}, #{bjsjL1,jdbcType=INTEGER}, \n" +
            "      #{bjylH1,jdbcType=INTEGER}, #{bjylM1,jdbcType=INTEGER}, #{bjylL1,jdbcType=INTEGER}, \n" +
            "      #{zsbjWc11,jdbcType=INTEGER}, #{zsbjWc21,jdbcType=INTEGER}, #{zsbjResult1,jdbcType=TINYINT}, \n" +
            "      #{zs1,jdbcType=TINYINT}, #{sygbt1,jdbcType=TINYINT}, #{dyxtk1,jdbcType=TINYINT}, \n" +
            "      #{jjkp1,jdbcType=TINYINT}, #{qpbj1,jdbcType=TINYINT}, #{kmbj1,jdbcType=TINYINT}, \n" +
            "      #{llcsd12,jdbcType=INTEGER}, #{pjll12,jdbcType=INTEGER}, #{llcsd22,jdbcType=INTEGER}, \n" +
            "      #{pjll22,jdbcType=INTEGER}, #{wc2,jdbcType=INTEGER}, #{llcsResult2,jdbcType=INTEGER}, \n" +
            "      #{zsbjcsll2,jdbcType=INTEGER}, #{bjszH2,jdbcType=INTEGER}, #{bjszM2,jdbcType=INTEGER}, \n" +
            "      #{bjszL2,jdbcType=INTEGER}, #{bjsjH2,jdbcType=INTEGER}, #{bjsjM2,jdbcType=INTEGER}, \n" +
            "      #{bjsjL2,jdbcType=INTEGER}, #{bjylH2,jdbcType=INTEGER}, #{bjylM2,jdbcType=INTEGER}, \n" +
            "      #{bjylL2,jdbcType=INTEGER}, #{zsbjWc12,jdbcType=INTEGER}, #{zsbjWc22,jdbcType=INTEGER}, \n" +
            "      #{zsbjResult2,jdbcType=TINYINT}, #{zs2,jdbcType=TINYINT}, #{sygbt2,jdbcType=TINYINT}, \n" +
            "      #{dyxtk2,jdbcType=TINYINT}, #{jjkp2,jdbcType=TINYINT}, #{qpbj2,jdbcType=TINYINT}, \n" +
            "      #{kmbj2,jdbcType=TINYINT})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void saveStzs(StzsM stzsM);

    @Update("update stzs_m\n" +
            "    set jcyq_id = #{jcyqId,jdbcType=INTEGER},\n" +
            "      eq_id = #{eqId,jdbcType=INTEGER},\n" +
            "      tester = #{tester,jdbcType=VARCHAR},\n" +
            "      auditor = #{auditor,jdbcType=VARCHAR},\n" +
            "      test_time = #{testTime,jdbcType=TIMESTAMP},\n" +
            "      jcjl = #{jcjl,jdbcType=VARCHAR},\n" +
            "      jcsm = #{jcsm,jdbcType=VARCHAR},\n" +
            "      llcsd11 = #{llcsd11,jdbcType=INTEGER},\n" +
            "      pjll_11 = #{pjll11,jdbcType=INTEGER},\n" +
            "      llcsd21 = #{llcsd21,jdbcType=INTEGER},\n" +
            "      pjll_21 = #{pjll21,jdbcType=INTEGER},\n" +
            "      wc1 = #{wc1,jdbcType=INTEGER},\n" +
            "      llcs_result1 = #{llcsResult1,jdbcType=INTEGER},\n" +
            "      zsbj_llz1 = #{zsbjLlz1,jdbcType=INTEGER},\n" +
            "      bjsz_h1 = #{bjszH1,jdbcType=INTEGER},\n" +
            "      bjsz_m1 = #{bjszM1,jdbcType=INTEGER},\n" +
            "      bjsz_l1 = #{bjszL1,jdbcType=INTEGER},\n" +
            "      bjsj_h1 = #{bjsjH1,jdbcType=VARCHAR},\n" +
            "      bjsj_m1 = #{bjsjM1,jdbcType=VARCHAR},\n" +
            "      bjsj_l1 = #{bjsjL1,jdbcType=VARCHAR},\n" +
            "      bjyl_h1 = #{bjylH1,jdbcType=INTEGER},\n" +
            "      bjyl_m1 = #{bjylM1,jdbcType=INTEGER},\n" +
            "      bjyl_l1 = #{bjylL1,jdbcType=INTEGER},\n" +
            "      zsbj_wc11 = #{zsbjWc11,jdbcType=INTEGER},\n" +
            "      zsbj_wc21 = #{zsbjWc21,jdbcType=INTEGER},\n" +
            "      zsbj_result1 = #{zsbjResult1,jdbcType=TINYINT},\n" +
            "      zs1 = #{zs1,jdbcType=TINYINT},\n" +
            "      sygbt1 = #{sygbt1,jdbcType=TINYINT},\n" +
            "      dyxtk1 = #{dyxtk1,jdbcType=TINYINT},\n" +
            "      jjkp1 = #{jjkp1,jdbcType=TINYINT},\n" +
            "      qpbj1 = #{qpbj1,jdbcType=TINYINT},\n" +
            "      kmbj1 = #{kmbj1,jdbcType=TINYINT},\n" +
            "      llcsd12 = #{llcsd12,jdbcType=INTEGER},\n" +
            "      pjll_12 = #{pjll12,jdbcType=INTEGER},\n" +
            "      llcsd22 = #{llcsd22,jdbcType=INTEGER},\n" +
            "      pjll_22 = #{pjll22,jdbcType=INTEGER},\n" +
            "      wc2 = #{wc2,jdbcType=INTEGER},\n" +
            "      llcs_result2 = #{llcsResult2,jdbcType=INTEGER},\n" +
            "      zsbjcsll2 = #{zsbjcsll2,jdbcType=INTEGER},\n" +
            "      bjsz_h2 = #{bjszH2,jdbcType=INTEGER},\n" +
            "      bjsz_m2 = #{bjszM2,jdbcType=INTEGER},\n" +
            "      bjsz_l2 = #{bjszL2,jdbcType=INTEGER},\n" +
            "      bjsj_h2 = #{bjsjH2,jdbcType=VARCHAR},\n" +
            "      bjsj_m2 = #{bjsjM2,jdbcType=VARCHAR},\n" +
            "      bjsj_l2 = #{bjsjL2,jdbcType=VARCHAR},\n" +
            "      bjyl_h2 = #{bjylH2,jdbcType=INTEGER},\n" +
            "      bjyl_m2 = #{bjylM2,jdbcType=INTEGER},\n" +
            "      bjyl_l2 = #{bjylL2,jdbcType=INTEGER},\n" +
            "      zsbj_wc12 = #{zsbjWc12,jdbcType=INTEGER},\n" +
            "      zsbj_wc22 = #{zsbjWc22,jdbcType=INTEGER},\n" +
            "      zsbj_result2 = #{zsbjResult2,jdbcType=TINYINT},\n" +
            "      zs2 = #{zs2,jdbcType=TINYINT},\n" +
            "      sygbt2 = #{sygbt2,jdbcType=TINYINT},\n" +
            "      dyxtk2 = #{dyxtk2,jdbcType=TINYINT},\n" +
            "      jjkp2 = #{jjkp2,jdbcType=TINYINT},\n" +
            "      qpbj2 = #{qpbj2,jdbcType=TINYINT},\n" +
            "      kmbj2 = #{kmbj2,jdbcType=TINYINT}\n" +
            "    where id = #{id,jdbcType=BIGINT}")
    void updateStzs(StzsM stzsM);

    //根据设备Id,检测仪器Id以及状态查询最后一条记录
    @Select("select * from ${tableName} where eq_id=#{eqId} and jcyq_id=#{jcyqId} order by test_time desc, id desc limit 1")
    SybC findByEqIdandJcyqIdLast(@Param("tableName") String tableName, @Param("eqId") String eqId, @Param("jcyqId") String jcyqId);
/*双通道注射泵*/
    @Select("select * from ${tableName} where eq_id=#{eqId} and jcyq_id=#{jcyqId} order by test_time desc, id desc limit 1")
    StzsM findByEqIdandJcyqIdLastStzsM(@Param("tableName") String tableName, @Param("eqId") String eqId, @Param("jcyqId") String jcyqId);


    //根据设备Id,检测仪器Id以及状态查询
    @Select("select * from ${tableName} where eq_id=#{eqId} and jcyq_id=#{jcyqId}")
    List<SybC> findByEqIdandJcyqId(@Param("tableName") String tableName, @Param("eqId") String eqId, @Param("jcyqId") String jcyqId);


    @Select("select * from zsb_c where zsb_c.eq_id=#{eqId} and zsb_c.jcyq_id=#{jcyqId} order by id desc limit 1")
    SybC findByEqIdandJcyqIdLast1C(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //根据设备Id,检测仪器Id以及状态查询电器表
    @Select("select * from zsb_c where zsb_c.eq_id=#{eqId} and zsb_c.jcyq_id=#{jcyqId}")
    List<SybC> findByEqIdandJcyqIdC(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //根据设备Id,检测仪器Id以及状态查询电器表查询最后一条记录
    @Select("select * from zsb_m where zsb_c.eq_id=#{eqId} and zsb_c.jcyq_id=#{jcyqId} order by id desc limit 1")
    SybC findByEqIdandJcyqIdLast1M(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //根据设备Id,检测仪器Id以及状态查询电器表
    @Select("select * from zsb_m where zsb_c.eq_id=#{eqId} and zsb_c.jcyq_id=#{jcyqId}")
    List<SybC> findByEqIdandJcyqIdM(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //根据设备Id,检测仪器Id以及状态查询电器表查询最后一条记录
    @Select("select * from stzs_m where zsb_c.eq_id=#{eqId} and zsb_c.jcyq_id=#{jcyqId} order by id desc limit 1")
    StzsM findByEqIdandJcyqIdLast1S(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //根据设备Id,检测仪器Id以及状态查询电器表
    @Select("select * from stzs_m where zsb_c.eq_id=#{eqId} and zsb_c.jcyq_id=#{jcyqId}")
    List<StzsM> findByEqIdandJcyqIdS(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //查询所有检测表数据信息
    @Select("select * from ${tableName}")
    List<SybC> findAll(String tableName);

    @Select("select * from stzs_m")
    List<StzsM> findAllS();

    /**
     * 根据iD状态查询
     */
    @Select("select * from ${tableName} where id=#{id}")
    SybC findByid(@Param("id") Integer id, @Param("tableName") String tableName);

    @Select("select * from stzs_m where id=#{id}")
    StzsM findByidS(@Param("id") Integer id);

    //修改审核人意见
    @Update("update zsb_c set shr_jcjl=#{shrJcjl},auditor=#{auditor},shsj_time=#{shsjTime} where id=#{dqjcid}")
    void updateShrJcjyC(@Param("dqjcid") Integer dqjcid, @Param("shrJcjl") String shrJcjl, @Param("auditor") String auditor, @Param("shsjTime") Date shsjTime);

    @Update("update zsb_m set shr_jcjl=#{shrJcjl},auditor=#{auditor},shsj_time=#{shsjTime} where id=#{dqjcid}")
    void updateShrJcjyM(@Param("dqjcid") Integer dqjcid, @Param("shrJcjl") String shrJcjl, @Param("auditor") String auditor, @Param("shsjTime") Date shsjTime);

    @Update("update stzs_m set shr_jcjl=#{shrJcjl},auditor=#{auditor},shsj_time=#{shsjTime} where id=#{dqjcid}")
    void updateShrJcjyS(@Param("dqjcid") Integer dqjcid, @Param("shrJcjl") String shrJcjl, @Param("auditor") String auditor, @Param("shsjTime") Date shsjTime);

}
