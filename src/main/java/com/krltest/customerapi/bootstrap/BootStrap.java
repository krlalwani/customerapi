package com.krltest.customerapi.bootstrap;

import com.krltest.customerapi.domain.Customer;
import com.krltest.customerapi.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrap implements CommandLineRunner {
    private CustomerRepository customerRepository;

    public BootStrap(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Customer cust1 = new Customer();
        cust1.setCustomerName("Kum");
        cust1.setCity("Mumbai");
        cust1.setPin(400071);

        Customer cust2 = new Customer();
        cust2.setCustomerName("Ash");
        cust2.setCity("Ulhasnagar");
        cust2.setPin(421003);

        Customer cust3 = new Customer();
        cust3.setCustomerName("Man");
        cust3.setCity("Goregaon");
        cust3.setPin(400063);

        Customer cust4 = new Customer();
        cust4.setCustomerName("Ur");
        cust4.setCity("NCPA");
        cust4.setPin(400021);

        customerRepository.save(cust1);
        customerRepository.save(cust2);
        customerRepository.save(cust3);
        customerRepository.save(cust4);

        System.out.println("Data Loaded +" + customerRepository.count());
        //Customer cust5 = customerRepository.findByCustomerName("Mannat");
        //System.out.println("Customer + "+ cust5.getCity());

    }
}
