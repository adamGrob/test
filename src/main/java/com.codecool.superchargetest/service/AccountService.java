package com.codecool.superchargetest.service;

import com.codecool.superchargetest.ejb.Account;
import com.codecool.superchargetest.ejb.Transaction;
import com.codecool.superchargetest.model.TransActionType;
import com.codecool.superchargetest.repository.AccountRepository;
import com.codecool.superchargetest.repository.TransActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Date;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    private TransActionRepository transActionRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository, TransActionRepository transActionRepository) {
        this.accountRepository = accountRepository;
        this.transActionRepository = transActionRepository;
    }

    public void transfer(Account fromAccount, Account toAccount, BigDecimal amount) {
        changeBalance(fromAccount, amount, TransActionType.WITHDRAW);

        changeBalance(toAccount, amount, TransActionType.DEPOSIT);
    }

    public void changeBalance(Account account, BigDecimal amount, TransActionType transActionType){
        Transaction transActionB = new Transaction();
        transActionB.setBalanceAtTransAction(account.getBalance());
        transActionB.setDate(new Date());
        transActionB.setTransActionType(transActionType);
        transActionB.setAccount(account);
        if(transActionType.equals(TransActionType.DEPOSIT)) {
            transActionB.setTransactionAmount(amount);
            accountRepository.changeBalance(account.getId(), amount);
        } else {
            transActionB.setTransactionAmount(amount.negate());
            accountRepository.changeBalance(account.getId(), amount.negate());
        }
        transActionRepository.save(transActionB);
    }
}


