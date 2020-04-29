package com.litbo.hospitalzj.user.service;

import com.litbo.hospitalzj.user.bean.Wjsc;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//文件上传yewuceng
public interface WjscService {
    void insert(Wjsc wjsc);
    void delete(Integer id);
    List<Wjsc> select(@Param("sourceType") Integer sourceType, @Param("sourceId") Integer sourceId, @Param("type") Integer type);

    List<Wjsc> selectByType(Integer i, Integer sourceId);

    Wjsc selectLast(int sourceType, int sourceId, String type);
}
