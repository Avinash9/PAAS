package com.payments.accounting;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Ankit Thakwani
 * @version $Id: AccountingException.java, v 0.1 2019-10-31 1:09 PM Ankit Thakwani Exp $$
 */

@Data
@RequiredArgsConstructor
public class AccountingException extends RuntimeException{

    @NotBlank
    private final String code;

    private String message;

}