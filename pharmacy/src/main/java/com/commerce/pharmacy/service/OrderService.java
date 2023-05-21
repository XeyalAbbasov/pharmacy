package com.commerce.pharmacy.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.commerce.pharmacy.converter.OrderDtoConverter;
import com.commerce.pharmacy.dto.CreateOrderRequest;
import com.commerce.pharmacy.dto.OrderDto;
import com.commerce.pharmacy.model.Orders;
import com.commerce.pharmacy.model.Product;
import com.commerce.pharmacy.model.User;
import com.commerce.pharmacy.repository.OrderRepository;

@Service
public class OrderService {

	private final OrderRepository orderRepository;
	private final UserService userService;
	private final ProductService productService;
	private final OrderDtoConverter converter;

	public OrderService(OrderRepository orderRepository, UserService userService, ProductService productService,
			OrderDtoConverter converter) {
		this.orderRepository = orderRepository;
		this.userService = userService;
		this.productService = productService;
		this.converter = converter;
	}

	public OrderDto createOrder(final CreateOrderRequest request) {

		User user = userService.findUserById(request.getUser_id());
		Product product = productService.findProductById(request.getProduct_id());

		Orders createOrder = new Orders(
				request.getUser_id(),
				request.getProduct_id());

		return converter.convert(orderRepository.save(createOrder));

	}

}
