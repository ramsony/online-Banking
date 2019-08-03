package com.eBanking.service.UserServiceImp;

import java.util.List;

import javax.transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eBanking.Dao.PrimaryTransactionDao;
import com.eBanking.Dao.SavingsTransactionDao;
import com.eBanking.entity.PrimaryTransaction;
import com.eBanking.entity.SavingsTransaction;
import com.eBanking.entity.User;
import com.eBanking.service.TransactionService;
import com.eBanking.service.UserService;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	private UserService userService;
	
	@Autowired
	private PrimaryTransactionDao primaryTransactionDao;
	
	@Autowired
	private SavingsTransactionDao savingsTransactionDao;
	
	public List<PrimaryTransaction> findPrimaryTransactionList(String username){
		User user = userService.findByUsername(username);
		List<PrimaryTransaction> primaryTransactionList = user.getPrimaryAccount().getPrimaryTransactionList();
		
		return primaryTransactionList;	
	}
	
	public List<SavingsTransaction> findSavingsTransactionList(String username){
		User user = userService.findByUsername(username);
		List<SavingsTransaction> savingsTransactionList = user.getSavingsAccount().getSavingsTransactionList();
		
		return savingsTransactionList;	
	}
	
	public void savePrimaryDepositTransaction(PrimaryTransaction primaryTransaction) {
		primaryTransactionDao.save(primaryTransaction);
	}
	
	public void saveSavingsDepositTransaction(SavingsTransaction savingsTransaction) {
		savingsTransactionDao.save(savingsTransaction);
	}
	
}
