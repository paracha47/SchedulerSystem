package com.bemycompetence.model;

public class Calender {

	private int calId;
	private String userId;
	private String date;
	private String time;
	private String day;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
		
	public void setCalId(int calId) {
		this.calId = calId;
	}
	
	public int getCalId() {
		return calId;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "calId: "+calId+"| userid: "+userId+"| day: "+day;
	}
}
