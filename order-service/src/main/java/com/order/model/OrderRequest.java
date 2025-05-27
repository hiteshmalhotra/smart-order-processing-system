package com.order.model;

public record OrderRequest(String orderId, String userId, String product, int quantity, double totalAmount) {	
}