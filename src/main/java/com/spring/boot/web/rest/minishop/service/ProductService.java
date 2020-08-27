package com.spring.boot.web.rest.minishop.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.web.rest.minishop.Dao.ProductDao;
import com.spring.boot.web.rest.minishop.Dao.UserDao;
import com.spring.boot.web.rest.minishop.model.Product;
import com.spring.boot.web.rest.minishop.model.Quantity;
import com.spring.boot.web.rest.minishop.model.User;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDAO;
//	@Autowired
//	private UserDao userDao;

	public Product addProduct(Product product) {
		boolean productExist = productDAO.doesProductExist(product);
		if (!productExist) {
			int result = productDAO.add(product);
			if (result != 0) {
				return product;
			}
		}
		return null;
	}

	public List<Product> getProductByCategory(String category) {
		return productDAO.getProductsByCategory(category);

	}

	public List<Product> getProducts() {
		return productDAO.getProducts();

	}

	public int updateQuantity(Quantity quantity) {

		// todo: check if product exists by code
		if (!productDAO.doesProductExistByCode(quantity.getCode())) {
			return 0;
		}
		// todo: retrieve product

		Product prod = productDAO.getProductByCode(quantity.getCode());
		// todo: update the products quantity

		prod.setCurrentQuantity(prod.getCurrentQuantity() + quantity.getQuantity());
		int status = productDAO.updateQuantity(prod);

		return status;

	}

}
