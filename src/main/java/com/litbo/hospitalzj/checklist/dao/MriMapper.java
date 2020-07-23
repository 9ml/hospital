package com.litbo.hospitalzj.checklist.dao;

import com.litbo.hospitalzj.checklist.domain.Mri;
import com.litbo.hospitalzj.checklist.domain.MriTemplate;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface MriMapper {

    //查询模板值
    @Select("select * from mri_template order by mri_template_id desc limit 1")
    MriTemplate findTemplate();
    //修改模板表数据
    @Update(" update mri_template\n" +
            "    set   xq_smtj = #{record.xqSmtj,jdbcType=VARCHAR},\n" +
            "      smjz_smtj = #{record.smjzSmtj,jdbcType=VARCHAR},\n" +
            "      mcxl_smtj = #{record.mcxlSmtj,jdbcType=VARCHAR},\n" +
            "      cjjz_smtj = #{record.cjjzSmtj,jdbcType=VARCHAR},\n" +
            "      cfsj_smtj = #{record.cfsjSmtj,jdbcType=VARCHAR},\n" +
            "      sy_smtj = #{record.sySmtj,jdbcType=VARCHAR},\n" +
            "      hbsj_smtj = #{record.hbsjSmtj,jdbcType=VARCHAR},\n" +
            "      ch_smtj = #{record.chSmtj,jdbcType=VARCHAR},\n" +
            "      pjcs_smtj = #{record.pjcsSmtj,jdbcType=VARCHAR},\n" +
            "      cjj_smtj = #{record.cjjSmtj,jdbcType=VARCHAR},\n" +
            "      xzb_bzyq = #{record.xzbBzyq,jdbcType=VARCHAR},\n" +
            "      jhqbl_bzyq = #{record.jhqblBzyq,jdbcType=VARCHAR},\n" +
            "      kjfbl_bzyq = #{record.kjfblBzyq,jdbcType=VARCHAR},\n" +
            "      txjyx_bzyq = #{record.txjyxBzyq,jdbcType=VARCHAR},\n" +
            "      chwc_bzyq = #{record.chwcBzyq,jdbcType=VARCHAR},\n" +
            "      chfjyx_bzyq = #{record.chfjyxBzyq,jdbcType=VARCHAR},\n" +
            "      zhb_bzyq = #{record.zhbBzyq,jdbcType=VARCHAR},\n" +
            "      ddbdfbl_bzyq1 = #{record.ddbdfblBzyq1,jdbcType=VARCHAR},\n" +
            "      ddbdfbl_bzyq2 = #{record.ddbdfblBzyq2,jdbcType=VARCHAR},\n" +
            "      type = #{record.type,jdbcType=TINYINT}"+
            "    where mri_template_id = #{mriTemplateId,jdbcType=INTEGER}")
    int updateMriTemplate(MriTemplate mriTemplate);
    //插入模板表数据
    @Insert(" insert into mri_template ( xq_smtj, smjz_smtj, \n" +
            "      mcxl_smtj, cjjz_smtj, cfsj_smtj, \n" +
            "      sy_smtj, hbsj_smtj, ch_smtj, \n" +
            "      pjcs_smtj, cjj_smtj, xzb_bzyq, \n" +
            "      jhqbl_bzyq, kjfbl_bzyq, txjyx_bzyq, \n" +
            "      chwc_bzyq, chfjyx_bzyq, zhb_bzyq, \n" +
            "      ddbdfbl_bzyq1, ddbdfbl_bzyq2, type)\n" +
            "    values (#{xqSmtj,jdbcType=VARCHAR}, #{smjzSmtj,jdbcType=VARCHAR}, \n" +
            "      #{mcxlSmtj,jdbcType=VARCHAR}, #{cjjzSmtj,jdbcType=VARCHAR}, #{cfsjSmtj,jdbcType=VARCHAR}, \n" +
            "      #{sySmtj,jdbcType=VARCHAR}, #{hbsjSmtj,jdbcType=VARCHAR}, #{chSmtj,jdbcType=VARCHAR}, \n" +
            "      #{pjcsSmtj,jdbcType=VARCHAR}, #{cjjSmtj,jdbcType=VARCHAR}, #{xzbBzyq,jdbcType=VARCHAR}, \n" +
            "      #{jhqblBzyq,jdbcType=VARCHAR}, #{kjfblBzyq,jdbcType=VARCHAR}, #{txjyxBzyq,jdbcType=VARCHAR}, \n" +
            "      #{chwcBzyq,jdbcType=VARCHAR}, #{chfjyxBzyq,jdbcType=VARCHAR}, #{zhbBzyq,jdbcType=VARCHAR}, \n" +
            "      #{ddbdfblBzyq1,jdbcType=VARCHAR}, #{ddbdfblBzyq2,jdbcType=VARCHAR}, #{type,jdbcType=TINYINT})")
    int insert(MriTemplate mriTemplate);

    //保存
    @Insert("insert into mri ( jcyq_id, eq_id, \n" +
            "      shr_jcjl, tester, auditor, \n" +
            "      test_time, shsj_time, jcjl, \n" +
            "      jcsm, xq_smtj, smjz_smtj, \n" +
            "      mcxl_smtj, cjjz_smtj, cfsj_smtj, \n" +
            "      sy_smtj, hbsj_smtj, ch_smtj, \n" +
            "      pjcs_smtj, cjj_smtj, xzb_bzyq, \n" +
            "      xzb_value, xzb_result, jhqbl_bzyq, \n" +
            "      jhqbl_value, jhqbl_result, kjfbl_bzyq, \n" +
            "      kjfbl_value, kjfbl_result, txjyx_bzyq, \n" +
            "      txjyx_value, txjyx_result, chwc_bzyq, \n" +
            "      chwc_value, chwc_result, chfjyx_bzyq, \n" +
            "      chfjyx_value, chfjyx_result, zhb_bzyq, \n" +
            "      zhb_value, zhb_result, ddbdfbl_bzyq1, \n" +
            "      ddbdfbl_bzyq2, ddbdfbl_value, ddbdfbl_result, \n" +
            "      type) " +
            "values ( #{jcyqId,jdbcType=INTEGER}, #{eqId,jdbcType=INTEGER}, \n" +
            "      #{shrJcjl,jdbcType=VARCHAR}, #{tester,jdbcType=VARCHAR}, #{auditor,jdbcType=VARCHAR}, \n" +
            "      #{testTime,jdbcType=TIMESTAMP}, #{shsjTime,jdbcType=TIMESTAMP}, #{jcjl,jdbcType=VARCHAR}, \n" +
            "      #{jcsm,jdbcType=VARCHAR}, #{xqSmtj,jdbcType=VARCHAR}, #{smjzSmtj,jdbcType=VARCHAR}, \n" +
            "      #{mcxlSmtj,jdbcType=VARCHAR}, #{cjjzSmtj,jdbcType=VARCHAR}, #{cfsjSmtj,jdbcType=VARCHAR}, \n" +
            "      #{sySmtj,jdbcType=VARCHAR}, #{hbsjSmtj,jdbcType=VARCHAR}, #{chSmtj,jdbcType=VARCHAR}, \n" +
            "      #{pjcsSmtj,jdbcType=VARCHAR}, #{cjjSmtj,jdbcType=VARCHAR}, #{xzbBzyq,jdbcType=VARCHAR}, \n" +
            "      #{xzbValue,jdbcType=VARCHAR}, #{xzbResult,jdbcType=TINYINT}, #{jhqblBzyq,jdbcType=VARCHAR}, \n" +
            "      #{jhqblValue,jdbcType=VARCHAR}, #{jhqblResult,jdbcType=TINYINT}, #{kjfblBzyq,jdbcType=VARCHAR}, \n" +
            "      #{kjfblValue,jdbcType=VARCHAR}, #{kjfblResult,jdbcType=TINYINT}, #{txjyxBzyq,jdbcType=VARCHAR}, \n" +
            "      #{txjyxValue,jdbcType=VARCHAR}, #{txjyxResult,jdbcType=TINYINT}, #{chwcBzyq,jdbcType=VARCHAR}, \n" +
            "      #{chwcValue,jdbcType=VARCHAR}, #{chwcResult,jdbcType=TINYINT}, #{chfjyxBzyq,jdbcType=VARCHAR}, \n" +
            "      #{chfjyxValue,jdbcType=VARCHAR}, #{chfjyxResult,jdbcType=TINYINT}, #{zhbBzyq,jdbcType=VARCHAR}, \n" +
            "      #{zhbValue,jdbcType=VARCHAR}, #{zhbResult,jdbcType=TINYINT}, #{ddbdfblBzyq1,jdbcType=VARCHAR}, \n" +
            "      #{ddbdfblBzyq2,jdbcType=VARCHAR}, #{ddbdfblValue,jdbcType=VARCHAR}, #{ddbdfblResult,jdbcType=TINYINT}, \n" +
            "      #{type,jdbcType=TINYINT})")
    @Options(useGeneratedKeys = true, keyProperty = "mriId", keyColumn = "mri_id")
    void save(Mri mri);
    //修改数据
    @Update(" update mri\n" +
            "    set jcyq_id = #{record.jcyqId,jdbcType=INTEGER},\n" +
            "      eq_id = #{record.eqId,jdbcType=INTEGER},\n" +
            "      shr_jcjl = #{record.shrJcjl,jdbcType=VARCHAR},\n" +
            "      tester = #{record.tester,jdbcType=VARCHAR},\n" +
            "      auditor = #{record.auditor,jdbcType=VARCHAR},\n" +
            "      test_time = #{record.testTime,jdbcType=TIMESTAMP},\n" +
            "      shsj_time = #{record.shsjTime,jdbcType=TIMESTAMP},\n" +
            "      jcjl = #{record.jcjl,jdbcType=VARCHAR},\n" +
            "      jcsm = #{record.jcsm,jdbcType=VARCHAR},\n" +
            "      xq_smtj = #{record.xqSmtj,jdbcType=VARCHAR},\n" +
            "      smjz_smtj = #{record.smjzSmtj,jdbcType=VARCHAR},\n" +
            "      mcxl_smtj = #{record.mcxlSmtj,jdbcType=VARCHAR},\n" +
            "      cjjz_smtj = #{record.cjjzSmtj,jdbcType=VARCHAR},\n" +
            "      cfsj_smtj = #{record.cfsjSmtj,jdbcType=VARCHAR},\n" +
            "      sy_smtj = #{record.sySmtj,jdbcType=VARCHAR},\n" +
            "      hbsj_smtj = #{record.hbsjSmtj,jdbcType=VARCHAR},\n" +
            "      ch_smtj = #{record.chSmtj,jdbcType=VARCHAR},\n" +
            "      pjcs_smtj = #{record.pjcsSmtj,jdbcType=VARCHAR},\n" +
            "      cjj_smtj = #{record.cjjSmtj,jdbcType=VARCHAR},\n" +
            "      xzb_bzyq = #{record.xzbBzyq,jdbcType=VARCHAR},\n" +
            "      xzb_value = #{record.xzbValue,jdbcType=VARCHAR},\n" +
            "      xzb_result = #{record.xzbResult,jdbcType=TINYINT},\n" +
            "      jhqbl_bzyq = #{record.jhqblBzyq,jdbcType=VARCHAR},\n" +
            "      jhqbl_value = #{record.jhqblValue,jdbcType=VARCHAR},\n" +
            "      jhqbl_result = #{record.jhqblResult,jdbcType=TINYINT},\n" +
            "      kjfbl_bzyq = #{record.kjfblBzyq,jdbcType=VARCHAR},\n" +
            "      kjfbl_value = #{record.kjfblValue,jdbcType=VARCHAR},\n" +
            "      kjfbl_result = #{record.kjfblResult,jdbcType=TINYINT},\n" +
            "      txjyx_bzyq = #{record.txjyxBzyq,jdbcType=VARCHAR},\n" +
            "      txjyx_value = #{record.txjyxValue,jdbcType=VARCHAR},\n" +
            "      txjyx_result = #{record.txjyxResult,jdbcType=TINYINT},\n" +
            "      chwc_bzyq = #{record.chwcBzyq,jdbcType=VARCHAR},\n" +
            "      chwc_value = #{record.chwcValue,jdbcType=VARCHAR},\n" +
            "      chwc_result = #{record.chwcResult,jdbcType=TINYINT},\n" +
            "      chfjyx_bzyq = #{record.chfjyxBzyq,jdbcType=VARCHAR},\n" +
            "      chfjyx_value = #{record.chfjyxValue,jdbcType=VARCHAR},\n" +
            "      chfjyx_result = #{record.chfjyxResult,jdbcType=TINYINT},\n" +
            "      zhb_bzyq = #{record.zhbBzyq,jdbcType=VARCHAR},\n" +
            "      zhb_value = #{record.zhbValue,jdbcType=VARCHAR},\n" +
            "      zhb_result = #{record.zhbResult,jdbcType=TINYINT},\n" +
            "      ddbdfbl_bzyq1 = #{record.ddbdfblBzyq1,jdbcType=VARCHAR},\n" +
            "      ddbdfbl_bzyq2 = #{record.ddbdfblBzyq2,jdbcType=VARCHAR},\n" +
            "      ddbdfbl_value = #{record.ddbdfblValue,jdbcType=VARCHAR},\n" +
            "      ddbdfbl_result = #{record.ddbdfblResult,jdbcType=TINYINT},\n" +
            "      type = #{record.type,jdbcType=TINYINT}" +
            "    where mri_id = #{mriId,jdbcType=INTEGER}")
    void updateMri(Mri mri);
    //根据设备id查询检测表婴儿培养箱
    @Select("select * from mri where eq_id =#{eqId} order by mri_id desc limit 1")
    public Mri findMri(String eqId);
    //查询一条
    @Select("select * from mri order by mri_id desc limit 1")
    Mri find();
    //根据设备Id,检测仪器Id以及状态查询电切表查询最后一条记录
    @Select("select mri.* from mri where mri.eq_id=#{eqId} and mri.jcyq_id=#{jcyqId} order by test_time desc, mri_id desc limit 1" )
    Mri findByEqIdandJcyqIdLast1(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //根据设备Id,检测仪器Id以及状态查询电切表
    @Select("select mri.* from mri where mri.eq_id=#{eqId} and mri.jcyq_id=#{jcyqId}" )
    List<Mri> findByEqIdandJcyqId(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //查询所有
    @Select("select * from mri")
    List<Mri> findAll();

    //根据检测仪器Id查询
    @Select("select mri.* from mri where mri_id=#{mriId}" )
    Mri findByMriid(@Param("mriId") Integer mriId);

    //修改审核人意见
    @Update("update mri set shr_jcjl=#{shrJcjl},auditor=#{auditor},shsj_time=#{shsjTime} where mri_id=#{mriId}")
    void updateShrJcjy(@Param("mriId") Integer mriId, @Param("shrJcjl") String shrJcjl, @Param("auditor") String auditor, @Param("shsjTime") Date shsjTime);
}

