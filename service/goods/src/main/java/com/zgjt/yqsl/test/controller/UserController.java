package com.zgjt.yqsl.test.controller;

import com.zgjt.yqsl.entity.PowerUser;
import com.zgjt.yqsl.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUserList")
    public List<PowerUser> getStudent(){
        return userService.getUserList1();
    }

    @GetMapping("/getUserList1")
    public List<PowerUser> getStudent1(){
        return userService.getUserList();
    }
}
