package com.payments.accounting.service.impl;

import com.payments.accounting.model.Account;
import com.payments.accounting.repository.AccountRepository;
import com.payments.accounting.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Properties;


/**
 * @author Ankit Thakwani
 * @version $Id: AccountServiceImpl.java, v 0.1 2019-10-30 5:32 PM Ankit Thakwani Exp $$
 */

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    @Qualifier("exception")
    private Properties exceptionCodeToMessageMap;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Account createAccount(Account account) throws Exception {

        Account fetchedAccount = accountRepository.findAccountByOwnerId(account.getOwnerId());
        if (fetchedAccount == null) {
            return accountRepository.save(account);
        } else {
            throw new Exception();
        }

    }

}