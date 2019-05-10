package com.github.aquan.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-meow")
public interface SchedualServiceMeow {

    // @RequestMapping(value = "/meow",method = RequestMethod.GET)
    @GetMapping(value = "/meow")
    String sayMeowFromClientOne(@RequestParam(value = "name") String name);

}
