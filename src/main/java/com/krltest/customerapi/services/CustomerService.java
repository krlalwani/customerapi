package com.krltest.customerapi.services;

import com.krltest.customerapi.api.model.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {
    List<CustomerDTO> getAllCustomers();

    CustomerDTO getByCustomerName(String name);
}
