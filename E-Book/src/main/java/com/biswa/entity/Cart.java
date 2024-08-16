package com.biswa.entity;

public class Cart {
	private int cid;
	private int bid;
	private int userId;
	private String bookName;
	private String author;
	private Double price;
	private Double totalPrice;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int useerId) {
		this.userId = useerId;
	}

	public String getBookname() {
		return bookName;
	}

	public void setBookname(String bookname) {
		this.bookName = bookname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getTotalprice() {
		return totalPrice;
	}

	public void setTotalprice(Double totalprice) {
		this.totalPrice = totalprice;
	}

	@Override
	public String toString() {
		return "Cartr [cid=" + cid + ", bid=" + bid + ", useerId=" + userId + ", bookname=" + bookName + ", author="
				+ author + ", price=" + price + ", totalprice=" + totalPrice + "]";
	}

}
