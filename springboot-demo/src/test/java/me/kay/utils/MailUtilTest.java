package me.kay.utils;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailUtilTest {

    @Autowired
    private JavaMailSenderImpl mailSender;

    @Test
    public void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件设置
        message.setSubject("通知-今晚开会");
        message.setText("今晚7:30开会");

        message.setTo("kayfhan@sina.com");
        message.setFrom("601400175@qq.com");

        mailSender.send(message);
    }

    @Test
    public void sendMail() {
        sendMail(
                "kayfhan@sina.com",
                "hello kay",
                "you are a handsome boy.",
                "601400175@qq.com");
    }

    public static boolean sendMail(String to, String title, String content, String from) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(title);
        message.setText(content);
        message.setTo(to);
        message.setFrom(from);

        try {
//            mailSender.send(message);
            return true;
        } catch (MailException e) {
            return false;
        }
    }

    public  boolean send(String to, String title, String content, String from, Map<String, String> attachmentFilePath) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            final MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            //邮件设置
            helper.setSubject(title);
            helper.setText(content, true);

            helper.setTo(to);
            helper.setFrom(from);

            //上传文件
            attachmentFilePath.forEach((name, path) -> {
                try {
                    helper.addAttachment(name, new File(path));
                } catch (MessagingException e) {
                    System.out.println();
                    e.printStackTrace();
                }
            });

            mailSender.send(mimeMessage);

            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }
}