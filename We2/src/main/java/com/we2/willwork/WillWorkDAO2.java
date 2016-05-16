package com.we2.willwork;

import java.sql.*;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class WillWorkDAO2 {
	
	private JdbcTemplate jdbcTemplate;
	
	public WillWorkDAO2(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<WillWork> selectAll(){
		
		public class WillWorkVORowMapper implements RowMapper<WillWorkVO>{
				@Override
				public WillWorkVO mapRow(ResultSet rs, int rowNum) throws SQLException{
				WillWorkVO willWorkVO = new WillWorkVO(rs.getString("userId"),
						rs.getInt("pjtCode"),
						rs.getString("doWork"),
						rs.getString("doneWork"),
						rs.getString("stateWork"),
						rs.getString("name"));
				return willWorkVO;
				}
			}
	
	}
}
