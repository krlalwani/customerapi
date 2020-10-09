package com.krltest.customerapi.api.mapper;

import com.krltest.customerapi.api.model.CustomerDTO;
import com.krltest.customerapi.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerDTOMapper {
    CustomerDTOMapper INSTANCE = Mappers.getMapper(CustomerDTOMapper.class);
  /*
      @Mappings({
            //@Mapping(source = "custName", target = "firstName"),
            //@Mapping(source = "pincode", target = "pin")
    })

   */
    Customer customerDTOToCustomer(CustomerDTO customerDTO);
    CustomerDTO customerToCustomerDTO (Customer customer);

}
