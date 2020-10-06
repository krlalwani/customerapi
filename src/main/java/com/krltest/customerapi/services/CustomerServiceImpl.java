package com.krltest.customerapi.services;

import com.krltest.customerapi.api.mapper.CustomerMapper;
import com.krltest.customerapi.api.model.CustomerDTO;
import com.krltest.customerapi.domain.Customer;
import com.krltest.customerapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerMapper customerMapper, CustomerRepository customerRepository) {
        this.customerMapper = customerMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        /* USE EITHER OR
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::custToCustomerDTO)
                .collect(Collectors.toList());

         */
        return customerRepository.findAll()
                .stream()
                .map(customer ->{
                          CustomerDTO customerDTO = customerMapper.custToCustomerDTO(customer);
                          return customerDTO;
                              })
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getByCustomerName(String name) {
        //return null; //for testing in interim
        return customerMapper.custToCustomerDTO(customerRepository.findByCustomerName(name));
    }

    @Override
    public void createNewCustomer(Customer customer) {
        System.out.println("Arg customer ..."+customer.getCustomerName());
        customerRepository.save(customer);
        System.out.println("New Data Loaded +" + customerRepository.count());
        //System.out.println("Customer retrieved!.."+customerMapper.customerDTOToCust(customerDTO).getCustomerName());
        //Customer customer = customerRepository.save(customerMapper.customerDTOToCust(customerDTO));

    }

    @Override
    public void deleteCustomer(String name) {
        Customer customer = customerRepository.findByCustomerName(name);
        customerRepository.delete(customer);
    }
}
