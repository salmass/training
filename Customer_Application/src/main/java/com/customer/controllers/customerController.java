package com.customer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.repositories.CustomersRepository;
import com.customer.repositories.OrdersRepository;
import com.customer.resource.Orders;
import com.customer.resource.customers;

import com.customer.service.OrderService;

@RestController
public class customerController {
	
	@Autowired
	CustomersRepository customersRepository;
	
	@Autowired
	OrdersRepository ordersRepository;
	
	@Autowired
	OrderService orderService;
	

	@RequestMapping("/hi")
	public String sayHi(){
		return "Hello MongoDB!!!";
	}
	
	@RequestMapping("/customers")
	public List<customers> getAllCustomers(){
		return customersRepository.findAll();
	}
	
	
	@RequestMapping("/customers/{id}")
	public customers getCustomer(@PathVariable String id){
		return customersRepository.findOne(id);
	}
	
	@RequestMapping("/customers/orders")
	public List<Orders> getAllOrders(){
		return ordersRepository.findAll();	
	}
	
	@RequestMapping("/customers/{customerId}/orders")
	public List<Orders> getAllOrdersByCustomer(@PathVariable String customerdetailsId){	
		return orderService.getAllOrders(customerdetailsId);
	}
	
	@RequestMapping("/orders/{id}")
	public Orders getOrder(@PathVariable String id){
		return ordersRepository.findOne(id);
	}

}
