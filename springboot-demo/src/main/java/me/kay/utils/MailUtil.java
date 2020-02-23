package me.kay.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Map;

@Service
public class MailUtil {

    private final static Logger logger = LoggerFactory.getLogger(MailUtil.class);

    private static JavaMailSenderImpl mailSender;

    @Autowired
    public MailUtil(JavaMailSenderImpl mailSender){
        MailUtil.mailSender = mailSender;
    }

    public static boolean sendMail(String to, String title, String content, String from) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject(title);
            message.setText(content);
            message.setTo(to);
            message.setFrom(from);

            System.out.println(message.toString());
            System.out.println("-------------" + mailSender.getUsername());

            mailSender.send(message);
            return true;
        } catch (MailException e) {
            logger.info("send mail failed. to: {}, title: {}.", to, title);
            return false;
        }
    }

    public static boolean send(String to, String title, String content, String from, Map<String, String> attachmentFilePath) {
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
