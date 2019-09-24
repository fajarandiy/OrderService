package com.example.demo.model;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table(name="purchase_order")
@Entity
public class PurchaseOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	String txNumber;
	double totalPrice;
	String status;
	long customerId;
	
//	@OneToMany(mappedBy = "order")
//    private List<PurchaseOrderItem> orderItems = new ArrayList();	

	
	public void setId(long id) {
		this.id = id;
	}
	public long getId() {
		return id;
	}
	public void setTxNumber(String txNumber) {
		this.txNumber = txNumber;
	}
	public String getTxNumber() {
		return txNumber;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public long getCustomerId() {
		return customerId;
	}

/*	public void setOrderItems(List<PurchaseOrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	
	public List<PurchaseOrderItem> getOrderItems() {
		return orderItems;
	}
	*/
}
