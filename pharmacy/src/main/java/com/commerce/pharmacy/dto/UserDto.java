package com.commerce.pharmacy.dto;

import com.commerce.pharmacy.model.Orders;
import com.commerce.pharmacy.model.Product;

import java.util.List;

public class UserDto {

	private String email;
	private String username;
	private String surname;
	private Integer age;
	private Boolean isActive;
	private String password;
	private List<ProductDto> productDtos;


	public UserDto(String email, String username, String surname, Integer age,String password,List<ProductDto> productDtos) {
		this.email = email;
		this.username = username;
		this.surname = surname;
		this.age = age;
		this.password=password;
		this.productDtos=productDtos;

	}

	public String getEmail() {
		return email;
	}

	public String getUsername() {
		return username;
	}

	public String getSurname() {
		return surname;
	}

	public Integer getAge() {
		return age;
	}

	public Boolean getIsActive() {
		return isActive;
	}



}
