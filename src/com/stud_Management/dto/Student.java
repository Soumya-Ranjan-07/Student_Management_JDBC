package com.stud_Management.dto;

public class Student {
	private int sid;
	private String sname;
	private float stmark;
	private String saddr;
	
	
	public float getStmark() {
		return stmark;
	}
	public void setStmark(float stmark) {
		this.stmark = stmark;
	}
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSaddr() {
		return saddr;
	}
	public void setSaddr(String saddr) {
		this.saddr = saddr;
	}
		
}
