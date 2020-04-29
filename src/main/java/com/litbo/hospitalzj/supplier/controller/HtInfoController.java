package com.litbo.hospitalzj.supplier.controller;

import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.hospital.enums.EnumProcess;
import com.litbo.hospitalzj.supplier.entity.*;
import com.litbo.hospitalzj.supplier.mapper.EqInfoMapper;
import com.litbo.hospitalzj.supplier.service.*;
import com.litbo.hospitalzj.supplier.util.Message;
import com.litbo.hospitalzj.supplier.util.StringRandom;
import com.litbo.hospitalzj.supplier.vo.EqHtVo;
import com.litbo.hospitalzj.supplier.vo.SelHtEqVo;
import com.litbo.hospitalzj.user.bean.Wjsc;
import com.litbo.hospitalzj.user.service.WjscService;
import com.litbo.hospitalzj.util.MailUtils;
import com.litbo.hospitalzj.util.ResponseResult;
import io.swagger.models.auth.In;
import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/htInfo")
public class HtInfoController extends BaseController {
    @Autowired
    private HtInfoService htinfoService;
    @Autowired
    public HtLcService htLcService;
    @Autowired
    private EqInfoMapper eqInfoMapper;
    @Autowired
    private JavaMailSender mailSender; //自动注入的Bean
    @Autowired
    private SgdjHwService sgdjHwService;
    @Autowired
    private EqFjService eqFjService;
    @Autowired
    private EqInfoService eqInfoService;
    @Autowired
    private EqFseqService eqFseqService;
    @Autowired
    private WjscService wjscService;

    @Value("${spring.mail.username}")
    private String Sender; //读取配置文件中的参数


    @RequestMapping("/delete")
    public ResponseResult deleteById(String htId) {
        htinfoService.deleteById(htId);
        List<EqInfo> eqInfos = eqInfoMapper.selectEqinfo(Integer.parseInt(htId));
        for (EqInfo eqInfo : eqInfos) {
            EqInfo eq = eqInfoService.selectByEqId(eqInfo.getEqId());
            eqInfoService.deleteBat(eq);
        }
        return new ResponseResult(200);
    }

    @RequestMapping("countDws")
    public ResponseResult<Integer> countDws(HttpSession session) {
        String suMc = (String) session.getAttribute("suMc");
        if (suMc != null) {
            List<HtInfo> htInfos = htinfoService.findBySuMc(suMc);
            return new ResponseResult<>(200, htInfos.size());
        } else {
            return new ResponseResult<>(500, "您还没有登录");
        }
    }


    @RequestMapping("/findAll")
    public ResponseResult<List<HtInfo>> findAll(HttpSession session) {
        String suMc = (String) session.getAttribute("suMc");
        if (suMc != null) {
            List<HtInfo> htInfos = htinfoService.findBySuMc(suMc);
            return new ResponseResult<>(200, htInfos);
        } else {
            return new ResponseResult<>(500, "您还没有登录");
        }
    }


    @RequestMapping("/ysbg/{htId}")
    public ResponseResult<List<Object>> findYsbgByHtid(@PathVariable("htId") Integer htId) {
        HtInfo htInfo = htinfoService.select(htId);
        List<SelHtEqVo> htEqVos = eqInfoService.selectGroupEqHtVo2(htId);
        List<Object> eqFj =  new ArrayList<>();
        List<EqFj> eqFjs = new ArrayList<>();
        List<Object> eqfjeq = new ArrayList<>();
        for (SelHtEqVo eqInfo : htEqVos) {
            Integer eqId = eqInfo.getEqId();
            eqFjs = eqFjService.selectEqFjGroup(eqId);
            eqfjeq.add(eqFseqService.selectEqFseqGroup(eqId));
            eqFj.add(eqFjs);
        }
        SgdjHw sgdjHw = sgdjHwService.selectSgdjHw(htId);
        List<Wjsc> data0 = wjscService.selectByType(0, htId);
        List<Wjsc> data2 = wjscService.selectByType(2, htId);
        List<Object> list = new ArrayList<>();
        list.add(htInfo);
        list.add(sgdjHw);
        list.add(htEqVos);
        list.add(eqFj);
        list.add(eqfjeq);
        list.add(data0);
        list.add(data2);
        return new ResponseResult(200, list);
    }


    @RequestMapping("/province/{parent}")
    public ResponseResult<List<District>> findProvinceByParentId(@PathVariable("parent") String parent) {
        List<District> districts = htinfoService.findProvinceByParentId(parent);
        return new ResponseResult(200, districts);
    }

