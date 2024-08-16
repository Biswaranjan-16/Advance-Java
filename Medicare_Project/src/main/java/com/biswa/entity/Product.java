package com.biswa.entity;

public class Product {
private int product_id;
private String date;
private String product_name;
private String custom_url;
private String product_img;
private String product_price;
private String product_discount;
private int cid;
private String cname;
private int mid;
private String mname;
private String keyword;
private String availability;
private String expire_date;
private String stock;


public int getProduct_id() {
	return product_id;
}
public void setProduct_id(int product_id) {
	this.product_id = product_id;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getProduct_name() {
	return product_name;
}
public void setProduct_name(String product_name) {
	this.product_name = product_name;
}
public String getCustom_url() {
	return custom_url;
}
public void setCustom_url(String custom_url) {
	this.custom_url = custom_url;
}
public String getProduct_img() {
	return product_img;
}
public void setProduct_img(String product_img) {
	this.product_img = product_img;
}
public String getProduct_price() {
	return product_price;
}
public void setProduct_price(String product_price) {
	this.product_price = product_price;
}
public String getProduct_discount() {
	return product_discount;
}
public void setProduct_discount(String product_discount) {
	this.product_discount = product_discount;
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public int getMid() {
	return mid;
}
public void setMid(int mid) {
	this.mid = mid;
}
public String getMname() {
	return mname;
}
public void setMname(String mname) {
	this.mname = mname;
}
public String getKeyword() {
	return keyword;
}
public void setKeyword(String keyword) {
	this.keyword = keyword;
}
public String getAvailability() {
	return availability;
}
public void setAvailability(String availability) {
	this.availability = availability;
}
public String getExpire_date() {
	return expire_date;
}
public void setExpire_date(String expire_date) {
	this.expire_date = expire_date;
}
public String getStock() {
	return stock;
}
public void setStock(String stock) {
	this.stock = stock;
}
@Override
public String toString() {
	return "Product [product_id=" + product_id + ", date=" + date + ", product_name=" + product_name + ", custom_url="
			+ custom_url + ", product_img=" + product_img + ", product_price=" + product_price + ", product_discount="
			+ product_discount + ", cid=" + cid + ", cname=" + cname + ", mid=" + mid + ", mname=" + mname
			+ ", keyword=" + keyword + ", availability=" + availability + ", expire_date=" + expire_date + ", stock="
			+ stock + "]";
}



}
  