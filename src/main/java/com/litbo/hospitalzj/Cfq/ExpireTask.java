package com.litbo.hospitalzj.Cfq;

import com.litbo.hospitalzj.sf.service.UserService;
import com.litbo.hospitalzj.supplier.mapper.CodeMapper;
import com.litbo.hospitalzj.zk.domian.Yq;
import com.litbo.hospitalzj.zk.domian.YqTsls;
import com.litbo.hospitalzj.zk.mapper.YqTslsMapper;
import com.litbo.hospitalzj.zk.service.YqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.List;
@Component
public class ExpireTask {
    @Autowired
    private UserService userService;
    @Autowired
    private YqService yqService;
    @Autowired
    private YqTslsMapper yqTslsMapper;
    @Autowired
    private CodeMapper codeMapper;
    //每天早上0点执行
    @Scheduled(cron = "0 0 10,14,16 * * ? ")
    public void productExpire() {
        //距离到期还有2个月提醒
        String twoMonthExpireDate = DateUtil.addTwoMonth();
        dealExpireYq(twoMonthExpireDate);

    }
    private void dealExpireYq(String expireDate){
        List<Yq> data=yqService.selectTime();
        YqTsls yqTsls=new YqTsls();
        for(Yq yq:data){
          Calendar calendar = Calendar.getInstance();
          calendar.setTime(yq.getJcyqJzTime());
          calendar.add(Calendar.MONTH, 12);
          yqTsls.setYqExpireDate(calendar.getTime());
          yqTsls.setYqName(yq.getJcyqName());
          yqTsls.setPushMsg("您的检测仪器时间：" + yq.getJcyqName() + "，将于" + calendar.getTime() + "即将过期，请及时处理！");
          yqTslsMapper.insert(yqTsls);
      }
    }
    @Scheduled(cron = "0 0 12,15,17 * * ? ")
    public void pushMsgExpire() {
        List<Yq> data=yqService.selectTime();
        YqTsls yqTsls=new YqTsls();
        for(Yq yq:data) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(yq.getJcyqJzTime());
            calendar.add(Calendar.MONTH, 12);
            //推送消息只存在1天，根据到期时间将数据删除
            yqTslsMapper.delete(calendar.getTime());
        }
    }
    //每天晚上删除验证码
    @Scheduled(cron = "0 0 1 * * ?")
    public void deletCode(){
        codeMapper.deleteAllCode();
    }
    //每个月20,25号8,10,16推送
//    @Scheduled(cron = "0 0 8,10,16 20,25 1/1 ? ")
//    public void renWuTixing(HttpSession session) {
//        jianceTx(session);
//    }
    private void jianceTx(HttpSession session){
 /*       String uid=String.valueOf(session.getAttribute("uid").toString());
        NdjhTx data=new NdjhTx();
        data.setUserId(Integer.valueOf(uid));
        if() {

        }


    }

        for (Map<String, Object> expireProductMap : expireProductMapList) {
            ExpirePushMsg expirePushMsg = new ExpirePushMsg();
            expirePushMsg.setNeedPushEntityId((int)expireProductMap.get("id"));
            expirePushMsg.setNeedPushEntityNo((String)expireProductMap.get("insuranceNo"));
            String productName = (String)expireProductMap.get("insuranceName");
            expirePushMsg.setNeedPushEntityName(productName);
            //设置此推送消息的到期时间
            expirePushMsg.setExpireDate(DateUtil.stringToDate(DateUtil.addOneDay()));
            expirePushMsg.setPushType(2);
            StringBuffer needPushRoleIdString = new StringBuffer();
            needPushRoleIds.forEach(e -> needPushRoleIdString.append(e + ";"));
            expirePushMsg.setPushRoleId(needPushRoleIdString.toString().trim());
            String productExpireDateString = DateUtil.dateToShotString((Date)expireProductMap.get("expiryDate"));
            expirePushMsg.setPushMsg("您的产品：" + productName + "，将于" + productExpireDateString + "即将过期，请及时处理！");
            expirePushMsgs.add(expirePushMsg);
        }
        expirePushMsgMapper.insertAll(expirePushMsgs);
        for(Yq yq:data){

            yqTsls.setPushMsg("您本月目前设备已检测台数：" + "未检测台数:" +"台数"+"，"+"本月检测完成率为:" +"，请您合理安排检测时间");
            yqTslsMapper.insert(yqTsls);
        }*/
    }
}
