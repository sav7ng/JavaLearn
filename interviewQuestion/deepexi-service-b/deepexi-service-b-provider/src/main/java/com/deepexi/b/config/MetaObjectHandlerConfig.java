package com.deepexi.b.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class MetaObjectHandlerConfig implements MetaObjectHandler {

    // mybatis-plus公共字段自动填充，https://baomidou.oschina.io/mybatis-plus-doc/#/auto-fill
    @Override
    public void insertFill(MetaObject metaObject) {
//        System.out.println("插入方法实体填充");
        setFieldValByName("createdAt", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
//        System.out.println("更新方法实体填充");
        setFieldValByName("updatedAt", new Date(), metaObject);
    }
}