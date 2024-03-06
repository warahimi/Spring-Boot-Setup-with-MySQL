package com.wahid.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/*
 OrderEntity is same as the OrderModel
 its purpose is to connect the OrderModel to the Orders table in the database. 
 */

@Table("ORDERS") // Telling spring which table we are associating this with
// maping a class to a table in the database
public class OrderEntity {
	@Id
	@Column("ID")
	private Long id;
	@Column("ORDER_NUMBER")
	private String orderNo = "";
	@Column("PRODUCT_NAME")
	private String productName = "";
	@Column("PRICE")
	private float price = 0;
	@Column("QUANTITY")
	private int quantity = 0;
	
	
	
	public OrderEntity() {
		super();
	}

	public OrderEntity(Long id, String orderNo, String productName, float price, int quantity) {
		super();
		this.id = id;
		this.orderNo = orderNo;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderModel [id=" + id + ", orderNo=" + orderNo + ", productName=" + productName + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}

}
