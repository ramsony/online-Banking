package com.eBanking.service;

import java.util.Set;

import com.eBanking.entity.User;
import com.eBanking.entity.security.UserRole;

public interface UserService {

	User findByUsername(String username);
	boolean checkUserExists(String username,String email);
	boolean checkUsernameExists(String username);
	boolean checkEmailExists(String email);
	void save(User user);
	User createUser(User user, Set<UserRole> userRoles);
	
}
