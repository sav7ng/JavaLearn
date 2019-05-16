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

    @Select("SELECT * FROM product p WHERE p.price > #{price}")
    List<Product> selectPageVo(@Param("price") Integer price);

    // @Update("update product set name = #{product.name}, price = #{product.price} where id = #{upid}")
    // Integer updateProductById(@Param("upid") String upid, Product product);

    @Update("update product p set p.name = #{product.name}, p.price = #{product.price}, p.updated_at = sysdate() where p.id = #{upid}")
    Integer updateProductById(@Param("upid") String upid,@Param("product") Product product);

    // @Delete("delete from product p where p.id in () ")
    // Boolean deleteProductById(List ids);

}
