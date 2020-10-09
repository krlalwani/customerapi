package com.krltest.customerapi.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;

    @Enumerated(value = EnumType.STRING)
    private AccountType accountType;

    private int accountNo;

    @ManyToMany(mappedBy = "account",fetch = FetchType.EAGER)
    private Set<Customer> customer=new HashSet<>();

  public int getAccountId() {
    return accountId;
  }

  public void setAccountId(int accountId) {
    this.accountId = accountId;
  }

  public AccountType getAccountType() {
    return accountType;
  }

  public void setAccountType(AccountType accountType) {
    this.accountType = accountType;
  }

  public int getAccountNo() {
    return accountNo;
  }

  public void setAccountNo(int accountNo) {
    this.accountNo = accountNo;
  }

  public Set<Customer> getCustomer() {
    return customer;
  }

  public void setCustomer(Set<Customer> customer) {
    this.customer = customer;
  }
}
