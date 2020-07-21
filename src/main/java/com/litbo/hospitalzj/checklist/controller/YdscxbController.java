package com.litbo.hospitalzj.checklist.controller;

import com.litbo.hospitalzj.checklist.domain.Ydscxb;
import com.litbo.hospitalzj.checklist.domain.YdscxbTemplate;
import com.litbo.hospitalzj.checklist.service.YdscxbService;
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
@RequestMapping("/ydscxb")
public class YdscxbController extends BaseController {

    @Autowired
    private YdscxbService ydscxbService;
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
    public ResponseResult<YdscxbTemplate> findTemplate() {
        return new ResponseResult<YdscxbTemplate>(200, ydscxbService.findTemplate());
    }

    //修改模板值
    @RequestMapping("/updateYdscxbTemplate")
    public ResponseResult<Void> updateYdscxbTemplate(YdscxbTemplate ydscxbTemplate) {
        ydscxbService.updateYdscxbTemplate(ydscxbTemplate);
        return new ResponseResult<Void>(200);
    }

    //插入模板值
    @RequestMapping("/insert")
    public ResponseResult<Void> insert(YdscxbTemplate ydscxbTemplate) {
        ydscxbService.insert(ydscxbTemplate);
        return new ResponseResult<Void>(200);
    }

    //保存
    @RequestMapping("/save")
    public ResponseResult save(@RequestParam("eqId") String eqId, @RequestParam("jcyqId") String jcyqId, @RequestParam(value = "userEqId") Integer userEqId,
                               HttpSession session, HttpServletRequest req) {
        Ydscxb ydscxb = CommonUtils.toBean(req.getParameterMap(), Ydscxb.class);
        int yqEqId = yqEqService.insertBatch(eqId, jcyqId);
        yqEqService.updateType(yqEqId, EnumProcess2.TO_UPLOAD.getMessage());
        //修改状态为待上传

//        String userId = req.getAttribute("uid").toString();
//        userEqService.insertBatchByJcEqid(userId,jcyqId,)
        userEqService.setEqState(userEqId, EnumProcess2.TO_UPLOAD.getMessage());
        ydscxbService.save(ydscxb);
        EqZjls eqZjls = CommonUtils.toBean(req.getParameterMap(), EqZjls.class);
        EqInfo eqById = eqInfoService.findEqById(eqId);
        eqZjls.setEqMc(eqById.getEqMc());
        eqZjls.setEqDah(eqById.getEqDah());
        eqZjlsService.insert(eqZjls);
        int[] x = {ydscxb.getYdId(), yqEqId};
//        return new ResponseResult<>(200, x);
        return new ResponseResult<int[]>(200, x);
    }


    //只根据id更新检测数据
    @RequestMapping("/updataNow/{id}")
    public com.litbo.hospitalzj.util.ResponseResult updataNow(@PathVariable("id")Integer id, HttpServletRequest req){
        Ydscxb ydscxb = CommonUtils.toBean(req.getParameterMap(), Ydscxb.class);
        ydscxb.setYdId(id);
        //更新
        ydscxbService.updateYdscxb(ydscxb);
        return new com.litbo.hospitalzj.util.ResponseResult(200, id);
    }

    @RequestMapping("/updataYdscxb")
    public ResponseResult updataYdscxb(
            @RequestParam("eqId")String eqId,
            @RequestParam("jcyqId") String jcyqId,
            HttpSession session,
            HttpServletRequest req){
        Ydscxb last1 = ydscxbService.findByEqIdandJcyqIdLast1(eqId, jcyqId);
        Ydscxb ydscxb = CommonUtils.toBean(req.getParameterMap(), Ydscxb.class);
        ydscxb.setYdId(last1.getYdId());
        //更新
        ydscxbService.updateYdscxb(ydscxb);
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

        int[] x = {ydscxb.getYdId(), yqEqId,userEqId};
        return new ResponseResult<int[]>(200, x);
    }


    //修改录入数据
  /*  @RequestMapping("/updateYdscxb")
    public ResponseResult<Void> updateYdscxb(Ydscxb ydscxb) {
        ydscxbService.updateYdscxb(ydscxb);
        return new ResponseResult<Void>(200);
    }*/

    //查询本设备的最后一条
    @RequestMapping("/findYdscxb")
    public ResponseResult<Ydscxb> findYdscxb(String eqId) {
        ydscxbService.findYdscxb(eqId);
        return new ResponseResult<Ydscxb>(200);
    }

    //查询全部数据的最后一条
    @RequestMapping("/find")
    public ResponseResult<Ydscxb> find() {
        ydscxbService.find();
        return new ResponseResult<Ydscxb>(200);
    }

    /**
     * 查询根据设备IDand检测仪器id电气检测表数据查询最后一条记录
     *
     * @return
     */
    @RequestMapping("/findByEqIdandJcyqIdLast1")
    public ResponseResult<Ydscxb> findByEqIdandJcyqIdLast1(@RequestParam("eqId") String eqId, @RequestParam("jcyqId") String jcyqId) {
        Ydscxb list = ydscxbService.findByEqIdandJcyqIdLast1(eqId, jcyqId);
        return new ResponseResult<Ydscxb>(200, list);
    }

    /**
     * 查询根据设备IDand检测仪器id电气检测表数据
     *
     * @return
     */
    @RequestMapping("/findByEqIdandJcyqId")
    public ResponseResult<List<Ydscxb>> findByEqIdandJcyqId(@RequestParam("eqId") String eqId, @RequestParam("jcyqId") String jcyqId) {
        List<Ydscxb> list = ydscxbService.findByEqIdandJcyqId(eqId, jcyqId);
        return new ResponseResult<List<Ydscxb>>(200, list);
    }

    //查询所有
    @RequestMapping("/findAll")
    public ResponseResult<List<Ydscxb>> findAll() {
        return new ResponseResult<List<Ydscxb>>(200, ydscxbService.findAll());
    }

    /**
     * 查询根据检测仪器id检测表数据
     *
     * @return
     */
    @RequestMapping("/findByYdId")
    public ResponseResult<Ydscxb> findByYdId(Integer ydId) {
        Ydscxb list = ydscxbService.findByYdId(ydId);
        return new ResponseResult<Ydscxb>(200, list);
    }

    //修改审核人建议同时修改状态
    @RequestMapping("/updateShrJcjy")
    public ResponseResult<Void> updateShrJcjy(@RequestParam("ydId") Integer ydId,
                                              @RequestParam("jcyqId") Integer jcyqId,
                                              @RequestParam("eqId") Integer eqId,
                                              @RequestParam("shrJcjl") String shrJcjl,
                                              @RequestParam("state") Integer state, HttpSession session) {
        String auditor = getUserNameFromSession(session);
        Integer yqEqId = yqEqService.findId(jcyqId, eqId);
        ydscxbService.updateShrJcjy(ydId, shrJcjl, auditor);
        if (state.equals(1)) {
            yqEqService.updateState(yqEqId, 1);
        } else {
            yqEqService.updateState(yqEqId, 2);
        }
        return new ResponseResult<Void>(200);
    }
}
