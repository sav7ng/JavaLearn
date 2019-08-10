package com.company.project.service.impl;

import com.company.project.dao.InvoiceMapper;
import com.company.project.model.Invoice;
import com.company.project.service.InvoiceService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/08/10.
 */
@Service
@Transactional
public class InvoiceServiceImpl extends AbstractService<Invoice> implements InvoiceService {
    @Resource
    private InvoiceMapper invoiceMapper;

}
