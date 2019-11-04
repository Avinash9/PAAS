package com.payments.accounting.model.request.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Ankit Thakwani
 * @version $Id: KycStatus.java, v 0.1 2019-10-31 2:47 PM Ankit Thakwani Exp $$
 */

@AllArgsConstructor
@Getter
public enum KycStatus {

    FULL_KYC("FK", "FULL_KYC"),
    MIN_KYC("MK", "MIN_KYC"),
    NO_KYC("NK", "NO_KYC");

    private String code;
    private String message;

}