package com.eBanking.service;

import java.security.Principal;

import com.eBanking.entity.PrimaryAccount;
import com.eBanking.entity.SavingsAccount;

public interface AccountService {
	
	PrimaryAccount createPrimaryAccount();
	SavingsAccount createSavingsAccount();
	void deposit(String accountType, double amount, Principal principal);
}
