package com.commerce.pharmacy.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.commerce.pharmacy.dto.ProductDto;
import com.commerce.pharmacy.model.Product;

@Component
public class ProductDtoConverter {

	@Autowired
	private UserDtoConverter userDtoConverter;


	public ProductDto convert(Product from) {

		return new ProductDto(from.getName(), from.getPrice(), from.getCountry(), from.getDescription(),
				userDtoConverter.convert(new ArrayList<>(from.getUsers())));
	}

	public List<ProductDto> convert(List<Product> fromlist) {

		return fromlist.stream().map(this::convert).collect(Collectors.toList());

	}

}
