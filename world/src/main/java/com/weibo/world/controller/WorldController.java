package com.weibo.world.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: xnpeng (xpneng@hotmail.com)
 * @date: 2019/1/18
 * @doc description
 **/
@RestController
public class WorldController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/")
    public String world() {
        String helloResult = restTemplate.getForObject("http://hello-service/", String.class);
        return "World===>" + helloResult ;
    }

    @RequestMapping("/you")
    public String you(){
        return "World:you";
    }

    @RequestMapping("/me")
    public String me(){
        return "world:me";
    }
}
