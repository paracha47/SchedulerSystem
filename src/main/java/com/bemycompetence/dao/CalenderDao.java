package com.bemycompetence.dao;

import java.util.List;

import com.bemycompetence.model.AcknowledgeCalender;
import com.bemycompetence.model.Calender;
import com.bemycompetence.model.SharedCalender;
import com.bemycompetence.model.User;

public interface CalenderDao {

	public boolean calenderDayTime(Calender cal);
	public boolean calenderDayTimeRemove(Calender cal);
	public List<Calender> getUserCalender(String userNumber);
	public List<User> getSharedUserList(String userid);
	public void shareYourCalender(List<Calender> calList, String senderNo);
	public boolean isUserAvailable(String userid);
	public List<Calender> getSharedUserCalender(String sharedUserId,String userid);
	public List<Calender> getCalenderData(List<Calender> calenderList);
	public boolean saveAcknowledge(AcknowledgeCalender acknowledgeCalender);
	public boolean ackCalenderRemove(AcknowledgeCalender acknowledgeCalender);
	public List<AcknowledgeCalender> getAckCalender(String userid);
}
