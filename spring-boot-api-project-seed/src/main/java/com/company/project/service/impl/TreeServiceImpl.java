package com.company.project.service.impl;

import com.company.project.dao.TreeMapper;
import com.company.project.model.Customer;
import com.company.project.model.Invoice;
import com.company.project.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Class TreeServiceImpl
 * @Description TODO
 * @Author Aquan
 * @Date 2019.8.10 21:35
 * @Version 1.0
 **/
@Service
@Transactional
public class TreeServiceImpl implements TreeService {

    @Autowired
    TreeMapper treeMapper;

    @Override
    public Invoice getInvoiceById(Integer id) {
        return treeMapper.getInvoiceById(id);
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return treeMapper.getCustomerById(id);
    }
}