package com.commerce.pharmacy.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Double price;
	private String country;
	private String description;


	@ManyToMany(mappedBy = "products",fetch = FetchType.EAGER)
	@JsonIgnoreProperties(value = "products")
	private Set<User> users=new HashSet<>();


	// create
	public Product(String name, Double price, String country, String description) {
		this.name = name;
		this.price = price;
		this.country = country;
		this.description = description;
	}

	// update
	public Product(Integer id, String name, Double price, String country, String description) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.country = country;
		this.description = description;
	}

	public Product() {
	}

	public Integer getId() {
		return id;
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

	public Set<User> getUsers() {
		return users;
	}
}
