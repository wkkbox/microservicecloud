package com.wk.springcloud.controller;

import com.wk.springcloud.common.MessageResult;
import com.wk.springcloud.feign.service.UserFeignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sd/consumer")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserFeignService userFeignService;

    @RequestMapping(value = "/cloud/getUsers", produces = "application/json")
    public MessageResult getUsers() {
        MessageResult messageResult = userFeignService.getUsers();
        return messageResult;
    }

    @RequestMapping(value = "/cloud/discovery", produces = "application/json")
    public MessageResult discovery() {
        return userFeignService.discovery();
    }

}
