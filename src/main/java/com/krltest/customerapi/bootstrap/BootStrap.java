package com.krltest.customerapi.bootstrap;

import com.krltest.customerapi.api.model.CustomerDTO;
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
        loadCustomers();

        System.out.println("Data Loaded +" + customerRepository.count());
        //Customer cust5 = customerRepository.findByCustomerName("Man");
        //System.out.println("Customer + "+ cust5.getCity());

    }

    private void loadCustomers() {
        Customer cust1 = new Customer();
        cust1.setCustomerName("Kumar");
        cust1.setCity("Mumbai");
        cust1.setPin(400071);

        Customer cust2 = new Customer();
        cust2.setCustomerName("Mannat");
        cust2.setCity("Ulhasnagar");
        cust2.setPin(421003);

        Customer cust3 = new Customer();
        cust3.setCustomerName("Urvi");
        cust3.setCity("Goregaon");
        cust3.setPin(400063);

        Customer cust4 = new Customer();
        cust4.setCustomerName("Sushila");
        cust4.setCity("NCPA");
        cust4.setPin(400021);

        customerRepository.save(cust1);
        customerRepository.save(cust2);
        customerRepository.save(cust3);
        customerRepository.save(cust4);
    }
}
