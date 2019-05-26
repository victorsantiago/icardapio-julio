package br.com.icardapio.repositories;

import java.util.List;

import br.com.icardapio.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	List<Category> getAllCategories();
}
