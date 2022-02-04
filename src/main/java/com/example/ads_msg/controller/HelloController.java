package com.example.ads_msg.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/test")
    public String sayHello(){
        return "测试任务";
    }
}
