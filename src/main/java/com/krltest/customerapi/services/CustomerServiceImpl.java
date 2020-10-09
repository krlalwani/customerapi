package com.krltest.customerapi.services;

import com.krltest.customerapi.api.mapper.AccountDTOMapper;
import com.krltest.customerapi.api.mapper.AddressDTOMapper;
import com.krltest.customerapi.api.mapper.CustomerDTOMapper;
import com.krltest.customerapi.api.model.AccountDTO;
import com.krltest.customerapi.api.model.AddressDTO;
import com.krltest.customerapi.api.model.AddressListDTO;
import com.krltest.customerapi.api.model.CustomerDTO;
import com.krltest.customerapi.domain.*;
import com.krltest.customerapi.repository.AccountRepository;
import com.krltest.customerapi.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {


    private final CustomerDTOMapper customerDTOMapper;
    private final AddressDTOMapper addressDTOMapper;
    private final AccountDTOMapper accountDTOMapper;
    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;

    public CustomerServiceImpl(CustomerDTOMapper customerDTOMapper, AddressDTOMapper addressDTOMapper, AccountDTOMapper accountDTOMapper, CustomerRepository customerRepository, AccountRepository accountRepository) {
        this.customerDTOMapper = customerDTOMapper;
        this.addressDTOMapper = addressDTOMapper;
        this.accountDTOMapper = accountDTOMapper;
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
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
                          CustomerDTO customerDTO = customerDTOMapper.customerToCustomerDTO(customer);
                          return customerDTO;
                              })
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getByCustomerName(String name) {
        return customerDTOMapper.customerToCustomerDTO(customerRepository.findByFirstName(name));
    }

    @Override
    public void createNewCustomer(CustomerDTO customerDTO) {
        customerRepository.save(customerDTOMapper.customerDTOToCustomer(customerDTO));
    }

    @Override
    public void deleteCustomer(String name) {
        Customer customer = customerRepository.findByFirstName(name);
        customerRepository.delete(customer);
    }

    @Override
    public CustomerDTO editCustomer(CustomerDTO customerDTO) {
        Customer editedCustomer =  customerRepository.save(customerDTOMapper.customerDTOToCustomer(customerDTO));
        return customerDTOMapper.customerToCustomerDTO(editedCustomer);
    }

    @Override
    public CustomerDTO editCustomerByName(CustomerDTO customerDTO, String name) {
        Customer existingCustomerDetails = customerRepository.findByFirstName(name);
        Long existingCustomerId= existingCustomerDetails.getCustomerId();
        if(existingCustomerId!=null){
            Customer revisedCustomerDetails=customerDTOMapper.customerDTOToCustomer(customerDTO);
            revisedCustomerDetails.setCustomerId(existingCustomerId);
            customerRepository.save(revisedCustomerDetails);
            return customerDTOMapper.customerToCustomerDTO(revisedCustomerDetails);
        }
        else return null;
    }

    @Override
    public Set<AddressDTO> getCustomerAddress(String name) {
        Customer customer = customerRepository.findByFirstName(name);
        Set<Address> set = customer.getAddress();
        Set<AddressDTO> returnObject = new HashSet<>();
        AddressDTO addressDTO;
        for (Address setNew : set) {
            System.out.println(" AddressType : ..." + setNew.getType()+" City ..."+setNew.getCity());
            addressDTO = addressDTOMapper.addressToAddressDTO(setNew);
            returnObject.add(addressDTO);
        }
        return  returnObject;
    }
    @Override
    public Set<AccountDTO> getCustomerAccount(String name) {
        Customer customer = customerRepository.findByFirstName(name);
        Set<Account> set = customer.getAccount();
        Set<AccountDTO> returnObject = new HashSet<>();
        AccountDTO accountDTO;
        for (Account setNew : set) {
            accountDTO = accountDTOMapper.accountToAccountDTO(setNew);
            returnObject.add(accountDTO);
        }
        return  returnObject;
    }

    @Override
    public Set<CustomerDTO> getCustomer(AccountDTO accountDTO) {

        Account custAccount = accountRepository.findByAccountNo(accountDTO.getAccountNo());
        Set<Customer> set = custAccount.getCustomer();
        Set<CustomerDTO> returnObject = new HashSet<>();
        CustomerDTO customerDTO;
        for (Customer setNew : set) {
            customerDTO = customerDTOMapper.customerToCustomerDTO(setNew);
            returnObject.add(customerDTO);
        }
        return  returnObject;

    }
}
