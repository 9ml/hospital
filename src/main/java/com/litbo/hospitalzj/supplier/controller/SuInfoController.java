package com.litbo.hospitalzj.supplier.controller;

import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.sf.entity.Code;
import com.litbo.hospitalzj.supplier.entity.SuInfo;
import com.litbo.hospitalzj.supplier.service.CodeService;
import com.litbo.hospitalzj.supplier.service.SuInfoService;
import com.litbo.hospitalzj.supplier.vo.SuInfoAndZzInfo;
import com.litbo.hospitalzj.util.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/suinfo")
@Slf4j
public class SuInfoController extends BaseController {
    @Autowired
    private SuInfoService suInfoService;
    @Autowired
    private CodeService codeService;
    @RequestMapping("/login")
    public ResponseResult<SuInfo> handleLogin(
            @RequestParam("username") String suMc,
            @RequestParam("password") String password,
            HttpSession session) {
        // 执行登录
        SuInfo user = suInfoService.login(suMc, password);
        System.out.println(user.getSuId());
        session.setAttribute("suMc", user.getSuMc());
        session.setAttribute("suId", user.getSuId());
        System.out.println(getUidFromSession(session));
        // 返回
        return new ResponseResult<>(SUCCESS, user);
    }
    @Transactional
    @RequestMapping("/updatePassword")
    public ResponseResult updatePassword(String suEmail,String code ,String password){
        Code res = codeService.findCodeAndEmail(suEmail,code);
        if(res == null){
            return new ResponseResult<>(ERROR, "验证码错误");
        }
        suInfoService.updatePwdByEmail(suEmail,password);
        return new ResponseResult<>(SUCCESS, "修改成功！");
    }
    @Transactional
    @RequestMapping("/forget")
    public ResponseResult forget(String suEmail){
        Integer res = suInfoService.isExistByEmail(suEmail);
        if(res!=null){
            String subject = "主题:南方医院账户验证码";
            String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
            String text = "您的医院系统登录用户名是" + suEmail + "," + "验证码是"
                    + verifyCode + ",请妥善管理！如何自己没进行修改密码操作，则忽略本条信息，谢谢合作！！！";
            try {
                Code code = new Code();
                code.setCode(verifyCode);
                code.setSuEmail(suEmail);
                codeService.deleteAllCodeByEmail(suEmail);
                codeService.insertCode(code);
                suInfoService.sendCodeMail(suEmail, subject, text);
                return new ResponseResult<>(ERROR);
            }catch (Exception e){
                return new ResponseResult<>(ERROR);
            }
        }else {
            return new ResponseResult(SUCCESS,"该邮箱不存在");
        }



    }
    @RequestMapping("/one")
    public ResponseResult<SuInfoAndZzInfo> getByCode(HttpSession session) {
        Integer suId = getUidFromSession(session);
        SuInfoAndZzInfo data = suInfoService.findSuById(suId);
        return new ResponseResult<SuInfoAndZzInfo>(SUCCESS, data);
    }

    @RequestMapping("/findSuById")
    public ResponseResult<SuInfoAndZzInfo> findSuById(Integer suId) {
        SuInfoAndZzInfo data = suInfoService.findSuById(suId);
        return new ResponseResult<SuInfoAndZzInfo>(SUCCESS, data);
    }

    @RequestMapping("/insert")
    public ResponseResult<Integer> insert(SuInfo suInfo) {
        try{
            suInfo.setIsDelete(0);
            suInfo.setState(4);
            int insert = suInfoService.insert(suInfo);
            if(insert == 1){
                return new ResponseResult<>(603, "该公司名称已存在！");
            }
            return new ResponseResult<Integer>(SUCCESS, suInfo.getSuId());
        }catch (Exception e){
            e.printStackTrace();
            log.error(suInfo.toString());
            log.error(e.getMessage());
            return new ResponseResult<>(ERROR,"服务器异常");
        }

    }

    @RequestMapping("/delete")
    public ResponseResult<Void> delete(@RequestParam("suId") Integer suId) {
        suInfoService.delete(suId, 1);
        return new ResponseResult<Void>(SUCCESS);
    }

    @RequestMapping("/all")
    public ResponseResult<List<SuInfo>> getAll() {
        List<SuInfo> data = suInfoService.selectAll();
        return new ResponseResult<List<SuInfo>>(SUCCESS, data);
    }

    @RequestMapping("/update")
    public ResponseResult<Void> update(SuInfo suInfo) {
        suInfoService.update(suInfo);
        return new ResponseResult<Void>(SUCCESS);
    }


    // 发邮件，改状态
    @RequestMapping("/updateStateIs")
    public ResponseResult updateStateIs(Integer suId) {
        try {
            SuInfoAndZzInfo suinfo = suInfoService.findSuinfoById(suId);
            suInfoService.updateState(suId, 1);
            String subject = "主题:南方医院账户密码验证";
            String password = suinfo.getSuEmail().substring(0, 4);
            String text = "您的医院系统登录用户名是" + suinfo.getSuMc() + "," + "登录密码是"
                    + password + ",请妥善管理！如有遗失，请联系系统管理员，谢谢合作！！！";

            sendMail(suId, suinfo.getSuEmail(), password, subject, text);

            return new ResponseResult<>(200);
        } catch (Exception e) {
            suInfoService.updateState(suId, 3);
            e.printStackTrace();
            return new ResponseResult<>(500);
        }
    }

    //发送密码和用户
    //@RequestMapping("/mail")
    public void sendMail(Integer suId, String email, String password,
                         String subject, String text
    ) throws MessagingException {
        suInfoService.sendEmail(suId, email, password, subject, text);

    }


    @RequestMapping("/updateStateNot")
    public ResponseResult updateStateNot(Integer suId) {
        try {
            SuInfoAndZzInfo suinfo = suInfoService.findSuinfoById(suId);
            suInfoService.updateState(suId, 2);
            String subject = "主题:南方医院注册通知";
            String text = "对不起! 您的注册申请未通过审核！";
            sendMail(suId, suinfo.getSuEmail(), null, subject, text);

            return new ResponseResult<>(200);
        } catch (MessagingException e) {
            suInfoService.updateState(suId, 3);
            e.printStackTrace();
            return new ResponseResult<>(500);
        }

    }


    @RequestMapping("/findBySuMcLike")
    public ResponseResult<List<SuInfo>> findBySuMcLike(String suMc) {
        List<SuInfo> data = suInfoService.findBySuMcLike(suMc);
        return new ResponseResult<List<SuInfo>>(SUCCESS, data);
    }

    //待审核供应商
    @RequestMapping("/findSuByStateSh")
    public ResponseResult<List<SuInfo>> findSuByStateSh() {
        List<SuInfo> data = suInfoService.findSuByState(0);
        return new ResponseResult<List<SuInfo>>(SUCCESS, data);
    }

    //已审核供应商
    @RequestMapping("/findSuByStateXg")
    public ResponseResult<List<SuInfo>> findSuByStateXg() {
        List<SuInfo> data = suInfoService.findSuByState(1);
        return new ResponseResult<List<SuInfo>>(SUCCESS, data);
    }

    //供应商申请数量
    @RequestMapping("/countByGyssq")
    public ResponseResult<Integer> countByGyssq() {
        Integer data = suInfoService.count(0);
        return new ResponseResult<Integer>(SUCCESS, data);
    }

    //修改密码
    @RequestMapping("/updatePwd")
    public ResponseResult<Void> updatePwd(@RequestParam("suId") Integer suId, @RequestParam("password") String password) {
        suInfoService.updatePwd(suId, password);
        return new ResponseResult<Void>(SUCCESS);
    }










}