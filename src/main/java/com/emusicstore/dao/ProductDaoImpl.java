package com.emusicstore.dao;

import com.emusicstore.model.Product;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
//	Session session = sessionFactory.getCurrentSession();
//	session.saveOrUpdate(product);
//	session.flush();
	return;
}

public void deleteProduct(Long id) {
//	Session session = sessionFactory.getCurrentSession();
//	session.delete(getProductById(id));
//	session.flush();
	return;
	
}

public Product getProductById(Long id) {
//	Session session = sessionFactory.getCurrentSession();
////	Product product = (Product) session.get(Product.class, id);
////	session.flush();
////	return product;
	return null;
}

public List<Product> getAllProducts() {
	try {
	
		//TODO handle null pointer Exception by change session.createQuery
		Query query=entityManager.createQuery("from Product ");
		return (List<Product>)query.getResultList();
	} catch (HibernateException e) {
		e.printStackTrace();
	} catch (NullPointerException e) {
		return null;
	}
	return null;
}
}
