package com.example.ebean.account.controller;

import com.example.ebean.account.entity.User;
import com.example.ebean.account.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuzk
 * @date 2017/10/13
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/get")
    public User get(String name) {

        return service.get(name);
    }
}
