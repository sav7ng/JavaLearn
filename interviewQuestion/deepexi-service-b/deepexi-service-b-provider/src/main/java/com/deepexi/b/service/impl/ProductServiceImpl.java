package com.deepexi.b.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.deepexi.b.service.ProductService;
import com.deepexi.b.domain.eo.Product;
import com.deepexi.b.extension.ApplicationException;
import com.deepexi.b.mapper.ProductMapper;
import com.deepexi.util.pageHelper.PageBean;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by donh on 2018/11/6.
 */
@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductMapper productMapper;

    public PageBean getProductList(Integer page, Integer size, Integer age) {
        PageHelper.startPage(page, size);
        List<Product> userTasks = productMapper.selectPageVo(age);
        return new PageBean<>(userTasks);
    }

    public Integer createProduct(Product product) {
        return productMapper.insert(product);
    }

    public Boolean deleteProductById(String id) {
        productMapper.deleteById(id);
        return true;
    }

    @SentinelResource(value = "testSentinel", fallback = "doFallback", blockHandler = "exceptionHandler")
    public Product getProductById(String id) {
        return productMapper.selectById(id);
    }

    public String doFallback(long i) {
        // Return fallback value.
        return "Oops, degraded";
    }

    /**
     * 熔断降级处理逻辑
     * @param s
     * @param ex
     * @return
     */
    public void exceptionHandler(long s, Exception ex) {
        // Do some log here.
        logger.info("-------------熔断降级处理逻辑---------\n");
        throw new ApplicationException("100", "熔断降级处理");
    }

    @Override
    public void testError() {
        throw new ApplicationException("100", "测试异常");
    }
}