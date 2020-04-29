 package com.litbo.hospitalzj.supplier.mapper;

 import com.litbo.hospitalzj.supplier.entity.District;
 import com.litbo.hospitalzj.supplier.entity.HtInfo;
 import com.litbo.hospitalzj.supplier.vo.EqHtVo;
 import org.apache.ibatis.annotations.*;

 import java.util.List;

 @Mapper
 public interface HtInfoMapper {
     //插入合同
     @Insert("insert into ht_info(ht_id,ht_ghsn,ht_ghslxr,email,ht_ghsdh,ht_hthao,ht_gzspd,ht_zhbhao,ht_bz,ht_qytime,ht_dhtime,ht_bxtime,"
             + "ht_syks,ht_azdd,ht_ly,ht_cgfs,ht_sglb,ht_sbyt,ht_jfly"
             + ",ht_state,ht_yzm,sbcs_id,ht_yssj,ht_ysbz,ht_zje,ht_ysy_dh, ht_jedw) value "
             + "(#{htId},#{htGhsn},#{htGhslxr},#{email},#{htGhsdh},#{htHthao},#{htGzspd},#{htZhbhao},#{htBz},#{htQytime},#{htDhtime},#{htBxtime},"
             + "#{htSyks},#{htAzdd},#{htLy},#{htCgfs},#{htSglb},#{htSbyt},#{htJfly},#{htState},#{htYzm},#{sbcsId},#{htYssj},#{htYsbz},#{htZje},#{htYsyDh},#{htJedw})")
     @Options(useGeneratedKeys = true, keyProperty = "htId", keyColumn = "ht_id")
     Integer insertHt(HtInfo htInfo);
     //修改合同状态
     @Update("UPDATE ht_info SET ht_yzm=#{htYzm},ht_state=#{htState}, now_time=#{format} where ht_id=#{htId}")
     Integer updateYzm(@Param("htId") Integer htId, @Param("htYzm") String htYzm, @Param("htState") String htState, @Param("format") String format);
     //修改合通信息
     @Update("UPDATE ht_info SET ht_ghslxr=#{htGhslxr},email=#{email},ht_hthao=#{htHthao},ht_ghsdh=#{htGhsdh},ht_zhbhao=#{htZhbhao},"
             + "ht_bz=#{htBz},ht_qytime=#{htQytime},ht_dhtime=#{htDhtime},"
             + "ht_bxtime=#{htBxtime},ht_syks=#{htSyks},ht_azdd=#{htAzdd},ht_ly=#{htLy},ht_cgfs=#{htCgfs},"
             + "ht_sglb=#{htSglb},ht_sbyt=#{htSbyt},ht_jfly=#{htJfly},"
             + "ht_zje=#{htZje},ht_State=#{htState} "
             + "where ht_id=#{htId}")
     void updateInfo(HtInfo htinfo);
     //通过供应商iD查询合同
     @Select("select ht_id htId,ht_ghsn htGhsn,ht_ghslxr htGhslxr,email,ht_ghsdh htGhsdh,ht_ghsdh htGhsdh,IFNULL(ht_hthao,'无') htHthao,IFNULL(ht_gzspd,'无') htGzspd,"
             + "ht_zhbhao htZhbhao,ht_bz htBz,ht_qytime htQytime,ht_dhtime htDhtime,ht_bxtime htBxtime,"
             + "ht_syks htSyks,ht_azdd htAzdd,ht_ly htLy,ht_cgfs htCgfs,ht_sglb htSglb,ht_sbyt htSbyt,"
             + "ht_jfly htJfly,ht_zje htZje,ht_state htState,ht_yzm htYzm,sbcs_id sbcdId,ht_yssj htYssj,"
             + "ht_ysbz htYsbz, now_time nowTime ,azgcsqm_time azgcsqmTime , tyys_time tyysTime , wszl_time wszlTime , ht_jedw htJedw from ht_info where sbcs_id=#{sbcsId}")
     List<HtInfo> findBySbcsId(Integer sbcsId);
     //通过合同id查询合同信息
     @Select("select ht_id htId,ht_ghsn htGhsn,ht_ghslxr htGhslxr,email,ht_ghsdh htGhsdh,ht_ghsdh htGhsdh,IFNULL(ht_hthao,'无') htHthao,IFNULL(ht_gzspd,'无') htGzspd,"
             + "IFNULL(ht_zhbhao,'无') htZhbhao,ht_bz htBz,ht_qytime htQytime,ht_dhtime htDhtime,ht_bxtime htBxtime,"
             + "ht_syks htSyks,ht_azdd htAzdd,ht_ly htLy,ht_cgfs htCgfs,ht_sglb htSglb,ht_sbyt htSbyt,"
             + "ht_jfly htJfly,ht_zje htZje,ht_state htState,ht_yzm htYzm,sbcs_id sbcdId,ht_yssj htYssj,"
             + "ht_ysbz htYsbz,ht_ysy_dh htYsyDh,ht_gysqm htGysqm, ht_azgcsqm htAzgcsqm, ht_ysrqm htYsrqm, now_time nowTime , tyys_time tyysTime , wszl_time wszlTime , azgcsqm_time azgcsqmTime , ht_jedw htJedw from ht_info where ht_id=#{htId}")
     HtInfo findByHtId(Integer htId);
     //通过验证码查询合同
     @Select("select ht_id htId,ht_ghsn htGhsn,ht_ghslxr htGhslxr,email,ht_ghsdh htGhsdh,IFNULL(ht_hthao,'无')  htHthao,IFNULL(ht_gzspd,'无') htGzspd,IFNULL(ht_zhbhao,'无') htZhbhao,"
             + "ht_bz htBz,ht_qytime htQytime,ht_dhtime htDhtime,ht_bxtime htBxtime,ht_syks htSyks,ht_azdd htAzdd,ht_ly htLy,ht_cgfs htCgfs,ht_sglb htSglb,ht_sbyt htSbyt,"
             + "ht_jfly htJfly,ht_zje htZje,ht_state htState,ht_yzm htYzm,sbcs_id sbcdId,ht_yssj htYssj,ht_ysbz htYsbz, now_time nowTime, azgcsqm_time azgcsqmTime , ht_jedw htJedw from ht_info where ht_yzm=#{htYzm}")
     HtInfo findByHtYzm(@Param("htYzm") String htYzm);
     //通过验证码查询存在的合同以及设备信息
     @Select("select ht_ids htIds,ht_hthao htHthao,eq_pm eqPm,eq_gg eqGg,eq_xh eqXh,ht_qytime htQytime,ht_state htState,ht_yzm htYzm from ht_info inner join eq_info on ht_info.ht_id=eq_info.ht_ids where ht_yzm=#{htYzm}")
     List<EqHtVo> EqHtVo(String htYzm);
     //通过状态查询合同信息
     @Select("select ht_id ,ht_ghsn ,ht_ghslxr ,email,ht_ghsdh ,ht_ghsdh ,IFNULL(ht_hthao,'无') ht_hthao,IFNULL(ht_gzspd,'无') ht_gzspd,"
             + "IFNULL(ht_zhbhao,'无') htZhbhao,ht_bz ,ht_qytime ,ht_dhtime ,ht_bxtime ,"
             + "ht_syks ,ht_azdd ,ht_ly ,ht_cgfs ,ht_sglb ,ht_sbyt ,"
             + "ht_zje htZje,ht_state ,ht_yzm ,sbcs_id ,ht_yssj ,"
             + "ht_ysbz, now_time nowTime, azgcsqm_time azgcsqmTime , tyys_time tyysTime , wszl_time wszlTime, ht_jedw htJedw from ht_info where ht_state=#{state}")
     List<HtInfo> findAll(String state);

     @Update("UPDATE ht_info SET ht_State=#{htState},ht_bz =#{yy},ht_yssj=#{date}, ht_ysy_dh=#{htYsyDh} where ht_id=#{htId}")
     int updateState(@Param("htId") Integer htId, @Param("yy") String yy, @Param("date") String date, @Param("htState") String htState, @Param("htYsyDh") String htYsyDh);
     //通过合同id修改合同状态
     @Update("UPDATE ht_info SET ht_State=#{htState} where ht_id=#{htId}")
     int updateStateById(@Param("htId") Integer htId, @Param("htState") String htState);
     //查询状态数量
     @Select("select count(*) from ht_info where ht_State=#{htState}")
     int count(@Param("htState") String htState);

     //根据父id查询省份列表
     @Select("select * from t_dict_district where parent = #{parent}")
     List<District> findProvinceByParentId(String parent);

     void saveqmAndState(String htId, String img);

     @Update("update ht_info set ht_gysqm=#{img} where ht_id=#{htId}")
     void saveqm1(@Param("htId")String htId, @Param("img")String img);

     @Update("update ht_info set ht_azgcsqm=#{img}, azgcsqm_time=#{format} where ht_id=#{htId}")
     void saveqm2(@Param("htId")String htId, @Param("img")String img, @Param("format")String format);

     @Update("update ht_info set ht_ysrqm=#{img}, ht_state='完善资料' where ht_id=#{htId}")
     void saveqm3(@Param("htId")String htId, @Param("img")String img);

     @Update("UPDATE ht_info SET ht_State=#{message}, tyys_time=#{format} where ht_id=#{htId}")
     void updateHtInfoStateAndTime(@Param("htId") Integer htId, @Param("format")String format, @Param("message")String message);

     @Update("UPDATE ht_info SET ht_State=#{message}, wszl_time=#{format} where ht_id=#{htId}")
     void updateHtInfoStateAndwsTime(@Param("htId") Integer htId, @Param("format")String format, @Param("message")String message);

     @Select("select ht_id ,ht_ghsn ,ht_ghslxr ,email,ht_ghsdh ,ht_ghsdh ,IFNULL(ht_hthao,'无') ht_hthao,IFNULL(ht_gzspd,'无') ht_gzspd,"
             + "IFNULL(ht_zhbhao,'无') ht_zhbhao ,ht_bz ,ht_qytime ,ht_dhtime ,ht_bxtime ,"
             + "ht_syks ,ht_azdd ,ht_ly ,ht_cgfs ,ht_sglb ,ht_sbyt ,"
             + "ht_zje htZje,ht_state ,ht_yzm ,sbcs_id ,ht_yssj ,ht_jfly ,"
             + "ht_ysbz, now_time nowTime, azgcsqm_time azgcsqmTime , tyys_time tyysTime , wszl_time wszlTime, " +
             "ht_jedw htJedw from ht_info where ht_ghsn=#{suMc} and ht_state = '0' ")
     List<HtInfo> findBySuMc(String suMc);

     @Update("update ht_info set ht_state='1' where ht_id=#{htId}")
     void deleteById(String htId);
     /*//查询一个合同中全部设备以及附件*/

 }
