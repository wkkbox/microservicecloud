package com.wk.springcloud.controller;

import com.wk.springcloud.common.MessageResult;
import com.wk.springcloud.model.Url;
import com.wk.springcloud.service.UrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mm")
public class UrlController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UrlService urlService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/cloud/getUrls", produces = "application/json")
    public MessageResult getUrls() {
        System.out.println("mm-provider-8003");
        MessageResult messageResult = null;
        //System.out.println(1/0);
        List<Url> urls = urlService.selectAll();
        messageResult = new MessageResult(true, "查询成功", urls);
        return messageResult;
    }

    @RequestMapping(value = "/cloud/discovery", produces = "application/json")
    public Object discovery() {
        System.out.println("mm-provider-8003");
        MessageResult messageResult = null;
        //System.out.println(1/0);
        List<String> list = discoveryClient.getServices();
        System.out.println("**********" + list);
        List<ServiceInstance> srvList = discoveryClient.getInstances("MICROSERVICECLOUD-MM");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        messageResult = new MessageResult(true, "查询成功", discoveryClient);
        return messageResult;
    }

}
