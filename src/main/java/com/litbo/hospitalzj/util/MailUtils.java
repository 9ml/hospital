package com.litbo.hospitalzj.util;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public class MailUtils {


    /**
     * 发邮件工具类
     */
   /* @Value("${spring.mail.username}")
    private  String username = "nyist_cjs@126.com";
    @Value("${spring.mail.password}")
    private  String password = "Cjs950820";*/

    @Value("${spring.mail.username}")
    private static String USER; // 发件人称号，同邮箱地址
    @Value("${spring.mail.password}")
    private static String PASSWORD; // 如果是qq邮箱可以使户端授权码，或者登录密码

    @Value("${spring.mail.host}")
    private static String host;

    /**
     * @param to    收件人邮箱
     * @param text  邮件正文
     * @param title 标题
     */
    /* 发送验证信息的邮件 */
    public static boolean sendMail(String to, String text, String title) {
        try {
            final Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.host", "smtp.126.com");
            props.setProperty("mail.smtp.port", "465");
            props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.setProperty("mail.smtp.socketFactory.fallback", "false");
            props.setProperty("mail.smtp.socketFactory.port", "465");

            // 发件人的账号
            props.put("mail.user", "nyist_cjs@126.com");
            //发件人的密码
            props.put("mail.password", "Cjs950820");

            // 构建授权信息，用于进行SMTP进行身份验证
            Authenticator authenticator = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    // 用户名、密码
                    String userName = props.getProperty("mail.user");
                    String password = props.getProperty("mail.password");
                    return new PasswordAuthentication(userName, password);
                }
            };
            // 使用环境属性和授权信息，创建邮件会话
            Session mailSession = Session.getInstance(props, authenticator);
            // 创建邮件消息
            MimeMessage message = new MimeMessage(mailSession);
            // 设置发件人
            String username = props.getProperty("mail.user");
            InternetAddress form = new InternetAddress(username);
            message.setFrom(form);

            // 设置收件人
            InternetAddress toAddress = new InternetAddress(to);
            message.setRecipient(Message.RecipientType.TO, toAddress);

            // 设置邮件标题
            message.setSubject(title);

            // 设置邮件的内容体
            message.setContent(text, "text/html;charset=UTF-8");
            // 发送邮件
            Transport.send(message);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;


    }


/*
    public static void main(String[] args) throws Exception { // 做测试用
        long before = System.currentTimeMillis();
        MailUtils.sendMail("nyistcjs@163.com","你好，这是一封测试邮件，无需回复。","测试邮件");
        long after = System.currentTimeMillis();
        System.out.print("发送邮件所用时间  ");
        System.out.println( after - before);// 6531  13817
        System.out.println("发送成功");
    }
*/

}