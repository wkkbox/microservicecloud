package com.wk.springcloud.feign.service;

import com.wk.springcloud.common.MessageResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

//@FeignClient(value = "MICROSERVICECLOUD-MM")
@FeignClient(value = "MICROSERVICECLOUD-MM", fallbackFactory = UrlFeignServiceFallbackFactory.class)
public interface UrlFeignService {

    @RequestMapping(value = "/mm/cloud/getUrls")
    MessageResult getUrls();

    @RequestMapping(value = "/mm/cloud/discovery")
    MessageResult discovery();

}
