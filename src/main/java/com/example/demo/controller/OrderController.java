package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Order;
import com.example.demo.model.OrderItem;
import com.example.demo.repositories.OrderRepository;

import com.example.demo.repositories.OrderItemRepository;

@RestController
@RequestMapping("api")
public class OrderController {
	
	@Autowired
	private OrderRepository repo;
	
	@Autowired
	private OrderItemRepository itemRepo;
	
	@PostMapping("/order/create")
	public Long create(@Valid @RequestBody Order obj) {			
		repo.save(obj);
		return obj.getId();
	}

	@PostMapping("/order/{id}/setItems")
	public String setOrderItems(@PathVariable(value="id") Long id,@Valid @RequestBody List<OrderItem> orderItems) {	
		Optional<Order> opt=repo.findById(id);
		if(opt.isPresent()) {
			Order order=opt.get();																																																																																																																																																																																																																										
			order.setOrderItems(orderItems);
		
			repo.save(order);
			return order.getTxNumber();
		} else return "invalid.order";
	}
	
	/*	
	@PostMapping("/order/{id}/checkOut")
	public String addItem(@PathVariable(value="id") Long id,@Valid @RequestBody List<OrderItem> orderItems) {	
		Optional<Order> opt=repo.findById(id);
		if(opt.isPresent()) {
			Order order=opt.get();
			order.setOrderItems(orderItems);
			repo.save(order);
			return order.getTxNumber();
		} else return "invalid.order";
		
	}*/
	
	@GetMapping("/order/getAll")
	public Iterable<Order> findAll() {			
		return repo.findAll();
	}
	
	@GetMapping("/order/{id}")
	public Optional<Order> findById(@PathVariable(value="id") Long id) {			
		return repo.findById(id);
	}
	
	@PostMapping("/order/delete/{id}")
	public Boolean delete(@PathVariable(value="id") Long id) {
		repo.deleteById(id);
		return true;
	}
	
	/*
	@GetMapping("/order/email/{email}")
	public Iterable<Order> findByEmail(@PathVariable(value="email") String email) {			
		return repo.findByEmail2(email);
	}
	@GetMapping("/order/address/{address}")
	public Iterable<Order> findByAddress(@PathVariable(value="address") String address) {			
		return repo.findByAddress(address);
	}
	
	@GetMapping("/order/all/{param}")
	public Iterable<Order> findByAddressOrEmail(@PathVariable(value="param") String param) {			
		return repo.findByAddressOrEmail(param);
	}
	
	@PostMapping("/order/all")
	public Iterable<Order> findByAddressAndEmail(@Valid @RequestBody Map dataMap) {			
		return repo.findByAddressAndEmail((String)dataMap.get("email"),(String) dataMap.get("address"));
	}
	*/
	
	public static void main(String[] args) {
		
	}
}
