package com.litbo.hospitalzj.checklist.controller;

import com.litbo.hospitalzj.checklist.domain.Gpdd;
import com.litbo.hospitalzj.checklist.domain.Hxj;
import com.litbo.hospitalzj.checklist.domain.HxjTemplate;
import com.litbo.hospitalzj.checklist.service.HxjService;
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
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/hxj")
public class HxjController extends BaseController {

    @Autowired
    private HxjService hxjService;
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
    public ResponseResult<HxjTemplate> findTemplate(){
        return new ResponseResult<HxjTemplate>(200, hxjService.findTemplate());
    }
    //修改模板值
    @RequestMapping("/updateTemplate")
    public ResponseResult<Void> updateTemplate(HxjTemplate hxjTemplate){
        hxjService.updateHxjTemplate(hxjTemplate);
        return new ResponseResult<Void>(200);
    }
    //插入模板值
    @RequestMapping("/insert")
    public ResponseResult<Void> insert(HxjTemplate hxjTemplate){
        hxjService.insertHxjTemplate(hxjTemplate);
        return new ResponseResult<Void>(200);
    }

    //保存呼吸机检测数据
    @RequestMapping("/save")
    public ResponseResult saveChild(@RequestParam("eqId") String eqId,
                                    @RequestParam("jcyqId") String jcyqId,
                                    @RequestParam(value = "userEqId") Integer userEqId,
                                    HttpServletRequest req){
        Hxj hxj = CommonUtils.toBean(req.getParameterMap(), Hxj.class);
        int yqEqId=yqEqService.insertBatch(eqId,jcyqId);
        yqEqService.updateType(yqEqId, EnumProcess2.TO_UPLOAD.getMessage());
        //修改状态为待上传
        userEqService.setEqState(userEqId,EnumProcess2.TO_UPLOAD.getMessage());
        hxjService.save(hxj);
        EqZjls eqZjls = CommonUtils.toBean(req.getParameterMap(), EqZjls.class);
        EqInfo eqById = eqInfoService.findEqById(eqId);
        eqZjls.setEqMc(eqById.getEqMc());
        eqZjls.setEqDah(eqById.getEqDah());
        eqZjlsService.insert(eqZjls);
        int[] x={hxj.getHxjid(),yqEqId};
        return new ResponseResult(200, x);
    }

    //只根据id更新检测数据
    @RequestMapping("/updataNow/{id}")
    public com.litbo.hospitalzj.util.ResponseResult updataNow(@PathVariable("id")Integer id, HttpServletRequest req){
        Hxj hxj = CommonUtils.toBean(req.getParameterMap(), Hxj.class);
        hxj.setHxjid(id);
        //更新
        hxjService.updateHxj(hxj);
        return new com.litbo.hospitalzj.util.ResponseResult(200, id);
    }




    //修改录入数据
    @RequestMapping("/updataHxj")
    public ResponseResult updataHxj(
            @RequestParam("eqId")String eqId,
            @RequestParam("jcyqId") String jcyqId,
            HttpSession session,
            HttpServletRequest req){
        Hxj last1 = hxjService.findByEqIdandJcyqIdLast1(eqId, jcyqId);
        Hxj hxj = CommonUtils.toBean(req.getParameterMap(), Hxj.class);
        hxj.setHxjid(last1.getHxjid());
        //更新
        hxjService.updateHxj(hxj);
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


        int[] x={hxj.getHxjid(),yqEqId,userEqId};
        return new ResponseResult(200, x);
    }


    //查询本设备的最后一条
    @RequestMapping("/findGpdd")
    public ResponseResult<Hxj> findGpdd(String eqId){
        hxjService.findHxj(eqId);
        return new ResponseResult<Hxj>(200);
    }
    /**
     * 查询根据设备IDand检测仪器id电气检测表数据查询最后一条记录
     * @return
     */
    @RequestMapping("/findByEqIdandJcyqIdLast1")
    public ResponseResult<Hxj> findByEqIdandJcyqIdLast1(@RequestParam("eqId")String eqId, @RequestParam("jcyqId")String jcyqId){
        Hxj list = hxjService.findByEqIdandJcyqIdLast1(eqId,jcyqId);
        return new ResponseResult<Hxj>(200, list);
    }
    /**
     * 查询根据设备IDand检测仪器id电气检测表数据
     * @return
     */
    @RequestMapping("/findByEqIdandJcyqId")
    public ResponseResult<List<Hxj>> findByEqIdandJcyqId(@RequestParam("eqId")String eqId, @RequestParam("jcyqId")String jcyqId){
        List<Hxj> list = hxjService.findByEqIdandJcyqId(eqId,jcyqId);
        return new ResponseResult<List<Hxj>>(200, list);
    }
    //查询所有
    @RequestMapping("/findAll")
    public ResponseResult<List<Hxj>> findAll(){
        List<Hxj> data=hxjService.findAll();
        return new ResponseResult<List<Hxj>>(200,data);
    }
    /**
     * 查询根据检测仪器id检测表数据
     * @return
     */
    @RequestMapping("/findByHxjId")
    public ResponseResult<Hxj> findByHxjId(Integer hxjId){
        Hxj list = hxjService.findByHxjId(hxjId);
        return new ResponseResult<Hxj>(200, list);
    }
    //修改审核人建议同时修改状态
    @RequestMapping("/updateShrJcjy")
    public ResponseResult<Void> updateShrJcjy(@RequestParam("hxjid")Integer hxjid,
                                               @RequestParam("jcyqId")Integer jcyqId,
                                               @RequestParam("eqId")Integer eqId,
                                               @RequestParam("shrJcjl")String shrJcjl,
                                               @RequestParam("state")Integer state,
                                              HttpSession session){
        String auditor=getUserNameFromSession(session);
        Integer yqEqId= yqEqService.findId(jcyqId,eqId);
        hxjService.updateShrJcjy(hxjid,shrJcjl,auditor);
        if(state.equals(1)){
            yqEqService.updateState(yqEqId,1);
        }else{
            yqEqService.updateState(yqEqId,2);
        }
        return new ResponseResult<Void>(200);
    }

}
