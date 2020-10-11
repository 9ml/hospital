package com.litbo.hospitalzj.checklist.dao;

import com.litbo.hospitalzj.checklist.domain.Zsb;
import com.litbo.hospitalzj.checklist.domain.ZsbTemplate;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface ZsbMapper {

    //查询模板值
    @Select("select * from zsb_template order by zsb_template_id desc limit 1")
    ZsbTemplate findTemplate();
    //修改模板表数据
    @Update(" update zsb_template\n" +
            "    set   lljc_sdz1 = #{lljcSdz1,jdbcType=VARCHAR},\n" +
            "      lljc_sdz2 = #{lljcSdz2,jdbcType=VARCHAR},\n" +
            "      lljc_wc1 = #{lljcWc1,jdbcType=VARCHAR},\n" +
            "      lljc_wc2 = #{lljcWc2,jdbcType=VARCHAR},\n" +
            "      zsbjyljc_wc = #{zsbjyljcWc,jdbcType=VARCHAR},\n" +
            "      zsbjyljc_ls = #{zsbjyljcLs,jdbcType=VARCHAR},\n" +
            "      type = #{type,jdbcType=VARCHAR}"+
            "    where zsb_template_id = #{zsbTemplateId,jdbcType=INTEGER}")
    int updateZsbTemplate(ZsbTemplate zsbTemplate);
    //插入模板表数据
    @Insert(" insert into zsb_template ( lljc_sdz1, lljc_sdz2, \n" +
            "      lljc_wc1, lljc_wc2, zsbjyljc_wc, \n" +
            "      zsbjyljc_ls, type)\n" +
            "    values (#{lljcSdz1,jdbcType=VARCHAR}, #{lljcSdz2,jdbcType=VARCHAR}, \n" +
            "      #{lljcWc1,jdbcType=VARCHAR}, #{lljcWc2,jdbcType=VARCHAR}, #{zsbjyljcWc,jdbcType=VARCHAR}, \n" +
            "      #{zsbjyljcLs,jdbcType=VARCHAR}, #{type,jdbcType=VARCHAR})")
    int insert(ZsbTemplate zsbTemplate);

    //保存
    @Insert("insert into zsb (jcyq_id, eq_id, \n" +
            "      shr_jcjl, auditor, tester, \n" +
            "      test_time, shsj_time, jcjl, \n" +
            "      jcsm, lljc_sdz1, lljc_sdz2, \n" +
            "      lljc_csz1, lljc_csz2, lljc_csz3,lljc_csz4, lljc_csz5, lljc_csz6,  \n" +
            "      lljc_pjz1, lljc_wcz1, lljc_wcz2, \n" +
            "      lljc_pjz2, lljc_wc1, lljc_wc2, \n" +
            "      lljc_result1, lljc_result2, zsbjyljc_ls, \n" +
            "      zsbjyljc_syylz, zsbjyljc_csz1, zsbjyljc_wcz1, \n" +
            "      zsbjyljc_zxylz, zsbjyljc_csz2, zsbjyljc_wcz2, \n" +
            "      zsbjyljc_zdylz, zsbjyljc_csz3, zsbjyljc_wcz3, \n" +
            "      zsbjyljc_wc, zsbjyljc_result, kmbj, \n" +
            "      sywbbj, dyxtlbj, jl, \n" +
            "      qksm, type) " +
            "values ( #{jcyqId,jdbcType=INTEGER}, #{eqId,jdbcType=INTEGER}, \n" +
            "      #{shrJcjl,jdbcType=VARCHAR}, #{auditor,jdbcType=VARCHAR}, #{tester,jdbcType=VARCHAR}, \n" +
            "      #{testTime,jdbcType=TIMESTAMP}, #{shsjTime,jdbcType=TIMESTAMP}, #{jcjl,jdbcType=VARCHAR}, \n" +
            "      #{jcsm,jdbcType=VARCHAR}, #{lljcSdz1,jdbcType=VARCHAR}, #{lljcSdz2,jdbcType=VARCHAR}, \n" +
            "      #{lljcCsz1,jdbcType=VARCHAR}, #{lljcCsz2,jdbcType=VARCHAR}, #{lljcCsz3,jdbcType=VARCHAR}, #{lljcCsz4,jdbcType=VARCHAR}, #{lljcCsz5,jdbcType=VARCHAR}, #{lljcCsz6,jdbcType=VARCHAR}, \n" +
            "      #{lljcPjz1,jdbcType=VARCHAR}, #{lljcWcz1,jdbcType=VARCHAR}, #{lljcWcz2,jdbcType=VARCHAR}, \n" +
            "      #{lljcPjz2,jdbcType=VARCHAR}, #{lljcWc1,jdbcType=VARCHAR}, #{lljcWc2,jdbcType=VARCHAR}, \n" +
            "      #{lljcResult1,jdbcType=VARCHAR}, #{lljcResult2,jdbcType=VARCHAR}, #{zsbjyljcLs,jdbcType=VARCHAR}, \n" +
            "      #{zsbjyljcSyylz,jdbcType=VARCHAR}, #{zsbjyljcCsz1,jdbcType=VARCHAR}, #{zsbjyljcWcz1,jdbcType=VARCHAR}, \n" +
            "      #{zsbjyljcZxylz,jdbcType=VARCHAR}, #{zsbjyljcCsz2,jdbcType=VARCHAR}, #{zsbjyljcWcz2,jdbcType=VARCHAR}, \n" +
            "      #{zsbjyljcZdylz,jdbcType=VARCHAR}, #{zsbjyljcCsz3,jdbcType=VARCHAR}, #{zsbjyljcWcz3,jdbcType=VARCHAR}, \n" +
            "      #{zsbjyljcWc,jdbcType=VARCHAR}, #{zsbjyljcResult,jdbcType=VARCHAR}, #{kmbj,jdbcType=VARCHAR}, \n" +
            "      #{sywbbj,jdbcType=VARCHAR}, #{dyxtlbj,jdbcType=VARCHAR}, #{jl,jdbcType=VARCHAR}, \n" +
            "      #{qksm,jdbcType=VARCHAR}, #{type,jdbcType=VARCHAR})")
    @Options(useGeneratedKeys = true, keyProperty = "zsbId", keyColumn = "zsb_id")
    void save(Zsb zsb);
    //修改数据
    @Update(" update zsb\n" +
            "    set jcyqId,jdbcType=INTEGER},\n" +
            "      eq_id = #{eqId,jdbcType=INTEGER},\n" +
            "      shr_jcjl = #{shrJcjl,jdbcType=VARCHAR},\n" +
            "      auditor = #{auditor,jdbcType=VARCHAR},\n" +
            "      tester = #{tester,jdbcType=VARCHAR},\n" +
            "      test_time = #{testTime,jdbcType=TIMESTAMP},\n" +
            "      shsj_time = #{shsjTime,jdbcType=TIMESTAMP},\n" +
            "      jcjl = #{jcjl,jdbcType=VARCHAR},\n" +
            "      jcsm = #{jcsm,jdbcType=VARCHAR},\n" +
            "      lljc_sdz1 = #{lljcSdz1,jdbcType=VARCHAR},\n" +
            "      lljc_sdz2 = #{lljcSdz2,jdbcType=VARCHAR},\n" +
            "      lljc_csz1 = #{lljcCsz1,jdbcType=VARCHAR},\n" +
            "      lljc_csz2 = #{lljcCsz2,jdbcType=VARCHAR},\n" +
            "      lljc_csz3 = #{lljcCsz3,jdbcType=VARCHAR},\n" +
            "      lljc_csz4 = #{lljcCsz4,jdbcType=VARCHAR},\n" +
            "      lljc_csz5 = #{lljcCsz5,jdbcType=VARCHAR},\n" +
            "      lljc_csz6 = #{lljcCsz6,jdbcType=VARCHAR},\n" +
            "      lljc_pjz1 = #{lljcPjz1,jdbcType=VARCHAR},\n" +
            "      lljc_wcz1 = #{lljcWcz1,jdbcType=VARCHAR},\n" +
            "      lljc_wcz2 = #{lljcWcz2,jdbcType=VARCHAR},\n" +
            "      lljc_pjz2 = #{lljcPjz2,jdbcType=VARCHAR},\n" +
            "      lljc_wc1 = #{lljcWc1,jdbcType=VARCHAR},\n" +
            "      lljc_wc2 = #{lljcWc2,jdbcType=VARCHAR},\n" +
            "      lljc_result1 = #{lljcResult1,jdbcType=VARCHAR},\n" +
            "      lljc_result2 = #{lljcResult2,jdbcType=VARCHAR},\n" +
            "      zsbjyljc_ls = #{zsbjyljcLs,jdbcType=VARCHAR},\n" +
            "      zsbjyljc_syylz = #{zsbjyljcSyylz,jdbcType=VARCHAR},\n" +
            "      zsbjyljc_csz1 = #{zsbjyljcCsz1,jdbcType=VARCHAR},\n" +
            "      zsbjyljc_wcz1 = #{zsbjyljcWcz1,jdbcType=VARCHAR},\n" +
            "      zsbjyljc_zxylz = #{zsbjyljcZxylz,jdbcType=VARCHAR},\n" +
            "      zsbjyljc_csz2 = #{zsbjyljcCsz2,jdbcType=VARCHAR},\n" +
            "      zsbjyljc_wcz2 = #{zsbjyljcWcz2,jdbcType=VARCHAR},\n" +
            "      zsbjyljc_zdylz = #{zsbjyljcZdylz,jdbcType=VARCHAR},\n" +
            "      zsbjyljc_csz3 = #{zsbjyljcCsz3,jdbcType=VARCHAR},\n" +
            "      zsbjyljc_wcz3 = #{zsbjyljcWcz3,jdbcType=VARCHAR},\n" +
            "      zsbjyljc_wc = #{zsbjyljcWc,jdbcType=VARCHAR},\n" +
            "      zsbjyljc_result = #{zsbjyljcResult,jdbcType=VARCHAR},\n" +
            "      kmbj = #{kmbj,jdbcType=VARCHAR},\n" +
            "      sywbbj = #{sywbbj,jdbcType=VARCHAR},\n" +
            "      dyxtlbj = #{dyxtlbj,jdbcType=VARCHAR},\n" +
            "      jl = #{jl,jdbcType=VARCHAR},\n" +
            "      qksm = #{qksm,jdbcType=VARCHAR},\n" +
            "      type = #{type,jdbcType=VARCHAR}" +
            "    where zsb_id = #{zsbId,jdbcType=INTEGER}")
    void updateZsb(Zsb zsb);
    //根据设备id查询检测表婴儿培养箱
    @Select("select * from zsb where eq_id =#{eqId} order by zsb_id desc limit 1")
    public Zsb findZsb(String eqId);
    //查询一条
    @Select("select * from zsb order by zsb_id desc limit 1")
    Zsb find();
    //根据设备Id,检测仪器Id以及状态查询电切表查询最后一条记录
    @Select("select zsb.* from zsb where zsb.eq_id=#{eqId} and zsb.jcyq_id=#{jcyqId} order by test_time desc, zsb_id desc limit 1" )
    Zsb findByEqIdandJcyqIdLast1(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //根据设备Id,检测仪器Id以及状态查询电切表
    @Select("select zsb.* from zsb where zsb.eq_id=#{eqId} and zsb.jcyq_id=#{jcyqId}" )
    List<Zsb> findByEqIdandJcyqId(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //查询所有
    @Select("select * from zsb")
    List<Zsb> findAll();

    //根据检测仪器Id查询
    @Select("select zsb.* from zsb where zsb_id=#{zsbId}" )
    Zsb findByZsbId(@Param("zsbId") Integer zsbId);

    //修改审核人意见
    @Update("update zsb set shr_jcjl=#{shrJcjl},auditor=#{auditor},shsj_time=#{shsjTime} where zsb_id=#{zsbId}")
    void updateShrJcjy(@Param("zsbId") Integer zsbId, @Param("shrJcjl") String shrJcjl, @Param("auditor") String auditor, @Param("shsjTime") Date shsjTime);
}

