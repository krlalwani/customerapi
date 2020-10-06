package com.krltest.customerapi.services;

import com.krltest.customerapi.api.model.CustomerDTO;
import com.krltest.customerapi.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {
    List<CustomerDTO> getAllCustomers();

    CustomerDTO getByCustomerName(String name);
    void createNewCustomer(Customer customer);
    void deleteCustomer(String name);
}
