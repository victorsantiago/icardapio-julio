package br.com.icardapio.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.icardapio.entity.Restaurant;
import br.com.icardapio.repositories.RestaurantRepository;

@Repository
@Transactional
public class RestaurantRepositoryImpl implements RestaurantRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Long add(Restaurant restaurant) {
		return (Long) sessionFactory.getCurrentSession().save(restaurant);
	}

	@Override
	public void delete(Long id) {
		Query query = sessionFactory.getCurrentSession().createQuery("delete from Restaurant a where a.id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

	@Override
	public boolean update(Restaurant restaurant) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("update Restaurant a set a.Restaurant=:content where a.id=:id");
		query.setParameter("id", restaurant.getId());
		query.executeUpdate();
		return true;
	}

	@Override
	public Restaurant findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Restaurant getBySubdomain(String subdomain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Restaurant> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
