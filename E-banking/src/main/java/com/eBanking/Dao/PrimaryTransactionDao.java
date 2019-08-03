package com.eBanking.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eBanking.entity.PrimaryTransaction;

public interface PrimaryTransactionDao extends JpaRepository<PrimaryTransaction, Long>{
	
	List<PrimaryTransaction> findAll();
}
