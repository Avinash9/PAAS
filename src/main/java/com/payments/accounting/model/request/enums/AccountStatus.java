package com.payments.accounting.model.request.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Ankit Thakwani
 * @version $Id: AccountStatus.java, v 0.1 2019-10-30 2:57 PM Ankit Thakwani Exp $$
 */
@AllArgsConstructor
@Getter
public enum AccountStatus {

    ACTIVE("ACTIVE","AC"),
    INACTIVE("INACTIVE","IA"),
    FROZEN("FROZEN","FR");

    private String code;
    private String name;

}