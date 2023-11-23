package com.workintech.bankAuth.controller;

import com.workintech.bankAuth.entity.Account;
import com.workintech.bankAuth.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/")
    public List<Account> findAll() {
        return accountService.findAll();
    }

    @PostMapping("/")
    public Account save(@RequestBody Account account) {
        return accountService.save(account);
    }
}
