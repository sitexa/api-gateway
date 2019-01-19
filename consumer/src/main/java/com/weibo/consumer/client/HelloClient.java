package com.weibo.consumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: xnpeng (xpneng@hotmail.com)
 * @date: 2019/1/18
 * @doc description
 **/
@FeignClient(name = "hello-service")
public interface HelloClient {

    @RequestMapping("/")
    String hello();

    @RequestMapping(value = "/say", method = RequestMethod.GET)
    String say(@RequestParam("words") String words);

    @RequestMapping(value = "/bye", method = RequestMethod.POST)
    String bye(@RequestParam("name") String name);

    @RequestMapping(value = "/play", method = RequestMethod.POST)
    String play(@RequestBody Object body);
}
