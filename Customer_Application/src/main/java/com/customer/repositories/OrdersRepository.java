package com.customer.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.customer.resource.Orders;

public interface OrdersRepository extends MongoRepository<Orders, String> {

	List<Orders> findByCustomerId(ObjectId objectId);

}