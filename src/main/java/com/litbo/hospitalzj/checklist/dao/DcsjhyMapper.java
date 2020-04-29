package com.litbo.hospitalzj.checklist.dao;

import com.litbo.hospitalzj.checklist.domain.Dcsjhy;
import com.litbo.hospitalzj.checklist.domain.DcsjhyTemplate;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * 多参数监护仪dao层
 *
 * @author bigStone
 */
@Mapper
public interface DcsjhyMapper {

    //查询多参数监护仪模板表（成人）
    @Select("select * from dcsjhy_template_m order by dc_templateid desc limit 1")
    public DcsjhyTemplate findTemplate_m();

    //查询多参数监护仪模板表(儿童)
    @Select("select * from dcsjhy_template_c order by dc_templateid desc limit 1")
    public DcsjhyTemplate findTemplate_c();

    //查询多参数监护仪模板表(儿童)
    @Select("select * from ${tableName} wehere dc_templateid=#{dcTemplateid}")
    public DcsjhyTemplate findTemplateById(@Param("dcTemplateid") Integer dcTemplateid, @Param("tableName") String tableName);

    //修改模板表数据
    @Update("update dcsjhy_template_m\n" +
            "    set xl_test1 = #{xlTest1},\n" +
            "      xl_test2 = #{xlTest2},\n" +
            "      xl_test3 = #{xlTest3},\n" +
            "      xl_test4 = #{xlTest4},\n" +
            "      xl_test5 = #{xlTest5},\n" +
            "      xl_wc = #{xlWc},\n" +
            "      hxl_test1 = #{hxlTest1},\n" +
            "      hxl_test2 = #{hxlTest2},\n" +
            "      hxl_test3 = #{hxlTest3},\n" +
            "      hxl_test4 = #{hxlTest4},\n" +
            "      hxl_test5 = #{hxlTest5},\n" +
            "      hxl_wc = #{hxlWc},\n" +
            "      xybhd_test1 = #{xybhdTest1},\n" +
            "      xybhd_test2 = #{xybhdTest2},\n" +
            "      xybhd_test3 = #{xybhdTest3},\n" +
            "      xybhd_test4 = #{xybhdTest4},\n" +
            "      xybhd_test5 = #{xybhdTest5},\n" +
            "      xybhd_wc = #{xybhdWc},\n" +
            "      wcxy_h_test1 = #{wcxyHTest1},\n" +
            "      wcxy_l_test1 = #{wcxyLTest1},\n" +
            "      wcxy_m_test1 = #{wcxyMTest1},\n" +
            "      wcxy_h_test2 = #{wcxyHTest2},\n" +
            "      wcxy_l_test2 = #{wcxyLTest2},\n" +
            "      wcxy_m_test2 = #{wcxyMTest2},\n" +
            "      wcxy_h_test3 = #{wcxyHTest3},\n" +
            "      wcxy_l_test3 = #{wcxyLTest3},\n" +
            "      wcxy_m_test3 = #{wcxyMTest3},\n" +
            "      wcxy_h_test4 = #{wcxyHTest4},\n" +
            "      wcxy_l_test4 = #{wcxyLTest4},\n" +
            "      wcxy_m_test4 = #{wcxyMTest4},\n" +
            "      wcxy_h_test5 = #{wcxyHTest5},\n" +
            "      wcxy_l_test5 = #{wcxyLTest5},\n" +
            "      wcxy_m_test5 = #{wcxyMTest5},\n" +
            "      wcxy_wc = #{wcxyWc},\n" +
            "      wcxyjt_sd = #{wcxyjtSd},\n" +
            "      wcxyjt_wc = #{wcxyjtWc},\n" +
            "      wcxyqm_sd = #{wcxyqmSd},\n" +
            "      wcxyqm_xll_wc = #{wcxyqmXllWc}\n" +
            "    where dc_templateid = #{dcTemplateid}")
    int updateM(DcsjhyTemplate dcsjhyTemplate);

    //成人
    @Update("update dcsjhy_template_c\n" +
            "    set xl_test1 = #{xlTest1},\n" +
            "      xl_test2 = #{xlTest2},\n" +
            "      xl_test3 = #{xlTest3},\n" +
            "      xl_test4 = #{xlTest4},\n" +
            "      xl_test5 = #{xlTest5},\n" +
            "      xl_wc = #{xlWc},\n" +
            "      hxl_test1 = #{hxlTest1},\n" +
            "      hxl_test2 = #{hxlTest2},\n" +
            "      hxl_test3 = #{hxlTest3},\n" +
            "      hxl_test4 = #{hxlTest4},\n" +
            "      hxl_test5 = #{hxlTest5},\n" +
            "      hxl_wc = #{hxlWc},\n" +
            "      xybhd_test1 = #{xybhdTest1},\n" +
            "      xybhd_test2 = #{xybhdTest2},\n" +
            "      xybhd_test3 = #{xybhdTest3},\n" +
            "      xybhd_test4 = #{xybhdTest4},\n" +
            "      xybhd_test5 = #{xybhdTest5},\n" +
            "      xybhd_wc = #{xybhdWc},\n" +
            "      wcxy_h_test1 = #{wcxyHTest1},\n" +
            "      wcxy_l_test1 = #{wcxyLTest1},\n" +
            "      wcxy_m_test1 = #{wcxyMTest1},\n" +
            "      wcxy_h_test2 = #{wcxyHTest2},\n" +
            "      wcxy_l_test2 = #{wcxyLTest2},\n" +
            "      wcxy_m_test2 = #{wcxyMTest2},\n" +
            "      wcxy_h_test3 = #{wcxyHTest3},\n" +
            "      wcxy_l_test3 = #{wcxyLTest3},\n" +
            "      wcxy_m_test3 = #{wcxyMTest3},\n" +
            "      wcxy_h_test4 = #{wcxyHTest4},\n" +
            "      wcxy_l_test4 = #{wcxyLTest4},\n" +
            "      wcxy_m_test4 = #{wcxyMTest4},\n" +
            "      wcxy_h_test5 = #{wcxyHTest5},\n" +
            "      wcxy_l_test5 = #{wcxyLTest5},\n" +
            "      wcxy_m_test5 = #{wcxyMTest5},\n" +
            "      wcxy_wc = #{wcxyWc},\n" +
            "      wcxyjt_sd = #{wcxyjtSd},\n" +
            "      wcxyjt_wc = #{wcxyjtWc},\n" +
            "      wcxyqm_sd = #{wcxyqmSd},\n" +
            "      wcxyqm_xll_wc = #{wcxyqmXllWc}\n" +
            "    where dc_templateid = #{dcTemplateid}")
    int updateC(DcsjhyTemplate dcsjhyTemplate);

