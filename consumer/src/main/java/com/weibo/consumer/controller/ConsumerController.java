package com.weibo.consumer.controller;

import com.weibo.consumer.client.HelloClient;
import com.weibo.consumer.client.WorldClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;

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

    @RequestMapping("/")
    public String index() {
        return "Consumer";
    }

    @RequestMapping("/call-hello")
    public String callHello() {
        String helloResult = helloClient.hello();
        return "Consumer===>" + helloResult;
    }

    @RequestMapping("/call-world")
    public String callWorld() {
        String worldResult = worldClient.world();
        return "Consumer===>" + worldResult;
    }

    @RequestMapping("/call-say")
    public String callSay() {
        String sayResult = helloClient.say("Oscar");
        return "Consumer===>" + sayResult;
    }

    @RequestMapping("/call-bye")
    public String callBye() {
        String byeResult = helloClient.bye("Intel");
        return "Consumer===>" + byeResult;
    }

    @RequestMapping("/call-play")
    public String callPlay() {
        HashMap<String, Object> body = new HashMap<>();
        body.put("name", "basketball");
        body.put("time", new Date());
        String playResult = helloClient.play(body);
        return "Consumer===>" + playResult;
    }
}
