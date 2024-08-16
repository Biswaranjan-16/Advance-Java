package com.biswa.entity;

public class Coupons {
private int coupons_id;
private String coupons_title;
private String coupons_code;
private String coupons_price;
private String coupons_product;
private String coupons_amount;


public int getCoupons_id() {
	return coupons_id;
}
public void setCoupons_id(int coupons_id) {
	this.coupons_id = coupons_id;
}
public String getCoupons_title() {
	return coupons_title;
}
public void setCoupons_title(String coupons_title) {
	this.coupons_title = coupons_title;
}
public String getCoupons_code() {
	return coupons_code;
}
public void setCoupons_code(String coupons_code) {
	this.coupons_code = coupons_code;
}
public String getCoupons_price() {
	return coupons_price;
}
public void setCoupons_price(String coupons_price) {
	this.coupons_price = coupons_price;
}
public String getCoupons_product() {
	return coupons_product;
}
public void setCoupons_product(String coupons_product) {
	this.coupons_product = coupons_product;
}
public String getCoupons_amount() {
	return coupons_amount;
}
public void setCoupons_amount(String coupons_amount) {
	this.coupons_amount = coupons_amount;
}
@Override
public String toString() {
	return "Coupons [coupons_id=" + coupons_id + ", coupons_title=" + coupons_title + ", coupons_code=" + coupons_code
			+ ", coupons_price=" + coupons_price + ", coupons_product=" + coupons_product + ", coupons_amount="
			+ coupons_amount + "]";
}



}
