package com.workintech.bankAuth.dao;

import com.workintech.bankAuth.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDao extends JpaRepository<Account, Integer> {
}
