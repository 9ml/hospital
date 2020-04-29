package com.litbo.hospitalzj.checklist.controller;

import com.litbo.hospitalzj.checklist.domain.SybC;
import com.litbo.hospitalzj.checklist.domain.Yepyx;
import com.litbo.hospitalzj.checklist.domain.YepyxTemplate;
import com.litbo.hospitalzj.checklist.service.YepyxService;
import com.litbo.hospitalzj.checklist.utils.commons.CommonUtils;
import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.user.bean.EqZjls;
import com.litbo.hospitalzj.user.service.EqZjlsService;
import com.litbo.hospitalzj.util.ResponseResult;
import com.litbo.hospitalzj.zk.Enum.EnumProcess2;
import com.litbo.hospitalzj.zk.domian.EqInfo;
import com.litbo.hospitalzj.zk.service.EqInfoService;
import com.litbo.hospitalzj.zk.service.UserEqService;
import com.litbo.hospitalzj.zk.service.YqEqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/yepyx")
public class YepyxController extends BaseController {

    @Autowired
    private YepyxService yepyxService;
    @Autowired
    private YqEqService yqEqService;
    @Autowired
    private UserEqService userEqService;
    @Autowired
    private EqZjlsService eqZjlsService;
    @Autowired
    private EqInfoService eqInfoService;

    //查询婴儿培养箱检测模板表
    @RequestMapping("/findTemplate")
    public ResponseResult<YepyxTemplate> findTemplate() {
        YepyxTemplate yepyxTemplate = yepyxService.findTemplate();
        return new ResponseResult<YepyxTemplate>(200, yepyxTemplate);
    }

    //修改模板表数据
    @RequestMapping("/updateTemplate")
    public ResponseResult<Void> updateTemplate(YepyxTemplate yepyxTemplate) {
        yepyxService.updateTemplate(yepyxTemplate);
        return new ResponseResult<Void>(200);
    }

    //插入模板表数据
    @RequestMapping("/insertTemplate")
    public ResponseResult<Void> insertTemplate(YepyxTemplate yepyxTemplate) {
        yepyxService.insertTemplate(yepyxTemplate);
        return new ResponseResult<Void>(200);
    }

    //保存婴儿培养箱检测数据
    @RequestMapping("/save")
    public ResponseResult save(@RequestParam(value = "eqId") String eqId,
                               @RequestParam(value = "jcyqId") String jcyqId,
                               @RequestParam(value = "userEqId") Integer userEqId,
                                HttpServletRequest req) {
        Yepyx yepyx = CommonUtils.toBean(req.getParameterMap(), Yepyx.class);
        int yqEqId = yqEqService.insertBatch(eqId, jcyqId);
        yqEqService.updateType(yqEqId, EnumProcess2.TO_UPLOAD.getMessage());
        //修改状态为待上传
        userEqService.setEqState(userEqId, EnumProcess2.TO_UPLOAD.getMessage());
        yepyxService.save(yepyx);
        //质检流水
        EqZjls eqZjls = CommonUtils.toBean(req.getParameterMap(), EqZjls.class);
        EqInfo eqById = eqInfoService.findEqById(eqId);
        eqZjls.setEqMc(eqById.getEqMc());
        eqZjls.setEqDah(eqById.getEqDah());
        eqZjlsService.insert(eqZjls);
        int[] x = {yepyx.getPyxId(), yqEqId};
        return new ResponseResult<>(200, x);
    }

    //只根据id更新检测数据
    @RequestMapping("/updataNow/{id}")
    public ResponseResult updataNow(@PathVariable("id")Integer id,HttpServletRequest req){
        Yepyx yepyx = CommonUtils.toBean(req.getParameterMap(), Yepyx.class);
        yepyx.setPyxId(id);
        //更新
        yepyxService.update(yepyx);
        return new ResponseResult(200, id);
    }


