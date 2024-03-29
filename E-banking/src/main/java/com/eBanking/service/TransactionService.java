package com.eBanking.service;

import java.util.List;

import com.eBanking.entity.PrimaryTransaction;
import com.eBanking.entity.SavingsTransaction;

public interface TransactionService {
	
	List<PrimaryTransaction> findPrimaryTransactionList(String username);

    List<SavingsTransaction> findSavingsTransactionList(String username);

    void savePrimaryDepositTransaction(PrimaryTransaction primaryTransaction);

    void saveSavingsDepositTransaction(SavingsTransaction savingsTransaction);
}
