package com.payments.accounting.model.response;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author Ankit Thakwani
 * @version $Id: Response.java, v 0.1 2019-10-31 4:32 PM Ankit Thakwani Exp $$
 */

@Data
@Accessors(chain = true)
public class Response<T> {

    private Status status;
    T payload;
    ErrorDetails errorDetails;

    public enum Status {
        OK, BAD_REQUEST, VALIDATION_EXCEPTION, INTERNAL_SERVER_ERROR, UNAUTHORIZED;
    }

    public static <T> Response<T> badRequest() {
        Response<T> response = new Response<>();
        response.setStatus(Status.BAD_REQUEST);
        return response;
    }

    public static <T> Response<T> ok() {
        Response<T> response = new Response<>();
        response.setStatus(Status.OK);
        return response;
    }

    public static <T> Response<T> unauthorized() {
        Response<T> response = new Response<>();
        response.setStatus(Status.UNAUTHORIZED);
        return response;
    }

    public static <T> Response<T> validationException() {
        Response<T> response = new Response<>();
        response.setStatus(Status.VALIDATION_EXCEPTION);
        return response;
    }

    public static <T> Response<T> internalServerError() {
        Response<T> response = new Response<>();
        response.setStatus(Status.INTERNAL_SERVER_ERROR);
        return response;
    }

    public void addErrorMsgToResponse(String errorCode, String errorMessage, Object errorMessageDetails) {

        ErrorDetails errorDetails = new ErrorDetails()
                .setErrorCode(errorCode)
                .setErrorMessage(errorMessage)
                .setMetadata(errorMessageDetails)
                .setTimestamp(new Date());

        this.setErrorDetails(errorDetails);

    }

    public void addErrorMsgToResponse(String errorCode, String errorMessage) {

        ErrorDetails errorDetails = new ErrorDetails()
                .setErrorCode(errorCode)
                .setErrorMessage(errorMessage)
                .setTimestamp(new Date());

        this.setErrorDetails(errorDetails);

    }

}