package com.deepexi.b.depend;

import com.deepexi.b.domain.eo.Product;
import com.deepexi.util.config.Payload;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by donh on 2018/11/5.
 */
@FeignClient(value = "deepexi-service-a-provider")
public interface DemoClient {

    @RequestMapping(method = RequestMethod.GET, value = "/provider/add")
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);


    @GetMapping(value = "/deepexi-service-a/api/v1/products/{id}")
    Payload getProductById(@PathVariable("id") String id);

    @PostMapping(value = "/deepexi-service-a/api/v1/products")
    Payload createProduct(@RequestBody Product product);

}