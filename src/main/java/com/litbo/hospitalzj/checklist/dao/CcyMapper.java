package com.litbo.hospitalzj.checklist.dao;

import com.litbo.hospitalzj.checklist.domain.Ccy;
import com.litbo.hospitalzj.checklist.domain.CcyTemplate;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface CcyMapper {

    //查询电气检测模板表
    @Select("select * from ccy_template order by ccy_template_id desc limit 1")
    public CcyTemplate findTemplate();
    @Select("select * from ccy_template where ccy_template_id=#{ccyTemplateId}")
    public CcyTemplate findTemplateById(Integer ccYtemplateId);
    //修改模板表数据
    @Update("  update ccy_template\n" +
            "    set ccy_template_id = #{ccyTemplateId,jdbcType=INTEGER},\n" +
            "      sfnl_yxwc = #{sfnlYxwc,jdbcType=VARCHAR},\n" +
            "      sfnl_test1 = #{sfnlTest1,jdbcType=VARCHAR},\n" +
            "      sfnl_test2 = #{sfnlTest2,jdbcType=VARCHAR},\n" +
            "      sfnl_test3 = #{sfnlTest3,jdbcType=VARCHAR},\n" +
            "      sfnl_test4 = #{sfnlTest4,jdbcType=VARCHAR},\n" +
            "      sfnl_test5 = #{sfnlTest5,jdbcType=VARCHAR},\n" +
            "      sfnl_test6 = #{sfnlTest6,jdbcType=VARCHAR},\n" +
            "      sfnl_test7 = #{sfnlTest7,jdbcType=VARCHAR},\n" +
            "      sfnl_test8 = #{sfnlTest8,jdbcType=VARCHAR},\n" +
            "      cdsj_test = #{cdsjTest,jdbcType=VARCHAR},\n" +
            "      tbms_ycsj = #{tbmsYcsj,jdbcType=VARCHAR},\n" +
            "      xlsz_test11 = #{xlszTest11,jdbcType=INTEGER},\n" +
            "      xlsz_test12 = #{xlszTest12,jdbcType=INTEGER},\n" +
            "      xlsz_test13 = #{xlszTest13,jdbcType=INTEGER},\n" +
            "      xlsz_test21 = #{xlszTest21,jdbcType=INTEGER},\n" +
            "      xlsz_test22 = #{xlszTest22,jdbcType=INTEGER},\n" +
            "      xlsz_test23 = #{xlszTest23,jdbcType=INTEGER},\n" +
            "      xlsz_test31 = #{xlszTest31,jdbcType=INTEGER},\n" +
            "      xlsz_test32 = #{xlszTest32,jdbcType=INTEGER},\n" +
            "      xlsz_test33 = #{xlszTest33,jdbcType=INTEGER},\n" +
            "      xlsz_test41 = #{xlszTest41,jdbcType=INTEGER},\n" +
            "      xlsz_test42 = #{xlszTest42,jdbcType=INTEGER},\n" +
            "      xlsz_test43 = #{xlszTest43,jdbcType=INTEGER},\n" +
            "      xlsz_test51 = #{xlszTest51,jdbcType=INTEGER},\n" +
            "      xlsz_test52 = #{xlszTest52,jdbcType=INTEGER},\n" +
            "      xlsz_test53 = #{xlszTest53,jdbcType=INTEGER}")
    public void updateTemplate(CcyTemplate ccyTemplate);
    //插入模板表数据
    @Insert(" insert into ccy_template (ccy_template_id, sfnl_yxwc, sfnl_test1, \n" +
            "      sfnl_test2, sfnl_test3, sfnl_test4, \n" +
            "      sfnl_test5, sfnl_test6, sfnl_test7, \n" +
            "      sfnl_test8, cdsj_test, tbms_ycsj, \n" +
            "      xlsz_test11, xlsz_test12, xlsz_test13, \n" +
            "      xlsz_test21, xlsz_test22, xlsz_test23, \n" +
            "      xlsz_test31, xlsz_test32, xlsz_test33, \n" +
            "      xlsz_test41, xlsz_test42, xlsz_test43, \n" +
            "      xlsz_test51, xlsz_test52, xlsz_test53\n" +
            "      )\n" +
            "    values (#{ccyTemplateId,jdbcType=INTEGER}, #{sfnlYxwc,jdbcType=VARCHAR}, #{sfnlTest1,jdbcType=VARCHAR}, \n" +
            "      #{sfnlTest2,jdbcType=VARCHAR}, #{sfnlTest3,jdbcType=VARCHAR}, #{sfnlTest4,jdbcType=VARCHAR}, \n" +
            "      #{sfnlTest5,jdbcType=VARCHAR}, #{sfnlTest6,jdbcType=VARCHAR}, #{sfnlTest7,jdbcType=VARCHAR}, \n" +
            "      #{sfnlTest8,jdbcType=VARCHAR}, #{cdsjTest,jdbcType=VARCHAR}, #{tbmsYcsj,jdbcType=VARCHAR}, \n" +
            "      #{xlszTest11,jdbcType=INTEGER}, #{xlszTest12,jdbcType=INTEGER}, #{xlszTest13,jdbcType=INTEGER}, \n" +
            "      #{xlszTest21,jdbcType=INTEGER}, #{xlszTest22,jdbcType=INTEGER}, #{xlszTest23,jdbcType=INTEGER}, \n" +
            "      #{xlszTest31,jdbcType=INTEGER}, #{xlszTest32,jdbcType=INTEGER}, #{xlszTest33,jdbcType=INTEGER}, \n" +
            "      #{xlszTest41,jdbcType=INTEGER}, #{xlszTest42,jdbcType=INTEGER}, #{xlszTest43,jdbcType=INTEGER}, \n" +
            "      #{xlszTest51,jdbcType=INTEGER}, #{xlszTest52,jdbcType=INTEGER}, #{xlszTest53,jdbcType=INTEGER}\n" +
            "      )")
    void insertTemplate(CcyTemplate ccyTemplate);

    //保存除颤仪检测数据
    @Insert("  insert into ccy (ccy_id, jcyq_id, eq_id, \n" +
            "      tester, auditor, test_time, \n" +
            "      shr_jcjl, shsj_time, jcjl, \n" +
            "      jcsm, sfnl_yxwc, sfnl_test1, \n" +
            "      sfnl_value1, sfnl_wc1, sfnl_test2, \n" +
            "      sfnl_value2, sfnl_wc2, sfnl_test3, \n" +
            "      sfnl_value3, sfnl_wc3, sfnl_test4, \n" +
            "      sfnl_value4, sfnl_wc4, sfnl_test5, \n" +
            "      sfnl_value5, sfnl_wc5, sfnl_test6, \n" +
            "      sfnl_value6, sfnl_wc6, sfnl_test7, \n" +
            "      sfnl_value71, sfnl_value72, sfnl_value73, \n" +
            "      sfnl_wc7, sfnl_test8, sfnl_value81, \n" +
            "      sfnl_value82, sfnl_value83, sfnl_wc8, \n" +
            "      sfnl_result, cdsj_test, cdsj_value, \n" +
            "      cdsj_result, nbfd_result, tbms_cfresult, \n" +
            "      tbms_ycsj, tbms_sj, tbms_result, \n" +
            "      xlsz_test11, xlsz_test12, xlsz_test13, \n" +
            "      xlsz_value1, xlsz_test21, xlsz_test22, \n" +
            "      xlsz_test23, xlsz_value2, xlsz_test31, \n" +
            "      xlsz_test32, xlsz_test33, xlsz_value3, \n" +
            "      xlsz_test41, xlsz_test42, xlsz_test43, \n" +
            "      xlsz_value4, xlsz_test51, xlsz_test52, \n" +
            "      xlsz_test53, xlsz_value5, xlsz_result, \n" +
            "      sgbj_result, bjx_result, jy_result, zxnl, zdnl, zdnl2\n" +
            "      )\n" +
            "    values (#{ccyId,jdbcType=INTEGER}, #{jcyqId,jdbcType=INTEGER}, #{eqId,jdbcType=INTEGER}, \n" +
            "      #{tester,jdbcType=VARCHAR}, #{auditor,jdbcType=VARCHAR}, #{testTime,jdbcType=DATE}, \n" +
            "      #{shrJcjl,jdbcType=VARCHAR}, #{shsjTime,jdbcType=TIMESTAMP}, #{jcjl,jdbcType=VARCHAR}, \n" +
            "      #{jcsm,jdbcType=VARCHAR}, #{sfnlYxwc,jdbcType=VARCHAR}, #{sfnlTest1,jdbcType=VARCHAR}, \n" +
            "      #{sfnlValue1,jdbcType=VARCHAR}, #{sfnlWc1,jdbcType=VARCHAR}, #{sfnlTest2,jdbcType=VARCHAR}, \n" +
            "      #{sfnlValue2,jdbcType=VARCHAR}, #{sfnlWc2,jdbcType=VARCHAR}, #{sfnlTest3,jdbcType=VARCHAR}, \n" +
            "      #{sfnlValue3,jdbcType=VARCHAR}, #{sfnlWc3,jdbcType=VARCHAR}, #{sfnlTest4,jdbcType=VARCHAR}, \n" +
            "      #{sfnlValue4,jdbcType=VARCHAR}, #{sfnlWc4,jdbcType=VARCHAR}, #{sfnlTest5,jdbcType=VARCHAR}, \n" +
            "      #{sfnlValue5,jdbcType=VARCHAR}, #{sfnlWc5,jdbcType=VARCHAR}, #{sfnlTest6,jdbcType=VARCHAR}, \n" +
            "      #{sfnlValue6,jdbcType=VARCHAR}, #{sfnlWc6,jdbcType=VARCHAR}, #{sfnlTest7,jdbcType=VARCHAR}, \n" +
            "      #{sfnlValue71,jdbcType=VARCHAR}, #{sfnlValue72,jdbcType=VARCHAR}, #{sfnlValue73,jdbcType=VARCHAR}, \n" +
            "      #{sfnlWc7,jdbcType=VARCHAR}, #{sfnlTest8,jdbcType=VARCHAR}, #{sfnlValue81,jdbcType=VARCHAR}, \n" +
            "      #{sfnlValue82,jdbcType=VARCHAR}, #{sfnlValue83,jdbcType=VARCHAR}, #{sfnlWc8,jdbcType=VARCHAR}, \n" +
            "      #{sfnlResult,jdbcType=VARCHAR}, #{cdsjTest,jdbcType=VARCHAR}, #{cdsjValue,jdbcType=VARCHAR}, \n" +
            "      #{cdsjResult,jdbcType=VARCHAR}, #{nbfdResult,jdbcType=VARCHAR}, #{tbmsCfresult,jdbcType=VARCHAR}, \n" +
            "      #{tbmsYcsj,jdbcType=VARCHAR}, #{tbmsSj,jdbcType=VARCHAR}, #{tbmsResult,jdbcType=VARCHAR}, \n" +
            "      #{xlszTest11,jdbcType=INTEGER}, #{xlszTest12,jdbcType=INTEGER}, #{xlszTest13,jdbcType=INTEGER}, \n" +
            "      #{xlszValue1,jdbcType=VARCHAR}, #{xlszTest21,jdbcType=INTEGER}, #{xlszTest22,jdbcType=INTEGER}, \n" +
            "      #{xlszTest23,jdbcType=INTEGER}, #{xlszValue2,jdbcType=VARCHAR}, #{xlszTest31,jdbcType=INTEGER}, \n" +
            "      #{xlszTest32,jdbcType=INTEGER}, #{xlszTest33,jdbcType=INTEGER}, #{xlszValue3,jdbcType=VARCHAR}, \n" +
            "      #{xlszTest41,jdbcType=INTEGER}, #{xlszTest42,jdbcType=INTEGER}, #{xlszTest43,jdbcType=INTEGER}, \n" +
            "      #{xlszValue4,jdbcType=VARCHAR}, #{xlszTest51,jdbcType=INTEGER}, #{xlszTest52,jdbcType=INTEGER}, \n" +
            "      #{xlszTest53,jdbcType=INTEGER}, #{xlszValue5,jdbcType=VARCHAR}, #{xlszResult,jdbcType=VARCHAR}, \n" +
            "      #{sgbjResult,jdbcType=VARCHAR}, #{bjxResult,jdbcType=VARCHAR}, #{jyResult,jdbcType=VARCHAR}," +
            "      #{zxnl,jdbcType=VARCHAR},#{zdnl,jdbcType=VARCHAR} ,#{zdnl2,jdbcType=VARCHAR}\n" +
            "      )")
    @Options(useGeneratedKeys = true, keyProperty = "ccyId", keyColumn = "ccy_id")
    public void save(Ccy ccy);

    @Update("update ccy\n" +
            "    set jcyq_id = #{jcyqId,jdbcType=INTEGER},\n" +
            "      eq_id = #{eqId,jdbcType=INTEGER},\n" +
            "      tester = #{tester,jdbcType=VARCHAR},\n" +
            "      auditor = #{auditor,jdbcType=VARCHAR},\n" +
            "      test_time = #{testTime,jdbcType=DATE},\n" +
            "      shr_jcjl = #{shrJcjl,jdbcType=VARCHAR},\n" +
            "      shsj_time = #{shsjTime,jdbcType=TIMESTAMP},\n" +
            "      jcjl = #{jcjl,jdbcType=VARCHAR},\n" +
            "      jcsm = #{jcsm,jdbcType=VARCHAR},\n" +
            "      sfnl_yxwc = #{sfnlYxwc,jdbcType=VARCHAR},\n" +
            "      sfnl_test1 = #{sfnlTest1,jdbcType=VARCHAR},\n" +
            "      sfnl_value1 = #{sfnlValue1,jdbcType=VARCHAR},\n" +
            "      sfnl_wc1 = #{sfnlWc1,jdbcType=VARCHAR},\n" +
            "      sfnl_test2 = #{sfnlTest2,jdbcType=VARCHAR},\n" +
            "      sfnl_value2 = #{sfnlValue2,jdbcType=VARCHAR},\n" +
            "      sfnl_wc2 = #{sfnlWc2,jdbcType=VARCHAR},\n" +
            "      sfnl_test3 = #{sfnlTest3,jdbcType=VARCHAR},\n" +
            "      sfnl_value3 = #{sfnlValue3,jdbcType=VARCHAR},\n" +
            "      sfnl_wc3 = #{sfnlWc3,jdbcType=VARCHAR},\n" +
            "      sfnl_test4 = #{sfnlTest4,jdbcType=VARCHAR},\n" +
            "      sfnl_value4 = #{sfnlValue4,jdbcType=VARCHAR},\n" +
            "      sfnl_wc4 = #{sfnlWc4,jdbcType=VARCHAR},\n" +
            "      sfnl_test5 = #{sfnlTest5,jdbcType=VARCHAR},\n" +
            "      sfnl_value5 = #{sfnlValue5,jdbcType=VARCHAR},\n" +
            "      sfnl_wc5 = #{sfnlWc5,jdbcType=VARCHAR},\n" +
            "      sfnl_test6 = #{sfnlTest6,jdbcType=VARCHAR},\n" +
            "      sfnl_value6 = #{sfnlValue6,jdbcType=VARCHAR},\n" +
            "      sfnl_wc6 = #{sfnlWc6,jdbcType=VARCHAR},\n" +
            "      sfnl_test7 = #{sfnlTest7,jdbcType=VARCHAR},\n" +
            "      sfnl_value71 = #{sfnlValue71,jdbcType=VARCHAR},\n" +
            "      sfnl_value72 = #{sfnlValue72,jdbcType=VARCHAR},\n" +
            "      sfnl_value73 = #{sfnlValue73,jdbcType=VARCHAR},\n" +
            "      sfnl_wc7 = #{sfnlWc7,jdbcType=VARCHAR},\n" +
            "      sfnl_test8 = #{sfnlTest8,jdbcType=VARCHAR},\n" +
            "      sfnl_value81 = #{sfnlValue81,jdbcType=VARCHAR},\n" +
            "      sfnl_value82 = #{sfnlValue82,jdbcType=VARCHAR},\n" +
            "      sfnl_value83 = #{sfnlValue83,jdbcType=VARCHAR},\n" +
            "      sfnl_wc8 = #{sfnlWc8,jdbcType=VARCHAR},\n" +
            "      sfnl_result = #{sfnlResult,jdbcType=VARCHAR},\n" +
            "      cdsj_test = #{cdsjTest,jdbcType=VARCHAR},\n" +
            "      cdsj_value = #{cdsjValue,jdbcType=VARCHAR},\n" +
            "      cdsj_result = #{cdsjResult,jdbcType=VARCHAR},\n" +
            "      nbfd_result = #{nbfdResult,jdbcType=VARCHAR},\n" +
            "      tbms_cfresult = #{tbmsCfresult,jdbcType=VARCHAR},\n" +
            "      tbms_ycsj = #{tbmsYcsj,jdbcType=VARCHAR},\n" +
            "      tbms_sj = #{tbmsSj,jdbcType=VARCHAR},\n" +
            "      tbms_result = #{tbmsResult,jdbcType=VARCHAR},\n" +
            "      xlsz_test11 = #{xlszTest11,jdbcType=INTEGER},\n" +
            "      xlsz_test12 = #{xlszTest12,jdbcType=INTEGER},\n" +
            "      xlsz_test13 = #{xlszTest13,jdbcType=INTEGER},\n" +
            "      xlsz_value1 = #{xlszValue1,jdbcType=VARCHAR},\n" +
            "      xlsz_test21 = #{xlszTest21,jdbcType=INTEGER},\n" +
            "      xlsz_test22 = #{xlszTest22,jdbcType=INTEGER},\n" +
            "      xlsz_test23 = #{xlszTest23,jdbcType=INTEGER},\n" +
            "      xlsz_value2 = #{xlszValue2,jdbcType=VARCHAR},\n" +
            "      xlsz_test31 = #{xlszTest31,jdbcType=INTEGER},\n" +
            "      xlsz_test32 = #{xlszTest32,jdbcType=INTEGER},\n" +
            "      xlsz_test33 = #{xlszTest33,jdbcType=INTEGER},\n" +
            "      xlsz_value3 = #{xlszValue3,jdbcType=VARCHAR},\n" +
            "      xlsz_test41 = #{xlszTest41,jdbcType=INTEGER},\n" +
            "      xlsz_test42 = #{xlszTest42,jdbcType=INTEGER},\n" +
            "      xlsz_test43 = #{xlszTest43,jdbcType=INTEGER},\n" +
            "      xlsz_value4 = #{xlszValue4,jdbcType=VARCHAR},\n" +
            "      xlsz_test51 = #{xlszTest51,jdbcType=INTEGER},\n" +
            "      xlsz_test52 = #{xlszTest52,jdbcType=INTEGER},\n" +
            "      xlsz_test53 = #{xlszTest53,jdbcType=INTEGER},\n" +
            "      xlsz_value5 = #{xlszValue5,jdbcType=VARCHAR},\n" +
            "      xlsz_result = #{xlszResult,jdbcType=VARCHAR},\n" +
            "      sgbj_result = #{sgbjResult,jdbcType=VARCHAR},\n" +
            "      bjx_result = #{bjxResult,jdbcType=VARCHAR},\n" +
            "      jy_result = #{jyResult,jdbcType=VARCHAR},\n" +
            "      zxnl = #{zxnl,jdbcType=VARCHAR},\n" +
            "      zdnl = #{zdnl,jdbcType=VARCHAR}\n" +
            "      zdnl2 = #{zdnl2,jdbcType=VARCHAR}\n" +
            "    where ccy_id = #{ccyId,jdbcType=INTEGER}")
    void updateCcy(Ccy ccy);
    //根据设备id查询设备检测表
    @Select(" ccy_id, jcyq_id, eq_id, tester, auditor, test_time, shr_jcjl, shsj_time, jcjl, jcsm, \n" +
            "    sfnl_yxwc, sfnl_test1, sfnl_value1, sfnl_wc1, sfnl_test2, sfnl_value2, sfnl_wc2, \n" +
            "    sfnl_test3, sfnl_value3, sfnl_wc3, sfnl_test4, sfnl_value4, sfnl_wc4, sfnl_test5, \n" +
            "    sfnl_value5, sfnl_wc5, sfnl_test6, sfnl_value6, sfnl_wc6, sfnl_test7, sfnl_value71, \n" +
            "    sfnl_value72, sfnl_value73, sfnl_wc7, sfnl_test8, sfnl_value81, sfnl_value82, sfnl_value83, \n" +
            "    sfnl_wc8, sfnl_result, cdsj_test, cdsj_value, cdsj_result, nbfd_result, tbms_cfresult, \n" +
            "    tbms_ycsj, tbms_sj, tbms_result, xlsz_test11, xlsz_test12, xlsz_test13, xlsz_value1, \n" +
            "    xlsz_test21, xlsz_test22, xlsz_test23, xlsz_value2, xlsz_test31, xlsz_test32, xlsz_test33, \n" +
            "    xlsz_value3, xlsz_test41, xlsz_test42, xlsz_test43, xlsz_value4, xlsz_test51, xlsz_test52, \n" +
            "    xlsz_test53, xlsz_value5, xlsz_result, sgbj_result, bjx_result, jy_result, zxnl,zxnl2, zdnl, zdnl2 from ccy order by ccy_id desc limit 1 where eq_id = #{eqId}")
    public Ccy findCcy(String eqId);

    //以id排序，查询最后一条记录
    @Select("select * from Ccy order by ccy_id desc limit 1")
    Ccy find();

    //根据设备Id,检测仪器Id以及状态查询查询最后一条记录
    @Select("select * from ccy where ccy.eq_id=#{eqId} and ccy.jcyq_id=#{jcyqId} order by test_time desc, ccy_id desc limit 1" )
    Ccy findByEqIdandJcyqIdLast1(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //根据设备Id,检测仪器Id以及状态查询电器表
    @Select("select * from ccy where ccy.eq_id=#{eqId} and ccy.jcyq_id=#{jcyqId}" )
    List<Ccy> findByEqIdandJcyqId(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //查询所有检测表数据信息
    @Select("select * from ccy")
    List<Ccy> findAll();

    /**
     * 删除电器数据
     */
   /* @Delete("delete from Ccy where eq_id=#{eqId} and jcyq_id=#{jcyqId}")
    void delete(@Param("eqId")String eqId,@Param("jcyqId")String jcyqId);*/

    /**
     * 根据iD状态查询
     */
    @Select("select * from ccy where ccy_id=#{ccyId}")
    Ccy findByCcyId(@Param("ccyId") Integer ccyId);
    /*
    修改状态
     */
  /*  @Update("update dqjc set state=#{state} where dqjcid=#{dqjcid}")
    void updateState(@Param("dqjcid")Integer dqjcid,@Param("state")Integer state);*/
    //修改审核人意见
    @Update("update ccy set shr_jcjl=#{shrJcjl},auditor=#{auditor},shsj_time=#{shsjTime} where ccy_id=#{ccyId}")
    void updateShrJcjy(@Param("ccyId") Integer ccyId, @Param("shrJcjl") String shrJcjl, @Param("auditor") String auditor, @Param("shsjTime") Date shsjTime);
}
