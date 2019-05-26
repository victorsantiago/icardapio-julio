package br.com.icardapio.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.icardapio.entity.Category;
import br.com.icardapio.entity.Product;
import br.com.icardapio.repositories.ProductRepository;

@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Long add(Product product) {
		return (Long) sessionFactory.getCurrentSession().save(product);
	}

	@Override
	public void delete(Long id) {
		Query query = sessionFactory.getCurrentSession().createQuery("delete from Product a where a.id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

	@Override
	public boolean update(Product product) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("update Product a set a.id=:content where a.id=:id");
		query.setParameter("id", product.getId());
		query.executeUpdate();
		return true;
	}

	@Override
	public Product findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findAllByCategory(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

}
