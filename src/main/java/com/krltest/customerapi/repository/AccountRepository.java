package com.krltest.customerapi.repository;


import com.krltest.customerapi.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
    Account findByAccountNo(int accountNo);

}
