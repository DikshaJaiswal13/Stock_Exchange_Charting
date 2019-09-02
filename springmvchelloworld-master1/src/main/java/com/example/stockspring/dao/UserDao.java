package com.example.stockspring.dao;

import java.sql.SQLException;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stockspring.model.Company;
import com.example.stockspring.model.User;

public interface UserDao extends JpaRepository<User, Integer>  {
	 /*public boolean insertUser(User user) throws SQLException;

	public User login(String username, String password);*/
	
	User findByUsername(String username);
	User findByEmail(String email);
	    
}
