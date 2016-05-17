package com.we2.utils;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class ExcelDAO {

	private JdbcTemplate jdbcTemplate;
	public ExcelDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	} //MemberDao에 DataSource를 주입함!!
	
	public List<Object> getPjtMake(){
		return null;
	}
	public List<Object> getPjtManager(){
		return null;
	}
	public List<Object> getWillWork(){
		return null;
	}
	public List<Object> getNotify(){
		return null;
	}
	public List<Object> getSchedule(){
		return null;
	}
	public List<Object> getFileShare(){
		return null;
	}
}
