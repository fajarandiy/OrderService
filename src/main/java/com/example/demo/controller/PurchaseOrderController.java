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

import com.example.demo.model.PurchaseOrder;
import com.example.demo.model.PurchaseOrderItem;
import com.example.demo.repositories.PurchaseOrderRepository;

import com.example.demo.repositories.PurchaseOrderItemRepository;

@RestController
@RequestMapping("api")
public class PurchaseOrderController {
	
	@Autowired
	private PurchaseOrderRepository repo;
	
	@Autowired
	private PurchaseOrderItemRepository itemRepo;
	
	@PostMapping("/purchaseOrder/create")
	public Long create(@Valid @RequestBody PurchaseOrder obj) {			
		repo.save(obj);
		return obj.getId();
	}

	@PostMapping("/purchaseOrder/{id}/setItems")
	public String setOrderItems(@PathVariable(value="id") Long id,@Valid @RequestBody List<PurchaseOrderItem> orderItems) {	
		Optional<PurchaseOrder> opt=repo.findById(id);
		if(opt.isPresent()) {
			PurchaseOrder order=opt.get();																																																																																																																																																																																																																										
			for (PurchaseOrderItem orderItem : orderItems) {
				orderItem.setOrder(order);
				itemRepo.save(orderItem);
			}
		
			repo.save(order);
			return order.getTxNumber();
		} else return "invalid.order";
	}
	
	/*	
	@PostMapping("/purchaseOrder/{id}/checkOut")
	public String addItem(@PathVariable(value="id") Long id,@Valid @RequestBody List<OrderItem> orderItems) {	
		Optional<Order> opt=repo.findById(id);
		if(opt.isPresent()) {
			Order order=opt.get();
			order.setOrderItems(orderItems);
			repo.save(order);
			return order.getTxNumber();
		} else return "invalid.order";
		
	}*/
	
	@GetMapping("/purchaseOrder/getAll")
	public Iterable<PurchaseOrder> findAll() {			
		return repo.findAll();
	}
	
	@GetMapping("/purchaseOrder/{id}")
	public Optional<PurchaseOrder> findById(@PathVariable(value="id") Long id) {			
		return repo.findById(id);
	}
	
	@PostMapping("/purchaseOrder/delete/{id}")
	public Boolean delete(@PathVariable(value="id") Long id) {
		repo.deleteById(id);
		return true;
	}
	
	/*
	@GetMapping("/purchaseOrder/email/{email}")
	public Iterable<Order> findByEmail(@PathVariable(value="email") String email) {			
		return repo.findByEmail2(email);
	}
	@GetMapping("/purchaseOrder/address/{address}")
	public Iterable<Order> findByAddress(@PathVariable(value="address") String address) {			
		return repo.findByAddress(address);
	}
	
	@GetMapping("/purchaseOrder/all/{param}")
	public Iterable<Order> findByAddressOrEmail(@PathVariable(value="param") String param) {			
		return repo.findByAddressOrEmail(param);
	}
	
	@PostMapping("/purchaseOrder/all")
	public Iterable<Order> findByAddressAndEmail(@Valid @RequestBody Map dataMap) {			
		return repo.findByAddressAndEmail((String)dataMap.get("email"),(String) dataMap.get("address"));
	}
	*/
	
	public static void main(String[] args) {
		
	}
}
