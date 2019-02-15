package com.bemycompetence.model;

public class Week {

	private String day;
	private String date;
	
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " week date : "+date+" day : "+day;
	}
	
}
