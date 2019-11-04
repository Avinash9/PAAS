package com.payments.accounting.repository;

import com.payments.accounting.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author Ankit Thakwani
 * @version $Id: AccountRepository.java, v 0.1 2019-10-30 5:33 PM Ankit Thakwani Exp $$
 */
public interface AccountRepository extends CrudRepository<Account, Long> {

    @Query(value = "SELECT /*+ MAX_EXECUTION_TIME(250) */ id, tenant, accountType, accountStatus, ownerId, accountMetadata, version, createTimestamp, updateTimestamp" +
            " FROM account " +
            "WHERE ownerId = :ownerId " +
            "FOR UPDATE ", nativeQuery = true)
    Account findAccountByOwnerIdUsingLock( @Param("ownerId") String ownerId);

    Account findAccountByOwnerId(String ownerId);

}