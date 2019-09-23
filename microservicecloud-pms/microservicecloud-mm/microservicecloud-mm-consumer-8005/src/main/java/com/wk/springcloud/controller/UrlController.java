package com.wk.springcloud.controller;

import com.wk.springcloud.common.MessageResult;
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

    //private static final String REST_URL_PREFIX = "http://localhost:8001";
    private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-MM";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/cloud/getUrls", produces = "application/json")
    public MessageResult getUrls() {
        MessageResult messageResult = restTemplate.getForObject(REST_URL_PREFIX + "/mm/cloud/getUrls", MessageResult.class);
        return messageResult;
    }

    @RequestMapping(value = "/cloud/discovery", produces = "application/json")
    public MessageResult discovery() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/mm/cloud/discovery", MessageResult.class);
    }

}
