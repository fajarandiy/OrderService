package com.example.demo.model;

public class InventoryItem {
	Product product;
	long quantity;
	public void setProduct(Product product) {
		this.product = product;
	}
	public Product getProduct() {
		return product;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public long getQuantity() {
		return quantity;
	}

}
