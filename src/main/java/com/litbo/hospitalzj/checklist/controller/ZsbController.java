package com.litbo.hospitalzj.checklist.controller;

import com.litbo.hospitalzj.checklist.domain.Zsb;
import com.litbo.hospitalzj.checklist.domain.ZsbTemplate;
import com.litbo.hospitalzj.checklist.service.ZsbService;
import com.litbo.hospitalzj.checklist.utils.ResponseResult;
import com.litbo.hospitalzj.checklist.utils.commons.CommonUtils;
import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.user.bean.EqZjls;
import com.litbo.hospitalzj.user.service.EqZjlsService;
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
@RequestMapping("/zsb")
public class ZsbController extends BaseController {

    @Autowired
    private ZsbService sybService;
    @Autowired
    private UserEqService userEqService;
    @Autowired
    private YqEqService yqEqService;
    @Autowired
    private EqZjlsService eqZjlsService;
    @Autowired
    private EqInfoService eqInfoService;
    //查询模板值
    @RequestMapping("/findTemplate")
    public ResponseResult<ZsbTemplate> findTemplate() {
        return new ResponseResult<ZsbTemplate>(200, sybService.findTemplate());
    }

    //修改模板值
    @RequestMapping("/updateZsbTemplate")
    public ResponseResult<Void> updateZsbTemplate(ZsbTemplate sybTemplate) {
        sybService.updateZsbTemplate(sybTemplate);
        return new ResponseResult<Void>(200);
    }

    //插入模板值
    @RequestMapping("/insert")
    public ResponseResult<Void> insert(ZsbTemplate sybTemplate) {
        sybService.insert(sybTemplate);
        return new ResponseResult<Void>(200);
    }

    //保存
    @RequestMapping("/save")
    public ResponseResult save(@RequestParam("eqId") String eqId, @RequestParam("jcyqId") String jcyqId, @RequestParam(value = "userEqId") Integer userEqId,
                               HttpSession session, HttpServletRequest req) {
        Zsb syb = CommonUtils.toBean(req.getParameterMap(), Zsb.class);
        int yqEqId = yqEqService.insertBatch(eqId, jcyqId);
        yqEqService.updateType(yqEqId, EnumProcess2.TO_UPLOAD.getMessage());
        //修改状态为待上传

//        String userId = req.getAttribute("uid").toString();
//        userEqService.insertBatchByJcEqid(userId,jcyqId,)
        userEqService.setEqState(userEqId, EnumProcess2.TO_UPLOAD.getMessage());
        sybService.save(syb);
        EqZjls eqZjls = CommonUtils.toBean(req.getParameterMap(), EqZjls.class);
        EqInfo eqById = eqInfoService.findEqById(eqId);
        eqZjls.setEqMc(eqById.getEqMc());
        eqZjls.setEqDah(eqById.getEqDah());
        eqZjlsService.insert(eqZjls);
        int[] x = {syb.getZsbId(), yqEqId};
//        return new ResponseResult<>(200, x);
        return new ResponseResult<int[]>(200, x);
    }


    //只根据id更新检测数据
    @RequestMapping("/updataNow/{id}")
    public com.litbo.hospitalzj.util.ResponseResult updataNow(@PathVariable("sybId")Integer sybId, HttpServletRequest req){
        Zsb syb = CommonUtils.toBean(req.getParameterMap(), Zsb.class);
        syb.setZsbId(sybId);
        //更新
        sybService.updateZsb(syb);
        return new com.litbo.hospitalzj.util.ResponseResult(200, sybId);
    }

    @RequestMapping("/updataZsb")
    public ResponseResult updataZsb(
            @RequestParam("eqId")String eqId,
            @RequestParam("jcyqId") String jcyqId,
            HttpSession session,
            HttpServletRequest req){
        Zsb last1 = sybService.findByEqIdandJcyqIdLast1(eqId, jcyqId);
        Zsb syb = CommonUtils.toBean(req.getParameterMap(), Zsb.class);
        syb.setZsbId(last1.getZsbId());
        //更新
        sybService.updateZsb(syb);
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

        int[] x = {syb.getZsbId(), yqEqId,userEqId};
        return new ResponseResult<int[]>(200, x);
    }


    //修改录入数据
  /*  @RequestMapping("/updateZsb")
    public ResponseResult<Void> updateZsb(Zsb syb) {
        sybService.updateZsb(syb);
        return new ResponseResult<Void>(200);
    }*/

    //查询本设备的最后一条
    @RequestMapping("/findZsb")
    public ResponseResult<Zsb> findZsb(String eqId) {
        sybService.findZsb(eqId);
        return new ResponseResult<Zsb>(200);
    }

    //查询全部数据的最后一条
    @RequestMapping("/find")
    public ResponseResult<Zsb> find() {
        sybService.find();
        return new ResponseResult<Zsb>(200);
    }

    /**
     * 查询根据设备IDand检测仪器id电气检测表数据查询最后一条记录
     *
     * @return
     */
    @RequestMapping("/findByEqIdandJcyqIdLast1")
    public ResponseResult<Zsb> findByEqIdandJcyqIdLast1(@RequestParam("eqId") String eqId, @RequestParam("jcyqId") String jcyqId) {
        Zsb list = sybService.findByEqIdandJcyqIdLast1(eqId, jcyqId);
        return new ResponseResult<Zsb>(200, list);
    }

    /**
     * 查询根据设备IDand检测仪器id电气检测表数据
     *
     * @return
     */
    @RequestMapping("/findByEqIdandJcyqId")
    public ResponseResult<List<Zsb>> findByEqIdandJcyqId(@RequestParam("eqId") String eqId, @RequestParam("jcyqId") String jcyqId) {
        List<Zsb> list = sybService.findByEqIdandJcyqId(eqId, jcyqId);
        return new ResponseResult<List<Zsb>>(200, list);
    }

    //查询所有
    @RequestMapping("/findAll")
    public ResponseResult<List<Zsb>> findAll() {
        return new ResponseResult<List<Zsb>>(200, sybService.findAll());
    }

    /**
     * 查询根据检测仪器id检测表数据
     *
     * @return
     */
    @RequestMapping("/findByZsbid")
    public ResponseResult<Zsb> findByZsbid(Integer sybId) {
        Zsb list = sybService.findByZsbId(sybId);
        return new ResponseResult<Zsb>(200, list);
    }

    //修改审核人建议同时修改状态
    @RequestMapping("/updateShrJcjy")
    public ResponseResult<Void> updateShrJcjy(@RequestParam("sybId") Integer sybId,
                                              @RequestParam("jcyqId") Integer jcyqId,
                                              @RequestParam("eqId") Integer eqId,
                                              @RequestParam("shrJcjl") String shrJcjl,
                                              @RequestParam("state") Integer state, HttpSession session) {
        String auditor = getUserNameFromSession(session);
        Integer yqEqId = yqEqService.findId(jcyqId, eqId);
        sybService.updateShrJcjy(sybId, shrJcjl, auditor);
        if (state.equals(1)) {
            yqEqService.updateState(yqEqId, 1);
        } else {
            yqEqService.updateState(yqEqId, 2);
        }
        return new ResponseResult<Void>(200);
    }
}
