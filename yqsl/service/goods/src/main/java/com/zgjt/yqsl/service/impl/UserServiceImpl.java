package com.zgjt.yqsl.service.impl;

import com.zgjt.yqsl.annotation.DataSource;
import com.zgjt.yqsl.entity.User;
import com.zgjt.yqsl.mapper.UserMapper;
import com.zgjt.yqsl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @DataSource("read")
    public List<User> getUserList() {
        return userMapper.selectList(null);
    }

    @Override
    @DataSource("write")
    public List<User> getUserList1() {
        return userMapper.selectList(null);
    }
}
