package com.jobbridge.user.controller;

import com.jobbridge.auth.entity.User;
import com.jobbridge.user.dto.ProfileUpdateRequest;
import com.jobbridge.user.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    /*@GetMapping("/api/user/me")
    public String me(Authentication authentication) {
        return "Logged in user: " + authentication.getName();
    }*/
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public User getProfile(Authentication authentication) {
        return userService.getProfile(authentication.getName());
    }

    @PutMapping("/profile")
    public User updateProfile(Authentication authentication,
                              @RequestBody ProfileUpdateRequest request) {
        return userService.updateProfile(authentication.getName(), request);
    }
}