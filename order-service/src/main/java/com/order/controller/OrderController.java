package com.order.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.model.Events;
import com.order.model.OrderRequest;
import com.order.service.OrderService;

@RestController
@RequestMapping("/orders/")
public class OrderController {

	@Autowired
	KafkaTemplate<String, Object> template;
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("create")
	public ResponseEntity<String> createOrder(@RequestBody OrderRequest order){
		orderService.placeOrder(order);
		
		//Publish order ceated event
		Events.OrderCreated event = new Events.OrderCreated(order.orderId(), order.userId(),order.totalAmount());
		template.send("order-event", event);
		return ResponseEntity.ok("Order created with id");

	}
}
