package com.bemycompetence.dao;

import java.util.List;

import com.bemycompetence.model.Calender;
import com.bemycompetence.model.User;

public interface UserDao {

	public boolean createAccount(User user);
	public boolean userLogin(User user);
	public User getUser(String user_id);
	public Calender getCalenderData(int no);
//	public List<Calender> getCalenderData2(List<Calender> calenderList);


}
