package com.litbo.hospitalzj.user.dao;

import com.litbo.hospitalzj.user.bean.Wjsc;
import org.apache.ibatis.annotations.*;

import java.util.List;

//文件上传持久层
@Mapper
public interface WjscDao {
    @Insert("insert into wjsc (id, source_type, source_id, \n" +
            "      type, path, sc_time)\n" +
            "    values (#{id,jdbcType=INTEGER}, #{sourceType,jdbcType=INTEGER}, #{sourceId,jdbcType=INTEGER}, \n" +
            "      #{type,jdbcType=INTEGER}, #{path,jdbcType=VARCHAR}, #{scTime,jdbcType=DATE})")
    int insert(Wjsc wjsc);

    @Delete("delete from wjsc where id = #{id,jdbcType=INTEGER}")
    int delete(Integer id);

    @Select("Select * from wjsc where source_type=#{sourceType} and source_id=#{sourceId} and type=#{type}")
    List<Wjsc> select(@Param("sourceType") Integer sourceType, @Param("sourceId") Integer sourceId, @Param("type") Integer type);

    @Select("select * from wjsc where source_type=#{sourceType} and source_id=#{sourceId}")
    List<Wjsc> selectByType(@Param("sourceType") int sourceType, @Param("sourceId") Integer sourceId);

    @Select("select * from wjsc where source_type=#{sourceType} and source_id=#{sourceId} and type=#{type} order by id desc limit 1 ")
    Wjsc selectLast(@Param("sourceType") int sourceType, @Param("sourceId")int sourceId, @Param("type") String type);
}
