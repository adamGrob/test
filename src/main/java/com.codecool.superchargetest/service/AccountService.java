package com.codecool.superchargetest.service;

import com.codecool.superchargetest.ejb.Account;
import com.codecool.superchargetest.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void transfer(Account fromAccount, Account toAccount, BigDecimal amount) {
        accountRepository.changeBalance(fromAccount.getId(), amount.negate());
        accountRepository.changeBalance(toAccount.getId(), amount);
    }

}


