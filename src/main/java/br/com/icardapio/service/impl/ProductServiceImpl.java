package br.com.icardapio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import br.com.icardapio.entity.Product;
import br.com.icardapio.repositories.ProductRepository;
import br.com.icardapio.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productsRepository;

	@Override
	@PreAuthorize("hasRole('admin')")
	public void removeProduct(Long categoryId, Long productId) {
		// Category category = categoriesRepository.findOne(categoryId);
		// Product product = productsRepository.findOne(productId);
		// category.getProducts().remove(product);
		// return product;
		Product product = productsRepository.findOne(productId);
		productsRepository.delete(product.getId());
	}

	@Override
	@PreAuthorize("hasRole('admin')")
	public Long addProduct(Product product) {
		return productsRepository.add(product);
	}

}
