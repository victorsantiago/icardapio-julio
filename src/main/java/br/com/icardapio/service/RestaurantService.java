package br.com.icardapio.service;

import br.com.icardapio.entity.Restaurant;

public interface RestaurantService {

	Restaurant getRestaurant();

	Restaurant getRestaurantbyId(Long id);

	Long getIdRestaurantbySubdomain(String sub);

	Long addRestaurant(Restaurant restaurant);
	
	void createMasterData();

}