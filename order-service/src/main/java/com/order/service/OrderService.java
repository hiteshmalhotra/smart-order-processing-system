package com.order.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;

import com.kafka.model.OrderEvent;
import com.order.model.OrderRequest;

public class OrderService {

	@Autowired
	private KafkaTemplate<String, OrderEvent> kafkaTemplate;
	
	@Async
	public CompletableFuture<String> placeOrder(OrderRequest request){
		// Simulate processing
        try {
            Thread.sleep(1000); // mimic delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        OrderEvent event = new OrderEvent(
                request.orderId(),
                "CREATED",
                "order-service"
        );
        
        kafkaTemplate.send("order-events", event);
        
        return CompletableFuture.completedFuture("Order created: " + request.orderId());
		
	}
}
