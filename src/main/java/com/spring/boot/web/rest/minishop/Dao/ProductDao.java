package com.spring.boot.web.rest.minishop.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.boot.web.rest.minishop.model.Product;

@Repository
public class ProductDao {
	@Autowired
	JdbcTemplate jdbc;

	public int add(Product product) {
		String sql = "insert into product(code, title,description,category, price, init_qty ,current_qty) "
				+ "values(?,?,?,?,?,?,?)";

		try {
			int counter = jdbc.update(sql,
					new Object[] { product.getCode(), product.getTitle(), product.getDescription(),
							product.getCategory(), product.getPrice(), product.getIntialQuantity(),
							product.getCurrentQuantity() });

			return counter;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public boolean doesProductExist(Product product) {
		String check = "Select * from product where code=?";
		List<Product> listOfProd = new ArrayList<Product>();
		try {
			 listOfProd = jdbc.query(check, new Object[] { product.getCode() }, new RowMapper<Product>() {

				@Override
				public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
					Product product = new Product();
					product.setId(rs.getInt("id"));
					product.setCode(rs.getString("code"));
					product.setTitle(rs.getString("title"));
					product.setDescription(rs.getString("description"));
					product.setCategory(rs.getString("category"));
					product.setPrice(rs.getFloat("price"));
					product.setIntialQuantity(rs.getInt("intialQuantity"));
					product.setCurrentQuantity(rs.getInt("currentQuantity"));

					return product;
				}

			});
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (listOfProd.size() == 1) {
			return true;
		}
		return false;
	}
	
	public boolean doesProductExistByCode(String code) {
		String check = "Select * from product where code=?";
		List<Product> listOfProd = new ArrayList<Product>();

		try {
			listOfProd = jdbc.query(check, new Object[] {code }, new RowMapper<Product>() {

				@Override
				public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
					Product product = new Product();
					product.setId(rs.getInt("id"));
					product.setCode(rs.getString("code"));
					product.setTitle(rs.getString("title"));
					product.setDescription(rs.getString("description"));
					product.setCategory(rs.getString("category"));
					product.setPrice(rs.getFloat("price"));
					product.setIntialQuantity(rs.getInt("init_qty"));
					product.setCurrentQuantity(rs.getInt("current_qty"));

					return product;
				}

			});
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (listOfProd.size() == 1) {
			return true;
		}
		return false;
	}

	public List<Product> getProductsByCategory(String category) {
		String check = "Select * from product where category=?";
		List<Product> listOfProd = new ArrayList<Product>();

		try {
			listOfProd = jdbc.query(check, new Object[] {category }, new RowMapper<Product>() {

				@Override
				public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
					Product product = new Product();
					product.setId(rs.getInt("id"));
					product.setCode(rs.getString("code"));
					product.setTitle(rs.getString("title"));
					product.setDescription(rs.getString("description"));
					product.setCategory(rs.getString("category"));
					product.setPrice(rs.getFloat("price"));
					product.setIntialQuantity(rs.getInt("init_qty"));
					product.setCurrentQuantity(rs.getInt("current_qty"));

					return product;
				}

			});
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listOfProd;

	}
	public List<Product> getProducts() {
		String check = "Select * from product";
		List<Product> listOfProd = new ArrayList<Product>();

		try {
			listOfProd = jdbc.query(check, new RowMapper<Product>() {

				@Override
				public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
					Product product = new Product();
					product.setId(rs.getInt("id"));
					product.setCode(rs.getString("code"));
					product.setTitle(rs.getString("title"));
					product.setDescription(rs.getString("description"));
					product.setCategory(rs.getString("category"));
					product.setPrice(rs.getFloat("price"));
					product.setIntialQuantity(rs.getInt("init_qty"));
					product.setCurrentQuantity(rs.getInt("current_qty"));

					return product;
				}

			});
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listOfProd;

	}
	
	
	public Product getProductByCode(String code) {
		String check = "Select * from product where code=?";
		List<Product> listOfProd = new ArrayList<Product>();

		try {
			listOfProd = jdbc.query(check, new Object[] {code }, new RowMapper<Product>() {

				@Override
				public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
					Product product = new Product();
					product.setId(rs.getInt("id"));
					product.setCode(rs.getString("code"));
					product.setTitle(rs.getString("title"));
					product.setDescription(rs.getString("description"));
					product.setCategory(rs.getString("category"));
					product.setPrice(rs.getFloat("price"));
					product.setIntialQuantity(rs.getInt("init_qty"));
					product.setCurrentQuantity(rs.getInt("current_qty"));

					return product;
				}

			});
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (listOfProd.size() == 1) {
			return listOfProd.get(0);
		}
		return null;
	}
	public int updateQuantity(Product product) {
		String sql = "update product set current_qty=? where code=?";

		try {
			int counter = jdbc.update(sql,
					new Object[] { product.getCurrentQuantity(), product.getCode()});

			return counter;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