    //插入模板表数据
    @Insert(" insert into dcsjhy_template_m (dc_templateid, xl_test1, xl_test2, \n" +
            "      xl_test3, xl_test4, xl_test5, \n" +
            "      xl_wc, hxl_test1, hxl_test2, \n" +
            "      hxl_test3, hxl_test4, hxl_test5, \n" +
            "      hxl_wc, xybhd_test1, xybhd_test2, \n" +
            "      xybhd_test3, xybhd_test4, xybhd_test5, \n" +
            "      xybhd_wc, wcxy_h_test1, wcxy_l_test1, \n" +
            "      wcxy_m_test1, wcxy_h_test2, wcxy_l_test2, \n" +
            "      wcxy_m_test2, wcxy_h_test3, wcxy_l_test3, \n" +
            "      wcxy_m_test3, wcxy_h_test4, wcxy_l_test4, \n" +
            "      wcxy_m_test4, wcxy_h_test5, wcxy_l_test5, \n" +
            "      wcxy_m_test5, wcxy_wc, wcxyjt_sd, \n" +
            "      wcxyjt_wc, wcxyqm_sd, wcxyqm_xll_wc\n" +
            "      )\n" +
            "    values (#{dcTemplateid}, #{xlTest1}, #{xlTest2}, \n" +
            "      #{xlTest3}, #{xlTest4}, #{xlTest5}, \n" +
            "      #{xlWc}, #{hxlTest1}, #{hxlTest2}, \n" +
            "      #{hxlTest3}, #{hxlTest4}, #{hxlTest5}, \n" +
            "      #{hxlWc}, #{xybhdTest1}, #{xybhdTest2}, \n" +
            "      #{xybhdTest3}, #{xybhdTest4}, #{xybhdTest5}, \n" +
            "      #{xybhdWc}, #{wcxyHTest1}, #{wcxyLTest1}, \n" +
            "      #{wcxyMTest1}, #{wcxyHTest2}, #{wcxyLTest2}, \n" +
            "      #{wcxyMTest2}, #{wcxyHTest3}, #{wcxyLTest3}, \n" +
            "      #{wcxyMTest3}, #{wcxyHTest4}, #{wcxyLTest4}, \n" +
            "      #{wcxyMTest4}, #{wcxyHTest5}, #{wcxyLTest5}, \n" +
            "      #{wcxyMTest5}, #{wcxyWc}, #{wcxyjtSd}, \n" +
            "      #{wcxyjtWc}, #{wcxyqmSd}, #{wcxyqmXllWc}\n" +
            "      )")
    int insertM(DcsjhyTemplate dcsjhyTemplate);

    @Insert(" insert into dcsjhy_template_c (dc_templateid, xl_test1, xl_test2, \n" +
            "      xl_test3, xl_test4, xl_test5, \n" +
            "      xl_wc, hxl_test1, hxl_test2, \n" +
            "      hxl_test3, hxl_test4, hxl_test5, \n" +
            "      hxl_wc, xybhd_test1, xybhd_test2, \n" +
            "      xybhd_test3, xybhd_test4, xybhd_test5, \n" +
            "      xybhd_wc, wcxy_h_test1, wcxy_l_test1, \n" +
            "      wcxy_m_test1, wcxy_h_test2, wcxy_l_test2, \n" +
            "      wcxy_m_test2, wcxy_h_test3, wcxy_l_test3, \n" +
            "      wcxy_m_test3, wcxy_h_test4, wcxy_l_test4, \n" +
            "      wcxy_m_test4, wcxy_h_test5, wcxy_l_test5, \n" +
            "      wcxy_m_test5, wcxy_wc, wcxyjt_sd, \n" +
            "      wcxyjt_wc, wcxyqm_sd, wcxyqm_xll_wc\n" +
            "      )\n" +
            "    values (#{dcTemplateid}, #{xlTest1}, #{xlTest2}, \n" +
            "      #{xlTest3}, #{xlTest4}, #{xlTest5}, \n" +
            "      #{xlWc}, #{hxlTest1}, #{hxlTest2}, \n" +
            "      #{hxlTest3}, #{hxlTest4}, #{hxlTest5}, \n" +
            "      #{hxlWc}, #{xybhdTest1}, #{xybhdTest2}, \n" +
            "      #{xybhdTest3}, #{xybhdTest4}, #{xybhdTest5}, \n" +
            "      #{xybhdWc}, #{wcxyHTest1}, #{wcxyLTest1}, \n" +
            "      #{wcxyMTest1}, #{wcxyHTest2}, #{wcxyLTest2}, \n" +
            "      #{wcxyMTest2}, #{wcxyHTest3}, #{wcxyLTest3}, \n" +
            "      #{wcxyMTest3}, #{wcxyHTest4}, #{wcxyLTest4}, \n" +
            "      #{wcxyMTest4}, #{wcxyHTest5}, #{wcxyLTest5}, \n" +
            "      #{wcxyMTest5}, #{wcxyWc}, #{wcxyjtSd}, \n" +
            "      #{wcxyjtWc}, #{wcxyqmSd}, #{wcxyqmXllWc}\n" +
            "      )")
    int insertC(DcsjhyTemplate dcsjhyTemplate);

