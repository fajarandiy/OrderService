package com.example.demo.model;

import javax.persistence.*;


@Entity
public class OrderItem {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	long orderId;
	
	long productId;
	long quantity;
	double price;
	double subTotal;
	
	public void setId(long id) {
		this.id = id;
	}
	public long getId() {
		return id;
	}
	
	
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public long getProductId() {
		return productId;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPrice() {
		return price;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	public double getSubTotal() {
		return subTotal;
	}

}
