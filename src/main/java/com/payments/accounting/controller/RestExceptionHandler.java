package com.payments.accounting.controller;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.payments.accounting.AccountingException;
import com.payments.accounting.controller.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author Ankit Thakwani
 * @version $Id: RestExceptionHandler.java, v 0.1 2019-10-09 4:35 PM Ankit Thakwani Exp $$
 */

@RestControllerAdvice
public class RestExceptionHandler {

    @Autowired
    @Qualifier("exception")
    private Properties exceptionCodeToMessageMap;

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response handleValidationException(MethodArgumentNotValidException ex) {

        String errorCode = "ACN_002";
        Response response = Response.validationException();

        List<String> errorDetails = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(x -> {
            errorDetails.add(x.getDefaultMessage());
        });

        response.addErrorMsgToResponse(errorCode, exceptionCodeToMessageMap.getProperty(errorCode), errorDetails);

        return response;

    }

    @ExceptionHandler({InvalidFormatException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response handleValidationException(InvalidFormatException e) {

        String errorCode = "ACN_003";
        Response response = Response.badRequest();

        response.addErrorMsgToResponse(errorCode, exceptionCodeToMessageMap.getProperty(errorCode), e.getOriginalMessage());

        return response;

    }

    @ExceptionHandler({AccountingException.class})
    @ResponseStatus(HttpStatus.OK)
    public Response handleException(AccountingException ae) {

        Response response = Response.ok();
        response.addErrorMsgToResponse(ae.getCode(), exceptionCodeToMessageMap.getProperty(ae.getCode()));

        return response;

    }

    @ExceptionHandler({RuntimeException.class})
    @ResponseStatus(HttpStatus.OK)
    public Response handleException(RuntimeException ae) {

        String internalServerExceptionCode = "ACN_004";

        Response response = Response.ok();
        response.addErrorMsgToResponse(internalServerExceptionCode, exceptionCodeToMessageMap.getProperty(internalServerExceptionCode));

        return response;

    }


}