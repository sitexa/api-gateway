package com.weibo.consumer.controller;

import com.weibo.consumer.client.HelloClient;
import com.weibo.consumer.client.WorldClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xnpeng (xpneng@hotmail.com)
 * @date: 2019/1/18
 * @doc description
 **/
@Slf4j
@RestController
public class ConsumerController {

    @Autowired
    HelloClient helloClient;

    @Autowired
    WorldClient worldClient;

    @RequestMapping("/consumer")
    public String consumer() {

        String helloResult = helloClient.hello();
        String worldResult = worldClient.world();

        return "\n[[Consumer]] call [[hello-service]]:" + helloResult + "; and [[world-service]]:" + worldResult;

    }
}
