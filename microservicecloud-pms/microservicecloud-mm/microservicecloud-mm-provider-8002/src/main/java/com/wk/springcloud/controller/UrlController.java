package com.wk.springcloud.controller;

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
    public List<Url> getUrls() {
        System.out.println("mm-provider-8002");
        List<Url> urls = null;
        try {
            //System.out.println(1 / 0);
            urls = urlService.selectAll();
        } catch (Exception e) {
            logger.error("调用/cloud/getUrls失败", e);
            e.printStackTrace();
        }
        return urls;
    }

    @RequestMapping(value = "/cloud/discovery", produces = "application/json")
    public Object discovery() {
        List<String> list = discoveryClient.getServices();
        System.out.println("**********" + list);
        List<ServiceInstance> srvList = discoveryClient.getInstances("MICROSERVICECLOUD-MM");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.discoveryClient;
    }

}
