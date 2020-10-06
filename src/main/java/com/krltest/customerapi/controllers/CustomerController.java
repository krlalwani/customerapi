package com.krltest.customerapi.controllers;

import com.krltest.customerapi.api.model.CustomerDTO;
import com.krltest.customerapi.api.model.CustomerListDTO;
import com.krltest.customerapi.domain.Customer;
import com.krltest.customerapi.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers/")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CustomerListDTO getAllCustomers(){
        System.out.println("in get all customers"+customerService.getAllCustomers().toString());
        return new CustomerListDTO(customerService.getAllCustomers());
    }


    @GetMapping("{name}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO getCustomerByName(@PathVariable String name){
        System.out.println("in get by customer name"+customerService.getByCustomerName(name));
        return customerService.getByCustomerName(name);
    }

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomer(){
        //@RequestBody CustomerDTO customerDTO - in argument
        System.out.println("in create method!!............");

        Customer c1 = new Customer();
        c1.setCustomerName("Temp");
        c1.setCity("Chuna");
        c1.setPin(152458);
        customerService.createNewCustomer(c1);
    }


    @GetMapping("delete/{name}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable String name){
        customerService.deleteCustomer(name);
    }
}
