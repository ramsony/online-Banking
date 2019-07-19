package com.eBanking.service;

import com.eBanking.entity.PrimaryAccount;
import com.eBanking.entity.SavingsAccount;

public interface AccountService {
	
	PrimaryAccount createPrimaryAccount();
	SavingsAccount createSavingsAccount();
}
