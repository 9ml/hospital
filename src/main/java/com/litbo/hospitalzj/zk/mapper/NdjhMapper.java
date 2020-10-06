package com.litbo.hospitalzj.zk.mapper;

import com.litbo.hospitalzj.zk.domian.Ndjh;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 年度计划持久层
 */
@Mapper
public interface NdjhMapper {
    @Insert("   insert into ndjh (ndjh_id, eq_pm_id, eq_pm_name, \n" +
            "      user_id, user_name, ndjh_sbsj, \n" +
            "      ndjh_sbsl, ndjh_dtsj, ndjh_jhl, \n" +
            "      ndjh_1yfjh, ndjh_1sj, ndjh_2yfjh, \n" +
            "      ndjh_2sj, ndjh_3yfjh, ndjh_3sj, \n" +
            "      ndjh_4yfjh, ndjh_4sj, ndjh_5yfjh, \n" +
            "      ndjh_5sj, ndjh_6yfjh, ndjh_6sj, \n" +
            "      ndjh_7yfjh, ndjh_7sj, ndjh_8yfjh, \n" +
            "      ndjh_8sj, ndjh_9yfjh, ndjh_9sj, \n" +
            "      ndjh_10yfjh, ndjh_10sj, ndjh_11yfjh, \n" +
            "      ndjh_11sj, ndjh_12yfjh, ndjh_12sj, \n" +
            "      state)\n" +
            "    values (#{ndjhId,jdbcType=INTEGER}, #{eqPmId}, #{eqPmName,jdbcType=VARCHAR}, \n" +
            "      #{userId,jdbcType=VARCHAR}, #{userName,jdbcType=VARCHAR}, #{ndjhSbsj,jdbcType=DATE}, \n" +
            "      #{ndjhSbsl,jdbcType=INTEGER}, #{ndjhDtsj,jdbcType=INTEGER}, #{ndjhJhl,jdbcType=INTEGER}, \n" +
            "      #{ndjh1yfjh,jdbcType=INTEGER}, #{ndjh1sj,jdbcType=INTEGER}, #{ndjh2yfjh,jdbcType=INTEGER}, \n" +
            "      #{ndjh2sj,jdbcType=INTEGER}, #{ndjh3yfjh,jdbcType=INTEGER}, #{ndjh3sj,jdbcType=INTEGER}, \n" +
            "      #{ndjh4yfjh,jdbcType=INTEGER}, #{ndjh4sj,jdbcType=INTEGER}, #{ndjh5yfjh,jdbcType=INTEGER}, \n" +
            "      #{ndjh5sj,jdbcType=INTEGER}, #{ndjh6yfjh,jdbcType=INTEGER}, #{ndjh6sj,jdbcType=INTEGER}, \n" +
            "      #{ndjh7yfjh,jdbcType=INTEGER}, #{ndjh7sj,jdbcType=INTEGER}, #{ndjh8yfjh,jdbcType=INTEGER}, \n" +
            "      #{ndjh8sj,jdbcType=INTEGER}, #{ndjh9yfjh,jdbcType=INTEGER}, #{ndjh9sj,jdbcType=INTEGER}, \n" +
            "      #{ndjh10yfjh,jdbcType=INTEGER}, #{ndjh10sj,jdbcType=INTEGER}, #{ndjh11yfjh,jdbcType=INTEGER}, \n" +
            "      #{ndjh11sj,jdbcType=INTEGER}, #{ndjh12yfjh,jdbcType=INTEGER}, #{ndjh12sj,jdbcType=INTEGER}, \n" +
            "      #{state,jdbcType=VARCHAR})")
    int insertNdjh(Ndjh ndjh);

    @Select("select * from ndjh where ndjh_id=#{ndjhId}")
    Ndjh selectNdjh(Integer ndjhId);

    @Select("select * from ndjh where user_id=#{userId}")
    List<Ndjh> selectAll(Integer userId);

    @Delete("delete from ndjh where ndjh_id = #{ndjhId,jdbcType=INTEGER}")
    int deletENdjh(Integer ndjhId);

    @Select("SELECT n.*,u.shr_id,u.eq_pm_id from ndjh n " +
            "inner join user_pm u on n.user_id=u.user_id and n.eq_pm_id=u.eq_pm_id" +
            " where shr_id=#{shrId} and n.state=#{state} ")
    List<Ndjh> selectByShrId(@Param("shrId") String shrId, @Param("state") String state);

    @Select("select * from ndjh where user_id=#{userId} ")
    List<Ndjh> selectByUserId(String userId);

    @Select("select * from ndjh where user_id=#{userId} and state=#{state} ORDER BY  ndjh_sbsj DESC ")
    List<Ndjh> selectByUserIdAndState(@Param("userId") String userId, @Param("state") String state);

    //用户查询年度计划中各状态数量
    @Select("select count(*) from ndjh where user_id=#{userId} and state=#{state}")
    Integer jhCount(@Param("userId") String userId, @Param("state") String state);

