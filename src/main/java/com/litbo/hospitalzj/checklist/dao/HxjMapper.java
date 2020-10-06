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
            "    set bhjdzk_yxz = #{bhjdzkYxz,jdbcType=VARCHAR},\n" +
            "      jyzk_yxz = #{jyzkYxz,jdbcType=VARCHAR},\n" +
            "      ddld_zc_yxz = #{ddldZcYxz,jdbcType=VARCHAR},\n" +
            "      ddld_dygz_yxz = #{ddldDygzYxz,jdbcType=VARCHAR},\n" +
            "      wkld_zc_yxz = #{wkldZcYxz,jdbcType=VARCHAR},\n" +
            "      wkld_dy_yx = #{wkldDyYx,jdbcType=VARCHAR},\n" +
            "      cql_hxjsdz1 = #{cqlHxjsdz1,jdbcType=VARCHAR},\n" +
            "      cql_hxjsdz2 = #{cqlHxjsdz2,jdbcType=VARCHAR},\n" +
            "      cql_hxjsdz3 = #{cqlHxjsdz3,jdbcType=VARCHAR},\n" +
            "      cql_hxjsdz4 = #{cqlHxjsdz4,jdbcType=VARCHAR},\n" +
            "      cql_hxjsdz5 = #{cqlHxjsdz5,jdbcType=VARCHAR},\n" +
            "      cql_zdyc = #{cqlZdyc,jdbcType=VARCHAR},\n" +
            "      qztqpl_hxjsdz1 = #{qztqplHxjsdz1,jdbcType=VARCHAR},\n" +
            "      qztqpl_hxjsdz2 = #{qztqplHxjsdz2,jdbcType=VARCHAR},\n" +
            "      qztqpl_hxjsdz3 = #{qztqplHxjsdz3,jdbcType=VARCHAR},\n" +
            "      qztqpl_hxjsdz4 = #{qztqplHxjsdz4,jdbcType=VARCHAR},\n" +
            "      qztqpl_hxjsdz5 = #{qztqplHxjsdz5,jdbcType=VARCHAR},\n" +
            "      qztqpl_zdyc = #{qztqplZdyc,jdbcType=VARCHAR},\n" +
            "      xrynd_hxjsdz1 = #{xryndHxjsdz1,jdbcType=VARCHAR},\n" +
            "      xrynd_hxjsdz2 = #{xryndHxjsdz2,jdbcType=VARCHAR},\n" +
            "      xrynd_hxjsdz3 = #{xryndHxjsdz3,jdbcType=VARCHAR},\n" +
            "      xrynd_hxjsdz4 = #{xryndHxjsdz4,jdbcType=VARCHAR},\n" +
            "      xrynd_hxjsdz5 = #{xryndHxjsdz5,jdbcType=VARCHAR},\n" +
            "      xrynd_zdyc = #{xryndZdyc,jdbcType=VARCHAR},\n" +
            "      xqfzyl_hxjsdz1 = #{xqfzylHxjsdz1,jdbcType=VARCHAR},\n" +
            "      xqfzyl_hxjsdz2 = #{xqfzylHxjsdz2,jdbcType=VARCHAR},\n" +
            "      xqfzyl_hxjsdz3 = #{xqfzylHxjsdz3,jdbcType=VARCHAR},\n" +
            "      xqfzyl_hxjsdz4 = #{xqfzylHxjsdz4,jdbcType=VARCHAR},\n" +
            "      xqfzyl_hxjsdz5 = #{xqfzylHxjsdz5,jdbcType=VARCHAR},\n" +
            "      xqfzyl_zdyc1 = #{xqfzylZdyc1,jdbcType=VARCHAR},\n" +
            "      xqfzyl_zdyc2 = #{xqfzylZdyc2,jdbcType=VARCHAR},\n" +
            "      hqmzy_hxjsdz1 = #{hqmzyHxjsdz1,jdbcType=VARCHAR},\n" +
            "      hqmzy_hxjsdz2 = #{hqmzyHxjsdz2,jdbcType=VARCHAR},\n" +
            "      hqmzy_hxjsdz3 = #{hqmzyHxjsdz3,jdbcType=VARCHAR},\n" +
            "      hqmzy_hxjsdz4 = #{hqmzyHxjsdz4,jdbcType=VARCHAR},\n" +
            "      hqmzy_hxjsdz5 = #{hqmzyHxjsdz5,jdbcType=VARCHAR},\n" +
            "      hqmzy_zdyc = #{hqmzyZdyc,jdbcType=VARCHAR},\n" +
            "      type = #{type,jdbcType=INTEGER}" +
            "    where hxj_template_id = #{hxjTemplateId,jdbcType=INTEGER}")
    int updateHxjTemplate(HxjTemplate hxjTemplate);
    //插入模板值
    @Insert("    insert into hxj_template (bhjdzk_yxz, jyzk_yxz, \n" +
            "      ddld_zc_yxz, ddld_dygz_yxz, wkld_zc_yxz, \n" +
            "      wkld_dy_yx, cql_hxjsdz1, cql_hxjsdz2, \n" +
            "      cql_hxjsdz3, cql_hxjsdz4, cql_hxjsdz5, \n" +
            "      cql_zdyc, qztqpl_hxjsdz1, qztqpl_hxjsdz2, \n" +
            "      qztqpl_hxjsdz3, qztqpl_hxjsdz4, qztqpl_hxjsdz5,qztqpl_zdyc \n" +
            "      xrynd_hxjsdz1, xrynd_hxjsdz2, xrynd_hxjsdz3, \n" +
            "      xrynd_hxjsdz4, xrynd_hxjsdz5, xrynd_zdyc, \n" +
            "      xqfzyl_hxjsdz1, xqfzyl_hxjsdz2, xqfzyl_hxjsdz3, \n" +
            "      xqfzyl_hxjsdz4, xqfzyl_hxjsdz5, xqfzyl_zdyc1, xqfzyl_zdyc2, \n" +
            "      hqmzy_hxjsdz1, hqmzy_hxjsdz2, hqmzy_hxjsdz3, \n" +
            "      hqmzy_hxjsdz4, hqmzy_hxjsdz5, hqmzy_zdyc, \n" +
            "      type )" +
            "    values (#{bhjdzkYxz,jdbcType=VARCHAR}, #{jyzkYxz,jdbcType=VARCHAR}, \n" +
            "      #{ddldZcYxz,jdbcType=VARCHAR}, #{ddldDygzYxz,jdbcType=VARCHAR}, #{wkldZcYxz,jdbcType=VARCHAR}, \n" +
            "      #{wkldDyYx,jdbcType=VARCHAR}, #{cqlHxjsdz1,jdbcType=VARCHAR}, #{cqlHxjsdz2,jdbcType=VARCHAR}, \n" +
            "      #{cqlHxjsdz3,jdbcType=VARCHAR}, #{cqlHxjsdz4,jdbcType=VARCHAR}, #{cqlHxjsdz5,jdbcType=VARCHAR}, \n" +
            "      #{cqlZdyc,jdbcType=VARCHAR}, #{qztqplHxjsdz1,jdbcType=VARCHAR}, #{qztqplHxjsdz2,jdbcType=VARCHAR}, \n" +
            "      #{qztqplHxjsdz3,jdbcType=VARCHAR}, #{qztqplHxjsdz4,jdbcType=VARCHAR}, #{qztqplHxjsdz5,jdbcType=VARCHAR},#{qztqplZdyc,jdbcType=VARCHAR}, \n" +
            "      #{xryndHxjsdz1,jdbcType=VARCHAR}, #{xryndHxjsdz2,jdbcType=VARCHAR}, #{xryndHxjsdz3,jdbcType=VARCHAR}, \n" +
            "      #{xryndHxjsdz4,jdbcType=VARCHAR}, #{xryndHxjsdz5,jdbcType=VARCHAR}, #{xryndZdyc,jdbcType=VARCHAR}, \n" +
            "      #{xqfzylHxjsdz1,jdbcType=VARCHAR}, #{xqfzylHxjsdz2,jdbcType=VARCHAR}, #{xqfzylHxjsdz3,jdbcType=VARCHAR}, \n" +
            "      #{xqfzylHxjsdz4,jdbcType=VARCHAR}, #{xqfzylHxjsdz5,jdbcType=VARCHAR}, #{xqfzylZdyc1,jdbcType=VARCHAR},#{xqfzylZdyc2,jdbcType=VARCHAR}, \n" +
            "      #{hqmzyHxjsdz1,jdbcType=VARCHAR}, #{hqmzyHxjsdz2,jdbcType=VARCHAR}, #{hqmzyHxjsdz3,jdbcType=VARCHAR}, \n" +
            "      #{hqmzyHxjsdz4,jdbcType=VARCHAR}, #{hqmzyHxjsdz5,jdbcType=VARCHAR}, #{hqmzyZdyc,jdbcType=VARCHAR}, \n" +
            "      #{type,jdbcType=INTEGER}\n" +
            "      )")
    int insertHxjTemplate(HxjTemplate hxjTemplate);

    //保存
    @Insert("insert into hxj ( jcyq_id, eq_id, \n" +
            "      tester, auditor, shsj_time, \n" +
            "      shr_jcjl, test_time, jcjl, \n" +
            "      jcsm, bhjdzk_clz_value, bhjdzk_yxz, \n" +
            "      bhjdzk_result, jyzk_clz_value, jyzk_yxz, \n" +
            "      jykz_result, ddld_zc_zx_value, ddld_zc_fx_value, \n" +
            "      ddld_zc_yxz, ddld_zc_result, ddld_dygz_zxdl_value, \n" +
            "      ddld_dygz_fxdl_value, ddld_dygz_yxz, ddld_dygz_result, \n" +
            "      wkld_zc_zx_value, wkld_zc_fx_value, wkld_zc_yxz, \n" +
            "      wkld_zc_result, wkld_dy_zxdl_value1, wkld_dy_zxdd_value, \n" +
            "      wkld_dy_zxdl_value2, wkld_dy_fxdd_value, wkld_dy_yx, \n" +
            "      wkld_dy_result, cql_hxjsdz1, cql_hxjsdz2, \n" +
            "      cql_hxjsdz3, cql_hxjsdz4, cql_hxjsdz5, \n" +
            "      cql_hxjjcz_value11, cql_hxjjcz_value12, cql_hxjjcz_value13, \n" +
            "      cql_hxjjcz_value14, cql_hxjjcz_value15, cql_hxjjcz_value21, \n" +
            "      cql_hxjjcz_value22, cql_hxjjcz_value23, cql_hxjjcz_value24, \n" +
            "      cql_hxjjcz_value25, cql_hxjjcz_value31, cql_hxjjcz_value32, \n" +
            "      cql_hxjjcz_value33, cql_hxjjcz_value34, cql_hxjjcz_value35, \n" +
            "      cql_pjz_jcz_value1, cql_pjz_jcz_value2, cql_pjz_jcz_value3, \n" +
            "      cql_pjz_jcz_value4, cql_pjz_jcz_value5, cql_cslclz_value11, \n" +
            "      cql_cslclz_value12, cql_cslclz_value13, cql_cslclz_value14, \n" +
            "      cql_cslclz_value15, cql_cslclz_value21, cql_cslclz_value22, \n" +
            "      cql_cslclz_value23, cql_cslclz_value24, cql_cslclz_value25, \n" +
            "      cql_cslclz_value31, cql_cslclz_value32, cql_cslclz_value33, \n" +
            "      cql_cslclz_value34, cql_cslclz_value35, cql_pjz_clz_value1, \n" +
            "      cql_pjz_clz_value2, cql_pjz_clz_value3, cql_pjz_clz_value4, \n" +
            "      cql_pjz_clz_value5, cql_szwc_value1, cql_szwc_value2, \n" +
            "      cql_szwc_value3, cql_szwc_value4, cql_szwc_value5, \n" +
            "      cql_scwc_value1, cql_scwc_value2, cql_scwc_value3, \n" +
            "      cql_scwc_value4, cql_scwc_value5, cql_zdyc, \n" +
            "      cql_result, qztqpl_hxjsdz1, qztqpl_hxjsdz2, \n" +
            "      qztqpl_hxjsdz3, qztqpl_hxjsdz4, qztqpl_hxjsdz5, \n" +
            "      qztqpl_hxjjcz_value11, qztqpl_hxjjcz_value12, \n" +
            "      qztqpl_hxjjcz_value13, qztqpl_hxjjcz_value14, \n" +
            "      qztqpl_hxjjcz_value15, qztqpl_hxjjcz_value21, \n" +
            "      qztqpl_hxjjcz_value22, qztqpl_hxjjcz_value23, \n" +
            "      qztqpl_hxjjcz_value24, qztqpl_hxjjcz_value25, \n" +
            "      qztqpl_hxjjcz_value31, qztqpl_hxjjcz_value32, \n" +
            "      qztqpl_hxjjcz_value33, qztqpl_hxjjcz_value34, \n" +
            "      qztqpl_hxjjcz_value35, qztqpl_pjz_jcz_value1, \n" +
            "      qztqpl_pjz_jcz_value2, qztqpl_pjz_jcz_value3, \n" +
            "      qztqpl_pjz_jcz_value4, qztqpl_pjz_jcz_value5, \n" +
            "      qztqpl_csyclz_value11, qztqpl_csyclz_value12, \n" +
            "      qztqpl_csyclz_value13, qztqpl_csyclz_value14, \n" +
            "      qztqpl_csyclz_value15, qztqpl_csyclz_value21, \n" +
            "      qztqpl_csyclz_value22, qztqpl_csyclz_value23, \n" +
            "      qztqpl_csyclz_value24, qztqpl_csyclz_value25, \n" +
            "      qztqpl_csyclz_value31, qztqpl_csyclz_value32, \n" +
            "      qztqpl_csyclz_value33, qztqpl_csyclz_value34, \n" +
            "      qztqpl_csyclz_value35, qztqpl_pjz_clz_value1, \n" +
            "      qztqpl_pjz_clz_value2, qztqpl_pjz_clz_value3, \n" +
            "      qztqpl_pjz_clz_value4, qztqpl_pjz_clz_value5, \n" +
            "      qztqpl_szwc_value1, qztqpl_szwc_value2, qztqpl_szwc_value3, \n" +
            "      qztqpl_szwc_value4, qztqpl_szwc_value5, qztqpl_scwc_value1, \n" +
            "      qztqpl_scwc_value2, qztqpl_scwc_value3, qztqpl_scwc_value4, \n" +
            "      qztqpl_scwc_value5, qztqpl_zdyc, qztqpl_result, \n" +
            "      xrynd_hxjsdz1, xrynd_hxjsdz2, xrynd_hxjsdz3, \n" +
            "      xrynd_hxjsdz4, xrynd_hxjsdz5, xrynd_hxjjcz_value11, \n" +
            "      xrynd_hxjjcz_value12, xrynd_hxjjcz_value13, \n" +
            "      xrynd_hxjjcz_value14, xrynd_hxjjcz_value15, \n" +
            "      xrynd_hxjjcz_value21, xrynd_hxjjcz_value22, \n" +
            "      xrynd_hxjjcz_value23, xrynd_hxjjcz_value24, \n" +
            "      xrynd_hxjjcz_value25, xrynd_hxjjcz_value31, \n" +
            "      xrynd_hxjjcz_value32, xrynd_hxjjcz_value33, \n" +
            "      xrynd_hxjjcz_value34, xrynd_hxjjcz_value35, \n" +
            "      xrynd_pjz_jcz_value1, xrynd_pjz_jcz_value2, xrynd_pjz_jcz_value3, \n" +
            "      xrynd_pjz_jcz_value4, xrynd_pjz_jcz_value5, xrynd_cslclz_value11, \n" +
            "      xrynd_cslclz_value12, xrynd_cslclz_value13, \n" +
            "      xrynd_cslclz_value14, xrynd_cslclz_value15, \n" +
            "      xrynd_cslclz_value21, xrynd_cslclz_value22, \n" +
            "      xrynd_cslclz_value23, xrynd_cslclz_value24, \n" +
            "      xrynd_cslclz_value25, xrynd_cslclz_value31, \n" +
            "      xrynd_cslclz_value32, xrynd_cslclz_value33, \n" +
            "      xrynd_cslclz_value34, xrynd_cslclz_value35, \n" +
            "      xrynd_pjz_clz_value1, xrynd_pjz_clz_value2, xrynd_pjz_clz_value3, \n" +
            "      xrynd_pjz_clz_value4, xrynd_pjz_clz_value5, xrynd_szwc_value1, \n" +
            "      xrynd_szwc_value2, xrynd_szwc_value3, xrynd_szwc_value4, \n" +
            "      xrynd_szwc_value5, xrynd_scwc_value1, xrynd_scwc_value2, \n" +
            "      xrynd_scwc_value3, xrynd_scwc_value4, xrynd_scwc_value5, \n" +
            "      xrynd_zdyc, xrynd_result, xqfzyl_hxjsdz1, \n" +
            "      xqfzyl_hxjsdz2, xqfzyl_hxjsdz3, xqfzyl_hxjsdz4, \n" +
            "      xqfzyl_hxjsdz5, xqfzyl_hxjjcz_value11, xqfzyl_hxjjcz_value12, \n" +
            "      xqfzyl_hxjjcz_value13, xqfzyl_hxjjcz_value14, \n" +
            "      xqfzyl_hxjjcz_value15, xqfzyl_hxjjcz_value21, \n" +
            "      xqfzyl_hxjjcz_value22, xqfzyl_hxjjcz_value23, \n" +
            "      xqfzyl_hxjjcz_value24, xqfzyl_hxjjcz_value25, \n" +
            "      xqfzyl_hxjjcz_value31, xqfzyl_hxjjcz_value32, \n" +
            "      xqfzyl_hxjjcz_value33, xqfzyl_hxjjcz_value34, \n" +
            "      xqfzyl_hxjjcz_value35, xqfzyl_pjz_jcz_value1, \n" +
            "      xqfzyl_pjz_jcz_value2, xqfzyl_pjz_jcz_value3, \n" +
            "      xqfzyl_pjz_jcz_value4, xqfzyl_pjz_jcz_value5, \n" +
            "      xqfzyl_cslclz_value11, xqfzyl_cslclz_value12, \n" +
            "      xqfzyl_cslclz_value13, xqfzyl_cslclz_value14, \n" +
            "      xqfzyl_cslclz_value15, xqfzyl_cslclz_value21, \n" +
            "      xqfzyl_cslclz_value22, xqfzyl_cslclz_value23, \n" +
            "      xqfzyl_cslclz_value24, xqfzyl_cslclz_value25, \n" +
            "      xqfzyl_cslclz_value31, xqfzyl_cslclz_value32, \n" +
            "      xqfzyl_cslclz_value33, xqfzyl_cslclz_value34, \n" +
            "      xqfzyl_cslclz_value35, xqfzyl_pjz_clz_value1, \n" +
            "      xqfzyl_pjz_clz_value2, xqfzyl_pjz_clz_value3, \n" +
            "      xqfzyl_pjz_clz_value4, xqfzyl_pjz_clz_value5, \n" +
            "      xqfzyl_szwc_value1, xqfzyl_szwc_value2, xqfzyl_szwc_value3, \n" +
            "      xqfzyl_szwc_value4, xqfzyl_szwc_value5, xqfzyl_scwc_value1, \n" +
            "      xqfzyl_scwc_value2, xqfzyl_scwc_value3, xqfzyl_scwc_value4, \n" +
            "      xqfzyl_scwc_value5, xqfzyl_zdyc2, xqfzyl_zdyc1, \n" +
            "      xqfzyl_result, hqmzy_hxjsdz1, hqmzy_hxjsdz2, \n" +
            "      hqmzy_hxjsdz3, hqmzy_hxjsdz4, hqmzy_hxjsdz5, \n" +
            "      hqmzy_hxjjcz_value11, hqmzy_hxjjcz_value12, \n" +
            "      hqmzy_hxjjcz_value13, hqmzy_hxjjcz_value14, \n" +
            "      hqmzy_hxjjcz_value15, hqmzy_hxjjcz_value21, \n" +
            "      hqmzy_hxjjcz_value22, hqmzy_hxjjcz_value23, \n" +
            "      hqmzy_hxjjcz_value24, hqmzy_hxjjcz_value25, \n" +
            "      hqmzy_hxjjcz_value31, hqmzy_hxjjcz_value32, \n" +
            "      hqmzy_hxjjcz_value33, hqmzy_hxjjcz_value34, \n" +
            "      hqmzy_hxjjcz_value35, hqmzy_pjz_jcz_value1, \n" +
            "      hqmzy_pjz_jcz_value2, hqmzy_pjz_jcz_value3, hqmzy_pjz_jcz_value4, \n" +
            "      hqmzy_pjz_jcz_value5, hqmzy_cslclz_value11, \n" +
            "      hqmzy_cslclz_value12, hqmzy_cslclz_value13, \n" +
            "      hqmzy_cslclz_value14, hqmzy_cslclz_value15, \n" +
            "      hqmzy_cslclz_value21, hqmzy_cslclz_value22, \n" +
            "      hqmzy_cslclz_value23, hqmzy_cslclz_value24, \n" +
            "      hqmzy_cslclz_value25, hqmzy_cslclz_value31, \n" +
            "      hqmzy_cslclz_value32, hqmzy_cslclz_value33, \n" +
            "      hqmzy_cslclz_value34, hqmzy_cslclz_value35, \n" +
            "      hqmzy_pjz_clz_value1, hqmzy_pjz_clz_value2, hqmzy_pjz_clz_value3, \n" +
            "      hqmzy_pjz_clz_value4, hqmzy_pjz_clz_value5, hqmzy_szwc_value1, \n" +
            "      hqmzy_szwc_value2, hqmzy_szwc_value3, hqmzy_szwc_value4, \n" +
            "      hqmzy_szwc_value5, hqmzy_scwc_value1, hqmzy_scwc_value2, \n" +
            "      hqmzy_scwc_value3, hqmzy_scwc_value4, hqmzy_scwc_value5, \n" +
            "      hqmzy_zdyc, hqmzy_result, fwczdykg, \n" +
            "      brhlgybhgn, jygn, jysx, \n" +
            "      qdylsxxbj, bjsz, ddbj, \n" +
            "      hxplsxxbj, nbdy, qybj, \n" +
            "      yndsxxbj, wtjyfcs, fztqlsxxbj, \n" +
            "      hqmzysxxbj, tqzxbj, type\n" +
            "      )\n" +
            "    values ( #{jcyqId,jdbcType=INTEGER}, #{eqId,jdbcType=VARCHAR}, \n" +
            "      #{tester,jdbcType=VARCHAR}, #{auditor,jdbcType=VARCHAR}, #{shsjTime,jdbcType=TIMESTAMP}, \n" +
            "      #{shrJcjl,jdbcType=VARCHAR}, #{testTime,jdbcType=VARCHAR}, #{jcjl,jdbcType=VARCHAR}, \n" +
            "      #{jcsm,jdbcType=VARCHAR}, #{bhjdzkClzValue,jdbcType=VARCHAR}, #{bhjdzkYxz,jdbcType=VARCHAR}, \n" +
            "      #{bhjdzkResult,jdbcType=VARCHAR}, #{jyzkClzValue,jdbcType=VARCHAR}, #{jyzkYxz,jdbcType=VARCHAR}, \n" +
            "      #{jykzResult,jdbcType=VARCHAR}, #{ddldZcZxValue,jdbcType=VARCHAR}, #{ddldZcFxValue,jdbcType=VARCHAR}, \n" +
            "      #{ddldZcYxz,jdbcType=VARCHAR}, #{ddldZcResult,jdbcType=VARCHAR}, #{ddldDygzZxdlValue,jdbcType=VARCHAR}, \n" +
            "      #{ddldDygzFxdlValue,jdbcType=VARCHAR}, #{ddldDygzYxz,jdbcType=VARCHAR}, #{ddldDygzResult,jdbcType=VARCHAR}, \n" +
            "      #{wkldZcZxValue,jdbcType=VARCHAR}, #{wkldZcFxValue,jdbcType=VARCHAR}, #{wkldZcYxz,jdbcType=VARCHAR}, \n" +
            "      #{wkldZcResult,jdbcType=VARCHAR}, #{wkldDyZxdlValue1,jdbcType=VARCHAR}, #{wkldDyZxddValue,jdbcType=VARCHAR}, \n" +
            "      #{wkldDyZxdlValue2,jdbcType=VARCHAR}, #{wkldDyFxddValue,jdbcType=VARCHAR}, #{wkldDyYx,jdbcType=VARCHAR}, \n" +
            "      #{wkldDyResult,jdbcType=VARCHAR}, #{cqlHxjsdz1,jdbcType=VARCHAR}, #{cqlHxjsdz2,jdbcType=VARCHAR}, \n" +
            "      #{cqlHxjsdz3,jdbcType=VARCHAR}, #{cqlHxjsdz4,jdbcType=VARCHAR}, #{cqlHxjsdz5,jdbcType=VARCHAR}, \n" +
            "      #{cqlHxjjczValue11,jdbcType=VARCHAR}, #{cqlHxjjczValue12,jdbcType=VARCHAR}, #{cqlHxjjczValue13,jdbcType=VARCHAR}, \n" +
            "      #{cqlHxjjczValue14,jdbcType=VARCHAR}, #{cqlHxjjczValue15,jdbcType=VARCHAR}, #{cqlHxjjczValue21,jdbcType=VARCHAR}, \n" +
            "      #{cqlHxjjczValue22,jdbcType=VARCHAR}, #{cqlHxjjczValue23,jdbcType=VARCHAR}, #{cqlHxjjczValue24,jdbcType=VARCHAR}, \n" +
            "      #{cqlHxjjczValue25,jdbcType=VARCHAR}, #{cqlHxjjczValue31,jdbcType=VARCHAR}, #{cqlHxjjczValue32,jdbcType=VARCHAR}, \n" +
            "      #{cqlHxjjczValue33,jdbcType=VARCHAR}, #{cqlHxjjczValue34,jdbcType=VARCHAR}, #{cqlHxjjczValue35,jdbcType=VARCHAR}, \n" +
            "      #{cqlPjzJczValue1,jdbcType=VARCHAR}, #{cqlPjzJczValue2,jdbcType=VARCHAR}, #{cqlPjzJczValue3,jdbcType=VARCHAR}, \n" +
            "      #{cqlPjzJczValue4,jdbcType=VARCHAR}, #{cqlPjzJczValue5,jdbcType=VARCHAR}, #{cqlCslclzValue11,jdbcType=VARCHAR}, \n" +
            "      #{cqlCslclzValue12,jdbcType=VARCHAR}, #{cqlCslclzValue13,jdbcType=VARCHAR}, #{cqlCslclzValue14,jdbcType=VARCHAR}, \n" +
            "      #{cqlCslclzValue15,jdbcType=VARCHAR}, #{cqlCslclzValue21,jdbcType=VARCHAR}, #{cqlCslclzValue22,jdbcType=VARCHAR}, \n" +
            "      #{cqlCslclzValue23,jdbcType=VARCHAR}, #{cqlCslclzValue24,jdbcType=VARCHAR}, #{cqlCslclzValue25,jdbcType=VARCHAR}, \n" +
            "      #{cqlCslclzValue31,jdbcType=VARCHAR}, #{cqlCslclzValue32,jdbcType=VARCHAR}, #{cqlCslclzValue33,jdbcType=VARCHAR}, \n" +
            "      #{cqlCslclzValue34,jdbcType=VARCHAR}, #{cqlCslclzValue35,jdbcType=VARCHAR}, #{cqlPjzClzValue1,jdbcType=VARCHAR}, \n" +
            "      #{cqlPjzClzValue2,jdbcType=VARCHAR}, #{cqlPjzClzValue3,jdbcType=VARCHAR}, #{cqlPjzClzValue4,jdbcType=VARCHAR}, \n" +
            "      #{cqlPjzClzValue5,jdbcType=VARCHAR}, #{cqlSzwcValue1,jdbcType=VARCHAR}, #{cqlSzwcValue2,jdbcType=VARCHAR}, \n" +
            "      #{cqlSzwcValue3,jdbcType=VARCHAR}, #{cqlSzwcValue4,jdbcType=VARCHAR}, #{cqlSzwcValue5,jdbcType=VARCHAR}, \n" +
            "      #{cqlScwcValue1,jdbcType=VARCHAR}, #{cqlScwcValue2,jdbcType=VARCHAR}, #{cqlScwcValue3,jdbcType=VARCHAR}, \n" +
            "      #{cqlScwcValue4,jdbcType=VARCHAR}, #{cqlScwcValue5,jdbcType=VARCHAR}, #{cqlZdyc,jdbcType=VARCHAR}, \n" +
            "      #{cqlResult,jdbcType=VARCHAR}, #{qztqplHxjsdz1,jdbcType=VARCHAR}, #{qztqplHxjsdz2,jdbcType=VARCHAR}, \n" +
            "      #{qztqplHxjsdz3,jdbcType=VARCHAR}, #{qztqplHxjsdz4,jdbcType=VARCHAR}, #{qztqplHxjsdz5,jdbcType=VARCHAR}, \n" +
            "      #{qztqplHxjjczValue11,jdbcType=VARCHAR}, #{qztqplHxjjczValue12,jdbcType=VARCHAR}, \n" +
            "      #{qztqplHxjjczValue13,jdbcType=VARCHAR}, #{qztqplHxjjczValue14,jdbcType=VARCHAR}, \n" +
            "      #{qztqplHxjjczValue15,jdbcType=VARCHAR}, #{qztqplHxjjczValue21,jdbcType=VARCHAR}, \n" +
            "      #{qztqplHxjjczValue22,jdbcType=VARCHAR}, #{qztqplHxjjczValue23,jdbcType=VARCHAR}, \n" +
            "      #{qztqplHxjjczValue24,jdbcType=VARCHAR}, #{qztqplHxjjczValue25,jdbcType=VARCHAR}, \n" +
            "      #{qztqplHxjjczValue31,jdbcType=VARCHAR}, #{qztqplHxjjczValue32,jdbcType=VARCHAR}, \n" +
            "      #{qztqplHxjjczValue33,jdbcType=VARCHAR}, #{qztqplHxjjczValue34,jdbcType=VARCHAR}, \n" +
            "      #{qztqplHxjjczValue35,jdbcType=VARCHAR}, #{qztqplPjzJczValue1,jdbcType=VARCHAR}, \n" +
            "      #{qztqplPjzJczValue2,jdbcType=VARCHAR}, #{qztqplPjzJczValue3,jdbcType=VARCHAR}, \n" +
            "      #{qztqplPjzJczValue4,jdbcType=VARCHAR}, #{qztqplPjzJczValue5,jdbcType=VARCHAR}, \n" +
            "      #{qztqplCsyclzValue11,jdbcType=VARCHAR}, #{qztqplCsyclzValue12,jdbcType=VARCHAR}, \n" +
            "      #{qztqplCsyclzValue13,jdbcType=VARCHAR}, #{qztqplCsyclzValue14,jdbcType=VARCHAR}, \n" +
            "      #{qztqplCsyclzValue15,jdbcType=VARCHAR}, #{qztqplCsyclzValue21,jdbcType=VARCHAR}, \n" +
            "      #{qztqplCsyclzValue22,jdbcType=VARCHAR}, #{qztqplCsyclzValue23,jdbcType=VARCHAR}, \n" +
            "      #{qztqplCsyclzValue24,jdbcType=VARCHAR}, #{qztqplCsyclzValue25,jdbcType=VARCHAR}, \n" +
            "      #{qztqplCsyclzValue31,jdbcType=VARCHAR}, #{qztqplCsyclzValue32,jdbcType=VARCHAR}, \n" +
            "      #{qztqplCsyclzValue33,jdbcType=VARCHAR}, #{qztqplCsyclzValue34,jdbcType=VARCHAR}, \n" +
            "      #{qztqplCsyclzValue35,jdbcType=VARCHAR}, #{qztqplPjzClzValue1,jdbcType=VARCHAR}, \n" +
            "      #{qztqplPjzClzValue2,jdbcType=VARCHAR}, #{qztqplPjzClzValue3,jdbcType=VARCHAR}, \n" +
            "      #{qztqplPjzClzValue4,jdbcType=VARCHAR}, #{qztqplPjzClzValue5,jdbcType=VARCHAR}, \n" +
            "      #{qztqplSzwcValue1,jdbcType=VARCHAR}, #{qztqplSzwcValue2,jdbcType=VARCHAR}, #{qztqplSzwcValue3,jdbcType=VARCHAR}, \n" +
            "      #{qztqplSzwcValue4,jdbcType=VARCHAR}, #{qztqplSzwcValue5,jdbcType=VARCHAR}, #{qztqplScwcValue1,jdbcType=VARCHAR}, \n" +
            "      #{qztqplScwcValue2,jdbcType=VARCHAR}, #{qztqplScwcValue3,jdbcType=VARCHAR}, #{qztqplScwcValue4,jdbcType=VARCHAR}, \n" +
            "      #{qztqplScwcValue5,jdbcType=VARCHAR}, #{qztqplZdyc,jdbcType=VARCHAR}, #{qztqplResult,jdbcType=VARCHAR}, \n" +
            "      #{xryndHxjsdz1,jdbcType=VARCHAR}, #{xryndHxjsdz2,jdbcType=VARCHAR}, #{xryndHxjsdz3,jdbcType=VARCHAR}, \n" +
            "      #{xryndHxjsdz4,jdbcType=VARCHAR}, #{xryndHxjsdz5,jdbcType=VARCHAR}, #{xryndHxjjczValue11,jdbcType=VARCHAR}, \n" +
            "      #{xryndHxjjczValue12,jdbcType=VARCHAR}, #{xryndHxjjczValue13,jdbcType=VARCHAR}, \n" +
            "      #{xryndHxjjczValue14,jdbcType=VARCHAR}, #{xryndHxjjczValue15,jdbcType=VARCHAR}, \n" +
            "      #{xryndHxjjczValue21,jdbcType=VARCHAR}, #{xryndHxjjczValue22,jdbcType=VARCHAR}, \n" +
            "      #{xryndHxjjczValue23,jdbcType=VARCHAR}, #{xryndHxjjczValue24,jdbcType=VARCHAR}, \n" +
            "      #{xryndHxjjczValue25,jdbcType=VARCHAR}, #{xryndHxjjczValue31,jdbcType=VARCHAR}, \n" +
            "      #{xryndHxjjczValue32,jdbcType=VARCHAR}, #{xryndHxjjczValue33,jdbcType=VARCHAR}, \n" +
            "      #{xryndHxjjczValue34,jdbcType=VARCHAR}, #{xryndHxjjczValue35,jdbcType=VARCHAR}, \n" +
            "      #{xryndPjzJczValue1,jdbcType=VARCHAR}, #{xryndPjzJczValue2,jdbcType=VARCHAR}, #{xryndPjzJczValue3,jdbcType=VARCHAR}, \n" +
            "      #{xryndPjzJczValue4,jdbcType=VARCHAR}, #{xryndPjzJczValue5,jdbcType=VARCHAR}, #{xryndCslclzValue11,jdbcType=VARCHAR}, \n" +
            "      #{xryndCslclzValue12,jdbcType=VARCHAR}, #{xryndCslclzValue13,jdbcType=VARCHAR}, \n" +
            "      #{xryndCslclzValue14,jdbcType=VARCHAR}, #{xryndCslclzValue15,jdbcType=VARCHAR}, \n" +
            "      #{xryndCslclzValue21,jdbcType=VARCHAR}, #{xryndCslclzValue22,jdbcType=VARCHAR}, \n" +
            "      #{xryndCslclzValue23,jdbcType=VARCHAR}, #{xryndCslclzValue24,jdbcType=VARCHAR}, \n" +
            "      #{xryndCslclzValue25,jdbcType=VARCHAR}, #{xryndCslclzValue31,jdbcType=VARCHAR}, \n" +
            "      #{xryndCslclzValue32,jdbcType=VARCHAR}, #{xryndCslclzValue33,jdbcType=VARCHAR}, \n" +
            "      #{xryndCslclzValue34,jdbcType=VARCHAR}, #{xryndCslclzValue35,jdbcType=VARCHAR}, \n" +
            "      #{xryndPjzClzValue1,jdbcType=VARCHAR}, #{xryndPjzClzValue2,jdbcType=VARCHAR}, #{xryndPjzClzValue3,jdbcType=VARCHAR}, \n" +
            "      #{xryndPjzClzValue4,jdbcType=VARCHAR}, #{xryndPjzClzValue5,jdbcType=VARCHAR}, #{xryndSzwcValue1,jdbcType=VARCHAR}, \n" +
            "      #{xryndSzwcValue2,jdbcType=VARCHAR}, #{xryndSzwcValue3,jdbcType=VARCHAR}, #{xryndSzwcValue4,jdbcType=VARCHAR}, \n" +
            "      #{xryndSzwcValue5,jdbcType=VARCHAR}, #{xryndScwcValue1,jdbcType=VARCHAR}, #{xryndScwcValue2,jdbcType=VARCHAR}, \n" +
            "      #{xryndScwcValue3,jdbcType=VARCHAR}, #{xryndScwcValue4,jdbcType=VARCHAR}, #{xryndScwcValue5,jdbcType=VARCHAR}, \n" +
            "      #{xryndZdyc,jdbcType=VARCHAR}, #{xryndResult,jdbcType=VARCHAR}, #{xqfzylHxjsdz1,jdbcType=VARCHAR}, \n" +
            "      #{xqfzylHxjsdz2,jdbcType=VARCHAR}, #{xqfzylHxjsdz3,jdbcType=VARCHAR}, #{xqfzylHxjsdz4,jdbcType=VARCHAR}, \n" +
            "      #{xqfzylHxjsdz5,jdbcType=VARCHAR}, #{xqfzylHxjjczValue11,jdbcType=VARCHAR}, #{xqfzylHxjjczValue12,jdbcType=VARCHAR}, \n" +
            "      #{xqfzylHxjjczValue13,jdbcType=VARCHAR}, #{xqfzylHxjjczValue14,jdbcType=VARCHAR}, \n" +
            "      #{xqfzylHxjjczValue15,jdbcType=VARCHAR}, #{xqfzylHxjjczValue21,jdbcType=VARCHAR}, \n" +
            "      #{xqfzylHxjjczValue22,jdbcType=VARCHAR}, #{xqfzylHxjjczValue23,jdbcType=VARCHAR}, \n" +
            "      #{xqfzylHxjjczValue24,jdbcType=VARCHAR}, #{xqfzylHxjjczValue25,jdbcType=VARCHAR}, \n" +
            "      #{xqfzylHxjjczValue31,jdbcType=VARCHAR}, #{xqfzylHxjjczValue32,jdbcType=VARCHAR}, \n" +
            "      #{xqfzylHxjjczValue33,jdbcType=VARCHAR}, #{xqfzylHxjjczValue34,jdbcType=VARCHAR}, \n" +
            "      #{xqfzylHxjjczValue35,jdbcType=VARCHAR}, #{xqfzylPjzJczValue1,jdbcType=VARCHAR}, \n" +
            "      #{xqfzylPjzJczValue2,jdbcType=VARCHAR}, #{xqfzylPjzJczValue3,jdbcType=VARCHAR}, \n" +
            "      #{xqfzylPjzJczValue4,jdbcType=VARCHAR}, #{xqfzylPjzJczValue5,jdbcType=VARCHAR}, \n" +
            "      #{xqfzylCslclzValue11,jdbcType=VARCHAR}, #{xqfzylCslclzValue12,jdbcType=VARCHAR}, \n" +
            "      #{xqfzylCslclzValue13,jdbcType=VARCHAR}, #{xqfzylCslclzValue14,jdbcType=VARCHAR}, \n" +
            "      #{xqfzylCslclzValue15,jdbcType=VARCHAR}, #{xqfzylCslclzValue21,jdbcType=VARCHAR}, \n" +
            "      #{xqfzylCslclzValue22,jdbcType=VARCHAR}, #{xqfzylCslclzValue23,jdbcType=VARCHAR}, \n" +
            "      #{xqfzylCslclzValue24,jdbcType=VARCHAR}, #{xqfzylCslclzValue25,jdbcType=VARCHAR}, \n" +
            "      #{xqfzylCslclzValue31,jdbcType=VARCHAR}, #{xqfzylCslclzValue32,jdbcType=VARCHAR}, \n" +
            "      #{xqfzylCslclzValue33,jdbcType=VARCHAR}, #{xqfzylCslclzValue34,jdbcType=VARCHAR}, \n" +
            "      #{xqfzylCslclzValue35,jdbcType=VARCHAR}, #{xqfzylPjzClzValue1,jdbcType=VARCHAR}, \n" +
            "      #{xqfzylPjzClzValue2,jdbcType=VARCHAR}, #{xqfzylPjzClzValue3,jdbcType=VARCHAR}, \n" +
            "      #{xqfzylPjzClzValue4,jdbcType=VARCHAR}, #{xqfzylPjzClzValue5,jdbcType=VARCHAR}, \n" +
            "      #{xqfzylSzwcValue1,jdbcType=VARCHAR}, #{xqfzylSzwcValue2,jdbcType=VARCHAR}, #{xqfzylSzwcValue3,jdbcType=VARCHAR}, \n" +
            "      #{xqfzylSzwcValue4,jdbcType=VARCHAR}, #{xqfzylSzwcValue5,jdbcType=VARCHAR}, #{xqfzylScwcValue1,jdbcType=VARCHAR}, \n" +
            "      #{xqfzylScwcValue2,jdbcType=VARCHAR}, #{xqfzylScwcValue3,jdbcType=VARCHAR}, #{xqfzylScwcValue4,jdbcType=VARCHAR}, \n" +
            "      #{xqfzylScwcValue5,jdbcType=VARCHAR}, #{xqfzylZdyc2,jdbcType=VARCHAR}, #{xqfzylZdyc1,jdbcType=VARCHAR}, \n" +
            "      #{xqfzylResult,jdbcType=VARCHAR}, #{hqmzyHxjsdz1,jdbcType=VARCHAR}, #{hqmzyHxjsdz2,jdbcType=VARCHAR}, \n" +
            "      #{hqmzyHxjsdz3,jdbcType=VARCHAR}, #{hqmzyHxjsdz4,jdbcType=VARCHAR}, #{hqmzyHxjsdz5,jdbcType=VARCHAR}, \n" +
            "      #{hqmzyHxjjczValue11,jdbcType=VARCHAR}, #{hqmzyHxjjczValue12,jdbcType=VARCHAR}, \n" +
            "      #{hqmzyHxjjczValue13,jdbcType=VARCHAR}, #{hqmzyHxjjczValue14,jdbcType=VARCHAR}, \n" +
            "      #{hqmzyHxjjczValue15,jdbcType=VARCHAR}, #{hqmzyHxjjczValue21,jdbcType=VARCHAR}, \n" +
            "      #{hqmzyHxjjczValue22,jdbcType=VARCHAR}, #{hqmzyHxjjczValue23,jdbcType=VARCHAR}, \n" +
            "      #{hqmzyHxjjczValue24,jdbcType=VARCHAR}, #{hqmzyHxjjczValue25,jdbcType=VARCHAR}, \n" +
            "      #{hqmzyHxjjczValue31,jdbcType=VARCHAR}, #{hqmzyHxjjczValue32,jdbcType=VARCHAR}, \n" +
            "      #{hqmzyHxjjczValue33,jdbcType=VARCHAR}, #{hqmzyHxjjczValue34,jdbcType=VARCHAR}, \n" +
            "      #{hqmzyHxjjczValue35,jdbcType=VARCHAR}, #{hqmzyPjzJczValue1,jdbcType=VARCHAR}, \n" +
            "      #{hqmzyPjzJczValue2,jdbcType=VARCHAR}, #{hqmzyPjzJczValue3,jdbcType=VARCHAR}, #{hqmzyPjzJczValue4,jdbcType=VARCHAR}, \n" +
            "      #{hqmzyPjzJczValue5,jdbcType=VARCHAR}, #{hqmzyCslclzValue11,jdbcType=VARCHAR}, \n" +
            "      #{hqmzyCslclzValue12,jdbcType=VARCHAR}, #{hqmzyCslclzValue13,jdbcType=VARCHAR}, \n" +
            "      #{hqmzyCslclzValue14,jdbcType=VARCHAR}, #{hqmzyCslclzValue15,jdbcType=VARCHAR}, \n" +
            "      #{hqmzyCslclzValue21,jdbcType=VARCHAR}, #{hqmzyCslclzValue22,jdbcType=VARCHAR}, \n" +
            "      #{hqmzyCslclzValue23,jdbcType=VARCHAR}, #{hqmzyCslclzValue24,jdbcType=VARCHAR}, \n" +
            "      #{hqmzyCslclzValue25,jdbcType=VARCHAR}, #{hqmzyCslclzValue31,jdbcType=VARCHAR}, \n" +
            "      #{hqmzyCslclzValue32,jdbcType=VARCHAR}, #{hqmzyCslclzValue33,jdbcType=VARCHAR}, \n" +
            "      #{hqmzyCslclzValue34,jdbcType=VARCHAR}, #{hqmzyCslclzValue35,jdbcType=VARCHAR}, \n" +
            "      #{hqmzyPjzClzValue1,jdbcType=VARCHAR}, #{hqmzyPjzClzValue2,jdbcType=VARCHAR}, #{hqmzyPjzClzValue3,jdbcType=VARCHAR}, \n" +
            "      #{hqmzyPjzClzValue4,jdbcType=VARCHAR}, #{hqmzyPjzClzValue5,jdbcType=VARCHAR}, #{hqmzySzwcValue1,jdbcType=VARCHAR}, \n" +
            "      #{hqmzySzwcValue2,jdbcType=VARCHAR}, #{hqmzySzwcValue3,jdbcType=VARCHAR}, #{hqmzySzwcValue4,jdbcType=VARCHAR}, \n" +
            "      #{hqmzySzwcValue5,jdbcType=VARCHAR}, #{hqmzyScwcValue1,jdbcType=VARCHAR}, #{hqmzyScwcValue2,jdbcType=VARCHAR}, \n" +
            "      #{hqmzyScwcValue3,jdbcType=VARCHAR}, #{hqmzyScwcValue4,jdbcType=VARCHAR}, #{hqmzyScwcValue5,jdbcType=VARCHAR}, \n" +
            "      #{hqmzyZdyc,jdbcType=VARCHAR}, #{hqmzyResult,jdbcType=VARCHAR}, #{fwczdykg,jdbcType=VARCHAR}, \n" +
            "      #{brhlgybhgn,jdbcType=VARCHAR}, #{jygn,jdbcType=VARCHAR}, #{jysx,jdbcType=VARCHAR}, \n" +
            "      #{qdylsxxbj,jdbcType=VARCHAR}, #{bjsz,jdbcType=VARCHAR}, #{ddbj,jdbcType=VARCHAR}, \n" +
            "      #{hxplsxxbj,jdbcType=VARCHAR}, #{nbdy,jdbcType=VARCHAR}, #{qybj,jdbcType=VARCHAR}, \n" +
            "      #{yndsxxbj,jdbcType=VARCHAR}, #{wtjyfcs,jdbcType=VARCHAR}, #{fztqlsxxbj,jdbcType=VARCHAR}, \n" +
            "      #{hqmzysxxbj,jdbcType=VARCHAR}, #{tqzxbj,jdbcType=VARCHAR}, #{type,jdbcType=INTEGER}\n" +
            "      )")
    @Options(useGeneratedKeys = true, keyProperty = "hxjId", keyColumn = "hxj_id")
    void save(Hxj hxj);
