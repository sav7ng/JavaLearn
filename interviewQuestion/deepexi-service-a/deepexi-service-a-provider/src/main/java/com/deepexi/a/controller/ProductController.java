package com.deepexi.a.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSONArray;
import com.deepexi.a.depend.DemoClient;
import com.deepexi.a.domain.eo.Product;
import com.deepexi.a.extension.ApplicationException;
import com.deepexi.a.service.ProductService;
import com.deepexi.util.config.Payload;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by donh on 2018/11/5.
 */
@Api(value = "productcontroller",description = "商品管理")
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DemoClient demolient; // feign让跨服务调用能够看起来像本地调用

    @Autowired
    private ProductService productService;

    @ApiOperation(value ="过滤价格查询所有商品",notes ="",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page",value = "第几页",required = false,dataType = "Integer"),
            @ApiImplicitParam(name = "size",value = "每页查询数",required = false,dataType = "Integer"),
            @ApiImplicitParam(name = "price",value = "价格",required = false,dataType = "Integer")
    })
    @GetMapping
    public Payload getProductList(@RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                                  @RequestParam(name = "size", required = false, defaultValue = "10") Integer size,
                                  @RequestParam(name = "price", required = false, defaultValue = "0") Integer price) {
        return new Payload(productService.getProductList(page, size, price));
    }

    @GetMapping("/{id:[a-zA-Z0-9]+}")
    public Payload getProductById(@PathVariable("id") String id) {
        return new Payload(productService.getProductById(id));
    }

    @PostMapping
    public Payload createProduct(@RequestBody Product product) {
        return new Payload(productService.createProduct(product));
    }

    @PutMapping("/{upid:[a-zA-Z0-9]+}")
    public Payload updateProductById(@PathVariable("upid") String upid,
                                     @RequestParam("name") String name,
                                     @RequestParam("price") Integer price) {
        // return new Payload(productService.updateProductById(id, product));
        // productService.updateProductById(id, product);
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        Integer updateProductById = productService.updateProductById(upid, product);
        if (updateProductById > 0) {
            return new Payload(updateProductById);
        } else {
            return new Payload("修改失败！");
        }
    }

    // @DeleteMapping("/{id:[a-zA-Z0-9]+}")
    @DeleteMapping("/deleteProductByIds")
    @ApiOperation(value="删除Product", notes="deleteProductByIds")
    public Payload deleteProductByIds(@RequestParam("productIds") List<String> ids) {
        return new Payload(productService.deleteProductByIds(ids));
    }


    @GetMapping("/testError")
    public Payload testError() {
        productService.testError();
        return new Payload(true);
    }

    @GetMapping("/testSentinel")
    @SentinelResource(value = "testSentinel", blockHandler = "exceptionHandler")
    public Payload testSentinel() {
        logger.info("远程Sentinel测试接口成功: Hello World!!");
        return new Payload(true);
    }

    /**
     * 熔断降级处理逻辑
     * @param s
     * @param ex
     * @return
     */
    public Payload exceptionHandler(long s, BlockException ex) {
        // Do some log here.
        logger.info("-------------熔断降级处理逻辑---------\n");
        throw new ApplicationException("100", "熔断降级处理");
    }

    @GetMapping("/testFeign")
    public Payload testFeign(@RequestParam Integer a, @RequestParam Integer b) {
        logger.info("远程调用成功: Hello World!!");
        return new Payload(demolient.add(10, 20));
    }
}
