package com.litbo.hospitalzj.checklist.controller;

import com.litbo.hospitalzj.checklist.domain.Dcsjhy;
import com.litbo.hospitalzj.checklist.domain.Gpdd;
import com.litbo.hospitalzj.checklist.domain.SybC;
import com.litbo.hospitalzj.checklist.domain.SybCTemplate;
import com.litbo.hospitalzj.checklist.service.SybService;
import com.litbo.hospitalzj.checklist.utils.ResponseResult;
import com.litbo.hospitalzj.checklist.utils.commons.CommonUtils;
import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.user.bean.EqZjls;
import com.litbo.hospitalzj.user.service.EqZjlsService;
import com.litbo.hospitalzj.zk.Enum.EnumProcess2;
import com.litbo.hospitalzj.zk.domian.EqInfo;
import com.litbo.hospitalzj.zk.domian.TabEq;
import com.litbo.hospitalzj.zk.service.EqInfoService;
import com.litbo.hospitalzj.zk.service.TabEqService;
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

/**
 * 输液泵Controller
 */
@RestController
@RequestMapping("/syb")
public class SybController extends BaseController {

    @Autowired
    private SybService sybService;
    @Autowired
    private UserEqService userEqService;
    @Autowired
    private YqEqService yqEqService;
    @Autowired
    private TabEqService tabEqService;
    @Autowired
    private EqZjlsService eqZjlsService;
    @Autowired
    private EqInfoService eqInfoService;
    //插入模板数据
    //插入输液泵儿童模板值
    @RequestMapping("/insertChildTemplate")
    public ResponseResult insertChildTemplate(SybCTemplate template){
        sybService.insertChildTemplate(template);
        return new ResponseResult(200);
    }
    //插入输液泵成人模板值
    @RequestMapping("/insertManTemplate")
    public ResponseResult insertManTemplate(SybCTemplate template){
        sybService.insertManTemplate(template);
        return new ResponseResult(200);
    }

    //查询模板数据（成年人）
    @RequestMapping("/findManTemplate")
    public ResponseResult<SybCTemplate> findManTemplate(){
        String template = "syb_m_template";
        return new ResponseResult<SybCTemplate>(200, sybService.findTemplate(template));
    }
    //查询模板数据（儿童 ）
    @RequestMapping("/findChildTemplate")
    public ResponseResult<SybCTemplate> findChildTemplate(){
        String template = "syb_c_template";
        return new ResponseResult<SybCTemplate>(200, sybService.findTemplate(template));
    }

    //修改模板数据
    //幼儿
    @RequestMapping("/updateC")
    public ResponseResult updateC(SybCTemplate template){
        sybService.updateC(template);
        return new ResponseResult(200);
    }

    //成人
    @RequestMapping("/updateM")
    public ResponseResult updateM(SybCTemplate template){
        sybService.updateM(template);
        return new ResponseResult(200);
    }







    //修改幼儿数据表信息
    @RequestMapping("/saveChild")
    public ResponseResult saveChild(@RequestParam(value = "eqId") String eqId,
                                          @RequestParam(value = "jcyqId") String jcyqId,
                                          @RequestParam(value = "userEqId") Integer userEqId,
                                           HttpServletRequest req){
        SybC sybC = CommonUtils.toBean(req.getParameterMap(), SybC.class);
        int yqEqId=yqEqService.insertBatch(eqId,jcyqId);
        yqEqService.updateType(yqEqId, EnumProcess2.TO_UPLOAD.getMessage());
        //修改状态为待上传
        userEqService.setEqState(userEqId,EnumProcess2.TO_UPLOAD.getMessage());
        sybService.saveChild(sybC);

        //质检流水
        EqZjls eqZjls = CommonUtils.toBean(req.getParameterMap(), EqZjls.class);
        EqInfo eqById = eqInfoService.findEqById(eqId);
        eqZjls.setEqMc(eqById.getEqMc());
        eqZjls.setEqDah(eqById.getEqDah());
        eqZjlsService.insert(eqZjls);

        TabEq table=new TabEq();
        table.setEqId(Integer.valueOf(eqId));
        table.setJcyqId(Integer.valueOf(jcyqId));
        table.setTableName("syb_c");
        table.setValue(1);
        tabEqService.insert(table);
        long[] x={sybC.getId(),yqEqId};
        return new ResponseResult(200, x);
    }



