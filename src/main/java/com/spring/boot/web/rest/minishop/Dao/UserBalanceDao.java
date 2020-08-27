package com.spring.boot.web.rest.minishop.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.boot.web.rest.minishop.model.UserBalance;

@Repository
public class UserBalanceDao {
	@Autowired
	JdbcTemplate jdbc;

	public int addBlance(UserBalance userBalance) {

		String sql = "UPDATE users SET balance=? where username=?";

		try {
			int counter = jdbc.update(sql, new Object[] { userBalance.getAmount(), userBalance.getUserName() });

			return counter;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
