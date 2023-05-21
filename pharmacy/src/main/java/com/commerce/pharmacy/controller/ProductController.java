package com.commerce.pharmacy.controller;

import com.commerce.pharmacy.dto.APIResponse;
import com.commerce.pharmacy.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import com.commerce.pharmacy.dto.CreateProductRequest;
import com.commerce.pharmacy.dto.ProductDto;
import com.commerce.pharmacy.dto.UpdateProductRequest;
import com.commerce.pharmacy.service.ProductService;

import java.beans.PropertyEditorSupport;
import java.util.List;


@RestController
@RequestMapping("/v1/product")
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;

	}
	//	@GetMapping("/{id}")
//	public ResponseEntity<Optional<Product>> getProductById(@PathVariable("id") Integer id) {
//
//		return ResponseEntity.ok(productService.getProductById(id));
//	}
	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {

		return ResponseEntity.ok(productService.getAllProducts());
	}

	@GetMapping("/{field}")
	private APIResponse<List<Product>> getProductsWithSort(@PathVariable String field) {
		List<Product> allProducts = productService.findProductWithSorting(field);
		return new APIResponse<>(allProducts.size(), allProducts);
	}

	@GetMapping("/pagination/{offset}/{pageSize}")
	private APIResponse<Page<Product>> getProductsWithPagionation(@PathVariable int offset, @PathVariable int pageSize) {
		Page<Product> productsWithPagination = productService.findProductsWithPagination(offset, pageSize);
		return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);
	}


	@GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
	private APIResponse<Page<Product>> getProductWithPagionationAndSort(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field) {
		Page<Product> productsWithPagination = productService.findProductsWithPaginationAndSorting(offset, pageSize, field);
		return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);
	}

	@PostMapping
	public ResponseEntity<ProductDto> createProduct(@RequestBody CreateProductRequest request) {

		return ResponseEntity.ok(productService.createProduct(request));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProductDto> updateProduct(@RequestBody UpdateProductRequest request, @PathVariable Integer id) {

		return ResponseEntity.ok(productService.updateProduct(request, id));
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
		productService.deleteProduct(id);
		return ResponseEntity.ok().build();

	}
//	@ExceptionHandler
//	public String handleAccessDenaiedExceptions(AccessDeniedException exception){
//
//		return "You don't have an authority to get it";
//	}
	

}
