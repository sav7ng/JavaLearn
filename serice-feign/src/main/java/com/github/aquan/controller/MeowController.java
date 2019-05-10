package com.github.aquan.controller;

import com.github.aquan.service.SchedualServiceMeow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Class MeowController
 * @Description TODO
 * @Author Aquan
 * @Date 2019.5.10 18:28
 * @Version 1.0
 **/
@RestController
public class MeowController {

    @Autowired
    SchedualServiceMeow schedualServiceMeow;

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
        return schedualServiceMeow.sayMeowFromClientOne(name);
    }

}
