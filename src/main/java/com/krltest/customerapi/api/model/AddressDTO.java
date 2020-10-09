package com.krltest.customerapi.api.model;

import com.krltest.customerapi.domain.AddressType;
import com.krltest.customerapi.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private Long addressId;
    private AddressType type;
    private String city;
    private int pincode;
    //private Customer customer;
}
