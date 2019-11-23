package com.leyou.controller;

import com.leyou.pojo.User;
import com.leyou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
@GetMapping("{id}")//rest风格是需要一个占位符表示的参数,下面的方法要用@PathVariable接受,并且参数名一样
    public User findById(@PathVariable ("id")Long id) {
//    try {
//        Thread.sleep(2000);
//    } catch (InterruptedException e) {
//        e.printStackTrace();
//    }
    if(id==1){
        throw  new RuntimeException();
    }


    return userService.findById(id);
    }

}
