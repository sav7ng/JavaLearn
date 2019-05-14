package com.deepexi.b.depend;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by donh on 2018/11/5.
 */
@FeignClient("DEMO-SERVICE")
public interface DemoClient {

    @RequestMapping(method = RequestMethod.GET, value = "/provider/add")
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);
}