package com.we2.willwork;

import java.sql.*;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class WillWorkDAO2 {
	
	private static JdbcTemplate jdbcTemplate;
	
	public WillWorkDAO2(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<WillWorkVO> selectAll(){
		List<WillWorkVO> results = jdbcTemplate.query("select * from willwork", 
				new RowMapper<WillWorkVO>(){ //쿼리 실행결과를 자바 객체로 변환하는 RowMapper 인터페이스
				@Override
				public WillWorkVO mapRow(ResultSet rs, int rowNum) throws SQLException{
				WillWorkVO willWorkVO = new WillWorkVO(rs.getString("userId"),
						rs.getInt("pjtCode"),
						rs.getString("doWork"),
						rs.getString("doneWork"),
						rs.getString("stateWork"),
						rs.getString("name"));
				return willWorkVO; //WillWorkVO에 DB에서 조회한 내용을 저장
				}
			});
		
		//results를 반환
		return results;
	}
}
