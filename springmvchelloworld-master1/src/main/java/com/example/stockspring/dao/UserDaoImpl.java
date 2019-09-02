/*package com.example.stockspring.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import org.springframework.stereotype.Repository;

import com.example.stockspring.model.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Override
	public boolean insertUser(User user) throws SQLException {
		boolean i=true; 
		  try {
			  Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/diksha","root","pass@word1");
			  PreparedStatement ps=conn.prepareStatement("insert into user(id, username, password, usertype, email, mobilenumber, confirmed) values(?,?,?,?,?,?,?)");
			  Random r=new Random();
			  int no=r.nextInt(9000)+1000;
			  ps.setInt(1, no);
			  ps.setString(2,user.getUsername());
			  ps.setString(3,user.getPassword());
		  ps.setString(4,user.getUsertype());
		  ps.setString(5,user.getEmail());
		  ps.setLong(6,user.getMobilenumber());
		  ps.setInt(7,user.getConfirmed());
			
		  
		  i=ps.execute(); 
		  System.out.println(i); //returns false 
		  ps.close();
		  conn.close();
		  } 
		  catch(SQLException e) {
		   e.printStackTrace();
		    } 
		  return false;

	}
	
	
	@Override
	public User login(String username, String password) {
		User u=new User();
		try {
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/diksha","root","pass@word1");
		PreparedStatement ps=conn.prepareStatement("select * from user where username=? and password=?");
		ps.setString(1, username);
		ps.setString(2,password);
		ResultSet rs=ps.executeQuery();
		System.out.println("Value of:"+rs);
		while(rs.next()) {
			//User u=null;
			u.setId(rs.getInt(1));
			u.setUsername(rs.getString(2));
			u.setPassword(rs.getString(3));
			u.setUsertype(rs.getString(4));
			u.setEmail(rs.getString(5));
			u.setMobilenumber(rs.getLong(6));
			u.setConfirmed(rs.getInt(7));
			System.out.println("========================inside dao==================");
			System.out.println(u);
			return u;
		}
		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

}*/
