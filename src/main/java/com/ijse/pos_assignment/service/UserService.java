package com.ijse.pos_assignment.service;

import org.springframework.stereotype.Service;

import com.ijse.pos_assignment.entity.User;


@Service
public interface UserService {
    User createUser(User user);
}