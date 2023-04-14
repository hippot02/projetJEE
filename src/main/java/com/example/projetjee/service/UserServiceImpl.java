package com.example.projetjee.service;

import com.example.projetjee.model.Programme;
import com.example.projetjee.model.User;
import com.example.projetjee.repository.UserRepository;
import com.example.projetjee.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }
    @Override
    public User save(UserRegistrationDto registrationDto) {
        User user = new User(registrationDto.getPrenom(),
                registrationDto.getNom(),
                registrationDto.getEmail(),
                registrationDto.getPassword(),
                Arrays.asList(new Programme("Basique")));

        return userRepository.save(user);
    }
}
