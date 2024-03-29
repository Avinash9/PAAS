package com.payments.accounting.exception;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Ankit Thakwani
 * @version $Id: AccountingException.java, v 0.1 2019-10-31 1:09 PM Ankit Thakwani Exp $$
 */

@Getter
@RequiredArgsConstructor
public class AccountingException extends RuntimeException{

    @NotBlank
    private final String code;

}