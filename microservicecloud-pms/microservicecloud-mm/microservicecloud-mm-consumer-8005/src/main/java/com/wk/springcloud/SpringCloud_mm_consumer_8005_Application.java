package com.wk.springcloud;

import com.wk.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableEurekaClient
//争对MICROSERVICECLOUD-MM微服务负载均衡使用自定义的算法
@RibbonClient(name = "MICROSERVICECLOUD-MM", configuration = MySelfRule.class)
public class SpringCloud_mm_consumer_8005_Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloud_mm_consumer_8005_Application.class, args);
    }

}
