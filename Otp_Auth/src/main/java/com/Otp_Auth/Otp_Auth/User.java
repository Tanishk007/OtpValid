package com.Otp_Auth.Otp_Auth;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private  long id;

    @Column(name =  "phone_number" , nullable = false , unique = true)
    private  String phoneNumber;

    private String otp;

    @Column(name = "otp_generated_time")
    private LocalDateTime otpGeneratedTime;

    public User(String otp, LocalDateTime otpGeneratedTime) {
        this.otp = otp;
        this.otpGeneratedTime = otpGeneratedTime;
    }

    public String getOtp() {
        return otp;
    }

    public LocalDateTime getGeneratedTime() {
        return otpGeneratedTime;
    }

    public long getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getotp() {
        return otp;
    }

    public LocalDateTime getotpGeneratedTime() {
        return otpGeneratedTime;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setotp(String otp) {
        this.otp = otp;
    }

    public void setOtpGeneratedTime(LocalDateTime otpGeneratedTime) {
        this.otpGeneratedTime = otpGeneratedTime;
    }


}
