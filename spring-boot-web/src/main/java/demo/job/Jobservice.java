package demo.job;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class Jobservice {

    @Autowired
    private JavaMailSender javaMailSender;


    @Scheduled(fixedRate = 5000)
    public void domeil(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("xxxxxxxxxx@qq.com");
        message.setTo("aaaaaaaaaa@qq.com");
        message.setSubject("主题：简单邮件");
        message.setText(""+this.getClass()+""+LocalTime.now());

        javaMailSender.send(message);
    }
}
