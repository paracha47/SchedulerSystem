package com.bemycompetence.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bemycompetence.model.AcknowledgeCalender;
import com.bemycompetence.model.Calender;
import com.bemycompetence.model.SharedCalender;
import com.bemycompetence.model.User;
import com.bemycompetence.rowMapper.CalenderMapper;
import com.bemycompetence.rowMapper.UserMapper;
import com.bemycompetence.services.CalenderUtils;

@Repository("CalenderDao")
public class CalenderDaoImpl implements CalenderDao{

	@Autowired
	private JdbcTemplate jdbctemplate;
	@Override
	
	public boolean calenderDayTime(Calender cal) {
		return  jdbctemplate.update
				(CalenderUtils.SQl_INSERT_CALENDER,cal.getUserId(),cal.getDate(),cal.getDay(),cal.getTime()) >0;
		
	}

	@Override
	public boolean calenderDayTimeRemove(Calender cal) {

		return jdbctemplate.update(CalenderUtils.SQl_REMOVE_CALENDER, cal.getUserId(),cal.getDate(),cal.getTime()) > 0;
		
	}

	@Override
	public List<Calender> getUserCalender(String userNumber) {
	

		String currentDate = CalenderUtils.getCurrentDate();
		return jdbctemplate.query(CalenderUtils.SQl_USER_CALENDER,new Object[] {userNumber,currentDate},new CalenderMapper());
	}

	@Override
	public List<User> getSharedUserList(String userNumber) {
		List<User> userList = new ArrayList<User>();
		System.out.println(" user no "+userNumber);
		List<SharedCalender> sharedPersonIdList =  jdbctemplate.query(CalenderUtils.SQl_SHARED_CALENDER, new Object[] {userNumber},new RowMapper<SharedCalender>() {
			@Override
			public SharedCalender mapRow(ResultSet rs, int rowNum) throws SQLException {
				SharedCalender calender = new SharedCalender();
				calender.setSharedUserId(rs.getString("user_id"));
				return calender;
			}
		} );
		System.out.println("shared id list : "+sharedPersonIdList.size()+" name is "+sharedPersonIdList);
		if(sharedPersonIdList.size() > 0) {

			for(SharedCalender sh: sharedPersonIdList) {
				System.out.println(" user id "+ sh.getSharedUserId());
				User u = jdbctemplate.queryForObject(CalenderUtils.SQl_SHARED_User,new Object[] {sh.getSharedUserId()},new UserMapper());
//				System.out.println(" users are "+u);
				userList.add(u);			
			
		}
	}
		return userList;
	}

	@Override
	public void shareYourCalender(List<Calender> calList, String senderNo) {
		for(Calender cal: calList) {
			boolean save =   jdbctemplate.update
					(CalenderUtils.SQl_INSERT_SHARED_CALENDER,cal.getUserId(),senderNo,cal.getCalId()) >0;
				System.out.println("bollean save "+save);	
		}
		
	}

	@Override
	public boolean isUserAvailable(String userid) {
		boolean result= jdbctemplate.queryForObject(CalenderUtils.SQl_Find_USER_NO, new Object[] {userid},Boolean.class);
		System.out.println("user available status "+result);
		return result;
	}

	@Override
	public List<Calender> getSharedUserCalender(String sharedUserId,String userid) {
		 System.out.println(" share or user : "+sharedUserId+" user id "+userid);
			
		List<Calender> calenderList = jdbctemplate.query(CalenderUtils.SQl_GET_SHARED_CALENDER,new Object[] {sharedUserId,userid},new RowMapper<Calender>(){
			 @Override
			public Calender mapRow(ResultSet rs, int rowNum) throws SQLException {
				Calender calender = new Calender();
				calender.setCalId(rs.getInt("cal_id"));				
				return calender;
			}
			
		});
		 System.out.println(" share list in Dao : "+calenderList.size()+" list data "+calenderList);
		return calenderList;
	}

	@Override
	public List<Calender> getCalenderData(List<Calender> calenderList) {

		List<Calender> calenderData = new ArrayList<Calender>();
		for(Calender cal : calenderList ) { 
			try {
				Calender calender = jdbctemplate.queryForObject(CalenderUtils.SQl_GET_CALENDER,new Object[] {cal.getCalId()},new CalenderMapper());
				calenderData.add(calender);
			} catch (EmptyResultDataAccessException e) {
				System.out.println(" Exception occur in get Calender data   : "+e.toString());
			
			}

		}
		return calenderData;
	
	}

	@Override
	public boolean saveAcknowledge(AcknowledgeCalender ack) {
		
		User user = jdbctemplate.queryForObject(CalenderUtils.SQl_GET_USER, new Object[] {ack.getUser_id()},new UserMapper());
		System.out.println(" acknowledge username : "+user.getName()+" userid "+ack.getUser_id());
				return  jdbctemplate.update
						(CalenderUtils.SQl_ACKNOWLEDGE_CALENDER,ack.getUser_id(),user.getName(),ack.getSh_user_id(),ack.getDay(),ack.getDate(),ack.getTime()) >0;
	}

	@Override
	public boolean ackCalenderRemove(AcknowledgeCalender ack) {
		return  jdbctemplate.update
				(CalenderUtils.SQl_ACK_REMOVE_CALENDER,ack.getUser_id(),ack.getSh_user_id(),ack.getDay(),ack.getDate(),ack.getTime()) >0;

	}

	@Override
	public List<AcknowledgeCalender> getAckCalender(String userid) {
		List<AcknowledgeCalender> list = new ArrayList<AcknowledgeCalender>();
		String currDAte = String.valueOf(LocalDate.now());
		System.out.println(" user id "+userid+" date "+currDAte);
		list = jdbctemplate.query(CalenderUtils.SQl_GET_ACK_CALENDER,new Object[] {userid,currDAte},new RowMapper<AcknowledgeCalender>() {

			@Override
			public AcknowledgeCalender mapRow(ResultSet rs, int rowNum) throws SQLException {
				AcknowledgeCalender cal = new AcknowledgeCalender();
				cal.setUser_id(rs.getString("user_id"));
				cal.setUsername(rs.getString("username"));
				cal.setSh_user_id(rs.getString("sh_user_id"));
				cal.setDay(rs.getString("day"));
				cal.setDate(rs.getString("date"));
				cal.setTime(rs.getString("time"));
				
				return cal;
			}});
		return list;
	}
	
	
}
