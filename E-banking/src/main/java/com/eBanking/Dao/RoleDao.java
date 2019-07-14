package com.eBanking.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eBanking.entity.security.Role;

public interface RoleDao extends JpaRepository<Role, Integer>{
	Role findByName(String name);
}
