package com.example.demo.model;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class PurchaseOrderItem {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY,optional=false)
    @JoinColumn(name = "purchaseOrder_id",nullable=false)
	@OnDelete(action= OnDeleteAction.CASCADE)
	@JsonIgnore
	private PurchaseOrder order;
	
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
	
	public void setOrder(PurchaseOrder order) {
		this.order = order;
	}
	public PurchaseOrder getOrder() {
		return order;
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
