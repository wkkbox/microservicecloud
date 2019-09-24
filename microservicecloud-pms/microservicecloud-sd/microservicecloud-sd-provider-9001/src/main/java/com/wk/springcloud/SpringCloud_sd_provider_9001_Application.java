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
public class SpringCloud_sd_provider_9001_Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloud_sd_provider_9001_Application.class, args);
    }

}
