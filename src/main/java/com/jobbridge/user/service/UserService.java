package com.jobbridge.user.service;

import com.jobbridge.auth.entity.User;
import com.jobbridge.auth.repository.UserRepository;
import com.jobbridge.user.dto.ProfileUpdateRequest;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getProfile(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateProfile(String email, ProfileUpdateRequest request) {

        User user = getProfile(email);

        user.setName(request.getName());
        user.setPhone(request.getPhone());
        user.setLocation(request.getLocation());
        user.setSkills(request.getSkills());
        user.setExperienceYears(request.getExperienceYears());
        user.setBio(request.getBio());

        return userRepository.save(user);
    }
}