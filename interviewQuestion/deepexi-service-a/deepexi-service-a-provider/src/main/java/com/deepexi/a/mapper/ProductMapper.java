package com.deepexi.a.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.deepexi.a.domain.eo.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by donh on 2018/7/24.
 */
public interface ProductMapper extends BaseMapper<Product> {

    @Select("SELECT * FROM product WHERE price > #{price}")
    List<Product> selectPageVo(@Param("price") Integer price);

    @Update("update product set name = #{name} where id = #{upid}")
    Integer updateProductById(@Param("upid") String upid, @Param("name") String name);

}
