package com.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafka.model.Events;
import com.payment.model.Payment;

/**
 * Service class to handle Kafka events for Payment processing.
 */
@Service
public class PaymentService {


    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    /**
     * Listens for OrderCreated events and processes payment.
     * @param event the incoming OrderCreated event.
     */
    @KafkaListener(topics = "order-events", groupId = "payment-group")
    public void handleOrderCreated(Events.OrderCreated event) {
        // Mock payment processing as always successful
        boolean success = true;

        // Save payment info in DB
        Payment payment = new Payment();
        payment.setOrderId(event.orderId);
        payment.setSuccess(success);
        //paymentRepository.save(payment);

        // Create and send PaymentCompleted event
        Events.PaymentCompleted paymentEvent = new Events.PaymentCompleted(event.orderId, success);
        kafkaTemplate.send("payment-events", paymentEvent);
    }
}
