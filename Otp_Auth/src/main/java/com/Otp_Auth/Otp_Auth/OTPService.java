package com.Otp_Auth.Otp_Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

@Service
public class OTPService {

    @Autowired
    private  EmailService emailService;
    private  final Map<String,User> otpStorage = new HashMap<>();

    private final UserRepository userRepository;

    public  OTPService(UserRepository userRepository){
        this.userRepository = userRepository;

    }

    public void generateAndSendOtp(String email) {
        String otp = String.valueOf(new Random().nextInt(900000) + 100000); // Generates a 6-digit OTP

        Instant LocalGeneratedTime = Instant.now();
        emailService.sendotp(email, otp,LocalGeneratedTime); // Send OTP to the provided email
        otpStorage.put(email, new User(otp, LocalDateTime.now()));
    }

    public boolean verifyOtp(String email, String inputOtp) {
        User userdetails = otpStorage.get(email);
        if (userdetails != null && userdetails.getOtp().equals(inputOtp)) {
            otpStorage.remove(email); // Remove OTP after successful verification
            return true;
        }
        return false;
    }


}
