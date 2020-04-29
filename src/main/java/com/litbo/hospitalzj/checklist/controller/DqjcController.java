package com.litbo.hospitalzj.checklist.controller;

import com.litbo.hospitalzj.checklist.domain.Ccy;
import com.litbo.hospitalzj.checklist.domain.Dqjc;
import com.litbo.hospitalzj.checklist.domain.DqjcTemplate;
import com.litbo.hospitalzj.checklist.service.DqjcService;
import com.litbo.hospitalzj.checklist.utils.commons.CommonUtils;
import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.sf.service.UserService;
import com.litbo.hospitalzj.user.bean.EqZjls;
import com.litbo.hospitalzj.user.service.EqZjlsService;
import com.litbo.hospitalzj.util.ResponseResult;
import com.litbo.hospitalzj.zk.Enum.EnumProcess2;
import com.litbo.hospitalzj.zk.domian.EqInfo;
import com.litbo.hospitalzj.zk.domian.YqEq;
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
@RequestMapping("/dqjc")
public class DqjcController extends BaseController {

    @Autowired
    private DqjcService dqjcService;
    @Autowired
    private UserEqService userEqService;
    @Autowired
    private UserService userService;
    @Autowired
    private YqEqService yqEqService;
    @Autowired
    private EqZjlsService eqZjlsService;
    @Autowired
    private EqInfoService eqInfoService;

    /**
     * 查询含有模板表数据的电气检测表
     *
     * @return
     */
    @RequestMapping("/findTemplate")
    public ResponseResult<DqjcTemplate> findTemplate() {
        DqjcTemplate dqjc = dqjcService.findTemplate();
        return new ResponseResult<DqjcTemplate>(200, dqjc);
    }

    /**
     * 修改模板表数据
     *
     * @return
     */
    @RequestMapping("/updateTemplate")
    public ResponseResult<Void> updateTemplate(DqjcTemplate dqjcTemplate) {
        System.out.println(dqjcTemplate);
        dqjcService.updateTemplate(dqjcTemplate);
        return new ResponseResult<Void>(200);
    }


    //只根据id更新检测数据
    @RequestMapping("/updataNow/{id}")
    public ResponseResult updataNow(@PathVariable("id")Integer id, HttpServletRequest req){
        Dqjc dqjc = CommonUtils.toBean(req.getParameterMap(), Dqjc.class);
        dqjc.setDqjcid(id);
        dqjc.setState(0);
        //更新
        dqjcService.updateDqjc(dqjc);
        return new ResponseResult(200, id);
    }



    /**
     * 插入模板表数据
     *
     * @return
     */
    @RequestMapping("/insertTemplate")
    public ResponseResult<Void> insertTemplate(DqjcTemplate dqjcTemplate) {
        dqjcService.insertTemplate(dqjcTemplate);
        return new ResponseResult<Void>(200);
    }

    /**
     * 保存电器检测数据
     *
     * @param eqId
     * @param jcyqId
     * @param req
     * @return
     */
    @RequestMapping("/save")
    public ResponseResult saveDq(@RequestParam(value = "eqId") String eqId,
                                 @RequestParam(value = "jcyqId") String jcyqId,
                                 @RequestParam(value = "userEqId") Integer userEqId,
                                 HttpSession session, HttpServletRequest req) {
        Dqjc dqjc = CommonUtils.toBean(req.getParameterMap(), Dqjc.class);

        dqjcService.delete(eqId, jcyqId);
        dqjc.setState(0);
        int yqEqId = yqEqService.insertBatch(eqId, jcyqId);
        yqEqService.updateType(yqEqId, EnumProcess2.TO_UPLOAD.getMessage());
        //修改状态为待上传
        userEqService.setEqState(userEqId, EnumProcess2.TO_UPLOAD.getMessage());
        dqjcService.save(dqjc);

        EqZjls eqZjls = CommonUtils.toBean(req.getParameterMap(), EqZjls.class);
        EqInfo eqById = eqInfoService.findEqById(eqId);
        eqZjls.setEqMc(eqById.getEqMc());
        eqZjls.setEqDah(eqById.getEqDah());
        eqZjlsService.insert(eqZjls);

        int[] x = {dqjc.getDqjcid(), yqEqId};
        return new ResponseResult<int[]>(200, x);
    }


    @RequestMapping("/updataDqjc")
    public ResponseResult updataDqjc(
            @RequestParam("eqId")String eqId,
            @RequestParam("jcyqId") String jcyqId,
            HttpSession session,
            HttpServletRequest req){
        Dqjc last1 = dqjcService.findByEqIdandJcyqIdLast1(eqId, jcyqId);
        Dqjc dqjc = CommonUtils.toBean(req.getParameterMap(), Dqjc.class);
        dqjc.setDqjcid(last1.getDqjcid());
        //更新
        dqjcService.updateDqjc(dqjc);
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
        int[] x = {dqjc.getDqjcid(), yqEqId,userEqId};
        return new ResponseResult<int[]>(200, x);
    }



    //查询电气检测表（最后一条）
    @RequestMapping("/find")
    public ResponseResult<Dqjc> find() {
        Dqjc dqjc = dqjcService.find();
        return new ResponseResult<Dqjc>(200, dqjc);
    }

