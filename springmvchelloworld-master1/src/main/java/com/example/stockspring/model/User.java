package com.example.stockspring.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
		@Id
		private int id;
		
		
		private String username; 
		private String password;
		private String usertype; 
		private String email; 
		private long mobilenumber; 
		private int confirmed;
		@Override
		public String toString() {
			return "User [id=" + id + ", username=" + username + ", password=" + password + ", usertype=" + usertype
					+ ", email=" + email + ", mobilenumber=" + mobilenumber + ", confirmed=" + confirmed + "]";
		}
		public User() {
			super();
		}
		public User(int id, String username, String password, String usertype, String email, long mobilenumber,
				int confirmed) {
			super();
			this.id = id;
			this.username = username;
			this.password = password;
			this.usertype = usertype;
			this.email = email;
			this.mobilenumber = mobilenumber;
			this.confirmed = confirmed;
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getUsertype() {
			return usertype;
		}
		public void setUsertype(String usertype) {
			this.usertype = usertype;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public long getMobilenumber() {
			return mobilenumber;
		}
		public void setMobilenumber(long mobilenumber) {
			this.mobilenumber = mobilenumber;
		}
		public int getConfirmed() {
			return confirmed;
		}
		public void setConfirmed(int confirmed) {
			this.confirmed = confirmed;
		}
		
	}


