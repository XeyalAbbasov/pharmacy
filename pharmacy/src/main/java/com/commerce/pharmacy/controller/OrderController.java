package com.commerce.pharmacy.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.commerce.pharmacy.dto.CreateOrderRequest;
import com.commerce.pharmacy.dto.OrderDto;
import com.commerce.pharmacy.service.OrderService;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {
	
	private final OrderService orderService;
	
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping
	public ResponseEntity<OrderDto> createOrder(@RequestBody CreateOrderRequest request) {
		return ResponseEntity.ok(orderService.createOrder(request));
	}
}
