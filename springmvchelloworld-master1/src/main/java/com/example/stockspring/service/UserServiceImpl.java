package com.example.stockspring.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stockspring.dao.UserDao;
import com.example.stockspring.model.Login;
import com.example.stockspring.model.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;


	@Override
	public boolean insertUser(User user) throws SQLException {
		 if(userDao.save(user)!=null)
			 return true;
		 else
			 return false;
	}

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		
		return userDao.findByUsername(username);
	}
	
	public User validEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public void updatePassword(User dbUser) {
		userDao.save(dbUser);
		
	}
	
	@Override
	public boolean checkAdminid(String admin) {
		// TODO Auto-generated method stub
		if(userDao.findByUsername(admin)==null)
			return true;
		else
			return false;
	}
	
	@Override
	public User loginUser(Login login) throws SQLException {
		// TODO Auto-generated method stub
		User user=userDao.findByUsername(login.getUsername());
		return user;
	}


}
