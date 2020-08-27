package com.spring.boot.web.rest.minishop.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.web.rest.minishop.Dao.PurchaseDao;
import com.spring.boot.web.rest.minishop.Dao.UserBalanceDao;
import com.spring.boot.web.rest.minishop.Dao.UserDao;
import com.spring.boot.web.rest.minishop.model.User;
import com.spring.boot.web.rest.minishop.model.UserBalance;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserBalanceDao userBalanceDao;
	
	public User createUser(@Valid User user) {
		int result = userDao.createUser(user);
		if (result != 0) {
			return user;
		}
		return null;
	}

	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public User getUserByUserName(String userName) {
		
		return userDao.getUserByUserName(userName);
	}

	public Float addBalance(UserBalance userBalance, User user) {
		System.out.println(user);
		System.out.println(userBalance);
		
		userBalance.setAmount(user.getBalance()+userBalance.getAmount());
		
		float result = userBalanceDao.addBlance(userBalance);
		
		return userBalance.getAmount();
		
	}

}
