package com.Biswa.entity;

public class Faculty {

	private int fid;
	private String fname;
	private String femail;
	private String fpass;
	private String fadd;

	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFemail() {
		return femail;
	}
	public void setFemail(String femail) {
		this.femail = femail;
	}
	public String getFpass() {
		return fpass;
	}
	public void setFpass(String fpass) {
		this.fpass = fpass;
	}
	public String getFadd() {
		return fadd;
	}
	public void setFadd(String fadd) {
		this.fadd = fadd;
	}
	@Override
	public String toString() {
		return "Faculty [fid=" + fid + ", fname=" + fname + ", femail=" + femail + ", fpass=" + fpass + ", fadd=" + fadd
				+ "]";
	}


}
