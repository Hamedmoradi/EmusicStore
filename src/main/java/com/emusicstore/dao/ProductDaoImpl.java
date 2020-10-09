package com.emusicstore.dao;

import com.emusicstore.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {
@PersistenceContext
private EntityManager entityManager;

public void addProduct(Product product) {
	entityManager.persist(product);
	entityManager.flush();
}

public void deleteProduct(Product product) {
	product = entityManager.merge(product);
	entityManager.remove(product);
}

public Product getProductById(Long id) {
	return entityManager.find(Product.class, id);
	
}

public List<Product> getAllProducts() {
	Query query = entityManager.createQuery("from Product ");
	return (List<Product>) query.getResultList();
}
}
