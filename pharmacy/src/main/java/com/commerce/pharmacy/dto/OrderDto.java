package com.commerce.pharmacy.dto;


public class OrderDto {
	private Integer user_id;
	private Integer product_id;

	public OrderDto() {
	}

	public OrderDto(Integer user_id, Integer product_id) {
		this.user_id = user_id;
		this.product_id = product_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public Integer getProduct_id() {
		return product_id;
	}
}
