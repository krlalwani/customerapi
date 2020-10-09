package com.krltest.customerapi.api.model;

import com.krltest.customerapi.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerListDTO {
    private List<CustomerDTO> customers;


}
