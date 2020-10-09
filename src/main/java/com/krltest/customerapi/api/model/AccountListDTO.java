package com.krltest.customerapi.api.model;

import com.krltest.customerapi.domain.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountListDTO {
    private Set<AccountDTO> accounts = new HashSet<>();

    public Set<AccountDTO> setAccountListDTO(AccountDTO accountDTO){
        accounts.add(accountDTO);
        return this.accounts;
    }
}