    //保存多参数监护仪检测表(成人)
    @Insert("insert into dcsjhy_m (dcid, jcyq_id, eq_id,tester, auditor,shsj_time, test_time,shr_jcjl,jcjl, jcsm, xl_test1,                         "
            + "xl_test2, xl_test3, xl_test4, xl_test5, xl_value1, xl_value2,  xl_value3, xl_value4, xl_value5,                         "
            + "xl_wc, xl_result, hxl_test1,  hxl_test2, hxl_test3, hxl_test4, hxl_test5, hxl_value1, hxl_value2,                       "
            + "hxl_value3, hxl_value4, hxl_value5, hxl_wc, hxl_result, xybhd_test1,xybhd_test2, xybhd_test3, xybhd_test4,              "
            + "xybhd_test5, xybhd_value1, xybhd_value2, xybhd_value3, xybhd_value4, xybhd_value5,                                      "
            + "xybhd_wc, xybhd_result, wcxy_h_test1, wcxy_m_test1, wcxy_l_test1, wcxy_h_test2,                                         "
            + "wcxy_m_test2, wcxy_l_test2, wcxy_h_test3, wcxy_m_test3, wcxy_l_test3, wcxy_h_test4,                                     "
            + "wcxy_m_test4, wcxy_l_test4, wcxy_h_test5, wcxy_m_test5, wcxy_l_test5, wcxy_h_value11,                                   "
            + "wcxy_m_value11, wcxy_l_value11, wcxy_h_value12, wcxy_m_value12, wcxy_l_value12, wcxy_h_value13,                         "
            + "wcxy_m_value13, wcxy_l_value13, wcxy_h_value14, wcxy_m_value14, wcxy_l_value14, wcxy_h_value15,                         "
            + "wcxy_m_value15, wcxy_l_value15, wcxy_h_value21,  wcxy_m_value21, wcxy_l_value21, wcxy_h_value22,                        "
            + "wcxy_m_value22, wcxy_l_value22, wcxy_h_value23,  wcxy_m_value23, wcxy_l_value23, wcxy_h_value24,                        "
            + "wcxy_m_value24, wcxy_l_value24, wcxy_h_value25,  wcxy_m_value25, wcxy_l_value25, wcxy_h_value31,                        "
            + "wcxy_m_value31, wcxy_l_value31, wcxy_h_value32, wcxy_m_value32, wcxy_l_value32, wcxy_h_value33,                         "
            + "wcxy_m_value33, wcxy_l_value33, wcxy_h_value34, wcxy_m_value34, wcxy_l_value34, wcxy_h_value35,                         "
            + "wcxy_m_value35, wcxy_l_value35, wcxy_wc, wcxy_result, wcxyjt_sd, wcxyjt_mnq, wcxyjt_jhy, wcxyjt_wc, wcxyjt_result,      "
            + "wcxyqm_sd, wcxyqm_xll, wcxyqm_wc,  wcxyqm_result, sgbj_result, bjxjc_result, jyjc_result, state, spare2,  spare3)      "
            + "values (#{dcid}, #{jcyqId}, #{eqId},                                 "
            + "#{tester}, #{auditor}, #{shsjTime},#{testTime},                                "
            + "#{shrJcjl},#{jcjl}, #{jcsm}, #{xlTest1},                                        "
            + "#{xlTest2}, #{xlTest3}, #{xlTest4},                                  "
            + "#{xlTest5}, #{xlValue1}, #{xlValue2},                                "
            + "#{xlValue3}, #{xlValue4}, #{xlValue5},                               "
            + "#{xlWc}, #{xlResult}, #{hxlTest1},                                   "
            + "#{hxlTest2}, #{hxlTest3}, #{hxlTest4},                               "
            + "#{hxlTest5}, #{hxlValue1}, #{hxlValue2},                             "
            + "#{hxlValue3}, #{hxlValue4}, #{hxlValue5},                            "
            + "#{hxlWc}, #{hxlResult}, #{xybhdTest1},                               "
            + "#{xybhdTest2}, #{xybhdTest3}, #{xybhdTest4},                         "
            + "#{xybhdTest5}, #{xybhdValue1}, #{xybhdValue2},                       "
            + "#{xybhdValue3}, #{xybhdValue4}, #{xybhdValue5},                      "
            + "#{xybhdWc}, #{xybhdResult}, #{wcxyHTest1},                           "
            + "#{wcxyMTest1}, #{wcxyLTest1}, #{wcxyHTest2},                         "
            + "#{wcxyMTest2}, #{wcxyLTest2}, #{wcxyHTest3},                         "
            + "#{wcxyMTest3}, #{wcxyLTest3}, #{wcxyHTest4},                         "
            + "#{wcxyMTest4}, #{wcxyLTest4}, #{wcxyHTest5},                         "
            + "#{wcxyMTest5}, #{wcxyLTest5}, #{wcxyHValue11},                       "
            + "#{wcxyMValue11}, #{wcxyLValue11}, #{wcxyHValue12},                   "
            + "#{wcxyMValue12}, #{wcxyLValue12}, #{wcxyHValue13},                   "
            + "#{wcxyMValue13}, #{wcxyLValue13}, #{wcxyHValue14},                   "
            + "#{wcxyMValue14}, #{wcxyLValue14}, #{wcxyHValue15},                   "
            + "#{wcxyMValue15}, #{wcxyLValue15}, #{wcxyHValue21},                   "
            + "#{wcxyMValue21}, #{wcxyLValue21}, #{wcxyHValue22},                   "
            + "#{wcxyMValue22}, #{wcxyLValue22}, #{wcxyHValue23},                   "
            + "#{wcxyMValue23}, #{wcxyLValue23}, #{wcxyHValue24},                   "
            + "#{wcxyMValue24}, #{wcxyLValue24}, #{wcxyHValue25},                   "
            + "#{wcxyMValue25}, #{wcxyLValue25}, #{wcxyHValue31},                   "
            + "#{wcxyMValue31}, #{wcxyLValue31}, #{wcxyHValue32},                   "
            + "#{wcxyMValue32}, #{wcxyLValue32}, #{wcxyHValue33},                   "
            + "#{wcxyMValue33}, #{wcxyLValue33}, #{wcxyHValue34},                   "
            + "#{wcxyMValue34}, #{wcxyLValue34}, #{wcxyHValue35},                   "
            + "#{wcxyMValue35}, #{wcxyLValue35}, #{wcxyWc},                         "
            + "#{wcxyResult}, #{wcxyjtSd}, #{wcxyjtMnq},                            "
            + "#{wcxyjtJhy}, #{wcxyjtWc}, #{wcxyjtResult},                          "
            + "#{wcxyqmSd}, #{wcxyqmXll}, #{wcxyqmWc},                              "
            + "#{wcxyqmResult}, #{sgbjResult}, #{bjxjcResult},                      "
            + "#{jyjcResult}, #{state}, #{spare2},                                 "
            + "#{spare3})")
    @Options(useGeneratedKeys = true, keyProperty = "dcid", keyColumn = "dcid")
    public void saveMan(Dcsjhy dcsjhy);

