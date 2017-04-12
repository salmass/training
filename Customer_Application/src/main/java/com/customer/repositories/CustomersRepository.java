package com.customer.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.customer.resource.customers;

public interface CustomersRepository extends MongoRepository<customers, String> {
	
}
	
	

