package com.emusicstore.dao;

import com.emusicstore.model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
	private List<Product> productList;

public List<Product> getProductList() {
	Product product1=new Product();
	product1.setProductId(1L);
	product1.setProductName("tar1");
	product1.setProductDescription("asd");
	product1.setProductName("instrument");
	product1.setProductCategory("instrument");
	product1.setProductDescription("made by yahya");
	product1.setProductCondition("new");
	product1.setProductPrice(10000);
	product1.setProductStatus("Active");
	product1.setProductManufacturer("yahya");
	product1.setUnitInStock(11);
	
	Product product2=new Product();
	product2.setProductId(2L);
	product2.setProductName("tar2");
	product2.setProductDescription("asd");
	product2.setProductName("instrument");
	product2.setProductCategory("instrument");
	product2.setProductDescription("made by yahya");
	product2.setProductCondition("new");
	product2.setProductPrice(10000);
	product2.setProductStatus("Active");
	product2.setProductManufacturer("yahya");
	product2.setUnitInStock(11);
	
	Product product3=new Product();
	product3.setProductId(3L);
	product3.setProductName("tar3");
	product3.setProductDescription("asd");
	product3.setProductName("instrument");
	product3.setProductCategory("instrument");
	product3.setProductDescription("made by yahya");
	product3.setProductCondition("new");
	product3.setProductPrice(10000);
	product3.setProductStatus("Active");
	product3.setProductManufacturer("yahya");
	product3.setUnitInStock(11);
	productList=new ArrayList<Product>();
	productList.add(product1);
	productList.add(product2);
	productList.add(product3);
	return productList;
}

public Product getProductById(Long productId) throws IOException {
	for (Product product:getProductList()){
		if (product.getProductId()==productId){
			return product;
		}
	}
	throw new IOException("no product found");
}
}
