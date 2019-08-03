package com.eBanking.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eBanking.entity.PrimaryAccount;
import com.eBanking.entity.PrimaryTransaction;
import com.eBanking.entity.SavingsAccount;
import com.eBanking.entity.SavingsTransaction;
import com.eBanking.entity.User;
import com.eBanking.service.AccountService;
import com.eBanking.service.TransactionService;
import com.eBanking.service.UserService;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private TransactionService transactionService;

	@RequestMapping("/primaryAccount")
	public String primaryAccount(Model model,Principal principal) {
		
		List<PrimaryTransaction> primaryTransactionList = transactionService.findPrimaryTransactionList(principal.getName());
		User user = userService.findByUsername(principal.getName());
		PrimaryAccount primaryAccount = user.getPrimaryAccount();
		
		model.addAttribute("primaryAccount", primaryAccount);
		model.addAttribute("primaryTransactionList",primaryTransactionList);
		
		return "primaryAccount";
	}
	
	@RequestMapping("/savingsAccount")
	public String savingsAccount(Model model, Principal principal) {
		List<SavingsTransaction> savingsTransactionList = transactionService.findSavingsTransactionList(principal.getName());

		 User user = userService.findByUsername(principal.getName());
		 SavingsAccount savingsAccount = user.getSavingsAccount();
		 
		 model.addAttribute("savingsAccount", savingsAccount);
		 model.addAttribute("savingsTransactionList",savingsTransactionList);

		
		return "savingsAccount";
	}
	
	@GetMapping("/deposit")
	public String deposit(Model model) {
		model.addAttribute("accountType","");
		model.addAttribute("amount", "");
		
		return "deposit";
	}
	
	@PostMapping("/deposit")
	public String depositPost(
			@ModelAttribute("amount")String amount,
			@ModelAttribute("accountType")String accountType,Principal principal) {
		
			accountService.deposit(accountType,Double.parseDouble(amount),principal);
		
		return "redirect:/userHome";
	}
	
	@GetMapping("/withdraw")
	public String withdraw(Model model) {
		model.addAttribute("accountType","");
		model.addAttribute("amount", "");
		
		return "withdraw";
	}
	
	@PostMapping("/withdraw")
	public String withdrawPost(
			@ModelAttribute("amount")String amount,
			@ModelAttribute("accountType")String accountType,Principal principal) {
		
			accountService.withdraw(accountType,Double.parseDouble(amount),principal);
		
		return "redirect:/userHome";
	}
	
	
}
