package com.y0.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.y0.model.UserModel;

public class RowMapperHelper implements RowMapper {

	@Override
	public Object mapRow(ResultSet set, int index) throws SQLException {
		UserModel user = new UserModel();
		user.setUserName(set.getString("username"));
		user.setPassword(set.getString("password"));
		user.setNickName(set.getString("nickname"));
		return user;
	}
}
