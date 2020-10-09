package com.krltest.customerapi.api.model;

import com.krltest.customerapi.domain.Account;
import com.krltest.customerapi.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    private Long customerId;
    private String firstName;
    //private Set<AddressDTO> address;
    //private Set<AccountDTO> account;

}
