package com.deepexi.a.service;

import com.deepexi.a.domain.eo.Product;
import com.deepexi.util.pageHelper.PageBean;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    PageBean getProductList(Integer page, Integer size, Integer price);

    Product getProductById(String id);

    Integer createProduct(Product product);

    Boolean deleteProductById(String id);

    void testError();

    // Integer updateProductById(String upid, Product product);
    Integer updateProductById(String upid, String name);
}