    @Update("update dcsjhy_m\n" +
            "    set jcyq_id = #{jcyqId},\n" +
            "      eq_id = #{eqId},\n" +
            "      tester = #{tester},\n" +
            "      test_time = #{testTime},\n" +
            "      auditor = #{auditor},\n" +
            "      shsj_time = #{shsjTime},\n" +
            "      shr_jcjl = #{shrJcjl},\n" +
            "      jcjl = #{jcjl},\n" +
            "      jcsm = #{jcsm},\n" +
            "      xl_test1 = #{xlTest1},\n" +
            "      xl_test2 = #{xlTest2},\n" +
            "      xl_test3 = #{xlTest3},\n" +
            "      xl_test4 = #{xlTest4},\n" +
            "      xl_test5 = #{xlTest5},\n" +
            "      xl_value1 = #{xlValue1},\n" +
            "      xl_value2 = #{xlValue2},\n" +
            "      xl_value3 = #{xlValue3},\n" +
            "      xl_value4 = #{xlValue4},\n" +
            "      xl_value5 = #{xlValue5},\n" +
            "      xl_wc = #{xlWc},\n" +
            "      xl_result = #{xlResult},\n" +
            "      hxl_test1 = #{hxlTest1},\n" +
            "      hxl_test2 = #{hxlTest2},\n" +
            "      hxl_test3 = #{hxlTest3},\n" +
            "      hxl_test4 = #{hxlTest4},\n" +
            "      hxl_test5 = #{hxlTest5},\n" +
            "      hxl_value1 = #{hxlValue1},\n" +
            "      hxl_value2 = #{hxlValue2},\n" +
            "      hxl_value3 = #{hxlValue3},\n" +
            "      hxl_value4 = #{hxlValue4},\n" +
            "      hxl_value5 = #{hxlValue5},\n" +
            "      hxl_wc = #{hxlWc},\n" +
            "      hxl_result = #{hxlResult},\n" +
            "      xybhd_test1 = #{xybhdTest1},\n" +
            "      xybhd_test2 = #{xybhdTest2},\n" +
            "      xybhd_test3 = #{xybhdTest3},\n" +
            "      xybhd_test4 = #{xybhdTest4},\n" +
            "      xybhd_test5 = #{xybhdTest5},\n" +
            "      xybhd_value1 = #{xybhdValue1},\n" +
            "      xybhd_value2 = #{xybhdValue2},\n" +
            "      xybhd_value3 = #{xybhdValue3},\n" +
            "      xybhd_value4 = #{xybhdValue4},\n" +
            "      xybhd_value5 = #{xybhdValue5},\n" +
            "      xybhd_wc = #{xybhdWc},\n" +
            "      xybhd_result = #{xybhdResult},\n" +
            "      wcxy_h_test1 = #{wcxyHTest1},\n" +
            "      wcxy_m_test1 = #{wcxyMTest1},\n" +
            "      wcxy_l_test1 = #{wcxyLTest1},\n" +
            "      wcxy_h_test2 = #{wcxyHTest2},\n" +
            "      wcxy_m_test2 = #{wcxyMTest2},\n" +
            "      wcxy_l_test2 = #{wcxyLTest2},\n" +
            "      wcxy_h_test3 = #{wcxyHTest3},\n" +
            "      wcxy_m_test3 = #{wcxyMTest3},\n" +
            "      wcxy_l_test3 = #{wcxyLTest3},\n" +
            "      wcxy_h_test4 = #{wcxyHTest4},\n" +
            "      wcxy_m_test4 = #{wcxyMTest4},\n" +
            "      wcxy_l_test4 = #{wcxyLTest4},\n" +
            "      wcxy_h_test5 = #{wcxyHTest5},\n" +
            "      wcxy_m_test5 = #{wcxyMTest5},\n" +
            "      wcxy_l_test5 = #{wcxyLTest5},\n" +
            "      wcxy_h_value11 = #{wcxyHValue11},\n" +
            "      wcxy_m_value11 = #{wcxyMValue11},\n" +
            "      wcxy_l_value11 = #{wcxyLValue11},\n" +
            "      wcxy_h_value12 = #{wcxyHValue12},\n" +
            "      wcxy_m_value12 = #{wcxyMValue12},\n" +
            "      wcxy_l_value12 = #{wcxyLValue12},\n" +
            "      wcxy_h_value13 = #{wcxyHValue13},\n" +
            "      wcxy_m_value13 = #{wcxyMValue13},\n" +
            "      wcxy_l_value13 = #{wcxyLValue13},\n" +
            "      wcxy_h_value14 = #{wcxyHValue14},\n" +
            "      wcxy_m_value14 = #{wcxyMValue14},\n" +
            "      wcxy_l_value14 = #{wcxyLValue14},\n" +
            "      wcxy_h_value15 = #{wcxyHValue15},\n" +
            "      wcxy_m_value15 = #{wcxyMValue15},\n" +
            "      wcxy_l_value15 = #{wcxyLValue15},\n" +
            "      wcxy_h_value21 = #{wcxyHValue21},\n" +
            "      wcxy_m_value21 = #{wcxyMValue21},\n" +
            "      wcxy_l_value21 = #{wcxyLValue21},\n" +
            "      wcxy_h_value22 = #{wcxyHValue22},\n" +
            "      wcxy_m_value22 = #{wcxyMValue22},\n" +
            "      wcxy_l_value22 = #{wcxyLValue22},\n" +
            "      wcxy_h_value23 = #{wcxyHValue23},\n" +
            "      wcxy_m_value23 = #{wcxyMValue23},\n" +
            "      wcxy_l_value23 = #{wcxyLValue23},\n" +
            "      wcxy_h_value24 = #{wcxyHValue24},\n" +
            "      wcxy_m_value24 = #{wcxyMValue24},\n" +
            "      wcxy_l_value24 = #{wcxyLValue24},\n" +
            "      wcxy_h_value25 = #{wcxyHValue25},\n" +
            "      wcxy_m_value25 = #{wcxyMValue25},\n" +
            "      wcxy_l_value25 = #{wcxyLValue25},\n" +
            "      wcxy_h_value31 = #{wcxyHValue31},\n" +
            "      wcxy_m_value31 = #{wcxyMValue31},\n" +
            "      wcxy_l_value31 = #{wcxyLValue31},\n" +
            "      wcxy_h_value32 = #{wcxyHValue32},\n" +
            "      wcxy_m_value32 = #{wcxyMValue32},\n" +
            "      wcxy_l_value32 = #{wcxyLValue32},\n" +
            "      wcxy_h_value33 = #{wcxyHValue33},\n" +
            "      wcxy_m_value33 = #{wcxyMValue33},\n" +
            "      wcxy_l_value33 = #{wcxyLValue33},\n" +
            "      wcxy_h_value34 = #{wcxyHValue34},\n" +
            "      wcxy_m_value34 = #{wcxyMValue34},\n" +
            "      wcxy_l_value34 = #{wcxyLValue34},\n" +
            "      wcxy_h_value35 = #{wcxyHValue35},\n" +
            "      wcxy_m_value35 = #{wcxyMValue35},\n" +
            "      wcxy_l_value35 = #{wcxyLValue35},\n" +
            "      wcxy_wc = #{wcxyWc},\n" +
            "      wcxy_result = #{wcxyResult},\n" +
            "      wcxyjt_sd = #{wcxyjtSd},\n" +
            "      wcxyjt_mnq = #{wcxyjtMnq},\n" +
            "      wcxyjt_jhy = #{wcxyjtJhy},\n" +
            "      wcxyjt_wc = #{wcxyjtWc},\n" +
            "      wcxyjt_result = #{wcxyjtResult},\n" +
            "      wcxyqm_sd = #{wcxyqmSd},\n" +
            "      wcxyqm_xll = #{wcxyqmXll},\n" +
            "      wcxyqm_wc = #{wcxyqmWc},\n" +
            "      wcxyqm_result = #{wcxyqmResult},\n" +
            "      sgbj_result = #{sgbjResult},\n" +
            "      bjxjc_result = #{bjxjcResult},\n" +
            "      jyjc_result = #{jyjcResult},\n" +
            "      state = #{state},\n" +
            "      spare2 = #{spare2},\n" +
            "      spare3 = #{spare3}\n" +
            "    where dcid = #{dcid}")
    public void updateMen(Dcsjhy dcsjhy);

