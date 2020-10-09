package com.krltest.customerapi.controllers;

import com.krltest.customerapi.api.model.*;
import com.krltest.customerapi.domain.Account;
import com.krltest.customerapi.services.AccountService;
import com.krltest.customerapi.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping("/api/customers/")
public class CustomerController {
    private final CustomerService customerService;
    private final AccountService accountService;

    public CustomerController(CustomerService customerService, AccountService accountService) {
        this.customerService = customerService;
        this.accountService = accountService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CustomerListDTO getAllCustomers(){
        System.out.println("in get all customers..."+customerService.getAllCustomers().toString());
        return new CustomerListDTO(customerService.getAllCustomers());
    }


    @GetMapping("{name}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO getCustomerByName(@PathVariable String name){
        System.out.println("in get by customer name..."+customerService.getByCustomerName(name));
        return customerService.getByCustomerName(name);
    }

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomer(@RequestBody CustomerDTO customerDTO){
        //System.out.println("in create method!!............"+customerDTO.getCustName());
        //CustomerDTO c1 = new CustomerDTO(); //test to show builder capability
        //c1.builder().custName("Temp").city("Chuna").pincode(152458).build(); //test to show builder capability
        //to ensure a new customer gets created and not overwritten on existing customer if cust id is passed
        if(customerDTO.getCustomerId()!=null){
            customerDTO.setCustomerId(null);
        }
        customerService.createNewCustomer(customerDTO);
    }

    @PostMapping("edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO editCustomer(@RequestBody CustomerDTO customerDTO, @PathVariable Long id){
        System.out.println("in edit method!!............"+id);
        //to ensure existing customer if cust id is passed
        if(customerDTO.getCustomerId()==id){
            return customerService.editCustomer(customerDTO);
        }
        else return null;
    }

    @PostMapping("editName/{name}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO editCustomerByName(@RequestBody CustomerDTO customerDTO, @PathVariable String name){
            return customerService.editCustomerByName(customerDTO,name);
    }


    @GetMapping("delete/{name}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable String name){
        customerService.deleteCustomer(name);
    }

    @GetMapping("address/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Set<AddressDTO> getCustomerAddress (@PathVariable String name){
        return customerService.getCustomerAddress(name);
    }

    @GetMapping("accounts/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Set<AccountDTO> getCustomerAccounts (@PathVariable String name){
        return customerService.getCustomerAccount(name);
    }

    @GetMapping("account")
    @ResponseStatus(HttpStatus.OK)
    public Set<CustomerDTO> getCustomer(@RequestBody AccountDTO accountDTO){
        return customerService.getCustomer(accountDTO);
    }
}
