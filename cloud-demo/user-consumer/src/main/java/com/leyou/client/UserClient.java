package com.leyou.client;

import com.leyou.client.impl.UserClientImpl;
import com.leyou.config.LogConfig;
import com.leyou.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "user-service")//name是服务名
@FeignClient(name = "user-service", fallback= UserClientImpl.class,configuration = LogConfig.class)

public interface UserClient {
    //调用user-service提供的方法
    @GetMapping("/user/{id}")//这里的地址是user-service方法的地址
    User findById(@PathVariable("id") Long id);
}
