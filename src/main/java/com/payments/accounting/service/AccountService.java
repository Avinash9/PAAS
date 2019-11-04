package com.payments.accounting.service;

import com.payments.accounting.model.Account;

/**
 * @author Ankit Thakwani
 * @version $Id: AccountService.java, v 0.1 2019-10-30 5:31 PM Ankit Thakwani Exp $$
 */
public interface AccountService {

    Account createAccount(Account account) throws Exception;

}