package com.cdac.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdac.dao.UserDao;
import com.cdac.entity.User;
import com.cdac.exception.UserServiceException;

@Component
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public void register(User user) {
		if(userDao.isUserPresent(user.getAadharno()))
			throw new UserServiceException("User already exists.");
		else 
			userDao.add(user); 
	}
	
	public User login(String username, String password) {
		if(userDao.isUserPresent(username,password)) {
			return userDao.fetch(username,password);
		}else
			throw new UserServiceException("Username/Password is incorrect.");
	}
	
	public List<User> adminLogin(String username, String password) {
		if(userDao.isAdminPresent(username,password)) {
			return userDao.fetchAll();
		}else
			throw new UserServiceException("Username/Password is incorrect.");
	}
	
	public boolean delete(String username) {
	
		if(userDao.isUserPresent2(username)) {
			userDao.remove(username);
			return true;
		}else
			return false;
		
}
	
	public List<User> registeredUsers(){
		return userDao.fetchAll();
	}
	
	public  boolean recharge(String mobno, int amount) {
		if(userDao.isUserPresent3(mobno)) {
			userDao.balupdate(mobno,amount);
		return true;
	}
		else
			return false;
	}
	
	public boolean change(User newuser) {
		
		if(userDao.isUserPresent4(newuser.getAadharno())) {
			userDao.update(newuser);
			return true;
		}else
			return false;
		
}
	
	public  boolean wallet(String mobno, int amount) {
		if(userDao.isWalletPresent(mobno)) {
			userDao.walupdate(mobno,amount);
		return true;
	}
		else
			return false;
	}
	
	public boolean upi(String mobno1, String mobno2, int amount) {
		if(userDao.transfer(mobno1, mobno2, amount)) {
			return true;
		}else
			return false;
	}

}
