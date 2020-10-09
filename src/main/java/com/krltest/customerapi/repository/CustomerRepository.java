package com.krltest.customerapi.repository;

import com.krltest.customerapi.api.model.CustomerDTO;
import com.krltest.customerapi.domain.Address;
import com.krltest.customerapi.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByFirstName(String customerName);

}
