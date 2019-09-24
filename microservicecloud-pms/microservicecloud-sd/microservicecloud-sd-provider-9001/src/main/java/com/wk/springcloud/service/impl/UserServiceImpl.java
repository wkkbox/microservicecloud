package com.wk.springcloud.service.impl;

import com.wk.springcloud.mapper.UserMapper;
import com.wk.springcloud.model.User;
import com.wk.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> showUsers() {
        return userMapper.listUsers();
    }

}
