package com.spring.boot.web.rest.minishop.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.boot.web.rest.minishop.model.User;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate jdbc;

	public int createUser(User user) {
		String sql = "insert into users(username,full_name,address, balance) " + "values(?,?,?,?)";
		try {
			int counter = jdbc.update(sql,
					new Object[] { user.getUserName(), user.getFullName(), user.getAddress(), user.getBalance() });

			return counter;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int updateBalance(User user) {
		String sql = "UPDATE users SET balance=? ";

		try {
			int counter = jdbc.update(sql, new Object[] { user.getBalance() });

			return counter;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public User getUserByUserName(String userName) {
		String sql = "SELECT * FROM users WHERE username=?";
		List<User> users = new ArrayList<>();
		try {
			users = jdbc.query(sql, new Object[] { userName }, new RowMapper<User>() {

				@Override
				public User mapRow(ResultSet rs, int rowNum) throws SQLException {
					User user = new User();
					user.setUserName(rs.getString("username"));
					user.setFullName(rs.getString("full_name"));
					user.setAddress(rs.getString("address"));
					user.setBalance(rs.getFloat("balance"));

					return user;
				}

			});
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (users.size() == 1) {
			return users.get(0);
		}

		return null;
	}

}
