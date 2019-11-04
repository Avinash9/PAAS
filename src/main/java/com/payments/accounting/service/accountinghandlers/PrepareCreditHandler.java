package com.payments.accounting.service.accountinghandlers;

import com.payments.accounting.enums.AccountingType;
import com.payments.accounting.service.AccountingHandler;

/**
 * @author Ankit Thakwani
 * @version $Id: PrepareCreditHandler.java, v 0.1 2019-10-23 6:00 PM Ankit Thakwani Exp $$
 */
public class PrepareCreditHandler implements AccountingHandler {

    @Override
    public AccountingType getAccountingType(String txnType) {
        return AccountingType.PREPARE_CREDIT;
    }

}