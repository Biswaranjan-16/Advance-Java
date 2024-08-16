package com.biswa.entity;

public class Admin {

	private int admin_id;
	private String admin_name;
	private String admin_email;
	private String admin_password;
	private String admin_con_password;
	private String admin_phone;
	private String admin_image;
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getAdmin_email() {
		return admin_email;
	}
	public void setAdmin_email(String admin_email) {
		this.admin_email = admin_email;
	}
	public String getAdmin_password() {
		return admin_password;
	}
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
	public String getAdmin_con_password() {
		return admin_con_password;
	}
	public void setAdmin_con_password(String admin_con_password) {
		this.admin_con_password = admin_con_password;
	}
	public String getAdmin_phone() {
		return admin_phone;
	}
	public void setAdmin_phone(String admin_phone) {
		this.admin_phone = admin_phone;
	}
	public String getAdmin_image() {
		return admin_image;
	}
	public void setAdmin_image(String admin_image) {
		this.admin_image = admin_image;
	}
	
	
	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", admin_name=" + admin_name + ", admin_email=" + admin_email
				+ ", admin_password=" + admin_password + ", admin_con_password=" + admin_con_password + ", admin_phone="
				+ admin_phone + ", admin_image=" + admin_image + "]";
	}
	
	
	
	
	
	
}
