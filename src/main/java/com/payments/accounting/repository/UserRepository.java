package com.payments.accounting.repository;

import com.payments.accounting.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Ankit Thakwani
 * @version $Id: UserRepository.java, v 0.1 2019-10-03 1:23 PM Ankit Thakwani Exp $$
 */
public interface UserRepository extends CrudRepository<User, Long> {
}