package com.spring.boot.web.rest.minishop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.web.rest.minishop.Dao.ProductDao;
import com.spring.boot.web.rest.minishop.Dao.PurchaseDao;
import com.spring.boot.web.rest.minishop.Dao.UserDao;
import com.spring.boot.web.rest.minishop.model.Product;
import com.spring.boot.web.rest.minishop.model.Purchase;
import com.spring.boot.web.rest.minishop.model.User;

@Service
public class PurchaseService {
	
	@Autowired 
	private PurchaseDao purchaseDao;
	
	@Autowired 
	private ProductDao productDao;
	
	@Autowired 
	private UserDao userDao;

	public Purchase productPurchase(Purchase purchase) {
		
		// extract and check if user exists 
		User user = userDao.getUserByUserName(purchase.getUserName());
		System.out.println(user);
		if (user == null) {
			return null;
		}
		// extract and check if product exists
		Product product =  productDao.getProductByCode(purchase.getProductCode());
		System.out.println(product);
		if (product == null) {
			return null;
			
		}
//		If there is not enough quantity of given product, purchase request should be denied. 
		
		/* 1) product.getCurrentQuantity() --> get the current quantity
		 * 2) if product current quantity<purchase quantity --> error 
		 * 3) if not return result
		*/
		if (product.getCurrentQuantity()<purchase.getQuantity()) {
			System.out.println("error in current quantity");
			return null;
		}
		
//		check if user has enough balance 
		if (user.getBalance()< purchase.getQuantity()*product.getPrice()) {
			System.out.println("error in balance");
			return null;
		}
//		Purchase 
		
		int result = purchaseDao.purchaseProd(purchase);
		
		//		update product quantity and user balance 
	
		if (result != 0) {
			
			//update product quantity
			product.setCurrentQuantity(product.getCurrentQuantity()-purchase.getQuantity());
			productDao.updateQuantity(product);
			
			// update user balance 
			user.setBalance(user.getBalance()-purchase.getQuantity()*product.getPrice());
			userDao.updateBalance(user);
			
			return purchase;
		}
		// if purchase not successful 
		return null;
	}	

}
