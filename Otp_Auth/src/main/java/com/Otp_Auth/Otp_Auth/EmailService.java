package com.Otp_Auth.Otp_Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public  void sendotp(String toEmail , String otp, Instant localGeneratedTime){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Your OTP code");
        message.setText("Your OTP is:"+otp);
        mailSender.send(message);
    }
}
