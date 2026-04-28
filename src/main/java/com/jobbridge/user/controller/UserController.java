package com.jobbridge.user.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/api/user/me")
    public String me(Authentication authentication) {
        return "Logged in user: " + authentication.getName();
    }
}