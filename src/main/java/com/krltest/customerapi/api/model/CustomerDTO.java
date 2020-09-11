package com.krltest.customerapi.api.model;

import lombok.Data;

@Data
public class CustomerDTO {

    private Long custId;
    private String custName;
    private String city;
    private int pincode;
}