    @RequestMapping("/saveqm")
    public ResponseResult saveqm(@RequestParam(value = "htId") String htId, @RequestParam(value = "num") String num, @RequestParam(value = "img") String img) {
        String ims = img.replace(" ", "+");
        htinfoService.saveqm(htId, ims, Integer.parseInt(num));

        return new ResponseResult(200);
    }


    //增加合同
    @RequestMapping("/insert")
    public ResponseResult<Integer> insertHtInfo(HtInfo htInfo, HttpSession session) {
        htInfo.setSbcsId(getUidFromSession(session));
        htinfoService.InsertHtInfo(htInfo);
        int htId = htInfo.getHtId();
        session.setAttribute("htId", htId);
        htinfoService.updateHtInfoState(htId, "0");
        htLcService.InsertHtLc(htId, EnumProcess.CONTRACT_ENTRY.getMessage(), new Date());
        return new ResponseResult<Integer>(SUCCESS, htInfo.getHtId());
    }

    //设置状态，预约验收
    @RequestMapping("/yyys")
    public ResponseResult<Void> updataStatePerfect(String view, Integer htId) {
        if ("同意".equals(view)) {
            //预约验收
            htinfoService.updateHtInfoState(htId, EnumProcess.APPOINMENT_ACCEPTANCE.getMessage());
            htLcService.InsertHtLc(htId, EnumProcess.APPOINMENT_ACCEPTANCE.getMessage(), new Date());
        } else {
            //合同信息不完善
            htinfoService.updateHtInfoState(htId, EnumProcess.IMPERFECT_CONTRACT_INFORMATION.getMessage());
            htLcService.InsertHtLc(htId, EnumProcess.IMPERFECT_CONTRACT_INFORMATION.getMessage(), new Date());
        }
        return new ResponseResult<Void>(SUCCESS);
    }

