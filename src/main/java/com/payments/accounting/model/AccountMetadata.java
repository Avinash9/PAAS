package com.payments.accounting.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.payments.accounting.enums.KycStatus;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author Ankit Thakwani
 * @version $Id: AccountMetadata.java, v 0.1 2019-10-31 2:46 PM Ankit Thakwani Exp $$
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountMetadata {

    @NotNull(message = "AccountMetadata.kycStatus cannot be null")
    private KycStatus kycStatus;

    private String firstName;

    private String lastName;

    private long phoneNumber;

    private String email;

}