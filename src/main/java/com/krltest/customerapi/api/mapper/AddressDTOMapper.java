package com.krltest.customerapi.api.mapper;

import com.krltest.customerapi.api.model.AddressDTO;
import com.krltest.customerapi.domain.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressDTOMapper {
    AddressDTOMapper INSTANCE = Mappers.getMapper(AddressDTOMapper.class);
    Address addressDTOToAddress (AddressDTO addressDTO);
    AddressDTO addressToAddressDTO (Address address);
}
