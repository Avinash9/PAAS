package com.payments.accounting.controller.api;

import com.payments.accounting.AccountingException;
import com.payments.accounting.controller.request.CreateAccountRequest;
import com.payments.accounting.controller.response.CreateAccountResponse;
import com.payments.accounting.controller.response.Response;
import com.payments.accounting.model.Account;
import com.payments.accounting.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;

/**
 * @author Ankit Thakwani
 * @version $Id: AccountController.java, v 0.1 2019-10-03 1:25 PM Ankit Thakwani Exp $$
 */

@RestController
@RequestMapping(path = "/thakwani/account")
@Slf4j
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping(path = "/create")
    public Response addAccount(@Valid @RequestBody CreateAccountRequest request) {

        CreateAccountResponse payload = null;
        try {
            Account accountCreated = accountService.createAccount(buildAccount(request));
            payload = new CreateAccountResponse(accountCreated.getId());
            return Response.ok().setPayload(payload);
        } catch(Throwable th) {
            if(!(th instanceof AccountingException)) {
               throw new AccountingException("ACN_004");
            }
        }

        return Response.ok().setPayload(payload);

    }

    private Account buildAccount(CreateAccountRequest request) {

        Date now = new Date();

        Account account = new Account();
        account.setTenant(request.getTenant());
        account.setAccountType(request.getAccountType());
        account.setAccountStatus(request.getAccountStatus());
        account.setOwnerId(request.getOwnerId());
        account.setAccountMetadata(request.getAccountMetadata());
        account.setCreateTimestamp(now);
        account.setUpdateTimestamp(now);

        return account;

    }

}