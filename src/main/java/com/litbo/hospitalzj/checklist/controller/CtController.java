package com.litbo.hospitalzj.checklist.controller;

import com.litbo.hospitalzj.checklist.domain.Ct;
import com.litbo.hospitalzj.checklist.domain.CtTemplate;
import com.litbo.hospitalzj.checklist.domain.Ct;
import com.litbo.hospitalzj.checklist.service.CtService;
import com.litbo.hospitalzj.checklist.utils.ResponseResult;
import com.litbo.hospitalzj.checklist.utils.commons.CommonUtils;
import com.litbo.hospitalzj.user.bean.EqZjls;
import com.litbo.hospitalzj.user.service.EqZjlsService;
import com.litbo.hospitalzj.zk.Enum.EnumProcess2;
import com.litbo.hospitalzj.zk.domian.EqInfo;
import com.litbo.hospitalzj.zk.service.EqInfoService;
import com.litbo.hospitalzj.zk.service.UserEqService;
import com.litbo.hospitalzj.zk.service.YqEqService;
import com.litbo.hospitalzj.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/ct")
public class CtController extends BaseController{
    @Autowired
    private CtService ctService;
    @Autowired
    private UserEqService userEqService;
    @Autowired
    private YqEqService yqEqService;
    @Autowired
    private EqZjlsService eqZjlsService;
    @Autowired
    private EqInfoService eqInfoService;
    @RequestMapping("/findTemplate")
    public ResponseResult<CtTemplate> findTemplate() {
        return new ResponseResult<CtTemplate>(200, ctService.findTemplate());
    }

    //修改模板值
    @RequestMapping("/updateCtTemplate")
    public ResponseResult<Void> updateCtTemplate(CtTemplate ctTemplate) {
        ctService.updateCtTemplate(ctTemplate);
        return new ResponseResult<Void>(200);
    }

    //插入模板值
    @RequestMapping("/insert")
    public ResponseResult<Void> insert(CtTemplate CtTemplate) {
        ctService.insert(CtTemplate);
        return new ResponseResult<Void>(200);
    }

    //保存
    @RequestMapping("/save")
    public ResponseResult save(@RequestParam("eqId") String eqId, @RequestParam("ctId") String ctId, @RequestParam(value = "userEqId") Integer userEqId
                              , HttpServletRequest req) {
        Ct ct = CommonUtils.toBean(req.getParameterMap(), Ct.class);
        int yqEqId = yqEqService.insertBatch(eqId, ctId);
        yqEqService.updateType(yqEqId, EnumProcess2.TO_UPLOAD.getMessage());
        //修改状态为待上传

//        String userId = req.getAttribute("uid").toString();
//        userEqService.insertBatchByJcEqid(userId,jcyqId,)
        userEqService.setEqState(userEqId, EnumProcess2.TO_UPLOAD.getMessage());
        ctService.save(ct);
        EqZjls eqZjls = CommonUtils.toBean(req.getParameterMap(), EqZjls.class);
        EqInfo eqById = eqInfoService.findEqById(eqId);
        eqZjls.setEqMc(eqById.getEqMc());
        eqZjls.setEqDah(eqById.getEqDah());
        eqZjlsService.insert(eqZjls);
        int[] x = {ct.getCtId(), yqEqId};
//        return new ResponseResult<>(200, x);
        return new ResponseResult<int[]>(200, x);
    }


    //只根据id更新检测数据
    @RequestMapping("/updataNow/{id}")
    public com.litbo.hospitalzj.util.ResponseResult updataNow(@PathVariable("id")Integer id, HttpServletRequest req){
        Ct ct = CommonUtils.toBean(req.getParameterMap(), Ct.class);
        ct.setCtId(id);
        //更新
        ctService.updateCt(ct);
        return new com.litbo.hospitalzj.util.ResponseResult(200, id);
    }

    @RequestMapping("/updataCt")
    public ResponseResult updataCt(
            @RequestParam("eqId")String eqId,
            @RequestParam("jcyqId") String jcyqId,
            HttpSession session,
            HttpServletRequest req){
        Ct last1 = ctService.findByEqIdandJcyqIdLast1(eqId, jcyqId);
        Ct ct = CommonUtils.toBean(req.getParameterMap(), Ct.class);
        ct.setCtId(last1.getCtId());
        //更新
        ctService.updateCt(ct);
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

        int[] x = {ct.getCtId(), yqEqId,userEqId};
        return new ResponseResult<int[]>(200, x);
    }


    //修改录入数据
  /*  @RequestMapping("/updateCt")
    public ResponseResult<Void> updateCt(Ct ct) {
        ctService.updateCt(ct);
        return new ResponseResult<Void>(200);
    }*/

    //查询本设备的最后一条
    @RequestMapping("/findCt")
    public ResponseResult<Ct> findCt(String eqId) {
        ctService.findCt(eqId);
        return new ResponseResult<Ct>(200);
    }

    //查询全部数据的最后一条
    @RequestMapping("/find")
    public ResponseResult<Ct> find() {
        ctService.find();
        return new ResponseResult<Ct>(200);
    }

    /**
     * 查询根据设备IDand检测仪器id电气检测表数据查询最后一条记录
     *
     * @return
     */
    @RequestMapping("/findByEqIdandJcyqIdLast1")
    public ResponseResult<Ct> findByEqIdandJcyqIdLast1(@RequestParam("eqId") String eqId, @RequestParam("jcyqId") String jcyqId) {
        Ct list = ctService.findByEqIdandJcyqIdLast1(eqId, jcyqId);
        return new ResponseResult<Ct>(200, list);
    }

    /**
     * 查询根据设备IDand检测仪器id电气检测表数据
     *
     * @return
     */
    @RequestMapping("/findByEqIdandJcyqId")
    public ResponseResult<List<Ct>> findByEqIdandJcyqId(@RequestParam("eqId") String eqId, @RequestParam("jcyqId") String jcyqId) {
        List<Ct> list = ctService.findByEqIdandJcyqId(eqId, jcyqId);
        return new ResponseResult<List<Ct>>(200, list);
    }

    //查询所有
    @RequestMapping("/findAll")
    public ResponseResult<List<Ct>> findAll() {
        return new ResponseResult<List<Ct>>(200, ctService.findAll());
    }

    /**
     * 查询根据检测仪器id检测表数据
     *
     * @return
     */
    @RequestMapping("/findByCtid")
    public ResponseResult<Ct> findByCtid(Integer ctId) {
        Ct list = ctService.findByCtid(ctId);
        return new ResponseResult<Ct>(200, list);
    }

    //修改审核人建议同时修改状态
    @RequestMapping("/updateShrJcjy")
    public ResponseResult<Void> updateShrJcjy(@RequestParam("ctId") Integer ctId,
                                              @RequestParam("jcyqId") Integer jcyqId,
                                              @RequestParam("eqId") Integer eqId,
                                              @RequestParam("shrJcjl") String shrJcjl,
                                              @RequestParam("state") Integer state, HttpSession session) {
        String auditor = getUserNameFromSession(session);
        Integer yqEqId = yqEqService.findId(jcyqId, eqId);
        ctService.updateShrJcjy(ctId, shrJcjl, auditor);
        if (state.equals(1)) {
            yqEqService.updateState(yqEqId, 1);
        } else {
            yqEqService.updateState(yqEqId, 2);
        }
        return new ResponseResult<Void>(200);
    }
}