    //保存多参数监护仪检测表(幼儿)
    @Insert("insert into dcsjhy_c (dcid, jcyq_id, eq_id,tester, auditor, shsj_time,test_time,shr_jcjl, jcjl, jcsm, xl_test1,                         "
            + "xl_test2, xl_test3, xl_test4, xl_test5, xl_value1, xl_value2,  xl_value3, xl_value4, xl_value5,                         "
            + "xl_wc, xl_result, hxl_test1,  hxl_test2, hxl_test3, hxl_test4, hxl_test5, hxl_value1, hxl_value2,                       "
            + "hxl_value3, hxl_value4, hxl_value5, hxl_wc, hxl_result, xybhd_test1,xybhd_test2, xybhd_test3, xybhd_test4,              "
            + "xybhd_test5, xybhd_value1, xybhd_value2, xybhd_value3, xybhd_value4, xybhd_value5,                                      "
            + "xybhd_wc, xybhd_result, wcxy_h_test1, wcxy_m_test1, wcxy_l_test1, wcxy_h_test2,                                         "
            + "wcxy_m_test2, wcxy_l_test2, wcxy_h_test3, wcxy_m_test3, wcxy_l_test3, wcxy_h_test4,                                     "
            + "wcxy_m_test4, wcxy_l_test4, wcxy_h_test5, wcxy_m_test5, wcxy_l_test5, wcxy_h_value11,                                   "
            + "wcxy_m_value11, wcxy_l_value11, wcxy_h_value12, wcxy_m_value12, wcxy_l_value12, wcxy_h_value13,                         "
            + "wcxy_m_value13, wcxy_l_value13, wcxy_h_value14, wcxy_m_value14, wcxy_l_value14, wcxy_h_value15,                         "
            + "wcxy_m_value15, wcxy_l_value15, wcxy_h_value21,  wcxy_m_value21, wcxy_l_value21, wcxy_h_value22,                        "
            + "wcxy_m_value22, wcxy_l_value22, wcxy_h_value23,  wcxy_m_value23, wcxy_l_value23, wcxy_h_value24,                        "
            + "wcxy_m_value24, wcxy_l_value24, wcxy_h_value25,  wcxy_m_value25, wcxy_l_value25, wcxy_h_value31,                        "
            + "wcxy_m_value31, wcxy_l_value31, wcxy_h_value32, wcxy_m_value32, wcxy_l_value32, wcxy_h_value33,                         "
            + "wcxy_m_value33, wcxy_l_value33, wcxy_h_value34, wcxy_m_value34, wcxy_l_value34, wcxy_h_value35,                         "
            + "wcxy_m_value35, wcxy_l_value35, wcxy_wc, wcxy_result, wcxyjt_sd, wcxyjt_mnq, wcxyjt_jhy, wcxyjt_wc, wcxyjt_result,      "
            + "wcxyqm_sd, wcxyqm_xll, wcxyqm_wc,  wcxyqm_result, sgbj_result, bjxjc_result, jyjc_result, state, spare2,  spare3)      "
            + "values (#{dcid}, #{jcyqId}, #{eqId},                                 "
            + "#{tester}, #{auditor}, #{shsjTime},#{testTime},                                "
            + "#{shrJcjl},#{jcjl}, #{jcsm}, #{xlTest1},                                        "
            + "#{xlTest2}, #{xlTest3}, #{xlTest4},                                  "
            + "#{xlTest5}, #{xlValue1}, #{xlValue2},                                "
            + "#{xlValue3}, #{xlValue4}, #{xlValue5},                               "
            + "#{xlWc}, #{xlResult}, #{hxlTest1},                                   "
            + "#{hxlTest2}, #{hxlTest3}, #{hxlTest4},                               "
            + "#{hxlTest5}, #{hxlValue1}, #{hxlValue2},                             "
            + "#{hxlValue3}, #{hxlValue4}, #{hxlValue5},                            "
            + "#{hxlWc}, #{hxlResult}, #{xybhdTest1},                               "
            + "#{xybhdTest2}, #{xybhdTest3}, #{xybhdTest4},                         "
            + "#{xybhdTest5}, #{xybhdValue1}, #{xybhdValue2},                       "
            + "#{xybhdValue3}, #{xybhdValue4}, #{xybhdValue5},                      "
            + "#{xybhdWc}, #{xybhdResult}, #{wcxyHTest1},                           "
            + "#{wcxyMTest1}, #{wcxyLTest1}, #{wcxyHTest2},                         "
            + "#{wcxyMTest2}, #{wcxyLTest2}, #{wcxyHTest3},                         "
            + "#{wcxyMTest3}, #{wcxyLTest3}, #{wcxyHTest4},                         "
            + "#{wcxyMTest4}, #{wcxyLTest4}, #{wcxyHTest5},                         "
            + "#{wcxyMTest5}, #{wcxyLTest5}, #{wcxyHValue11},                       "
            + "#{wcxyMValue11}, #{wcxyLValue11}, #{wcxyHValue12},                   "
            + "#{wcxyMValue12}, #{wcxyLValue12}, #{wcxyHValue13},                   "
            + "#{wcxyMValue13}, #{wcxyLValue13}, #{wcxyHValue14},                   "
            + "#{wcxyMValue14}, #{wcxyLValue14}, #{wcxyHValue15},                   "
            + "#{wcxyMValue15}, #{wcxyLValue15}, #{wcxyHValue21},                   "
            + "#{wcxyMValue21}, #{wcxyLValue21}, #{wcxyHValue22},                   "
            + "#{wcxyMValue22}, #{wcxyLValue22}, #{wcxyHValue23},                   "
            + "#{wcxyMValue23}, #{wcxyLValue23}, #{wcxyHValue24},                   "
            + "#{wcxyMValue24}, #{wcxyLValue24}, #{wcxyHValue25},                   "
            + "#{wcxyMValue25}, #{wcxyLValue25}, #{wcxyHValue31},                   "
            + "#{wcxyMValue31}, #{wcxyLValue31}, #{wcxyHValue32},                   "
            + "#{wcxyMValue32}, #{wcxyLValue32}, #{wcxyHValue33},                   "
            + "#{wcxyMValue33}, #{wcxyLValue33}, #{wcxyHValue34},                   "
            + "#{wcxyMValue34}, #{wcxyLValue34}, #{wcxyHValue35},                   "
            + "#{wcxyMValue35}, #{wcxyLValue35}, #{wcxyWc},                         "
            + "#{wcxyResult}, #{wcxyjtSd}, #{wcxyjtMnq},                            "
            + "#{wcxyjtJhy}, #{wcxyjtWc}, #{wcxyjtResult},                          "
            + "#{wcxyqmSd}, #{wcxyqmXll}, #{wcxyqmWc},                              "
            + "#{wcxyqmResult}, #{sgbjResult}, #{bjxjcResult},                      "
            + "#{jyjcResult}, #{state}, #{spare2},                                 "
            + "#{spare3})")
    @Options(useGeneratedKeys = true, keyProperty = "dcid", keyColumn = "dcid")
    public void saveChild(Dcsjhy dcsjhy);

