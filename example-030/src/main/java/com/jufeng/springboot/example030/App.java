package com.jufeng.springboot.example030;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private JavaMailSender javaMailSender;


    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        //multipart模式
        try {
            MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setTo("sisi.deweiyi@163.com");//收件人邮箱user.getMail()
            mimeMessageHelper.setFrom("sisi.deweiyi@163.com");//发件人邮箱
            mimeMessage.setSubject("测试");
            //启用html
            mimeMessageHelper.setText("hello word",true);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}