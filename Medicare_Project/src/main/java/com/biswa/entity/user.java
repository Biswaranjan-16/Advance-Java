package com.biswa.entity;

public class user {
	private int uid;
private String uname;
private String uemail;
private String uphone;
private String upassword;
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getUemail() {
	return uemail;
}
public void setUemail(String uemail) {
	this.uemail = uemail;
}
public String getUphone() {
	return uphone;
}
public void setUphone(String uphone) {
	this.uphone = uphone;
}
public String getUpassword() {
	return upassword;
}
public void setUpassword(String upassword) {
	this.upassword = upassword;
}
@Override
public String toString() {
	return "user [uid=" + uid + ", uname=" + uname + ", uemail=" + uemail + ", uphone=" + uphone + ", upassword="
			+ upassword + "]";
}


}
