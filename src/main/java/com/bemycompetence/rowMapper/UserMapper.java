package com.bemycompetence.rowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bemycompetence.model.User;

public class UserMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {

		User user = new User();
		user.setId(rs.getInt("user_id"));
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		user.setPhoneNo(rs.getString("phone_no"));
		user.setPassword(rs.getString("password"));
		
		System.out.println(" user data : "+user);
		return user;
	}

}