    //只根据id更新检测数据
    @RequestMapping("/updataNowMan/{id}")
    public com.litbo.hospitalzj.util.ResponseResult updataNowMan(@PathVariable("id")Integer id, HttpServletRequest req){
        SybC syb_m = CommonUtils.toBean(req.getParameterMap(), SybC.class);
        syb_m.setId(id);
        //更新
        sybService.updateMan(syb_m);
        return new com.litbo.hospitalzj.util.ResponseResult(200, id);
    }


    //只根据id更新检测数据
    @RequestMapping("/updataNowChild/{id}")
    public com.litbo.hospitalzj.util.ResponseResult updataNowChild(@PathVariable("id")Integer id, HttpServletRequest req){
        SybC syb_c = CommonUtils.toBean(req.getParameterMap(), SybC.class);
        syb_c.setId(id);
        //更新
        sybService.updateChild(syb_c);
        return new com.litbo.hospitalzj.util.ResponseResult(200, id);
    }


    @RequestMapping("/updatachild")
    public ResponseResult updataChild(
            @RequestParam("eqId")String eqId,
            @RequestParam("jcyqId") String jcyqId,
            HttpSession session,
            HttpServletRequest req){
        SybC syb_m = sybService.findByEqIdandJcyqIdLast("syb_c", eqId, jcyqId);
        SybC sybC = CommonUtils.toBean(req.getParameterMap(), SybC.class);
        sybC.setId(syb_m.getId());
        //更新
        sybService.updateChild(sybC);
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

        long[] x={sybC.getId(),yqEqId,userEqId};
        return new ResponseResult(200, x);
    }



    /*@RequestMapping("/updateChild")
    public ResponseResult<SybC> updateChild(SybC sybC){
        sybService.updateChild(sybC);
        return new ResponseResult<SybC>(200, sybC);
    }*/

    @RequestMapping("/saveman")
    public ResponseResult saveMan(@RequestParam(value = "eqId") String eqId,
                                  @RequestParam(value = "jcyqId") String jcyqId,
                                  @RequestParam(value = "userEqId") Integer userEqId,
                                   HttpSession session, HttpServletRequest req){
        SybC sybC = CommonUtils.toBean(req.getParameterMap(), SybC.class);
        int yqEqId=yqEqService.insertBatch(eqId,jcyqId);
        yqEqService.updateType(yqEqId, EnumProcess2.TO_UPLOAD.getMessage());
        //修改状态为待上传
        userEqService.setEqState(userEqId,EnumProcess2.TO_UPLOAD.getMessage());
        sybService.saveMan(sybC);

        //质检流水
        EqZjls eqZjls = CommonUtils.toBean(req.getParameterMap(), EqZjls.class);
        EqInfo eqById = eqInfoService.findEqById(eqId);
        eqZjls.setEqMc(eqById.getEqMc());
        eqZjls.setEqDah(eqById.getEqDah());
        eqZjlsService.insert(eqZjls);

        TabEq table=new TabEq();
        table.setEqId(Integer.valueOf(eqId));
        table.setJcyqId(Integer.valueOf(jcyqId));
        table.setTableName("syb_m");
        table.setValue(2);
        tabEqService.insert(table);
        long[] x={sybC.getId(),yqEqId};
        return new ResponseResult(200,x);
    }


    @RequestMapping("/updataman")
    public ResponseResult updataMan(
            @RequestParam("eqId")String eqId,
            @RequestParam("jcyqId") String jcyqId,
            HttpSession session,
            HttpServletRequest req){
        SybC syb_m = sybService.findByEqIdandJcyqIdLast("syb_m", eqId, jcyqId);
        SybC sybC = CommonUtils.toBean(req.getParameterMap(), SybC.class);
        sybC.setId(syb_m.getId());
        //更新
        sybService.updateMan(sybC);
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
        long[] x={sybC.getId(),yqEqId,userEqId};
        return new ResponseResult(200, x);
    }


   /* @RequestMapping("/updateMan")
    public ResponseResult<SybC> updateMan(SybC sybC){
        sybService.updateMan(sybC);
        return new ResponseResult<SybC>(200, sybC);
    }*/
    //查询所有录入信息(成人)
    @RequestMapping("/findAllMan")
    public ResponseResult<List<SybC>> findAllMan(){
        return new ResponseResult<List<SybC>>(200, sybService.findAll("syb_m"));
    }
    //查询所有录入信息(儿童)
    @RequestMapping("/findAllChild")
    public ResponseResult<List<SybC>> findAllChild(){
        return new ResponseResult<List<SybC>>(200, sybService.findAll("syb_c"));
    }
    
