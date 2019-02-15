package com.bemycompetence.dao;


import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import com.bemycompetence.model.Calender;
import com.bemycompetence.model.User;
import com.bemycompetence.rowMapper.CalenderMapper;
import com.bemycompetence.rowMapper.UserMapper;
import com.bemycompetence.services.CalenderUtils;


public class UserDaoImpl implements UserDao{

	
	private JdbcTemplate jdbctemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbctemplate = jdbcTemplate;  
	}  
	@Override
	public boolean createAccount(User user) {
		
		boolean isUserAvialable = jdbctemplate.queryForObject(CalenderUtils.SQl_Find_USER_NO, new Object[] {user.getPhoneNo()},Boolean.class);
		System.out.println(" is User Available : "+isUserAvialable);
		if(!isUserAvialable)
		{
		jdbctemplate.update(CalenderUtils.SQl_CREATE_USER,user.getName(),user.getEmail(),
								user.getPhoneNo(),user.getPassword()) ;
	
		return isUserAvialable;
		}
		return isUserAvialable;
	}
	@Override
	public boolean userLogin(User user) {
		boolean isUserValidate = jdbctemplate.queryForObject(CalenderUtils.SQl_User_Validation, new Object[] {user.getPhoneNo(),user.getPassword()},Boolean.class);
		System.out.println(" is User Available : "+isUserValidate);
		
		return isUserValidate;
	}
	@Override
	public Calender getCalenderData(int calid) {
//		String sql = "select * from calender where cal_id = ?";
		Calender calender = jdbctemplate.queryForObject(CalenderUtils.SQl_CALANDER,new Object[] {calid},new CalenderMapper());
			
		return calender;
	}
	

	
	@Override
	public User getUser(String user_id) {
//		System.out.println(" user no in get user : "+user_id);
		User user = jdbctemplate.queryForObject(CalenderUtils.SQl_GET_USER, new Object[] {user_id},new UserMapper());
		return user;
	}
	

	/*
	@Override
	public List<Calender> getCalenderData2(List<Calender> calenderList) {
		String sql = "select * from calender where cal_id = ?";
		List<Calender> calList = new ArrayList<Calender>();
		

		for(Calender cal :calenderList) {
			System.out.println(" cal id "+cal.getCalId());
			Calender calender = jdbctemplate.queryForObject(sql,new Object[] {cal.getCalId()},new CalenderMapper());
			calList.add(calender);
		}
		
		System.out.println("cal list size :"+calList.size());
		
		return calList;
	}
	
	*/
}