    //管理员根据用户品名关联表和年度计划表查询待审核数量
    @Select("select count(*) from ndjh where state=#{state} and user_id IN(SELECT user_id FROM user_pm WHERE shr_id=#{shrId})")
    Integer dshCount(@Param("shrId") String shrId, @Param("state") String state);

    @Update("update ndjh set state=#{state} where ndjh_id=#{ndjhId}")
    void update(@Param("ndjhId") Integer ndjhId, @Param("state") String state);

    @Update("update ndjh set \r\n" +
            "ndjh_1sj=#{ndjh1sj},ndjh_2sj=#{ndjh2sj},ndjh_3sj= #{ndjh3sj},\r\n" +
            "ndjh_4sj=#{ndjh4sj},ndjh_5sj= #{ndjh5sj},ndjh_6sj=#{ndjh6sj}, \r\n" +
            "ndjh_7sj=#{ndjh7sj}, ndjh_8sj=#{ndjh8sj}, ndjh_9sj=#{ndjh9sj}," +
            "ndjh_10sj=#{ndjh10sj},ndjh_11sj=#{ndjh11sj}, ndjh_12sj=#{ndjh12sj} where ndjh_id=#{ndjhId}")
    void updateMonth(Ndjh ndjh);

    @Update("update ndjh\n" +
            "    set eq_pm_id = #{eqPmId,jdbcType=VARCHAR},\n" +
            "      eq_pm_name = #{eqPmName,jdbcType=VARCHAR},\n" +
            "      user_id = #{userId,jdbcType=VARCHAR},\n" +
            "      user_name = #{userName,jdbcType=VARCHAR},\n" +
            "      ndjh_sbsj = #{ndjhSbsj,jdbcType=DATE},\n" +
            "      ndjh_sbsl = #{ndjhSbsl,jdbcType=INTEGER},\n" +
            "      ndjh_dtsj = #{ndjhDtsj,jdbcType=INTEGER},\n" +
            "      ndjh_jhl = #{ndjhJhl,jdbcType=INTEGER},\n" +
            "      ndjh_1yfjh = #{ndjh1yfjh,jdbcType=INTEGER},\n" +
            "      ndjh_1sj = #{ndjh1sj,jdbcType=INTEGER},\n" +
            "      ndjh_2yfjh = #{ndjh2yfjh,jdbcType=INTEGER},\n" +
            "      ndjh_2sj = #{ndjh2sj,jdbcType=INTEGER},\n" +
            "      ndjh_3yfjh = #{ndjh3yfjh,jdbcType=INTEGER},\n" +
            "      ndjh_3sj = #{ndjh3sj,jdbcType=INTEGER},\n" +
            "      ndjh_4yfjh = #{ndjh4yfjh,jdbcType=INTEGER},\n" +
            "      ndjh_4sj = #{ndjh4sj,jdbcType=INTEGER},\n" +
            "      ndjh_5yfjh = #{ndjh5yfjh,jdbcType=INTEGER},\n" +
            "      ndjh_5sj = #{ndjh5sj,jdbcType=INTEGER},\n" +
            "      ndjh_6yfjh = #{ndjh6yfjh,jdbcType=INTEGER},\n" +
            "      ndjh_6sj = #{ndjh6sj,jdbcType=INTEGER},\n" +
            "      ndjh_7yfjh = #{ndjh7yfjh,jdbcType=INTEGER},\n" +
            "      ndjh_7sj = #{ndjh7sj,jdbcType=INTEGER},\n" +
            "      ndjh_8yfjh = #{ndjh8yfjh,jdbcType=INTEGER},\n" +
            "      ndjh_8sj = #{ndjh8sj,jdbcType=INTEGER},\n" +
            "      ndjh_9yfjh = #{ndjh9yfjh,jdbcType=INTEGER},\n" +
            "      ndjh_9sj = #{ndjh9sj,jdbcType=INTEGER},\n" +
            "      ndjh_10yfjh = #{ndjh10yfjh,jdbcType=INTEGER},\n" +
            "      ndjh_10sj = #{ndjh10sj,jdbcType=INTEGER},\n" +
            "      ndjh_11yfjh = #{ndjh11yfjh,jdbcType=INTEGER},\n" +
            "      ndjh_11sj = #{ndjh11sj,jdbcType=INTEGER},\n" +
            "      ndjh_12yfjh = #{ndjh12yfjh,jdbcType=INTEGER},\n" +
            "      ndjh_12sj = #{ndjh12sj,jdbcType=INTEGER},\n" +
            "      state = #{state,jdbcType=VARCHAR}\n" +
            "    where ndjh_id = #{ndjhId,jdbcType=INTEGER}")
    void updateNdjh(Ndjh ndjh);

    /*@Select("select oount(*) from ndjh where user_id=#{userId} and state=#{state}")
    Integer subCount(String userId, String state);*/
}
