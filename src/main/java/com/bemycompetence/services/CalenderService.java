package com.bemycompetence.services;

import java.text.ParseException;
import java.util.List;

import com.bemycompetence.model.AcknowledgeCalender;
import com.bemycompetence.model.Calender;
import com.bemycompetence.model.SharedCalender;
import com.bemycompetence.model.User;
import com.bemycompetence.model.Week;

public interface CalenderService {

	public void calenderDayTime(String day, String time,String userid,String status);
	public List<Calender> getUserCalender(String userNumber);
	public List<User> getSharedUserList(String userid);
	public void shareYourCalender(List<Calender> calList, String senderNo);
	public boolean isUserAvailable(String userid);
	public List<Calender> getSharedUserCalender(String sharedUserId,String userid);
	public List<Calender> getCalenderData(List<Calender> calenderList);
	public void sendAcknowledgeData(String user_id, String sh_user_id, String date,  String time,
			String status);
	public List<AcknowledgeCalender> getAckCalender(String userid);
	

}
