package com.commerce.pharmacy.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.commerce.pharmacy.converter.ProductDtoConverter;
import com.commerce.pharmacy.dto.CreateProductRequest;
import com.commerce.pharmacy.dto.ProductDto;
import com.commerce.pharmacy.dto.UpdateProductRequest;
import com.commerce.pharmacy.exception.ProductNotFoundExeption;
import com.commerce.pharmacy.model.Product;
import com.commerce.pharmacy.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

	private final ProductRepository productRepository;
	private final ProductDtoConverter converter;

	public ProductService(ProductRepository productRepository, ProductDtoConverter converter) {
		this.productRepository = productRepository;
		this.converter = converter;
	}
//	public Optional<Product>  getProductById(Integer id){
//
//		return productRepository.findById(id);
//	}

	public List<Product> getAllProducts(){

		return productRepository.findAll();
	}
	public List<Product> findProductWithSorting(String field) {

		return productRepository.findAll(Sort.by(Sort.Direction.ASC, field));
	}

	public Page<Product> findProductsWithPagination(int offset, int pageSize){

		Page<Product> products= productRepository.findAll(PageRequest.of(offset,pageSize));
		return products;
	}

	public Page<Product> findProductsWithPaginationAndSorting(int offset, int pageSize,String field){

		Page<Product> products= productRepository.findAll(PageRequest.of(offset,pageSize).withSort(Sort.by(field)));
		return products;
	}

	public ProductDto createProduct(final CreateProductRequest request) {

		Product product = new Product(
				request.getName(),
				request.getPrice(), 
				request.getCountry(),
				request.getDescription());

		return converter.convert(productRepository.save(product));
	}

	public ProductDto updateProduct(final UpdateProductRequest request, Integer id) {

		Product product = findProductById(id);

		Product updateProduct = new Product(
				product.getId(), 
				request.getName(), 
				request.getPrice(),
				request.getCountry(), 
				request.getDescription());

		return converter.convert(productRepository.save(updateProduct));
	}

	public void deleteProduct(Integer id) {

		if (doesProductExixt(id)) {

			productRepository.deleteById(id);
		} else

			throw new ProductNotFoundExeption("Product couldn't be found by following id:" + id);
	}

		protected Product findProductById(Integer id) {

		return productRepository.findById(id)
				.orElseThrow(() -> new ProductNotFoundExeption("Product couldn't be found by following id:" + id));
	}

	private boolean doesProductExixt(Integer id) {

		return productRepository.existsById(id);

	}

}
