package com.commerce.pharmacy.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
public class Authorities {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String username;
	private String authority;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
//
//	public Integer getUser_id() {
//		return user_id;
//	}
//
//	public void setUser_id(Integer user_id) {
//		this.user_id = user_id;
//	}
	
	
}
