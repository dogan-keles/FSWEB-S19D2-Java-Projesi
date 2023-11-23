package com.workintech.bankAuth.service;

import com.workintech.bankAuth.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();
    Account save(Account account);
}
