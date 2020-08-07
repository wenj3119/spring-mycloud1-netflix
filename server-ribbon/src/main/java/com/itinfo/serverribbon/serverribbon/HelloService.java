package com.itinfo.serverribbon.serverribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloError")
    public String helloService(String name){
        return restTemplate.getForObject("http://service-hello/hello?name=" + name,String.class);
    }

    public String helloError(String name){
        return "hello" + name + ",sorry,服务器繁忙，请稍后再试";
    }
}
