package com.emusicstore.dao;

import com.emusicstore.model.Product;

import java.util.List;

public interface ProductDao {

void addProduct(Product product);

void editProduct(Product product);

void deleteProduct(Long product);

Product getProductById(Long id);

List<Product> getAllProducts();
}
