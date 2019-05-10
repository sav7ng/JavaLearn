package com.github.aquan.controller;

import com.github.aquan.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Class HelloControler
 * @Description TODO
 * @Author Aquan
 * @Date 2019.5.10 16:02
 * @Version 1.0
 **/
@RestController
public class HelloControler {

    @Autowired
    HelloService helloService;

    @GetMapping(value = "/meow")
    public String meow(@RequestParam String name) {
        return helloService.meowService(name);
    }

}
