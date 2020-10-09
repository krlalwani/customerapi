package com.krltest.customerapi.services;

import com.krltest.customerapi.api.mapper.AccountDTOMapper;
import com.krltest.customerapi.api.model.AccountDTO;
import com.krltest.customerapi.domain.Account;
import com.krltest.customerapi.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{
    private AccountRepository accountRepository;
    private AccountDTOMapper accountDTOMapper;

    public AccountServiceImpl(AccountRepository accountRepository, AccountDTOMapper accountDTOMapper) {
        this.accountRepository = accountRepository;
        this.accountDTOMapper = accountDTOMapper;
    }

    @Override
    public AccountDTO getCustomerByAccountNo(int accountNo) {
        System.out.println("...Account No...."+accountNo);
        Account account=accountRepository.findByAccountNo(accountNo);
        return accountDTOMapper.accountToAccountDTO(account);
    }
}
