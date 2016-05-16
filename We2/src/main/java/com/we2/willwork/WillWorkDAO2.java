package com.we2.willwork;

import java.sql.*;
import java.text.ParseException;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import com.we2.pjtMake.PjtMakeVO;

public class WillWorkDAO2 {
	
	private static JdbcTemplate jdbcTemplate;
	
	public WillWorkDAO2(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public WillWorkDAO2(){
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
	
	public void insertWillWork(final String name, final String doWork) throws ParseException{
		 	
	        jdbcTemplate.update(new PreparedStatementCreator() {
	            @Override
	            public PreparedStatement createPreparedStatement(Connection con) 
	                    throws SQLException {
	                // �Ķ���ͷ� ���޹��� Connection�� �̿��ؼ� PreparedStatement ����
	                PreparedStatement pstmt = con.prepareStatement(
	                	"update willwork set dowork = dowork || ', ' || ? where name=?"
                      );
	                // �ε��� �Ķ���� �� ����
	                pstmt.setString(1, doWork);
	                pstmt.setString(2, name);
	                // ������ PreparedStatement ��ü ����
	                return pstmt;
	            } //end createPreparedStatement()
	        });
	}
}
