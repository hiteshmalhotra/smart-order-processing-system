package com.kafka.model;

public class OrderEvent {
	private String orderId;
    private String status;
    private String source;
    
	public OrderEvent(String orderId, String status, String source) {
		super();
		this.orderId = orderId;
		this.status = status;
		this.source = source;
	}

}
