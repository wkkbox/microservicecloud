package com.wk.springcloud.feign.service;

import com.wk.springcloud.model.Url;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "MICROSERVICECLOUD-MM")
public interface UrlFeignService {

    @RequestMapping(value = "/mm/cloud/getUrls")
    List<Url> getUrls();

    @RequestMapping(value = "/mm/cloud/discovery")
    Object discovery();

}
