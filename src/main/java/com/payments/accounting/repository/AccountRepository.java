package com.payments.accounting.repository;

import com.payments.accounting.model.Account;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Ankit Thakwani
 * @version $Id: AccountRepository.java, v 0.1 2019-10-30 5:33 PM Ankit Thakwani Exp $$
 */
public interface AccountRepository extends CrudRepository<Account, Long> {

    Account findAccountByOwnerId(String ownerId);
}