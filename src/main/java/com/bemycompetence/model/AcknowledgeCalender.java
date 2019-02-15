package com.bemycompetence.model;

public class AcknowledgeCalender {

	private int ack_id;
	private String user_id;
	private String username;
	private String sh_user_id;
	private String day;
	private String date;
	private String time;
	
	public AcknowledgeCalender() {
		// TODO Auto-generated constructor stub
	}
	public AcknowledgeCalender( String user_id, String sh_user_id, String day, String date, String time) {
		this.user_id = user_id;
		this.sh_user_id = sh_user_id;
		this.day = day;
		this.date = date;
		this.time = time;
	}
	
	public int getAck_id() {
		return ack_id;
	}
	public void setAck_id(int ack_id) {
		this.ack_id = ack_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSh_user_id() {
		return sh_user_id;
	}
	public void setSh_user_id(String sh_user_id) {
		this.sh_user_id = sh_user_id;
	}
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "userid |"+user_id+" sh_user |"+sh_user_id+"day |"+day+" date |"+date+" time |"+time;
	}
}
