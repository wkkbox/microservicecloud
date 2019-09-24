package com.wk.springcloud.controller;

import com.wk.springcloud.common.MessageResult;
import com.wk.springcloud.feign.service.UrlFeignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mm/consumer")
public class UrlController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UrlFeignService urlFeignService;

    @RequestMapping(value = "/cloud/getUrls", produces = "application/json")
    public MessageResult getUrls() {
        MessageResult messageResult = urlFeignService.getUrls();
        return messageResult;
    }

    @RequestMapping(value = "/cloud/discovery", produces = "application/json")
    public MessageResult discovery() {
        return urlFeignService.discovery();
    }

}
