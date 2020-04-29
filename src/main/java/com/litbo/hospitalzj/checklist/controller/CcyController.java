package com.litbo.hospitalzj.checklist.controller;

import com.litbo.hospitalzj.checklist.domain.Ccy;
import com.litbo.hospitalzj.checklist.domain.CcyTemplate;
import com.litbo.hospitalzj.checklist.domain.Dcsjhy;
import com.litbo.hospitalzj.checklist.domain.Yepyx;
import com.litbo.hospitalzj.checklist.service.CcyService;
import com.litbo.hospitalzj.checklist.utils.commons.CommonUtils;
import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.sf.service.UserService;
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
@RequestMapping("/ccy")
public class CcyController extends BaseController {

    @Autowired
    private CcyService ccyService;
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
    public ResponseResult<CcyTemplate> findTemplate() {
        CcyTemplate dqjc = ccyService.findTemplate();
        return new ResponseResult<CcyTemplate>(200, dqjc);
    }

    /**
     * 查询含有模板表数据的电气检测表
     *
     * @return
     */
    @RequestMapping("/findTemplateById")
    public ResponseResult<CcyTemplate> findTemplateById(Integer ccyTemplateId) {
        CcyTemplate dqjc = ccyService.findTemplateById(ccyTemplateId);
        return new ResponseResult<CcyTemplate>(200, dqjc);
    }

    /**
     * 修改模板表数据
     *
     * @return
     */
    @RequestMapping("/updateTemplate")
    public ResponseResult<Void> updateTemplate(CcyTemplate ccyTemplate) {
        ccyService.updateTemplate(ccyTemplate);
        return new ResponseResult<Void>(200);
    }

    /**
     * 插入模板表数据
     *
     * @return
     */
    @RequestMapping("/insertTemplate")
    public ResponseResult<Void> insertTemplate(CcyTemplate ccyTemplate) {
        ccyService.insertTemplate(ccyTemplate);
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
        Ccy ccy = CommonUtils.toBean(req.getParameterMap(), Ccy.class);
        EqZjls eqZjls = CommonUtils.toBean(req.getParameterMap(), EqZjls.class);
        int yqEqId = yqEqService.insertBatch(eqId, jcyqId);
        yqEqService.updateType(yqEqId, EnumProcess2.TO_UPLOAD.getMessage());
        //修改状态为待上传
        userEqService.setEqState(userEqId, EnumProcess2.TO_UPLOAD.getMessage());
        ccyService.save(ccy);

        EqInfo eqById = eqInfoService.findEqById(eqId);
        eqZjls.setEqMc(eqById.getEqMc());
        eqZjls.setEqDah(eqById.getEqDah());
        eqZjlsService.insert(eqZjls);


        int[] x = {ccy.getCcyId(), yqEqId};
        return new ResponseResult<>(200, x);
    }


    @RequestMapping("/updataccy")
    public ResponseResult updataccy(
            @RequestParam("eqId")String eqId,
            @RequestParam("jcyqId") String jcyqId,
            HttpSession session,
            HttpServletRequest req){
        Ccy last1 = ccyService.findByEqIdandJcyqIdLast1(eqId, jcyqId);
        Ccy ccy = CommonUtils.toBean(req.getParameterMap(), Ccy.class);
        ccy.setCcyId(last1.getCcyId());
        //更新
        ccyService.updateCcy(ccy);
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
        int[] x = {ccy.getCcyId(), yqEqId,userEqId};
        return new ResponseResult<>(200, x);
    }

    //只根据id更新检测数据
    @RequestMapping("/updataNow/{id}")
    public ResponseResult updataNow(@PathVariable("id")Integer id, HttpServletRequest req){
        Ccy ccy = CommonUtils.toBean(req.getParameterMap(), Ccy.class);
        ccy.setCcyId(id);
        //更新
        ccyService.updateCcy(ccy);
        return new ResponseResult(200, id);
    }




    //查询电气检测表（最后一条）
    /*@RequestMapping("/find")
    public ResponseResult<Dqjc> find(){
        Dqjc dqjc = ccyService.find();
        return new ResponseResult<Dqjc>(200, dqjc);
    }*/

    /***
     * 查询所有电气检测表数据
     * @return
     */
    @RequestMapping("/findAll")
    public ResponseResult<List<Ccy>> findAll() {
        List<Ccy> list = ccyService.findAll();
        return new ResponseResult<List<Ccy>>(200, list);
    }

    /**
     * 查询根据设备IDand检测仪器id电气检测表数据查询最后一条记录
     *
     * @return
     */
    @RequestMapping("/findByEqIdandJcyqIdLast1")
    public ResponseResult<Ccy> findByEqIdandJcyqIdLast1(@RequestParam("eqId") String eqId, @RequestParam("jcyqId") String jcyqId) {
        Ccy list = ccyService.findByEqIdandJcyqIdLast1(eqId, jcyqId);
        return new ResponseResult<Ccy>(200, list);
    }

    /**
     * 查询根据设备IDand检测仪器id电气检测表数据
     *
     * @return
     */
    @RequestMapping("/findByEqIdandJcyqId")
    public ResponseResult<List<Ccy>> findByEqIdandJcyqId(@RequestParam("eqId") String eqId, @RequestParam("jcyqId") String jcyqId) {
        List<Ccy> list = ccyService.findByEqIdandJcyqId(eqId, jcyqId);
        return new ResponseResult<List<Ccy>>(200, list);
    }

    /**
     * 查询根据检测仪器id电气检测表数据
     *
     * @return
     */
    @RequestMapping("/findByCcyIds")
    public ResponseResult<Ccy> findByCcyId(Integer ccyId) {
        Ccy list = ccyService.findByCcyId(ccyId);
        return new ResponseResult<Ccy>(200, list);
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
    public ResponseResult<Void> updateShrJcjy(@RequestParam("ccyId") Integer ccyId, @RequestParam("jcyqId") Integer jcyqId,
                                              @RequestParam("eqId") Integer eqId, @RequestParam("shrJcjl") String shrJcjl, @RequestParam("state") Integer state, HttpSession session) {
        String auditor = getUserNameFromSession(session);
        Integer yqEqId = yqEqService.findId(jcyqId, eqId);
        ccyService.updateShrJcjy(ccyId, shrJcjl, auditor);
        if (state.equals(1)) {
            yqEqService.updateState(yqEqId, 1);
        } else {
            yqEqService.updateState(yqEqId, 2);
        }
        return new ResponseResult<Void>(200);
    }

}