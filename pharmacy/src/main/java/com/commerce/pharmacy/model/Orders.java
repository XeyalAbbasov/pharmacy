package com.commerce.pharmacy.model;

import javax.persistence.*;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Entity
@Component
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDateTime orderDate;
	private Integer user_id;
	private Integer product_id;

	public Orders() {
	}

	public Orders(Integer user_id, Integer product_id) {
		this(user_id, product_id, LocalDateTime.now());
	}

	public Orders(Integer user_id, Integer product_id, LocalDateTime orderDate) {
		this.user_id = user_id;
		this.product_id = product_id;
		this.orderDate = orderDate;
	}

	public Integer getId() {
		return id;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

}
