package com.jobbridge.auth.service;

import com.jobbridge.auth.dto.AuthResponse;
import com.jobbridge.auth.dto.LoginRequest;
import com.jobbridge.auth.dto.RegisterRequest;
import com.jobbridge.auth.entity.User;
import com.jobbridge.auth.repository.UserRepository;
import com.jobbridge.common.util.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String register(RegisterRequest request) {

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(encoder.encode(request.getPassword()));
        user.setRole("USER");

        userRepository.save(user);

        return "User Registered Successfully";
    }
    public AuthResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!encoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = JwtUtil.generateToken(user.getEmail());

        return new AuthResponse(token);
    }
}