package com.krltest.customerapi.bootstrap;


import com.krltest.customerapi.api.mapper.AccountDTOMapper;
import com.krltest.customerapi.api.mapper.AddressDTOMapper;
import com.krltest.customerapi.api.mapper.CustomerDTOMapper;
import com.krltest.customerapi.api.model.*;
import com.krltest.customerapi.domain.*;
import com.krltest.customerapi.repository.AccountRepository;
import com.krltest.customerapi.repository.AddressRepository;
import com.krltest.customerapi.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Component
public class BootStrap implements CommandLineRunner {
    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;
    private final AddressRepository addressRepository;
    private final CustomerDTOMapper customerDTOMapper;
    private final AddressDTOMapper addressDTOMapper;
    private final AccountDTOMapper accountDTOMapper;

    public BootStrap(CustomerRepository customerRepository, AccountRepository accountRepository,
                     AddressRepository addressRepository, CustomerDTOMapper customerDTOMapper,
                     AddressDTOMapper addressDTOMapper, AccountDTOMapper accountDTOMapper) {
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
        this.addressRepository = addressRepository;
        this.customerDTOMapper = customerDTOMapper;
        this.addressDTOMapper = addressDTOMapper;
        this.accountDTOMapper = accountDTOMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCustomers();
        System.out.println("==============================================================");
        System.out.println("Data Loaded +" + customerRepository.count());

        //retrieveDataModel();
        retrieveDataDTO();

    }

    private void loadCustomers(){
        Customer cust = new Customer();
        cust.setFirstName("Kumar");

        Address add1= new Address();
        add1.setCity("Goregaon");
        add1.setPincode(400063);
        add1.setType(AddressType.RESI);
        cust.addAddress(add1);

        Address add2= new Address();
        add2.setCity("Powai");
        add2.setPincode(400071);
        add2.setType(AddressType.OFFICE);
        cust.addAddress(add2);

        Account acc1=new Account();
        acc1.setAccountType(AccountType.SAVINGS);
        acc1.setAccountNo(123456789);
        Account acc2=new Account();
        acc2.setAccountType(AccountType.CURRENT);
        acc2.setAccountNo(98745874);

        Set<Account> acctSet = new HashSet<>();
        acctSet.add(acc1);
        acctSet.add(acc2);
        cust.setAccount(acctSet);

        customerRepository.save(cust);

        Customer cust2 = new Customer();
        cust2.setFirstName("Mannat");
        Address add3= new Address();
        add3.setCity("Andheri");
        add3.setPincode(400001);
        add3.setType(AddressType.OFFICE);
        cust2.addAddress(add3);
        Account acc3=new Account();
        acc3.setAccountType(AccountType.CURRENT);
        acc3.setAccountNo(11111111);
        Set<Account> acct1Set = new HashSet<>();
        acct1Set.add(acc3);
        cust2.setAccount(acct1Set);

        customerRepository.save(cust2);
    }
    private void retrieveDataModel(){
        System.out.println("==============================================================");
        Customer cust2 = customerRepository.findByFirstName("Kumar");
        System.out.println("Customer Saved= " +cust2.getCustomerId());

        Set<Address> add = cust2.getAddress();
        for (Address add1 : add) {
            System.out.println(" AddressType : ..." + add1.getType() + " of customer " + add1.getCustomer().getFirstName());
        }
        Set<Account> acc = cust2.getAccount();
        for (Account add2 : acc) {
            System.out.println(" Accont Type : ..." + add2.getAccountType() + " of customer " + add2.getCustomer().iterator().next().getFirstName());
        }
        System.out.println("Mannat Account +"+accountRepository.findByAccountNo(11111111).getCustomer().iterator().next().getFirstName());


    }
    private void retrieveDataDTO(){
        System.out.println("==============================================================");
        Customer cust2= customerRepository.findByFirstName("Kumar");
        CustomerDTO cust2DTO= customerDTOMapper.customerToCustomerDTO(cust2);

        AddressListDTO addressListDTO = new AddressListDTO();
        AddressDTO addressDTO = new AddressDTO();

        Set<Address> set = cust2.getAddress();
        for (Address setNew : set) {
            System.out.println(" AddressType : ..." + setNew.getType()+" City ..."+setNew.getCity()+"...."+setNew.getCustomer());
            addressDTO = addressDTOMapper.addressToAddressDTO(setNew);
            addressListDTO.setAddressListDTO(addressDTO);
        }

        AccountListDTO accountListDTO= new AccountListDTO();
        AccountDTO accountDTO = new AccountDTO();

        Set<Account> setAcct = cust2.getAccount();
        for (Account setNewAcct : setAcct) {
            System.out.println(" AccountType : ..." + setNewAcct.getAccountType()+" AccountNo ..."+setNewAcct.getAccountNo());
            accountDTO = accountDTOMapper.accountToAccountDTO(setNewAcct);
            accountListDTO.setAccountListDTO(accountDTO);
        }
    }
}
