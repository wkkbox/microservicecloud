package com.wk.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.wk.springcloud.mapper")
@EnableEurekaClient
@EnableDiscoveryClient
public class SpringCloud_mm_provider_8001_Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloud_mm_provider_8001_Application.class, args);
    }

}
