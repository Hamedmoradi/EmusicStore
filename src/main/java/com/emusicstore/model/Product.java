package com.emusicstore.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="product")
public class Product implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productId;
	private String productName;
	private String productCategory;
	private String productDescription;
	private double productPrice;
	private String productCondition;
	private String productStatus;
	private int unitInStock;
	private String productManufacturer;

	
public String getProductName() {
	return productName;
}

public Long getProductId() {
	return productId;
}

public void setProductId(Long productId) {
	this.productId = productId;
}

public void setProductName(String productName) {
	this.productName = productName;
}

public String getProductCategory() {
	return productCategory;
}

public void setProductCategory(String productCategory) {
	this.productCategory = productCategory;
}

public String getProductDescription() {
	return productDescription;
}

public void setProductDescription(String productDescription) {
	this.productDescription = productDescription;
}

public double getProductPrice() {
	return productPrice;
}

public void setProductPrice(double productPrice) {
	this.productPrice = productPrice;
}

public String getProductCondition() {
	return productCondition;
}

public void setProductCondition(String productCondition) {
	this.productCondition = productCondition;
}

public String getProductStatus() {
	return productStatus;
}

public void setProductStatus(String productStatus) {
	this.productStatus = productStatus;
}

public int getUnitInStock() {
	return unitInStock;
}

public void setUnitInStock(int unitInStock) {
	this.unitInStock = unitInStock;
}

public String getProductManufacturer() {
	return productManufacturer;
}

public void setProductManufacturer(String productManufacturer) {
	this.productManufacturer = productManufacturer;
}
}