    @Update("update dcsjhy_c\n" +
            "    set jcyq_id = #{jcyqId},\n" +
            "      eq_id = #{eqId},\n" +
            "      tester = #{tester},\n" +
            "      test_time = #{testTime},\n" +
            "      auditor = #{auditor},\n" +
            "      shsj_time = #{shsjTime},\n" +
            "      shr_jcjl = #{shrJcjl},\n" +
            "      jcjl = #{jcjl},\n" +
            "      jcsm = #{jcsm},\n" +
            "      xl_test1 = #{xlTest1},\n" +
            "      xl_test2 = #{xlTest2},\n" +
            "      xl_test3 = #{xlTest3},\n" +
            "      xl_test4 = #{xlTest4},\n" +
            "      xl_test5 = #{xlTest5},\n" +
            "      xl_value1 = #{xlValue1},\n" +
            "      xl_value2 = #{xlValue2},\n" +
            "      xl_value3 = #{xlValue3},\n" +
            "      xl_value4 = #{xlValue4},\n" +
            "      xl_value5 = #{xlValue5},\n" +
            "      xl_wc = #{xlWc},\n" +
            "      xl_result = #{xlResult},\n" +
            "      hxl_test1 = #{hxlTest1},\n" +
            "      hxl_test2 = #{hxlTest2},\n" +
            "      hxl_test3 = #{hxlTest3},\n" +
            "      hxl_test4 = #{hxlTest4},\n" +
            "      hxl_test5 = #{hxlTest5},\n" +
            "      hxl_value1 = #{hxlValue1},\n" +
            "      hxl_value2 = #{hxlValue2},\n" +
            "      hxl_value3 = #{hxlValue3},\n" +
            "      hxl_value4 = #{hxlValue4},\n" +
            "      hxl_value5 = #{hxlValue5},\n" +
            "      hxl_wc = #{hxlWc},\n" +
            "      hxl_result = #{hxlResult},\n" +
            "      xybhd_test1 = #{xybhdTest1},\n" +
            "      xybhd_test2 = #{xybhdTest2},\n" +
            "      xybhd_test3 = #{xybhdTest3},\n" +
            "      xybhd_test4 = #{xybhdTest4},\n" +
            "      xybhd_test5 = #{xybhdTest5},\n" +
            "      xybhd_value1 = #{xybhdValue1},\n" +
            "      xybhd_value2 = #{xybhdValue2},\n" +
            "      xybhd_value3 = #{xybhdValue3},\n" +
            "      xybhd_value4 = #{xybhdValue4},\n" +
            "      xybhd_value5 = #{xybhdValue5},\n" +
            "      xybhd_wc = #{xybhdWc},\n" +
            "      xybhd_result = #{xybhdResult},\n" +
            "      wcxy_h_test1 = #{wcxyHTest1},\n" +
            "      wcxy_m_test1 = #{wcxyMTest1},\n" +
            "      wcxy_l_test1 = #{wcxyLTest1},\n" +
            "      wcxy_h_test2 = #{wcxyHTest2},\n" +
            "      wcxy_m_test2 = #{wcxyMTest2},\n" +
            "      wcxy_l_test2 = #{wcxyLTest2},\n" +
            "      wcxy_h_test3 = #{wcxyHTest3},\n" +
            "      wcxy_m_test3 = #{wcxyMTest3},\n" +
            "      wcxy_l_test3 = #{wcxyLTest3},\n" +
            "      wcxy_h_test4 = #{wcxyHTest4},\n" +
            "      wcxy_m_test4 = #{wcxyMTest4},\n" +
            "      wcxy_l_test4 = #{wcxyLTest4},\n" +
            "      wcxy_h_test5 = #{wcxyHTest5},\n" +
            "      wcxy_m_test5 = #{wcxyMTest5},\n" +
            "      wcxy_l_test5 = #{wcxyLTest5},\n" +
            "      wcxy_h_value11 = #{wcxyHValue11},\n" +
            "      wcxy_m_value11 = #{wcxyMValue11},\n" +
            "      wcxy_l_value11 = #{wcxyLValue11},\n" +
            "      wcxy_h_value12 = #{wcxyHValue12},\n" +
            "      wcxy_m_value12 = #{wcxyMValue12},\n" +
            "      wcxy_l_value12 = #{wcxyLValue12},\n" +
            "      wcxy_h_value13 = #{wcxyHValue13},\n" +
            "      wcxy_m_value13 = #{wcxyMValue13},\n" +
            "      wcxy_l_value13 = #{wcxyLValue13},\n" +
            "      wcxy_h_value14 = #{wcxyHValue14},\n" +
            "      wcxy_m_value14 = #{wcxyMValue14},\n" +
            "      wcxy_l_value14 = #{wcxyLValue14},\n" +
            "      wcxy_h_value15 = #{wcxyHValue15},\n" +
            "      wcxy_m_value15 = #{wcxyMValue15},\n" +
            "      wcxy_l_value15 = #{wcxyLValue15},\n" +
            "      wcxy_h_value21 = #{wcxyHValue21},\n" +
            "      wcxy_m_value21 = #{wcxyMValue21},\n" +
            "      wcxy_l_value21 = #{wcxyLValue21},\n" +
            "      wcxy_h_value22 = #{wcxyHValue22},\n" +
            "      wcxy_m_value22 = #{wcxyMValue22},\n" +
            "      wcxy_l_value22 = #{wcxyLValue22},\n" +
            "      wcxy_h_value23 = #{wcxyHValue23},\n" +
            "      wcxy_m_value23 = #{wcxyMValue23},\n" +
            "      wcxy_l_value23 = #{wcxyLValue23},\n" +
            "      wcxy_h_value24 = #{wcxyHValue24},\n" +
            "      wcxy_m_value24 = #{wcxyMValue24},\n" +
            "      wcxy_l_value24 = #{wcxyLValue24},\n" +
            "      wcxy_h_value25 = #{wcxyHValue25},\n" +
            "      wcxy_m_value25 = #{wcxyMValue25},\n" +
            "      wcxy_l_value25 = #{wcxyLValue25},\n" +
            "      wcxy_h_value31 = #{wcxyHValue31},\n" +
            "      wcxy_m_value31 = #{wcxyMValue31},\n" +
            "      wcxy_l_value31 = #{wcxyLValue31},\n" +
            "      wcxy_h_value32 = #{wcxyHValue32},\n" +
            "      wcxy_m_value32 = #{wcxyMValue32},\n" +
            "      wcxy_l_value32 = #{wcxyLValue32},\n" +
            "      wcxy_h_value33 = #{wcxyHValue33},\n" +
            "      wcxy_m_value33 = #{wcxyMValue33},\n" +
            "      wcxy_l_value33 = #{wcxyLValue33},\n" +
            "      wcxy_h_value34 = #{wcxyHValue34},\n" +
            "      wcxy_m_value34 = #{wcxyMValue34},\n" +
            "      wcxy_l_value34 = #{wcxyLValue34},\n" +
            "      wcxy_h_value35 = #{wcxyHValue35},\n" +
            "      wcxy_m_value35 = #{wcxyMValue35},\n" +
            "      wcxy_l_value35 = #{wcxyLValue35},\n" +
            "      wcxy_wc = #{wcxyWc},\n" +
            "      wcxy_result = #{wcxyResult},\n" +
            "      wcxyjt_sd = #{wcxyjtSd},\n" +
            "      wcxyjt_mnq = #{wcxyjtMnq},\n" +
            "      wcxyjt_jhy = #{wcxyjtJhy},\n" +
            "      wcxyjt_wc = #{wcxyjtWc},\n" +
            "      wcxyjt_result = #{wcxyjtResult},\n" +
            "      wcxyqm_sd = #{wcxyqmSd},\n" +
            "      wcxyqm_xll = #{wcxyqmXll},\n" +
            "      wcxyqm_wc = #{wcxyqmWc},\n" +
            "      wcxyqm_result = #{wcxyqmResult},\n" +
            "      sgbj_result = #{sgbjResult},\n" +
            "      bjxjc_result = #{bjxjcResult},\n" +
            "      jyjc_result = #{jyjcResult},\n" +
            "      state = #{state},\n" +
            "      spare2 = #{spare2},\n" +
            "      spare3 = #{spare3}\n" +
            "    where dcid = #{dcid}")
    public void updateChild(Dcsjhy dcsjhy);


