package com.payments.accounting.model.request.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Ankit Thakwani
 * @version $Id: AccountingType.java, v 0.1 2019-10-22 1:23 PM Ankit Thakwani Exp $$
 */

@Getter
@AllArgsConstructor
public enum AccountingType {

    CREDIT("CREDIT", "CREDIT"),
    DEBIT("DEBIT","DEBIT"),
    PREPARE_CREDIT("PREPARE_CREDIT", "PREPARE_CREDIT"),
    PREPARE_DEBIT("PREPARE_DEBIT", "PREPARE_DEBIT"),
    COMMIT("COMMIT", "COMMIT"),
    ROLLBACK("ROLLBACK", "ROLLBACK");

    String name;
    String code;

}