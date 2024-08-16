package com.biswa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.biswa.entity.Slideshow;
import com.biswa.util.DbConnection;

public class SlideshowDao {
	public int saveSlideshow(Slideshow s) {
		int status=0;
		try {
			Connection con=DbConnection.getcon();
			String query="insert into slideshow (slide_name,slide_image)values(?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, s.getSlide_name());
			ps.setString(2, s.getSlide_image());
					
			status=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public List<Slideshow> viewSlideshow(){
		ArrayList<Slideshow> slideList=new ArrayList<>();
		try {
			Connection con=DbConnection.getcon();
			String query="select slide_id,slide_name,slide_image from medicare.slideshow";
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Slideshow ss=new Slideshow();
				ss.setSlide_id(rs.getInt(1));
				ss.setSlide_name(rs.getString(2));
				ss.setSlide_image(rs.getString(3));
				slideList.add(ss);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return slideList;
	}
	
	public int deleteSlide(int slide_id) {
		int status=0;
		try {
			Connection con=DbConnection.getcon();
			String query="delete from slideshow where slide_id=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, slide_id);
			status=ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}
		return status;
	}
	
	public List<Slideshow> getSlideById(int slide_id) {  
		ArrayList<Slideshow> sliList=new ArrayList<>();
		try {
			Connection con=DbConnection.getcon();
			String query="select  slide_id,slide_name,slide_image from slideshow where slide_id=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, slide_id); 
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Slideshow ss=new Slideshow();
				
				ss.setSlide_id(rs.getInt(1));
				ss.setSlide_name(rs.getString(2));
				ss.setSlide_image(rs.getString(3));
				
				sliList.add(ss);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sliList;

	}
	
	public int updateslide(Slideshow s) {
		
		int status=0;
		try {
			Connection con=DbConnection.getcon();				
			String query="update slideshow set slide_name=? where slide_id=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, s.getSlide_name());
			ps.setInt(2,s.getSlide_id());
			
			status=ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;	
	}

	
}
