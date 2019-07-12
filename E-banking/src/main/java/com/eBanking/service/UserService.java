package com.eBanking.service;

import com.eBanking.entity.User;

public interface UserService {

	User findByUsername(String username);
	boolean checkUserExists(String username,String email);
	boolean checkUsernameExists(String username);
	boolean checkEmailExists(String email);
	void save(User user);
	
}
