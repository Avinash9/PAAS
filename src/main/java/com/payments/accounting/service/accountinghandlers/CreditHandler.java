package com.payments.accounting.service.accountinghandlers;

import com.payments.accounting.enums.AccountingType;
import com.payments.accounting.service.AccountingHandler;

/**
 * @author Ankit Thakwani
 * @version $Id: CreditHandler.java, v 0.1 2019-10-22 1:22 PM Ankit Thakwani Exp $$
 */
public class CreditHandler implements AccountingHandler {

    @Override
    public AccountingType getAccountingType(String txnType) {
        return AccountingType.CREDIT;
    }
}