package com.payments.accounting.controller.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.payments.accounting.enums.AccountStatus;
import com.payments.accounting.enums.AccountType;
import com.payments.accounting.enums.Tenant;
import com.payments.accounting.model.AccountMetadata;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Ankit Thakwani
 * @version $Id: CreateAccountRequest.java, v 0.1 2019-10-30 5:36 PM Ankit Thakwani Exp $$
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateAccountRequest {

    @NotNull(message = "tenant cannot be null")
    private Tenant tenant;

    @NotNull(message = "accountType cannot be null")
    private AccountType accountType;

    @NotNull(message = "accountStatus cannot be null")
    private AccountStatus accountStatus;

    @NotEmpty(message = "ownerId cannot be null/empty")
    private String ownerId;

    @Valid
    private AccountMetadata accountMetadata;

}