    /***
     * 查询所有电气检测表数据
     * @return
     */
    @RequestMapping("/findAll")
    public ResponseResult<List<Dqjc>> findAll() {
        List<Dqjc> list = dqjcService.findAll();
        return new ResponseResult<List<Dqjc>>(200, list);
    }

    /**
     * 查询根据设备IDand检测仪器id电气检测表数据查询最后一条记录
     *
     * @return
     */
    @RequestMapping("/findByEqIdandJcyqIdLast1")
    public ResponseResult<Dqjc> findByEqIdandJcyqIdLast1(@RequestParam("eqId") String eqId, @RequestParam("jcyqId") String jcyqId) {
        Dqjc list = dqjcService.findByEqIdandJcyqIdLast1(eqId, jcyqId);
        return new ResponseResult<Dqjc>(200, list);
    }

    /**
     * 查询根据设备IDand检测仪器id电气检测表数据
     *
     * @return
     */
    @RequestMapping("/findByEqIdandJcyqId")
    public ResponseResult<List<Dqjc>> findByEqIdandJcyqId(@RequestParam("eqId") String eqId, @RequestParam("jcyqId") String jcyqId) {
        List<Dqjc> list = dqjcService.findByEqIdandJcyqId(eqId, jcyqId);
        return new ResponseResult<List<Dqjc>>(200, list);
    }

    /**
     * 查询根据检测仪器id电气检测表数据
     *
     * @return
     */
    @RequestMapping("/findByDqjcid")
    public ResponseResult<Dqjc> findByDqjcid(Integer dqjcid) {
        Dqjc list = dqjcService.findByDqjcid(dqjcid, 0);
        return new ResponseResult<Dqjc>(200, list);
    }

    //修改状态
    @RequestMapping("/updateState")
    public ResponseResult<Void> updateState(@RequestParam("yqEqId") Integer yqEqId, @RequestParam("userEqId") Integer userEqId) {
        //根据设备id查此id与检测仪器的关联表
        //如果此设备id关联的检测仪器有一个状态为待上传，那么此设备状态为待上传
        //如果此设备id关联的检测仪器全部状态为已上传，那么此设备状态为已上传
        yqEqService.updateState(yqEqId, 0);
        yqEqService.updateType(yqEqId, EnumProcess2.IS_UPLOAD.getMessage());
        //改为待审核之前判断一下yqeq是否有待上传记录
        YqEq yqEq = yqEqService.findById(yqEqId);
        //待上传的
        List<YqEq> yqEqs = yqEqService.findByType(yqEq.getEqId(), EnumProcess2.TO_UPLOAD.getMessage());
        if(yqEqs.size() == 0){
            userEqService.setEqState(userEqId, EnumProcess2.UNDER_REVIEW.getMessage());
        }
        return new ResponseResult<Void>(200);
    }

    //修改状态
    @RequestMapping("/updateState2")
    public ResponseResult<Void> updateState2(@RequestParam("eqId")String eqId, @RequestParam("yqEqId") Integer yqEqId, @RequestParam("userEqId") Integer userEqId) {
        yqEqService.updateState(yqEqId, 0);
        yqEqService.updateType(yqEqId, EnumProcess2.IS_UPLOAD.getMessage());
        //YqEq yqEq = yqEqService.selectYqEq(yqEqId);
        //如果未通过的设备关联的仪器为0，修改状态为待上传
        Integer num = yqEqService.findTotalNum(eqId);
            if(num == 0){
            userEqService.setEqState(userEqId, EnumProcess2.UNDER_REVIEW.getMessage());
        }
        return new ResponseResult<Void>(200);
    }


    //修改状态
    @RequestMapping("/updateState3")
    public ResponseResult<Void> updateState3(@RequestParam("eqId")String eqId, @RequestParam("userEqId") Integer userEqId) {
        //如果未通过的设备关联的仪器为0，修改状态为待上传
        Integer num = yqEqService.findTotalNum(eqId);
        if(num == 0){
            //user_eq 状态改为带上传
            userEqService.setEqState(userEqId, EnumProcess2.TO_UPLOAD.getMessage());
        }
        return new ResponseResult<Void>(200);
    }

    //修改仪器为已上传
    //修改状态
    @RequestMapping("/updateType")
    public ResponseResult<Void> updateType(@RequestParam("yqEqId") Integer yqEqId, @RequestParam("userEqId") Integer userEqId, HttpSession session) {
        yqEqService.updateState(yqEqId, 0);
        yqEqService.updateType(yqEqId, EnumProcess2.IS_UPLOAD.getMessage());
        return new ResponseResult<Void>(200);
    }

    //修改审核人建议同时修改状态
    @RequestMapping("/updateShrJcjy")
    public ResponseResult<Void> updateShrJcjy(@RequestParam("dqjcid") Integer dqjcid,
                                              @RequestParam("jcyqId") Integer jcyqId,
                                              @RequestParam("eqId") Integer eqId,
                                              @RequestParam("shrJcjl") String shrJcjl,
                                              @RequestParam("state") Integer state, HttpSession session) {
        String auditor = getUserNameFromSession(session);
        Integer yqEqId = yqEqService.findId(jcyqId, eqId);
        dqjcService.updateShrJcjy(dqjcid, shrJcjl, auditor);
        if (state.equals(1)) {
            yqEqService.updateState(yqEqId, 1);
        } else {
            yqEqService.updateState(yqEqId, 2);
        }
        return new ResponseResult<Void>(200);
    }

}