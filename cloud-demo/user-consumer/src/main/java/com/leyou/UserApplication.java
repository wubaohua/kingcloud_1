package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

//@SpringBootApplication
//@EnableDiscoveryClient//声明当前项目是一个注册中心的客户端
//@EnableCircuitBreaker//开启熔断器
@SpringCloudApplication //相当于上面的全部注解
@EnableFeignClients//表示使用feign
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);

    }

//使用了feign之后,RestTemplate就没有用了
    @Bean//下面就是一个典型的构造器注入
    @LoadBalanced//添加负载均衡
    public RestTemplate restTemplate(){

        RestTemplate restTemplate = new RestTemplate();
        //更改默认编码
        restTemplate.getMessageConverters().add(1,new StringHttpMessageConverter(Charset.forName("utf-8")));
        return restTemplate;

    }



}