@Update("update hxj\n" +
        "    set jcyq_id = #{jcyqId,jdbcType=INTEGER},\n" +
        "      eq_id = #{eqId,jdbcType=VARCHAR},\n" +
        "      tester = #{tester,jdbcType=VARCHAR},\n" +
        "      auditor = #{auditor,jdbcType=VARCHAR},\n" +
        "      shsj_time = #{shsjTime,jdbcType=TIMESTAMP},\n" +
        "      shr_jcjl = #{shrJcjl,jdbcType=VARCHAR},\n" +
        "      test_time = #{testTime,jdbcType=VARCHAR},\n" +
        "      jcjl = #{jcjl,jdbcType=VARCHAR},\n" +
        "      jcsm = #{jcsm,jdbcType=VARCHAR},\n" +
        "      bhjdzk_clz_value = #{bhjdzkClzValue,jdbcType=VARCHAR},\n" +
        "      bhjdzk_yxz = #{bhjdzkYxz,jdbcType=VARCHAR},\n" +
        "      bhjdzk_result = #{bhjdzkResult,jdbcType=VARCHAR},\n" +
        "      jyzk_clz_value = #{jyzkClzValue,jdbcType=VARCHAR},\n" +
        "      jyzk_yxz = #{jyzkYxz,jdbcType=VARCHAR},\n" +
        "      jykz_result = #{jykzResult,jdbcType=VARCHAR},\n" +
        "      ddld_zc_zx_value = #{ddldZcZxValue,jdbcType=VARCHAR},\n" +
        "      ddld_zc_fx_value = #{ddldZcFxValue,jdbcType=VARCHAR},\n" +
        "      ddld_zc_yxz = #{ddldZcYxz,jdbcType=VARCHAR},\n" +
        "      ddld_zc_result = #{ddldZcResult,jdbcType=VARCHAR},\n" +
        "      ddld_dygz_zxdl_value = #{ddldDygzZxdlValue,jdbcType=VARCHAR},\n" +
        "      ddld_dygz_fxdl_value = #{ddldDygzFxdlValue,jdbcType=VARCHAR},\n" +
        "      ddld_dygz_yxz = #{ddldDygzYxz,jdbcType=VARCHAR},\n" +
        "      ddld_dygz_result = #{ddldDygzResult,jdbcType=VARCHAR},\n" +
        "      wkld_zc_zx_value = #{wkldZcZxValue,jdbcType=VARCHAR},\n" +
        "      wkld_zc_fx_value = #{wkldZcFxValue,jdbcType=VARCHAR},\n" +
        "      wkld_zc_yxz = #{wkldZcYxz,jdbcType=VARCHAR},\n" +
        "      wkld_zc_result = #{wkldZcResult,jdbcType=VARCHAR},\n" +
        "      wkld_dy_zxdl_value1 = #{wkldDyZxdlValue1,jdbcType=VARCHAR},\n" +
        "      wkld_dy_zxdd_value = #{wkldDyZxddValue,jdbcType=VARCHAR},\n" +
        "      wkld_dy_zxdl_value2 = #{wkldDyZxdlValue2,jdbcType=VARCHAR},\n" +
        "      wkld_dy_fxdd_value = #{wkldDyFxddValue,jdbcType=VARCHAR},\n" +
        "      wkld_dy_yx = #{wkldDyYx,jdbcType=VARCHAR},\n" +
        "      wkld_dy_result = #{wkldDyResult,jdbcType=VARCHAR},\n" +
        "      cql_hxjsdz1 = #{cqlHxjsdz1,jdbcType=VARCHAR},\n" +
        "      cql_hxjsdz2 = #{cqlHxjsdz2,jdbcType=VARCHAR},\n" +
        "      cql_hxjsdz3 = #{cqlHxjsdz3,jdbcType=VARCHAR},\n" +
        "      cql_hxjsdz4 = #{cqlHxjsdz4,jdbcType=VARCHAR},\n" +
        "      cql_hxjsdz5 = #{cqlHxjsdz5,jdbcType=VARCHAR},\n" +
        "      cql_hxjjcz_value11 = #{cqlHxjjczValue11,jdbcType=VARCHAR},\n" +
        "      cql_hxjjcz_value12 = #{cqlHxjjczValue12,jdbcType=VARCHAR},\n" +
        "      cql_hxjjcz_value13 = #{cqlHxjjczValue13,jdbcType=VARCHAR},\n" +
        "      cql_hxjjcz_value14 = #{cqlHxjjczValue14,jdbcType=VARCHAR},\n" +
        "      cql_hxjjcz_value15 = #{cqlHxjjczValue15,jdbcType=VARCHAR},\n" +
        "      cql_hxjjcz_value21 = #{cqlHxjjczValue21,jdbcType=VARCHAR},\n" +
        "      cql_hxjjcz_value22 = #{cqlHxjjczValue22,jdbcType=VARCHAR},\n" +
        "      cql_hxjjcz_value23 = #{cqlHxjjczValue23,jdbcType=VARCHAR},\n" +
        "      cql_hxjjcz_value24 = #{cqlHxjjczValue24,jdbcType=VARCHAR},\n" +
        "      cql_hxjjcz_value25 = #{cqlHxjjczValue25,jdbcType=VARCHAR},\n" +
        "      cql_hxjjcz_value31 = #{cqlHxjjczValue31,jdbcType=VARCHAR},\n" +
        "      cql_hxjjcz_value32 = #{cqlHxjjczValue32,jdbcType=VARCHAR},\n" +
        "      cql_hxjjcz_value33 = #{cqlHxjjczValue33,jdbcType=VARCHAR},\n" +
        "      cql_hxjjcz_value34 = #{cqlHxjjczValue34,jdbcType=VARCHAR},\n" +
        "      cql_hxjjcz_value35 = #{cqlHxjjczValue35,jdbcType=VARCHAR},\n" +
        "      cql_pjz_jcz_value1 = #{cqlPjzJczValue1,jdbcType=VARCHAR},\n" +
        "      cql_pjz_jcz_value2 = #{cqlPjzJczValue2,jdbcType=VARCHAR},\n" +
        "      cql_pjz_jcz_value3 = #{cqlPjzJczValue3,jdbcType=VARCHAR},\n" +
        "      cql_pjz_jcz_value4 = #{cqlPjzJczValue4,jdbcType=VARCHAR},\n" +
        "      cql_pjz_jcz_value5 = #{cqlPjzJczValue5,jdbcType=VARCHAR},\n" +
        "      cql_cslclz_value11 = #{cqlCslclzValue11,jdbcType=VARCHAR},\n" +
        "      cql_cslclz_value12 = #{cqlCslclzValue12,jdbcType=VARCHAR},\n" +
        "      cql_cslclz_value13 = #{cqlCslclzValue13,jdbcType=VARCHAR},\n" +
        "      cql_cslclz_value14 = #{cqlCslclzValue14,jdbcType=VARCHAR},\n" +
        "      cql_cslclz_value15 = #{cqlCslclzValue15,jdbcType=VARCHAR},\n" +
        "      cql_cslclz_value21 = #{cqlCslclzValue21,jdbcType=VARCHAR},\n" +
        "      cql_cslclz_value22 = #{cqlCslclzValue22,jdbcType=VARCHAR},\n" +
        "      cql_cslclz_value23 = #{cqlCslclzValue23,jdbcType=VARCHAR},\n" +
        "      cql_cslclz_value24 = #{cqlCslclzValue24,jdbcType=VARCHAR},\n" +
        "      cql_cslclz_value25 = #{cqlCslclzValue25,jdbcType=VARCHAR},\n" +
        "      cql_cslclz_value31 = #{cqlCslclzValue31,jdbcType=VARCHAR},\n" +
        "      cql_cslclz_value32 = #{cqlCslclzValue32,jdbcType=VARCHAR},\n" +
        "      cql_cslclz_value33 = #{cqlCslclzValue33,jdbcType=VARCHAR},\n" +
        "      cql_cslclz_value34 = #{cqlCslclzValue34,jdbcType=VARCHAR},\n" +
        "      cql_cslclz_value35 = #{cqlCslclzValue35,jdbcType=VARCHAR},\n" +
        "      cql_pjz_clz_value1 = #{cqlPjzClzValue1,jdbcType=VARCHAR},\n" +
        "      cql_pjz_clz_value2 = #{cqlPjzClzValue2,jdbcType=VARCHAR},\n" +
        "      cql_pjz_clz_value3 = #{cqlPjzClzValue3,jdbcType=VARCHAR},\n" +
        "      cql_pjz_clz_value4 = #{cqlPjzClzValue4,jdbcType=VARCHAR},\n" +
        "      cql_pjz_clz_value5 = #{cqlPjzClzValue5,jdbcType=VARCHAR},\n" +
        "      cql_szwc_value1 = #{cqlSzwcValue1,jdbcType=VARCHAR},\n" +
        "      cql_szwc_value2 = #{cqlSzwcValue2,jdbcType=VARCHAR},\n" +
        "      cql_szwc_value3 = #{cqlSzwcValue3,jdbcType=VARCHAR},\n" +
        "      cql_szwc_value4 = #{cqlSzwcValue4,jdbcType=VARCHAR},\n" +
        "      cql_szwc_value5 = #{cqlSzwcValue5,jdbcType=VARCHAR},\n" +
        "      cql_scwc_value1 = #{cqlScwcValue1,jdbcType=VARCHAR},\n" +
        "      cql_scwc_value2 = #{cqlScwcValue2,jdbcType=VARCHAR},\n" +
        "      cql_scwc_value3 = #{cqlScwcValue3,jdbcType=VARCHAR},\n" +
        "      cql_scwc_value4 = #{cqlScwcValue4,jdbcType=VARCHAR},\n" +
        "      cql_scwc_value5 = #{cqlScwcValue5,jdbcType=VARCHAR},\n" +
        "      cql_zdyc = #{cqlZdyc,jdbcType=VARCHAR},\n" +
        "      cql_result = #{cqlResult,jdbcType=VARCHAR},\n" +
        "      qztqpl_hxjsdz1 = #{qztqplHxjsdz1,jdbcType=VARCHAR},\n" +
        "      qztqpl_hxjsdz2 = #{qztqplHxjsdz2,jdbcType=VARCHAR},\n" +
        "      qztqpl_hxjsdz3 = #{qztqplHxjsdz3,jdbcType=VARCHAR},\n" +
        "      qztqpl_hxjsdz4 = #{qztqplHxjsdz4,jdbcType=VARCHAR},\n" +
        "      qztqpl_hxjsdz5 = #{qztqplHxjsdz5,jdbcType=VARCHAR},\n" +
        "      qztqpl_hxjjcz_value11 = #{qztqplHxjjczValue11,jdbcType=VARCHAR},\n" +
        "      qztqpl_hxjjcz_value12 = #{qztqplHxjjczValue12,jdbcType=VARCHAR},\n" +
        "      qztqpl_hxjjcz_value13 = #{qztqplHxjjczValue13,jdbcType=VARCHAR},\n" +
        "      qztqpl_hxjjcz_value14 = #{qztqplHxjjczValue14,jdbcType=VARCHAR},\n" +
        "      qztqpl_hxjjcz_value15 = #{qztqplHxjjczValue15,jdbcType=VARCHAR},\n" +
        "      qztqpl_hxjjcz_value21 = #{qztqplHxjjczValue21,jdbcType=VARCHAR},\n" +
        "      qztqpl_hxjjcz_value22 = #{qztqplHxjjczValue22,jdbcType=VARCHAR},\n" +
        "      qztqpl_hxjjcz_value23 = #{qztqplHxjjczValue23,jdbcType=VARCHAR},\n" +
        "      qztqpl_hxjjcz_value24 = #{qztqplHxjjczValue24,jdbcType=VARCHAR},\n" +
        "      qztqpl_hxjjcz_value25 = #{qztqplHxjjczValue25,jdbcType=VARCHAR},\n" +
        "      qztqpl_hxjjcz_value31 = #{qztqplHxjjczValue31,jdbcType=VARCHAR},\n" +
        "      qztqpl_hxjjcz_value32 = #{qztqplHxjjczValue32,jdbcType=VARCHAR},\n" +
        "      qztqpl_hxjjcz_value33 = #{qztqplHxjjczValue33,jdbcType=VARCHAR},\n" +
        "      qztqpl_hxjjcz_value34 = #{qztqplHxjjczValue34,jdbcType=VARCHAR},\n" +
        "      qztqpl_hxjjcz_value35 = #{qztqplHxjjczValue35,jdbcType=VARCHAR},\n" +
        "      qztqpl_pjz_jcz_value1 = #{qztqplPjzJczValue1,jdbcType=VARCHAR},\n" +
        "      qztqpl_pjz_jcz_value2 = #{qztqplPjzJczValue2,jdbcType=VARCHAR},\n" +
        "      qztqpl_pjz_jcz_value3 = #{qztqplPjzJczValue3,jdbcType=VARCHAR},\n" +
        "      qztqpl_pjz_jcz_value4 = #{qztqplPjzJczValue4,jdbcType=VARCHAR},\n" +
        "      qztqpl_pjz_jcz_value5 = #{qztqplPjzJczValue5,jdbcType=VARCHAR},\n" +
        "      qztqpl_csyclz_value11 = #{qztqplCsyclzValue11,jdbcType=VARCHAR},\n" +
        "      qztqpl_csyclz_value12 = #{qztqplCsyclzValue12,jdbcType=VARCHAR},\n" +
        "      qztqpl_csyclz_value13 = #{qztqplCsyclzValue13,jdbcType=VARCHAR},\n" +
        "      qztqpl_csyclz_value14 = #{qztqplCsyclzValue14,jdbcType=VARCHAR},\n" +
        "      qztqpl_csyclz_value15 = #{qztqplCsyclzValue15,jdbcType=VARCHAR},\n" +
        "      qztqpl_csyclz_value21 = #{qztqplCsyclzValue21,jdbcType=VARCHAR},\n" +
        "      qztqpl_csyclz_value22 = #{qztqplCsyclzValue22,jdbcType=VARCHAR},\n" +
        "      qztqpl_csyclz_value23 = #{qztqplCsyclzValue23,jdbcType=VARCHAR},\n" +
        "      qztqpl_csyclz_value24 = #{qztqplCsyclzValue24,jdbcType=VARCHAR},\n" +
        "      qztqpl_csyclz_value25 = #{qztqplCsyclzValue25,jdbcType=VARCHAR},\n" +
        "      qztqpl_csyclz_value31 = #{qztqplCsyclzValue31,jdbcType=VARCHAR},\n" +
        "      qztqpl_csyclz_value32 = #{qztqplCsyclzValue32,jdbcType=VARCHAR},\n" +
        "      qztqpl_csyclz_value33 = #{qztqplCsyclzValue33,jdbcType=VARCHAR},\n" +
        "      qztqpl_csyclz_value34 = #{qztqplCsyclzValue34,jdbcType=VARCHAR},\n" +
        "      qztqpl_csyclz_value35 = #{qztqplCsyclzValue35,jdbcType=VARCHAR},\n" +
        "      qztqpl_pjz_clz_value1 = #{qztqplPjzClzValue1,jdbcType=VARCHAR},\n" +
        "      qztqpl_pjz_clz_value2 = #{qztqplPjzClzValue2,jdbcType=VARCHAR},\n" +
        "      qztqpl_pjz_clz_value3 = #{qztqplPjzClzValue3,jdbcType=VARCHAR},\n" +
        "      qztqpl_pjz_clz_value4 = #{qztqplPjzClzValue4,jdbcType=VARCHAR},\n" +
        "      qztqpl_pjz_clz_value5 = #{qztqplPjzClzValue5,jdbcType=VARCHAR},\n" +
        "      qztqpl_szwc_value1 = #{qztqplSzwcValue1,jdbcType=VARCHAR},\n" +
        "      qztqpl_szwc_value2 = #{qztqplSzwcValue2,jdbcType=VARCHAR},\n" +
        "      qztqpl_szwc_value3 = #{qztqplSzwcValue3,jdbcType=VARCHAR},\n" +
        "      qztqpl_szwc_value4 = #{qztqplSzwcValue4,jdbcType=VARCHAR},\n" +
        "      qztqpl_szwc_value5 = #{qztqplSzwcValue5,jdbcType=VARCHAR},\n" +
        "      qztqpl_scwc_value1 = #{qztqplScwcValue1,jdbcType=VARCHAR},\n" +
        "      qztqpl_scwc_value2 = #{qztqplScwcValue2,jdbcType=VARCHAR},\n" +
        "      qztqpl_scwc_value3 = #{qztqplScwcValue3,jdbcType=VARCHAR},\n" +
        "      qztqpl_scwc_value4 = #{qztqplScwcValue4,jdbcType=VARCHAR},\n" +
        "      qztqpl_scwc_value5 = #{qztqplScwcValue5,jdbcType=VARCHAR},\n" +
        "      qztqpl_zdyc = #{qztqplZdyc,jdbcType=VARCHAR},\n" +
        "      qztqpl_result = #{qztqplResult,jdbcType=VARCHAR},\n" +
        "      xrynd_hxjsdz1 = #{xryndHxjsdz1,jdbcType=VARCHAR},\n" +
        "      xrynd_hxjsdz2 = #{xryndHxjsdz2,jdbcType=VARCHAR},\n" +
        "      xrynd_hxjsdz3 = #{xryndHxjsdz3,jdbcType=VARCHAR},\n" +
        "      xrynd_hxjsdz4 = #{xryndHxjsdz4,jdbcType=VARCHAR},\n" +
        "      xrynd_hxjsdz5 = #{xryndHxjsdz5,jdbcType=VARCHAR},\n" +
        "      xrynd_hxjjcz_value11 = #{xryndHxjjczValue11,jdbcType=VARCHAR},\n" +
        "      xrynd_hxjjcz_value12 = #{xryndHxjjczValue12,jdbcType=VARCHAR},\n" +
        "      xrynd_hxjjcz_value13 = #{xryndHxjjczValue13,jdbcType=VARCHAR},\n" +
        "      xrynd_hxjjcz_value14 = #{xryndHxjjczValue14,jdbcType=VARCHAR},\n" +
        "      xrynd_hxjjcz_value15 = #{xryndHxjjczValue15,jdbcType=VARCHAR},\n" +
        "      xrynd_hxjjcz_value21 = #{xryndHxjjczValue21,jdbcType=VARCHAR},\n" +
        "      xrynd_hxjjcz_value22 = #{xryndHxjjczValue22,jdbcType=VARCHAR},\n" +
        "      xrynd_hxjjcz_value23 = #{xryndHxjjczValue23,jdbcType=VARCHAR},\n" +
        "      xrynd_hxjjcz_value24 = #{xryndHxjjczValue24,jdbcType=VARCHAR},\n" +
        "      xrynd_hxjjcz_value25 = #{xryndHxjjczValue25,jdbcType=VARCHAR},\n" +
        "      xrynd_hxjjcz_value31 = #{xryndHxjjczValue31,jdbcType=VARCHAR},\n" +
        "      xrynd_hxjjcz_value32 = #{xryndHxjjczValue32,jdbcType=VARCHAR},\n" +
        "      xrynd_hxjjcz_value33 = #{xryndHxjjczValue33,jdbcType=VARCHAR},\n" +
        "      xrynd_hxjjcz_value34 = #{xryndHxjjczValue34,jdbcType=VARCHAR},\n" +
        "      xrynd_hxjjcz_value35 = #{xryndHxjjczValue35,jdbcType=VARCHAR},\n" +
        "      xrynd_pjz_jcz_value1 = #{xryndPjzJczValue1,jdbcType=VARCHAR},\n" +
        "      xrynd_pjz_jcz_value2 = #{xryndPjzJczValue2,jdbcType=VARCHAR},\n" +
        "      xrynd_pjz_jcz_value3 = #{xryndPjzJczValue3,jdbcType=VARCHAR},\n" +
        "      xrynd_pjz_jcz_value4 = #{xryndPjzJczValue4,jdbcType=VARCHAR},\n" +
        "      xrynd_pjz_jcz_value5 = #{xryndPjzJczValue5,jdbcType=VARCHAR},\n" +
        "      xrynd_cslclz_value11 = #{xryndCslclzValue11,jdbcType=VARCHAR},\n" +
        "      xrynd_cslclz_value12 = #{xryndCslclzValue12,jdbcType=VARCHAR},\n" +
        "      xrynd_cslclz_value13 = #{xryndCslclzValue13,jdbcType=VARCHAR},\n" +
        "      xrynd_cslclz_value14 = #{xryndCslclzValue14,jdbcType=VARCHAR},\n" +
        "      xrynd_cslclz_value15 = #{xryndCslclzValue15,jdbcType=VARCHAR},\n" +
        "      xrynd_cslclz_value21 = #{xryndCslclzValue21,jdbcType=VARCHAR},\n" +
        "      xrynd_cslclz_value22 = #{xryndCslclzValue22,jdbcType=VARCHAR},\n" +
        "      xrynd_cslclz_value23 = #{xryndCslclzValue23,jdbcType=VARCHAR},\n" +
        "      xrynd_cslclz_value24 = #{xryndCslclzValue24,jdbcType=VARCHAR},\n" +
        "      xrynd_cslclz_value25 = #{xryndCslclzValue25,jdbcType=VARCHAR},\n" +
        "      xrynd_cslclz_value31 = #{xryndCslclzValue31,jdbcType=VARCHAR},\n" +
        "      xrynd_cslclz_value32 = #{xryndCslclzValue32,jdbcType=VARCHAR},\n" +
        "      xrynd_cslclz_value33 = #{xryndCslclzValue33,jdbcType=VARCHAR},\n" +
        "      xrynd_cslclz_value34 = #{xryndCslclzValue34,jdbcType=VARCHAR},\n" +
        "      xrynd_cslclz_value35 = #{xryndCslclzValue35,jdbcType=VARCHAR},\n" +
        "      xrynd_pjz_clz_value1 = #{xryndPjzClzValue1,jdbcType=VARCHAR},\n" +
        "      xrynd_pjz_clz_value2 = #{xryndPjzClzValue2,jdbcType=VARCHAR},\n" +
        "      xrynd_pjz_clz_value3 = #{xryndPjzClzValue3,jdbcType=VARCHAR},\n" +
        "      xrynd_pjz_clz_value4 = #{xryndPjzClzValue4,jdbcType=VARCHAR},\n" +
        "      xrynd_pjz_clz_value5 = #{xryndPjzClzValue5,jdbcType=VARCHAR},\n" +
        "      xrynd_szwc_value1 = #{xryndSzwcValue1,jdbcType=VARCHAR},\n" +
        "      xrynd_szwc_value2 = #{xryndSzwcValue2,jdbcType=VARCHAR},\n" +
        "      xrynd_szwc_value3 = #{xryndSzwcValue3,jdbcType=VARCHAR},\n" +
        "      xrynd_szwc_value4 = #{xryndSzwcValue4,jdbcType=VARCHAR},\n" +
        "      xrynd_szwc_value5 = #{xryndSzwcValue5,jdbcType=VARCHAR},\n" +
        "      xrynd_scwc_value1 = #{xryndScwcValue1,jdbcType=VARCHAR},\n" +
        "      xrynd_scwc_value2 = #{xryndScwcValue2,jdbcType=VARCHAR},\n" +
        "      xrynd_scwc_value3 = #{xryndScwcValue3,jdbcType=VARCHAR},\n" +
        "      xrynd_scwc_value4 = #{xryndScwcValue4,jdbcType=VARCHAR},\n" +
        "      xrynd_scwc_value5 = #{xryndScwcValue5,jdbcType=VARCHAR},\n" +
        "      xrynd_zdyc = #{xryndZdyc,jdbcType=VARCHAR},\n" +
        "      xrynd_result = #{xryndResult,jdbcType=VARCHAR},\n" +
        "      xqfzyl_hxjsdz1 = #{xqfzylHxjsdz1,jdbcType=VARCHAR},\n" +
        "      xqfzyl_hxjsdz2 = #{xqfzylHxjsdz2,jdbcType=VARCHAR},\n" +
        "      xqfzyl_hxjsdz3 = #{xqfzylHxjsdz3,jdbcType=VARCHAR},\n" +
        "      xqfzyl_hxjsdz4 = #{xqfzylHxjsdz4,jdbcType=VARCHAR},\n" +
        "      xqfzyl_hxjsdz5 = #{xqfzylHxjsdz5,jdbcType=VARCHAR},\n" +
        "      xqfzyl_hxjjcz_value11 = #{xqfzylHxjjczValue11,jdbcType=VARCHAR},\n" +
        "      xqfzyl_hxjjcz_value12 = #{xqfzylHxjjczValue12,jdbcType=VARCHAR},\n" +
        "      xqfzyl_hxjjcz_value13 = #{xqfzylHxjjczValue13,jdbcType=VARCHAR},\n" +
        "      xqfzyl_hxjjcz_value14 = #{xqfzylHxjjczValue14,jdbcType=VARCHAR},\n" +
        "      xqfzyl_hxjjcz_value15 = #{xqfzylHxjjczValue15,jdbcType=VARCHAR},\n" +
        "      xqfzyl_hxjjcz_value21 = #{xqfzylHxjjczValue21,jdbcType=VARCHAR},\n" +
        "      xqfzyl_hxjjcz_value22 = #{xqfzylHxjjczValue22,jdbcType=VARCHAR},\n" +
        "      xqfzyl_hxjjcz_value23 = #{xqfzylHxjjczValue23,jdbcType=VARCHAR},\n" +
        "      xqfzyl_hxjjcz_value24 = #{xqfzylHxjjczValue24,jdbcType=VARCHAR},\n" +
        "      xqfzyl_hxjjcz_value25 = #{xqfzylHxjjczValue25,jdbcType=VARCHAR},\n" +
        "      xqfzyl_hxjjcz_value31 = #{xqfzylHxjjczValue31,jdbcType=VARCHAR},\n" +
        "      xqfzyl_hxjjcz_value32 = #{xqfzylHxjjczValue32,jdbcType=VARCHAR},\n" +
        "      xqfzyl_hxjjcz_value33 = #{xqfzylHxjjczValue33,jdbcType=VARCHAR},\n" +
        "      xqfzyl_hxjjcz_value34 = #{xqfzylHxjjczValue34,jdbcType=VARCHAR},\n" +
        "      xqfzyl_hxjjcz_value35 = #{xqfzylHxjjczValue35,jdbcType=VARCHAR},\n" +
        "      xqfzyl_pjz_jcz_value1 = #{xqfzylPjzJczValue1,jdbcType=VARCHAR},\n" +
        "      xqfzyl_pjz_jcz_value2 = #{xqfzylPjzJczValue2,jdbcType=VARCHAR},\n" +
        "      xqfzyl_pjz_jcz_value3 = #{xqfzylPjzJczValue3,jdbcType=VARCHAR},\n" +
        "      xqfzyl_pjz_jcz_value4 = #{xqfzylPjzJczValue4,jdbcType=VARCHAR},\n" +
        "      xqfzyl_pjz_jcz_value5 = #{xqfzylPjzJczValue5,jdbcType=VARCHAR},\n" +
        "      xqfzyl_cslclz_value11 = #{xqfzylCslclzValue11,jdbcType=VARCHAR},\n" +
        "      xqfzyl_cslclz_value12 = #{xqfzylCslclzValue12,jdbcType=VARCHAR},\n" +
        "      xqfzyl_cslclz_value13 = #{xqfzylCslclzValue13,jdbcType=VARCHAR},\n" +
        "      xqfzyl_cslclz_value14 = #{xqfzylCslclzValue14,jdbcType=VARCHAR},\n" +
        "      xqfzyl_cslclz_value15 = #{xqfzylCslclzValue15,jdbcType=VARCHAR},\n" +
        "      xqfzyl_cslclz_value21 = #{xqfzylCslclzValue21,jdbcType=VARCHAR},\n" +
        "      xqfzyl_cslclz_value22 = #{xqfzylCslclzValue22,jdbcType=VARCHAR},\n" +
        "      xqfzyl_cslclz_value23 = #{xqfzylCslclzValue23,jdbcType=VARCHAR},\n" +
        "      xqfzyl_cslclz_value24 = #{xqfzylCslclzValue24,jdbcType=VARCHAR},\n" +
        "      xqfzyl_cslclz_value25 = #{xqfzylCslclzValue25,jdbcType=VARCHAR},\n" +
        "      xqfzyl_cslclz_value31 = #{xqfzylCslclzValue31,jdbcType=VARCHAR},\n" +
        "      xqfzyl_cslclz_value32 = #{xqfzylCslclzValue32,jdbcType=VARCHAR},\n" +
        "      xqfzyl_cslclz_value33 = #{xqfzylCslclzValue33,jdbcType=VARCHAR},\n" +
        "      xqfzyl_cslclz_value34 = #{xqfzylCslclzValue34,jdbcType=VARCHAR},\n" +
        "      xqfzyl_cslclz_value35 = #{xqfzylCslclzValue35,jdbcType=VARCHAR},\n" +
        "      xqfzyl_pjz_clz_value1 = #{xqfzylPjzClzValue1,jdbcType=VARCHAR},\n" +
        "      xqfzyl_pjz_clz_value2 = #{xqfzylPjzClzValue2,jdbcType=VARCHAR},\n" +
        "      xqfzyl_pjz_clz_value3 = #{xqfzylPjzClzValue3,jdbcType=VARCHAR},\n" +
        "      xqfzyl_pjz_clz_value4 = #{xqfzylPjzClzValue4,jdbcType=VARCHAR},\n" +
        "      xqfzyl_pjz_clz_value5 = #{xqfzylPjzClzValue5,jdbcType=VARCHAR},\n" +
        "      xqfzyl_szwc_value1 = #{xqfzylSzwcValue1,jdbcType=VARCHAR},\n" +
        "      xqfzyl_szwc_value2 = #{xqfzylSzwcValue2,jdbcType=VARCHAR},\n" +
        "      xqfzyl_szwc_value3 = #{xqfzylSzwcValue3,jdbcType=VARCHAR},\n" +
        "      xqfzyl_szwc_value4 = #{xqfzylSzwcValue4,jdbcType=VARCHAR},\n" +
        "      xqfzyl_szwc_value5 = #{xqfzylSzwcValue5,jdbcType=VARCHAR},\n" +
        "      xqfzyl_scwc_value1 = #{xqfzylScwcValue1,jdbcType=VARCHAR},\n" +
        "      xqfzyl_scwc_value2 = #{xqfzylScwcValue2,jdbcType=VARCHAR},\n" +
        "      xqfzyl_scwc_value3 = #{xqfzylScwcValue3,jdbcType=VARCHAR},\n" +
        "      xqfzyl_scwc_value4 = #{xqfzylScwcValue4,jdbcType=VARCHAR},\n" +
        "      xqfzyl_scwc_value5 = #{xqfzylScwcValue5,jdbcType=VARCHAR},\n" +
        "      xqfzyl_zdyc = #{xqfzylZdyc,jdbcType=VARCHAR},\n" +
        "      xqfzyl_result = #{xqfzylResult,jdbcType=VARCHAR},\n" +
        "      hqmzy_hxjsdz1 = #{hqmzyHxjsdz1,jdbcType=VARCHAR},\n" +
        "      hqmzy_hxjsdz2 = #{hqmzyHxjsdz2,jdbcType=VARCHAR},\n" +
        "      hqmzy_hxjsdz3 = #{hqmzyHxjsdz3,jdbcType=VARCHAR},\n" +
        "      hqmzy_hxjsdz4 = #{hqmzyHxjsdz4,jdbcType=VARCHAR},\n" +
        "      hqmzy_hxjsdz5 = #{hqmzyHxjsdz5,jdbcType=VARCHAR},\n" +
        "      hqmzy_hxjjcz_value11 = #{hqmzyHxjjczValue11,jdbcType=VARCHAR},\n" +
        "      hqmzy_hxjjcz_value12 = #{hqmzyHxjjczValue12,jdbcType=VARCHAR},\n" +
        "      hqmzy_hxjjcz_value13 = #{hqmzyHxjjczValue13,jdbcType=VARCHAR},\n" +
        "      hqmzy_hxjjcz_value14 = #{hqmzyHxjjczValue14,jdbcType=VARCHAR},\n" +
        "      hqmzy_hxjjcz_value15 = #{hqmzyHxjjczValue15,jdbcType=VARCHAR},\n" +
        "      hqmzy_hxjjcz_value21 = #{hqmzyHxjjczValue21,jdbcType=VARCHAR},\n" +
        "      hqmzy_hxjjcz_value22 = #{hqmzyHxjjczValue22,jdbcType=VARCHAR},\n" +
        "      hqmzy_hxjjcz_value23 = #{hqmzyHxjjczValue23,jdbcType=VARCHAR},\n" +
        "      hqmzy_hxjjcz_value24 = #{hqmzyHxjjczValue24,jdbcType=VARCHAR},\n" +
        "      hqmzy_hxjjcz_value25 = #{hqmzyHxjjczValue25,jdbcType=VARCHAR},\n" +
        "      hqmzy_hxjjcz_value31 = #{hqmzyHxjjczValue31,jdbcType=VARCHAR},\n" +
        "      hqmzy_hxjjcz_value32 = #{hqmzyHxjjczValue32,jdbcType=VARCHAR},\n" +
        "      hqmzy_hxjjcz_value33 = #{hqmzyHxjjczValue33,jdbcType=VARCHAR},\n" +
        "      hqmzy_hxjjcz_value34 = #{hqmzyHxjjczValue34,jdbcType=VARCHAR},\n" +
        "      hqmzy_hxjjcz_value35 = #{hqmzyHxjjczValue35,jdbcType=VARCHAR},\n" +
        "      hqmzy_pjz_jcz_value1 = #{hqmzyPjzJczValue1,jdbcType=VARCHAR},\n" +
        "      hqmzy_pjz_jcz_value2 = #{hqmzyPjzJczValue2,jdbcType=VARCHAR},\n" +
        "      hqmzy_pjz_jcz_value3 = #{hqmzyPjzJczValue3,jdbcType=VARCHAR},\n" +
        "      hqmzy_pjz_jcz_value4 = #{hqmzyPjzJczValue4,jdbcType=VARCHAR},\n" +
        "      hqmzy_pjz_jcz_value5 = #{hqmzyPjzJczValue5,jdbcType=VARCHAR},\n" +
        "      hqmzy_cslclz_value11 = #{hqmzyCslclzValue11,jdbcType=VARCHAR},\n" +
        "      hqmzy_cslclz_value12 = #{hqmzyCslclzValue12,jdbcType=VARCHAR},\n" +
        "      hqmzy_cslclz_value13 = #{hqmzyCslclzValue13,jdbcType=VARCHAR},\n" +
        "      hqmzy_cslclz_value14 = #{hqmzyCslclzValue14,jdbcType=VARCHAR},\n" +
        "      hqmzy_cslclz_value15 = #{hqmzyCslclzValue15,jdbcType=VARCHAR},\n" +
        "      hqmzy_cslclz_value21 = #{hqmzyCslclzValue21,jdbcType=VARCHAR},\n" +
        "      hqmzy_cslclz_value22 = #{hqmzyCslclzValue22,jdbcType=VARCHAR},\n" +
        "      hqmzy_cslclz_value23 = #{hqmzyCslclzValue23,jdbcType=VARCHAR},\n" +
        "      hqmzy_cslclz_value24 = #{hqmzyCslclzValue24,jdbcType=VARCHAR},\n" +
        "      hqmzy_cslclz_value25 = #{hqmzyCslclzValue25,jdbcType=VARCHAR},\n" +
        "      hqmzy_cslclz_value31 = #{hqmzyCslclzValue31,jdbcType=VARCHAR},\n" +
        "      hqmzy_cslclz_value32 = #{hqmzyCslclzValue32,jdbcType=VARCHAR},\n" +
        "      hqmzy_cslclz_value33 = #{hqmzyCslclzValue33,jdbcType=VARCHAR},\n" +
        "      hqmzy_cslclz_value34 = #{hqmzyCslclzValue34,jdbcType=VARCHAR},\n" +
        "      hqmzy_cslclz_value35 = #{hqmzyCslclzValue35,jdbcType=VARCHAR},\n" +
        "      hqmzy_pjz_clz_value1 = #{hqmzyPjzClzValue1,jdbcType=VARCHAR},\n" +
        "      hqmzy_pjz_clz_value2 = #{hqmzyPjzClzValue2,jdbcType=VARCHAR},\n" +
        "      hqmzy_pjz_clz_value3 = #{hqmzyPjzClzValue3,jdbcType=VARCHAR},\n" +
        "      hqmzy_pjz_clz_value4 = #{hqmzyPjzClzValue4,jdbcType=VARCHAR},\n" +
        "      hqmzy_pjz_clz_value5 = #{hqmzyPjzClzValue5,jdbcType=VARCHAR},\n" +
        "      hqmzy_szwc_value1 = #{hqmzySzwcValue1,jdbcType=VARCHAR},\n" +
        "      hqmzy_szwc_value2 = #{hqmzySzwcValue2,jdbcType=VARCHAR},\n" +
        "      hqmzy_szwc_value3 = #{hqmzySzwcValue3,jdbcType=VARCHAR},\n" +
        "      hqmzy_szwc_value4 = #{hqmzySzwcValue4,jdbcType=VARCHAR},\n" +
        "      hqmzy_szwc_value5 = #{hqmzySzwcValue5,jdbcType=VARCHAR},\n" +
        "      hqmzy_scwc_value1 = #{hqmzyScwcValue1,jdbcType=VARCHAR},\n" +
        "      hqmzy_scwc_value2 = #{hqmzyScwcValue2,jdbcType=VARCHAR},\n" +
        "      hqmzy_scwc_value3 = #{hqmzyScwcValue3,jdbcType=VARCHAR},\n" +
        "      hqmzy_scwc_value4 = #{hqmzyScwcValue4,jdbcType=VARCHAR},\n" +
        "      hqmzy_scwc_value5 = #{hqmzyScwcValue5,jdbcType=VARCHAR},\n" +
        "      hqmzy_zdyc1 = #{hqmzyZdyc1,jdbcType=VARCHAR},\n" +
        "      hqmzy_zdyc2 = #{hqmzyZdyc2,jdbcType=VARCHAR},\n" +
        "      hqmzy_result = #{hqmzyResult,jdbcType=VARCHAR},\n" +
        "      fwczdykg = #{fwczdykg,jdbcType=VARCHAR},\n" +
        "      brhlgybhgn = #{brhlgybhgn,jdbcType=VARCHAR},\n" +
        "      jygn = #{jygn,jdbcType=VARCHAR},\n" +
        "      jysx = #{jysx,jdbcType=VARCHAR},\n" +
        "      qdylsxxbj = #{qdylsxxbj,jdbcType=VARCHAR},\n" +
        "      bjsz = #{bjsz,jdbcType=VARCHAR},\n" +
        "      ddbj = #{ddbj,jdbcType=VARCHAR},\n" +
        "      hxplsxxbj = #{hxplsxxbj,jdbcType=VARCHAR},\n" +
        "      nbdy = #{nbdy,jdbcType=VARCHAR},\n" +
        "      qybj = #{qybj,jdbcType=VARCHAR},\n" +
        "      yndsxxbj = #{yndsxxbj,jdbcType=VARCHAR},\n" +
        "      wtjyfcs = #{wtjyfcs,jdbcType=VARCHAR},\n" +
        "      fztqlsxxbj = #{fztqlsxxbj,jdbcType=VARCHAR},\n" +
        "      hqmzysxxbj = #{hqmzysxxbj,jdbcType=VARCHAR},\n" +
        "      tqzxbj = #{tqzxbj,jdbcType=VARCHAR},\n" +
        "      type = #{type,jdbcType=INTEGER}\n" +
        "    where hxj_id = #{hxjId,jdbcType=INTEGER}")
    void updateHxj(Hxj hxj);
    //根据电气检测设备id查询设备检测表
    @Select("select * from hxj  order by hxj_id desc limit 1 where eq_id = #{eqId}")
    public Hxj findHxj(@Param("eqId") String eqId);

    /*//以id排序，查询最后一条记录
    @Select("select * from dqjc order by dqjcid desc limit 1")
    Dqjc find();
*/

    //根据设备Id,检测仪器Id以及状态查询电器表查询最后一条记录
    @Select("select hxj.* from hxj where hxj.eq_id=#{eqId} and hxj.jcyq_id=#{jcyqId} order by test_time desc, hxj_id desc limit 1" )
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
    @Select("select * from hxj where hxj_id=#{hxjId}")
    Hxj findByHxjId(@Param("hxjId") Integer hxjId);
    /*
    修改状态
     */
    /*@Update("update Hxj set state=#{state} where dqjcid=#{dqjcid}")
    void updateState(@Param("dqjcid")Integer dqjcid,@Param("state")Integer state);*/
    //修改审核人意见
    @Update("update hxj set shr_jcjl=#{shrJcjl},auditor=#{auditor},shsj_time=#{shsjTime} where hxj_id=#{hxjId}")
    void updateShrJcjy(@Param("hxjId") Integer hxjId, @Param("shrJcjl") String shrJcjl, @Param("auditor") String auditor, @Param("shsjTime") Date shsjTime);




}
