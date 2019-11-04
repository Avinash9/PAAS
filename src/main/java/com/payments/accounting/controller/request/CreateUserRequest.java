package com.payments.accounting.controller.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Ankit Thakwani
 * @version $Id: CreateUserRequest.java, v 0.1 2019-10-04 1:15 PM Ankit Thakwani Exp $$
 */

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUserRequest {

    @NotEmpty(message = "firstName cannot be null/empty")
    private String firstName;

    @NotEmpty(message = "lastName cannot be null/empty")
    private String lastName;

    @Email(message = "invalid email")
    @NotEmpty(message = "email cannot be null/empty")
    private String email;

    @NotNull(message = "phone number cannot be null")
    @Min(value = 100, message = "phone number must have minimum value = 100")
    private Long phoneNumber;

}