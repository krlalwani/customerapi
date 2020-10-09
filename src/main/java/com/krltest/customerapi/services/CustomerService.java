package com.krltest.customerapi.services;

import com.krltest.customerapi.api.model.AccountDTO;
import com.krltest.customerapi.api.model.AddressDTO;
import com.krltest.customerapi.api.model.CustomerDTO;
import java.util.List;
import java.util.Set;


public interface CustomerService {
    List<CustomerDTO> getAllCustomers();
    CustomerDTO getByCustomerName(String name);
    void createNewCustomer(CustomerDTO customerDTO);
    void deleteCustomer(String name);
    CustomerDTO editCustomer(CustomerDTO customerDTO);
    CustomerDTO editCustomerByName(CustomerDTO customerDTO, String name);
    Set<AddressDTO> getCustomerAddress(String name);
    Set<AccountDTO> getCustomerAccount(String name);
    Set<CustomerDTO> getCustomer(AccountDTO accountDTO);
}