    //修改合同状态为已发货
    @RequestMapping("/tyys")
    public ResponseResult<Void> updataState(Integer htId) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = fmt.format(new Date());
        htinfoService.updateHtInfoStateAndTime(htId, format, EnumProcess.TONG_YI_YANSHOU.getMessage());
        htLcService.InsertHtLc(htId, EnumProcess.TONG_YI_YANSHOU.getMessage(), new Date());
        return new ResponseResult<Void>(SUCCESS);
    }

    //完善资料
    @RequestMapping("/wszl")
    public ResponseResult<Void> updataStatePerfectOne(Integer htId) {
        htinfoService.updateHtInfoState(htId, EnumProcess.PERFECT_INFORMATION.getMessage());
        htLcService.InsertHtLc(htId, EnumProcess.PERFECT_INFORMATION.getMessage(), new Date());
        return new ResponseResult<Void>(SUCCESS);
    }

    //等待审核验收
    @RequestMapping("/ddshys")
    public ResponseResult<Void> ddshys(@RequestParam("htId") Integer htId) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = fmt.format(new Date());
        htinfoService.updateHtInfoStateAndwsTime(htId, format, EnumProcess.WAIT_ACCEPT_YS.getMessage());
        htLcService.InsertHtLc(htId, EnumProcess.WAIT_ACCEPT_YS.getMessage(), new Date());
        return new ResponseResult<Void>(SUCCESS);
    }

    //验收完成
    @RequestMapping("/yswc")
    public ResponseResult<Integer> updataStatePerfectThree(Integer htId) {
        /*
        htinfoService.updateHtInfoState(htId, EnumProcess.ACCEPT_OVER.getMessage());
        htLcService.InsertHtLc(htId, EnumProcess.ACCEPT_OVER.getMessage(), new Date());
        eqInfoMapper.update(htId);*/
        HtInfo htInfo = htinfoService.select(htId);
        if("无".equals(htInfo.getHtGzspd())){
            return new ResponseResult<>(200, 1);
        }
        return new ResponseResult<>(200, 2);
    }

    //验收完成
    @RequestMapping("/updateYswc")
    public ResponseResult<Void> updataStatePerfectYswc(Integer htId) {
        htinfoService.updateHtInfoState(htId, EnumProcess.ACCEPT_OVER.getMessage());
        htLcService.InsertHtLc(htId, EnumProcess.ACCEPT_OVER.getMessage(), new Date());
        eqInfoMapper.update(htId);
        return new ResponseResult<>(200);
    }






    //审核验收不通过
    @RequestMapping("/ysbtg")
    public ResponseResult<Void> updataStatePerfectThree2(Integer htId) {
        htinfoService.updateHtInfoState(htId, EnumProcess.WAIT_ACCEPT_YS_NOT.getMessage());
        htLcService.InsertHtLc(htId, EnumProcess.WAIT_ACCEPT_YS_NOT.getMessage(), new Date());
        //eqInfoMapper.update(htId, 1);
        return new ResponseResult<Void>(SUCCESS);
    }

    //查询合同状态为 “同意验收”的数量，
    @RequestMapping("/countTyys")
    public ResponseResult selectCountTyys() {
        String type = "同意验收";
        int num = htinfoService.count(type);
        return new ResponseResult(200, num);
    }

    //查询合同状态为 “等待审核验收 + 同意验收”的数量
    @RequestMapping("/countTyysAndDdshys")
    public ResponseResult countTyysAndDdshys() {
        String type1 = "同意验收";
        String type2 = "等待审核验收";
        int num1 = htinfoService.count(type1);
        int num2 = htinfoService.count(type2);
        return new ResponseResult(200, num1 + num2);
    }

    @RequestMapping("/updateInfo")
    public ResponseResult<Void> updateInfo(HtInfo htInfo) {
        htinfoService.updateInfo(htInfo);
        htLcService.InsertHtLc(htInfo.getHtId(), EnumProcess.REVISE_A_CONTRACT.getMessage(), new Date());
        return new ResponseResult<Void>(SUCCESS);
    }

    //通过验证码查询全部合同设备信息
    @RequestMapping("/select")
    public ResponseResult<List<EqHtVo>> selectEqHtVo(String htYzm) {
        List<EqHtVo> data = htinfoService.selectEqHtVo(htYzm);
        return new ResponseResult<List<EqHtVo>>(SUCCESS, data);
    }

    //通过验证码查询合同信息
    @RequestMapping("/yzm")
    public ResponseResult<HtInfo> selectHtInfo(String htYzm) {
        HtInfo data = htinfoService.selectHtInfo(htYzm.toUpperCase());
        return new ResponseResult<HtInfo>(SUCCESS, data);
    }

    //通过合同id查询一条合同的信息
    @RequestMapping("/selectOne")
    public ResponseResult<HtInfo> selectOne(Integer htId) {
        HtInfo data = htinfoService.select(htId);
        return new ResponseResult<HtInfo>(SUCCESS, data);
    }

    //生成验证码，并修改
    @RequestMapping("/updateYzm")
    public ResponseResult<Void> updataYzm(@RequestParam("htId") Integer htId, @RequestParam("email") String email) {
        String htYzm = StringRandom.getStringRandom(6);
      /*  System.out.println(htYzm);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(Sender);
        message.setTo(email);*/
        String subject = "主题:南方医院合同验证码验证";
        String text = "您的医院系统合同验证码是: " + htYzm + " ,"
                + "此验证码是您查询合同流程的重要依据，请妥善管理！"
                + "如有遗失，请联系系统管理员，谢谢合作！！！";
      /*  message.setSubject();
        message.setText();
        mailSender.send(message);*/
        MailUtils.sendMail(email, text, subject);

        htinfoService.updateYzm(htId, htYzm, EnumProcess.WAIT_ACCEPT.getMessage());
        htLcService.InsertHtLc(htId, EnumProcess.WAIT_ACCEPT.getMessage(), new Date());
        return new ResponseResult<Void>(SUCCESS);
    }

    //拆分设备，是否需要检测
    @RequestMapping("/htjc")
    public ResponseResult<Void> htjc(@RequestParam("htId") Integer htId) {
        htinfoService.HtJC(htId);
        return new ResponseResult<Void>(SUCCESS);
    }

    //查询状态数量
    @RequestMapping("/countByYyys")
    public ResponseResult<Integer> htStateByYyys() {
        Integer data = htinfoService.count(EnumProcess.WAIT_ACCEPT.getMessage());
        return new ResponseResult<Integer>(SUCCESS, data);
    }

    //等待审核验收数量
    @RequestMapping("/countByDdshys")
    public ResponseResult<Integer> countByDdshys() {
        Integer all = htinfoService.count(EnumProcess.WAIT_ACCEPT_YS.getMessage());
        return new ResponseResult<Integer>(SUCCESS, all);
    }

    //同意验收数量
    @RequestMapping("/countByTyys")
    public ResponseResult<Integer> countByTyys() {
        Integer all = htinfoService.count(EnumProcess.TONG_YI_YANSHOU.getMessage());
        return new ResponseResult<Integer>(SUCCESS, all);
    }

    //调用接口发送短信
    @RequestMapping("/sendInfo")
    public ResponseResult<Integer> sendInfo() {
        Message.sendMessage();
        return new ResponseResult<Integer>(SUCCESS);
    }


}

