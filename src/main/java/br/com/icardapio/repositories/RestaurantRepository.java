package br.com.icardapio.repositories;

import br.com.icardapio.entity.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
	
	Restaurant getBySubdomain(String subdomain);
	
}