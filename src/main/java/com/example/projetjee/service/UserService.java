package com.example.projetjee.service;

import com.example.projetjee.model.User;
import com.example.projetjee.web.dto.UserRegistrationDto;

public interface UserService {
    User save(UserRegistrationDto registrationDto);
}
