package com.payments.accounting.model.response;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

/**
 * @author Ankit Thakwani
 * @version $Id: ErrorDetails.java, v 0.1 2019-10-31 4:33 PM Ankit Thakwani Exp $$
 */

@Data
@Accessors(chain = true)
public class ErrorDetails {

    private Date timestamp;

    private String errorCode;

    private String errorMessage;

    private Object metadata;

}