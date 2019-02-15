package com.bemycompetence.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.jdbc.core.RowMapper;

import com.bemycompetence.model.Calender;

public class CalenderMapper implements RowMapper<Calender>{

	@Override
	public Calender mapRow(ResultSet rs, int rowNum) throws SQLException {
		Calender cal = new Calender();
		cal.setCalId(rs.getInt("cal_id"));
		cal.setUserId(rs.getString("user_id"));
		cal.setDay(rs.getString("day"));
		cal.setTime(rs.getString("time"));
		cal.setDate(rs.getString("date"));
		return cal;
	}

}
