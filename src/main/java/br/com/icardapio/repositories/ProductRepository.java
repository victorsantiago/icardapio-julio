package br.com.icardapio.repositories;

import java.util.List;

import br.com.icardapio.entity.Category;
import br.com.icardapio.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

	List<Product> findAllByCategory(Category category);

}
