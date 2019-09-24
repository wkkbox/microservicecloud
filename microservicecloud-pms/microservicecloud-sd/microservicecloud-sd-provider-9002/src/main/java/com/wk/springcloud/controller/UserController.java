package com.wk.springcloud.controller;

import com.wk.springcloud.common.MessageResult;
import com.wk.springcloud.model.User;
import com.wk.springcloud.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sd")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/cloud/getUsers", produces = "application/json")
    public MessageResult getUsers() {
        System.out.println("sd-provider-9002");
        MessageResult messageResult = null;
        List<User> userList  = userService.showUsers();
        messageResult = new MessageResult(true, "查询成功", userList);
        return messageResult;
    }

    @RequestMapping(value = "/cloud/discovery", produces = "application/json")
    public MessageResult discovery() {
        System.out.println("sd-provider-9002");
        MessageResult messageResult = null;
        List<String> list = discoveryClient.getServices();
        System.out.println("**********" + list);
        List<ServiceInstance> srvList = discoveryClient.getInstances("MICROSERVICECLOUD-SD");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        messageResult = new MessageResult(true, "查询成功", discoveryClient);
        return messageResult;
    }

}
