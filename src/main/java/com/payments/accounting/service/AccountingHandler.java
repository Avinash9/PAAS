package com.payments.accounting.service;

import com.payments.accounting.enums.AccountingType;

/**
 * @author Ankit Thakwani
 * @version $Id: AccountingHandler.java, v 0.1 2019-10-22 1:20 PM Ankit Thakwani Exp $$
 */
public interface AccountingHandler {

    AccountingType getAccountingType(String txnType);

}