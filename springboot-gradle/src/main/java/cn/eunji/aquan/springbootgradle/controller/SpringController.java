package cn.eunji.aquan.springbootgradle.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Class SpringController
 * @Description TODO
 * @Author Aquan
 * @Date 2019.1.11 16:35
 * @Version 1.0
 **/

@Controller
@EnableAutoConfiguration
public class SpringController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Gradle";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringController.class, args);
    }

}
