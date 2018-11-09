package com.gismo.carbon.proxy;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CarbonProxyApplication {
    
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(CarbonProxyApplication.class, args);


        System.out.println("Current timestamp:" + Long.toString(System.currentTimeMillis()));

    }

}
