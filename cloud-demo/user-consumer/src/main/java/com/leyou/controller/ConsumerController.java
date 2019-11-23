package com.leyou.controller;

import com.leyou.client.UserClient;
import com.leyou.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
//@DefaultProperties(defaultFallback = "allMethodFallBack")//定义一个全局的降级方法,类上的注解
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

/*
   int i =0;

    @GetMapping("{id}")
    public User findById(@PathVariable("id") Long id){
//可以有多个服务.返回的是一个list
        List<ServiceInstance> list = discoveryClient.getInstances("user-service");//serviceId 就是注册中心的服务端的注册项目名称
  //负载均衡    一般有两种方式 一种是 随机,和轮询
        //轮询
//         int num = i%list.size();
//         i++;
        //随机
//                  int  num =      new Random().nextInt(list.size());



        ServiceInstance instance = list.get(num);//获取第一个服务
        System.out.println(instance.getHost());
        System.out.println(instance.getPort());
        System.out.println(instance.getUri());//j就是IP地址+端口号

        User user = restTemplate.getForObject(instance.getUri()+"/user/" + id, User.class);
        return user;
    }*/





/*    @GetMapping("{id}")
//    @HystrixCommand(fallbackMethod = "findByIdFallBack")//和被降级的方法产生关联
    @HystrixCommand
    public String  findById(@PathVariable("id") Long id){
        String user = restTemplate.getForObject("http://user-service/user/" + id, String.class);//负载均衡中,把ip地址改成服务项目名
        return user;
    }*/


//降级的方法有要求:和被降级的方法的参数,返回类型一致
//    public String findByIdFallBack(Long id){
//        return"服务异常,请稍后重试";
//    }
@Autowired
private UserClient userClient;

    @GetMapping("{id}")
    @HystrixCommand
    public User findById(@PathVariable("id") Long id){
        User user = userClient.findById(id);
        return user;
    }






//   //定义一个全局的降级方法
//   public String allMethodFallBack(){
//
//        return "服务器very busy,请先去忙点别的吧";
//   }

}
