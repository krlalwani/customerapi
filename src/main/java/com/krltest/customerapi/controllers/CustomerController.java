package com.krltest.customerapi.controllers;

import com.krltest.customerapi.api.model.CustomerDTO;
import com.krltest.customerapi.api.model.CustomerListDTO;
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
    public void createCustomer(@RequestBody CustomerDTO customerDTO){
        System.out.println("in create method!!............"+customerDTO.getCustName());
        CustomerDTO c1 = new CustomerDTO(); //test to show builder capability
        c1.builder().custName("Temp").city("Chuna").pincode(152458).build(); //test to show builder capability
        //to ensure a new customer gets created and not overwritten on existing customer if cust id is passed
        if(customerDTO.getCustId()!=null){
            customerDTO.setCustId(null);
        }
        customerService.createNewCustomer(customerDTO);
    }

    @PostMapping("edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO editCustomer(@RequestBody CustomerDTO customerDTO, @PathVariable Long id){
        System.out.println("in edit method!!............"+id);
        //to ensure existing customer if cust id is passed
        if(customerDTO.getCustId()==id){
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
}
