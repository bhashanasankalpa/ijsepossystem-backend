package com.ijse.pos_assignment.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.pos_assignment.entity.User;
import com.ijse.pos_assignment.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;
    
    @PostMapping("/user")
    public User postMethodName(@RequestBody User user) {
        
        return userService.createUser(user);
    }
    
    
    
}
