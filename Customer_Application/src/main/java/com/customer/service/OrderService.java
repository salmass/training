package com.customer.service;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.customer.repositories.OrdersRepository;
import com.customer.resource.Orders;




@Service
public class OrderService {

	@Autowired
	OrdersRepository ordersRepository;
	@Autowired
	private MongoTemplate mongotemplate;
	
	public List<Orders> getAllOrders(String customerId){
		String ty = "clothing";
		Criteria criteria = Criteria.where("customerdetailsId").is(new ObjectId(customerId));
		return mongotemplate.find(Query.query(criteria),Orders.class);
	
}
}
