package com.payments.accounting.service.accountinghandlers;

import com.payments.accounting.model.request.enums.AccountingType;
import com.payments.accounting.service.AccountingHandler;

/**
 * @author Ankit Thakwani
 * @version $Id: CommitHandler.java, v 0.1 2019-10-23 5:58 PM Ankit Thakwani Exp $$
 */
public class CommitHandler implements AccountingHandler {

    @Override
    public AccountingType getAccountingType(String txnType) {
        return AccountingType.COMMIT;
    }

}