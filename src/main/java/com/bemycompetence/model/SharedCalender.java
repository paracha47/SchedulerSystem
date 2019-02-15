package com.bemycompetence.model;

public class SharedCalender {

	private int sharedId;
	private String userPhoneId;
	private String sharedUserId;
	private int calId;
	
	public int getSharedId() {
		return sharedId;
	}
	public void setSharedId(int sharedId) {
		this.sharedId = sharedId;
	}
	
	public int getCalId() {
		return calId;
	}
	public void setCalId(int calId) {
		this.calId = calId;
	}
	
	
	public String getUserPhoneId() {
		return userPhoneId;
	}
	public void setUserPhoneId(String userPhoneId) {
		this.userPhoneId = userPhoneId;
	}
	public String getSharedUserId() {
		return sharedUserId;
	}
	public void setSharedUserId(String sharedUserId) {
		this.sharedUserId = sharedUserId;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " shared id : "+sharedId+", userPhoneNo :"+userPhoneId+", sharedUserID"+sharedUserId+", calenderID "+calId;
	}
}
