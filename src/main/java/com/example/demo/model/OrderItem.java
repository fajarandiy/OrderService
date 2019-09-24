package com.example.demo.model;

import javax.persistence.*;


@Entity
public class OrderItem {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	Order order;
	Product product;
	long quantity;
	double price;
	double subTotal;
	
	public void setId(long id) {
		this.id = id;
	}
	public long getId() {
		return id;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	public Order getOrder() {
		return order;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Product getProduct() {
		return product;
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
