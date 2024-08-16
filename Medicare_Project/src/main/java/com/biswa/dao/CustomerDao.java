package com.biswa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.biswa.entity.Customer;
import com.biswa.util.DbConnection;

public class CustomerDao {
	
	public int checkpassword(String  password,String email) {
		int status=0;
		try {
			Connection con = DbConnection.getcon();
			String query = "select count(*)   from customer where customer_email=? and customer_password=? ";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, email);
			ps.setString(2,password);
		
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				status=rs.getInt(1);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
		
	}
	//
	
public Customer getDataEmailPassword(String  password,String email) {
	Customer cu = new Customer();
	

	try {
		Connection con = DbConnection.getcon();
		String query = "select customer_id,customer_name from customer where customer_email=? and customer_password=?  ";
		PreparedStatement ps = con.prepareStatement(query);
		
		ps.setString(1, email);
		ps.setString(2,password);
	
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			cu.setCustomer_id(rs.getInt(1));
			cu.setCustomer_name(rs.getString(2));
		}
		
	} catch (Exception e) {
		e.printStackTrace();
    }
	return cu;
}

	public int saveCustomer(Customer c) {
		int status = 0;
		try {
			Connection con = DbConnection.getcon();
			String query = "insert into customer(customer_name,customer_email,customer_address,customer_city,customer_phone,customer_password)values(?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, c.getCustomer_name());
			ps.setString(2, c.getCustomer_email());
			ps.setString(3, c.getCustomer_address());
			ps.setString(4, c.getCustomer_city());
			ps.setString(5, c.getCustomer_phone());
			ps.setString(6, c.getCustomer_password());
			
			status = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public List<Customer> viewcustomer() {
		ArrayList<Customer> cusList = new ArrayList<>();
		try {
			Connection con = DbConnection.getcon();
			String query = "select customer_id,customer_name,customer_email,customer_address,customer_city,customer_phone from customer";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Customer cu = new Customer();
				cu.setCustomer_id(rs.getInt(1));
				cu.setCustomer_name(rs.getString(2));
				cu.setCustomer_email(rs.getString(3));
				cu.setCustomer_address(rs.getString(4));
				cu.setCustomer_city(rs.getString(5));
				cu.setCustomer_phone(rs.getString(6));

				cusList.add(cu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cusList;
	}

	public int deleteCustomer(int customer_id) {
		int status = 0;
		try {
			Connection con = DbConnection.getcon();
			String query = "delete from customer where customer_id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, customer_id);
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public List<Customer> getCustomerById(int customer_id) { // getCustomerById for servlet line 4
		ArrayList<Customer> cusList = new ArrayList<>();
		try {
			Connection con = DbConnection.getcon();
			String query = "select customer_id,customer_name,customer_email,customer_address,customer_city,customer_phone from customer where customer_id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, customer_id); // line 1 name
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Customer cu = new Customer();
				cu.setCustomer_id(rs.getInt(1));
				cu.setCustomer_name(rs.getString(2));
				cu.setCustomer_email(rs.getString(3));
				cu.setCustomer_address(rs.getString(4));
				cu.setCustomer_city(rs.getString(5));
				cu.setCustomer_phone(rs.getString(6));

				cusList.add(cu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cusList;

	}

	public int updateCustomer(Customer c) {
		int status = 0;
		try {
			Connection con = DbConnection.getcon();
			String query = "update customer set customer_name=?,customer_email=?,customer_address=?,customer_city=?,customer_phone=? where customer_id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, c.getCustomer_name());
			ps.setString(2, c.getCustomer_email());
			ps.setString(3, c.getCustomer_address());
			ps.setString(4, c.getCustomer_city());
			ps.setString(5, c.getCustomer_phone());
			ps.setInt(6, c.getCustomer_id());

			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
