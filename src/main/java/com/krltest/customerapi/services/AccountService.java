package com.krltest.customerapi.services;

import com.krltest.customerapi.api.model.AccountDTO;

public interface AccountService {
    AccountDTO getCustomerByAccountNo (int accountNo);
}