    @RequestMapping("/findByidM")
    public ResponseResult<SybC> findByidM(Integer id){
        String tableName="syb_m";
        return new ResponseResult<SybC>(200, sybService.findByid(id,tableName));
    }
    @RequestMapping("/findByidC")
    public ResponseResult<SybC> findByidC(Integer id){
        String tableName="syb_c";
        return new ResponseResult<SybC>(200, sybService.findByid(id,tableName));
    }
    //查询最后录入的一条检测信息
    @RequestMapping("/findByEqIdandJcyqIdLast1")
    public ResponseResult findByEqIdandJcyqIdLast1(@RequestParam("eqId")String eqId, @RequestParam("jcyqId") String jcyqId){
        TabEq table=tabEqService.findTable(Integer.valueOf(eqId),Integer.valueOf(jcyqId));
        SybC data=sybService.findByEqIdandJcyqIdLast(table.getTableName(),eqId,jcyqId);
        return new ResponseResult(200,data);
    }
    @RequestMapping("/findByEqIdandJcyqId")
    public ResponseResult<List<SybC>> findByEqIdandJcyqId(@RequestParam("eqId")String eqId, @RequestParam("jcyqId") String jcyqId){
        TabEq table=tabEqService.findTable(Integer.valueOf(eqId),Integer.valueOf(jcyqId));
        List<SybC> data=sybService.findByEqIdandJcyqId(table.getTableName(),eqId,jcyqId);
        return new ResponseResult<List<SybC>>(200,data);
    }

   /* @RequestMapping("/findByEqIdandJcyqIdLast1C")
    public ResponseResult<SybC> findByEqIdandJcyqIdLast1C(@RequestParam("eqId")String eqId,@RequestParam("jcyqId") String jcyqId){
        SybC data=sybService.findByEqIdandJcyqIdLast1C(eqId, jcyqId);
        return new ResponseResult<SybC>(200,data);
    }
    @RequestMapping("/findByEqIdandJcyqIdC")
    public ResponseResult<List<SybC>> findByEqIdandJcyqIdC(@RequestParam("eqId")String eqId, @RequestParam("jcyqId")String jcyqId){
        List<SybC> data=sybService.findByEqIdandJcyqIdC(eqId,jcyqId);
        return new ResponseResult<List<SybC>>(200, data);
    }

    @RequestMapping("/findByEqIdandJcyqIdLast1M")
    public ResponseResult<SybC> findByEqIdandJcyqIdLast1M(@RequestParam("eqId")String eqId,@RequestParam("jcyqId") String jcyqId){
        SybC data=sybService.findByEqIdandJcyqIdLast1C(eqId, jcyqId);
        return new ResponseResult<SybC>(200,data);
    }
    @RequestMapping("/findByEqIdandJcyqIdM")
    public ResponseResult<List<SybC>> findByEqIdandJcyqIdM(@RequestParam("eqId")String eqId, @RequestParam("jcyqId")String jcyqId){
        List<SybC> data=sybService.findByEqIdandJcyqIdM(eqId,jcyqId);
        return new ResponseResult<List<SybC>>(200, data);
    }*/
    //修改审核人意见
    @RequestMapping("/updateShrJcjyM")
    public ResponseResult<Void> updateShrJcjyM(@RequestParam("id")Integer id, @RequestParam("jcyqId")Integer jcyqId,
                                               @RequestParam("eqId")Integer eqId, @RequestParam("shrJcjl")String shrJcjl,
                                               @RequestParam("state")Integer state, HttpSession session){
        String auditor=getUserNameFromSession(session);
        Integer yqEqId= yqEqService.findId(jcyqId,eqId);
        sybService.updateShrJcjyM(id,shrJcjl,auditor);
        if(state.equals(1)){
            yqEqService.updateState(yqEqId,1);
        }else{
            yqEqService.updateState(yqEqId,2);
        }
        return new ResponseResult<Void>(200);
    }
    @RequestMapping("/updateShrJcjyC")
    public ResponseResult<Void> updateShrJcjyC(@RequestParam("id")Integer id, @RequestParam("jcyqId")Integer jcyqId,
                                               @RequestParam("eqId")Integer eqId, @RequestParam("shrJcjl")String shrJcjl,
                                               @RequestParam("state")Integer state, HttpSession session){
        String auditor=getUserNameFromSession(session);
        Integer yqEqId= yqEqService.findId(jcyqId,eqId);
        sybService.updateShrJcjyC(id,shrJcjl,auditor);
        if(state.equals(1)){
            yqEqService.updateState(yqEqId,1);
        }else{
            yqEqService.updateState(yqEqId,2);
        }
        return new ResponseResult<Void>(200);
    }
}
