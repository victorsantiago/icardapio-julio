package br.com.icardapio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.icardapio.entity.Category;
import br.com.icardapio.entity.Restaurant;
import br.com.icardapio.multitenancy.CurrentTenantResolver;
import br.com.icardapio.repositories.CategoryRepository;
import br.com.icardapio.repositories.ProductRepository;
import br.com.icardapio.repositories.RestaurantRepository;
import br.com.icardapio.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private CurrentTenantResolver<Long> tenantResolver;

	@Autowired
	private RestaurantRepository restaurantsRepository;

	@Autowired
	private CategoryRepository categoriesRepository;

	@Autowired
	private ProductRepository productsRepository;

	public Restaurant getRestaurant() {
		return restaurantsRepository.findOne(tenantResolver.getCurrentTenantId());
	}

	public Restaurant getRestaurantbyId(Long id) {
		Restaurant restaurant = new Restaurant();
		restaurant = restaurantsRepository.findOne(id);
		return restaurant;
	}

	public Long getIdRestaurantbySubdomain(String sub) {
		Restaurant restaurant = new Restaurant();
		restaurant = restaurantsRepository.getBySubdomain(sub);
		return restaurant.getId();
	}

	public List<Category> getAllCategories() {
		List<Category> categories = categoriesRepository.findAll();

		for (Category category : categories) {
			category.setProducts(productsRepository.findAllByCategory(category));
		}

		return categories;
	}

	public void createMasterData() {

		// cria o tenant master
		if (restaurantsRepository.getBySubdomain("default") == null) {
			Restaurant restaurant = new Restaurant();
			restaurant.setName("iCardapio");
			restaurant.setSubdomain("default");
			restaurant.setSlogan("Seu Cardapio na Internet");
			restaurant.setPhone("11 3114-2334");
			restaurant.setAddress("Av Dr Gentil de Moura, 850");
			restaurant.setCity("Sao Paulo");

			restaurantsRepository.add(restaurant);
		}

		// cria algumas categorias
		if (categoriesRepository.findAll().size() <= 0) {
			for (String categoryName : new String[] { "Pizza", "Massas", "Bebidas", "Sobremesas" }) {
				categoriesRepository.add(new Category(categoryName));
			}
		}
	}

	public Long addRestaurant(Restaurant restaurant) {
		return restaurantsRepository.add(restaurant);
	}

}
