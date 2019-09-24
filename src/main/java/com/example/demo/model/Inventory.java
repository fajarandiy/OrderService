package com.example.demo.model;

import java.util.List;

public class Inventory {
	String name;
	String address;
	List<InventoryItem> stocks;
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	public void stocks(List<InventoryItem> stocks) {
		this.stocks = stocks;
	}
	public List<InventoryItem> getStocks() {
		return stocks;
	}

}
