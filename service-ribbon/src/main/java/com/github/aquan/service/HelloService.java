package com.github.aquan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Class HelloService
 * @Description TODO
 * @Author Aquan
 * @Date 2019.5.10 15:59
 * @Version 1.0
 **/
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    public String meowService(String name) {
        return restTemplate.getForObject("http://SERVICE-MEOW/meow?name="+name,String.class);
    }

}
