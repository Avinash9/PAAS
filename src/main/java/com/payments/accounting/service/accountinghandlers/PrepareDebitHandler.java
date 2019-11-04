package com.payments.accounting.service.accountinghandlers;

import com.payments.accounting.model.request.enums.AccountingType;
import com.payments.accounting.service.AccountingHandler;

/**
 * @author Ankit Thakwani
 * @version $Id: PrepareDebitHandler.java, v 0.1 2019-10-23 5:59 PM Ankit Thakwani Exp $$
 */
public class PrepareDebitHandler implements AccountingHandler {

    @Override
    public AccountingType getAccountingType(String txnType) {
        return AccountingType.PREPARE_DEBIT;
    }

}