    //根据设备Id,检测仪器Id以及状态查询最后一条记录
    @Select("select * from ${tableName} where eq_id=#{eqId} and jcyq_id=#{jcyqId} order by test_time desc, dcid desc limit 1")
    Dcsjhy findByEqIdandJcyqIdLast(@Param("tableName") String tableName, @Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //根据设备Id,检测仪器Id以及状态查询
    @Select("select * from ${tableName} where eq_id=#{eqId} and jcyq_id=#{jcyqId}")
    List<Dcsjhy> findByEqIdandJcyqId(@Param("tableName") String tableName, @Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    /*@Select("select * from dcsjhy_m order by dcid desc limit 1")
    Dcsjhy findDcsjhyMan();
    @Select("select * from dcsjhy_m where eq_id=#{eqId} and jcyq_id=#{jcyqId}")
    List<Dcsjhy> findByEqIdandJcyqIdMan(@Param("eqId")String eqId,@Param("jcyqId")String jcyqId);
    //查询多参数监护仪检测单条数据（幼儿）
    @Select("select * from dcsjhy_c order by dcid desc limit 1")
    Dcsjhy findDcsjhyChild();
    @Select("select d.* from dcsjhy_c d where eq_id=#{eqId} and jcyq_id=#{jcyqId}")
    List<Dcsjhy>  findByEqIdandJcyqIdCh(@Param("eqId")String eqId,@Param("jcyqId")String jcyqId);*/
    //查询多参数监护仪检测单条数据（成人）
    @Select("select * from dcsjhy_m")
    List<Dcsjhy> findDcsjhyMans();

    //查询多参数监护仪检测单条数据（幼儿）
    @Select("select * from dcsjhy_c")
    List<Dcsjhy> findDcsjhyChilds();

    //删除数据
    @Delete("delete from dcsjhy_m where eq_id=#{eqId} and jcyq_id=#{jcyqId}")
    void delectMen(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    @Delete("delete from dcsjhy_c where eq_id=#{eqId} and jcyq_id=#{jcyqId}")
    void delectChi(@Param("eqId") String eqId, @Param("jcyqId") String jcyqId);

    //修改状态
    @Update("update dcsjhy_m set state=#{state} where dcid=#{dcid}")
    void updateStateM(@Param("dcid") Integer dcid, @Param("state") Integer state);

    @Update("update dcsjhy_c set state=#{state} where dcid=#{dcid}")
    void updateStateC(@Param("dcid") Integer dcid, @Param("state") Integer state);

    //根据id查询
    @Select("select * from dcsjhy_m where dcid=#{dcid}")
    Dcsjhy findByDcidM(@Param("dcid") Integer dcid);

    @Select("select * from dcsjhy_c where dcid=#{dcid}")
    Dcsjhy findByDcidC(@Param("dcid") Integer dcid);

    //修改审核人意见
    @Update("update dcsjhy_m set shr_jcjl=#{shrJcjl},auditor=#{auditor},shsj_time=#{shsjTime} where dcid=#{dcid}")
    void updateShrJcjyM(@Param("dcid") Integer dcid, @Param("shrJcjl") String shrJcjl, @Param("auditor") String auditor, @Param("shsjTime") Date shsjTime);

    @Update("update dcsjhy_c set shr_jcjl=#{shrJcjl},auditor=#{auditor},shsj_time=#{shsjTime} where dqjcid=#{dqjcid}")
    void updateShrJcjyC(@Param("dcid") Integer dcid, @Param("shrJcjl") String shrJcjl, @Param("auditor") String auditor, @Param("shsjTime") Date shsjTime);

    //根据设备id和检测仪器id查询出最后一条检测数据
    //现在默认查的为成人，（后续要区分成人和新生儿）
    @Select("select * from dcsjhy_m where eq_id = #{eq_id} and jcyq_id = #{jcyqId} order by test_time desc , dcid desc limit 1 ")
    Dcsjhy findByEqIdandJcyqId1(String eqId, String jcyqId);
}