package com.krltest.customerapi.api.model;

import com.krltest.customerapi.domain.AccountType;
import com.krltest.customerapi.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {

    private AccountType accountType;
    private int accountNo;
    //private Set<Customer> customer;
}
