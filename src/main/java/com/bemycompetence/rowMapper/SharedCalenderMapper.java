package com.bemycompetence.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bemycompetence.model.SharedCalender;

public class SharedCalenderMapper implements RowMapper<SharedCalender>{

	@Override
	public SharedCalender mapRow(ResultSet rs, int rowNum) throws SQLException {
	
		SharedCalender calender = new SharedCalender();
		calender.setSharedId(rs.getInt("shared_id"));
		calender.setUserPhoneId(rs.getString("user_id"));
		calender.setSharedUserId(rs.getString("sh_user_id"));
		calender.setCalId(rs.getInt("cal_id"));
		
		System.out.println(" shared calender obj :"+calender);
		return calender;
	}

}
