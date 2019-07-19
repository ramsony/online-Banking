package com.eBanking.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eBanking.entity.SavingsAccount;

public interface SavingsAccountDao extends JpaRepository<SavingsAccount, Long> {
	SavingsAccount findByAccountNumber(int accountNumber);
}
