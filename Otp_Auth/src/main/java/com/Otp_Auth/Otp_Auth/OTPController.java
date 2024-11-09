package com.Otp_Auth.Otp_Auth;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class OTPController {

    private final OTPService otpService;

    public OTPController(OTPService otpService){
        this.otpService = otpService;

    }

    @PostMapping("/send-otp")
    public ResponseEntity<String> sendOtp(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        otpService.generateAndSendOtp(email);
        return ResponseEntity.ok("OTP sent successfully to " + email);
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<String> verifyOtp(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String otp = request.get("otp");

        boolean isVerified = otpService.verifyOtp(email, otp);
        if (isVerified) {
            return ResponseEntity.ok("OTP verified successfully.");
        } else {
            return ResponseEntity.status(400).body("Invalid OTP.");
        }
    }



}
