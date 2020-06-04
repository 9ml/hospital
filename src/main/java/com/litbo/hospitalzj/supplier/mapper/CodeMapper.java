package com.litbo.hospitalzj.supplier.mapper;

import com.litbo.hospitalzj.sf.entity.Code;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CodeMapper {
    @Insert("insert into code(su_email,code) value(#{suEmail},#{code})")
    Integer insertCode(Code code);
    @Delete("delete from code where su_email = #{email}")
    Integer deleteAllCodeByEmail(String email);
    @Select("select * from code where  su_email = #{suEmail} and code = #{code}")
    Code findCodeAndEmail(String suEmail, String code);
}
