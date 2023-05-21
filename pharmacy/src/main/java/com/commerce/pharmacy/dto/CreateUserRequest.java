package com.commerce.pharmacy.dto;

public class CreateUserRequest {

	private String email;
	private String username;
	private String surname;
	private Integer age;
	private Boolean isActive;
	private String password;

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

	public String getPassword() {
		return password;
	}

}
