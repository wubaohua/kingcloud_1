package com.leyou.client.impl;

import com.leyou.client.UserClient;
import com.leyou.pojo.User;
import org.springframework.stereotype.Component;

@Component//把这个交给容器进行管理,否则报错
public class UserClientImpl implements UserClient {

    @Override
    public User findById(Long id) {
        User user = new User();
        user.setName("用户不存在");
        return user;
    }
}
