package com.wk.springcloud.controller;

import com.wk.springcloud.feign.service.UrlFeignService;
import com.wk.springcloud.model.Url;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/mm/consumer")
public class UrlController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UrlFeignService urlFeignService;

    @RequestMapping(value = "/cloud/getUrls", produces = "application/json")
    public List<Url> getUrls() {
        List<Url> urlList = urlFeignService.getUrls();
        return urlList;
    }

    @RequestMapping(value = "/cloud/discovery", produces = "application/json")
    public Object discovery() {
        return urlFeignService.discovery();
    }

}