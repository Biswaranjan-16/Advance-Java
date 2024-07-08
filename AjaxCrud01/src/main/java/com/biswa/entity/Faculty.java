package com.biswa.entity;

public class Faculty {
	private int fid;
	private String fName;
	private String fEmail;
	private String fPass;
	private String fAdd;
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getfEmail() {
		return fEmail;
	}
	public void setfEmail(String fEmail) {
		this.fEmail = fEmail;
	}
	public String getfPass() {
		return fPass;
	}
	public void setfPass(String fPass) {
		this.fPass = fPass;
	}
	public String getfAdd() {
		return fAdd;
	}
	public void setfAdd(String fAdd) {
		this.fAdd = fAdd;
	}
	@Override
	public String toString() {
		return "Faculty [fid=" + fid + ", fName=" + fName + ", fEmail=" + fEmail + ", fPass=" + fPass + ", fAdd=" + fAdd
				+ "]";
	}
	
	
}
