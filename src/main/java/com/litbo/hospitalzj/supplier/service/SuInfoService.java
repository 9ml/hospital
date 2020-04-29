package com.litbo.hospitalzj.supplier.service;

import com.litbo.hospitalzj.supplier.entity.SuInfo;
import com.litbo.hospitalzj.supplier.service.exception.PasswordNotMatchException;
import com.litbo.hospitalzj.supplier.service.exception.UserNotFoundException;
import com.litbo.hospitalzj.supplier.vo.SuInfoAndZzInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SuInfoService {
    int insert(SuInfo suInfo);
    void delete(@Param("suId") Integer suId, @Param("isDelete") Integer isDelete);
    void update(SuInfo suInfo);
    void updateState(@Param("suId") Integer suId, @Param("state") Integer state);
    List<SuInfo> selectAll();
    SuInfoAndZzInfo findSuById(Integer suId);
    List<SuInfo> findBySuMcLike(@Param("suMc") String suMc);
    Integer count(Integer state);
    List<SuInfo> findSuByState(Integer state);
    void updatePwd(@Param("suId") Integer suId, @Param("password") String password);
    public SuInfo login(String suMc, String password) throws UserNotFoundException, PasswordNotMatchException;
    void sendEmail(Integer suId, String email, String password, String subject, String text);
    //根据id查数据
    SuInfoAndZzInfo findSuinfoById(Integer suId);

    //插入当前时间
    void insertNowTime(String suId);
}
