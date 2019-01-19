package com.weibo.consumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: xnpeng (xpneng@hotmail.com)
 * @date: 2019/1/18
 * @doc description
 **/
@FeignClient(name = "hello-service")
public interface HelloClient {

    @RequestMapping("/hello")
    String hello();
}