    @RequestMapping("/updateYepyx")
    public ResponseResult updateYepyx(
            @RequestParam("eqId")String eqId,
            @RequestParam("jcyqId") String jcyqId,
            HttpSession session,
            HttpServletRequest req){
        Yepyx data = yepyxService.findByEqIdandJcyqIdLast1(eqId, jcyqId);
        Yepyx yepyx = CommonUtils.toBean(req.getParameterMap(), Yepyx.class);
        yepyx.setPyxId(data.getPyxId());
        //更新
        yepyxService.update(yepyx);
        //修改yq_eq 得state 和 type
        int yqEqId=yqEqService.insertBatch(eqId,jcyqId);
        yqEqService.updateType(yqEqId,EnumProcess2.TO_UPLOAD.getMessage());
        yqEqService.updateState(yqEqId, 0);
        //如果未通过的设备关联的仪器为0，修改状态为待上传
        Integer num = yqEqService.findTotalNum(eqId);
        Integer userEqId = userEqService.findUserEqByUserIdAndJceqid(getUserIdFromSession(session), eqId);
        if(num == 0){
            userEqService.setEqState(userEqId,EnumProcess2.TO_UPLOAD.getMessage());
        }
        int[] x = {yepyx.getPyxId(), yqEqId, userEqId};
        return new ResponseResult<>(200, x);
    }



    //数据修改
  /*  @RequestMapping("/updateYepyx")
    public ResponseResult<Void> update(Yepyx yepyx) {
        yepyxService.update(yepyx);
        return new ResponseResult<Void>(200);
    }*/

    //根据婴儿培养箱id查询设备检测表
    @RequestMapping("/findYepyx")
    public ResponseResult<Yepyx> findYepyx(String eqId) {
        Yepyx data = yepyxService.findYepyx(eqId);
        return new ResponseResult<Yepyx>(200, data);
    }

    //根据设备Id,检测仪器Id以及状态查询电器表查询最后一条记录
    @RequestMapping("/findByEqIdandJcyqIdLast1")
    public ResponseResult<Yepyx> findByEqIdandJcyqIdLast1(@RequestParam("eqId") String eqId, @RequestParam("jcyqId") String jcyqId) {
        Yepyx data = yepyxService.findByEqIdandJcyqIdLast1(eqId, jcyqId);
        return new ResponseResult<Yepyx>(200, data);
    }

    //根据设备Id,检测仪器Id以及状态查询电器表
    @RequestMapping("/findByEqIdandJcyqId")
    public ResponseResult<List<Yepyx>> findByEqIdandJcyqId(@RequestParam("eqId") String eqId, @RequestParam("jcyqId") String jcyqId) {
        List<Yepyx> data = yepyxService.findByEqIdandJcyqId(eqId, jcyqId);
        return new ResponseResult<List<Yepyx>>(200, data);
    }

    //查询所有检测表数据信息
    @RequestMapping("/findAll")
    public ResponseResult<List<Yepyx>> findAll() {
        List<Yepyx> data = yepyxService.findAll();
        return new ResponseResult<List<Yepyx>>(200, data);
    }

    //根据iD状态查询
    @RequestMapping("/findByPyxId")
    public ResponseResult<Yepyx> findByPyxId(Integer pyxId) {
        Yepyx data = yepyxService.findByPyxId(pyxId);
        return new ResponseResult<Yepyx>(200, data);
    }
    //修改状态
    /* void updateState(@Param("pyxId")Integer pyxId,@Param("state")Integer state);*/

    //修改审核人意见
    @RequestMapping("/updateShrJcjy")
    public com.litbo.hospitalzj.checklist.utils.ResponseResult<Void> updateShrJcjy(
            @RequestParam("pyxId") Integer pyxId,
            @RequestParam("jcyqId") Integer jcyqId,
            @RequestParam("eqId") Integer eqId,
            @RequestParam("shrJcjl") String shrJcjl,
            @RequestParam("state") Integer state, HttpSession session) {
        String auditor = getUserNameFromSession(session);
        Integer yqEqId = yqEqService.findId(jcyqId, eqId);
        yepyxService.updateShrJcjy(pyxId, shrJcjl, auditor);
        if (state.equals(1)) {
            yqEqService.updateState(yqEqId, 1);
        } else {
            yqEqService.updateState(yqEqId, 2);
        }
        return new com.litbo.hospitalzj.checklist.utils.ResponseResult<Void>(200);
    }
}