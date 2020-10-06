package com.krltest.customerapi.controllers;

import com.krltest.customerapi.api.model.CustomerDTO;
import com.krltest.customerapi.api.model.CustomerListDTO;
import com.krltest.customerapi.domain.Customer;
import com.krltest.customerapi.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers/")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity <CustomerListDTO> getAllCustomers(){
        System.out.println("in get all customers"+customerService.getAllCustomers().toString());
        return new ResponseEntity <CustomerListDTO>(
                new CustomerListDTO(customerService.getAllCustomers()),
                HttpStatus.OK);
    }


    @GetMapping("{name}")
    public ResponseEntity<CustomerDTO> getCustomerByName(@PathVariable String name){
        System.out.println("in get by customer name"+customerService.getByCustomerName(name));
        return new ResponseEntity<CustomerDTO>(
                customerService.getByCustomerName(name),
                HttpStatus.OK
        );
    }

    @PostMapping("create")
    public ResponseEntity<Customer> createCustomer(){
        //@RequestBody CustomerDTO customerDTO - in argument

        System.out.println("in create method!!............");

        Customer c1 = new Customer();
        c1.setCustomerName("Temp");
        c1.setCity("Chuna");
        c1.setPin(152458);

        customerService.createNewCustomer(c1);
        return new ResponseEntity<Customer>(
                HttpStatus.CREATED
        );
    }

    @GetMapping("delete/{name}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable String name){
        customerService.deleteCustomer(name);

        return new ResponseEntity<Customer>(
                HttpStatus.OK
        );
    }
}
