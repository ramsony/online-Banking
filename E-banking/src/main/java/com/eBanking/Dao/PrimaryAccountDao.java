package com.eBanking.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eBanking.entity.PrimaryAccount;

public interface PrimaryAccountDao extends JpaRepository<PrimaryAccount, Long> {
	PrimaryAccount findByAccountNumber(int accountNumber);
}
