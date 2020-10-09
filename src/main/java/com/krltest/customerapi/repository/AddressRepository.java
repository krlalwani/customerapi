package com.krltest.customerapi.repository;

import com.krltest.customerapi.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
