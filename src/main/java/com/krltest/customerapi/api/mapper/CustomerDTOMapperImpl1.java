package com.krltest.customerapi.api.mapper;

import com.krltest.customerapi.api.model.AccountDTO;
import com.krltest.customerapi.api.model.AddressDTO;
import com.krltest.customerapi.api.model.CustomerDTO;
import com.krltest.customerapi.domain.Account;
import com.krltest.customerapi.domain.Address;
import com.krltest.customerapi.domain.Customer;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;


//@Component
public class CustomerDTOMapperImpl1 {//implements CustomerDTOMapper {
    private AddressDTOMapper addressDTOMapper;
    private AccountDTOMapper accountDTOMapper;

    public CustomerDTOMapperImpl1(AddressDTOMapper addressDTOMapper, AccountDTOMapper accountDTOMapper) {
        this.addressDTOMapper = addressDTOMapper;
        this.accountDTOMapper = accountDTOMapper;
    }

    public CustomerDTOMapperImpl1() {
    }
/*
    public Customer customerDTOToCustomer(CustomerDTO customerDTO) {
        if (customerDTO == null) {
            return null;
        } else {
            Customer customer = new Customer();
            customer.setCustomerId(customerDTO.getCustomerId());
            customer.setFirstName(customerDTO.getFirstName());
            Set<AddressDTO> set = customerDTO.getAddress();
            if (set != null) {
                customer.setAddress(new HashSet(set));
            }

            Set<AccountDTO> set1 = customerDTO.getAccount();
            if (set1 != null) {
                customer.setAccount(new HashSet(set1));
            }

            return customer;
        }
    }
/*
    public CustomerDTO customerToCustomerDTO(Customer customer) {
        if (customer == null) {
            return null;
        } else {
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setCustomerId(customer.getCustomerId());
            customerDTO.setFirstName(customer.getFirstName());
            Set<AddressDTO> set = customer.getAddress();
            if (set != null) {
                customerDTO.setAddress(new HashSet(set));
            }

            Set<AccountDTO> set1 = customer.getAccount();
            if (set1 != null) {
                customerDTO.setAccount(new HashSet(set1));
            }

            return customerDTO;
        }
    }

 */
}

