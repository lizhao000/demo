package com.example.demo2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo1ApplicationTests {
    @Autowired
    JavaMailSenderImpl JavaMailSenderImpl;
    @Test
    public void testJavaMailSenderImpl(){
        //封装简单的邮件内容
        SimpleMailMessage Message = new SimpleMailMessage();
        //标题
        Message.setSubject("放假通知");
        //内容
        Message.setText("国庆节放假7天");
        //发件人
        Message.setFrom("1780257669@qq.com");
        //收件人
        Message.setTo("13997523871@163.com");
        JavaMailSenderImpl.send(Message);
    }
//    @Test
//    public void test1JavaMailSenderImpl() throws MessagingException {
//        MimeMessage mimeMessage = JavaMailSenderImpl.createMimeMessage();
//        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
//        //标题
//        mimeMessageHelper.setSubject("放假通知");
//        //内容
//        mimeMessageHelper.setText("<h2 style='color:red'>国庆节放假7天</h2>",true);
//        //附件
//        mimeMessageHelper.addAttachment("1图片",new File("D:\\图片\\20170515225143_AaKHd.jpeg"));
//        mimeMessageHelper.addAttachment("2图片",new File("D:\\图片\\u=2410731614,2107512208&fm=214&gp=0.jpg"));
//        mimeMessageHelper.addAttachment("3图片",new File("D:\\图片\\u=3061040066,3001383224&fm=214&gp=0.jpg"));
//        mimeMessageHelper.addAttachment("4图片",new File("D:\\图片\\u=3591542794,321365225&fm=214&gp=0.jpg"));
//        mimeMessageHelper.addAttachment("word",new File("E:\\资料\\国培图片.doc"));
//        //发件人
//        mimeMessageHelper.setFrom("1780257669@qq.com");
//        //收件人
//        mimeMessageHelper.setTo("13997523871@163.com");
//        JavaMailSenderImpl.send(mimeMessage);
//
//
//    }

}
