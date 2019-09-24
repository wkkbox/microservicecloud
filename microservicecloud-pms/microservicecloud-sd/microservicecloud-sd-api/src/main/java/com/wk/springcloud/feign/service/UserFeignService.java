package com.wk.springcloud.feign.service;

import com.wk.springcloud.common.MessageResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

//@FeignClient(value = "MICROSERVICECLOUD-SD")
@FeignClient(value = "MICROSERVICECLOUD-SD", fallbackFactory = UserFeignServiceFallbackFactory.class)
public interface UserFeignService {

    @RequestMapping(value = "/sd/cloud/getUsers")
    MessageResult getUsers();

    @RequestMapping(value = "/sd/cloud/discovery")
    MessageResult discovery();

}
