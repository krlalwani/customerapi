package com.krltest.customerapi.api.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressListDTO {
    //private AddressDTO addressDTO;
    private Set<AddressDTO> addresses = new HashSet<>();

    public Set<AddressDTO> setAddressListDTO(AddressDTO addressDTO){
        addresses.add(addressDTO);
        return this.addresses;
    }
}
