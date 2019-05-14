package com.deepexi.b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by donh on 2018/11/5.
 * EnableDiscoveryClient 用于启动服务发现功能
 * EnableFeignClients 用于启动Fegin功能
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class StartupApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartupApplication.class, args);
    }
}