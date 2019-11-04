package com.payments.accounting.service.impl;

import com.payments.accounting.model.User;
import com.payments.accounting.repository.UserRepository;
import com.payments.accounting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author Ankit Thakwani
 * @version $Id: UserServiceImpl.java, v 0.1 2019-10-14 10:55 AM Ankit Thakwani Exp $$
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
