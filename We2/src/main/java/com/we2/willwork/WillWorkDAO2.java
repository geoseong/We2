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
				new RowMapper<WillWorkVO>(){ //���� �������� �ڹ� ��ü�� ��ȯ�ϴ� RowMapper �������̽�
				@Override
				public WillWorkVO mapRow(ResultSet rs, int rowNum) throws SQLException{
				WillWorkVO willWorkVO = new WillWorkVO(rs.getString("userId"),
						rs.getInt("pjtCode"),
						rs.getString("doWork"),
						rs.getString("doneWork"),
						rs.getString("stateWork"),
						rs.getString("name"));
				return willWorkVO; //WillWorkVO�� DB���� ��ȸ�� ������ ����
				}
			});
		
		//results�� ��ȯ
		return results;
	}
}
