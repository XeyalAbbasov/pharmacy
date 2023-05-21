package com.commerce.pharmacy.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.commerce.pharmacy.dto.UserDto;
import com.commerce.pharmacy.model.User;

@Component
public class UserDtoConverter {
	@Autowired
	private ProductDtoConverter productDtoConverter;

	public UserDto convert(User from) {
		
		return new UserDto(from.getEmail(),from.getUsername(),from.getSurname(),from.getAge(),from.getPassword(),

				productDtoConverter.convert(new ArrayList<>(from.getProducts())));
	}
	public List<UserDto> convert(List<User>fromlist){

		return fromlist.stream().map(this::convert).collect(Collectors.toList());
	}

}
