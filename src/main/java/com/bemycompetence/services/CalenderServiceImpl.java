package com.bemycompetence.services;


import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bemycompetence.dao.CalenderDao;
import com.bemycompetence.model.AcknowledgeCalender;
import com.bemycompetence.model.Calender;
import com.bemycompetence.model.SharedCalender;
import com.bemycompetence.model.User;
import com.bemycompetence.model.Week;

@Service("CalenderService")
public class CalenderServiceImpl implements CalenderService{


	
	@Autowired
	private CalenderDao calenderDao;
	
	@Override
	public void calenderDayTime(String d, String t,String u,String s) {

		try {
		Date date = CalenderUtils.dateFormat.parse(d);
		String day = CalenderUtils.dayformat.format(date);
		Calender cal = new Calender();
		cal.setUserId(u);
		cal.setDay(day);
		cal.setTime(t);
		cal.setDate(d);
		System.out.println(u+" day "+day+" t "+t+" date "+d);
		if(s.equals(CalenderUtils.STATUS)) {
			boolean save  = calenderDao.calenderDayTime(cal);
			System.out.println("calender data status save :"+save);
		}else {
		boolean remove = calenderDao.calenderDayTimeRemove(cal);	
		System.out.println("calender data status remove :"+remove);
		}
		}
		catch (Exception e) {
			System.out.println(" exception in calender dayTime "+e);
		}
		
	}

	@Override
	public List<Calender> getUserCalender(String userNumber) {
	
		List<Calender> userCalender = calenderDao.getUserCalender(userNumber);
		for(Calender cal: userCalender) {
			
			System.out.println("user calender userid : "+cal.getUserId()+" day "+cal.getDay()+" time "+cal.getTime());
			
		}
		return userCalender;
	}

	@Override
	public List<User> getSharedUserList(String userid) {
		List<User> sharedList = calenderDao.getSharedUserList(userid);
		return sharedList;
	}

	@Override
	public void shareYourCalender(List<Calender> calList, String senderNo) {
		
		calenderDao.shareYourCalender(calList,senderNo);

	}

	@Override
	public boolean isUserAvailable(String userid) {
		boolean available = calenderDao.isUserAvailable(userid);
		return available;
	}

	@Override
	public List<Calender> getSharedUserCalender(String sharedUserId,String userid) {
		List<Calender> calenderList = calenderDao.getSharedUserCalender(sharedUserId,userid);
		return calenderList;
	}

	@Override
	public List<Calender> getCalenderData(List<Calender> calenderList) {
		List<Calender> calenderData = calenderDao.getCalenderData(calenderList);

		return calenderData;
	}

	

	@Override
	public void sendAcknowledgeData(String userid, String sh_user_id, String date, String time,
			String status) {
		try {
		Date tempDate = CalenderUtils.dateFormat.parse(date);
		String day = CalenderUtils.dayformat.format(tempDate);
		AcknowledgeCalender acknowledgeCalender = new AcknowledgeCalender(userid, sh_user_id, day, date , time);
		if(CalenderUtils.STATUS.equals(status)) {

			boolean remove = calenderDao.ackCalenderRemove(acknowledgeCalender);	
			System.out.println("ack nowledge :"+remove);
//				
		
		}else {
				System.out.println(" status is false if condition");
				boolean save = calenderDao.saveAcknowledge(acknowledgeCalender);
				System.out.println(" acknowledge save status"+ save);
		}
		}catch (Exception e) {
			System.out.println(" Exception in sendAcknowledgeData"+e);
			
		}
	}

	@Override
	public List<AcknowledgeCalender> getAckCalender(String userid) {
		List<AcknowledgeCalender> ackList = calenderDao.getAckCalender(userid);
		return ackList;
	}



}
