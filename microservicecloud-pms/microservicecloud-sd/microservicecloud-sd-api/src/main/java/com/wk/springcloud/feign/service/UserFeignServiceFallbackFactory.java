package com.wk.springcloud.feign.service;

import com.wk.springcloud.common.MessageResult;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component          //一定要加这个注解
public class UserFeignServiceFallbackFactory implements FallbackFactory<UserFeignService> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public UserFeignService create(Throwable throwable) {
        return new UserFeignService() {
            @Override
            public MessageResult getUsers() {
                logger.error("调用/cloud/getUsers失败", throwable);
                return new MessageResult(false, "查询失败");
            }

            @Override
            public MessageResult discovery() {
                logger.error("调用/cloud/discovery失败", throwable);
                return new MessageResult(false, "查询失败在维护");
            }
        };
    }
}
