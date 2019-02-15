package com.bemycompetence.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.bemycompetence.model.Week;

public class CalenderUtils {

	/*  User DB Queries */
	public static final String SQl_CREATE_USER = "insert into User(name,email,phone_no,password) values(?,?,?,?)";
	public static final String SQl_GET_USER = "Select * from user where phone_no = ?";
	public static final String SQl_Find_USER_NO = "Select count(*) from user where phone_no = ?";
	public static final String SQl_User_Validation = "Select count(*) from user where phone_no = ? and password = ?";

	/*  Calendar DB Queries */
	public static final String SQl_CALANDER = "select * from calender where cal_id = ?";
	public static final String SQl_INSERT_CALENDER = "insert into calender(user_id,date,day,time) values(?,?,?,?)";
	public static final String SQl_ACKNOWLEDGE_CALENDER = "insert into acknowledgecalender(user_id,username,sh_user_id,day,date,time) values(?,?,?,?,?,?)";
	public static final String SQl_GET_ACK_CALENDER = "SELECT * FROM `acknowledgecalender` WHERE sh_user_id = ? and date >= ?"; 
	public static final String SQl_INSERT_SHARED_CALENDER = "insert into sharedcalender(user_id,sh_user_id,cal_id) values(?,?,?)";
	public static final String SQl_REMOVE_CALENDER = "	delete from calender where user_id = ? and date = ? and time = ? "; 
	public static final String SQl_ACK_REMOVE_CALENDER = "	delete from acknowledgecalender where user_id = ? and sh_user_id = ? and day = ? and date = ? and time = ?"; 
	public static final String SQl_USER_CALENDER = "select * from calender where user_id = ? and date >= ?"; 
	public static final String SQl_GET_CALENDER = "select * from calender where cal_id = ?"; 
	public static final String SQl_GET_SHARED_CALENDER = "select cal_id from sharedcalender where user_id = ? and sh_user_id = ?"; 
	public static final String SQl_SHARED_CALENDER = "select distinct(user_id) from sharedcalender where sh_user_id = ? "; 
	public static final String SQl_SHARED_User = "select * from user where phone_no = ? "; 

	/* Constants */
	public static final String STATUS = "busy";
	public static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	public static final DateFormat dayformat=new SimpleDateFormat("EEEE"); 

	public static String getCurrentDate() {
		String currDate = String.valueOf(LocalDate.now());
		return currDate;
	}
	
	public static List<Week> getWeekDate() {
		
		ArrayList<Week> weekDate = new ArrayList<Week>();
		for(int i = 0; i<7; i++) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			String currentdate = String.valueOf(LocalDate.now());
			c.setTime( dateFormat.parse(currentdate));
			c.add(Calendar.DATE, i);
			String tommorow = dateFormat.format(c.getTime());
			String day = CalenderUtils.dayformat.format(c.getTime());
			Week w = new Week();
			w.setDate(tommorow);
			w.setDay(day);
			weekDate.add(w);
			
				  } catch (ParseException e) {
			e.printStackTrace();
		}
		}
		return weekDate;

		
		
	}
}
