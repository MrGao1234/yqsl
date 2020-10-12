package com.zgjt.yqsl.test.service.impl;

import com.zgjt.yqsl.annotation.DataSource;
import com.zgjt.yqsl.entity.PowerUser;
import com.zgjt.yqsl.test.mapper.UserMapper;
import com.zgjt.yqsl.test.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @DataSource

    public List<PowerUser> getUserList() {


        userMapper.deleteById(6);

        return userMapper.selectList(null);
    }

    @Override
    @DataSource("write")
    @Cacheable(value = "test",key = "'keyDemo'")
    public List<PowerUser> getUserList1() {
        return userMapper.selectList(null);
    }
}
