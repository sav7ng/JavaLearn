package com.deepexi.a.service;

import com.deepexi.a.domain.eo.Product;
import com.deepexi.util.pageHelper.PageBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    PageBean getProductList(Integer page, Integer size, Integer price);

    Product getProductById(String id);

    Integer createProduct(Product product);

    Boolean deleteProductByIds(List<String> ids);

    void testError();

    // Integer updateProductById(String upid, Product product);
    Integer updateProductById(String upid, Product product);
}
