package com.krltest.customerapi.api.mapper;

import com.krltest.customerapi.api.model.AccountDTO;
import com.krltest.customerapi.domain.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountDTOMapper {
    AccountDTOMapper INSTANCE = Mappers.getMapper(AccountDTOMapper.class);
    Account accountDTOToAccount (AccountDTO accountDTO);
    AccountDTO accountToAccountDTO (Account account);
}
