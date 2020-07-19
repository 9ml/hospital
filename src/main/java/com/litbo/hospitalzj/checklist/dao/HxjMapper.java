package com.litbo.hospitalzj.checklist.dao;

import com.litbo.hospitalzj.checklist.domain.Hxj;
import com.litbo.hospitalzj.checklist.domain.HxjTemplate;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface HxjMapper {

    //查询模板值
    @Select("select * from hxj_template where type = #{type} order by hxj_template_id desc limit 1")
    HxjTemplate findTemplate(Integer type);

    //修改模板值
    @Update("update hxj_template\n" +
            "    set bhjdzk_yx = #{bhjdzkYx,jdbcType=INTEGER},\n" +
            "      jykz_yx = #{jykzYx,jdbcType=INTEGER},\n" +
            "      ddld_z_yx = #{ddldZYx,jdbcType=INTEGER},\n" +
            "      ddld_d_yx = #{ddldDYx,jdbcType=INTEGER},\n" +
            "      wkld_z_yx = #{wkldZYx,jdbcType=INTEGER},\n" +
            "      wkld_d_yx = #{wkldDYx,jdbcType=INTEGER},\n" +
            "      cqz1 = #{cqz1,jdbcType=INTEGER},\n" +
            "      cqz2 = #{cqz2,jdbcType=INTEGER},\n" +
            "      cqz3 = #{cqz3,jdbcType=INTEGER},\n" +
            "      cqz_zdwc1 = #{cqzZdwc1,jdbcType=INTEGER},\n" +
            "      cqz_zdwc2 = #{cqzZdwc2,jdbcType=INTEGER},\n" +
            "      qztq1 = #{qztq1,jdbcType=INTEGER},\n" +
            "      qztq2 = #{qztq2,jdbcType=INTEGER},\n" +
            "      qztq3 = #{qztq3,jdbcType=INTEGER},\n" +
            "      qztq_zdwc1 = #{qztqZdwc1,jdbcType=INTEGER},\n" +
            "      qztq_zdwc2 = #{qztqZdwc2,jdbcType=INTEGER},\n" +
            "      xry1 = #{xry1,jdbcType=INTEGER},\n" +
            "      xry2 = #{xry2,jdbcType=INTEGER},\n" +
            "      xry3 = #{xry3,jdbcType=INTEGER},\n" +
            "      xry_zdwc1 = #{xryZdwc1,jdbcType=INTEGER},\n" +
            "      xry_zdwc2 = #{xryZdwc2,jdbcType=INTEGER},\n" +
            "      xqf1 = #{xqf1,jdbcType=INTEGER},\n" +
            "      xqf2 = #{xqf2,jdbcType=INTEGER},\n" +
            "      xqf3 = #{xqf3,jdbcType=INTEGER},\n" +
            "      xqf_zdwc1 = #{xqfZdwc1,jdbcType=INTEGER},\n" +
            "      xqf_zdwc2 = #{xqfZdwc2,jdbcType=INTEGER},\n" +
            "      hqm1 = #{hqm1,jdbcType=INTEGER},\n" +
            "      hqm2 = #{hqm2,jdbcType=INTEGER},\n" +
            "      hqm3 = #{hqm3,jdbcType=INTEGER},\n" +
            "      hqm_zdwc1 = #{hqmZdwc1,jdbcType=INTEGER},\n" +
            "      hqm_zdwc2 = #{hqmZdwc2,jdbcType=INTEGER},\n" +
            "      dybj = #{dybj,jdbcType=INTEGER},\n" +
            "      yqndsx = #{yqndsx,jdbcType=INTEGER},\n" +
            "      qybj = #{qybj,jdbcType=INTEGER},\n" +
            "      zxbj = #{zxbj,jdbcType=INTEGER},\n" +
            "      qdyl = #{qdyl,jdbcType=INTEGER},\n" +
            "      brhl = #{brhl,jdbcType=INTEGER},\n" +
            "      fztql = #{fztql,jdbcType=INTEGER},\n" +
            "      ajgn = #{ajgn,jdbcType=INTEGER},\n" +
            "      bz = #{bz,jdbcType=INTEGER},\n" +
            "      bz1 = #{bz1,jdbcType=INTEGER}\n" +
            "    where hxj_template_id = #{hxjTemplateId,jdbcType=INTEGER}")
    int updateHxjTemplate(HxjTemplate hxjTemplate);
    //插入模板值
    @Insert("    insert into hxj_template (hxj_template_id, bhjdzk_yx, jykz_yx, \n" +
            "      ddld_z_yx, ddld_d_yx, wkld_z_yx, \n" +
            "      wkld_d_yx, cqz1, cqz2, \n" +
            "      cqz3, cqz_zdwc1, cqz_zdwc2, \n" +
            "      qztq1, qztq2, qztq3, \n" +
            "      qztq_zdwc1, qztq_zdwc2, xry1, \n" +
            "      xry2, xry3, xry_zdwc1, \n" +
            "      xry_zdwc2, xqf1, xqf2, \n" +
            "      xqf3, xqf_zdwc1, xqf_zdwc2, \n" +
            "      hqm1, hqm2, hqm3, hqm_zdwc1, \n" +
            "      hqm_zdwc2, dybj, yqndsx, \n" +
            "      qybj, zxbj, qdyl, brhl, \n" +
            "      fztql, ajgn, bz, bz1,type\n" +
            "      )\n" +
            "    values (#{hxjTemplateId,jdbcType=INTEGER}, #{bhjdzkYx,jdbcType=INTEGER}, #{jykzYx,jdbcType=INTEGER}, \n" +
            "      #{ddldZYx,jdbcType=INTEGER}, #{ddldDYx,jdbcType=INTEGER}, #{wkldZYx,jdbcType=INTEGER}, \n" +
            "      #{wkldDYx,jdbcType=INTEGER}, #{cqz1,jdbcType=INTEGER}, #{cqz2,jdbcType=INTEGER}, \n" +
            "      #{cqz3,jdbcType=INTEGER}, #{cqzZdwc1,jdbcType=INTEGER}, #{cqzZdwc2,jdbcType=INTEGER}, \n" +
            "      #{qztq1,jdbcType=INTEGER}, #{qztq2,jdbcType=INTEGER}, #{qztq3,jdbcType=INTEGER}, \n" +
            "      #{qztqZdwc1,jdbcType=INTEGER}, #{qztqZdwc2,jdbcType=INTEGER}, #{xry1,jdbcType=INTEGER}, \n" +
            "      #{xry2,jdbcType=INTEGER}, #{xry3,jdbcType=INTEGER}, #{xryZdwc1,jdbcType=INTEGER}, \n" +
            "      #{xryZdwc2,jdbcType=INTEGER}, #{xqf1,jdbcType=INTEGER}, #{xqf2,jdbcType=INTEGER}, \n" +
            "      #{xqf3,jdbcType=INTEGER}, #{xqfZdwc1,jdbcType=INTEGER}, #{xqfZdwc2,jdbcType=INTEGER}, \n" +
            "      #{hqm1,jdbcType=INTEGER}, #{hqm2,jdbcType=INTEGER}, #{hqm3,jdbcType=INTEGER}, #{hqmZdwc1,jdbcType=INTEGER}, \n" +
            "      #{hqmZdwc2,jdbcType=INTEGER}, #{dybj,jdbcType=INTEGER}, #{yqndsx,jdbcType=INTEGER}, \n" +
            "      #{qybj,jdbcType=INTEGER}, #{zxbj,jdbcType=INTEGER}, #{qdyl,jdbcType=INTEGER}, #{brhl,jdbcType=INTEGER}, \n" +
            "      #{fztql,jdbcType=INTEGER}, #{ajgn,jdbcType=INTEGER}, #{bz,jdbcType=INTEGER}, #{bz1,jdbcType=INTEGER},#{type,jdbcType=INTEGER}\n" +
            "      )")
    int insertHxjTemplate(HxjTemplate hxjTemplate);

    //保存
    @Insert("insert into hxj (hxjid, jcyq_id, eq_id, \n" +
            "      tester, auditor, shsj_time, \n" +
            "      shr_jcjl, test_time, jcjl, \n" +
            "      jcsm, bhjdzk_test, bhjdzk_yx, \n" +
            "      bhjdzk_result, jykz_test, jykz_yx, \n" +
            "      jykz_result, ddld_z_z, ddld_z_f, \n" +
            "      ddld_z_yx, ddld_z_result, ddld_d_z1, \n" +
            "      ddld_d_z2, ddld_d_yx, ddld_d_result, \n" +
            "      wkld_z_z, wkld_z_f, wkld_z_yx, \n" +
            "      wkld_z_result, wkld_d_z1, wkld_d_z2, \n" +
            "      wkld_d_z3, wkld_d_z4, wkld_d_yx, \n" +
            "      wkld_d_result, cqz1, cqzh11, \n" +
            "      cqzh12, cqzh13, cqzhp11, \n" +
            "      cqzc11, cqzc12, cqzc13, \n" +
            "      cqzcp12, cqz1_swc, cqz2, \n" +
            "      cqzh21, cqzh22, cqzh23, \n" +
            "      cqzhp21, cqzc21, cqzc22, \n" +
            "      cqzc23, cqzcp22, cqz2_swc, \n" +
            "      cqz3, cqzh31, cqzh32, \n" +
            "      cqzh33, cqzhp31, cqzc31, \n" +
            "      cqzc32, cqzc33, cqzcp32, \n" +
            "      cqz3_swc, cqz_zdwc1, cqz_zdwc2, \n" +
            "      cqz_result, qztq1, qztqh11, \n" +
            "      qztqh12, qztqh13, qztqhp11, \n" +
            "      qztqc11, qztqc12, qztqc13, \n" +
            "      qztqcp12, qztq1_swc, qztq2, \n" +
            "      qztqh21, qztqh22, qztqh23, \n" +
            "      qztqhp21, qztqc21, qztqc22, \n" +
            "      qztqc23, qztqcp22, qztq2_swc, \n" +
            "      qztq3, qztqh31, qztqh32, \n" +
            "      qztqh33, qztqhp31, qztqc31, \n" +
            "      qztqc32, qztqc33, qztqcp32, \n" +
            "      qztq3_swc, qztq_zdwc1, qztq_zdwc2, \n" +
            "      qztq_result, xry1, xryh11, \n" +
            "      xryh12, xryh13, xryhp11, \n" +
            "      xryc11, xryc12, xryc13, \n" +
            "      xrycp12, xry1_swc, xry2, \n" +
            "      xryh21, xryh22, xryh23, \n" +
            "      xryhp21, xryc21, xryc22, \n" +
            "      xryc23, xrycp22, xry2_swc, \n" +
            "      xry3, xryh31, xryh32, \n" +
            "      xryh33, xryhp31, xryc31, \n" +
            "      xryc32, xryc33, xrycp32, \n" +
            "      xry3_swc, xry_zdwc1, xry_zdwc2, \n" +
            "      xry_result, xqf1, xqfh11, \n" +
            "      xqfh12, xqfh13, xqfhp11, \n" +
            "      xqfc11, xqfc12, xqfc13, \n" +
            "      xqfcp12, xqf1_swc, xqf2, \n" +
            "      xqfh21, xqfh22, xqfh23, \n" +
            "      xqfhp21, xqfc21, xqfc22, \n" +
            "      xqfc23, xqfcp22, xqf2_swc, \n" +
            "      xqf3, xqfh31, xqfh32, \n" +
            "      xqfh33, xqfhp31, xqfc31, \n" +
            "      xqfc32, xqfc33, xqfcp32, \n" +
            "      xqf3_swc, xqf_zdwc1, xqf_zdwc2, \n" +
            "      xqf_result, hqm1, hqmh11, \n" +
            "      hqmh12, hqmh13, hqmhp11, \n" +
            "      hqmc11, hqmc12, hqmc13, \n" +
            "      hqmcp12, hqm1_swc, hqm2, \n" +
            "      hqmh21, hqmh22, hqmh23, \n" +
            "      hqmhp21, hqmc21, hqmc22, \n" +
            "      hqmc23, hqmcp22, hqm2_swc, \n" +
            "      hqm3, hqmh31, hqmh32, \n" +
            "      hqmh33, hqmhp31, hqmc31, \n" +
            "      hqmc32, hqmc33, hqmcp32, \n" +
            "      hqm3_swc, hqm_zdwc1, hqm_zdwc2, \n" +
            "      hqm_result, dybj, yqndsx, \n" +
            "      qybj, zxbj, qdyl, brhl, \n" +
            "      fztql, ajgn, bz, bz1,type\n" +
            "      )\n" +
            "    values (#{hxjid,jdbcType=INTEGER}, #{jcyqId,jdbcType=INTEGER}, #{eqId,jdbcType=INTEGER}, \n" +
            "      #{tester,jdbcType=VARCHAR}, #{auditor,jdbcType=VARCHAR}, #{shsjTime,jdbcType=TIMESTAMP}, \n" +
            "      #{shrJcjl,jdbcType=VARCHAR}, #{testTime,jdbcType=TIMESTAMP}, #{jcjl,jdbcType=VARCHAR}, \n" +
            "      #{jcsm,jdbcType=VARCHAR}, #{bhjdzkTest,jdbcType=INTEGER}, #{bhjdzkYx,jdbcType=INTEGER}, \n" +
            "      #{bhjdzkResult,jdbcType=INTEGER}, #{jykzTest,jdbcType=INTEGER}, #{jykzYx,jdbcType=INTEGER}, \n" +
            "      #{jykzResult,jdbcType=INTEGER}, #{ddldZZ,jdbcType=INTEGER}, #{ddldZF,jdbcType=INTEGER}, \n" +
            "      #{ddldZYx,jdbcType=INTEGER}, #{ddldZResult,jdbcType=INTEGER}, #{ddldDZ1,jdbcType=INTEGER}, \n" +
            "      #{ddldDZ2,jdbcType=INTEGER}, #{ddldDYx,jdbcType=INTEGER}, #{ddldDResult,jdbcType=INTEGER}, \n" +
            "      #{wkldZZ,jdbcType=INTEGER}, #{wkldZF,jdbcType=INTEGER}, #{wkldZYx,jdbcType=INTEGER}, \n" +
            "      #{wkldZResult,jdbcType=INTEGER}, #{wkldDZ1,jdbcType=INTEGER}, #{wkldDZ2,jdbcType=INTEGER}, \n" +
            "      #{wkldDZ3,jdbcType=INTEGER}, #{wkldDZ4,jdbcType=INTEGER}, #{wkldDYx,jdbcType=INTEGER}, \n" +
            "      #{wkldDResult,jdbcType=INTEGER}, #{cqz1,jdbcType=INTEGER}, #{cqzh11,jdbcType=INTEGER}, \n" +
            "      #{cqzh12,jdbcType=INTEGER}, #{cqzh13,jdbcType=INTEGER}, #{cqzhp11,jdbcType=INTEGER}, \n" +
            "      #{cqzc11,jdbcType=INTEGER}, #{cqzc12,jdbcType=INTEGER}, #{cqzc13,jdbcType=INTEGER}, \n" +
            "      #{cqzcp12,jdbcType=INTEGER}, #{cqz1Swc,jdbcType=INTEGER}, #{cqz2,jdbcType=INTEGER}, \n" +
            "      #{cqzh21,jdbcType=INTEGER}, #{cqzh22,jdbcType=INTEGER}, #{cqzh23,jdbcType=INTEGER}, \n" +
            "      #{cqzhp21,jdbcType=INTEGER}, #{cqzc21,jdbcType=INTEGER}, #{cqzc22,jdbcType=INTEGER}, \n" +
            "      #{cqzc23,jdbcType=INTEGER}, #{cqzcp22,jdbcType=INTEGER}, #{cqz2Swc,jdbcType=INTEGER}, \n" +
            "      #{cqz3,jdbcType=INTEGER}, #{cqzh31,jdbcType=INTEGER}, #{cqzh32,jdbcType=INTEGER}, \n" +
            "      #{cqzh33,jdbcType=INTEGER}, #{cqzhp31,jdbcType=INTEGER}, #{cqzc31,jdbcType=INTEGER}, \n" +
            "      #{cqzc32,jdbcType=INTEGER}, #{cqzc33,jdbcType=INTEGER}, #{cqzcp32,jdbcType=INTEGER}, \n" +
            "      #{cqz3Swc,jdbcType=INTEGER}, #{cqzZdwc1,jdbcType=INTEGER}, #{cqzZdwc2,jdbcType=INTEGER}, \n" +
            "      #{cqzResult,jdbcType=INTEGER}, #{qztq1,jdbcType=INTEGER}, #{qztqh11,jdbcType=INTEGER}, \n" +
            "      #{qztqh12,jdbcType=INTEGER}, #{qztqh13,jdbcType=INTEGER}, #{qztqhp11,jdbcType=INTEGER}, \n" +
            "      #{qztqc11,jdbcType=INTEGER}, #{qztqc12,jdbcType=INTEGER}, #{qztqc13,jdbcType=INTEGER}, \n" +
            "      #{qztqcp12,jdbcType=INTEGER}, #{qztq1Swc,jdbcType=INTEGER}, #{qztq2,jdbcType=INTEGER}, \n" +
            "      #{qztqh21,jdbcType=INTEGER}, #{qztqh22,jdbcType=INTEGER}, #{qztqh23,jdbcType=INTEGER}, \n" +
            "      #{qztqhp21,jdbcType=INTEGER}, #{qztqc21,jdbcType=INTEGER}, #{qztqc22,jdbcType=INTEGER}, \n" +
            "      #{qztqc23,jdbcType=INTEGER}, #{qztqcp22,jdbcType=INTEGER}, #{qztq2Swc,jdbcType=INTEGER}, \n" +
            "      #{qztq3,jdbcType=INTEGER}, #{qztqh31,jdbcType=INTEGER}, #{qztqh32,jdbcType=INTEGER}, \n" +
            "      #{qztqh33,jdbcType=INTEGER}, #{qztqhp31,jdbcType=INTEGER}, #{qztqc31,jdbcType=INTEGER}, \n" +
            "      #{qztqc32,jdbcType=INTEGER}, #{qztqc33,jdbcType=INTEGER}, #{qztqcp32,jdbcType=INTEGER}, \n" +
            "      #{qztq3Swc,jdbcType=INTEGER}, #{qztqZdwc1,jdbcType=INTEGER}, #{qztqZdwc2,jdbcType=INTEGER}, \n" +
            "      #{qztqResult,jdbcType=INTEGER}, #{xry1,jdbcType=INTEGER}, #{xryh11,jdbcType=INTEGER}, \n" +
            "      #{xryh12,jdbcType=INTEGER}, #{xryh13,jdbcType=INTEGER}, #{xryhp11,jdbcType=INTEGER}, \n" +
            "      #{xryc11,jdbcType=INTEGER}, #{xryc12,jdbcType=INTEGER}, #{xryc13,jdbcType=INTEGER}, \n" +
            "      #{xrycp12,jdbcType=INTEGER}, #{xry1Swc,jdbcType=INTEGER}, #{xry2,jdbcType=INTEGER}, \n" +
            "      #{xryh21,jdbcType=INTEGER}, #{xryh22,jdbcType=INTEGER}, #{xryh23,jdbcType=INTEGER}, \n" +
            "      #{xryhp21,jdbcType=INTEGER}, #{xryc21,jdbcType=INTEGER}, #{xryc22,jdbcType=INTEGER}, \n" +
            "      #{xryc23,jdbcType=INTEGER}, #{xrycp22,jdbcType=INTEGER}, #{xry2Swc,jdbcType=INTEGER}, \n" +
            "      #{xry3,jdbcType=INTEGER}, #{xryh31,jdbcType=INTEGER}, #{xryh32,jdbcType=INTEGER}, \n" +
            "      #{xryh33,jdbcType=INTEGER}, #{xryhp31,jdbcType=INTEGER}, #{xryc31,jdbcType=INTEGER}, \n" +
            "      #{xryc32,jdbcType=INTEGER}, #{xryc33,jdbcType=INTEGER}, #{xrycp32,jdbcType=INTEGER}, \n" +
            "      #{xry3Swc,jdbcType=INTEGER}, #{xryZdwc1,jdbcType=INTEGER}, #{xryZdwc2,jdbcType=INTEGER}, \n" +
            "      #{xryResult,jdbcType=INTEGER}, #{xqf1,jdbcType=INTEGER}, #{xqfh11,jdbcType=INTEGER}, \n" +
            "      #{xqfh12,jdbcType=INTEGER}, #{xqfh13,jdbcType=INTEGER}, #{xqfhp11,jdbcType=INTEGER}, \n" +
            "      #{xqfc11,jdbcType=INTEGER}, #{xqfc12,jdbcType=INTEGER}, #{xqfc13,jdbcType=INTEGER}, \n" +
            "      #{xqfcp12,jdbcType=INTEGER}, #{xqf1Swc,jdbcType=INTEGER}, #{xqf2,jdbcType=INTEGER}, \n" +
            "      #{xqfh21,jdbcType=INTEGER}, #{xqfh22,jdbcType=INTEGER}, #{xqfh23,jdbcType=INTEGER}, \n" +
            "      #{xqfhp21,jdbcType=INTEGER}, #{xqfc21,jdbcType=INTEGER}, #{xqfc22,jdbcType=INTEGER}, \n" +
            "      #{xqfc23,jdbcType=INTEGER}, #{xqfcp22,jdbcType=INTEGER}, #{xqf2Swc,jdbcType=INTEGER}, \n" +
            "      #{xqf3,jdbcType=INTEGER}, #{xqfh31,jdbcType=INTEGER}, #{xqfh32,jdbcType=INTEGER}, \n" +
            "      #{xqfh33,jdbcType=INTEGER}, #{xqfhp31,jdbcType=INTEGER}, #{xqfc31,jdbcType=INTEGER}, \n" +
            "      #{xqfc32,jdbcType=INTEGER}, #{xqfc33,jdbcType=INTEGER}, #{xqfcp32,jdbcType=INTEGER}, \n" +
            "      #{xqf3Swc,jdbcType=INTEGER}, #{xqfZdwc1,jdbcType=INTEGER}, #{xqfZdwc2,jdbcType=INTEGER}, \n" +
            "      #{xqfResult,jdbcType=INTEGER}, #{hqm1,jdbcType=INTEGER}, #{hqmh11,jdbcType=INTEGER}, \n" +
            "      #{hqmh12,jdbcType=INTEGER}, #{hqmh13,jdbcType=INTEGER}, #{hqmhp11,jdbcType=INTEGER}, \n" +
            "      #{hqmc11,jdbcType=INTEGER}, #{hqmc12,jdbcType=INTEGER}, #{hqmc13,jdbcType=INTEGER}, \n" +
            "      #{hqmcp12,jdbcType=INTEGER}, #{hqm1Swc,jdbcType=INTEGER}, #{hqm2,jdbcType=INTEGER}, \n" +
            "      #{hqmh21,jdbcType=INTEGER}, #{hqmh22,jdbcType=INTEGER}, #{hqmh23,jdbcType=INTEGER}, \n" +
            "      #{hqmhp21,jdbcType=INTEGER}, #{hqmc21,jdbcType=INTEGER}, #{hqmc22,jdbcType=INTEGER}, \n" +
            "      #{hqmc23,jdbcType=INTEGER}, #{hqmcp22,jdbcType=INTEGER}, #{hqm2Swc,jdbcType=INTEGER}, \n" +
            "      #{hqm3,jdbcType=INTEGER}, #{hqmh31,jdbcType=INTEGER}, #{hqmh32,jdbcType=INTEGER}, \n" +
            "      #{hqmh33,jdbcType=INTEGER}, #{hqmhp31,jdbcType=INTEGER}, #{hqmc31,jdbcType=INTEGER}, \n" +
            "      #{hqmc32,jdbcType=INTEGER}, #{hqmc33,jdbcType=INTEGER}, #{hqmcp32,jdbcType=INTEGER}, \n" +
            "      #{hqm3Swc,jdbcType=INTEGER}, #{hqmZdwc1,jdbcType=INTEGER}, #{hqmZdwc2,jdbcType=INTEGER}, \n" +
            "      #{hqmResult,jdbcType=INTEGER}, #{dybj,jdbcType=INTEGER}, #{yqndsx,jdbcType=INTEGER}, \n" +
            "      #{qybj,jdbcType=INTEGER}, #{zxbj,jdbcType=INTEGER}, #{qdyl,jdbcType=INTEGER}, #{brhl,jdbcType=INTEGER}, \n" +
            "      #{fztql,jdbcType=INTEGER}, #{ajgn,jdbcType=INTEGER}, #{bz,jdbcType=INTEGER}, #{bz1,jdbcType=INTEGER}, #{type,jdbcType=INTEGER}\n" +
            "      )")
    @Options(useGeneratedKeys = true, keyProperty = "hxjid", keyColumn = "hxjid")
    void save(Hxj hxj);
@Update("update hxj\n" +
        "    set jcyq_id = #{jcyqId,jdbcType=INTEGER},\n" +
        "      eq_id = #{eqId,jdbcType=INTEGER},\n" +
        "      tester = #{tester,jdbcType=VARCHAR},\n" +
        "      auditor = #{auditor,jdbcType=VARCHAR},\n" +
        "      shsj_time = #{shsjTime,jdbcType=TIMESTAMP},\n" +
        "      shr_jcjl = #{shrJcjl,jdbcType=VARCHAR},\n" +
        "      test_time = #{testTime,jdbcType=TIMESTAMP},\n" +
        "      jcjl = #{jcjl,jdbcType=VARCHAR},\n" +
        "      jcsm = #{jcsm,jdbcType=VARCHAR},\n" +
        "      bhjdzk_test = #{bhjdzkTest,jdbcType=INTEGER},\n" +
        "      bhjdzk_yx = #{bhjdzkYx,jdbcType=INTEGER},\n" +
        "      bhjdzk_result = #{bhjdzkResult,jdbcType=INTEGER},\n" +
        "      jykz_test = #{jykzTest,jdbcType=INTEGER},\n" +
        "      jykz_yx = #{jykzYx,jdbcType=INTEGER},\n" +
        "      jykz_result = #{jykzResult,jdbcType=INTEGER},\n" +
        "      ddld_z_z = #{ddldZZ,jdbcType=INTEGER},\n" +
        "      ddld_z_f = #{ddldZF,jdbcType=INTEGER},\n" +
        "      ddld_z_yx = #{ddldZYx,jdbcType=INTEGER},\n" +
        "      ddld_z_result = #{ddldZResult,jdbcType=INTEGER},\n" +
        "      ddld_d_z1 = #{ddldDZ1,jdbcType=INTEGER},\n" +
        "      ddld_d_z2 = #{ddldDZ2,jdbcType=INTEGER},\n" +
        "      ddld_d_yx = #{ddldDYx,jdbcType=INTEGER},\n" +
        "      ddld_d_result = #{ddldDResult,jdbcType=INTEGER},\n" +
        "      wkld_z_z = #{wkldZZ,jdbcType=INTEGER},\n" +
        "      wkld_z_f = #{wkldZF,jdbcType=INTEGER},\n" +
        "      wkld_z_yx = #{wkldZYx,jdbcType=INTEGER},\n" +
        "      wkld_z_result = #{wkldZResult,jdbcType=INTEGER},\n" +
        "      wkld_d_z1 = #{wkldDZ1,jdbcType=INTEGER},\n" +
        "      wkld_d_z2 = #{wkldDZ2,jdbcType=INTEGER},\n" +
        "      wkld_d_z3 = #{wkldDZ3,jdbcType=INTEGER},\n" +
        "      wkld_d_z4 = #{wkldDZ4,jdbcType=INTEGER},\n" +
        "      wkld_d_yx = #{wkldDYx,jdbcType=INTEGER},\n" +
        "      wkld_d_result = #{wkldDResult,jdbcType=INTEGER},\n" +
        "      cqz1 = #{cqz1,jdbcType=INTEGER},\n" +
        "      cqzh11 = #{cqzh11,jdbcType=INTEGER},\n" +
        "      cqzh12 = #{cqzh12,jdbcType=INTEGER},\n" +
        "      cqzh13 = #{cqzh13,jdbcType=INTEGER},\n" +
        "      cqzhp11 = #{cqzhp11,jdbcType=INTEGER},\n" +
        "      cqzc11 = #{cqzc11,jdbcType=INTEGER},\n" +
        "      cqzc12 = #{cqzc12,jdbcType=INTEGER},\n" +
        "      cqzc13 = #{cqzc13,jdbcType=INTEGER},\n" +
        "      cqzcp12 = #{cqzcp12,jdbcType=INTEGER},\n" +
        "      cqz1_swc = #{cqz1Swc,jdbcType=INTEGER},\n" +
        "      cqz2 = #{cqz2,jdbcType=INTEGER},\n" +
        "      cqzh21 = #{cqzh21,jdbcType=INTEGER},\n" +
        "      cqzh22 = #{cqzh22,jdbcType=INTEGER},\n" +
        "      cqzh23 = #{cqzh23,jdbcType=INTEGER},\n" +
        "      cqzhp21 = #{cqzhp21,jdbcType=INTEGER},\n" +
        "      cqzc21 = #{cqzc21,jdbcType=INTEGER},\n" +
        "      cqzc22 = #{cqzc22,jdbcType=INTEGER},\n" +
        "      cqzc23 = #{cqzc23,jdbcType=INTEGER},\n" +
        "      cqzcp22 = #{cqzcp22,jdbcType=INTEGER},\n" +
        "      cqz2_swc = #{cqz2Swc,jdbcType=INTEGER},\n" +
        "      cqz3 = #{cqz3,jdbcType=INTEGER},\n" +
        "      cqzh31 = #{cqzh31,jdbcType=INTEGER},\n" +
        "      cqzh32 = #{cqzh32,jdbcType=INTEGER},\n" +
        "      cqzh33 = #{cqzh33,jdbcType=INTEGER},\n" +
        "      cqzhp31 = #{cqzhp31,jdbcType=INTEGER},\n" +
        "      cqzc31 = #{cqzc31,jdbcType=INTEGER},\n" +
        "      cqzc32 = #{cqzc32,jdbcType=INTEGER},\n" +
        "      cqzc33 = #{cqzc33,jdbcType=INTEGER},\n" +
        "      cqzcp32 = #{cqzcp32,jdbcType=INTEGER},\n" +
        "      cqz3_swc = #{cqz3Swc,jdbcType=INTEGER},\n" +
        "      cqz_zdwc1 = #{cqzZdwc1,jdbcType=INTEGER},\n" +
        "      cqz_zdwc2 = #{cqzZdwc2,jdbcType=INTEGER},\n" +
        "      cqz_result = #{cqzResult,jdbcType=INTEGER},\n" +
        "      qztq1 = #{qztq1,jdbcType=INTEGER},\n" +
        "      qztqh11 = #{qztqh11,jdbcType=INTEGER},\n" +
        "      qztqh12 = #{qztqh12,jdbcType=INTEGER},\n" +
        "      qztqh13 = #{qztqh13,jdbcType=INTEGER},\n" +
        "      qztqhp11 = #{qztqhp11,jdbcType=INTEGER},\n" +
        "      qztqc11 = #{qztqc11,jdbcType=INTEGER},\n" +
        "      qztqc12 = #{qztqc12,jdbcType=INTEGER},\n" +
        "      qztqc13 = #{qztqc13,jdbcType=INTEGER},\n" +
        "      qztqcp12 = #{qztqcp12,jdbcType=INTEGER},\n" +
        "      qztq1_swc = #{qztq1Swc,jdbcType=INTEGER},\n" +
        "      qztq2 = #{qztq2,jdbcType=INTEGER},\n" +
        "      qztqh21 = #{qztqh21,jdbcType=INTEGER},\n" +
        "      qztqh22 = #{qztqh22,jdbcType=INTEGER},\n" +
        "      qztqh23 = #{qztqh23,jdbcType=INTEGER},\n" +
        "      qztqhp21 = #{qztqhp21,jdbcType=INTEGER},\n" +
        "      qztqc21 = #{qztqc21,jdbcType=INTEGER},\n" +
        "      qztqc22 = #{qztqc22,jdbcType=INTEGER},\n" +
        "      qztqc23 = #{qztqc23,jdbcType=INTEGER},\n" +
        "      qztqcp22 = #{qztqcp22,jdbcType=INTEGER},\n" +
        "      qztq2_swc = #{qztq2Swc,jdbcType=INTEGER},\n" +
        "      qztq3 = #{qztq3,jdbcType=INTEGER},\n" +
        "      qztqh31 = #{qztqh31,jdbcType=INTEGER},\n" +
        "      qztqh32 = #{qztqh32,jdbcType=INTEGER},\n" +
        "      qztqh33 = #{qztqh33,jdbcType=INTEGER},\n" +
        "      qztqhp31 = #{qztqhp31,jdbcType=INTEGER},\n" +
        "      qztqc31 = #{qztqc31,jdbcType=INTEGER},\n" +
        "      qztqc32 = #{qztqc32,jdbcType=INTEGER},\n" +
        "      qztqc33 = #{qztqc33,jdbcType=INTEGER},\n" +
        "      qztqcp32 = #{qztqcp32,jdbcType=INTEGER},\n" +
        "      qztq3_swc = #{qztq3Swc,jdbcType=INTEGER},\n" +
        "      qztq_zdwc1 = #{qztqZdwc1,jdbcType=INTEGER},\n" +
        "      qztq_zdwc2 = #{qztqZdwc2,jdbcType=INTEGER},\n" +
        "      qztq_result = #{qztqResult,jdbcType=INTEGER},\n" +
        "      xry1 = #{xry1,jdbcType=INTEGER},\n" +
        "      xryh11 = #{xryh11,jdbcType=INTEGER},\n" +
        "      xryh12 = #{xryh12,jdbcType=INTEGER},\n" +
        "      xryh13 = #{xryh13,jdbcType=INTEGER},\n" +
        "      xryhp11 = #{xryhp11,jdbcType=INTEGER},\n" +
        "      xryc11 = #{xryc11,jdbcType=INTEGER},\n" +
        "      xryc12 = #{xryc12,jdbcType=INTEGER},\n" +
        "      xryc13 = #{xryc13,jdbcType=INTEGER},\n" +
        "      xrycp12 = #{xrycp12,jdbcType=INTEGER},\n" +
        "      xry1_swc = #{xry1Swc,jdbcType=INTEGER},\n" +
        "      xry2 = #{xry2,jdbcType=INTEGER},\n" +
        "      xryh21 = #{xryh21,jdbcType=INTEGER},\n" +
        "      xryh22 = #{xryh22,jdbcType=INTEGER},\n" +
        "      xryh23 = #{xryh23,jdbcType=INTEGER},\n" +
        "      xryhp21 = #{xryhp21,jdbcType=INTEGER},\n" +
        "      xryc21 = #{xryc21,jdbcType=INTEGER},\n" +
        "      xryc22 = #{xryc22,jdbcType=INTEGER},\n" +
        "      xryc23 = #{xryc23,jdbcType=INTEGER},\n" +
        "      xrycp22 = #{xrycp22,jdbcType=INTEGER},\n" +
        "      xry2_swc = #{xry2Swc,jdbcType=INTEGER},\n" +
        "      xry3 = #{xry3,jdbcType=INTEGER},\n" +
        "      xryh31 = #{xryh31,jdbcType=INTEGER},\n" +
        "      xryh32 = #{xryh32,jdbcType=INTEGER},\n" +
        "      xryh33 = #{xryh33,jdbcType=INTEGER},\n" +
        "      xryhp31 = #{xryhp31,jdbcType=INTEGER},\n" +
        "      xryc31 = #{xryc31,jdbcType=INTEGER},\n" +
        "      xryc32 = #{xryc32,jdbcType=INTEGER},\n" +
        "      xryc33 = #{xryc33,jdbcType=INTEGER},\n" +
        "      xrycp32 = #{xrycp32,jdbcType=INTEGER},\n" +
        "      xry3_swc = #{xry3Swc,jdbcType=INTEGER},\n" +
        "      xry_zdwc1 = #{xryZdwc1,jdbcType=INTEGER},\n" +
        "      xry_zdwc2 = #{xryZdwc2,jdbcType=INTEGER},\n" +
        "      xry_result = #{xryResult,jdbcType=INTEGER},\n" +
        "      xqf1 = #{xqf1,jdbcType=INTEGER},\n" +
        "      xqfh11 = #{xqfh11,jdbcType=INTEGER},\n" +
        "      xqfh12 = #{xqfh12,jdbcType=INTEGER},\n" +
        "      xqfh13 = #{xqfh13,jdbcType=INTEGER},\n" +
        "      xqfhp11 = #{xqfhp11,jdbcType=INTEGER},\n" +
        "      xqfc11 = #{xqfc11,jdbcType=INTEGER},\n" +
        "      xqfc12 = #{xqfc12,jdbcType=INTEGER},\n" +
        "      xqfc13 = #{xqfc13,jdbcType=INTEGER},\n" +
        "      xqfcp12 = #{xqfcp12,jdbcType=INTEGER},\n" +
        "      xqf1_swc = #{xqf1Swc,jdbcType=INTEGER},\n" +
        "      xqf2 = #{xqf2,jdbcType=INTEGER},\n" +
        "      xqfh21 = #{xqfh21,jdbcType=INTEGER},\n" +
        "      xqfh22 = #{xqfh22,jdbcType=INTEGER},\n" +
        "      xqfh23 = #{xqfh23,jdbcType=INTEGER},\n" +
        "      xqfhp21 = #{xqfhp21,jdbcType=INTEGER},\n" +
        "      xqfc21 = #{xqfc21,jdbcType=INTEGER},\n" +
        "      xqfc22 = #{xqfc22,jdbcType=INTEGER},\n" +
        "      xqfc23 = #{xqfc23,jdbcType=INTEGER},\n" +
        "      xqfcp22 = #{xqfcp22,jdbcType=INTEGER},\n" +
        "      xqf2_swc = #{xqf2Swc,jdbcType=INTEGER},\n" +
        "      xqf3 = #{xqf3,jdbcType=INTEGER},\n" +
        "      xqfh31 = #{xqfh31,jdbcType=INTEGER},\n" +
        "      xqfh32 = #{xqfh32,jdbcType=INTEGER},\n" +
        "      xqfh33 = #{xqfh33,jdbcType=INTEGER},\n" +
        "      xqfhp31 = #{xqfhp31,jdbcType=INTEGER},\n" +
        "      xqfc31 = #{xqfc31,jdbcType=INTEGER},\n" +
        "      xqfc32 = #{xqfc32,jdbcType=INTEGER},\n" +
        "      xqfc33 = #{xqfc33,jdbcType=INTEGER},\n" +
        "      xqfcp32 = #{xqfcp32,jdbcType=INTEGER},\n" +
        "      xqf3_swc = #{xqf3Swc,jdbcType=INTEGER},\n" +
        "      xqf_zdwc1 = #{xqfZdwc1,jdbcType=INTEGER},\n" +
        "      xqf_zdwc2 = #{xqfZdwc2,jdbcType=INTEGER},\n" +
        "      xqf_result = #{xqfResult,jdbcType=INTEGER},\n" +
        "      hqm1 = #{hqm1,jdbcType=INTEGER},\n" +
        "      hqmh11 = #{hqmh11,jdbcType=INTEGER},\n" +
        "      hqmh12 = #{hqmh12,jdbcType=INTEGER},\n" +
        "      hqmh13 = #{hqmh13,jdbcType=INTEGER},\n" +
        "      hqmhp11 = #{hqmhp11,jdbcType=INTEGER},\n" +
        "      hqmc11 = #{hqmc11,jdbcType=INTEGER},\n" +
        "      hqmc12 = #{hqmc12,jdbcType=INTEGER},\n" +
        "      hqmc13 = #{hqmc13,jdbcType=INTEGER},\n" +
        "      hqmcp12 = #{hqmcp12,jdbcType=INTEGER},\n" +
        "      hqm1_swc = #{hqm1Swc,jdbcType=INTEGER},\n" +
        "      hqm2 = #{hqm2,jdbcType=INTEGER},\n" +
        "      hqmh21 = #{hqmh21,jdbcType=INTEGER},\n" +
        "      hqmh22 = #{hqmh22,jdbcType=INTEGER},\n" +
        "      hqmh23 = #{hqmh23,jdbcType=INTEGER},\n" +
        "      hqmhp21 = #{hqmhp21,jdbcType=INTEGER},\n" +
        "      hqmc21 = #{hqmc21,jdbcType=INTEGER},\n" +
        "      hqmc22 = #{hqmc22,jdbcType=INTEGER},\n" +
        "      hqmc23 = #{hqmc23,jdbcType=INTEGER},\n" +
        "      hqmcp22 = #{hqmcp22,jdbcType=INTEGER},\n" +
        "      hqm2_swc = #{hqm2Swc,jdbcType=INTEGER},\n" +
        "      hqm3 = #{hqm3,jdbcType=INTEGER},\n" +
        "      hqmh31 = #{hqmh31,jdbcType=INTEGER},\n" +
        "      hqmh32 = #{hqmh32,jdbcType=INTEGER},\n" +
        "      hqmh33 = #{hqmh33,jdbcType=INTEGER},\n" +
        "      hqmhp31 = #{hqmhp31,jdbcType=INTEGER},\n" +
        "      hqmc31 = #{hqmc31,jdbcType=INTEGER},\n" +
        "      hqmc32 = #{hqmc32,jdbcType=INTEGER},\n" +
        "      hqmc33 = #{hqmc33,jdbcType=INTEGER},\n" +
        "      hqmcp32 = #{hqmcp32,jdbcType=INTEGER},\n" +
        "      hqm3_swc = #{hqm3Swc,jdbcType=INTEGER},\n" +
        "      hqm_zdwc1 = #{hqmZdwc1,jdbcType=INTEGER},\n" +
        "      hqm_zdwc2 = #{hqmZdwc2,jdbcType=INTEGER},\n" +
        "      hqm_result = #{hqmResult,jdbcType=INTEGER},\n" +
        "      dybj = #{dybj,jdbcType=INTEGER},\n" +
        "      yqndsx = #{yqndsx,jdbcType=INTEGER},\n" +
        "      qybj = #{qybj,jdbcType=INTEGER},\n" +
        "      zxbj = #{zxbj,jdbcType=INTEGER},\n" +
        "      qdyl = #{qdyl,jdbcType=INTEGER},\n" +
        "      brhl = #{brhl,jdbcType=INTEGER},\n" +
        "      fztql = #{fztql,jdbcType=INTEGER},\n" +
        "      ajgn = #{ajgn,jdbcType=INTEGER},\n" +
        "      bz = #{bz,jdbcType=INTEGER},\n" +
        "      bz1 = #{bz1,jdbcType=INTEGER}\n" +
        "    where hxjid = #{hxjid,jdbcType=INTEGER}")
    void updateHxj(Hxj hxj);
    //根据电气检测设备id查询设备检测表
    @Select("select * from hxj  order by hxjid desc limit 1 where eq_id = #{eqId}")
    public Hxj findHxj(@Param("eqId") String eqId);

    /*//以id排序，查询最后一条记录
    @Select("select * from dqjc order by dqjcid desc limit 1")
    Dqjc find();
*/

    //根据设备Id,检测仪器Id以及状态查询电器表查询最后一条记录
    @Select("select hxj.* from hxj where hxj.eq_id=#{eqId} and hxj.jcyq_id=#{jcyqId} order by test_time desc, hxjid desc limit 1" )
    Hxj findByEqIdandJcyqIdLast1(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //根据设备Id,检测仪器Id以及状态查询电器表
    @Select("select hxj.* from hxj where hxj.eq_id=#{eqId} and hxj.jcyq_id=#{jcyqId}" )
    List<Hxj> findByEqIdandJcyqId(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //查询所有
    @Select("select * from Hxj where type = #{type}")
    List<Hxj> findAll(@Param("type")Integer type);

    /**
     * 删除电器数据
     */
    /*@Delete("delete from dqjc where eq_id=#{eqId} and jcyq_id=#{jcyqId}")
    void delete(@Param("eqId")String eqId,@Param("jcyqId")String jcyqId);*/

    /**
     * 根据iD状态查询
     */
    @Select("select * from hxj where hxjid=#{hxjid}")
    Hxj findByHxjId(@Param("hxjid") Integer hxjid);
    /*
    修改状态
     */
    /*@Update("update Hxj set state=#{state} where dqjcid=#{dqjcid}")
    void updateState(@Param("dqjcid")Integer dqjcid,@Param("state")Integer state);*/
    //修改审核人意见
    @Update("update hxj set shr_jcjl=#{shrJcjl},auditor=#{auditor},shsj_time=#{shsjTime} where hxjid=#{hxjid}")
    void updateShrJcjy(@Param("hxjid") Integer hxjid, @Param("shrJcjl") String shrJcjl, @Param("auditor") String auditor, @Param("shsjTime") Date shsjTime);




}
