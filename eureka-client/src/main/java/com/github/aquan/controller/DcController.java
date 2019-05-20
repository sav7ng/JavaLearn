package com.github.aquan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Class DcController
 * @Description TODO
 * @Author Aquan
 * @Date 2019.5.20 15:59
 * @Version 1.0
 **/
@RestController
public class DcController {

    @Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    Environment environment;

    @GetMapping("/dc")
    public String dc() {
        String services = "Services：" + discoveryClient.getServices() + "{" + environment.getProperty("local.server.port") + "}";
        System.out.println(services);
        return services;
    }

}
