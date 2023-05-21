package com.commerce.pharmacy.dto;

import com.commerce.pharmacy.model.User;

import java.util.List;

public class ProductDto {
	
	private String name;
	private Double price;
	private String country;
	private String description;
	private List<UserDto> userDtos;
	
	
	
	public ProductDto(String name, Double price, String country, String description,List<UserDto> userDtos) {
		this.name = name;
		this.price = price;
		this.country = country;
		this.description = description;
		this.userDtos=userDtos;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public String getCountry() {
		return country;
	}

	public String getDescription() {
		return description;
	}

}
