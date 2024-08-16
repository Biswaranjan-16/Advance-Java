package com.biswa.entity;

public class Cart {
	private int cart_id;
	private int cart_qty;
	private int product_id;
	private int customer_id;	
	private double total_amount;
	private double untprice;
	private String product_name;
	private String product_image;

	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_image() {
		return product_image;
	}
	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public int getCart_qty() {
		return cart_qty;
	}
	public void setCart_qty(int cart_qty) {
		this.cart_qty = cart_qty;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public double getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}
	public double getUntprice() {
		return untprice;
	}
	public void setUntprice(double untprice) {
		this.untprice = untprice;
	}

	@Override
	public String toString() {
		return "Cart [cart_id=" + cart_id + ", cart_qty=" + cart_qty + ", product_id=" + product_id + ", customer_id="
				+ customer_id + ", total_amount=" + total_amount + ", untprice=" + untprice + ", product_name="
				+ product_name + ", product_image=" + product_image + "]";
	}	





}
