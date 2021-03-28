package com.horsefarmer.springboottool;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @Description
 * @Author horse-farmer
 * @Date 2021/3/27 0:13
 */

@SpringBootTest
public class MailTest {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    public void test() {
        // 一个简单邮件发送服务！！！
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("通知，刘蕊同志，组织现召唤你！请速来");
        mailMessage.setText("哈哈哈！！！");
        mailMessage.setTo("876499364@qq.com");
        mailMessage.setFrom("hpeng0512@foxmail.com");
        mailSender.send(mailMessage);
    }


    @Test
    public void test2() throws MessagingException {
        // 一个简复杂键发送服务！！！
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        // 组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setSubject("通知，刘蕊同志，组织现召唤你！请速来。复杂版本");
        // 支持发送html标签
        helper.setText("<p style='color: red'>看看是什么颜色</p>", true);
        // 添加附件
        helper.addAttachment("1.png",new File("D:\\PRO-gradle\\springboot-tool\\img.png"));
        helper.setTo("876499364@qq.com");
        helper.setFrom("hpeng0512@foxmail.com");
        mailSender.send(mimeMessage);
    }
}
