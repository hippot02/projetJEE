package com.example.projetjee.service;

import com.example.projetjee.model.User;
import com.example.projetjee.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
