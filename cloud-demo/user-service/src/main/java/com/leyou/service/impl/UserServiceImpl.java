package com.leyou.service.impl;

import com.leyou.mapper.UserMapper;
import com.leyou.pojo.User;
import com.leyou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
@Autowired
private UserMapper userMapper;
    @Override
    public User findById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
