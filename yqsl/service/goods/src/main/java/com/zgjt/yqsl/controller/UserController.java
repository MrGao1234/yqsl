package com.zgjt.yqsl.controller;

import com.zgjt.yqsl.entity.User;
import com.zgjt.yqsl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUserList")
    public List<User> getStudent(){
        return userService.getUserList1();
    }

    @RequestMapping("/getUserList1")
    public List<User> getStudent1(){
        return userService.getUserList();
    }
}
