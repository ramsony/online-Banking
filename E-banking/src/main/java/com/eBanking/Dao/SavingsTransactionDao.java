package com.eBanking.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eBanking.entity.SavingsTransaction;

public interface SavingsTransactionDao extends JpaRepository<SavingsTransaction, Long> {
	List<SavingsTransaction> findAll();
}
