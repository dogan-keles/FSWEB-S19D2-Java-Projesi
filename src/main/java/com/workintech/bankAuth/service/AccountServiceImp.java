package com.workintech.bankAuth.service;

import com.workintech.bankAuth.dao.AccountDao;
import com.workintech.bankAuth.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImp implements AccountService {
    private AccountDao accountDao;

    @Autowired
    public AccountServiceImp(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public Account save(Account account) {
        return accountDao.save(account);
    }
}
