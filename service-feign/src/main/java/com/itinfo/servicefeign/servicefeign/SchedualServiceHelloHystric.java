package com.itinfo.servicefeign.servicefeign;

import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHelloHystric implements SchedualServiceHello{
    @Override
    public String sayHelloFromClientOne(String name) {
        return "sorry " + name +"服务器繁忙，请稍后重试！";
    }
}
