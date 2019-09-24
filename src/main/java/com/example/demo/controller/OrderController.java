package com.example.demo.controller;

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
import com.example.demo.repositories.OrderRepository;

@RestController
@RequestMapping("api")
public class OrderController {
	
	@Autowired
	private OrderRepository repo;
	
	@PostMapping("/order/create")
	public String create(@Valid @RequestBody Order obj) {			
		repo.save(obj);
		
		return "OK";
	}

	@GetMapping("/order/getAll")
	public Iterable<Order> findAll() {			
		return repo.findAll();
	}
	
	@GetMapping("/order/{id}")
	public Optional<Order> findById(@PathVariable(value="id") Integer custId) {			
		return repo.findById(custId);
	}
	
	@PostMapping("/order/delete/{id}")
	public Boolean delete(@PathVariable(value="id") Integer custId) {
		repo.deleteById(custId);
		return true;
	}
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
}
