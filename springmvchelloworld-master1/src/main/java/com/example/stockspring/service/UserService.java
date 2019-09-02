package com.example.stockspring.service;

import java.sql.SQLException;

import com.example.stockspring.model.Login;
import com.example.stockspring.model.User;

public interface UserService {
	  public boolean insertUser(User user) throws SQLException;
	  
	public User login(String username, String password);
	public User validEmail(String email);

	public void updatePassword(User dbUser);
	public boolean checkAdminid(String admin);
	public User loginUser(Login login)throws SQLException;
}
