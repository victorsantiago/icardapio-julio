package br.com.icardapio.service;

import br.com.icardapio.entity.Product;

public interface ProductService {

	Long addProduct(Product product);

	void removeProduct(Long categoryId, Long productId);

}
