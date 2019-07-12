package com.eBanking.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eBanking.entity.User;

public interface UserDao extends JpaRepository<User, Long>{

	User findByUsername(String username);
	User findByEmail(String email);
}
