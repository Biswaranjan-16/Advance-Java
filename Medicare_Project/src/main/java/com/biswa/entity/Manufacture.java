package com.biswa.entity;

public class Manufacture {
	private int mid;
	private String mname;
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
	@Override
	public String toString() {
		return "Manufature [mid=" + mid + ", mname=" + mname + "]";
	}
	
	
	
}
