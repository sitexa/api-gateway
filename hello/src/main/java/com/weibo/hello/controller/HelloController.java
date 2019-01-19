package com.weibo.hello.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author: xnpeng (xpneng@hotmail.com)
 * @date: 2019/1/18
 * @doc description
 **/
@Slf4j
@RestController
public class HelloController {

    @Autowired
    DiscoveryClient discoveryClient;

    @RequestMapping("/")
    public String hello() {
        return "Hello!";
    }

    @GetMapping("/say")
    public String say(@RequestParam String words) {
        return "Say: " + words;
    }

    @PostMapping("/bye")
    public String bye(@RequestParam String name) {
        return "Bye:" + name;
    }

    @PostMapping("/play")
    public String play(@RequestBody String body) {
        JSONObject json = JSON.parseObject(body);
        String name = json.getString("name");
        Date time = json.getDate("time");
        return "Play " + name + " at " + time;
    }
}
