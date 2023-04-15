package com.example.projetjee.service;

import com.example.projetjee.model.Programme;
import com.example.projetjee.model.User;
import com.example.projetjee.repository.UserRepository;
import com.example.projetjee.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import javax.management.relation.Role;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }
    @Override
    public User save(UserRegistrationDto registrationDto) {
        User user = new User(registrationDto.getPrenom(),
                registrationDto.getNom(),
                registrationDto.getEmail(),
                passwordEncoder.encode(registrationDto.getPassword()),
                Arrays.asList(new Programme("Basique")));

        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),null);
    }

//    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<com.example.projetjee.model.Role> roles) {
//    return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
//    }


}