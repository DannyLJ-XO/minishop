package com.spring.boot.web.rest.minishop.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.sun.istack.internal.NotNull;

public class Product {
	private Integer id;
	
	@NotNull
	private String code;
	
	@NotEmpty(message = "Title is required!")
	private String title;
	
	@NotEmpty(message = "Description is required!")
	private String description;
	
	@NotEmpty(message = "Category cannot be empty!")
	@Size(min = 3 , max = 20, message = "Category shoud be between three and ten characters!")
	private String category;
	
	@Min(value = 0, message = "The minimum price is zero.")
	private Float price;
	

	@Min(value=1, message = "The minimum value for initial quantity is one.")
	private Integer intialQuantity;
	
	@Min(value = 0, message = "The minimum entry not met!")
	private Integer currentQuantity;
	
	public Product() {
	}

	public Product(String code, String title, String description, String category, Float price, Integer intialQuantity,
			Integer currentQuantity) {

		this.code = code;
		this.title = title;
		this.description = description;
		this.category = category;
		this.price = price;
		this.intialQuantity = intialQuantity;
		this.currentQuantity = currentQuantity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getIntialQuantity() {
		return intialQuantity;
	}

	public void setIntialQuantity(Integer intialQuantity) {
		this.intialQuantity = intialQuantity;
	}

	public Integer getCurrentQuantity() {
		return currentQuantity;
	}

	public void setCurrentQuantity(Integer currentQuantity) {
		this.currentQuantity = currentQuantity;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", title=" + title + ", description=" + description
				+ ", category=" + category + ", price=" + price + ", intialQuantity=" + intialQuantity
				+ ", currentQuantity=" + currentQuantity + "]";
	}
	
}
