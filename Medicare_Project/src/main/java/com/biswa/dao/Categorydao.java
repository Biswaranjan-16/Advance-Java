package com.biswa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.biswa.entity.Category;
import com.biswa.util.DbConnection;

public class Categorydao {
		public int saveCategory(String c) {
			int status=0;
			try {
				Connection con=DbConnection.getcon();
				String query="insert into category(cname)values(?)";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1,c);		
				status=ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return status;
		}

		public List<Category> viewcategory(){
			ArrayList<Category> catList=new ArrayList<>();
			try {
				Connection con=DbConnection.getcon();
				String query="select cid,cname from category";
				PreparedStatement ps=con.prepareStatement(query);
				ResultSet rs=ps.executeQuery();
				while (rs.next()) {
					Category cs=new Category();
					cs.setCid(rs.getInt(1));
					cs.setCname(rs.getString(2));
					catList.add(cs);
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return catList;
		}
		public int deleteCategory(int cid) {
			int status=0;
			try {
				Connection con=DbConnection.getcon();
				String query="delete from category where cid=?";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setInt(1, cid);
				status=ps.executeUpdate();
			} catch (Exception e) {
			e.printStackTrace();
			}
			return status;
		}
		
		
		public List<Category> getCategoryById(int cid) {
			ArrayList<Category> catList=new ArrayList<>();
			try {
				Connection con=DbConnection.getcon();
				String query="select cid,cname from category where cid=?";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setInt(1, cid);
				ResultSet rs=ps.executeQuery();
				while (rs.next()) {
					Category cs=new Category();
					cs.setCid(rs.getInt(1));
					cs.setCname(rs.getString(2));
					
					catList.add(cs);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return catList;
		}

		public int updateCategory(Category c) {
			int status=0;
			try {
				Connection con=DbConnection.getcon();				
				String query="update category set cname=? where cid=?";
				PreparedStatement ps=con.prepareStatement(query);
				
				ps.setString(1, c.getCname());
				ps.setInt(2, c.getCid());
				status=ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return status;	
		}

}
