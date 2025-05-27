package com.payment.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.kafka.model.OrderEvent;

@Component
public class PaymentConsumer {
	
	@KafkaListener(topics = "order-events", groupId = "payment")
	public void consume(OrderEvent orderEvent) {
		
	}

}
