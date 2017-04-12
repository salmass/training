package com.customer.resource;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="orders")
	public class Orders {
		
		
		@Id
		private String id;
		@DBRef
		private customers customerdetails;
		private String item;
		private String price;
		private String customerId;
		
		public Orders() {
			
		}
		
		
		public Orders(String id, String item, String type, String price, String customerdetailsId, String customerId) {
			super();
			this.id = id;
			this.item = item;
			
			this.price = price;
			this.customerId = customerId;
		}
		
		
		
		public String getItem() {
			return item;
		}
		public void setItem(String item) {
			this.item = item;
		}
		
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}


		public String getId() {
			return id;
		}


		public void setId(String id) {
			this.id = id;
		}


		public String getCustomerId() {
			return customerId;
		}


		public void setCustomerId(String customerId) {
			this.customerId = customerId;
		}


		
		
		
	
	

}
