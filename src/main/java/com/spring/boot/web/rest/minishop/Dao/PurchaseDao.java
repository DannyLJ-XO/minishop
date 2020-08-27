package com.spring.boot.web.rest.minishop.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.boot.web.rest.minishop.model.Purchase;

@Repository
public class PurchaseDao {
	
	@Autowired
	JdbcTemplate jdbc;
	
	public int purchaseProd(Purchase purchase) {
		String purchaseQuery = "insert into purchase(product_code,username,qty) " + "values(?,?,?)";
		try {
			int counter = jdbc.update(purchaseQuery,
					new Object[] { purchase.getProductCode(), purchase.getUserName(), purchase.getQuantity() });

			return counter;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
