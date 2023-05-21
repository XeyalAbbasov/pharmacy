package com.commerce.pharmacy.dto;

public class UpdateUserRequest {

	private String username;
	private String surname;
	private Integer age;
	private Boolean isActive;

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
