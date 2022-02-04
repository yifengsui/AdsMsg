package com.example.ads_msg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.SpringServletContainerInitializer;

@SpringBootApplication
public class AdsMsgApplication extends SpringServletContainerInitializer {

    public static void main(String[] args) {

        SpringApplication.run(AdsMsgApplication.class, args);
    }

}
