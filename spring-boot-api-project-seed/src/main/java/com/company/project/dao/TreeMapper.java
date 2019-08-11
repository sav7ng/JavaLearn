package com.company.project.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.company.project.model.Customer;
import com.company.project.model.Invoice;
import org.mapstruct.Mapper;

@Mapper
public interface TreeMapper extends BaseMapper {

    Invoice getInvoiceById(Integer id);

    Customer getCustomerById(Integer id);

}
