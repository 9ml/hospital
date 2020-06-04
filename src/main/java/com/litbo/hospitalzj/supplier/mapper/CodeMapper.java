package com.litbo.hospitalzj.supplier.mapper;

import com.litbo.hospitalzj.sf.entity.Code;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CodeMapper {
    @Insert("insert into code(su_email,code) value(#{suEmail},#{code})")
    Integer insertCode(Code code);
    @Delete("delete from code where su_email = #{email}")
    Integer deleteAllCodeByEmail(String email);
    @Select("select * from code where  su_email = #{suEmail} and code = #{code}")
    Code findCodeAndEmail(@Param("suEmail") String suEmail, @Param("code") String code);
    @Delete("delete from code")
    Integer deleteAllCode();
}
