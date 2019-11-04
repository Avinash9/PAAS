package com.payments.accounting.service.accountinghandlers;

import com.payments.accounting.enums.AccountingType;
import com.payments.accounting.service.AccountingHandler;

/**
 * @author Ankit Thakwani
 * @version $Id: RollbackHandler.java, v 0.1 2019-10-23 6:00 PM Ankit Thakwani Exp $$
 */
public class RollbackHandler implements AccountingHandler {

    @Override
    public AccountingType getAccountingType(String txnType) {
        return AccountingType.ROLLBACK;
    }

}
