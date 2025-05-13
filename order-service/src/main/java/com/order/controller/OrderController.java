package com.order.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.model.OrderRequest;
import com.order.service.OrderService;

@RestController
@RequestMapping("/orders/")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@PostMapping("create")
	public CompletableFuture<ResponseEntity<String>> createOrder(@RequestBody OrderRequest req){
		return orderService.placeOrder(req).thenApply(ResponseEntity::ok);
	}
}
