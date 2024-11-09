package com.Otp_Auth.Otp_Auth;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User,Long> {
    Optional<User> findByPhoneNumber(String phoneNumber);
}