package com.krltest.customerapi.services;

import com.krltest.customerapi.api.mapper.CustomerDTOMapper;
import com.krltest.customerapi.api.mapper.CustomerMapper;
import com.krltest.customerapi.api.model.CustomerDTO;
import com.krltest.customerapi.domain.Customer;
import com.krltest.customerapi.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerMapper customerMapper;
    private final CustomerDTOMapper customerDTOMapper;
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerMapper customerMapper, CustomerDTOMapper customerDTOMapper, CustomerRepository customerRepository) {
        this.customerMapper = customerMapper;
        this.customerDTOMapper = customerDTOMapper;
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
                          CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);
                          return customerDTO;
                              })
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getByCustomerName(String name) {
        return customerMapper.customerToCustomerDTO(customerRepository.findByCustomerName(name));
    }

    @Override
    public void createNewCustomer(CustomerDTO customerDTO) {
        customerRepository.save(customerDTOMapper.customerDTOToCustomer(customerDTO));
    }

    @Override
    public void deleteCustomer(String name) {
        Customer customer = customerRepository.findByCustomerName(name);
        customerRepository.delete(customer);
    }

    @Override
    public CustomerDTO editCustomer(CustomerDTO customerDTO) {
        Customer editedCustomer =  customerRepository.save(customerDTOMapper.customerDTOToCustomer(customerDTO));
        return customerMapper.customerToCustomerDTO(editedCustomer);
    }

    @Override
    public CustomerDTO editCustomerByName(CustomerDTO customerDTO, String name) {
        Customer existingCustomerDetails = customerRepository.findByCustomerName(name);
        Long existingCustomerId= existingCustomerDetails.getCustId();
        if(existingCustomerId!=null){
            Customer revisedCustomerDetails=customerDTOMapper.customerDTOToCustomer(customerDTO);
            revisedCustomerDetails.setCustId(existingCustomerId);
            customerRepository.save(revisedCustomerDetails);
            return customerMapper.customerToCustomerDTO(revisedCustomerDetails);
        }
        else return null;
    }
}
