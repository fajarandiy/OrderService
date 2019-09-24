package com.example.demo.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.*;

public interface PurchaseOrderRepository extends CrudRepository<PurchaseOrder,Long> {
	
	
	
/*	
	
	@Query("Select c from Order c where c.email like concat('%',:email,'%')")
	Iterable<Order> findByEmail(@Param("email") String email);
	
	@Query("Select c.fullName, c.address, c.email from Order c where c.email like concat('%',:email,'%')")
	Iterable<Order> findByEmail2(@Param("email") String email);
	
	Iterable<Order> findByAddress(@Param("address") String address);
		
	@Query("Select c from Order c where c.email like concat('%',:email,'%') or c.address like concat('%',:email,'%')")
	Iterable<Order> findByAddressOrEmail(@Param("email") String email);
	 
	@Query("Select c from Order c where c.email like concat('%',:email,'%') and c.address like concat('%',:address,'%')")
	Iterable<Order> findByAddressAndEmail(String email,String address);
	*/
}
