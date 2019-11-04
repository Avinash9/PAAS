package com.payments.accounting.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Ankit Thakwani
 * @version $Id: AccountType.java, v 0.1 2019-10-30 2:38 PM Ankit Thakwani Exp $$
 */

@Getter
@AllArgsConstructor
public enum AccountType {

    USER("USER", "U"),
    MERCHANT("MERCHANT", "M");

    private String name;
    private String code;

}