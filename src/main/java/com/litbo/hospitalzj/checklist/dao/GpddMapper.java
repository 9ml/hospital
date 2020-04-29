package com.litbo.hospitalzj.checklist.dao;

import com.litbo.hospitalzj.checklist.domain.Gpdd;
import com.litbo.hospitalzj.zk.domian.GpddTemplate;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface GpddMapper {

    //查询模板值
    @Select("select * from gpdd_template order by gpdd_template_id desc limit 1")
    GpddTemplate findTemplate();
    //修改模板表数据
    @Update(" update gpdd_template\n" +
            "    set djdq_test1 = #{djdqTest1,jdbcType=DOUBLE},\n" +
            "      djdq_test2 = #{djdqTest2,jdbcType=DOUBLE},\n" +
            "      djdq_test3 = #{djdqTest3,jdbcType=DOUBLE},\n" +
            "      djdq_test4 = #{djdqTest4,jdbcType=DOUBLE},\n" +
            "      djdq_wc = #{djdqWc,jdbcType=INTEGER},\n" +
            "      djdn_test1 = #{djdnTest1,jdbcType=DOUBLE},\n" +
            "      djdn_test2 = #{djdnTest2,jdbcType=DOUBLE},\n" +
            "      djdn_test3 = #{djdnTest3,jdbcType=DOUBLE},\n" +
            "      djdn_test4 = #{djdnTest4,jdbcType=DOUBLE},\n" +
            "      djdn_wc = #{djdnWc,jdbcType=INTEGER},\n" +
            "      sjdq_test1 = #{sjdqTest1,jdbcType=DOUBLE},\n" +
            "      sjdq_test2 = #{sjdqTest2,jdbcType=DOUBLE},\n" +
            "      sjdq_test3 = #{sjdqTest3,jdbcType=DOUBLE},\n" +
            "      sjdq_test4 = #{sjdqTest4,jdbcType=DOUBLE},\n" +
            "      sjdq_wc = #{sjdqWc,jdbcType=INTEGER},\n" +
            "      sjdn_test1 = #{sjdnTest1,jdbcType=DOUBLE},\n" +
            "      sjdn_test2 = #{sjdnTest2,jdbcType=DOUBLE},\n" +
            "      sjdn_test3 = #{sjdnTest3,jdbcType=DOUBLE},\n" +
            "      sjdn_test4 = #{sjdnTest4,jdbcType=DOUBLE},\n" +
            "      sjdn_wc = #{sjdnWc,jdbcType=INTEGER},\n" +
            "      djgpld_wc = #{djgpldWc,jdbcType=INTEGER},\n" +
            "      sjgpld_wc = #{sjgpldWc,jdbcType=INTEGER},\n" +
            "      spare1 = #{spare1,jdbcType=VARCHAR},\n" +
            "      spare2 = #{spare2,jdbcType=VARCHAR}\n" +
            "      spare3 = #{spare3,jdbcType=INTEGER}\n" +
            "      spare4 = #{spare4,jdbcType=INTEGER}\n" +
            "      spare5 = #{spare5,jdbcType=INTEGER}\n" +
            "    where gpdd_template_id = #{gpddTemplateId,jdbcType=INTEGER}")
    int updateGpddTemplate(GpddTemplate gpddTemplate);
    //插入模板表数据
    @Insert(" insert into gpdd_template (gpdd_template_id, djdq_test1, djdq_test2, \n" +
            "      djdq_test3, djdq_test4, djdq_wc, \n" +
            "      djdn_test1, djdn_test2, djdn_test3, \n" +
            "      djdn_test4, djdn_wc, sjdq_test1, \n" +
            "      sjdq_test2, sjdq_test3, sjdq_test4, \n" +
            "      sjdq_wc, sjdn_test1, sjdn_test2, \n" +
            "      sjdn_test3, sjdn_test4, sjdn_wc, \n" +
            "      djgpld_wc, sjgpld_wc, spare1, \n" +
            "      spare2)\n" +
            "    values (#{gpddTemplateId,jdbcType=INTEGER}, #{djdqTest1,jdbcType=DOUBLE}, #{djdqTest2,jdbcType=DOUBLE}, \n" +
            "      #{djdqTest3,jdbcType=DOUBLE}, #{djdqTest4,jdbcType=DOUBLE}, #{djdqWc,jdbcType=INTEGER}, \n" +
            "      #{djdnTest1,jdbcType=DOUBLE}, #{djdnTest2,jdbcType=DOUBLE}, #{djdnTest3,jdbcType=DOUBLE}, \n" +
            "      #{djdnTest4,jdbcType=DOUBLE}, #{djdnWc,jdbcType=INTEGER}, #{sjdqTest1,jdbcType=DOUBLE}, \n" +
            "      #{sjdqTest2,jdbcType=DOUBLE}, #{sjdqTest3,jdbcType=DOUBLE}, #{sjdqTest4,jdbcType=DOUBLE}, \n" +
            "      #{sjdqWc,jdbcType=INTEGER}, #{sjdnTest1,jdbcType=DOUBLE}, #{sjdnTest2,jdbcType=DOUBLE}, \n" +
            "      #{sjdnTest3,jdbcType=DOUBLE}, #{sjdnTest4,jdbcType=DOUBLE}, #{sjdnWc,jdbcType=INTEGER}, \n" +
            "      #{djgpldWc,jdbcType=INTEGER}, #{sjgpldWc,jdbcType=INTEGER}, #{spare1,jdbcType=VARCHAR}, \n" +
            "      #{spare2,jdbcType=VARCHAR})")
    int insert(GpddTemplate gpddTemplate);

    //保存
    @Insert("insert into gpdd (gpddid, jcyq_id, eq_id,  tester, auditor, test_time, shsj_time,jcjl, jcsm, djdq_test1, \n" +
            "      djdq_value1, djdq_test2, djdq_value2,  djdq_test3, djdq_value3, djdq_test4,  djdq_value4, djdq_wc, djdq_result,   djdn_test1, djdn_value1, djdn_test2, \n" +
            "      djdn_value2, djdn_test3, djdn_value3, djdn_test4, djdn_value4, djdn_wc,   djdn_result, sjdq_test1, sjdq_value1,   sjdq_test2, sjdq_value2, sjdq_test3, \n" +
            "      sjdq_value3, sjdq_test4, sjdq_value4,  sjdq_wc, sjdq_result, sjdn_test1,  sjdn_value1, sjdn_test2, sjdn_value2,   sjdn_test3, sjdn_value3, sjdn_test4, \n" +
            "      sjdn_value4, sjdn_wc, sjdn_result,   ssld_djdq, ssld_djdn, zxld_djdq,  zxld_djdn, djgpld_wc, djgpld_result,  ssld_sjdq, ssld_sjdn, zxld_sjdq, \n" +
            "      zxld_sjdn, sjgpld_wc, sjgpld_result, spare1, spare2, spare3 , spare4, spare5) values (#{gpddid,jdbcType=INTEGER}, #{jcyqId,jdbcType=INTEGER}, #{eqId,jdbcType=INTEGER}, \n" +
            "      #{tester,jdbcType=VARCHAR}, #{auditor,jdbcType=VARCHAR}, #{testTime,jdbcType=TIMESTAMP},#{shsjTime}, \n" +
            "      #{jcjl,jdbcType=VARCHAR}, #{jcsm,jdbcType=VARCHAR}, #{djdqTest1,jdbcType=DOUBLE}, \n" +
            "      #{djdqValue1,jdbcType=DOUBLE}, #{djdqTest2,jdbcType=DOUBLE}, #{djdqValue2,jdbcType=DOUBLE}, \n" +
            "      #{djdqTest3,jdbcType=DOUBLE}, #{djdqValue3,jdbcType=DOUBLE}, #{djdqTest4,jdbcType=DOUBLE}, \n" +
            "      #{djdqValue4,jdbcType=DOUBLE}, #{djdqWc,jdbcType=INTEGER}, #{djdqResult,jdbcType=TINYINT}, \n" +
            "      #{djdnTest1,jdbcType=DOUBLE}, #{djdnValue1,jdbcType=DOUBLE}, #{djdnTest2,jdbcType=DOUBLE}, \n" +
            "      #{djdnValue2,jdbcType=DOUBLE}, #{djdnTest3,jdbcType=DOUBLE}, #{djdnValue3,jdbcType=DOUBLE}, \n" +
            "      #{djdnTest4,jdbcType=DOUBLE}, #{djdnValue4,jdbcType=DOUBLE}, #{djdnWc,jdbcType=INTEGER}, \n" +
            "      #{djdnResult,jdbcType=TINYINT}, #{sjdqTest1,jdbcType=DOUBLE}, #{sjdqValue1,jdbcType=DOUBLE}, \n" +
            "      #{sjdqTest2,jdbcType=DOUBLE}, #{sjdqValue2,jdbcType=DOUBLE}, #{sjdqTest3,jdbcType=DOUBLE}, \n" +
            "      #{sjdqValue3,jdbcType=DOUBLE}, #{sjdqTest4,jdbcType=DOUBLE}, #{sjdqValue4,jdbcType=DOUBLE}, \n" +
            "      #{sjdqWc,jdbcType=INTEGER}, #{sjdqResult,jdbcType=TINYINT}, #{sjdnTest1,jdbcType=DOUBLE}, \n" +
            "      #{sjdnValue1,jdbcType=DOUBLE}, #{sjdnTest2,jdbcType=DOUBLE}, #{sjdnValue2,jdbcType=DOUBLE}, \n" +
            "      #{sjdnTest3,jdbcType=DOUBLE}, #{sjdnValue3,jdbcType=DOUBLE}, #{sjdnTest4,jdbcType=DOUBLE}, \n" +
            "      #{sjdnValue4,jdbcType=DOUBLE}, #{sjdnWc,jdbcType=INTEGER}, #{sjdnResult,jdbcType=TINYINT}, \n" +
            "      #{ssldDjdq,jdbcType=DOUBLE}, #{ssldDjdn,jdbcType=DOUBLE}, #{zxldDjdq,jdbcType=DOUBLE}, \n" +
            "      #{zxldDjdn,jdbcType=DOUBLE}, #{djgpldWc,jdbcType=INTEGER}, #{djgpldResult,jdbcType=TINYINT}, \n" +
            "      #{ssldSjdq,jdbcType=DOUBLE}, #{ssldSjdn,jdbcType=DOUBLE}, #{zxldSjdq,jdbcType=DOUBLE}, \n" +
            "      #{zxldSjdn,jdbcType=DOUBLE}, #{sjgpldWc,jdbcType=INTEGER}, #{sjgpldResult,jdbcType=TINYINT}, \n" +
            "      #{spare1,jdbcType=VARCHAR}, #{spare2,jdbcType=VARCHAR}, #{spare3,jdbcType=INTEGER}, \n" +
            "      #{spare4,jdbcType=INTEGER}, #{spare5,jdbcType=INTEGER})")
    @Options(useGeneratedKeys = true, keyProperty = "gpddid", keyColumn = "gpddid")
    void save(Gpdd gpdd);
    //修改数据
    @Update(" update gpdd\n" +
            "    set jcyq_id = #{jcyqId,jdbcType=INTEGER},\n" +
            "      eq_id = #{eqId,jdbcType=INTEGER},\n" +
            "      tester = #{tester,jdbcType=VARCHAR},\n" +
            "      auditor = #{auditor,jdbcType=VARCHAR},\n" +
            "      test_time = #{testTime,jdbcType=TIMESTAMP},\n" +
            "      shsj_time = #{shsjTime,jdbcType=TIMESTAMP},\n" +
            "      jcjl = #{jcjl,jdbcType=VARCHAR},\n" +
            "      jcsm = #{jcsm,jdbcType=VARCHAR},\n" +
            "      djdq_test1 = #{djdqTest1,jdbcType=DOUBLE},\n" +
            "      djdq_value1 = #{djdqValue1,jdbcType=DOUBLE},\n" +
            "      djdq_test2 = #{djdqTest2,jdbcType=DOUBLE},\n" +
            "      djdq_value2 = #{djdqValue2,jdbcType=DOUBLE},\n" +
            "      djdq_test3 = #{djdqTest3,jdbcType=DOUBLE},\n" +
            "      djdq_value3 = #{djdqValue3,jdbcType=DOUBLE},\n" +
            "      djdq_test4 = #{djdqTest4,jdbcType=DOUBLE},\n" +
            "      djdq_value4 = #{djdqValue4,jdbcType=DOUBLE},\n" +
            "      djdq_wc = #{djdqWc,jdbcType=INTEGER},\n" +
            "      djdq_result = #{djdqResult,jdbcType=TINYINT},\n" +
            "      djdn_test1 = #{djdnTest1,jdbcType=DOUBLE},\n" +
            "      djdn_value1 = #{djdnValue1,jdbcType=DOUBLE},\n" +
            "      djdn_test2 = #{djdnTest2,jdbcType=DOUBLE},\n" +
            "      djdn_value2 = #{djdnValue2,jdbcType=DOUBLE},\n" +
            "      djdn_test3 = #{djdnTest3,jdbcType=DOUBLE},\n" +
            "      djdn_value3 = #{djdnValue3,jdbcType=DOUBLE},\n" +
            "      djdn_test4 = #{djdnTest4,jdbcType=DOUBLE},\n" +
            "      djdn_value4 = #{djdnValue4,jdbcType=DOUBLE},\n" +
            "      djdn_wc = #{djdnWc,jdbcType=INTEGER},\n" +
            "      djdn_result = #{djdnResult,jdbcType=TINYINT},\n" +
            "      sjdq_test1 = #{sjdqTest1,jdbcType=DOUBLE},\n" +
            "      sjdq_value1 = #{sjdqValue1,jdbcType=DOUBLE},\n" +
            "      sjdq_test2 = #{sjdqTest2,jdbcType=DOUBLE},\n" +
            "      sjdq_value2 = #{sjdqValue2,jdbcType=DOUBLE},\n" +
            "      sjdq_test3 = #{sjdqTest3,jdbcType=DOUBLE},\n" +
            "      sjdq_value3 = #{sjdqValue3,jdbcType=DOUBLE},\n" +
            "      sjdq_test4 = #{sjdqTest4,jdbcType=DOUBLE},\n" +
            "      sjdq_value4 = #{sjdqValue4,jdbcType=DOUBLE},\n" +
            "      sjdq_wc = #{sjdqWc,jdbcType=INTEGER},\n" +
            "      sjdq_result = #{sjdqResult,jdbcType=TINYINT},\n" +
            "      sjdn_test1 = #{sjdnTest1,jdbcType=DOUBLE},\n" +
            "      sjdn_value1 = #{sjdnValue1,jdbcType=DOUBLE},\n" +
            "      sjdn_test2 = #{sjdnTest2,jdbcType=DOUBLE},\n" +
            "      sjdn_value2 = #{sjdnValue2,jdbcType=DOUBLE},\n" +
            "      sjdn_test3 = #{sjdnTest3,jdbcType=DOUBLE},\n" +
            "      sjdn_value3 = #{sjdnValue3,jdbcType=DOUBLE},\n" +
            "      sjdn_test4 = #{sjdnTest4,jdbcType=DOUBLE},\n" +
            "      sjdn_value4 = #{sjdnValue4,jdbcType=DOUBLE},\n" +
            "      sjdn_wc = #{sjdnWc,jdbcType=INTEGER},\n" +
            "      sjdn_result = #{sjdnResult,jdbcType=TINYINT},\n" +
            "      ssld_djdq = #{ssldDjdq,jdbcType=DOUBLE},\n" +
            "      ssld_djdn = #{ssldDjdn,jdbcType=DOUBLE},\n" +
            "      zxld_djdq = #{zxldDjdq,jdbcType=DOUBLE},\n" +
            "      zxld_djdn = #{zxldDjdn,jdbcType=DOUBLE},\n" +
            "      djgpld_wc = #{djgpldWc,jdbcType=INTEGER},\n" +
            "      djgpld_result = #{djgpldResult,jdbcType=TINYINT},\n" +
            "      ssld_sjdq = #{ssldSjdq,jdbcType=DOUBLE},\n" +
            "      ssld_sjdn = #{ssldSjdn,jdbcType=DOUBLE},\n" +
            "      zxld_sjdq = #{zxldSjdq,jdbcType=DOUBLE},\n" +
            "      zxld_sjdn = #{zxldSjdn,jdbcType=DOUBLE},\n" +
            "      sjgpld_wc = #{sjgpldWc,jdbcType=INTEGER},\n" +
            "      sjgpld_result = #{sjgpldResult,jdbcType=TINYINT},\n" +
            "      spare1 = #{spare1,jdbcType=VARCHAR},\n" +
            "      spare2 = #{spare2,jdbcType=VARCHAR},\n" +
            "      spare3 = #{spare3,jdbcType=INTEGER},\n" +
            "      spare4 = #{spare4,jdbcType=INTEGER},\n" +
            "      spare5 = #{spare5,jdbcType=INTEGER}\n" +
            "    where gpddid = #{gpddid,jdbcType=INTEGER}")
    void updateGpdd(Gpdd gpdd);
    //根据设备id查询检测表婴儿培养箱
    @Select("select gpddid, jcyq_id, eq_id, tester, auditor, test_time, shsj_time, jcjl, jcsm, djdq_test1, \n" +
            "    djdq_value1, djdq_test2, djdq_value2, djdq_test3, djdq_value3, djdq_test4, djdq_value4, \n" +
            "    djdq_wc, djdq_result, djdn_test1, djdn_value1, djdn_test2, djdn_value2, djdn_test3, \n" +
            "    djdn_value3, djdn_test4, djdn_value4, djdn_wc, djdn_result, sjdq_test1, sjdq_value1, \n" +
            "    sjdq_test2, sjdq_value2, sjdq_test3, sjdq_value3, sjdq_test4, sjdq_value4, sjdq_wc, \n" +
            "    sjdq_result, sjdn_test1, sjdn_value1, sjdn_test2, sjdn_value2, sjdn_test3, sjdn_value3, \n" +
            "    sjdn_test4, sjdn_value4, sjdn_wc, sjdn_result, ssld_djdq, ssld_djdn, zxld_djdq, zxld_djdn, \n" +
            "    djgpld_wc, djgpld_result, ssld_sjdq, ssld_sjdn, zxld_sjdq, zxld_sjdn, sjgpld_wc, \n" +
            "    sjgpld_result, spare1, spare2, spare3, spare4, spare5 from gpdd where eq_id =#{eqId} order by gpddid desc limit 1")
    public Gpdd findGpdd(String eqId);
    //查询一条
    @Select("select * from gpdd order by gpddid desc limit 1")
    Gpdd find();
    //根据设备Id,检测仪器Id以及状态查询电切表查询最后一条记录
    @Select("select gpdd.* from gpdd where gpdd.eq_id=#{eqId} and gpdd.jcyq_id=#{jcyqId} order by test_time desc, gpddid desc limit 1" )
    Gpdd findByEqIdandJcyqIdLast1(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //根据设备Id,检测仪器Id以及状态查询电切表
    @Select("select gpdd.* from gpdd where gpdd.eq_id=#{eqId} and gpdd.jcyq_id=#{jcyqId}" )
    List<Gpdd> findByEqIdandJcyqId(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //查询所有
    @Select("select * from gpdd")
    List<Gpdd> findAll();

    //根据检测仪器Id查询
    @Select("select gpdd.* from gpdd where gpddid=#{gpddid}" )
    Gpdd findByGpddid(@Param("gpddid") Integer gpddid);

    //修改审核人意见
    @Update("update gpdd set shr_jcjl=#{shrJcjl},auditor=#{auditor},shsj_time=#{shsjTime} where gpddid=#{gpddid}")
    void updateShrJcjy(@Param("gpddid") Integer gpddid, @Param("shrJcjl") String shrJcjl, @Param("auditor") String auditor, @Param("shsjTime") Date shsjTime);
}

