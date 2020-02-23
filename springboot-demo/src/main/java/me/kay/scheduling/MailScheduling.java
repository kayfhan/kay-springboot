package me.kay.scheduling;

import me.kay.utils.MailUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MailScheduling {

    @Scheduled(cron = "5 * * * * *")
    public void sendMail(){
        System.out.println("send mail...");
        boolean isSuccessed = MailUtil.sendMail(
                "kayfhan@sina.com",
                "hello kay",
                "you are a handsome boy.",
                "601400175@qq.com");
        System.out.println("send mail " + isSuccessed);
    }
}
