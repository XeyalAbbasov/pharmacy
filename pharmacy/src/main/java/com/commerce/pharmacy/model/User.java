package com.commerce.pharmacy.model;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String email;
	private String username;
	private String surname;
	private Integer age;
	private Boolean isActive;
	private String password;
	private Boolean enabled;//TO DO change it Integer


	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "orders",joinColumns = @JoinColumn(name ="user_id" ),
			inverseJoinColumns = @JoinColumn(name =  "product_id"))
	@JsonIgnoreProperties(value = "users")
	private Set<Product> products=new HashSet<>();


	// create
	public User(String email, String username, String surname, Integer age,String password) {
		this.email = email;
		this.username = username;
		this.surname = surname;
		this.age = age;
		this.password=password;
	}

	// update
	public User(Integer id, String email, String username, String surname, Integer age, Boolean isActive,String password) {
		this.id = id;
		this.email = email;
		this.username = username;
		this.surname = surname;
		this.age = age;
		this.isActive = isActive;
		this.password=password;

	}

	public User() {
	}

	public Integer getId() {
		return id;
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

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getPassword() {
		return password;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}
}
