package com.kafka.model;

public class Events {

    // Order events
    public static class OrderCreated {
        public String orderId;
        public String customerId;
        public double totalAmount;
        // constructors, getters, setters
        public OrderCreated(String orderId, String customerId, double totalAmount) {
			super();
			this.orderId = orderId;
			this.customerId = customerId;
			this.totalAmount = totalAmount;
		}
        
		public String getOrderId() {
			return orderId;
		}
		
		public void setOrderId(String orderId) {
			this.orderId = orderId;
		}
		public String getCustomerId() {
			return customerId;
		}
		public void setCustomerId(String customerId) {
			this.customerId = customerId;
		}
		public double getTotalAmount() {
			return totalAmount;
		}
		public void setTotalAmount(double totalAmount) {
			this.totalAmount = totalAmount;
		}
        
    }

    public static class PaymentCompleted {
        public String orderId;
        public boolean success;
        // constructors, getters, setters
		public PaymentCompleted(String orderId, boolean success) {
			super();
			this.orderId = orderId;
			this.success = success;
		}        
        
		public String getOrderId() {
			return orderId;
		}
		public void setOrderId(String orderId) {
			this.orderId = orderId;
		}
		public boolean isSuccess() {
			return success;
		}
		public void setSuccess(boolean success) {
			this.success = success;
		}
        
    }

    public static class InventoryReserved {
        public String orderId;
        public boolean success;
        // constructors, getters, setters
		public String getOrderId() {
			return orderId;
		}
		public void setOrderId(String orderId) {
			this.orderId = orderId;
		}
		public boolean isSuccess() {
			return success;
		}
		public void setSuccess(boolean success) {
			this.success = success;
		}
        
    }
}

