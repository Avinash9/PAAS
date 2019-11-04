package com.payments.accounting.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Ankit Thakwani
 * @version $Id: ErrorResponse.java, v 0.1 2019-10-09 4:37 PM Ankit Thakwani Exp $$
 */

@Data
@AllArgsConstructor
public class ErrorResponse {

    private String statusCode;

    private String message;

}