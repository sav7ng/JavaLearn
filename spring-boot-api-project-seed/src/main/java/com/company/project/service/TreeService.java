package com.company.project.service;

import com.company.project.model.Customer;
import com.company.project.model.Invoice;

public interface TreeService {

    Invoice getInvoiceById(Integer id);

    Customer getCustomerById(Integer id);

}
