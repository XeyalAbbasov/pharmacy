package com.commerce.pharmacy.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.commerce.pharmacy.dto.OrderDto;
import com.commerce.pharmacy.model.Orders;

@Component
public class OrderDtoConverter {
	


	public OrderDto convert(Orders from) {

		return new OrderDto(from.getUser_id(),from.getProduct_id());
				
	}

	public List<OrderDto> convert(List<Orders> fromlist) {

		return fromlist.stream().map(this::convert).collect(Collectors.toList());

	}

}
