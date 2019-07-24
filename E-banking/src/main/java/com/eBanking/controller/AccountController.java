package com.eBanking.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eBanking.entity.PrimaryAccount;
import com.eBanking.entity.SavingsAccount;
import com.eBanking.entity.User;
import com.eBanking.service.UserService;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	UserService userService;

	@RequestMapping("/primaryAccount")
	public String primaryAccount(Model model,Principal principal) {
		User user = userService.findByUsername(principal.getName());
		PrimaryAccount primaryAccount = user.getPrimaryAccount();
		
		model.addAttribute("primaryAccount", primaryAccount);
		
		return "primaryAccount";
	}
	
	@RequestMapping("/savingsAccount")
	public String savingsAccount(Model model, Principal principal) {
		 User user = userService.findByUsername(principal.getName());
		 SavingsAccount savingsAccount = user.getSavingsAccount();
		 
		 model.addAttribute("savingsAccount", savingsAccount);
		
		return "savingsAccount";
	}
}
