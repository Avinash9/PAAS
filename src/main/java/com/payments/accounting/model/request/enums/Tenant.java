package com.payments.accounting.model.request.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Ankit Thakwani
 * @version $Id: Tenant.java, v 0.1 2019-10-30 3:51 PM Ankit Thakwani Exp $$
 */

@AllArgsConstructor
@Getter
public enum Tenant {

    ONE97("ONE97", "O97"),
    PAYTM_BANK("PAYTM_BANK","PB"),
    PAYTM_PAYOUT("PAYTM_PAYOUT", "PP");

    private String name;
    private String code;
    
}