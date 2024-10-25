package com.ijse.pos_assignment.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ijse.pos_assignment.entity.User;
import com.ijse.pos_assignment.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User createUser(User user) {
       user.setPassword(passwordEncoder.encode(user.getPassword()));//encode password

       return userRepository.save(user);
    }
    
}