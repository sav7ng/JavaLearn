package com.deepexi.a.domain.eo;

import com.baomidou.mybatisplus.annotation.TableName;


@TableName("product")
public class Product extends SuperEntity {

    private String name;

    private Integer price;

    public Product() {}

    public Product(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}

