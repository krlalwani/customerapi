package com.krltest.customerapi.api.mapper;

import com.krltest.customerapi.api.model.CustomerDTO;
import com.krltest.customerapi.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    @Mappings({
            @Mapping(source = "customerName", target = "custName"),
            @Mapping(source = "pin", target = "pincode")
    })
    CustomerDTO custToCustomerDTO (Customer customer);
    Customer customerDTOToCust (CustomerDTO customerDTO);

}
