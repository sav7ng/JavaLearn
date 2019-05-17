package com.deepexi.b.controller;

import com.deepexi.b.depend.DemoClient;
import com.deepexi.b.domain.eo.Product;
import com.deepexi.util.config.Payload;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Class aProductController
 * @Description TODO
 * @Author Aquan
 * @Date 2019.5.17 15:10
 * @Version 1.0
 **/

@Api(value = "aproductcontroller",description = "该微服务作为消费者，调用deepexi-service-a，实现远程调用")
@RestController
@RequestMapping("/api/v1/aproducts")
public class aProductController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DemoClient demolient;


    @GetMapping(value = "/{id:[a-zA-Z0-9]+}")
    public Payload getProductById(@PathVariable("id") String id) {
        return new Payload(demolient.getProductById(id));
    }

    @PostMapping
    public Payload createProduct(@RequestBody Product product) {
        return new Payload(demolient.createProduct(product));
    }



}
